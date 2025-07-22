    @Bean(name = "machineType")
    public String determineMachineType() {
        try {
            boolean isDocker = runningInDocker();
            boolean isKubernetes = System.getenv("KUBERNETES_SERVICE_HOST") != null;
            boolean isBrowserOpen = "true".equalsIgnoreCase(env.getProperty("BROWSER_OPEN"));
            if (isKubernetes) {
                return "Kubernetes";
            } else {
                if (!isDocker) {
                    if (isBrowserOpen) {
                        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
                        if (!(os.contains("win"))) {
                            if (os.contains("mac")) {
                                return "Client-mac";
                            } else {
                                return "Client-unix";
                            }
                        } else {
                            return "Client-windows";
                        } 
                    } else {
                        return "Server-jar";
                    }
                } else {
                    return "Docker";
                } 
            }
        } catch (Exception e) {
            return "Unknown";
        }
    }
