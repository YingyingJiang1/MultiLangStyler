package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;
import org.example.utils.ParseTreeUtil;

import java.util.ArrayList;
import java.util.List;

public class For2whileHandler extends Handler{
    public For2whileHandler(String[][] argsList) {
        super(argsList);
    }

    /**
     * 检查语句中是否有continue，有的话将update statement插入到continue之前
     * 注意：本类必须在{@link Exp2ExpStmtHandler}之后执行，因为只有这样`update_stmt_placeholder`才有对应的树
     * argsList:[[update_stmt_placeholder, $S, $S1...]]
     * @param structure
     * @param args
     * @param parser
     */
    @Override
    protected void doHandle(EquivalentStructure structure, List<String> args, MyParser parser) {
        List<ParseTree> updateStmts = structure.getVNode(args.get(0)).matchedTrees;
        if (updateStmts.isEmpty()) {
            return;
        }

        for (int i = 1; i < args.size(); i++) {
            List<ParseTree> loopSubStmts = structure.getVNode(args.get(i)).matchedTrees;
            for (ParseTree node : loopSubStmts) {
                if (node instanceof ExtendContext ctx) {
                    handleContinue(ctx, updateStmts, parser);
                }
            }
        }
    }

    private void handleContinue(ExtendContext node, List<ParseTree> updateStmts, MyParser parser) {
        int rule = node.getRuleIndex();
        boolean stop = parser.belongToLoop(rule) || parser.isLambdaExpression(node) ||
                parser.isTypeDeclaration(node);
        if (stop) {
            return; // 停止递归
        }

        if (parser.isContinueStmt(parser.getSpecificStmt(node))) {
            if (node.getParent() instanceof ExtendContext ctx) {
                int insertionPoint = ctx.children.indexOf(node);
                for (int i = 0; i < updateStmts.size(); i++) {
                    ctx.insertChild(insertionPoint++,
                            ParseTreeUtil.getInstance().copyTree(updateStmts.get(i), false));
                }
            }
        }

        for (ParseTree child : node.children) {
            if (parser.belongToStmt(child)) {
                handleContinue((ExtendContext) child, updateStmts, parser);
            }
        }
    }
}
