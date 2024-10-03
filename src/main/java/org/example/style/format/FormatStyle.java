package org.example.style.format;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.parser.AntlrHelper;
import org.example.interfaces.Style;
import org.example.style.format.grouper.FineGrainedGrouper;
import org.example.style.format.grouper.Grouper;
import org.example.style.format.grouper.RuleGrouper;
import org.example.styler.hws.style.SpaceRule;
import org.example.styler.linewrapping.style.LineWrappingRule;
import org.example.styler.newline.style.NewlineContext;
import org.example.styler.newline.style.NewlineProperty;
import org.example.styler.newline.style.NewlineRule;

import java.util.*;
import java.util.function.Function;


/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/8 22:16
 */
public class FormatStyle extends Style {
  public boolean isRulesEnough = true;
  private Map<Integer, SpaceRule> spaces; // The Integer key is the group of the left token.
  private Grouper tokenGrouper;
  private Grouper ruleGrouper;
  private int columnLimit;

  private LineWrappingRule lineWrappingRule = new LineWrappingRule();
  private List<NewlineRule> newlineRules;
  private SingleLineBlockProperty singleLineBlock = new SingleLineBlockProperty();

  private static final int COARSE = 1; // coarse-grained
  private static final int FINE = 2; // fine-grained
  


  public FormatStyle() {
    styleName = "Format";
    this.spaces = new HashMap<>();
    this.newlineRules = new ArrayList<>();
    setTokenGrouper();
    setRuleGrouper();

    // add default space rule.
    addDefaultSpaceRule();

  }

  private void addDefaultSpaceRule() {
    int identifierType = AntlrHelper.getTokenType("IDENTIFIER");
    int keywordGroup = tokenGrouper.getGroupId("keyword");
    int literalGroup = tokenGrouper.getGroupId("literal");
    addRule(identifierType, identifierType, 1);
    addRule(identifierType, keywordGroup, 1);
    addRule(identifierType, literalGroup, 1);
    addRule(keywordGroup, identifierType, 1);
    addRule(keywordGroup, keywordGroup, 1);
    addRule(keywordGroup, literalGroup, 1);
    addRule(literalGroup, identifierType, 1);
    addRule(literalGroup, keywordGroup, 1);
    addRule(literalGroup, literalGroup, 1);
  }

  private void setTokenGrouper() {
    tokenGrouper = FineGrainedGrouper.getInstance();
  }

  private void setRuleGrouper() {
    ruleGrouper = RuleGrouper.getInstance();
    NewlineContext.grouper = ruleGrouper;
  }

  @Override
  public void addElement(Element root, Parser parser) {
    Element formatStyleEle = root.addElement("format_style");



    Element spaceInfosEle = formatStyleEle.addElement("space_infos");
    spaceInfosEle.addComment("space_info: (left token group type, right token group type)");
    for(SpaceRule hwsInfo : spaces.values()) {
      String leftTokenName = getTokenName(hwsInfo.startToken);
      for(int i = 0; i < hwsInfo.endTokens.size(); ++i) {
        int endToken = hwsInfo.endTokens.get(i);
        String rightTokenName = getTokenName(hwsInfo.endTokens.get(i));
        spaceInfosEle.addElement("space_info").addText(
            hwsInfo.startToken + ":" + leftTokenName + "," +
                endToken + ":" + rightTokenName + "," +
                (hwsInfo.counts.get(i) >= 0)
        );
      }
    }


    
    Element newlineRulesEle = formatStyleEle.addElement("newline_rules");
    for(NewlineRule rule : newlineRules) {
      Element ruleEle = newlineRulesEle.addElement("newline_rule");
      rule.addElement(ruleEle);
    }

    Element columnLimitEle = formatStyleEle.addElement("column_limit");
    columnLimitEle.addText(Integer.toString(columnLimit));
    lineWrappingRule.addElement(formatStyleEle);

    Element singleLineBlockEle = formatStyleEle.addElement("single_line_block");
    singleLineBlock.addElement(singleLineBlockEle);
  }

