package org.example.semantic.javaimpl;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.resolution.UnsolvedSymbolException;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.SymbolTable;
import org.example.semantic.SymbolTableManager;
import org.example.semantic.intf.Resolver;
import org.example.semantic.intf.Symbol;
import org.example.styler.naming.SymbolType;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JavaResolver implements Resolver {
    JavaSymbolSolver symbolSolver;
    CompilationUnit cu;


    public JavaResolver() {
        CombinedTypeSolver typeSolver = new CombinedTypeSolver();
        typeSolver.add(new ReflectionTypeSolver()); // Java 标准库解析
        typeSolver.add(new JavaParserTypeSolver(new File("src/main/java"))); // 项目源代码解析
        symbolSolver = new JavaSymbolSolver(typeSolver);
    }

    @Override
    public SymbolTable parse(String code) {
        try {
            StaticJavaParser.getParserConfiguration().setSymbolResolver(symbolSolver);
            cu = StaticJavaParser.parse(code);
            return doResolve(cu);
        } catch (Exception e) {
            LoggerFactory.getLogger(JavaResolver.class).error("Failed to resolve symbols for code", e);
        }
        return null;
    }

    @Override
    public SymbolTable parse(File file) {
        try {
            StaticJavaParser.getParserConfiguration().setSymbolResolver(symbolSolver);
            cu = StaticJavaParser.parse(file);
            return doResolve(cu);
        } catch (Exception e) {
            LoggerFactory.getLogger(JavaResolver.class).error("Failed to resolve symbols for file", e);
        }
        return null;
    }

    @Override
    public String getParsedSourceCode() {
        return cu.toString();
    }

    @Override
    public Symbol resolve(TerminalNode identifierNode, MyParser parser) {
        SymbolTable st = SymbolTableManager.getInstance().getSymbolTable(parser.getRoot());

        List<CandidateSymbol> candidates = new ArrayList<>();
        List<Symbol> symbols = st.getSymbolsHasSameName(identifierNode.getText());
        if (symbols == null) {
            return null;
        }

        symbols.forEach(symbol -> candidates.add(new CandidateSymbol(symbol, identifierNode)));
        while (candidates.size() > 1) {
            List<CandidateSymbol> newCandidates = new ArrayList<>();
            for (CandidateSymbol candidate : candidates) {
                if (candidate.symbol instanceof JavaSymbol javaSymbol) {
                    Node context1 = findContext(javaSymbol.declaration);
                    ParseTree context2 = findContext(candidate.node, parser);
                    candidate.node = context2;
                    if (context1 != null && context2 != null && context1.toString().equals(context2.getText())) {
                        newCandidates.add(candidate);
                    }
                }
            }
        }

        return null;
    }

    private ParseTree findContext(ParseTree node, MyParser parser) {
        ExtendContext parent = (ExtendContext) node.getParent();
        while (parent != null) {
            if (parser.belongToStmt(parent)) {
                return parent;
            }
            parent = (ExtendContext) parent.getParent();
        }
        return null;
    }

    private Node findContext(ResolvedValueDeclaration declaration) {
        if (declaration == null) {
            return null;
        }
        Node node = declaration.toAst().get();
        while (node.getParentNode().isPresent()) {
            if (node instanceof Statement) {
                return node;
            }
            node = node.getParentNode().get();
        }
        return null;
    }


    private SymbolTable doResolve(CompilationUnit cu) {
        SymbolTable st = new SymbolTable();
        // 获取所有变量的声明并解析其类型
        cu.findAll(VariableDeclarator.class).forEach(variable -> {
            List<String> modifiers = new ArrayList<String>();
            Symbol symbol = createSymbol(variable.resolve(), variable);
            Optional<Node> cur = variable.getParentNode();

            st.addSym(symbol);
        });
        cu.findAll(Parameter.class).forEach(parameter -> {
            List<String> modifiers = new ArrayList<String>();
            Symbol symbol = createSymbol(parameter.resolve(), parameter);
            st.addSym(symbol);
        });

        // 获取 NameExpr 类型并解析引用的变量的类型
        cu.findAll(NameExpr.class).forEach(nameExpr -> {
            ResolvedValueDeclaration declaration = null;
            try {
                declaration = nameExpr.resolve();
            } catch (UnsolvedSymbolException e) {
                LoggerFactory.getLogger(JavaResolver.class).warn("Failed to resolve identifier: {}", nameExpr.getNameAsString());
            }

            if (declaration != null) {
                List<Symbol> symbols = st.getSymbolsHasSameName(nameExpr.getNameAsString());
                if (symbols != null) {
                    for (Symbol symbol : symbols) {
                        if (symbol instanceof JavaSymbol javaSymbol) {
                            if (declaration.toAst().get() == javaSymbol.getDefNode()) {
                                symbol.addReference(new JavaReference(symbol, nameExpr));
                            }
                        }
                    }
                }
            } else {
                LoggerFactory.getLogger(JavaResolver.class).warn("Failed to resolve reference for NameExpr: {}", nameExpr.getNameAsString());
            }
        });

        return st;
    }

    private Symbol createSymbol(ResolvedValueDeclaration  declaration, Node defNode) {
        SymbolType symbolType = null;
        Symbol symbol = null;
        if (declaration.isField()) {
            symbolType = SymbolType.FIELD;
            symbol = new JavaVarSym(symbolType, declaration, defNode);
        } else if (declaration.isParameter()) {
            symbolType = SymbolType.PARAMETER;
            symbol = new JavaVarSym(symbolType, declaration, defNode);
        } else if (declaration.isVariable()) {
            symbolType = SymbolType.LOCAL_VARIABLE;
            symbol = new JavaVarSym(symbolType, declaration, defNode);
        } else if (declaration.isType() || declaration.isTypePattern()) {
            symbolType = SymbolType.TYPE;
            symbol = new JavaClassSym(symbolType, declaration, defNode);
        } else if (declaration.isEnumConstant()) {
            symbolType = SymbolType.ENUM_CONSTANT;
            symbol = new JavaVarSym(symbolType, declaration, defNode);
        } else if (declaration.isMethod()) {
            symbolType = SymbolType.METHOD;
            symbol = new JavaFunctionSym(symbolType, declaration, defNode);
        }

        return symbol;
    }


    private static class CandidateSymbol {
        Symbol symbol;
        ParseTree node;

        public CandidateSymbol(Symbol symbol, ParseTree node) {
            this.symbol = symbol;
            this.node = node;
        }
    }

}
