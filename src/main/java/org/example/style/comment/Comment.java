package org.example.style.comment;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.Style;
import org.junit.Rule;

import java.util.ArrayList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/31 15:58
 */
public class Comment extends Style {

  List<CommentRule> rules = new ArrayList<>();

  public void addRules(List<CommentRule> newRules) {
    for(CommentRule newRule : newRules) {
      boolean addFlag = true;
      for (CommentRule rule : rules) {
        if(newRule.context.equals(rule.context)) {
          rule.property.merge(newRule.property);
          addFlag = false;
        }
      }
      if (addFlag) {
        rules.add(newRule);
      }
    }
  }

  public CommentRule.Property getProperty(CommentRule.Context context) {
    int minDis = Integer.MAX_VALUE;
    CommentRule.Property target = null;
    for (CommentRule rule : rules) {
      int dis = rule.context.calculateDistance(context);
      if(dis < minDis) {
        minDis = dis;
        target = rule.property;
      }
    }
    return target;
  }

  @Override
  public void addElement(Element parent, Parser parser) {
    Element commentEle = parent.addElement("comment");
    for(CommentRule rule : rules) {
      Element ruleEle = commentEle.addElement("rule");
      rule.addElement(ruleEle);
    }
  }

  @Override
  public Object parseElement(Element parent, Parser parser) {
    Element commentEle = parent.element("comment");
    List<Element> ruleEles = commentEle.elements();
    for(Element ruleEle : ruleEles) {
      CommentRule rule = new CommentRule();
      rule.parseElement(ruleEle);
      rules.add(rule);
    }
    return this;
  }
}
