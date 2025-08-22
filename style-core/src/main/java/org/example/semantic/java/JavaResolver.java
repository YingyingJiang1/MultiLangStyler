package org.example.semantic.java;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.SymbolTable;
import org.example.semantic.SymbolTableManager;
import org.example.semantic.intf.Resolver;
import org.example.semantic.intf.symbol.ClassSym;
import org.example.semantic.intf.symbol.FunctionSym;
import org.example.semantic.intf.symbol.Symbol;
import org.example.semantic.intf.symbol.VarSym;
import org.example.semantic.intf.type.PrimitiveType;
import org.example.semantic.intf.type.ReferenceType;
import org.example.semantic.intf.type.Type;
import org.example.styler.naming.NameType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class JavaResolver implements Resolver {
    public static Logger logger = LoggerFactory.getLogger(JavaResolver.class);


    /**
     * note: the references of the returned symbol may not be resolved.
     * @param identifierNode
     * @param parser
     * @return symbol
     */
    @Override
    public Symbol resolve(ExtendContext identifierNode, MyParser parser) {
        ParseTree root = parser.getRoot();
        Symbol ret = null;

        // Resolve all identifiers in current ast.
        SymbolTable st = SymbolTableManager.getSymbolTable(parser);
        if (st == null) {
            st = resolveAll(root, parser);
            SymbolTableManager.addSymbolTable(root, st);
        }

        return st.getSymbol(identifierNode, parser);
    }

    @Override
    public SymbolTable resolveAll(ParseTree root, MyParser parser) {
        if (root instanceof ExtendContext ctx) {
            SymbolTable st = new SymbolTable();
            doResolveRec(st, ctx, parser);

            // Resolve reference type for variables.
            for (Symbol symbol : st.getAllSymbols()) {
                if (symbol instanceof VarSym varSym && varSym.getType() != null) {
                    if (varSym.getType() instanceof ReferenceType referenceType && referenceType.getSymbol() == null) {
                        referenceType.setSymbol(st.getSymbol((ExtendContext) referenceType.getAstNode(), parser));
                    }
                }
            }
            return st;
        }
        return null;
    }


    @Override
    public SymbolTable getSymbolTable(MyParser parser) {
        return SymbolTableManager.getSymbolTable(parser);
    }


    private void doResolveRec(SymbolTable st, ExtendContext node, MyParser parser) {
        if (parser.isIdentifier(node)) {
            doResolve(st, node, parser);
        } else {
            for (ParseTree child : node.children) {
                if (child instanceof ExtendContext) {
                    doResolveRec(st, (ExtendContext) child, parser);
                }
            }
        }
    }


    private Symbol doResolve(SymbolTable st, ExtendContext identifierNode, MyParser parser) {
        Symbol symbol = null;
        if (!parser.isIdentifier(identifierNode) || identifierNode.getParent() == null) {
            return null;
        }

        ExtendContext parent = (ExtendContext) identifierNode.getParent();
        if (isFunctionIdentifier(identifierNode, parser)) {
            symbol = resolveFunctionDeclaration(parent, identifierNode, parser);
        } else if (isTypeDecIdentifier(identifierNode, parser)){
            symbol = resolveTypeDeclaration(st, parent, identifierNode, parser);
        }else if(isVarDecIdentifier(identifierNode, parser)) {
            symbol = resolveVarDeclaration(identifierNode, parser);
        } else if(isParaIdentifier(identifierNode, parser)) {
            symbol = resolveParameter(parent, identifierNode, parser);
        } else if (isReference(identifierNode, parser)) {
            resolveReference(st, identifierNode, parser);
        } else if (parser.isTypeParameter(parent)) {
            symbol = resolveTypeParameter(parent, identifierNode, parser);
        }

        if (symbol != null) {
            st.addSymbol(symbol, parser);
        }
        return symbol;
    }

    private boolean isReference(ExtendContext identifierNode, MyParser parser) {
        boolean isTypeType = identifierNode.getFirstParentIf(parser::isTypeType) != null;
        return isTypeType || parser.getRuleExpression() == identifierNode.getParent().getRuleIndex();
    }

    private boolean isFunctionIdentifier(ExtendContext identifierNode, MyParser parser) {
        return parser.belongToMethodHead(identifierNode.getParent().getRuleIndex());
    }

    private boolean isTypeDecIdentifier(ExtendContext identifierNode, MyParser parser) {
        return identifierNode.getParent() != null && identifierNode.getParent().getParent() != null &&
                parser.isTypeDeclaration(identifierNode.getParent().getParent());
    }

    private boolean isVarDecIdentifier(ExtendContext identifierNode, MyParser parser) {
        boolean isDynamicType = identifierNode.getParent() != null && parser.isIdentifier(identifierNode.getParent());
        return isDynamicType || parser.isVariableDeclaratorId(identifierNode.getParent())
                && identifierNode.findFirstParentIf(node -> parser.isLocalVarDeclaration(node) || parser.isFieldDeclaration(node)) != null;
    }

    private boolean isParaIdentifier(ExtendContext identifierNode, MyParser parser) {
        ExtendContext parent = (ExtendContext) identifierNode.getParent();
        boolean isLambdaPara = parser.isLambdaLVTIParameter(parent) || parser.isLambdaParameters(parent);
        return isLambdaPara || parser.isVariableDeclaratorId(parent);
    }

    private Type resolveType(ExtendContext typeNode, MyParser parser) {
        if (typeNode == null) {
            return  null;
        }

        ExtendContext specificTypeNode = typeNode.getFirstCtxChildIf(child -> parser.isPrimitiveType(child) || parser.isReferenceType(child));
        if (parser.isPrimitiveType(specificTypeNode)) {
            return new PrimitiveType(typeNode, specificTypeNode.getText());
        } else if(parser.isReferenceType(specificTypeNode)) {
            return new ReferenceType(typeNode, null);
        }
        return null;
    }


    private Symbol resolveParameter(ExtendContext decNode, ExtendContext identifier, MyParser parser) {
        NameType nameType = NameType.PARAMETER;
        ExtendContext modifierList = decNode.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleModifierList());
        ExtendContext typeNode = decNode.getFirstCtxChildIf(parser::isTypeType);
        Type type = resolveType(typeNode, parser);
        VarSym symbol = new VarSym(type, identifier, modifierList, nameType);
        return symbol;
    }

    private List<Symbol> resolveTypeParameters(ExtendContext headContext, MyParser parser) {
        ExtendContext typeParametersNode = headContext.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleTypeParameters());
        List<Symbol> typeParameters = new ArrayList<>();
        if (typeParametersNode != null) {
            typeParametersNode.children.forEach(child -> {
                if (parser.isTypeParameter(child)) {
                    ExtendContext childCtx = (ExtendContext) child;
                    typeParameters.add(resolveTypeParameter(childCtx, childCtx, parser));
                }
            });
        }
        return typeParameters;
    }

    private Symbol resolveTypeDeclaration(SymbolTable st, ExtendContext headContextNode, ExtendContext identifier, MyParser parser) {
        NameType nameType = NameType.TYPE;
        ExtendContext modifierList = headContextNode.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleModifierList());
        List<Symbol> typeParameters = resolveTypeParameters(headContextNode, parser);

        // resolve parents
        List<ExtendContext> typeNodeofParents = new ArrayList<>();
        for (ParseTree child : headContextNode.children) {
            if (child instanceof ExtendContext ctx ) {
                if (ctx.getRuleIndex() == parser.getRuleTypeType()) {
                    typeNodeofParents.add(ctx);
                } else if (ctx.getRuleIndex() == parser.getRuleTypeList()) {
                    typeNodeofParents.addAll(ctx.getAllChildContextsIf(child1 -> child1.getRuleIndex() == parser.getRuleTypeType()));
                }
            }
        }

        // resolve outer class.
        Symbol outerClass = null;
        ParseTree parent = headContextNode.getParent();
        while (!parser.isTypeDeclaration(parent)) {
            if (parent == null) {
                break;
            }
            parent =  parent.getParent();
        }
        if (parser.isTypeDeclarationList(parent)) {
            ExtendContext identifierNode = headContextNode.getFirstCtxChildIf(parser::isIdentifier);
            outerClass = st.getSymbol(identifierNode, parser);
        }

        String path = findPathOfClass(headContextNode, parser);
        Symbol symbol = new ClassSym(typeNodeofParents, path, typeParameters, outerClass, identifier, modifierList, nameType);
        return symbol;
    }

    private String findPathOfClass(ExtendContext decNode, MyParser parser) {
        ParseTree parent = decNode.getParent();
        while (parent != null) {
            if (parent instanceof ExtendContext ctx && ctx.getRuleIndex() == parser.getRuleCompilationUnit()) {
                ExtendContext packageDec = ctx.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRulePackageDeclaration());
                if (packageDec != null) {
                    return packageDec.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleQualifiedName()).getText();
                }
            }
            parent =  parent.getParent();
        }
        return null;
    }

    private Symbol resolveFunctionDeclaration(ExtendContext headContextNode, ExtendContext identifier, MyParser parser) {
        ExtendContext modifierList = headContextNode.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleModifierList());
        ExtendContext typeNode = headContextNode.getFirstCtxChildIf(parser::isTypeType);
        NameType nameType = typeNode == null ? NameType.CONSTRUCTOR : NameType.METHOD;
        Type retType = resolveType(typeNode, parser);
        List<Symbol> typeParameters = resolveTypeParameters(headContextNode, parser);

        Symbol symbol = new FunctionSym(retType,typeParameters, identifier, modifierList, nameType);
        return symbol;
    }

    private Symbol resolveVarDeclaration(ExtendContext identifier, MyParser parser) {
        ExtendContext decNode = identifier.findFirstParentIf(node -> parser.isLocalVarDeclaration(node) || parser.isFieldDeclaration(node));
        NameType nameType = parser.isFieldDeclaration(decNode) ? NameType.FIELD : NameType.LOCAL_VARIABLE;
        ExtendContext modifierList = decNode.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleModifierList());
        ExtendContext typeNode = decNode.getFirstCtxChildIf(parser::isTypeType);
        Type type = resolveType(typeNode, parser);
        Symbol symbol = new VarSym(type, identifier, modifierList, nameType);
        return symbol;
    }


    private void resolveReference(SymbolTable st, ExtendContext identifier, MyParser parser) {
        Symbol symbol = st.getSymbol(identifier, parser);
        if (symbol == null) {
//            logger.warn("symbol '{}' is has no resolved symbol.", identifier.getText());
            return;
        }
        symbol.addReference(identifier);
    }

    private Symbol resolveTypeParameter(ExtendContext typeParameterNode, ExtendContext identifier, MyParser parser) {
        if (typeParameterNode == null) {
            return null;
        }
        return new VarSym(null, identifier, null, NameType.TYPE_PARAMETER);
    }

//    private ExtendContext getHeadContext(ParseTree decNode) {
//        if (decNode instanceof ExtendContext ctx) {
//            return (ExtendContext) decNode.getChild(1);
//        }
//        return null;
//    }

}
