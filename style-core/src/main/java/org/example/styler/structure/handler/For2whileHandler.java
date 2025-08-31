package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.TreeNodeFactoryGetter;
import org.example.styler.structure.EquivalentStructure;
import org.example.utils.NodeUtil;
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
     * argsList:[[$S, $S1...]]
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


    /**
     * 在continue语句前添加update statements.
     * @param node
     * @param updateStmts
     * @param parser
     * @return 返回插入的语句数量
     */
    private int handleContinue(ExtendContext node, List<ParseTree> updateStmts, MyParser parser) {

        int rule = node.getRuleIndex();
        boolean stop = parser.belongToLoop(rule) || parser.isLambdaExpression(node) ||
                parser.isTypeDeclaration(node);
        if (stop) {
            return 0; // 停止递归
        }

        if (parser.isStatement(node) && parser.isContinueStmt(parser.getSpecificStmt(node))) {
            if (node.getParent() instanceof ExtendContext ctx) {
                int insertionPoint = ctx.children.indexOf(node);

                // 检查是否需要为父语句添加{}
                ExtendContext parent = ctx;
                if (!parser.isBlock(ctx)) {
                    parent = ParseTreeUtil.getInstance().encapsulateStmtWithBrace(ctx, parser);
                }
                for (int i = 0; i < updateStmts.size(); i++) {
                    parent.insertChild(insertionPoint++,
                            ParseTreeUtil.getInstance().copyTree(updateStmts.get(i), false));
                }
                return updateStmts.size();
            }
        }

        if (!parser.belongToSingleStmt(node)) {
            for (int i = 0; i < node.children.size(); i++) {
                ParseTree child = node.children.get(i);
                if (child instanceof ExtendContext) {
                    i += handleContinue((ExtendContext) child, updateStmts, parser);
                }
            }
        }
        return 0;
    }
}
