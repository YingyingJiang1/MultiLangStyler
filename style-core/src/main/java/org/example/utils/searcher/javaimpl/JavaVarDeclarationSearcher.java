package org.example.utils.searcher.javaimpl;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.utils.searcher.intf.VarDeclarationSearcher;

import java.util.ArrayList;
import java.util.List;

public class JavaVarDeclarationSearcher implements VarDeclarationSearcher {
    public JavaVarDeclarationSearcher() {}


    public List<ExtendContext> searchIdentifiers(ExtendContext decNode, MyParser parser) {
        List<ExtendContext> result = new ArrayList<>();
        List<ExtendContext> declaratorList = decNode.getAllCtxsRecIf(parser::isVariableDeclaratorId);
        for (ExtendContext declarator : declaratorList) {
            ExtendContext identifierNode = declarator.getFirstCtxChildIf(parser::isIdentifier);
            result.add(identifierNode);
        }
        return result;
    }

    @Override
    public ExtendContext searchInitializerNode(ExtendContext decNode, ExtendContext identifier, MyParser parser) {
        if (identifier.parent.parent instanceof ExtendContext ctx) {
            return ctx.getFirstCtxChildIf(parser::isVariableInitializer);
        }
        return null;
    }

    @Override
    public ParseTree searchTypeNode(ExtendContext decNode, MyParser parser) {
        ExtendContext targetNode = getTargetNode(decNode, parser);
        for (ParseTree child : targetNode.children) {
            if (child instanceof TerminalNode) {
                if (child.getText().equals("var")) {
                    return child;
                }
            } else if (child instanceof ExtendContext extChild && parser.getRuleTypeType() == extChild.getRuleIndex()) {
                return child;
            }
        }
        return null;
    }

    @Override
    public ExtendContext searchVarDeclaratorsNode(ExtendContext decNode, MyParser parser) {
        ExtendContext targetNode = getTargetNode(decNode, parser);
        return targetNode.getFirstInnerChildByType(parser.getRuleVariableDeclarators());
    }

    @Override
    public List<TerminalNode> searchModifiers(ExtendContext decNode, MyParser parser) {
        ExtendContext targetNode = getTargetNode(decNode, parser);
        ExtendContext modifierListNode = targetNode.getFirstInnerChildByType(parser.getRuleModifierList());
        return modifierListNode == null ? new ArrayList<>() : modifierListNode.getAllTerminalsRecIf(t -> true);
    }

    @Override
    public List<ExtendContext> searchVarDeclaratorList(ExtendContext decNode, MyParser parser) {
        ExtendContext targetNode = getTargetNode(decNode, parser);
        ExtendContext declarators = targetNode.getFirstInnerChildByType(parser.getRuleVariableDeclarators());
        return declarators.getAllChildContextsIf(e -> e.getRuleIndex() == parser.getRuleVariableDeclarator());
    }

    private ExtendContext getTargetNode(ExtendContext node, MyParser parser) {
        if (node.getRuleIndex() == parser.getRuleFieldDeclaration() ||
        node.getRuleIndex() == parser.getRuleLocalVarDeclaration()) {
            return node;
        }
        return node.getFirstContextRecIf(parser::isLocalVarDeclaration);
    }
}
