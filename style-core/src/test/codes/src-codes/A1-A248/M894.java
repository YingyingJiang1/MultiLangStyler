    @Override
    public TSInfo build(Object data) {
      List<KeyValue> list = (List<KeyValue>) data;
      Map<String, Object> properties = new HashMap<>();
      Map<String, String> labels = null;
      Map<String, Rule> rules = null;
      List<Map<String, Object>> chunks = null;

      for (KeyValue propertyValue : list) {
        String prop = BuilderFactory.STRING.build(propertyValue.getKey());
        Object value = propertyValue.getValue();
        if (value instanceof List) {
          switch (prop) {
            case LABELS_PROPERTY:
              labels = BuilderFactory.STRING_MAP.build(value);
              value = labels;
              break;
            case RULES_PROPERTY:
              List<KeyValue> rulesDataList = (List<KeyValue>) value;
              Map<String, List<Object>> rulesValueMap = new HashMap<>(rulesDataList.size(), 1f);
              rules = new HashMap<>(rulesDataList.size());
              for (KeyValue rkv : rulesDataList) {
                String ruleName = BuilderFactory.STRING.build(rkv.getKey());
                List<Object> ruleValueList = BuilderFactory.ENCODED_OBJECT_LIST.build(rkv.getValue());
                rulesValueMap.put(ruleName, ruleValueList);
                rules.put(ruleName, new Rule(ruleName, ruleValueList));
              }
              value = rulesValueMap;
              break;
            case CHUNKS_PROPERTY:
              List<List<KeyValue>> chunksDataList = (List<List<KeyValue>>) value;
              List<Map<String, Object>> chunksValueList = new ArrayList<>(chunksDataList.size());
              chunks = new ArrayList<>(chunksDataList.size());
              for (List<KeyValue> chunkDataAsList : chunksDataList) {
                Map<String, Object> chunk = chunkDataAsList.stream()
                    .collect(Collectors.toMap(kv -> BuilderFactory.STRING.build(kv.getKey()),
                        kv -> BuilderFactory.ENCODED_OBJECT.build(kv.getValue())));
                chunksValueList.add(chunk);
                chunks.add(chunk);
              }
              value = chunksValueList;
              break;
            default:
              value = SafeEncoder.encodeObject(value);
              break;
          }
        } else if (value instanceof byte[]) {
          value = BuilderFactory.STRING.build(value);
          if (DUPLICATE_POLICY_PROPERTY.equals(prop)) {
            try {
              value = DuplicatePolicy.valueOf(((String) value).toUpperCase());
            } catch (Exception e) { }
          }
        }
        properties.put(prop, value);
      }

      return new TSInfo(properties, labels, rules, chunks);
    }
