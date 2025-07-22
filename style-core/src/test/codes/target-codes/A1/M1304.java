    @Override
    public AggregationResult build(Object data) {
      // return new AggregationResult(data);
      List list = (List) data;

      if (list.get(0) instanceof KeyValue) {
        List<KeyValue> kvList = (List<KeyValue>) data;
        long totalResults = -1;
        List<Map<String, Object>> results = null;
        List<String> warnings = null;
        for (KeyValue kv : kvList) {
          String key = BuilderFactory.STRING.build(kv.getKey());
          Object rawVal = kv.getValue();
          switch (key) {
            case TOTAL_RESULTS_STR:
              totalResults = BuilderFactory.LONG.build(rawVal);
              break;
            case RESULTS_STR:
              List<List<KeyValue>> resList = (List<List<KeyValue>>) rawVal;
              results = new ArrayList<>(resList.size());
              for (List<KeyValue> rikv : resList) {
                for (KeyValue ikv : rikv) {
                  if (FIELDS_STR.equals(BuilderFactory.STRING.build(ikv.getKey()))) {
                    results.add(BuilderFactory.ENCODED_OBJECT_MAP.build(ikv.getValue()));
                    break;
                  }
                }
              }
              break;
            case WARNINGS_STR:
              warnings = BuilderFactory.STRING_LIST.build(rawVal);
              break;
          }
        }
        return new AggregationResult(totalResults, results, warnings);
      }

      list = (List<Object>) SafeEncoder.encodeObject(data);

      // the first element is always the number of results
      long totalResults = (Long) list.get(0);
      List<Map<String, Object>> results = new ArrayList<>(list.size() - 1);

      for (int i = 1; i < list.size(); i++) {
        List<Object> mapList = (List<Object>) list.get(i);
        Map<String, Object> map = new HashMap<>(mapList.size() / 2, 1f);
        for (int j = 0; j < mapList.size(); j += 2) {
          Object r = mapList.get(j);
          if (r instanceof JedisDataException) {
            throw (JedisDataException) r;
          }
          map.put((String) r, mapList.get(j + 1));
        }
        results.add(map);
      }
      return new AggregationResult(totalResults, results);
    }
