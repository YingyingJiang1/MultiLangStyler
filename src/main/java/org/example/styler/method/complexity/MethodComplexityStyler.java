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
                encapsulateCode(ctx, complexity, targetProperty, parser);
            }
        }
        return ctx;
    }

    @Override
    public void extractFinalize() {
        double maxLines = complexityList.stream().mapToDouble(e -> e.lines).max().orElse(0.0);
        double maxNestingDepth = complexityList.stream().mapToDouble(e -> e.nestingDepth).max().orElse(0.0);
        MethodComplexity maxComplexity = new MethodComplexity(maxLines, maxNestingDepth);

        double avgLines = complexityList.stream().mapToDouble(e -> e.lines).average().orElse(0.0);
        double avgNestingDepth = complexityList.stream().mapToDouble(e -> e.nestingDepth).average().orElse(0.0);
        MethodComplexity avgComplexity = new MethodComplexity(avgLines, avgNestingDepth);

        style.addRule(null, new MethodComplexityProperty(maxComplexity, avgComplexity));
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleMethodDeclaration();
    }



    private void encapsulateCode(ExtendContext ctx, MethodComplexity curComplexity, MethodComplexityProperty targetProperty, MyParser parser) {
        // to do: 标记代码段

        // do encapsulation
    }

}
