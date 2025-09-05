package org.example.styler.format.body.optionalbrace;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.RunStatistic;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.TreeNodeFactoryGetter;
import org.example.parser.common.factory.context.TreeNodeFactory;
import org.example.styler.format.body.BodyContext;
import org.example.styler.format.body.BodySizeType;
import org.example.styler.format.body.BodyStyler;
import org.example.styler.format.body.optionalbrace.style.OptionalBraceProperty;

import java.util.*;
import java.util.ArrayList;

public class OptionalBraceStyler extends BodyStyler {
    private static Set<Integer> relevantRules = null;

    public OptionalBraceStyler() {
        style.setStyleName("optional_brace");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext specificStmt = parser.getSpecificStmt(ctx);
        List<ParseTree> bodies = specificStmt.children.stream().filter(parser::belongToStmt).toList();
        for (ParseTree body : bodies) {
            // Empty statement only has a semi token, which is a terminal node.
            ExtendContext specificBody = parser.getSpecificStmt((ExtendContext) body);
            // Only consider the body has one statement.
            BodyContext bodyContext = extractStyleContext(ctx, specificBody, parser);
            if (bodyContext.bodySizeType != BodySizeType.MULTI) {
                boolean useBrace = parser.isBlock(specificBody);
                style.addRule(bodyContext, new OptionalBraceProperty(useBrace));
            }
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext specificStmt = parser.getSpecificStmt(ctx);
        List<ParseTree> bodies = specificStmt.children.stream().filter(parser::belongToStmt).toList();

        for (ParseTree body : bodies) {
            // Empty statement only has a semi token, which is a terminal node.
            ExtendContext specificBody = parser.getSpecificStmt((ExtendContext) body);
            // Only consider the body has one statement.
            BodyContext bodyContext = extractStyleContext(ctx, specificBody, parser);
            OptionalBraceProperty property = (OptionalBraceProperty) style.getProperty(bodyContext);

            if (property == null) {
                continue;
            }
            if (property.useBrace && !parser.isBlock(specificBody)) {
                // Add {}
                TreeNodeFactory factory = TreeNodeFactoryGetter.getFactory(parser);
                ExtendContext block = factory.createBlock((ExtendContext) body.getParent());
                TerminalNode lb = factory.createTerminal(parser.getTokenFactory().create(parser.getLBrace(), "{"));
                TerminalNode rb = factory.createTerminal(parser.getTokenFactory().create(parser.getRBrace(), "}"));
                List<ParseTree> children = new ArrayList<>();
                children.add(lb);
                children.add(body);
                children.add(rb);
                block.addChildren(children);
                ctx.replaceChild(body, block);

                RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
            } else if (!property.useBrace) {
                // Removing {} happens when the bodyNumType is EMPTY or SINGLE. Otherwise, it may cause an error.
                boolean isBraceRemovable = parser.isBlock(specificBody) && (bodyContext.bodySizeType == BodySizeType.EMPTY || bodyContext.bodySizeType == BodySizeType.SINGLE);
                if (isBraceRemovable) {
                    ctx.replaceChild(body, specificBody.getFirstCtxChildIf(t -> true));

                    RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                }
            }
        }

        return ctx;
    }

    @Override
    protected Set<Integer> getRelevantRules(MyParser parser) {
        if (relevantRules == null) {
            relevantRules = new HashSet<>(parser.getBraceOptionalStmtRules());
        }
        return relevantRules;
    }

}
