package org.example.style;

import org.example.style.rule.RuleSet;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;

import java.util.List;

public interface Style {
    void addRule(StyleContext styleContext, StyleProperty styleProperty);
    StyleProperty getProperty(StyleContext targetContext);
    List<StyleProperty> getProperties(StyleContext context);
    StyleProperty getSimilarProperty(StyleContext targetContext);
    List<StyleRule> getRules();
    String getStyleName() ;
    void fillStyle();
    void setStyleName(String styleName);
    boolean contains(StyleContext targetContext);
    List<StyleContext> filterRules();
    StyleProperty remove(StyleContext styleContext);
    void reset();
    RuleSet getRuleSet();

}
