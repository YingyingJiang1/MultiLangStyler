package org.example.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.*;
import org.example.utils.FileCollection;

import java.util.List;

/*
 * @description: Base class of all specific style classes. If new instance of `RuleSet` is defined, then the following methods
 * must be overridden: addElement, parseElement, addRule, getProperty, fillStyle, contains.
 * instantiate StyleBase's subclass.
 * @author     : Jiang Yingying
 * @create     : 2024/1/7 17:55
 */
public class CommonStyle implements DomIO,Style {
    // @fileCollection tells where the style is extracted.
    public FileCollection srcFileCollection = null, targetFileCollection = null;
    public String styleName = "";
//    protected List<StyleRule> rules = new ArrayList<>();
    protected RuleSet ruleSet = new MapRuleSet();

    public void addElement(Element parent, MyParser parser){
        Element styleEle = parent.addElement("style");
        styleEle.addAttribute("name", styleName);
        for (StyleRule rule : ruleSet.getRules()) {
            Element ruleEle = styleEle.addElement("rule");
            rule.addElement(ruleEle, parser);
        }
    }

    public void parseElement(Element parent, MyParser parser){
        Element styleEle = parent.elements("style").stream()
            .filter(ele -> ele.attributeValue("name").equals(styleName))
            .findFirst().orElse(null);
        if (styleEle == null) {
            return;
        }
        List<Element> ruleEles = styleEle.elements();
        for(Element ruleEle : ruleEles) {
            StyleRule rule = createRule("rule");
            rule.parseElement(ruleEle, parser);
            ruleSet.addRule(rule.getStyleContext(), rule.getStyleProperty());
        }
    }

    public void addRule(StyleContext styleContext, StyleProperty styleProperty) {
        ruleSet.addRule(styleContext, styleProperty);
    }

    public StyleProperty getProperty(StyleContext targetContext) {
        StyleProperty property =  ruleSet.getProperty(targetContext);
        if (property == null) {
            Style selfStyle = SelfStyleManager.getStyle(srcFileCollection, styleName);
            if (selfStyle != this && selfStyle != null) {
                property = selfStyle.getProperty(targetContext);
            }
        }
        return property;
    }

    @Override
    public List<StyleProperty> getProperties(StyleContext context) {
        return ruleSet.getProperties(context);
    }

    public StyleProperty getSimilarProperty(StyleContext targetContext) {
        StyleProperty property =  ruleSet.getSimilarProperty(targetContext);
        if (property == null) {
            Style selfStyle = SelfStyleManager.getStyle(srcFileCollection, styleName);
            if (selfStyle != this && selfStyle != null) {
                property = selfStyle.getSimilarProperty(targetContext);
            }
        }
        return property;
    }

    public List<StyleRule> getRules() {
        return ruleSet.getRules();
    }

    public String getStyleName() {
        return styleName;
    }

    public void fillStyle() {
        for (StyleRule rule : ruleSet.getRules()) {
            rule.fillStyle();
        }
    }

    @Override
    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

//    protected void addListElement(Element parent, MyParser parser, RuleSet ruleSet, String name, String comment) {
//        if (comment != null) {
//            parent.addComment(comment);
//        }
//        for(StyleRule styleRule : ruleSet.getRules()) {
//            Element newParent = parent.addElement(name);
//            styleRule.addElement(newParent, parser);
//        }
//    }


    public boolean contains(StyleContext targetContext) {
        return ruleSet.contains(targetContext);
    }

    @Override
    public List<StyleContext> filterRules() {
        return ruleSet.filterRules();
    }

    public RuleSet getRuleSet() {
        return ruleSet;
    }


    @Override
    public StyleProperty remove(StyleContext styleContext) {
        return ruleSet.remove(styleContext);
    }

    @Override
    public void reset() {
        ruleSet.clear();
    }

//    protected void parseListElement(Element parent, MyParser parser, RuleSet ruleSet, String name) {
//        List<Element> eleList = parent.elements();
//        for(Element ele : eleList) {
//            StyleRule rule = createRule(name);
//            rule.parseElement(ele, parser);
//            ruleSet.addRule(rule.getStyleContext(), rule.getStyleProperty());
//        }
//    }

    protected StyleRule createRule(String propertyName) {
        return new StyleRule();
    }


