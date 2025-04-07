package org.example.styler.method.complexity;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.method.complexity.style.MethodComplexity;
import org.example.styler.method.complexity.style.MethodComplexityProperty;
import org.example.styler.method.utils.MethodComplexityCalculator;

import java.util.ArrayList;
import java.util.List;

public class MethodComplexityStyler extends Styler {
    public MethodComplexityStyler() {
        style.setStyleName("method_complexity");
    }

    private List<MethodComplexity> complexityList = new ArrayList<>();

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
       MethodComplexity complexity = MethodComplexityCalculator.getInstance().calculateComplexity(ctx, parser);
        complexityList.add(complexity);
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        if (style.getProperty(null) instanceof MethodComplexityProperty targetProperty) {
            MethodComplexity complexity = MethodComplexityCalculator.getInstance().calculateComplexity(ctx, parser);
            if (complexity.isMoreComplex(targetProperty.maxComplexity)) {
                MethodExtractor.getInstance().extractMethod(ctx, parser, targetProperty);
            }
        }
        return ctx;
    }

    @Override
    public void extractFinalize() {
        List<Double> linesList = complexityList.stream().map(e -> e.lines).toList();
        List<Double> nestingDepthList = complexityList.stream().map(e -> e.nestingDepth).toList();
        List<Double> cognitiveComplexityList = complexityList.stream().map(e -> e.cognitiveComplexity).toList();

        MethodComplexity maxComplexity = new MethodComplexity();
        double maxLines = linesList.stream().mapToDouble(e -> e).max().orElse(0.0);
        double maxNestingDepth = nestingDepthList.stream().mapToDouble(e -> e).max().orElse(0.0);
        double maxCognitiveComplexity = cognitiveComplexityList.stream().mapToDouble(e -> e).max().orElse(0.0);
        maxComplexity.lines = maxLines;
        maxComplexity.nestingDepth = maxNestingDepth;
        maxComplexity.cognitiveComplexity = maxCognitiveComplexity;

        double avgLines = linesList.stream().mapToDouble(e -> e).average().orElse(0.0);
        double avgNestingDepth = nestingDepthList.stream().mapToDouble(e -> e).average().orElse(0.0);
        double avgCognitiveComplexity = cognitiveComplexityList.stream().mapToDouble(e -> e).average().orElse(0.0);
        MethodComplexity avgComplexity = new MethodComplexity();
        avgComplexity.lines = avgLines;
        avgComplexity.nestingDepth = avgNestingDepth;
        avgComplexity.cognitiveComplexity = avgCognitiveComplexity;

        style.addRule(null, new MethodComplexityProperty(maxComplexity, avgComplexity));
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleMethodDeclaration();
    }


}
