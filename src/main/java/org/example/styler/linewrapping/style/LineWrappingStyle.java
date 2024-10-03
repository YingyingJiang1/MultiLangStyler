package org.example.styler.linewrapping.style;

import org.dom4j.Element;
import org.example.antlr.JavaParser;
import org.example.interfaces.Style;
import org.example.parser.AntlrHelper;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/8 1:24
 */
public class LineWrappingStyle extends Style {
  public int maxColumn = 0;
  public int avgColumn = 0;
  private List<Integer> maxColumns = new ArrayList<>();
  private List<Integer> avgColumns = new ArrayList<>();


  private LineWrappingProperty DEFAULT_LineWrapping_PROPERTY = new LineWrappingProperty(0);



  public void addRule(int leftToken, int rightToken, LineWrappingProperty lineWrappingProperty) {
    if(isPredefinedBreakPoint(leftToken)) {
      LineWrappingContext lineWrappingContext = new LineWrappingContext(leftToken, false);
      if (breakRules.get(lineWrappingContext) == null) {
        lineWrappingProperty.before = lineWrappingContext.before;
        breakRules.put(lineWrappingContext, lineWrappingProperty);
      } else {
        breakRules.get(lineWrappingContext).merge(lineWrappingProperty);
      }
    }
    if(isPredefinedBreakPoint(rightToken)) {
      LineWrappingContext lineWrappingContext = new LineWrappingContext(rightToken, true);
      if (breakRules.get(lineWrappingContext) == null) {
        lineWrappingProperty.before = lineWrappingContext.before;
        breakRules.put(lineWrappingContext, lineWrappingProperty);
      } else {
        breakRules.get(lineWrappingContext).merge(lineWrappingProperty);
      }
    }
  }

  public void addMaxColumn(int maxColumn) {
    maxColumns.add(maxColumn);
  }

  public void addAvgColumn(int column) {
    avgColumns.add(column);
  }

  public void fill() {
    maxColumn = maxColumns.stream().reduce(Integer::sum).map(integer -> integer / maxColumns.size()).orElse(-1);
    avgColumn = avgColumns.stream().reduce(Integer::sum).map(integer -> integer / avgColumns.size()).orElse(-1);

    List<LineWrappingContext> deletes = Arrays.asList(
        new LineWrappingContext(JavaParser.RPAREN, false) // after )
    );
    Iterator<Map.Entry<LineWrappingContext, LineWrappingProperty>> iterator = breakRules.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<LineWrappingContext, LineWrappingProperty> entry = iterator.next();
      LineWrappingProperty lineWrappingProperty = entry.getValue();
      lineWrappingProperty.fill();
      if(DEFAULT_LineWrapping_PROPERTY.count < lineWrappingProperty.count) {
        DEFAULT_LineWrapping_PROPERTY = lineWrappingProperty;
      }
      if(deletes.contains(entry.getKey())) {
        iterator.remove();
      }
    }
  }

  @Override
  public void addElement(Element parent) {
    parent.addElement("context").addText(tokenType + ":" + AntlrHelper.getTokenName(tokenType) + "," +
            (before ? "before" : "after"));
  }

  @Override
  public void parseElement(Element parent) {
    String[] strs = parent.element("context").getText().split("[,:]");
    tokenType = Integer.parseInt(strs[0]);
    before = strs[2].equals("before");
  }

  @Override
  public void addElement(Element parent) {
    Element ele = parent.addElement("line_wrapping_rule");
    ele.addElement("avg_max_column").addText(Integer.toString(maxColumn));
    ele.addElement("avg_column").addText(Integer.toString(avgColumn));
    Element breakRulesEle = ele.addElement("break_rules");
    for(Map.Entry<LineWrappingContext, LineWrappingProperty> entry : breakRules.entrySet()) {
      Element breakRuleEle = breakRulesEle.addElement("break_rule");
      entry.getKey().addElement(breakRuleEle);
      entry.getValue().addElement(breakRuleEle);
    }
  }

  @Override
  public void parseElement(Element parent) {
    Element ele = parent.element("line_wrapping_rule");
    maxColumn = Integer.parseInt(ele.elementText("avg_max_column"));
    avgColumn = Integer.parseInt(ele.elementText("avg_column"));

    Element breakRulesEle = ele.addElement("break_rules");
    for(Element child : breakRulesEle.elements())  {
      LineWrappingContext lineWrappingContext = new LineWrappingContext();
      LineWrappingProperty lineWrappingProperty = new LineWrappingProperty();
      lineWrappingContext.parseElement(child);
      lineWrappingProperty.parseElement(child);
      breakRules.put(lineWrappingContext, lineWrappingProperty);
    }
  }

  public LineWrappingProperty getProperty(int tokenType) {
    LineWrappingContext lineWrappingContext = new LineWrappingContext(tokenType, false);
    LineWrappingProperty lineWrappingProperty1 = breakRules.get(lineWrappingContext);
    lineWrappingContext.before = true;
    LineWrappingProperty lineWrappingProperty2 = breakRules.get(lineWrappingContext);
    if (lineWrappingProperty1 == null && lineWrappingProperty2 == null) {
      LineWrappingProperty lineWrappingProperty = new LineWrappingProperty(DEFAULT_LineWrapping_PROPERTY);
      lineWrappingProperty.count = getDefaultPriority(tokenType);
      return isPredefinedBreakPoint(tokenType) ? lineWrappingProperty : null;
    }
    if (lineWrappingProperty1 != null && lineWrappingProperty2 != null) {
      return lineWrappingProperty1.count > lineWrappingProperty2.count ? lineWrappingProperty1 : lineWrappingProperty2;
    }
    return lineWrappingProperty1 == null ? lineWrappingProperty2 : lineWrappingProperty1;
  }

  private int getDefaultPriority(int tokenType) {
    if(AntlrHelper.isSeparator(tokenType)) {
      if(tokenType == JavaParser.COMMA) {
        return 4;
      }
      if(tokenType == JavaParser.DOT) {
        return 3;
      }
      return 1;
    }
    if(AntlrHelper.isOperator(tokenType)) {
      return 2;
    }
    return 1;
  }

  private static boolean isPredefinedBreakPoint(int type) {
    return AntlrHelper.isOperator(type) || AntlrHelper.isSeparator(type);
  }

}
