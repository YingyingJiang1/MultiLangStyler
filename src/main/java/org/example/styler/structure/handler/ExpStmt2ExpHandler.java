package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.common.factory.TreeNodeFactoryGetter;
import org.example.parser.common.factory.context.TreeNodeFactory;
import org.example.styler.structure.EquivalentStructure;

import java.util.ArrayList;
import java.util.List;

public class ExpStmt2ExpHandler extends Handler{

    public ExpStmt2ExpHandler(String[][] argsList) {
        super(argsList);
    }

    /**
     * args: [[from, to, $S(expStmt), $E/$E_LIST]]
     * When transform from `from` to `to`, transform the matched trees of $S(expStmt) to expressions and move them into
     * the matched trees of $E/$E_LIST.
     */
    @Override
    public void handle(EquivalentStructure structure, int from, int to, MyParser parser) {
        for (String[] args : argsList) {
            if (args.length < 4) {
                logger.error("Arguments of ExpStmt2ExpHandler error: length < 4");
                continue;
            }
            int index1 = Integer.parseInt(args[0]);
            int index2 = Integer.parseInt(args[1]);
            if (index1 == from && index2 == to) {
                String expStmtHolderName = args[2];
                String expHolderName = args[3];
                List<ParseTree> expStmtList = structure.getVNode(expStmtHolderName).matchedTrees;
                List<ExtendContext> expressionList = new ArrayList<>();
                for (ParseTree tree : expStmtList) {
                    ExtendContext expStmt = (ExtendContext) tree;
                    if (parser.isStatement(tree)) {
                        expStmt = (ExtendContext) tree.getChild(0);
                    }
                    ExtendContext expression = expStmt.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleExpression());
                    expressionList.add(expression);
                }

                structure.getVNode(expStmtHolderName).matchedTrees.clear();
                if (expHolderName.startsWith("$E_LIST")) {
                    structure.getVNode(expHolderName).matchedTrees.add(toExpListNode(expressionList, parser));
                } else if (expHolderName.startsWith("$E")) {
                    structure.getVNode(expHolderName).matchedTrees.addAll(expressionList);
                }
            }
        }
    }

    private ExtendContext toExpListNode(List<ExtendContext> expressionList, MyParser parser) {
        TreeNodeFactory factory = TreeNodeFactoryGetter.getFactory(parser);
        ExtendContext expressionListNode = factory.createExpressionList(null);
        List<ParseTree> children = new ArrayList<>();
        if (expressionList.isEmpty()) {
            return expressionListNode;
        }

        children.add(expressionList.get(0));
        for (int i = 1; i < expressionList.size(); i++) {
            TerminalNode comma = factory.createTerminal(parser.getTokenFactory().create(parser.getComma(), ","));
            children.add(comma);
            children.add(expressionList.get(i));
        }
        expressionListNode.addChildren(children);
        return expressionListNode;
    }

}
