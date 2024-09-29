package org.example.style.format;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Vocabulary;
import org.dom4j.Element;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/1/31 22:29
 */
public class BraceInfo {

  private TypeEnum blockType;
  private int stmtNumInBlock; // 0:empty block, 1: only one single statement in block, 2: one single block statement or exceed one statement.
  private BraceLineBreakInfo lineBreakInfo;
  // key: the last four bits represents the value of @beforeLB, @afterLB, @beforeRB, @afterRB.
  // value: frequency.
  private Map<Integer, Integer> map;

  public BraceInfo() {}

  public BraceInfo(TypeEnum blockType, int stmtNumInBlock,
                   boolean beforeLB, boolean afterLB, boolean beforeRB, boolean afterRB) {
    this.blockType = blockType;
    this.stmtNumInBlock = stmtNumInBlock;
    this.lineBreakInfo = new BraceLineBreakInfo(beforeRB, afterLB, beforeRB, afterRB);
    this.map = new HashMap<>();
  }

  public BraceInfo(TypeEnum blockType, int stmtNumInBlock) {
    this.blockType = blockType;
    this.stmtNumInBlock = stmtNumInBlock;
    this.lineBreakInfo = new BraceLineBreakInfo();
    this.map = new HashMap<>();
  }

  public void addElement(Element parent, Parser parser) {
    Element braceInfoEle = parent.addElement("brace_info");
    braceInfoEle.addElement("block_type").addText(blockType.name());
    Element stmtNumEle = braceInfoEle.addElement("number_of_stmt");
    if(stmtNumInBlock < 2) {
      stmtNumEle.addText(Integer.toString(stmtNumInBlock));
    } else {
      stmtNumEle.addText("exceed 1");
    }
    Element lineBreakInfoEle = braceInfoEle.addElement("line_break_info").addText(
        "(" + lineBreakInfo.toString() + ")"
    );
  }

  public static BraceInfo parseElement(Element parent, Parser parser) {
    BraceInfo braceInfo = new BraceInfo();
    braceInfo.blockType = TypeEnum.valueOf(parent.element("block_type").getText());
    Element stmtNumEle = parent.element("number_of_stmt");
    String stmtNumText = stmtNumEle.getText();
    if(stmtNumText.equals("exceed 1")) {
      braceInfo.stmtNumInBlock = 2;
    } else {
      braceInfo.stmtNumInBlock = Integer.parseInt(stmtNumText);
    }
    String[] arr = parent.element("line_break_info").getText().split("[(),]");

    braceInfo.lineBreakInfo = new BraceLineBreakInfo(
        Boolean.parseBoolean(arr[0]), Boolean.parseBoolean(arr[1]),
        Boolean.parseBoolean(arr[2]), Boolean.parseBoolean(arr[3]));
    return braceInfo;
  }

  public int calculateDis(BraceInfo braceInfo) {
    if(this.equals(braceInfo)) {
      return 0;
    }
    int typeDis = blockType == braceInfo.blockType ? 0 : 1;
    return typeDis + Math.abs(stmtNumInBlock - braceInfo.stmtNumInBlock);
  }
  
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof BraceInfo) {
      BraceInfo info = (BraceInfo) obj;
      return blockType == info.blockType && stmtNumInBlock == info.stmtNumInBlock;
    }
    throw new RuntimeException("错误的类型: " + obj.getClass().getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(blockType, stmtNumInBlock);
  }

  public void fill() {
    if(map == null) {
      return;
    }
    int res = 0;
    if(!map.isEmpty()) {
      List<Map.Entry<Integer, Integer>> sortedList = map.entrySet()
          .stream()
          .sorted(Comparator.comparing(Map.Entry::getValue))
          .collect(Collectors.toList());
      res = sortedList.get(sortedList.size() - 1).getKey();
    }
    lineBreakInfo.afterRB = (res & 1) == 1;
    res >>= 1;
    lineBreakInfo.beforeRB = (res & 1) == 1;
    res >>= 1;
    lineBreakInfo.afterLB = (res & 1) == 1;
    res >>= 1;
    lineBreakInfo.beforeLB = (res & 1) == 1;

    map = null;
  }

  public BraceLineBreakInfo getLineBreakInfo() {
    return lineBreakInfo;
  }

  public void updateStatistic(boolean beforeLB, boolean afterLB, boolean beforeRB, boolean afterRB) {
    int integer = beforeLB ? 1 : 0;
    integer <<= 1;
    integer |= afterLB ? 1 : 0;
    integer <<= 1;
    integer |= beforeRB ? 1 : 0;
    integer <<= 1;
    integer |= afterRB ? 1 : 0;
    map.compute(integer, (k, v) -> v == null ? 1 : v + 1);
  }

  public enum TypeEnum {
    BODY_BLOCK, // Body of type declaration or method declaration.
    MULTI_BLOCK_STMT, // if-else, try-catch-finally
    DO_WHILE_BLOCK,
    INITIALIZER_BLOCK, // initializer of type declaration
    ARRAY_INITIALIZER_BLOCK, // array initializer
    NORMAL_BLOCK, // Except for the above blocks.
  }

  public static class BraceLineBreakInfo {
    public boolean beforeLB, afterLB, beforeRB, afterRB;

    public BraceLineBreakInfo() {}

    public BraceLineBreakInfo(boolean beforeLB, boolean afterLB, boolean beforeRB, boolean afterRB) {
      this.beforeLB = beforeLB;
      this.afterLB = afterLB;
      this.beforeRB = beforeRB;
      this.afterRB = afterRB;
    }

    @Override
    public String toString() {
      return Boolean.toString(beforeLB) + "," + Boolean.toString(afterLB) + "," +
          Boolean.toString(beforeRB) + "," + Boolean.toString(afterRB);
    }
  }
}