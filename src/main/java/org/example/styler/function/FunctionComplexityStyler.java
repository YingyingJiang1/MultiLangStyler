package org.example.styler.function;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.function.style.FunctionComplexityProperty;

import java.util.ArrayList;
import java.util.List;

public class FunctionComplexityStyler extends Styler {
    public FunctionComplexityStyler() {
        style.setStyleName("function_complexity");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        int lines = ctx.stop.getLine() - ctx.start.getLine() + 1;
        ExtendContext body = (ExtendContext) ctx.getChild(ctx.getChildCount() - 1);
        int maxNestedDepth = calculateMaxStmtNestingDepth(body, parser);

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
        ExtendContext specificStmt = (ExtendContext) parser.getSpecificStmt(node);
        int specificStmtType = specificStmt.getRuleIndex();
        boolean isSingleStmt = parser.getSingleStmts().contains(specificStmtType);
        if (isSingleStmt) {
            return 0;
        }

        boolean isControlStructure = parser.getCompoundStmts().contains(specificStmtType);
        if (isControlStructure) {
            int maxDepthOfSubStmt = 0;
            List<ExtendContext> innerStmts = new ArrayList<>();
            for (ParseTree child : specificStmt.children) {
                if (child instanceof ExtendContext ctx && parser.belongToStmt(child)) {
                    ExtendContext specificStmt1 = parser.getSpecificStmt(ctx);
                    if (specificStmt1.getRuleIndex() == parser.getRuleBlock()) {
                        innerStmts.addAll(specificStmt1.getAllContextsIf(parser::belongToStmt));
                    } else {
                        innerStmts.add(ctx);
                    }
                }
            }

            for (int i = 0; i < innerStmts.size(); i++) {
                if (parser.belongToStmt(innerStmts.get(i))) {
                    int depth = 1 + doCalculate(innerStmts.get(i), parser);
                    if (depth > maxDepthOfSubStmt) {
                        maxDepthOfSubStmt = depth;
                    }
                }
            }

            return maxDepthOfSubStmt;
        }
        return 0;
    }
}
