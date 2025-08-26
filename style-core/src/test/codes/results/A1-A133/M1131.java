    private static Object process(final RedisInputStream is) {
        final byte b = is.readByte();
        // System.out.println("BYTE: " + (char) b);
        switch (b) {
            case PLUS_BYTE:
                return is.readLineBytes();
            case DOLLAR_BYTE:
            case EQUAL_BYTE:
                return processBulkReply(is);
            case ASTERISK_BYTE:
                return processMultiBulkReply(is);
            case UNDERSCORE_BYTE:
                return is.readNullCrLf();
            case HASH_BYTE:
                return is.readBooleanCrLf();
            case COLON_BYTE:
                return is.readLongCrLf();
            case COMMA_BYTE:
                return is.readDoubleCrLf();
            case LEFT_BRACE_BYTE:
                return is.readBigIntegerCrLf();
            case PERCENT_BYTE : // TODO: currently just to start working with HELLO
                return processMapKeyValueReply(is);
            case TILDE_BYTE : // TODO:
                return processMultiBulkReply(is);
            case GREATER_THAN_BYTE:
                return processMultiBulkReply(is);
            case MINUS_BYTE:
                processError(is);
                return null;
                // TODO: Blob error '!'
            default:
                throw new JedisConnectionException("Unknown reply: " + (char) b);
        }
    }
