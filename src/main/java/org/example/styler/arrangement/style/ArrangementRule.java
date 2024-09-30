package org.example.styler.arrangement.style;

import org.example.style.StyleContext;
import org.example.style.StyleRule;

public class ArrangementRule extends StyleRule {

    public ArrangementRule(ArrangementContext context, ArrangementProperty property) {
        this.styleContext = context;
        this.styleProperty = property;
    }

    @Override
    public ArrangementContext getStyleContext() {
        return (ArrangementContext) styleContext;
    }

    @Override
    public ArrangementProperty getStyleProperty() {
        return (ArrangementProperty) styleProperty;
    }
}
