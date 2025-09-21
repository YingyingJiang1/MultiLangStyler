
private void executeJob(QueuedJob job) {
    if (job.cancelled) {
        log.debug("Job {} was cancelled, not executing", job.jobId);
        return;
    }

    Runnable task = new Runnable() {
        @Override
        public void run() {
            log.debug("Executing queued job {} (queued at {})", job.jobId, job.queuedAt);
            try {
                // execute with timeout
                Object result = executeWithTimeout(job.work, job.timeoutMs);

                // process result
                if (result instanceof ResponseEntity) {
                    job.future.complete((ResponseEntity<?>) result);
                } else {
                    job.future.complete(ResponseEntity.ok(result));
                }
            } catch (Exception e) {
                log.error("Error executing queued job {}: {}", job.jobId, e.getMessage(), e);
                job.future.completeExceptionally(e);
            }
        }
    };

    jobExecutor.execute(task);
}
