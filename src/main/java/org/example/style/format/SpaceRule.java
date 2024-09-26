package org.example.style.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/1/31 22:28
 */
public class SpaceRule {
  // 'startToken' and 'endTokens' store the group of token.
  public int startToken;
  public List<Integer> endTokens; // Ascending order in value of token type.
  // If there's a space between the ith pair token, then increase the count of pair,
  // otherwise, decrease the count.
  public List<Integer> counts;

  public SpaceRule(){}
  public SpaceRule(int startToken) {
    this.startToken = startToken;
    this.endTokens = new ArrayList<>();
    this.counts = new ArrayList<>();
  }

  public void add(int rightType) {
    endTokens.add(rightType);
  }

  public void fill() {
    /*List<Integer> finalEndTokens = new ArrayList<>();
    for (int i = 0; i < counts.size(); i++) {
      if (counts.get(i) >= 0) {
        finalEndTokens.add(endTokens.get(i));
      }
    }
    endTokens = finalEndTokens;
    counts = null;*/
  }

  public String getSpace(int endToken) {
    int index = endTokens.indexOf(endToken);
    if (index == -1) {
      return null;
    }
    return counts.get(index) < 0 ? "" : " ";
  }

  public boolean isMoreSpace() {
    int trueCount = counts.stream().filter(integer -> integer >= 0).toList().size();
    return trueCount > counts.size() - trueCount;
  }

  public void updateStatistic(int rightType, int delta) {
    int index = Collections.binarySearch(endTokens, rightType);
    if(index < 0) {
      int insertionPoint = Math.abs(index + 1);
      endTokens.add(insertionPoint, rightType);
      counts.add(insertionPoint, delta);
    } else {
      counts.set(index, counts.get(index) + delta);
    }
  }
}

