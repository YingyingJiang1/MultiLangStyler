@Override
public CommandDocument build(Object data) {
	List<Object> commandData=(List<Object>) data;
	String summary=STRING.build(commandData.get(1));
	String since=STRING.build(commandData.get(3));
	String group=STRING.build(commandData.get(5));
	String complexity=STRING.build(commandData.get(7));
	List<String> history=null;
	if (STRING.build(commandData.get(8)).equals("history")) {
		List<List<Object>> rawHistory=(List<List<Object>>) commandData.get(9);
		history=new ArrayList<>(rawHistory.size());
		for (List<Object> timePoint : rawHistory) {
			history.add(STRING.build(timePoint.get(0)) + ": " + STRING.build(timePoint.get(1)));
		}
	}
	return new CommandDocument(summary,since,group,complexity,history);
}