  /*protected static void groupTokens() {
    if(tokenSource == null)
      throw new EAsourceUnsetException("创建StyleBase子类实例前需要先为StyleBase设置tokenSource！");

    tokenGroup = new HashMap<>();
    final int INTEGER_LITERAL_START = tokenTypeMap.get("DECIMAL_LITERAL"), INTEGER_LITERAL_END = tokenTypeMap.get("BINARY_LITERAL");
    final int FLOAT_LITERAL_START = tokenTypeMap.get("FLOAT_LITERAL"), FLOAT_LITERAL_END = tokenTypeMap.get("HEX_FLOAT_LITERAL");
    final int STRING_LITERAL_START = tokenTypeMap.get("CHAR_LITERAL"), STRING_LITERAL_END = tokenTypeMap.get("TEXT_BLOCK");
    final int PRIMITIVE_TYPE_KEYWORD_START = tokenTypeMap.get("BOOLEAN"), PRIMITIVE_TYPE_KEYWORD_END = tokenTypeMap.get("VOID");
    final int CONTROL_KEYWORD_START = tokenTypeMap.get("CATCH"), CONTROL_KEYWORD_END = tokenTypeMap.get("RETURN");
    final int OTHER_KEYWORD_START = tokenTypeMap.get("ABSTRACT"), OTHER_KEYWORD_END = tokenTypeMap.get("NON_SEALED");
    final int OTHER_LITERAL_START = tokenTypeMap.get("BOOL_LITERAL"), OTHER_LITERAL_END = tokenTypeMap.get("NULL_LITERAL");
    final int BIN_OP_START = tokenTypeMap.get("ASSIGN"), BIN_OP_END = tokenTypeMap.get("URSHIFT_ASSIGN");
    final int UNARY_OP_START = tokenTypeMap.get("TILDE"), UNARY_OP_END = tokenTypeMap.get("DEC");
    final int COMMENT_START = tokenTypeMap.get("BLOCK_COMMENT"), COMMENT_END = tokenTypeMap.get("LINE_COMMENT");

    for(Integer tokenType : tokenTypeMap.values()) {
      TokenGroup group = TokenGroup.OTHER;

      if(PRIMITIVE_TYPE_KEYWORD_START <= tokenType && tokenType <= PRIMITIVE_TYPE_KEYWORD_END) {
        group = TokenGroup.PRIMITIVE_TYPE_KEYWORD;
      } else if(CONTROL_KEYWORD_START <= tokenType && tokenType <= CONTROL_KEYWORD_END) {
        group = TokenGroup.CONTROL_KEYWORD;
      } else if(OTHER_KEYWORD_START <= tokenType && tokenType <= OTHER_KEYWORD_END) {
        group = TokenGroup.OTHER_KEYWORD;
      } else if(OTHER_LITERAL_START <= tokenType && tokenType <= OTHER_LITERAL_END) {
        group = TokenGroup.OTHER_LITERAL;
      } else if(BIN_OP_START <= tokenType && tokenType <= BIN_OP_END) {
        group = TokenGroup.BIN_OP;
      } else if(UNARY_OP_START <= tokenType && tokenType <= UNARY_OP_END) {
        group = TokenGroup.UNARY_OP;
      } else if(COMMENT_START <= tokenType && tokenType <= COMMENT_END) {
        group = TokenGroup.COMMENT;
      } else if(INTEGER_LITERAL_START <= tokenType && tokenType <= INTEGER_LITERAL_END) {
        group = TokenGroup.INTEGER_LITERAL;
      } else if(FLOAT_LITERAL_START <= tokenType && tokenType <= FLOAT_LITERAL_END) {
        group = TokenGroup.FLOAT_LITERAL;
      } else if(STRING_LITERAL_START <= tokenType && tokenType <= STRING_LITERAL_END) {
        group = TokenGroup.STRING_LITERAL;
      } else {
        group = TokenGroup.findByInteger(tokenType);
      }
      tokenGroup.put(tokenType, group);
    }
  }

  protected enum TokenGroup {
    INTEGER_LITERAL(0), FLOAT_LITERAL(1), STRING_LITERAL(2),OTHER_LITERAL(3),
    PRIMITIVE_TYPE_KEYWORD(4), CONTROL_KEYWORD(5), OTHER_KEYWORD(6),
    BIN_OP(7), UNARY_OP(8),
    ANGLE_BRACKET(9), // '<' or '>' in pair <> is an angle bracket.
    COMMENT(10),
    OTHER(11),
    // Other case: token type is token group.
    EOF(JavaLexer.EOF),
    HWS(JavaLexer.HWS), VWS(JavaLexer.VWS),
    ARROW(JavaLexer.ARROW), COLON_COLON(JavaLexer.COLONCOLON), AT(JavaLexer.AT), ELLIPSIS(JavaLexer.ELLIPSIS),
    LBRACK(JavaLexer.LBRACK), RBRACK(JavaLexer.RBRACK), DOT(JavaLexer.DOT),
    LPAREN(JavaLexer.LPAREN), RPAREN(JavaLexer.RPAREN),LBRACE(JavaLexer.LBRACE), RBRACE(JavaLexer.RBRACE),
    SEMI(JavaLexer.SEMI), COMMA(JavaLexer.COMMA),
    IDENTIFIER(JavaLexer.IDENTIFIER);

    private final int integer;
    private TokenGroup(int integer) {
      this.integer = integer;
    }

    public int getValue() {
      return this.integer;
    }

    public static TokenGroup findByInteger(int target) {
      TokenGroup[] groups = values();
      for(int i = groups.length - 1; i >= 0; --i) {
        if(groups[i].integer == target)
          return groups[i];
      }
      throw new RuntimeException("token group为空！");
    }
  }*/

}
