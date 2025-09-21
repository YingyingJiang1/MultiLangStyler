
private void executeJob(QueuedJob job) {
    if (job.cancelled) {
        log.debug("Job {} was cancelled, not executing", job.jobId);
        return;
    }

    jobExecutor.execute(() -> {
        log.debug("Executing queued job {} (queued at {})", job.jobId, job.queuedAt);
        try {
            Object result = executeWithTimeout(job.work, job.timeoutMs);
            job.future.complete(
                result instanceof ResponseEntity 
                    ? (ResponseEntity<?>) result 
                    : ResponseEntity.ok(result)
            );
        } catch (Exception e) {
            log.error("Error executing queued job {}: {}", job.jobId, e.getMessage(), e);
            job.future.completeExceptionally(e);
        }
    });
}
