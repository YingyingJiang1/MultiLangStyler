    protected static String convertToJson(HystrixUtilization utilization) throws IOException {
        StringWriter jsonString = new StringWriter();
        JsonGenerator json = jsonFactory.createGenerator(jsonString);

        json.writeStartObject();
        json.writeStringField("type", "HystrixUtilization");
        json.writeObjectFieldStart("commands");
        for (Map.Entry<HystrixCommandKey, HystrixCommandUtilization> entry: utilization.getCommandUtilizationMap().entrySet()) {
            final HystrixCommandKey key = entry.getKey();
            final HystrixCommandUtilization commandUtilization = entry.getValue();
            writeCommandUtilizationJson(json, key, commandUtilization);

        }
        json.writeEndObject();

        json.writeObjectFieldStart("threadpools");
        for (Map.Entry<HystrixThreadPoolKey, HystrixThreadPoolUtilization> entry: utilization.getThreadPoolUtilizationMap().entrySet()) {
            final HystrixThreadPoolKey threadPoolKey = entry.getKey();
            final HystrixThreadPoolUtilization threadPoolUtilization = entry.getValue();
            writeThreadPoolUtilizationJson(json, threadPoolKey, threadPoolUtilization);
        }
        json.writeEndObject();
        json.writeEndObject();
        json.close();

        return jsonString.getBuffer().toString();
    }
