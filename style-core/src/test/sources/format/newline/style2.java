class Main {
// M128
    @Bean(name = "machineType")
    public String determineMachineType() {
        try {
            boolean isDocker = runningInDocker();
            boolean isKubernetes = System.getenv("KUBERNETES_SERVICE_HOST") != null;
            boolean isBrowserOpen = "true".equalsIgnoreCase(env.getProperty("BROWSER_OPEN"));

            if (isKubernetes) {
                return "Kubernetes";
            } else if (isDocker) {
                return "Docker";
            } else if (isBrowserOpen) {
                String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
                if (os.contains("win")) {
                    return "Client-windows";
                } else if (os.contains("mac")) {
                    return "Client-mac";
                } else {
                    return "Client-unix";
                }
            } else {
                return "Server-jar";
            }
        } catch (Exception e) {
            return "Unknown";
        }
    }


// M176
    private void processQueue() {
        // Jobs to execute after releasing the lock
        java.util.List<QueuedJob> jobsToExecute = new java.util.ArrayList<>();

        // First synchronized block: poll jobs from the queue and prepare them for execution
        synchronized (queueLock) {
            if (shuttingDown || jobQueue.isEmpty()) {
                return;
            }

            try {
                // Get current resource status
                ResourceMonitor.ResourceStatus status = resourceMonitor.getCurrentStatus().get();

                // Check if we should execute any jobs
                boolean canExecuteJobs = (status != ResourceMonitor.ResourceStatus.CRITICAL);

                if (!canExecuteJobs) {
                    // Under critical load, don't execute any jobs
                    log.debug("System under critical load, delaying job execution");
                    return;
                }

                // Get jobs from the queue, up to a limit based on resource availability
                int jobsToProcess =
                        Math.max(
                                1,
                                switch (status) {
                                    case OK -> 3;
                                    case WARNING -> 1;
                                    case CRITICAL -> 0;
                                });

                for (int i = 0; i < jobsToProcess && !jobQueue.isEmpty(); i++) {
                    QueuedJob job = jobQueue.poll();
                    if (job == null) break;

                    // Check if it's been waiting too long
                    long waitTimeMs = Instant.now().toEpochMilli() - job.queuedAt.toEpochMilli();
                    if (waitTimeMs > maxWaitTimeMs) {
                        log.warn(
                                "Job {} exceeded maximum wait time ({} ms), executing anyway",
                                job.jobId,
                                waitTimeMs);

                        // Add a specific status to the job context that can be tracked
                        // This will be visible in the job status API
                        try {
                            TaskManager taskManager =
                                    SpringContextHolder.getBean(TaskManager.class);
                            if (taskManager != null) {
                                taskManager.addNote(
                                        job.jobId,
                                        "QUEUED_TIMEOUT: Job waited in queue for "
                                                + (waitTimeMs / 1000)
                                                + " seconds, exceeding the maximum wait time of "
                                                + (maxWaitTimeMs / 1000)
                                                + " seconds.");
                            }
                        } catch (Exception e) {
                            log.error(
                                    "Failed to add timeout note to job {}: {}",
                                    job.jobId,
                                    e.getMessage());
                        }
                    }

                    // Remove from our map
                    jobMap.remove(job.jobId);
                    currentQueueSize = jobQueue.size();

                    // Add to the list of jobs to execute outside the synchronized block
                    jobsToExecute.add(job);
                }
            } catch (Exception e) {
                log.error("Error processing job queue: {}", e.getMessage(), e);
            }
        }

        // Now execute the jobs outside the synchronized block to avoid holding the lock
        for (QueuedJob job : jobsToExecute) {
            executeJob(job);
        }
    }


// M542
    @PostMapping(consumes = "multipart/form-data", value = "/compress-pdf")
    @Operation(
            summary = "Optimize PDF file",
            description =
                    "This endpoint accepts a PDF file and optimizes it based on the provided"
                            + " parameters. Input:PDF Output:PDF Type:SISO")
    public ResponseEntity<byte[]> optimizePdf(@ModelAttribute OptimizePdfRequest request)
            throws Exception {
        MultipartFile inputFile = request.getFileInput();
        Integer optimizeLevel = request.getOptimizeLevel();
        String expectedOutputSizeString = request.getExpectedOutputSize();
        Boolean convertToGrayscale = request.getGrayscale();
        if (expectedOutputSizeString == null && optimizeLevel == null) {
            throw new Exception("Both expected output size and optimize level are not specified");
        }

        Long expectedOutputSize = 0L;
        boolean autoMode = false;
        if (expectedOutputSizeString != null && expectedOutputSizeString.length() > 1) {
            expectedOutputSize = GeneralUtils.convertSizeToBytes(expectedOutputSizeString);
            autoMode = true;
        }

        // Create initial input file
        Path originalFile = Files.createTempFile("original_", ".pdf");
        inputFile.transferTo(originalFile.toFile());
        long inputFileSize = Files.size(originalFile);

        Path currentFile = Files.createTempFile("working_", ".pdf");
        Files.copy(originalFile, currentFile, StandardCopyOption.REPLACE_EXISTING);

        // Keep track of all temporary files for cleanup
        List<Path> tempFiles = new ArrayList<>();
        tempFiles.add(originalFile);
        tempFiles.add(currentFile);
        try {
            if (autoMode) {
                double sizeReductionRatio = expectedOutputSize / (double) inputFileSize;
                optimizeLevel = determineOptimizeLevel(sizeReductionRatio);
            }

            boolean sizeMet = false;
            boolean imageCompressionApplied = false;
            boolean externalCompressionApplied = false;

            while (!sizeMet && optimizeLevel <= 9) {
                // Apply external compression first
                if (!externalCompressionApplied) {
                    boolean ghostscriptSuccess = false;

                    // Try Ghostscript first if available - for ANY compression level
                    if (isGhostscriptEnabled()) {
                        try {
                            applyGhostscriptCompression(
                                    request, optimizeLevel, currentFile, tempFiles);
                            log.info("Ghostscript compression applied successfully");
                            ghostscriptSuccess = true;
                        } catch (IOException e) {
                            log.warn("Ghostscript compression failed, trying fallback methods");
                        }
                    }

                    // Fallback to QPDF if Ghostscript failed or not available (levels 1-3 only)
                    if (!ghostscriptSuccess && isQpdfEnabled() && optimizeLevel <= 3) {
                        try {
                            applyQpdfCompression(request, optimizeLevel, currentFile, tempFiles);
                            log.info("QPDF compression applied successfully");
                        } catch (IOException e) {
                            log.warn("QPDF compression also failed");
                        }
                    }

                    if (!ghostscriptSuccess && !isQpdfEnabled()) {
                        log.info(
                                "No external compression tools available, using image compression only");
                    }

                    externalCompressionApplied = true;

                    // Skip image compression if Ghostscript succeeded
                    if (ghostscriptSuccess) {
                        imageCompressionApplied = true;
                    }
                }

                // Apply image compression for levels 4+ only if Ghostscript didn't run
                if ((optimizeLevel >= 4 || Boolean.TRUE.equals(convertToGrayscale))
                        && !imageCompressionApplied) {
                    // Use different scale factors based on level
                    double scaleFactor =
                            switch (optimizeLevel) {
                                case 4 -> 0.95; // 95% of original size
                                case 5 -> 0.9; // 90% of original size
                                case 6 -> 0.8; // 80% of original size
                                case 7 -> 0.7; // 70% of original size
                                case 8 -> 0.65; // 65% of original size
                                case 9 -> 0.5; // 50% of original size
                                default -> 1.0;
                            };

                    log.info("Applying image compression with scale factor: {}", scaleFactor);
                    Path compressedImageFile =
                            compressImagesInPDF(
                                    currentFile,
                                    scaleFactor,
                                    0.7f, // Default JPEG quality
                                    Boolean.TRUE.equals(convertToGrayscale));

                    tempFiles.add(compressedImageFile);
                    currentFile = compressedImageFile;
                    imageCompressionApplied = true;
                }

                // Check if target size reached or not in auto mode
                long outputFileSize = Files.size(currentFile);
                if (outputFileSize <= expectedOutputSize || !autoMode) {
                    sizeMet = true;
                } else {
                    int newOptimizeLevel =
                            incrementOptimizeLevel(
                                    optimizeLevel, outputFileSize, expectedOutputSize);

                    // Check if we can't increase the level further
                    if (newOptimizeLevel == optimizeLevel) {
                        if (autoMode) {
                            log.info(
                                    "Maximum optimization level reached without meeting target size.");
                            sizeMet = true;
                        }
                    } else {
                        // Reset flags for next iteration with higher optimization level
                        imageCompressionApplied = false;
                        externalCompressionApplied = false;
                        optimizeLevel = newOptimizeLevel;
                    }
                }
            }

            // Use original if optimized file is somehow larger
            long finalFileSize = Files.size(currentFile);
            if (finalFileSize >= inputFileSize) {
                log.warn(
                        "Optimized file is larger than the original. Using the original file instead.");
                currentFile = originalFile;
            }

            String outputFilename =
                    Filenames.toSimpleFileName(inputFile.getOriginalFilename())
                                    .replaceFirst("[.][^.]+$", "")
                            + "_Optimized.pdf";

            return WebResponseUtils.pdfDocToWebResponse(
                    pdfDocumentFactory.load(currentFile.toFile()), outputFilename);

        } finally {
            // Clean up all temporary files
            for (Path tempFile : tempFiles) {
                try {
                    Files.deleteIfExists(tempFile);
                } catch (IOException e) {
                    log.warn("Failed to delete temporary file: " + tempFile, e);
                }
            }
        }
    }
}

