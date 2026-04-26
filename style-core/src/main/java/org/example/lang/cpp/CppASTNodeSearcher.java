package org.example.lang.cpp;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.cpp.CPPParser;
import org.example.lang.intf.ASTNodeSearcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A lightweight C++ AST node searcher based on the generated {@link CPPParser}.
 *
 * <p>Used by stylers (e.g. modifier order / declaration layout) to find:
 * - modifier/specifier tokens
 * - declared identifiers in a declaration context
 */
public class CppASTNodeSearcher implements ASTNodeSearcher {
    private static final CppASTNodeSearcher instance = new CppASTNodeSearcher();

    private CppASTNodeSearcher() {}

    public static CppASTNodeSearcher getInstance() {
        return instance;
    }

    // A conservative set of "modifier-like" specifiers in this grammar.
    // Note: C++ has many specifiers; we only include ones that are commonly treated as modifiers.
    private static final Set<Integer> MODIFIER_TOKEN_TYPES = Set.of(
            CPPParser.Static,
            CPPParser.Extern,
            CPPParser.Inline,
            CPPParser.Virtual,
            CPPParser.Explicit,
            CPPParser.Friend,
            CPPParser.Typedef,
            CPPParser.Mutable,
            CPPParser.Thread_local,
            CPPParser.Const,
            CPPParser.Volatile,
            CPPParser.Constexpr,
            CPPParser.Register
    );

    @Override
    public List<ParseTree> searchAllModifiers(ExtendContext ctx) {
        if (ctx == null) {
            return List.of();
        }

        // Prefer direct children to keep behavior similar to JavaASTNodeSearcher when used with "modifier list" like contexts.
        List<ParseTree> direct = new ArrayList<>();
        for (ParseTree child : ctx.children) {
            if (child instanceof TerminalNode t && MODIFIER_TOKEN_TYPES.contains(t.getSymbol().getType())) {
                direct.add(child);
            }
        }
        if (!direct.isEmpty()) {
            return direct;
        }

        // Fallback: collect recursively (useful when ctx is not a dedicated "modifier list" node).
        List<ParseTree> recursive = new ArrayList<>();
        for (TerminalNode t : ctx.getAllTerminalsRecIf(n -> MODIFIER_TOKEN_TYPES.contains(n.getSymbol().getType()))) {
            recursive.add(t);
        }
        return recursive;
    }

    @Override
    public List<ParseTree> searchAllDeclaredIdentifiers(ExtendContext ctx) {
        if (ctx == null) {
            return List.of();
        }

        // In this grammar, declared identifiers are carried by declaratorid -> ... -> Identifier.
        // We collect Identifier terminals that appear under declaratorid nodes.
        List<ExtendContext> declaratorIds = ctx.getAllCtxsRecIf(c -> c.getRuleIndex() == CPPParser.RULE_declaratorid);
        if (declaratorIds.isEmpty()) {
            return List.of();
        }

        Set<Integer> seenTokenIndexes = new HashSet<>();
        List<ParseTree> result = new ArrayList<>();
        for (ExtendContext declaratorId : declaratorIds) {
            for (Token tok : declaratorId.getAllTokensRec()) {
                if (tok.getType() == CPPParser.Identifier) {
                    // De-dup by token index to avoid repeats when the same node is traversed via different paths.
                    int idx = tok.getTokenIndex();
                    if (idx >= 0 && !seenTokenIndexes.add(idx)) {
                        continue;
                    }
                    // We don't have the TerminalNode here; returning the declaratorId's first matching terminal is sufficient.
                    // Use terminals recursion to find the first Identifier terminal under this declaratorid.
                    TerminalNode idNode = declaratorId.getAllTerminalsRecIf(n -> n.getSymbol().getType() == CPPParser.Identifier)
                            .stream().findFirst().orElse(null);
                    if (idNode != null) {
                        result.add(idNode);
                    }
                }
            }
        }
        return result;
    }
}

