    private ApiResponse processAsyncExecRequest(ApiRequest apiRequest, Session session) {
        String commandLine = apiRequest.getCommand();
        Map<String, Object> body = new TreeMap<String, Object>();
        body.put("command", commandLine);

        ApiResponse response = new ApiResponse();
        response.setSessionId(session.getSessionId())
                .setBody(body);

        if (!session.tryLock()) {
            response.setState(ApiState.REFUSED)
                    .setMessage("Another command is executing.");
            return response;
        }
        int lock = session.getLock();
        try {

            Job foregroundJob = session.getForegroundJob();
            if (foregroundJob != null) {
                response.setState(ApiState.REFUSED)
                        .setMessage("Another job is running.");
                logger.info("Another job is running, jobId: {}", foregroundJob.id());
                return response;
            }

            //create job
            Job job = this.createJob(commandLine, session, session.getResultDistributor());
            body.put("jobId", job.id());
            body.put("jobStatus", job.status());
            response.setState(ApiState.SCHEDULED);

            //add command before exec job
            CommandRequestModel commandRequestModel = new CommandRequestModel(commandLine, response.getState());
            commandRequestModel.setJobId(job.id());
            SharingResultDistributor resultDistributor = session.getResultDistributor();
            if (resultDistributor != null) {
                resultDistributor.appendResult(commandRequestModel);
            }
            session.setForegroundJob(job);
            updateSessionInputStatus(session, InputStatus.ALLOW_INTERRUPT);

            //run job
            job.run();

            return response;
        } catch (Throwable e) {
            logger.error("Async exec command failed:" + e.getMessage() + ", command:" + commandLine, e);
            response.setState(ApiState.FAILED).setMessage("Async exec command failed:" + e.getMessage());
            CommandRequestModel commandRequestModel = new CommandRequestModel(commandLine, response.getState(), response.getMessage());
            session.getResultDistributor().appendResult(commandRequestModel);
            return response;
        } finally {
            if (session.getLock() == lock) {
                session.unLock();
            }
        }
    }
