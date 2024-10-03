package org.example.styler.brace.style;

import org.example.interfaces.StyleRule;

public class OptionalBraceRule extends StyleRule {
    OptionalBraceProperty optionalBraceProperty;

    public OptionalBraceRule(OptionalBraceProperty property) {
        this.styleProperty = property;
    }

    @Override
    public OptionalBraceProperty getStyleProperty() {
        return optionalBraceProperty;
    }

}
