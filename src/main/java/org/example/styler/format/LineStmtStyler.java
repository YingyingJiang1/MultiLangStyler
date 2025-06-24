package org.example.styler.format;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.style.LineStmtContext;
import org.example.styler.format.style.LineStmtStyle;
import org.example.styler.format.style.NewlineProperty;

import java.util.Set;

public class LineStmtStyler extends Styler {
    private static Set<Integer> relevantRules = null;

    public LineStmtStyler() {
        style = new LineStmtStyle();
    }

    @Override
    public void extractFinalize() {
        // Add a rule representing there is a newline between two single statements.
        style.addRule(LineStmtContext.DEFAULT, new NewlineProperty(1));
        super.extractFinalize();
    }

    /**
     * @param ctx
     * @param parser
     * @return
     * @implNote One-way application.
     */
    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext firstStmtChild = ctx.getFirstCtxChildIf(parser::belongToStmt);
        if (firstStmtChild == null) {
            return ctx;
        }

        int indentionLength = firstStmtChild.start.getCharPositionInLine();
        int curLength =  indentionLength;
        for (int i = 0; i < ctx.getChildCount() - 1; i++) {
            ParseTree cur = ctx.getChild(i), next = ctx.getChild(i + 1);
            if (parser.belongToSingleStmt(cur) && (parser.belongToSingleStmt(next) || next instanceof TerminalNode)) {
                ExtendContext curCtx = (ExtendContext) cur;
                int stmtLength = curCtx.stop.getCharPositionInLine() + curCtx.stop.getText().length() - curCtx.start.getCharPositionInLine();
                curLength += stmtLength;

                StyleProperty property = style.getSimilarProperty(new LineStmtContext(curLength));
                if (property instanceof NewlineProperty newlineProperty) {
                    if (newlineProperty.newlines == 1 && curCtx.stop instanceof ExtendToken extStopToken && !extStopToken.hasTrailingComment) {
                        Token vws = parser.getTokenFactory().create(parser.getVws(), System.lineSeparator());
                        extStopToken.addTokenAfter(vws, parser);
                        curLength = indentionLength;
                    }
                }

            }
        }
        return ctx;
    }

    // Only extract the max sum text length of single statements in one line.
    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        int maxTextLengthInLine = 0, textLengthInLine = 0;
        for (int i = 0; i < ctx.getChildCount() - 1; i++) {
            ParseTree cur = ctx.getChild(i), next = ctx.getChild(i + 1);
            if (parser.belongToSingleStmt(cur) && parser.belongToSingleStmt(next)) {
                ExtendContext curCtx = (ExtendContext) cur, nextCtx = (ExtendContext) next;
                if (curCtx.stop.getLine() == nextCtx.start.getLine()) {
                    textLengthInLine = nextCtx.stop.getCharPositionInLine() + nextCtx.stop.getText().length();
                } else {
                    textLengthInLine = 0;
                }

                if (textLengthInLine > maxTextLengthInLine) {
                    maxTextLengthInLine = textLengthInLine;
                }
            }
        }

        // If the max text length is not zero, add a rule to style the max text length in one line.
        if (maxTextLengthInLine > 0) {
            if (style.getRules().isEmpty()) {
                style.addRule(new LineStmtContext(maxTextLengthInLine), new NewlineProperty(0));
            } else {
                if (style.getRules().get(0).getStyleContext() instanceof LineStmtContext context && context.maxTextLength < maxTextLengthInLine) {
                    style.remove(context);
                    style.addRule(new LineStmtContext(maxTextLengthInLine), new NewlineProperty(0));
                }
            }
        }
    }


    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        int ruleIndex = ctx.getRuleIndex();
        return parser.getRuleBlock() == ruleIndex || parser.getRuleFieldDeclarationList() == ruleIndex;
    }

}
