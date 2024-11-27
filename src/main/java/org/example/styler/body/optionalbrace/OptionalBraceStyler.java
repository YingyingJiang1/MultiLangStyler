package org.example.styler.body.optionalbrace;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.factory.ExtendTokenFactory;
import org.example.parser.common.ParseTreeFactory;
import org.example.parser.common.factory.TreeNodeFactoryGetter;
import org.example.parser.common.factory.context.TreeNodeFactory;
import org.example.parser.java.antlr.JavaParser;
import org.example.styler.body.BodyContext;
import org.example.styler.body.BodyNumType;
import org.example.styler.body.BodyStyler;
import org.example.styler.body.optionalbrace.style.OptionalBraceProperty;

import java.util.*;
import java.util.ArrayList;

public class OptionalBraceStyler extends BodyStyler {
    private static Set<Integer> relevantRules = null;

    public OptionalBraceStyler() {
        style.setStyleName("optional_brace");
    }

    @Override
    public void extractStyle(ExtendContext ctx) {
        int bodyIndex = ctx.indexOfIf(child -> parser.belongToStmt(child) ||parser.isBlock(child));
        if (bodyIndex >= 0) {
            ExtendContext body = (ExtendContext) ctx.getChild(bodyIndex);
            List<ParseTree> innerStmts = body.children.stream().filter(parser::belongToStmt).toList();
            // Only consider the body has one statement.
            if (innerStmts.size() == 1) {
                boolean useBrace = parser.isBlock(innerStmts.get(0));
                style.addRule(extractStyleContext(ctx, body), new OptionalBraceProperty(useBrace));
            }
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx) {
        int bodyIndex = ctx.indexOfIf(child -> parser.belongToStmt(child) || parser.isBlock(child));
        if (bodyIndex >= 0) {
            ExtendContext body = (ExtendContext) ctx.getChild(bodyIndex);
            BodyContext context = extractStyleContext(ctx, body);
            OptionalBraceProperty property = (OptionalBraceProperty) style.getProperty(context);
            if (property.useBrace && body.getRuleIndex() != parser.getRuleBlock()) {
                // Add {}
                TreeNodeFactory factory = TreeNodeFactoryGetter.getFactory(parser);
                ExtendContext block = factory.createBlock(ctx);
                TerminalNode lb = factory.createTerminal(parser.getTokenFactory().create(parser.getLBrace(), "{"));
                TerminalNode rb = ParseTreeFactory.createTerminalNode(parser.getTokenFactory().create(parser.getRBrace(), "}"));
                List<ParseTree> children = new ArrayList<>();
                children.add(lb);
                children.add(body);
                children.add(rb);
                block.addChildren(children);
                ctx.replaceChild(body, block);
            } else if (body.getRuleIndex() == JavaParser.RULE_block &&
                    (context.bodyNumType == BodyNumType.EMPTY || context.bodyNumType == BodyNumType.SINGLE)) {
                // Removing {} happens when the bodyNumType is EMPTY or SINGLE. Otherwise, it may cause an error.
                body.removeChildIf(child -> child instanceof TerminalNode ter && parser.belongToBrace(ter.getSymbol().getType()));
            }
        }
        return ctx;
    }

    @Override
    protected Set<Integer> getRelevantRules() {
        if (relevantRules == null) {
            relevantRules = new HashSet<Integer>(List.of(
                    parser.getRuleIfStmt(), parser.getRuleIfElseStmt(),
                    parser.getRuleForStmt(), parser.getRuleWhileStmt()
            ));
        }
        return relevantRules;
    }
}
