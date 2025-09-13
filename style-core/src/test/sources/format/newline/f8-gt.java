private void doPostprocessing() {

	errCode = ERROR_NOTHING;

	errObject = null;
	Thread thread = Thread.currentThread();
	notifyPostProcessing(1);
	if (DEBUG) {

		thread.setName("[" + TAG + "]  ps = " + psAlgorithm + "  filename = " + storage.getName());

	}

	Exception exception = null;

	try {

		psAlgorithm.run(this);

	} catch (Exception err) {

		Log.e(TAG, "Post-processing failed. " + psAlgorithm.toString(), err);
		if (err instanceof InterruptedIOException || err instanceof ClosedByInterruptException) {

			notifyError(DownloadMission.ERROR_POSTPROCESSING_STOPPED, null);
			return;

		}

		if (thread.isInterrupted()) {

			notifyError(DownloadMission.ERROR_POSTPROCESSING_STOPPED, null);
			return;

		}

		if (errCode == ERROR_NOTHING) {

			errCode = ERROR_POSTPROCESSING;

		}

		exception = err;

	} finally {

		notifyPostProcessing(errCode == ERROR_NOTHING ? 2 : 0);

	}

	if (errCode != ERROR_NOTHING) {

		if (exception == null) {

			exception = errObject;

		}

		notifyError(ERROR_POSTPROCESSING, exception);
		return;

	}

	notifyFinished();

}