  @Override
  public Object parseElement(Element root, Parser parser) {
    Element formatStyleEle = root.element("format_style");

    Element columnLimitEle = formatStyleEle.element("column_limit");
    columnLimit = Integer.parseInt(columnLimitEle.getText());



    Element spaceInfosEle = formatStyleEle.element("space_infos");
    List<Element> spaceInfoEleList = spaceInfosEle.elements();
    for(Element spaceInfoEle : spaceInfoEleList) {
      String[] arr = spaceInfoEle.getText().split("[:,]");
      int start = Integer.parseInt(arr[0]), end = Integer.parseInt(arr[2]);
      SpaceRule info = spaces.get(start);
      if (info == null) {
        info = new SpaceRule(start);
        spaces.put(start, info);
      }
      info.endTokens.add(end);
      info.counts.add(Boolean.parseBoolean(arr[4]) ? 1 : -1);
    }


    Element newlineRulesEle = formatStyleEle.element("newline_rules");
    for(Element ruleEle : newlineRulesEle.elements()) {
      NewlineRule rule = new NewlineRule();
      rule.parseElement(ruleEle);
      newlineRules.add(rule);
    }

    lineWrappingRule.parseElement(formatStyleEle);

    Element singleLineBlockEle = formatStyleEle.element("single_line_block");
    singleLineBlock.parseElement(singleLineBlockEle);
    return this;
  }



  public LineWrappingRule getRule() {
    return lineWrappingRule;
  }


  private void addRule(NewlineRule newRule) {
    boolean addFlag = true;
    for (NewlineRule rule : newlineRules) {
      if(rule.equals(newRule)) {
        rule.newlineContext.merge(newRule.newlineContext);
        addFlag = false;
        break;
      }
    }
    if (addFlag && newRule.newlineProperty.newlines > 0) {
      newlineRules.add(newRule);
    }
  }

  public void addRules(List<NewlineRule> rules) {
    for(NewlineRule newRule : rules) {
      addRule(newRule);
    }

    if (ruleGrouper != null) {
      for(NewlineRule newRule : rules) {
        NewlineContext groupedNewlineContext = newRule.newlineContext.getGroupedContext();
        if(!newRule.newlineContext.equals(groupedNewlineContext)) {
          NewlineRule groupedRule = new NewlineRule(groupedNewlineContext, newRule.newlineProperty.clone());
          addRule(groupedRule);
        }
      }
    }
  }


  public SingleLineBlockProperty getSingleBlockProperty() {
    return singleLineBlock;
  }

  public NewlineProperty getProperty(NewlineContext newlineContext) {
    Function<NewlineContext, NewlineProperty> propertyGetter =
        new Function<NewlineContext, NewlineProperty>() {
      @Override
      public NewlineProperty apply(NewlineContext context) {
        List<NewlineRule> candidates = new ArrayList<>();
        for (NewlineRule rule : newlineRules) {
          if(rule.newlineContext.equals(context)) {
            candidates.add(rule);
          }
        }

        if(!candidates.isEmpty()) {
          NewlineProperty ret = null;
          double minDis = Double.MAX_VALUE;
          for (NewlineRule rule : candidates) {
            double dis =rule.newlineContext.calculateDistance(context);
            if (dis < minDis) {
              minDis = dis;
              ret = rule.newlineProperty;
            }
          }
          return ret;
        }
        return null;
      }
    };
    NewlineProperty ret = propertyGetter.apply(newlineContext);

    if (ret == null && ruleGrouper != null) {
      NewlineContext groupedNewlineContext = newlineContext.getGroupedContext();
      if(!groupedNewlineContext.equals(newlineContext)) {
        ret = propertyGetter.apply(groupedNewlineContext);
      }
    }

    if (ret != null) {
      return ret;
    }

    if(NewlineRule.isDefaultCase(newlineContext)) {
      return NewlineRule.defaultNewlineProperty;
    }
    return null;
  }

