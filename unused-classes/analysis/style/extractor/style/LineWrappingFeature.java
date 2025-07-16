package org.example.analysis.style.extractor.style;

import org.example.analysis.style.ComputableStyleExtractor;

public class LineWrappingFeature extends ComputableStyleExtractor {

//
//
//    /**
//     * oracle java convention:Avoid lines longer than 80 characters, since they're not handled well by many terminals and tools.
//     * google java guide:column limit:100
//     */
//    int maxLen = 80;
//    @Override
//    public void toComputableStyle(Style style, Map<String, ComputableStyle> styleMap) {
//        StyleVector sv = new StyleVector();
//        for (StyleRule rule : style.getRules()) {
//            if (rule.getStyleContext() instanceof LineWrappingContext context &&
//            rule.getStyleProperty() instanceof LineWrappingProperty property) {
//                if (context.attr == LineWrappingContext.Attr.CODE) {
//                    if (property.maxLen == property.maxLenBefore) {
//                        sv.addAttrValue("Wrapping long line", new VectorFeatureValue(List.of(true)));
//                    } else if (property.maxLen > maxLen) {
//                        sv.addAttrValue("Wrapping long line", new VectorFeatureValue(List.of(false)));
//                    } else {
//                        sv = null; // indeterminate
//                    }
//                }
//            }
//        }
//        styleMap.put("Line wrapping", sv);
//    }

}
