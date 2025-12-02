package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;

import org.example.styler.structure.EquivalentStructure;

import java.util.ArrayList;
import java.util.List;

public class Exp2ExpStmtHandler extends Handler{
    public Exp2ExpStmtHandler(String[][] argsList) {
        super(argsList);
    }


    /**
     * args: [[$E/$E_LIST, $S(expStmt)]]
     * When transform from `from` to `to`, transform the matched trees of $E/$E_LIST to expression statements and move them into
     * the matched trees of $S(expStmt)
     */
    @Override
    protected void doHandle(EquivalentStructure structure, List<String> args, MyParser parser) {
        if (args.size() < 2) {
            logger.error("Arguments error in {}.doHandle: at least 2 arguments required.", this.getClass().getName());
            return;
        }
        String expHolderName = args.get(0);
        String expStmtHolderName = args.get(1);
        List<ParseTree> expList = structure.getVNode(expHolderName).matchedTrees;
        List<ParseTree> expStmtList = new ArrayList<>();

        for (ParseTree tree : expList) {
            if (tree instanceof ExtendContext ctx) {
                if (ctx.getRuleIndex() == parser.getRuleExpression()) {
                    expStmtList.add(toExpStmt(ctx, parser));
                } else if (ctx.getRuleIndex() == parser.getRuleExpressionList()) {
                    for (ParseTree child : ctx.children) {
                        if (child instanceof ExtendContext childCtx) {
                            expStmtList.add(toExpStmt(childCtx, parser));
                        }
                    }
                }
            }
        }

        structure.getVNode(expHolderName).matchedTrees.clear();
        structure.getVNode(expStmtHolderName).matchedTrees.addAll(expStmtList);
    }

    private ExtendContext toExpStmt(ExtendContext expression, MyParser parser) {
        ParseTree expStmt =  LangAdapterCreator.createParser(parser.getLanguage()).parseFromString("a=b;");
        if (expStmt instanceof ExtendContext stmt) {
            ExtendContext parent = stmt;
            ExtendContext expCtx = parent.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleExpression());
            if (expCtx == null) {
                parent = (ExtendContext) stmt.getChild(0);
                expCtx = parent.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleExpression());
            }

            if (expCtx != null) {
                parent.replaceChild(expCtx, expression);
                return stmt;
            }
        }
        return null;
    }
}
