    @Override
    public TSInfo build(Object data) {
      List<Object> list = (List<Object>) data;
      Map<String, Object> properties = new HashMap<>();
      Map<String, String> labels = null;
      Map<String, Rule> rules = null;
      List<Map<String, Object>> chunks = null;

      for (int i = 0; i < list.size(); i += 2) {
        String prop = SafeEncoder.encode((byte[]) list.get(i));
        Object value = list.get(i + 1);
        if (value instanceof List) {
          switch (prop) {
            case LABELS_PROPERTY:
              labels = BuilderFactory.STRING_MAP_FROM_PAIRS.build(value);
              value = labels;
              break;
            case RULES_PROPERTY:
              List<Object> rulesDataList = (List<Object>) value;
              List<List<Object>> rulesValueList = new ArrayList<>(rulesDataList.size());
              rules = new HashMap<>(rulesDataList.size());
              for (Object ruleData : rulesDataList) {
                List<Object> encodedRule = (List<Object>) SafeEncoder.encodeObject(ruleData);
                rulesValueList.add(encodedRule);
                rules.put((String) encodedRule.get(0), new Rule((String) encodedRule.get(0), (Long) encodedRule.get(1),
                    AggregationType.safeValueOf((String) encodedRule.get(2)), (Long) encodedRule.get(3)));
              }
              value = rulesValueList;
              break;
            case CHUNKS_PROPERTY:
              List<Object> chunksDataList = (List<Object>) value;
              List<Map<String, Object>> chunksValueList = new ArrayList<>(chunksDataList.size());
              chunks = new ArrayList<>(chunksDataList.size());
              for (Object chunkData : chunksDataList) {
                Map<String, Object> chunk = BuilderFactory.ENCODED_OBJECT_MAP.build(chunkData);
                chunksValueList.add(new HashMap<>(chunk));
                if (chunk.containsKey(CHUNKS_BYTES_PER_SAMPLE_PROPERTY)) {
                  chunk.put(CHUNKS_BYTES_PER_SAMPLE_PROPERTY,
                      DoublePrecision.parseEncodedFloatingPointNumber(chunk.get(CHUNKS_BYTES_PER_SAMPLE_PROPERTY)));
                }
                chunks.add(chunk);
              }
              value = chunksValueList;
              break;
            default:
              value = SafeEncoder.encodeObject(value);
              break;
          }
        } else if (value instanceof byte[]) {
          value = SafeEncoder.encode((byte[]) value);
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
