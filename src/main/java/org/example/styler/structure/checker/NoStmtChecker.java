package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoStmtChecker extends Checker{
    public NoStmtChecker(String[][] argsList) {
        super(argsList);
    }

    /**
     *
     * @param structure
     * @param args [stmt types..., placeholders...]
     * @param parser
     * @return
     */
    @Override
    protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
        Set<Integer> stmtTypes = new HashSet<Integer>();
        int index = 0;
        while (index < args.size() && !args.get(index).startsWith("$")) {
            stmtTypes.add(getStmtType(args.get(index), parser));
            ++index;
        }

        while (index < args.size()) {
            String holderName = args.get(index);
            List<ParseTree> realTrees = structure.getVNode(holderName).matchedTrees;
            for (ParseTree tree : realTrees) {
                if (tree instanceof ExtendContext ctx && stmtTypes.contains(ctx.getRuleIndex())) {
                    return false; // Found a statement in the given stmt types.
                }
            }
            ++index;
        }
        return true;
    }

    private Integer getStmtType(String stmtName, MyParser parser) {
        return switch (stmtName) {
          case "continueStmt" -> parser.getRuleContinueStmt();
          case "breakStmt" -> parser.getRuleBreakStmt();
          case "returnStmt" -> parser.getRuleReturnStmt();
            default -> -1;
        };
    }
}
