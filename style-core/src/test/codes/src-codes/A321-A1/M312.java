    private Observable<R> handleRequestCacheHitAndEmitValues(final HystrixCommandResponseFromCache<R> fromCache, final AbstractCommand<R> _cmd) {
        try {
            executionHook.onCacheHit(this);
        } catch (Throwable hookEx) {
            logger.warn("Error calling HystrixCommandExecutionHook.onCacheHit", hookEx);
        }

        return fromCache.toObservableWithStateCopiedInto(this)
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        if (commandState.compareAndSet(CommandState.OBSERVABLE_CHAIN_CREATED, CommandState.TERMINAL)) {
                            cleanUpAfterResponseFromCache(false); //user code never ran
                        } else if (commandState.compareAndSet(CommandState.USER_CODE_EXECUTED, CommandState.TERMINAL)) {
                            cleanUpAfterResponseFromCache(true); //user code did run
                        }
                    }
                })
                .doOnUnsubscribe(new Action0() {
                    @Override
                    public void call() {
                        if (commandState.compareAndSet(CommandState.OBSERVABLE_CHAIN_CREATED, CommandState.UNSUBSCRIBED)) {
                            cleanUpAfterResponseFromCache(false); //user code never ran
                        } else if (commandState.compareAndSet(CommandState.USER_CODE_EXECUTED, CommandState.UNSUBSCRIBED)) {
                            cleanUpAfterResponseFromCache(true); //user code did run
                        }
                    }
                });
    }
