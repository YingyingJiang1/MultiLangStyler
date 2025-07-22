    public synchronized void notifyError(int code, Exception err) {
        Log.e(TAG, "notifyError() code = " + code, err);
        if (err != null && err.getCause() instanceof ErrnoException) {
            int errno = ((ErrnoException) err.getCause()).errno;
            if (errno == OsConstants.ENOSPC) {
                code = ERROR_INSUFFICIENT_STORAGE;
                err = null;
            } else if (errno == OsConstants.EACCES) {
                code = ERROR_PERMISSION_DENIED;
                err = null;
            }
        }

        if (err instanceof IOException) {
            if (err.getMessage().contains("Permission denied")) {
                code = ERROR_PERMISSION_DENIED;
                err = null;
            } else if (err.getMessage().contains("ENOSPC")) {
                code = ERROR_INSUFFICIENT_STORAGE;
                err = null;
            } else if (!storage.canWrite()) {
                code = ERROR_FILE_CREATION;
                err = null;
            }
        }

        errCode = code;
        errObject = err;

        switch (code) {
            case ERROR_SSL_EXCEPTION:
            case ERROR_UNKNOWN_HOST:
            case ERROR_CONNECT_HOST:
            case ERROR_TIMEOUT:
                // do not change the queue flag for network errors, can be
                // recovered silently without the user interaction
                break;
            default:
                // also checks for server errors
                if (code < 500 || code > 599) enqueued = false;
        }

        notify(DownloadManagerService.MESSAGE_ERROR);

        if (running) pauseThreads();
    }
