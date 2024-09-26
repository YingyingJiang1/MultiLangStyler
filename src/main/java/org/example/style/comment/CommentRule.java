package org.example.style.comment;

import org.dom4j.Element;
import org.example.antlr.JavaParser;
import org.example.parser.AntlrHelper;
import org.example.style.DomIO;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/31 15:59
 */
public class CommentRule implements DomIO {

  Context context;
  Property property;

  public CommentRule() {
    context = new Context();
    property = new Property();
  }

  public CommentRule(Context context, Property property) {
    this.context = context;
    this.property = property;
  }

  @Override
  public void addElement(Element parent) {
    context.addElement(parent);
    property.addElement(parent);
  }

  @Override
  public void parseElement(Element parent) {
    context.parseElement(parent);
    property.parseElement(parent);
  }

  public static class Context implements DomIO {

    boolean trailing;
    int commentedRule; // -1 represents code comment.

    public Context() {

    }

    public Context(boolean trailing, int commentedRule) {
      this.trailing = trailing;
      this.commentedRule = commentedRule;
    }

    public int calculateDistance(Context context) {
      int distance = trailing == context.trailing ? 0 : 1;
      if (commentedRule != context.commentedRule) {
        if(CommentGroup.getGroup(commentedRule) == CommentGroup.getGroup(context.commentedRule)) {
          distance += 1;
        } else {
          distance += 2;
        }
      }
      return distance;
    }

    @Override
    public void addElement(Element parent) {
      Element contextEle = parent.addElement("context");
      contextEle.addElement("trailing").addText(Boolean.toString(trailing));
      String commentType = commentedRule == -1 ? "code comment" : AntlrHelper.getRuleName(commentedRule);
      contextEle.addElement("commented_rule").addText(
          Integer.toString(commentedRule) + ":" + commentType);
    }

    @Override
    public void parseElement(Element parent) {
      Element contextEle = parent.element("context");
      trailing = Boolean.parseBoolean(contextEle.addElement("trailing").getText());
      commentedRule = Integer.parseInt(contextEle.element("commented_rule").getText().split(":")[0]);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Context context = (Context) o;
      return trailing == context.trailing && commentedRule == context.commentedRule;
    }

    @Override
    public int hashCode() {
      return Objects.hash(trailing, commentedRule);
    }

    static class CommentGroup {
      public static final int TYPE_COMMENT = 1;
      public static final int METHOD_COMMENT = 2;
      public static final int BLOCK_COMMENT = 3;
      public static final int SINGLE_STATEMENT_COMMENT = 4;

      static Map<Integer, Integer> groupMap = new HashMap<>();

      static {
        groupMap.put(JavaParser.RULE_typeDeclaration, TYPE_COMMENT);
        groupMap.put(JavaParser.RULE_methodDeclaration, METHOD_COMMENT);
        groupMap.put(JavaParser.RULE_constructorDeclaration, METHOD_COMMENT);
      }

      public static int getGroup(int rule) {
        if(rule == -1) {
          return -1;
        } else if (groupMap.get(rule) != null) {
          return groupMap.get(rule);
        } else if(AntlrHelper.isBlockStructure(rule)) {
          return BLOCK_COMMENT;
        } else {
          return SINGLE_STATEMENT_COMMENT;
        }
      }
    }
  }

  public static class Property implements DomIO {
    public static final int ALIGN = 1;
    public static final int NO_INDENTION = 2;

    public int indention = ALIGN;

    public int[] indentionStatistic = new int[2];

    public void merge(Property property) {
      ++indentionStatistic[property.indention - 1];

      int maxCount = 0;
      for (int i = 0; i < indentionStatistic.length; i++) {
        if (indentionStatistic[i] > maxCount) {
          maxCount = indentionStatistic[i];
          indention = i + 1;
        }
      }

    }

    @Override
    public void addElement(Element parent) {
      Element propertyEle = parent.addElement("property");
      propertyEle.addComment("indention: 1(align), 2(no indention)");
      propertyEle.addElement("indention").addText(Integer.toString(indention));
    }

    @Override
    public void parseElement(Element parent) {
      Element propertyEle = parent.element("property");
      indention = Integer.parseInt(propertyEle.addElement("indention").getText());
    }
  }
}
