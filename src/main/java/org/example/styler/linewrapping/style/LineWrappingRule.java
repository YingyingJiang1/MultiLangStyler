package org.example.styler.linewrapping.style;

import org.dom4j.Element;
import org.example.antlr.JavaParser;
import org.example.parser.AntlrHelper;
import org.example.interfaces.DomIO;
import org.example.styler.hws.style.IndentionRule;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/8 1:24
 */
public class LineWrappingRule implements DomIO{
  public int maxColumn = 0;
  public int avgColumn = 0;
  private List<Integer> maxColumns = new ArrayList<>();
  private List<Integer> avgColumns = new ArrayList<>();

  private Map<Context, Property> breakRules = new HashMap<>();
  private Property DEFAULT_PROPERTY = new Property(0);

  public void addRule(int leftToken, int rightToken, Property property) {
    if(isPredefinedBreakPoint(leftToken)) {
      Context context = new Context(leftToken, false);
      if (breakRules.get(context) == null) {
        property.before = context.before;
        breakRules.put(context, property);
      } else {
        breakRules.get(context).merge(property);
      }
    }
    if(isPredefinedBreakPoint(rightToken)) {
      Context context = new Context(rightToken, true);
      if (breakRules.get(context) == null) {
        property.before = context.before;
        breakRules.put(context, property);
      } else {
        breakRules.get(context).merge(property);
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

    List<Context> deletes = Arrays.asList(
        new Context(JavaParser.RPAREN, false) // after )
    );
    Iterator<Map.Entry<Context, Property>> iterator = breakRules.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<Context, Property> entry = iterator.next();
      Property property = entry.getValue();
      property.fill();
      if(DEFAULT_PROPERTY.count < property.count) {
        DEFAULT_PROPERTY = property;
      }
      if(deletes.contains(entry.getKey())) {
        iterator.remove();
      }
    }
  }

  @Override
  public void addElement(Element parent) {
    Element ele = parent.addElement("line_wrapping_rule");
    ele.addElement("avg_max_column").addText(Integer.toString(maxColumn));
    ele.addElement("avg_column").addText(Integer.toString(avgColumn));
    Element breakRulesEle = ele.addElement("break_rules");
    for(Map.Entry<Context, Property> entry : breakRules.entrySet()) {
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
      Context context = new Context();
      Property property = new Property();
      context.parseElement(child);
      property.parseElement(child);
      breakRules.put(context, property);
    }
  }

  public Property getProperty(int tokenType) {
    Context context = new Context(tokenType, false);
    Property property1 = breakRules.get(context);
    context.before = true;
    Property property2 = breakRules.get(context);
    if (property1 == null && property2 == null) {
      Property property = new Property(DEFAULT_PROPERTY);
      property.count = getDefaultPriority(tokenType);
      return isPredefinedBreakPoint(tokenType) ? property : null;
    }
    if (property1 != null && property2 != null) {
      return property1.count > property2.count ? property1 : property2;
    }
    return property1 == null ? property2 : property1;
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

  public static class Context implements DomIO {
    int tokenType;
    boolean before = true;

    public Context() {
    }

    public Context(int tokenType, boolean before) {
      this.tokenType = tokenType;
      this.before = before;
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
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Context context = (Context) o;
      return tokenType == context.tokenType && before == context.before;
    }

    @Override
    public int hashCode() {
      return Objects.hash(tokenType, before);
    }
  }

  public static class Property implements DomIO {
    public boolean before = true;
    public Set<Integer> alignTokens = new HashSet<>();
    public int fixedIndention = 0;
    private List<Integer> fixedIndentions = new ArrayList<>();
    public int count = 1;

    public Property() {

    }

    public Property(int count) {
      this.count = 0;
    }

    public Property(Property property) {
      this.alignTokens = property.alignTokens;
      this.fixedIndention = property.fixedIndention;
      this.fixedIndentions = property.fixedIndentions;
      this.count = property.count;
    }

    public void addAlignToken(int type) {
      alignTokens.add(type);
    }

    public void addIndention(int indention) {
      if(indention >= fixedIndentions.size()) {
        fixedIndentions.addAll(Collections.nCopies(indention - fixedIndentions.size() + 1, 0));
      }
      fixedIndentions.set(indention, fixedIndentions.get(indention) + 1);
    }

    public void merge(Property property) {
      count += property.count;
      alignTokens.retainAll(property.alignTokens);
      for(Integer indention : property.fixedIndentions) {
        addIndention(indention);
      }
    }

    public void fill() {
      int maxCount = 0;
      for (int i = 0; i < fixedIndentions.size(); i++) {
        if(fixedIndentions.get(i) >= maxCount) {
          maxCount = fixedIndentions.get(i);
          fixedIndention = i;
        }
      }
    }



    @Override
    public void addElement(Element parent) {
      Element ele = parent.addElement("property");
      ele.addElement("aligns").addText(alignTokens.toString());
      ele.addElement("fix_indention").addText(Integer.toString(fixedIndention));
    }

    @Override
    public void parseElement(Element parent) {
      Element ele = parent.element("property");
      String[] strs = ele.elementText("aligns").split(",");
      for(String str : strs) {
        alignTokens.add(Integer.parseInt(str));
      }
      IndentionRule indentionRule = new IndentionRule();
      fixedIndention = Integer.parseInt(ele.elementText("fix_indention"));
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Property property = (Property) o;
      return Objects.equals(alignTokens, property.alignTokens) && Objects.equals(fixedIndention, property.fixedIndention);
    }

    @Override
    public int hashCode() {
      return Objects.hash(alignTokens, fixedIndention);
    }
  }
}
