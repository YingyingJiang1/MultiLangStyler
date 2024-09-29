package org.example.style.format;

import org.antlr.v4.runtime.Parser;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;
import org.example.antlr.JavaParser;
import org.example.parser.AntlrHelper;
import org.example.style.Style;
import org.example.style.format.grouper.FineGrainedGrouper;
import org.example.style.format.grouper.Grouper;
import org.example.style.format.grouper.RuleGrouper;

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
  private List<IndentionRule> indentionRules;
  private LineWrappingRule lineWrappingRule = new LineWrappingRule();
  private List<BraceInfo> braceInfos;
  private List<NewlineRule> newlineRules;
  private SingleLineBlockProperty singleLineBlock = new SingleLineBlockProperty();

  private static final int COARSE = 1; // coarse-grained
  private static final int FINE = 2; // fine-grained
  


  public FormatStyle() {
    styleName = "Format";
    this.spaces = new HashMap<>();
    this.braceInfos = new ArrayList<>();
    this.newlineRules = new ArrayList<>();
    this.indentionRules = new ArrayList<>();
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
    NewlineRule.Context.grouper = ruleGrouper;
  }

  @Override
  public void addElement(Element root, Parser parser) {
    Element formatStyleEle = root.addElement("format_style");

    Element indentionRulesEle = root.addElement("indention_rules");
    for(IndentionRule indentionRule : indentionRules) {
      indentionRule.addElement(indentionRulesEle);
    }

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

    Element braceInfosEle = formatStyleEle.addElement("brace_infos");
    braceInfosEle.addComment("In @brace_info.@line_break_info: (beforeLB, afterLB, beforeRB, afterRB)");
    for(BraceInfo braceInfo : braceInfos) {
      braceInfo.addElement(braceInfosEle, parser);
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

    Element indentionRulesEle = root.element("indention_rules");
    for(Element indentionRuleEle : indentionRulesEle.elements()) {
      IndentionRule indentionRule = new IndentionRule();
      indentionRule.parseElement(indentionRuleEle);
      indentionRules.add(indentionRule);
    }

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

    Element braceInfosEle = formatStyleEle.element("brace_infos");
    List<Element> braceInfoEleList = braceInfosEle.elements();
    for(Element braceInfoEle : braceInfoEleList) {
      braceInfos.add(BraceInfo.parseElement(braceInfoEle, parser));
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

  public void addRule(IndentionRule newRule) {
    boolean addFlag = true;
    for(IndentionRule rule : indentionRules) {
      if(rule.equals(newRule)) {
        rule.merge(newRule);
        addFlag = false;
        break;
      }
    }
    if (addFlag) {
      indentionRules.add(newRule);
    }
  }

  // Add Rule for @singleLineBlock
  public void addRule(SingleLineBlockProperty property) {
    singleLineBlock.merge(property);
  }

  public LineWrappingRule getRule() {
    return lineWrappingRule;
  }

  public IndentionRule getIndentionProperty() {
    if (indentionRules.isEmpty()) {
      return null;
    }
    return indentionRules.get(0);
  }

  private void addRule(NewlineRule newRule) {
    boolean addFlag = true;
    for (NewlineRule rule : newlineRules) {
      if(rule.equals(newRule)) {
        rule.context.merge(newRule.context);
        addFlag = false;
        break;
      }
    }
    if (addFlag && newRule.property.newlines > 0) {
      newlineRules.add(newRule);
    }
  }

  public void addRules(List<NewlineRule> rules) {
    for(NewlineRule newRule : rules) {
      addRule(newRule);
    }

    if (ruleGrouper != null) {
      for(NewlineRule newRule : rules) {
        NewlineRule.Context groupedContext = newRule.context.getGroupedContext();
        if(!newRule.context.equals(groupedContext)) {
          NewlineRule groupedRule = new NewlineRule(groupedContext, newRule.property.clone());
          addRule(groupedRule);
        }
      }
    }
  }


  public SingleLineBlockProperty getSingleBlockProperty() {
    return singleLineBlock;
  }

  public NewlineRule.Property getProperty(NewlineRule.Context context) {
    Function<NewlineRule.Context, NewlineRule.Property> propertyGetter =
        new Function<NewlineRule.Context, NewlineRule.Property>() {
      @Override
      public NewlineRule.Property apply(NewlineRule.Context context) {
        List<NewlineRule> candidates = new ArrayList<>();
        for (NewlineRule rule : newlineRules) {
          if(rule.context.equals(context)) {
            candidates.add(rule);
          }
        }

        if(!candidates.isEmpty()) {
          NewlineRule.Property ret = null;
          double minDis = Double.MAX_VALUE;
          for (NewlineRule rule : candidates) {
            double dis =rule.context.calculateDistance(context);
            if (dis < minDis) {
              minDis = dis;
              ret = rule.property;
            }
          }
          return ret;
        }
        return null;
      }
    };
    NewlineRule.Property ret = propertyGetter.apply(context);

    if (ret == null && ruleGrouper != null) {
      NewlineRule.Context groupedContext = context.getGroupedContext();
      if(!groupedContext.equals(context)) {
        ret = propertyGetter.apply(groupedContext);
      }
    }

    if (ret != null) {
      return ret;
    }

    if(NewlineRule.isDefaultCase(context)) {
      return NewlineRule.defaultProperty;
    }
    return null;
  }

  public void fill() {
    // Fill @spaces.
    for(SpaceRule info : this.spaces.values()) {
      info.fill();
    }

    // Fill @braceInfos
    for(BraceInfo braceInfo : braceInfos) {
      braceInfo.fill();;
    }

    // Fill @indentionRules
    Optional<IndentionRule> ret = indentionRules.stream().max(Comparator.comparing(IndentionRule::getCount));
    if (ret.isPresent()) {
      IndentionRule targetIndentionRule = ret.get();
      indentionRules.clear();
      indentionRules.add(targetIndentionRule);
    } else {
      isRulesEnough = false;
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

  public BraceInfo.BraceLineBreakInfo getBraceLineBreakInfo(BraceInfo.TypeEnum blockType, int stmtNum) {
    BraceInfo braceInfo = new BraceInfo(blockType, stmtNum);
    int minDis = Integer.MAX_VALUE;
    BraceInfo.BraceLineBreakInfo lineBreakInfo = null;
    for(BraceInfo braceInfo1 : braceInfos) {
      int distance = braceInfo1.calculateDis(braceInfo);
      if(distance < minDis) {
        minDis = distance;
        lineBreakInfo = braceInfo1.getLineBreakInfo();
      }
    }
    return lineBreakInfo;
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

  public void updateBraceInfoStatistic(BraceInfo.TypeEnum blockType, int elementNumInBlock,
                                       boolean beforeLB, boolean afterLB, boolean beforeRB, boolean afterRB) {
    BraceInfo newInfo = new BraceInfo(blockType, elementNumInBlock);
    int index = braceInfos.indexOf(newInfo);
    if(index >= 0) {
      newInfo = braceInfos.get(index);
    } else {
      braceInfos.add(newInfo);
    }
    newInfo.updateStatistic(beforeLB, afterLB, beforeRB, afterRB);
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
