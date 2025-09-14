public class Main {
	public static HeaderFileMetadata createFromFile(String headerPath) {
		final List<Pattern> patterns = readerLines.stream()
					.map(HeaderFileMetadata::createPatternFromLine).collect(Collectors.toUnmodifiableList());
		String valueStr = item.getValue() instanceof Map && item.getName().endsWith("MEMORY-USAGE") 
					? renderMemoryUsage((Map<String, Object>) item.getValue()) : renderItemValue(item.getValue());
	}
}
