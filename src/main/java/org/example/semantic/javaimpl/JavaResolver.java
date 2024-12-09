package org.example.semantic.javaimpl;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.resolution.UnsolvedSymbolException;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.semantic.SymbolTable;
import org.example.semantic.intf.FunctionSym;
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
        StaticJavaParser.getParserConfiguration().setSymbolResolver(symbolSolver);
        cu = StaticJavaParser.parse(code);
        return doRsolve(cu);

    }

    @Override
    public SymbolTable parse(File file) {
        try {
            StaticJavaParser.getParserConfiguration().setSymbolResolver(symbolSolver);
            cu = StaticJavaParser.parse(file);
            return doRsolve(cu);
        } catch (FileNotFoundException e) {
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
        System.out.println("to do: implement JavaResolver@resolve");
        return null;
    }


    private SymbolTable doRsolve(CompilationUnit cu) {
        SymbolTable st = new SymbolTable();
        // 获取所有变量的声明并解析其类型
        cu.findAll(VariableDeclarator.class).forEach(variable -> {
            List<String> modifiers = new ArrayList<String>();
            Symbol symbol = createSymbol(variable.resolve(), modifiers);
            Optional<Node> cur = variable.getParentNode();

            st.addSym(symbol);
        });
        cu.findAll(Parameter.class).forEach(parameter -> {
            List<String> modifiers = new ArrayList<String>();
            Symbol symbol = createSymbol(parameter.resolve(), modifiers);
            Optional<Node> cur = parameter.getParentNode();

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
                for (Symbol symbol : symbols) {
                    if (symbol instanceof JavaSymbol javaSymbol && declaration.toAst().get() == javaSymbol.declaration.toAst().get()) {
                        symbol.addReference(new JavaReference(symbol, nameExpr));
                    }
                }
            } else {
                LoggerFactory.getLogger(JavaResolver.class).warn("Failed to resolve reference for NameExpr: {}", nameExpr.getNameAsString());
            }
        });

        return st;
    }

    private Symbol createSymbol(ResolvedValueDeclaration  declaration, List<String> modifiers) {
        SymbolType symbolType = null;
        Symbol symbol = null;
        if (declaration.isField()) {
            symbolType = SymbolType.FIELD;
            symbol = new JavaVarSym(symbolType, declaration, modifiers);
        } else if (declaration.isParameter()) {
            symbolType = SymbolType.PARAMETER;
            symbol = new JavaVarSym(symbolType, declaration, modifiers);
        } else if (declaration.isVariable()) {
            symbolType = SymbolType.LOCAL_VARIABLE;
            symbol = new JavaVarSym(symbolType, declaration, modifiers);
        } else if (declaration.isType() || declaration.isTypePattern()) {
            symbolType = SymbolType.TYPE;
            symbol = new JavaClassSym(symbolType, declaration, modifiers);
        } else if (declaration.isEnumConstant()) {
            symbolType = SymbolType.ENUM_CONSTANT;
            symbol = new JavaVarSym(symbolType, declaration, modifiers);
        } else if (declaration.isMethod()) {
            symbolType = SymbolType.METHOD;
            symbol = new JavaFunctionSym(symbolType, declaration, modifiers);
        }

        return symbol;
    }




}