  public void fill() {
    // Fill @spaces.
    for(SpaceRule info : this.spaces.values()) {
      info.fill();
    }

    // Fill @singleLineBlock
    singleLineBlock.fill();

    // Fill @lineWrappingRule
    lineWrappingRule.fill();

	  // add default newline rule
//	  List<NewlineRule.Context> contexts = Arrays.asList(
//			  new NewlineRule.Context(JavaParser.RULE_packageDeclaration, JavaParser.RULE_importDeclaration),
//	  new NewlineRule.Context(JavaParser.RULE_importDeclaration, JavaParser.RULE_importDeclaration)
//	  );
//	  boolean[] addFlags = new boolean[contexts.size()];
//		Arrays.fill(addFlags, true);
//	  for (int i = 0; i < contexts.size(); i++) {
//		  NewlineRule.Context context = contexts.get(i);
//		  for(NewlineRule rule : newlineRules) {
//			  if(rule.context.equals(context)) {
//					addFlags[i] = false;
//			  }
//		  }
//	  }
//		List<NewlineRule> rules = new ArrayList<>();
//	  for (int i = 0; i < addFlags.length; i++) {
//		  if(addFlags[i]) {
//				rules.add(new NewlineRule(contexts.get(i), new NewlineRule.Property(1)));
//		  }
//	  }
//		addRules(rules);
  }

  public String getSpaceBetween(int leftTokenType, int rightTokenType) {
    String space = "";
    SpaceRule info = spaces.get(leftTokenType);
    if(info != null) {
      space = info.getSpace(rightTokenType);
    }
    // (leftTokenType, rightTokenType) doesn't appear in the program.
    if(info == null || space == null){
      space = secondTryForSpace(leftTokenType, rightTokenType);
    }
    return space == null ? "" : space;
  }


  /*public String getSpaceBetween(int leftTokenType, int rightTokenType) {
    String space = "";
    SpaceInfo info = spaces.get(leftTokenType);
    if(info != null) {
      space = info.getSpace(rightTokenType);
    }
    if(space.isEmpty()) {
      // space = secondTryForSpace(leftTokenType, rightTokenType);
    }

    return space;
  }*/

  // Try to find matching token group.
  public String secondTryForSpace(int leftTokenType, int rightTokenType) {
    int leftTokenGroup = tokenGrouper.getGroupId(leftTokenType);
    int rightTokenGroup = tokenGrouper.getGroupId(rightTokenType);
    String space = "";
    SpaceRule info = spaces.get(leftTokenGroup);
    if(info != null) {
      space = info.getSpace(rightTokenGroup);
    }
    // For binary operators, check around.
    int binOp = tokenGrouper.isBinaryOp(leftTokenGroup) ? leftTokenGroup : rightTokenGroup;
    if(tokenGrouper.isBinaryOp(binOp) && spaces.get(binOp) != null) {
      return spaces.get(binOp).isMoreSpace() ? " " : "";
    }
    return space;
  }



  public int getColumnLimit() {
    return columnLimit;
  }

  public void updateColumnLimit(int columnLimit) {
    if(columnLimit > this.columnLimit) {
      this.columnLimit = columnLimit;
    }
  }

  public void addRule(int leftTokenType, int rightTokenType, int delta) {
    SpaceRule info = spaces.computeIfAbsent(leftTokenType, k -> new SpaceRule(leftTokenType));
    info.updateStatistic(rightTokenType, delta);

    int leftGroup = tokenGrouper.getGroupId(leftTokenType);
    int rightGroup = tokenGrouper.getGroupId(rightTokenType);
    if (leftGroup != leftTokenType || rightGroup != rightTokenType) {
      int binOp, group = 0;
      if(tokenGrouper.isBinaryOp(leftGroup)) {
        binOp = leftGroup;
        group = rightGroup;
      } else if(tokenGrouper.isBinaryOp(rightGroup)) {
        binOp = rightGroup;
        group = leftGroup;
      } else {
        binOp = 0;
      }
      if(tokenGrouper.isBinaryOp(binOp)) {
        SpaceRule info1 = spaces.computeIfAbsent(binOp, k -> new SpaceRule(binOp));
        info1.updateStatistic(group, delta);
      } else {
        SpaceRule info1 = spaces.computeIfAbsent(leftGroup, k -> new SpaceRule(leftGroup));
        info1.updateStatistic(rightGroup, delta);
      }
    }
  }


  private String getTokenName(int type) {
    if(AntlrHelper.isLeftAngleBracket(type)) {
      return "left_angle_bracket";
    } else if(AntlrHelper.isRightAngleBracket(type)) {
      return "right_angle_bracket";
    } else if(AntlrHelper.isNegative(type)) {
      return "negative";
    } else if(type < -AntlrHelper.maxType()) {
      return tokenGrouper.getGroupName(type);
    } else {
      return AntlrHelper.getTokenName(type);
    }
  }
}
