package org.example.style.rule;


import java.util.List;

public interface RuleSet {
    void addRule(StyleContext context, StyleProperty property);

    boolean contains(StyleContext targetContext);

    StyleProperty getProperty(StyleContext targetContext);

    List<StyleProperty> getProperties(StyleContext targetContext);

    /**
     * Returns the property whose context has the min distance to the target context.
     * @param targetContext
     * @return
     */
    StyleProperty getSimilarProperty(StyleContext targetContext);

    List<StyleRule> getRules();
    /**
     * @description: When more than one rule with the same style context appears, the rule with the largest frequency is retained.
     * @return the style contexts of removed rules.
     */
    List<StyleContext> filterRules();

    boolean updateKey(StyleContext oldContext, StyleContext newContext);

    StyleProperty remove(StyleContext styleContext);

    void clear();
}
