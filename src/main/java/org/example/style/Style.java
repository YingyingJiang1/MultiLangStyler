package org.example.style;

import org.example.io.DomIO;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;

import java.util.List;
import java.util.Map;

public interface Style {
    void addRule(StyleContext styleContext, StyleProperty styleProperty);
    StyleProperty getProperty(StyleContext targetContext);
    StyleProperty getSimilarProperty(StyleContext targetContext);
    List<StyleRule> getRules();
    String getStyleName() ;
    void fillStyle();
    void setStyleName(String styleName);
    boolean contains(StyleContext targetContext);
    void filterRules();
    StyleProperty remove(StyleContext styleContext);
    void reset();
}
