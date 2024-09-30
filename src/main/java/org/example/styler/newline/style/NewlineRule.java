package org.example.styler.newline.style;

import org.dom4j.Element;
import org.example.antlr.JavaParser;
import org.example.parser.AntlrHelper;
import org.example.interfaces.DomIO;
import org.example.style.format.grouper.Grouper;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/28 23:04
 */
public class NewlineRule implements DomIO {
  public static Property defaultProperty = new Property(1);

  public Context context = new Context();
  public Property property = new Property();

  private static Set<Integer> defaultCases = new HashSet<>(Arrays.asList(
      JavaParser.RULE_packageDeclaration,JavaParser.RULE_importDeclaration,JavaParser.RULE_importDeclarationList,
      JavaParser.RULE_fieldDeclaration, JavaParser.RULE_fieldDeclarationList,
      JavaParser.RULE_localVariableDeclarationStmt,JavaParser.RULE_assertStmt,
      JavaParser.RULE_returnStmt, JavaParser.RULE_throwStmt, JavaParser.RULE_breakStmt, JavaParser.RULE_continueStmt,
      JavaParser.RULE_yieldStmt,JavaParser.RULE_expressionStmt,JavaParser.RULE_labelStmt,
      JavaParser.RULE_annotation, JavaParser.RULE_annotationList
  ));

  public NewlineRule() {

  }

  public NewlineRule(Context context, Property property) {
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

  public static boolean isDefaultCase(Context context) {
		return defaultCases.contains(context.type1);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NewlineRule that = (NewlineRule) o;
    return Objects.equals(context, that.context) && Objects.equals(property, that.property);
  }

  @Override
  public int hashCode() {
    return Objects.hash(context, property);
  }

  public static class Context implements DomIO {
    public static Grouper grouper;
    public int type1, type2;
    // Total text length of left child and right child. This is useful when style conflicts happens.
    Map<Integer, Integer> totalTextLens = new HashMap<>();
    double avgLen;
    int count = 0;

    public Context(int type1, int type2) {
      this.type1 = type1;
      this.type2 = type2;
    }

    public Context(int type1, int type2, int totalTextLen) {
      this.type1 = type1;
      this.type2 = type2;
      this.totalTextLens.put(totalTextLen, 1);
      ++count;
    }

    public Context() {}

    public Context getGroupedContext() {
      if (grouper == null) {
        return null;
      }

      Context context = new Context(grouper.getGroupId(type1), grouper.getGroupId(type2));
      context.totalTextLens.putAll(totalTextLens);
      context.avgLen = avgLen;
      return context;
    }


    @Override
    public void addElement(Element parent) {
      Element contextEle = parent.addElement("context");
      String type1Name = grouper == null ? AntlrHelper.getTypeName(type1) : grouper.getGroupName(type1);
      String type2Name = grouper == null ? AntlrHelper.getTypeName(type2) : grouper.getGroupName(type2);
      contextEle.addElement("type_around").addText(
          Integer.toString(type1) + ":" + type1Name + "," +
              Integer.toString(type2) + ":" + type2Name);
      contextEle.addElement("possible_total_text_length").addText(totalTextLens.keySet().toString());

      if (avgLen == 0 && !totalTextLens.isEmpty()) {
        long totalLen = 0, size = 0;
        for(Map.Entry<Integer, Integer> entry : totalTextLens.entrySet()) {
          totalLen += entry.getKey() * entry.getValue();
          size += entry.getValue();
        }
        avgLen = (double) totalLen / size;
      }
      contextEle.addElement("average_total_text_length").addText(Double.toString(avgLen));
      contextEle.addElement("count").addText(Integer.toString(count));
    }

    @Override
    public void parseElement(Element parent) {
      Element contextEle = parent.element("context");
      String[] types = contextEle.element("type_around").getText().split("[:,]");
      type1 = Integer.parseInt(types[0]);
      type2 = Integer.parseInt(types[2]);

      List<Integer> textLens = AntlrHelper.toIntList(contextEle.element("possible_total_text_length").getText());
      for(int textLen : textLens) {
        totalTextLens.put(textLen, 0);
      }
      avgLen = Double.parseDouble(contextEle.element("average_total_text_length").getText());
      count = Integer.parseInt(contextEle.element("count").getText());
    }


    public void merge(Context context) {
      if(this.equals(context)) {
        for(Map.Entry<Integer, Integer> entry : context.totalTextLens.entrySet()) {
          int key = entry.getKey(), value = entry.getValue();
          totalTextLens.merge(key, value, Integer::sum);
          count += value;
        }
      }
    }

    public double calculateDistance(Context context) {
      double dis = 0;
      int len = context.totalTextLens.keySet().iterator().next();
      if(totalTextLens.get(len) == null) {
        dis += Math.abs(len - avgLen);
      }
      return Integer.MAX_VALUE - count;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Context context = (Context) o;
      return type1 == context.type1 && type2 == context.type2;
    }

    @Override
    public int hashCode() {
      return Objects.hash(type1, type2);
    }
  }

  public static class Property implements DomIO {
    /**
     * The number of newlines between two structure.Except in two cases:
     * 1. The first newline around { and } are excluded.
     * for example:
     * if(true) {VWS1
     *   int a = 1;VWS2
     * }VWS3
     * VWS1 is a newline after {, VWS2 is a newline before }, VWS3 is a VWS after }.
     * So in this example,we will get the result: there is no newline between local variable declaration
     * statement and }.
     *
     * 2. The first newline after a statement in block statement but without brace.
     * if(true)VWS1
     *   a++;VWS2
     * int b = 1;
     * In this case, VWS2 is a vws after expression statement "a++;". So the number of newlines between ifStmt
     * and localVariableDeclarationStmt is 0.
     */
    public int newlines;

    public Property(int newlines) {
      this.newlines = newlines;
    }

    public Property() {}

    @Override
    public void addElement(Element parent) {
      Element propertyEle = parent.addElement("property");
      propertyEle.addElement("newlines").addText(Integer.toString(newlines));
    }

    @Override
    public void parseElement(Element parent) {
      Element propertyEle = parent.element("property");
      newlines = Integer.parseInt(propertyEle.addElement("newlines").getText());
    }

    @Override
    public Property clone() {
      return new Property(newlines);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Property property = (Property) o;
      return newlines == property.newlines;
    }

    @Override
    public int hashCode() {
      return Objects.hash(newlines);
    }
  }
}
