    @Override
    public Class<?> build(Object data) {
        if (data == null) {
            return null;
        }
        String str = STRING.build(data);
        switch (str) {
            case "null":
                return null;
            case "boolean":
                return boolean.class;
            case "integer":
                return int.class;
            case "number":
                return float.class;
            case "string":
                return String.class;
            case "object":
                return Object.class;
            case "array":
                return List.class;
            default:
                throw new JedisException("Unknown type: " + str);
        }
    }
