package org.example.styler.structure.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class StructureStyle extends CommonStyle {
    
    public StructureStyle() {
        super();
        styleName = "structure_preference";
    }

    @Override
    protected StyleRule createRule(String propertyName) {
        StructPreferenceContext context = new StructPreferenceContext();
        StructPreferenceProperty property = new StructPreferenceProperty();
        return new StyleRule(context, property);
    }
}
