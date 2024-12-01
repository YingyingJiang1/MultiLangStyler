package org.example.styler.structure.vtree;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.MyParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VirtualNodeMatcher {
    private static Map<Class, VirtualNodeMatcher> instances = new HashMap<>(0);
    private static Map<String, Set<Integer>> matchRules = new HashMap<>();
    private static Map<String, Set<Integer>> matchTokens = new HashMap<>();

    private VirtualNodeMatcher(MyParser parser) {
        init(parser);
    }

    public static VirtualNodeMatcher getInstance(MyParser parser) {
        VirtualNodeMatcher ret = instances.get(parser.getClass());
        if (ret == null) {
            ret = new VirtualNodeMatcher(parser);
            instances.put(parser.getClass(), ret);
        }
        return ret;
    }


    public boolean isMatched(String type, ParseTree tree, MyParser parser) {
        init(parser);
        if (tree instanceof TerminalNode) {
            if (tree.getText().equals(";") && type.equals("$S")) {
                return true;
            }
            return matchTokens.get(type) != null && matchTokens.get(type).contains(((TerminalNode) tree).getSymbol().getType());
        } else {
            int rule = ((ExtendContext) tree).getRuleIndex();
            Set<Integer> rules = matchRules.get(type);
            return rules != null && rules.contains(rule);
        }
    }

    private static void init(MyParser parser) {
        matchRules.put("$I", Set.of(parser.getRuleIdentifier()));
        matchRules.put("$C", Set.of(parser.getRuleExpression()));
        matchRules.put("$E", Set.of(parser.getRuleExpression()));
        matchRules.put("$S", parser.getAllStmts());
        matchRules.put("$T", Set.of(parser.getRuleTypeType()));
        matchRules.put("$M", Set.of(parser.getRuleModifierList()));

        matchRules.put("$S(ifStmt)", Set.of(parser.getRuleIfStmt()));
        matchRules.put("$S(ifElseStmt)", Set.of(parser.getRuleIfElseStmt()));

        matchTokens.put("$I", Set.of(parser.getIdentifier()));
        matchTokens.put("$HOMO_BOP", parser.getHomoOps());
        matchTokens.put("$HOMO_BOP_ASSIGN", parser.getOpAssign());
        matchTokens.put("$LITERAL", parser.getLiterals());
    }
}
