package org.example.styler.brace;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.ExtendToken;
import org.example.style.style;
import org.example.styler.Styler;
import org.example.styler.brace.style.OptionalBraceProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OptionalBraceStyler extends Styler {
    private static Set<Integer> relevantRules = null;

    public OptionalBraceStyler() {
        style.setStyleName("optional_brace");
    }

    @Override
    public void extractStyle(ExtendContext ctx) {
        if(!parser.belongToBraceOptionalStmt(ctx.getRuleIndex())) {
            return;
        }
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if(parser.isStatement(child) && child instanceof ExtendContext stmtCtx) {
                OptionalBraceProperty property = new OptionalBraceProperty();
                if(parser.isBlock(stmtCtx)) {
                    int innerStmtRule = stmtCtx.getRuleIndex();
                    boolean braceNotOptional = innerStmtRule == parser.getRuleIfElseStmt() ||
                            ctx.getRuleIndex() == parser.getRuleIfElseStmt() && innerStmtRule == parser.getRuleIfStmt();
                    property.useBrace = stmtCtx.countChildIf(parser::isStatement) == 1 && !braceNotOptional;
                } else {
                    ParseTree preChild = ctx.getChild(i - 1);
                    int preChildLine = preChild instanceof TerminalNode ? ((TerminalNode) preChild).getSymbol().getLine() :
                            ((ExtendContext) preChild).stop.getLine();
                    property.compactStyle = (stmtCtx.start.getLine() == preChildLine);
                }
                style.addRule(null, property);
            }
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx) {
        if(!parser.belongToBraceOptionalStmt(ctx.getRuleIndex())) {
            return ctx;
        }
        OptionalBraceProperty property = (OptionalBraceProperty) style.getProperty(null);
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if(parser.isStatement(child) && child instanceof ExtendContext stmtCtx) {
                if (!parser.isBlock(stmtCtx)) {
                    ExtendToken stop = (ExtendToken) stmtCtx.stop;
                    if(!property.compactStyle) {
                        ctx.addTerNode(parser.getVws(), System.lineSeparator(), i);
                        ++i;
                    } else {
                        ExtendToken start = (ExtendToken) stmtCtx.start;
                        // Move line comment to the end of statement.
                        if(!start.trailingComment && !start.comments.isEmpty() &&
                                parser.getLineComment() == start.comments.get(start.comments.size() - 1).getType()) {
                            stop = (ExtendToken) stmtCtx.stop;
                            stop.trailingComment = true;
                            stop.comments.addAll(start.comments);
                            start.comments.clear();
                        }
                    }
                    if(!(stop.trailingComment && parser.getLineComment() == stop.comments.get(0).getType())) {
                        ctx.addTerNode(parser.getVws(), System.lineSeparator(), i + 1); // Add vws after statement
                        ++i;
                    }
                }
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
