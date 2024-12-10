package org.example.semantic;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.Resolver;
import org.example.semantic.intf.symbol.ClassSym;
import org.example.semantic.intf.symbol.FunctionSym;
import org.example.semantic.intf.symbol.Symbol;
import org.example.semantic.intf.symbol.VarSym;
import org.example.semantic.intf.type.PrimitiveType;
import org.example.semantic.intf.type.ReferenceType;
import org.example.semantic.intf.type.Type;
import org.example.styler.naming.SymbolType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.plaf.synth.SynthCheckBoxUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResolverImpl implements Resolver {
    public static Logger logger = LoggerFactory.getLogger(ResolverImpl.class);
    private Map<ParseTree, SymbolTable> symbolTableMap = new HashMap<>();


    @Override
    public Symbol resolve(TerminalNode identifierNode, MyParser parser) {
        ParseTree root = parser.getRoot();
        if (symbolTableMap.get(root) == null) {
            symbolTableMap.put(root, new SymbolTable());
        }
        SymbolTable st = symbolTableMap.get(root);
        return doResolve(st, identifierNode, parser);
    }

    @Override
    public SymbolTable getSymbolTable(ParseTree root) {
        return symbolTableMap.get(root);
    }

    private Symbol doResolve(SymbolTable st, TerminalNode identifierNode, MyParser parser) {
        Symbol symbol = null;
        if (identifierNode.getSymbol().getType() == parser.getIdentifier()) {
            ExtendContext parent = (ExtendContext) identifierNode.getParent();
            while (parent != null) {
                int ruleIndex = parent.getRuleIndex();
                if (parser.isFieldDeclaration(parent) || parser.isLocalVarDeclaration(parent)) {
                    symbol = resolveVarDeclaration(parent, identifierNode, parser);
                    break;
                } else if (parser.belongToFunctionDec(ruleIndex)) {
                    symbol = resolveFunctionDeclaration(parent, identifierNode, parser);
                    break;
                } else if (parser.isTypeDeclaration(parent)) {
                    symbol = resolveTypeDeclaration(st, parent, identifierNode, parser);
                    break;
                } else if (parser.belongToParameter(parent)) {
                    symbol = resolveParameter(parent, identifierNode, parser);
                    break;
                } else if (parser.isTypeParameter(parent)) {
                    symbol = resolveTypeParameter(parent, identifierNode, parser);
                    break;
                } else if (ruleIndex == parser.getRuleExpression()) {
                    resolveReference(st, identifierNode, parser);
                    break;
                }
                parent = (ExtendContext) parent.getParent();
            }
            if (symbol != null) {
                st.addSymbol(symbol, parser);
            }
        }
        return symbol;
    }

    private Type resolveType(ExtendContext typeNode, MyParser parser) {
        if (typeNode == null) {
            return  null;
        }
        if (PrimitiveType.isPrimitiveType(typeNode.getText())) {
            return new PrimitiveType(typeNode);
        } else {
            return new ReferenceType(typeNode, null);
        }
    }


    private Symbol resolveParameter(ExtendContext decNode, TerminalNode identifier, MyParser parser) {
        SymbolType symbolType = SymbolType.PARAMETER;
        ExtendContext modifierList = decNode.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleModifierList());
        ExtendContext typeNode = decNode.getFirstCtxChildIf(parser::isTypeType);
        Type type = resolveType(typeNode, parser);
        VarSym symbol = new VarSym(type, identifier, modifierList, symbolType);
        return symbol;
    }

    private List<Symbol> resolveTypeParameters(ExtendContext headContext, MyParser parser) {
        ExtendContext typeParametersNode = headContext.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleTypeParameters());
        List<Symbol> typeParameters = new ArrayList<>();
        if (typeParametersNode != null) {
            typeParametersNode.children.forEach(child -> {
                if (parser.isTypeParameter(child)) {
                    ExtendContext childCtx = (ExtendContext) child;
                    typeParameters.add(resolveTypeParameter(childCtx, childCtx.getFirstTerChildByType(parser.getIdentifier()), parser));
                }
            });
        }
        return typeParameters;
    }

    private Symbol resolveTypeDeclaration(SymbolTable st, ExtendContext decNode, TerminalNode identifier, MyParser parser) {
        SymbolType symbolType = SymbolType.TYPE;
        ExtendContext modifierList = decNode.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleModifierList());
        ExtendContext headContext = getHeadContext(decNode);
        List<Symbol> typeParameters = resolveTypeParameters(headContext, parser);

        // resolve parents
        List<ExtendContext> typeNodeofParents = new ArrayList<>();
        for (ParseTree child : headContext.children) {
            if (child instanceof ExtendContext ctx ) {
                if (ctx.getRuleIndex() == parser.getRuleTypeType()) {
                    typeNodeofParents.add(ctx);
                } else if (ctx.getRuleIndex() == parser.getRuleTypeList()) {
                    typeNodeofParents.addAll(ctx.getAllContextsIf(child1 -> child1.getRuleIndex() == parser.getRuleTypeType()));
                }
            }
        }

        // resolve outer class.
        Symbol outerClass = null;
        ParseTree parent = decNode.getParent();
        while (!parser.isTypeDeclaration(parent)) {
            if (parent == null) {
                break;
            }
            parent =  parent.getParent();
        }
        if (parser.isTypeDeclarationList(parent)) {
            ExtendContext identifierNode = getHeadContext(parent).getFirstCtxChildIf(parser::isIdentifier);
            outerClass = st.getSymbol(identifierNode.getFirstTerChildByType(parser.getIdentifier()), parser);
        }

        String path = findPathOfClass(decNode, parser);
        Symbol symbol = new ClassSym(typeNodeofParents, path, typeParameters, outerClass, identifier, modifierList, symbolType);
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

    private Symbol resolveFunctionDeclaration(ExtendContext decNode, TerminalNode identifier, MyParser parser) {
        ExtendContext modifierList = decNode.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleModifierList());
        ExtendContext headContext = getHeadContext(decNode);
        ExtendContext typeNode = headContext.getFirstCtxChildIf(parser::isTypeType);
        SymbolType symbolType = typeNode == null ? SymbolType.CONSTRUCTOR : SymbolType.METHOD;
        Type retType = resolveType(typeNode, parser);
        List<Symbol> typeParameters = resolveTypeParameters(headContext, parser);

        Symbol symbol = new FunctionSym(retType,typeParameters, identifier, modifierList, symbolType);
        return symbol;
    }

    private Symbol resolveVarDeclaration(ExtendContext decNode, TerminalNode identifier, MyParser parser) {
        SymbolType symbolType = parser.isFieldDeclaration(decNode) ? SymbolType.FIELD : SymbolType.LOCAL_VARIABLE;
        ExtendContext modifierList = decNode.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleModifierList());
        ExtendContext typeNode = decNode.getFirstCtxChildIf(parser::isTypeType);
        Type type = resolveType(typeNode, parser);
        Symbol symbol = new VarSym(type, identifier, modifierList, symbolType);
        return symbol;
    }


    private void resolveReference(SymbolTable st, TerminalNode identifier, MyParser parser) {
        Symbol symbol = st.getSymbol(identifier, parser);
        if (symbol == null) {
            logger.warn("symbol '{}' is has no resolved symbol.", identifier.getText());
            return;
        }
        symbol.addReference(identifier);
    }

    private Symbol resolveTypeParameter(ExtendContext typeParameterNode, TerminalNode identifier, MyParser parser) {
        if (typeParameterNode == null) {
            return null;
        }
        return new VarSym(null, identifier, null, SymbolType.TYPE_PARAMETER);
    }

    private ExtendContext getHeadContext(ParseTree decNode) {
        if (decNode instanceof ExtendContext ctx) {
            return (ExtendContext) decNode.getChild(1);
        }
        return null;
    }

}
