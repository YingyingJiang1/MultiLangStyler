    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        List<HystrixEventType> foundEventTypes = new ArrayList<HystrixEventType>();

        sb.append(getCommandKey().name()).append("[");
        for (HystrixEventType eventType: ALL_EVENT_TYPES) {
            if (executionResult.getEventCounts().contains(eventType)) {
                foundEventTypes.add(eventType);
            }
        }
        int i = 0;
        for (HystrixEventType eventType: foundEventTypes) {
            sb.append(eventType.name());
            int eventCount = executionResult.getEventCounts().getCount(eventType);
            if (eventCount > 1) {
                sb.append("x").append(eventCount);

            }
            if (i < foundEventTypes.size() - 1) {
                sb.append(", ");
            }
            i++;
        }
        sb.append("][").append(getExecutionLatency()).append(" ms]");
        return sb.toString();
    }
