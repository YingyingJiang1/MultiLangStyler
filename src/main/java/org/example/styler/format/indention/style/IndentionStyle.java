package org.example.styler.format.indention.style;

import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;

public class IndentionStyle extends CommonStyle {
        
        public IndentionStyle() {
            super();
            styleName = "indention";
        }
    
        @Override
        protected StyleRule createRule(String propertyName) {
            IndentionProperty property = new IndentionProperty();
            return new StyleRule(property);
        }
}
