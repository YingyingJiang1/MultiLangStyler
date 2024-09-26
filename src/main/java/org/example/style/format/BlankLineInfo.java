package org.example.style.format;

import org.antlr.v4.runtime.Parser;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/1/31 22:29
 */
public class BlankLineInfo {
  // The newlines are between @leftChildNode and @rightChildNode, and the @parentNode is the parent of the two nodes.
  public int parentType, leftChildType, rightChildType; // pair:(type, token)

  public int number; // the number of newlines between @leftChildNode and @rightChildNode.
  private Map<Integer, Integer> blankLineStatistic; // The first Integer is the number of blank lines, the second Integer is the frequency of the key value.

  public BlankLineInfo(int parentType, int leftChildType, int rightChildType) {
    this.parentType = parentType;
    this.leftChildType = leftChildType;
    this.rightChildType = rightChildType;
    blankLineStatistic = new TreeMap<>();
    number = 0;
  }

  public BlankLineInfo(String str) {
    String[] arr = str.split(",");
    leftChildType = Integer.parseInt(arr[0]);
    rightChildType = Integer.parseInt(arr[1]);
    parentType = Integer.parseInt(arr[2]);
    number = Integer.parseInt(arr[3]);
  }

  public void fill() {
    if(blankLineStatistic != null && !blankLineStatistic.isEmpty()) {
      List<Map.Entry<Integer, Integer>> sortedList = blankLineStatistic.entrySet()
          .stream()
          .sorted(Comparator.comparing(Map.Entry::getValue))
          .collect(Collectors.toList());
      number = sortedList.get(sortedList.size() - 1).getKey();
    }
    blankLineStatistic = null;
  }

  public int getParentCtx() {
    return parentType;
  }

  public int getLeftCtx() {
    return leftChildType;
  }

  public int getRightCtx() {
    return rightChildType;
  }

  public int getBlankLineNumber() {
    return number;
  }

  public String toReadableString(Parser parser) {
    String[] ruleNames = parser.getRuleNames();
    String leftStr = leftChildType >= 0 ? ruleNames[leftChildType] : Integer.toString(leftChildType);
    String rightStr = rightChildType >= 0 ? ruleNames[rightChildType] : Integer.toString(rightChildType);
    return leftStr + "," +
        rightStr + "," +
        ruleNames[parentType] + "," +
        Integer.toString(number);
  }

  public void updateStatistic(int blankLines) {
    blankLineStatistic.compute(blankLines, (k, v) -> v == null ? 1 : v + 1);
  }

}
