                @Override
                public Observable<R> call() {
                    executionResult = executionResult.setExecutionOccurred();
                    if (!commandState.compareAndSet(CommandState.OBSERVABLE_CHAIN_CREATED, CommandState.USER_CODE_EXECUTED)) {
                        return Observable.error(new IllegalStateException("execution attempted while in state : " + commandState.get().name()));
                    }

                    metrics.markCommandStart(commandKey, threadPoolKey, ExecutionIsolationStrategy.THREAD);

                    if (isCommandTimedOut.get() == TimedOutStatus.TIMED_OUT) {
                        // the command timed out in the wrapping thread so we will return immediately
                        // and not increment any of the counters below or other such logic
                        return Observable.error(new RuntimeException("timed out before executing run()"));
                    }
                    if (threadState.compareAndSet(ThreadState.NOT_USING_THREAD, ThreadState.STARTED)) {
                        //we have not been unsubscribed, so should proceed
                        HystrixCounters.incrementGlobalConcurrentThreads();
                        threadPool.markThreadExecution();
                        // store the command that is being run
                        endCurrentThreadExecutingCommand = Hystrix.startCurrentThreadExecutingCommand(getCommandKey());
                        executionResult = executionResult.setExecutedInThread();
                        /**
                         * If any of these hooks throw an exception, then it appears as if the actual execution threw an error
                         */
                        try {
                            executionHook.onThreadStart(_cmd);
                            executionHook.onRunStart(_cmd);
                            executionHook.onExecutionStart(_cmd);
                            return getUserExecutionObservable(_cmd);
                        } catch (Throwable ex) {
                            return Observable.error(ex);
                        }
                    } else {
                        //command has already been unsubscribed, so return immediately
                        return Observable.empty();
                    }
                }
