    @Override
    public void addParams(CommandArguments args) {
        if (retentionPeriod != null) {
            args.add(RETENTION).add(toByteArray(retentionPeriod));
        }
        if (encoding != null) {
            args.add(ENCODING).add(encoding);
        }

        if (chunkSize != null) {
            args.add(CHUNK_SIZE).add(toByteArray(chunkSize));
        }

        if (duplicatePolicy != null) {
            args.add(DUPLICATE_POLICY).add(duplicatePolicy);
        }
        if (duplicatePolicy != null) {
            args.add(DUPLICATE_POLICY).add(duplicatePolicy);
        }
        if (onDuplicate != null) {
            args.add(ON_DUPLICATE).add(onDuplicate);
        }
        if (ignore) {
            args.add(IGNORE).add(ignoreMaxTimediff).add(ignoreMaxValDiff);
        }
        if (labels != null) {
            args.add(LABELS);
            labels.entrySet().forEach((entry) -> args.add(entry.getKey()).add(entry.getValue()));
        }
    }
