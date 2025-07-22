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
