package org.example.semantic;

import com.zaxxer.sparsebits.SparseBitSet;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

public enum Scope {
    GLOBAL,
    LOCAL,
    CLASS,
    CLASS_TREE,
    PACKAGE, // CLASS_TREE + same parent directory
    ;


    public static ParseTree getScopeNode(ParseTree node, MyParser parser) {
        if (node == null) {
            return null;
        }

        ParseTree cur = node;
        do {
            if (isScopeNode(cur, parser)) {
                return cur;
            }
            cur = cur.getParent();
        } while(cur != null);
        return null;
    }

    /**
     * s1: scope of node1; s2: scope of node2
     * Returns a positive integer if s1 > s2, returns a negative integer if s1 < s2, returns 0 if s1 == s1.
     * @param node1
     * @param node2
     * @param parser
     * @return
     */
    public static int compareTo(ParseTree node1, ParseTree node2, MyParser parser) throws Exception {
        ParseTree scopeNode1 = getScopeNode(node1, parser);
        ParseTree scopeNode2 = getScopeNode(node2, parser);
        if (scopeNode1 == scopeNode2) {
            return 0;
        }

        if (isAncestor(scopeNode1, scopeNode2)) {
            return 1;
        }
        if (isAncestor(scopeNode2, scopeNode1)) {
            return -1;
        }

        throw new RuntimeException("Incomparable scopes!");
    }

    // 判断 ancestor 是否是 descendant 的祖先
    private static boolean isAncestor(ParseTree ancestor, ParseTree descendant) {
        ParseTree p = descendant.getParent();
        while (p != null) {
            if (p == ancestor) return true;
            p = p.getParent();
        }
        return false;
    }

    public static boolean isScopeNode(ParseTree node, MyParser parser) {
        if (node instanceof ExtendContext ctx){
            int ruleIndex = ctx.getRuleIndex();
            return parser.getCompoundStmts().contains(ruleIndex) || parser.belongToMethodDec(ruleIndex) ||
                    parser.isLambdaExpression(node) || parser.isTypeDeclaration(node);
        }
        return false;
    }

}
