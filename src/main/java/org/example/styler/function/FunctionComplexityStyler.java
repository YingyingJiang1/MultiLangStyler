package org.example.styler.function;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.function.style.FunctionComplexityProperty;

import java.util.List;

public class FunctionComplexityStyler extends Styler {
    public FunctionComplexityStyler() {
        style.setStyleName("function_complexity");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        int lines = ctx.stop.getLine() - ctx.start.getLine() + 1;
        ExtendContext body = (ExtendContext) ctx.getChild(ctx.getChildCount() - 1);
        int maxNestedDepth = calculateMaxStmtNestingDepth(ctx, parser);

        List<StyleProperty> properties = style.getProperties(null);
        if (properties != null) {
            FunctionComplexityProperty property = (FunctionComplexityProperty) properties.get(0);
            if (lines > property.maxLines) {
                property.maxLines = lines;
            }
            if (maxNestedDepth > property.maxNestingDepth) {
                property.maxNestingDepth = maxNestedDepth;
            }
        } else {
            style.addRule(null, new FunctionComplexityProperty(lines, maxNestedDepth));
        }
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleMethodDeclaration();
    }

    private int calculateMaxStmtNestingDepth(ExtendContext block, MyParser parser) {
        int maxDepth = 0;
        for (ParseTree child : block.children) {
            if (parser.belongToStmt(child)) {
                int depth = doCalculate((ExtendContext) child, parser);
                if (depth > maxDepth) {
                    maxDepth = depth;
                }
            }
        }
        return maxDepth;
    }

    // 遍历语法树
    private int doCalculate(ExtendContext node, MyParser parser) {
        boolean isSingleStmt = parser.getSingleStmts().contains(node.getRuleIndex());
        if (isSingleStmt) {
            return 1;
        }

        boolean isControlStructure = parser.getCompoundStmts().contains(node.getRuleIndex());
        if (isControlStructure) {
            int maxDepthOfSubStmt = 0;
            for (int i = 0; i < node.getChildCount(); i++) {
                if (parser.belongToStmt(node.getChild(i))) {
                    int depth = doCalculate((ExtendContext) node.getChild(i), parser);
                    if (depth > maxDepthOfSubStmt) {
                        maxDepthOfSubStmt = depth;
                    }
                }
            }

            return maxDepthOfSubStmt + 1;
        }
        return -1; // Exception
    }
}
