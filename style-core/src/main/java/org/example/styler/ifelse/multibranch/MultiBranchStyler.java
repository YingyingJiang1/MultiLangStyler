package org.example.styler.ifelse.multibranch;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.tuple.MutablePair;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.ifelse.multibranch.style.MultiBranchContext;
import org.example.styler.ifelse.multibranch.style.MultiBranchProperty;
import org.example.styler.ifelse.multibranch.style.MultiBranchStyle;

public class MultiBranchStyler extends Styler {

    public MultiBranchStyler() {
        style = new MultiBranchStyle();
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        BranchType branchType = null;
        int branchCount = 0;

        if (ctx.getRuleIndex() == parser.getRuleSwitchStmt()) {
            branchType = BranchType.SWITCH;
            ExtendContext block = (ExtendContext) ctx.getChild(ctx.getChildCount() - 1);
            if (block.stop.getText().equals("}")) {
                branchCount = ctx.getChildCount() - 2;
            } else {
                branchCount = ctx.getChildCount();
            }

        } else if (ctx.getRuleIndex() == parser.getRuleIfElseStmt()) {
            ExtendContext cur = ctx;
            ++branchCount;
            while (cur.getRuleIndex() == parser.getRuleIfElseStmt() || cur.getRuleIndex() == parser.getRuleIfStmt()) {
                ++branchCount;
                ExtendContext lastStmt = cur.getLastCtxChildIf(child -> child.getRuleIndex() == parser.getRuleStmt());
                ExtendContext condExp = cur.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleParExpression());
                ExtendContext expression = condExp.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleExpression());
                if (!checkExp(expression, parser, new MutablePair<>(null, null))) {
                    return;
                }
                cur = (ExtendContext) lastStmt.getChild(0);
            }
            branchType = BranchType.CASCADING_IF_ELSE;
        }

        if (branchType != null) {
            style.addRule(new MultiBranchContext(branchCount), new MultiBranchProperty(branchType));
        }
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        int ruleIndex = ctx.getRuleIndex();
        return ruleIndex == parser.getRuleIfElseStmt() || ruleIndex == parser.getRuleSwitchStmt();
    }

    private boolean checkExp(ExtendContext exp, MyParser parser, MutablePair<String, String> pair) {
        for (int i = 0; i < exp.getChildCount(); i++) {
            ParseTree child = exp.getChild(i);
            if (child instanceof TerminalNode ter) {
                if (ter.getText().equals("&&")) {
                    return false;
                } else if (ter.getText().equals("==")) {
                    ExtendContext subExp = null;
                    ExtendContext literal = null;
                    String left = getTextOrType(exp.getChild(i - 1), parser, pair);
                    String right = getTextOrType(exp.getChild(i + 1), parser, pair);

                    if (left == null || right == null) {
                        return false;
                    }

                    return left.equals(pair.getLeft()) && right.equals(pair.getRight()) ||
                            left.equals(pair.getRight()) && right.equals(pair.getLeft());
                } else if (!ter.getText().equals("||")) {
                    return false;
                }
            } else if (child instanceof ExtendContext ctx) {
                return checkExp(ctx, parser, pair);
            }
        }
        return true;
    }

    private String getTextOrType(ParseTree node, MyParser parser, MutablePair<String, String> pair) {
        if (node instanceof ExtendContext ctx) {
            if (ctx.getRuleIndex() == parser.getRuleExpression()) {
                if (pair.getLeft() == null) {
                    pair.setLeft(ctx.getText());
                }
                return ctx.getText();
            } else if (ctx.getRuleIndex() == parser.getRuleLiteral()) {
                int literalType = ((TerminalNode) ctx.getChild(0)).getSymbol().getType();
                if (pair.getRight() == null) {
                    pair.setRight(parser.getTokenName(literalType));
                }
               return parser.getTokenName(literalType);
            }
        }
        return null;
    }

}
