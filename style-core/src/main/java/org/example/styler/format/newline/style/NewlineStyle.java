package org.example.styler.format.newline.style;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.style.CommonStyle;
import org.example.style.rule.StyleRule;


import java.util.List;
import java.util.Map;

public class NewlineStyle extends CommonStyle {

	public NewlineStyle() {
		styleName = "newline";
	}

	public NewlineProperty getProperty(NewlineContext context, double threshold) {
        List<Double> weights = getWeights(context);

		NewlineProperty targetProperty = null;
		double curSimilarity = 0;
		for (StyleRule rule : ruleSet.getRules()) {
			if (rule.getStyleContext() instanceof NewlineContext context1 &&
					rule.getStyleProperty() instanceof NewlineProperty property1) {
				double similarity = context1.similarityTo(context, weights);
				if (similarity >= curSimilarity && context.complexityComparision(context1) >= 0) {
					curSimilarity = similarity;
					targetProperty = property1;
				}
			}
		}

		return  curSimilarity >= threshold ? targetProperty : null;
	}

    /**
     *
     * @return vertical weight, horizontal weight, vertical length weight, horizontal length weight.
     */
    protected List<Double> getWeights(NewlineContext context) {
        return List.of(0.0, 1.0, 0.0, 0.0);
    }
}
