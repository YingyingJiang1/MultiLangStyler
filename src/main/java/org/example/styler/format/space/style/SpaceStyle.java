package org.example.styler.format.space.style;

import org.example.parser.common.token.TokenGroup;
import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;

import java.util.List;

public class SpaceStyle extends CommonStyle {
    @Override
    public List<StyleContext> filterRules() {
        List<StyleContext> ret = super.filterRules();

        // There's always a space between keywords and identifiers.
        String identifier = TokenGroup.IDENTIFIER.name(), keyword = TokenGroup.KEYWORD.name();
        List<SpaceContext> defaultContexts = List.of(
                new SpaceContext(keyword, identifier),new SpaceContext(identifier, keyword),
                new SpaceContext(keyword, keyword), new SpaceContext(identifier, identifier)
        );
        for (SpaceContext context : defaultContexts) {
            ruleSet.remove(context);
            ruleSet.addRule(context, new SpaceProperty(true));
        }
        return ret;
    }
}
