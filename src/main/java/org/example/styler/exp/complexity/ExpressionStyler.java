package org.example.styler.exp.complexity;

import java.util.*;
import java.util.function.Function;

import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.tuple.MutablePair;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.common.factory.ParseTreeUtil;
import org.example.parser.common.token.ExtendToken;
import org.example.semantic.SymbolTableManager;
import org.example.semantic.intf.symbol.Symbol;
import org.example.semantic.intf.symbol.VarSym;
import org.example.semantic.intf.type.ReferenceType;
import org.example.semantic.intf.type.Type;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.exp.ExpType;
import org.example.styler.exp.complexity.style.ExpressionContext;
import org.example.styler.exp.complexity.style.ExpressionProperty;
import org.example.styler.exp.complexity.style.ExpressionStyle;
import org.example.styler.naming.MyCaseFormat;
import org.example.styler.naming.NameType;
import org.example.utils.NameGenerator;
import org.example.utils.searcher.intf.CompilationUnitSearcher;
import org.example.utils.searcher.intf.DecStmtSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpressionStyler extends Styler {
    private static final Logger log = LoggerFactory.getLogger(ExpressionStyler.class);

    public ExpressionStyler() {
        style = new ExpressionStyle();
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext expression = ctx.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleExpression());
        if (expression == null) {
            return;
        }

        ExpressionContext styleContext = extractStyleContext(expression, parser);
        ExpressionProperty styleProperty = extractStyleProperty(expression, parser);
        if (styleContext != null) {
            StyleProperty targetProperty = style.getProperty(styleContext);
            if (targetProperty == null) {
                style.addRule(styleContext, styleProperty);
            } else if (targetProperty instanceof ExpressionProperty expProperty){
                if (expProperty.maxExpressionLength < styleProperty.maxExpressionLength) {
                    expProperty.maxExpressionLength = styleProperty.maxExpressionLength;
                }
                if (expProperty.maxSubExpNum < styleProperty.maxSubExpNum) {
                    expProperty.maxSubExpNum = styleProperty.maxSubExpNum;
                }
            }
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext expression = ctx.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleExpression());
        ExpressionContext styleContext = extractStyleContext(expression, parser);
        ExpressionProperty styleProperty = extractStyleProperty(expression, parser);
        StyleProperty property = style.getProperty(styleContext);
        if (property instanceof ExpressionProperty targetProperty) {
            boolean moreComplex = styleProperty.isMoreComplex(targetProperty);
            if (moreComplex) {
                splitExpression(expression, styleProperty, targetProperty, parser);
            } else {
                mergeExpression(expression,styleProperty, targetProperty, parser);
            }
        }
        return ctx;
    }


    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        // For efficiency, do not select the expression node for checking.
        return ctx.getRuleIndex() == parser.getRuleExpStmt() || ctx.getRuleIndex() == parser.getRuleParExpression() || parser.isVariableInitializer(ctx);
    }

    private ExpressionContext extractStyleContext(ExtendContext expression, MyParser parser) {
        ExpType expType = null;
        int parentRule = expression.getParent().getRuleIndex();
        if (parentRule == parser.getRuleExpStmt() || parser.isVariableInitializer(expression.getParent())) {
            expType = expression.getAllTerminalsIf(ter -> ter.getText().equals("?") || ter.getText().equals(":")).size() == 2
                    ? ExpType.TERNARY_EXP
                    : ExpType.TOP_EXP;
        } else if (parentRule == parser.getRuleParExpression()) {
            expType = ExpType.CONDITIONAL_EXP;
        }
        return expType == null ? null : new ExpressionContext(expType);
    }

    private ExpressionProperty extractStyleProperty(ExtendContext expression, MyParser parser) {
        int length = expression.getText().length();
        int subExpNum = expression.getAllCtxsRecIf(ctx -> ctx.getRuleIndex() == parser.getRuleExpression()).size();
        return new ExpressionProperty(length, subExpNum);
    }


    private void mergeExpression(ExtendContext expression, ExpressionProperty curProperty, ExpressionProperty targetProperty, MyParser parser) {

    }

    private void splitExpression(ExtendContext expression, ExpressionProperty curProperty, ExpressionProperty targetProperty, MyParser parser) {
        //
        Map<String, List<ExtendContext>> expressionMap = new HashMap<>();
        extractCommonExpression(expression, expressionMap, parser);
        PriorityQueue<MutablePair<String, List<ExtendContext>>> pq = new PriorityQueue<>(Comparator.comparing(
                (MutablePair<String, List<ExtendContext>> p) -> {
                    int lengthDiff = Math.abs(extractStyleProperty(p.getValue().get(0), parser).maxExpressionLength - targetProperty.maxExpressionLength);
                    return -(p.getRight().size() * 1000 - lengthDiff);
                }));
        for (Map.Entry<String, List<ExtendContext>> entry : expressionMap.entrySet()) {
            pq.add(new MutablePair<>(entry.getKey(), entry.getValue()));
        }


        MutablePair<String, List<ExtendContext>> selectedSubExp = pq.poll();
        while(selectedSubExp != null && curProperty.isMoreComplex(targetProperty)) {
            // Preparation for create declaration statement.
            int originalSubNum = extractStyleProperty(selectedSubExp.getValue().get(0), parser).maxSubExpNum;
            int originalExpLength = selectedSubExp.getKey().length();
            String name = doSplitExpression(selectedSubExp, parser);

            curProperty.maxExpressionLength -= (originalExpLength - name.length()) * selectedSubExp.getValue().size();
            curProperty.maxSubExpNum -= selectedSubExp.getValue().size() * originalSubNum;

            // Update the priority queue
            for (MutablePair<String, List<ExtendContext>> pair : pq) {
                String newExpressionText = pair.getValue().get(0).getText();
                if (!newExpressionText.equals(pair.getKey())) {
                    pair.setLeft(newExpressionText);
                }
            }
            selectedSubExp = pq.poll();
        }
    }

    private String doSplitExpression(MutablePair<String, List<ExtendContext>> selectedSubExp, MyParser parser) {
        // Create a variable declaration statement for the expressions.
        MyCaseFormat caseFormat = MyCaseFormat.LOWER_CAMEL;
        String name = NameGenerator.generateName("",caseFormat );
        Type type = GlobalInfo.getTypeSystem().getType(selectedSubExp.getValue().get(0), parser);
        if (type == null) {
            return "";
        }
        ExtendContext decStmt = addVarDeclaration(type, name, selectedSubExp.getValue().get(0), parser);
        if (decStmt == null) {
            log.info("Fail to split expression because of adding variable declaration failed.");
            return "";
        }

        // Set a meaningful name for the newly created variable
        DecStmtSearcher decStmtSearcher = GlobalInfo.getConf().getLanguageConfig().getNodeSearcherFactory().createDecStmtSearcher();
        ExtendContext identifier = decStmtSearcher.searchIdentifiers(decStmt, parser).get(0);
        String newName = NameGenerator.generateMeaningfulName(identifier, parser, GlobalInfo.getConf().getLlmConfig().getIdentifierLengthLimit());
        if (newName != null && identifier.getStart() instanceof ExtendToken extendToken) {
            extendToken.setText(newName);
        }

        // Add number suffix to the variable name until naming conflicts removed.
        name = identifier.getText();
        for (int i = 1; mayConflict(name, parser); i++) {
            name = name + Integer.toString(i);
        }
        if (!name.equals(identifier.getText()) && identifier.getStart() instanceof ExtendToken extendToken) {
            extendToken.setText(name);
        }

        List<ExtendContext> expressions = selectedSubExp.getRight();
        List<ExtendContext> copies = new ArrayList<>();
        for (int i = 0; i < expressions.size(); i++) {
            ExtendContext copyIdentifier = (ExtendContext) ParseTreeUtil.getInstance().copyTree(identifier, false);
            copies.add(copyIdentifier);
            expressions.get(i).replaceChildren(0, expressions.get(i).getChildCount(), List.of(copyIdentifier));
        }


        Symbol newSym = new VarSym(type, identifier, null, NameType.LOCAL_VARIABLE);
        copies.forEach(newSym::addReference);
        SymbolTableManager.getSymbolTable(parser.getRoot()).addSymbol(newSym, parser);

        return identifier.getText();
    }

    private void extractCommonExpression(ExtendContext expression, Map<String, List<ExtendContext>> expressionMap, MyParser parser) {
        expressionMap.computeIfAbsent(expression.getText(), k -> new ArrayList<>()).add(expression);
        for (ParseTree child : expression.children) {
            if (child instanceof ExtendContext ctx && ctx.getRuleIndex() == parser.getRuleExpression() && ctx.getChildCount() > 1) {
                extractCommonExpression(ctx,  expressionMap, parser);
            }
        }
    }

    private boolean mayConflict(String name, MyParser parser) {
        return GlobalInfo.getResolver().getSymbolTable(parser.getRoot()).hasSymbol(name);
    }

    private ExtendContext addVarDeclaration(Type type, String name, ExtendContext initializer, MyParser parser) {
        StringBuilder code = new StringBuilder();
        code.append(type.getName()).append(" ").append(name).append(" = ").append(initializer.getText()).append(";");
        ParseTree stmt = MyParserFactory.createParser(parser.getClass()).parse(code.toString(), parser.getRuleStmt());

        if (type instanceof ReferenceType referenceType) {
            // Import if necessary.
            CompilationUnitSearcher cuSearcher = GlobalInfo.getConf().getLanguageConfig().getNodeSearcherFactory().createCompilationUnitSearcher();
            ExtendContext cu = (ExtendContext) parser.getRoot();
            List<ExtendContext> imports = cuSearcher.searchImports(cu, parser);
            boolean isImported = false;
            for (ExtendContext importNode : imports) {
                if (importNode.getText().contains(referenceType.getQualifiedName())) {
                    isImported = true;
                    break;
                }
            }

            if (!isImported) {
                String importCode = "import " + referenceType.getQualifiedName() + ";";
                ParseTree importNode = MyParserFactory.createParser(parser.getClass()).parse(importCode, parser.getRuleImportDeclarationList());
                if (importNode == null) {
                    log.error("Fail to create import!");
                    return null;
                }
                if (imports.isEmpty()) {
                    cu.insertChild(cuSearcher.getIndexOfImportList(cu, parser), importNode);
                } else {
                    ExtendContext lastImport = imports.get(imports.size() - 1);
                    ExtendContext parent = (ExtendContext) lastImport.parent;
                    parent.addChild(importNode.getChild(0));
                    parent.children.sort(Comparator.comparing(ParseTree::getText));
                    parent.updateStartToken();
                    parent.updateStopToken();
                }
            }
        }
        // Insert the generated declaration statement
        ExtendContext expStmt = initializer.findFirstParentIf(parser::isStatement);
        if (expStmt.parent instanceof ExtendContext parent) {
            parent.insertChild(parent.indexOfFirstChild(child -> child == expStmt), stmt);
        }
        return parser.getSpecificStmt((ExtendContext) stmt);
    }

    private void replaceChildren(List<ExtendContext> expressions, List<ParseTree> newChildren, MyParser parser) {
        if (expressions.isEmpty()) {
            return;
        }
        expressions.get(0).replaceChildren(0, expressions.get(0).getChildCount(), newChildren);
        for (int i = 1; i < expressions.size(); i++) {
            List<ParseTree> copies = new ArrayList<>();
            newChildren.forEach(child -> copies.add(ParseTreeUtil.getInstance().copyTree(child, false)));
            expressions.get(i).replaceChildren(0, expressions.get(i).getChildCount(), copies);
        }
    }
}
