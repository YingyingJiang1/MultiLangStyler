package org.example.styler.hws.style;

import org.example.interfaces.StyleRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/1/31 22:28
 */
public class SpaceRule extends StyleRule {
  // 'startToken' and 'endTokens' store the group of token.
  public int startToken;
  public List<Integer> endTokens; // Ascending order in value of token type.


  public SpaceRule() {}

  public SpaceRule(SpaceContext spaceContext, SpaceProperty spaceProperty) {
    super(spaceContext, spaceProperty);
  }


  @Override
  public SpaceContext getStyleContext() {
    return (SpaceContext) styleContext;
  }

  @Override
  public SpaceProperty getStyleProperty() {
    return (SpaceProperty) styleProperty;
  }

  public void add(int rightType) {
    endTokens.add(rightType);
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

