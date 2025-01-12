package org.example.styler.declaration.location;

import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.Resolver;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.declaration.location.style.DeclarationLocationProperty;

import java.util.List;

public class DeclarationLocationStyler extends Styler {
    public DeclarationLocationStyler() {
        style.setStyleName("declaration_location");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        int i = 0;
        int blockStartCount = 0;
        int nearUseCount = 0;
        for (; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof ExtendContext stmt) {
                if (!parser.belongToVarDeclarationStmt(parser.getSpecificStmtType(stmt))) {
                    break;
                }
            }
        }

        blockStartCount = i;

        if (i + 1 < ctx.getChildCount()) {
            nearUseCount = (int) ctx.children.subList(i + 1, ctx.getChildCount()).stream()
                    .filter(child -> child instanceof ExtendContext stmt && parser.belongToVarDeclarationStmt(parser.getSpecificStmtType(stmt)))
                    .count();

        }

        Location location = null;
        if (blockStartCount > nearUseCount) {
            location = Location.BLOCK_START;
        } else if (blockStartCount < nearUseCount) {
            location = Location.NEAR_USE;
        }
        if (location != null) {
            style.addRule(null, new DeclarationLocationProperty(location));
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        if (style.getProperty(null) == null) {
            return ctx;
        }

        DeclarationLocationProperty property = (DeclarationLocationProperty) style.getProperty(null);
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof ExtendContext stmt && parser.belongToVarDeclarationStmt(parser.getSpecificStmtType(stmt))) {
                if (property.location.equals(Location.BLOCK_START)) {
                    moveToBlockStart(ctx, i, parser);
                } else if (property.location.equals(Location.NEAR_USE)) {
                    moveToFirstUse(ctx, stmt, parser);
                }
            }
        }
        return ctx;
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleBlock();
    }

    /**
     * Check whether the first statement containing the @identifierNode is in the @stmts, if true then return the index of the statement, else return -1.
     * @param stmts
     * @param identifierNode a usage identifier node
     * @return index of stmt
     */
    private int indexOfContainerStmt(List<ParseTree> stmts, ExtendContext identifierNode) {
        if (stmts.isEmpty()) {
            return -1;
        }
        ParseTree parent = identifierNode.getParent();
        while (parent != null) {
            int index = stmts.indexOf(parent);
            if (index >= 0) {
                return index;
            }
            parent = parent.getParent();
        }
        return -1;
    }

    /**
     * Move declaration statements forward until the first declaration statement is encountered or the start of the block is reached.
     * @param block
     * @param index index of declaration statement
     * @param parser
     */
    private void moveToBlockStart(ExtendContext block, int index, MyParser parser) {
        ExtendContext stmt = (ExtendContext) block.getChild(index);
        ExtendContext decStmt = parser.getSpecificStmt(stmt);
        int j = index - 1;
        for (; j >= 0; j--) {
            boolean isDecStmt = block.getChild(j) instanceof ExtendContext stmt1 && parser.belongToVarDeclarationStmt(parser.getSpecificStmtType(stmt1));
            if (isDecStmt) {
                break;
            }
        }

        int insertionPoint = j + 1;
        block.removeChildIf(child -> child == stmt);
        block.insertChild(insertionPoint, stmt);
    }

    /**
     * Move the declaration statement closest to the first use.
     * @param block
     * @param stmt declaration statement
     * @param parser
     */
    private void moveToFirstUse(ExtendContext block, ExtendContext stmt, MyParser parser) {
        ExtendContext decStmt = parser.getSpecificStmt(stmt);
        List<ExtendContext> decIdentifiers = parser.getDecStmtSearcher().searchIdentifiers(decStmt, parser);
        List<ExtendContext> declaratorList = decStmt.getAllContextsByTypeRec(parser.getRuleVariableDeclarator());
        Resolver resolver = GlobalInfo.getResolver();
        for (ExtendContext identifierNode : decIdentifiers) {
            // Get index of first statement that uses these declared variables.
            List<ExtendContext> references = resolver.resolve(identifierNode, parser).getReferences();
            int minUsingIndex =  Integer.MAX_VALUE;
            for (ExtendContext ref : references) {
                int index = indexOfContainerStmt(block.children, ref);
                if (index >= 0 && index < minUsingIndex) {
                    minUsingIndex = index;
                }
            }

            // Get the index of last statement that declares the variables used in the initializers of the declaration statement.
            int maxIndex = -1;
            ExtendContext initializer = parser.getDecStmtSearcher().searchInitializer(decStmt, identifierNode, parser);
            if (initializer != null) {
                List<ExtendContext> initializerReferences = initializer.getAllContextsByTypeRec(parser.getRuleIdentifier());
                for (ExtendContext ref : initializerReferences) {
                    ExtendContext decIdentifierNode = resolver.resolve(ref, parser).getDecIdentifierNode();
                    int index = indexOfContainerStmt(block.children, decIdentifierNode);
                    if (index >= 0 && index > maxIndex) {
                        maxIndex = index;
                    }
                }
            }

            // Move the declaration statement to the appropriate position:
            // after the last statement that declares the variables used in the declaration statement and
            // before the first statement that uses the variables that declared in the declaration statement.
            if (minUsingIndex == Integer.MAX_VALUE) {
                continue;
            }
            block.removeChildIf(child -> child == stmt);
            int insertionPoint = minUsingIndex;
            if (maxIndex >= 0 && insertionPoint < maxIndex) {
                insertionPoint = maxIndex + 1;
            }
            block.removeChildIf(child -> child == stmt);
            block.insertChild(insertionPoint, stmt);
        }
    }
}
