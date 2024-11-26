package org.example.style;

import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;

import java.util.List;

public interface Style {
    void addRule(StyleContext styleContext, StyleProperty styleProperty);
    StyleProperty getProperty(StyleContext targetContext);
    StyleProperty getSimilarProperty(StyleContext targetContext);
    List<StyleRule> getRules();
    String getStyleName() ;
    void fillStyle();
    void setStyleName(String styleName);
}
