
@Override
public void draw(CommandProcess process, JvmModel result) {
    TableElement table = new TableElement(2, 5).leftCellPadding(1).rightCellPadding(1);

    result.getJvmInfo().forEach((group, items) -> {
        table.row(true, label(group).style(Decoration.bold.bold()));
        
        items.forEach(item -> {
            String valueStr = (item.getValue() instanceof Map && item.getName().endsWith("MEMORY-USAGE"))
                ? renderMemoryUsage((Map<String, Object>) item.getValue())
                : renderItemValue(item.getValue());
                
            String entry = (item.getDesc() != null) 
                ? item.getName() + "\n[" + item.getDesc() + "]" 
                : item.getName();
                
            table.row(entry, valueStr);
        });
        
        table.row("", "");
    });

    process.write(RenderUtil.render(table, process.width()));
}
