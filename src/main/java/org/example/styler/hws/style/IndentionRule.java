package org.example.styler.hws.style;

import org.example.interfaces.StyleRule;

import java.util.List;

/*
 * @description IndentionRule has no context.
 * @author       Yingying Jiang
 * @create       2024/4/6 13:50
 */
public class IndentionRule extends StyleRule {
    public IndentionRule() {}

    public IndentionRule(IndentionProperty styleProperty) {
        super(styleProperty);
    }

    @Override
    public IndentionProperty getStyleProperty() {
        return (IndentionProperty) styleProperty;
    }
}
