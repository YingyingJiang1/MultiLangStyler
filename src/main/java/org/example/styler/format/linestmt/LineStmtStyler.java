package org.example.styler.format.linestmt;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.ExtendToken;
import org.example.styler.Styler;
import org.example.styler.format.linestmt.style.LineStmtProperty;

import java.util.HashSet;
import java.util.Set;

public class LineStmtStyler extends Styler {
    private static Set<Integer> relevantRules = null;

    public LineStmtStyler() {
        style.setStyleName("line_stmt");
    }

    /**
     * @implNote One-way application.
     * @param ctx
     * @return
     */
    @Override
    public ExtendContext applyStyle(ExtendContext ctx) {
        LineStmtProperty property = (LineStmtProperty) style.getProperty(null);
        if (property.isOneStmtPerLine) {
            for (int i = 0; i < ctx.getChildCount() - 1; i++) {
                ParseTree cur = ctx.getChild(i), next = ctx.getChild(i + 1);
                if (parser.belongToStmt(cur) && parser.belongToStmt(next)) {
                    if (((ExtendContext) cur).stop.getLine() == ((ExtendContext) next).start.getLine()) {
                        ExtendToken token = (ExtendToken) ((ExtendContext) cur).stop;
                        token.setText(token.getText() + System.lineSeparator());
                    }
                }
            }
        }
        return ctx;
    }

    @Override
    public void extractStyle(ExtendContext ctx) {
        boolean oneStmtPerLine = true;
        for (int i = 0; i < ctx.getChildCount() - 1; i++) {
            ParseTree cur = ctx.getChild(i), next = ctx.getChild(i + 1);
            if (parser.belongToStmt(cur) && parser.belongToStmt(next)) {
                if (((ExtendContext) cur).stop.getLine() == ((ExtendContext) next).start.getLine()) {
                    oneStmtPerLine = false;
                    break;
                }
            }
        }
        style.addRule(null, new LineStmtProperty(oneStmtPerLine));
    }

    @Override
    protected Set<Integer> getRelevantRules() {
        if (relevantRules == null) {
            relevantRules = new HashSet<>();
            relevantRules.add(parser.getRuleBlock());
            relevantRules.add(parser.getRuleBody());
        }
        return relevantRules;
    }

}
