    private void checkAndRefreshExplorer() {
        if (!IS_WINDOWS) {
            return;
        }
        if (timeAt90Percent == -1) {
            timeAt90Percent = System.currentTimeMillis();
            stuckTimer =
                    new Timer(
                            1000,
                            e -> {
                                long currentTime = System.currentTimeMillis();
                                if (currentTime - timeAt90Percent > stuckThreshold) {
                                    try {
                                        log.debug(
                                                "Attempting Windows explorer refresh due to 90% stuck state");
                                        String currentDir = System.getProperty("user.dir");

                                        // Store current explorer PIDs before we start new one
                                        Set<String> existingPids = new HashSet<>();
                                        ProcessBuilder listExplorer =
                                                new ProcessBuilder(
                                                        "cmd",
                                                        "/c",
                                                        "wmic",
                                                        "process",
                                                        "where",
                                                        "name='explorer.exe'",
                                                        "get",
                                                        "ProcessId",
                                                        "/format:csv");
                                        Process process = listExplorer.start();
                                        BufferedReader reader =
                                                new BufferedReader(
                                                        new InputStreamReader(
                                                                process.getInputStream()));
                                        String line;
                                        while ((line =
                                                        BoundedLineReader.readLine(
                                                                reader, 5_000_000))
                                                != null) {
                                            if (line.matches(".*\\d+.*")) { // Contains numbers
                                                String[] parts = line.trim().split(",");
                                                if (parts.length >= 2) {
                                                    existingPids.add(
                                                            parts[parts.length - 1].trim());
                                                }
                                            }
                                        }
                                        process.waitFor(2, TimeUnit.SECONDS);

                                        // Start new explorer
                                        ProcessBuilder pb =
                                                new ProcessBuilder(
                                                        "cmd",
                                                        "/c",
                                                        "start",
                                                        "/min",
                                                        "/b",
                                                        "explorer.exe",
                                                        currentDir);
                                        pb.redirectErrorStream(true);
                                        explorerProcess = pb.start();

                                        // Schedule cleanup
                                        Timer cleanupTimer =
                                                new Timer(
                                                        2000,
                                                        cleanup -> {
                                                            try {
                                                                // Find new explorer processes
                                                                ProcessBuilder findNewExplorer =
                                                                        new ProcessBuilder(
                                                                                "cmd",
                                                                                "/c",
                                                                                "wmic",
                                                                                "process",
                                                                                "where",
                                                                                "name='explorer.exe'",
                                                                                "get",
                                                                                "ProcessId",
                                                                                "/format:csv");
                                                                Process newProcess =
                                                                        findNewExplorer.start();
                                                                BufferedReader newReader =
                                                                        new BufferedReader(
                                                                                new InputStreamReader(
                                                                                        newProcess
                                                                                                .getInputStream()));
                                                                String newLine;
                                                                while ((newLine =
                                                                                BoundedLineReader
                                                                                        .readLine(
                                                                                                newReader,
                                                                                                5_000_000))
                                                                        != null) {
                                                                    if (newLine.matches(
                                                                            ".*\\d+.*")) {
                                                                        String[] parts =
                                                                                newLine.trim()
                                                                                        .split(",");
                                                                        if (parts.length >= 2) {
                                                                            String pid =
                                                                                    parts[
                                                                                            parts.length
                                                                                                    - 1]
                                                                                            .trim();
                                                                            if (!existingPids
                                                                                    .contains(
                                                                                            pid)) {
                                                                                log.debug(
                                                                                        "Found new explorer.exe with PID: "
                                                                                                + pid);
                                                                                ProcessBuilder
                                                                                        killProcess =
                                                                                                new ProcessBuilder(
                                                                                                        "taskkill",
                                                                                                        "/PID",
                                                                                                        pid,
                                                                                                        "/F");
                                                                                killProcess
                                                                                        .redirectErrorStream(
                                                                                                true);
                                                                                Process killResult =
                                                                                        killProcess
                                                                                                .start();
                                                                                killResult.waitFor(
                                                                                        2,
                                                                                        TimeUnit
                                                                                                .SECONDS);
                                                                                log.debug(
                                                                                        "Explorer process terminated: "
                                                                                                + pid);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                newProcess.waitFor(
                                                                        2, TimeUnit.SECONDS);
                                                            } catch (Exception ex) {
                                                                log.error(
                                                                        "Error cleaning up Windows explorer process",
                                                                        ex);
                                                            }
                                                        });
                                        cleanupTimer.setRepeats(false);
                                        cleanupTimer.start();
                                        stuckTimer.stop();
                                    } catch (Exception ex) {
                                        log.error("Error refreshing Windows explorer", ex);
                                    }
                                }
                            });
            stuckTimer.setRepeats(true);
            stuckTimer.start();
        }
    }
