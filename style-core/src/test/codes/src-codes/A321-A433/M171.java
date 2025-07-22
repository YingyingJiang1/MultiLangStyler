        EventCounts plus(HystrixEventType eventType, int count) {
            BitSet newBitSet = (BitSet) events.clone();
            int localNumEmits = numEmissions;
            int localNumFallbackEmits =  numFallbackEmissions;
            int localNumCollapsed = numCollapsed;
            switch (eventType) {
                case EMIT:
                    newBitSet.set(HystrixEventType.EMIT.ordinal());
                    localNumEmits += count;
                    break;
                case FALLBACK_EMIT:
                    newBitSet.set(HystrixEventType.FALLBACK_EMIT.ordinal());
                    localNumFallbackEmits += count;
                    break;
                case COLLAPSED:
                    newBitSet.set(HystrixEventType.COLLAPSED.ordinal());
                    localNumCollapsed += count;
                    break;
                default:
                    newBitSet.set(eventType.ordinal());
                    break;
            }
            return new EventCounts(newBitSet, localNumEmits, localNumFallbackEmits, localNumCollapsed);
        }
