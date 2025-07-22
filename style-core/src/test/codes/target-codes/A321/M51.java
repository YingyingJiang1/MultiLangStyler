    public void startMetricsMonitor(final boolean shouldLog) {
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    /**
                     * Since this is a simple example and we know the exact HystrixCommandKeys we are interested in
                     * we will retrieve the HystrixCommandMetrics objects directly.
                     *
                     * Typically you would instead retrieve metrics from where they are published which is by default
                     * done using Servo: https://github.com/Netflix/Hystrix/wiki/Metrics-and-Monitoring
                     */

                    // wait 5 seconds on each loop
                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        // ignore
                    }

                    // we are using default names so can use class.getSimpleName() to derive the keys
                    HystrixCommandMetrics creditCardMetrics = HystrixCommandMetrics.getInstance(HystrixCommandKey.Factory.asKey(CreditCardCommand.class.getSimpleName()));
                    HystrixCommandMetrics orderMetrics = HystrixCommandMetrics.getInstance(HystrixCommandKey.Factory.asKey(GetOrderCommand.class.getSimpleName()));
                    HystrixCommandMetrics userAccountMetrics = HystrixCommandMetrics.getInstance(HystrixCommandKey.Factory.asKey(GetUserAccountCommand.class.getSimpleName()));
                    HystrixCommandMetrics paymentInformationMetrics = HystrixCommandMetrics.getInstance(HystrixCommandKey.Factory.asKey(GetPaymentInformationCommand.class.getSimpleName()));

                    if (shouldLog) {
                        // print out metrics
                        StringBuilder out = new StringBuilder();
                        out.append("\n");
                        out.append("#####################################################################################").append("\n");
                        out.append("# CreditCardCommand: " + getStatsStringFromMetrics(creditCardMetrics)).append("\n");
                        out.append("# GetOrderCommand: " + getStatsStringFromMetrics(orderMetrics)).append("\n");
                        out.append("# GetUserAccountCommand: " + getStatsStringFromMetrics(userAccountMetrics)).append("\n");
                        out.append("# GetPaymentInformationCommand: " + getStatsStringFromMetrics(paymentInformationMetrics)).append("\n");
                        out.append("#####################################################################################").append("\n");
                        System.out.println(out.toString());
                    }
                }
            }

            private String getStatsStringFromMetrics(HystrixCommandMetrics metrics) {
                StringBuilder m = new StringBuilder();
                if (metrics != null) {
                    HealthCounts health = metrics.getHealthCounts();
                    m.append("Requests: ").append(health.getTotalRequests()).append(" ");
                    m.append("Errors: ").append(health.getErrorCount()).append(" (").append(health.getErrorPercentage()).append("%)   ");
                    m.append("Mean: ").append(metrics.getExecutionTimePercentile(50)).append(" ");
                    m.append("75th: ").append(metrics.getExecutionTimePercentile(75)).append(" ");
                    m.append("90th: ").append(metrics.getExecutionTimePercentile(90)).append(" ");
                    m.append("99th: ").append(metrics.getExecutionTimePercentile(99)).append(" ");
                }
                return m.toString();
            }

        });
        t.setDaemon(true);
        t.start();
    }
