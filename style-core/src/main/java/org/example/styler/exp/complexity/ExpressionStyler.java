package org.example.styler.exp.complexity;

import java.util.*;
import java.util.function.Function;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.tuple.MutablePair;
import org.example.RunStatistic;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.utils.ParseTreeUtil;
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
import org.example.styler.exp.complexity.style.ExpressionComplexity;
import org.example.styler.exp.complexity.style.ExpressionContext;
import org.example.styler.exp.complexity.style.ExpressionProperty;
import org.example.styler.exp.complexity.style.ExpressionStyle;
import org.example.styler.naming.MyCaseFormat;
import org.example.styler.naming.NameType;
import org.example.utils.NameGenerator;
import org.example.utils.searcher.intf.CompilationUnitSearcher;
import org.example.utils.searcher.intf.VarDeclarationSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 目前只能处理 primitive types
 */
public class ExpressionStyler extends Styler {
    private static final Logger log = LoggerFactory.getLogger(ExpressionStyler.class);
    private Map<ExpressionContext, List<ExpressionComplexity>> complexityMap = new HashMap<>();

    public ExpressionStyler() {
        style = new ExpressionStyle();
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext expression = ctx.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleExpression());
        if (expression == null) {
            return;
        }

        ExpressionContext styleContext = extractStyleContext(ctx, parser);
        ExpressionComplexity expComplexity = calExpComplexity(expression);
        complexityMap.computeIfAbsent(styleContext, k -> new ArrayList<>()).add(expComplexity);
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        ExtendContext expression = ctx.getFirstCtxChildIf(child -> child.getRuleIndex() == parser.getRuleExpression());
        if (expression == null) {
            return ctx;
        }

        ExpressionContext styleContext = extractStyleContext(ctx, parser);
        ExpressionComplexity complexity = calExpComplexity(expression);
        StyleProperty property = style.getProperty(styleContext);
        if (property instanceof ExpressionProperty targetProperty) {
            if (complexity.isMoreComplex(targetProperty.maxComplexity)) {
                try {
                    splitExpression(expression, complexity, targetProperty, parser);
                    RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                } catch (RuntimeException e) {
                    log.error("Fail to split expression.", e);
                }

            } else if (targetProperty.avgComplexity.isMoreComplex(complexity)) {
                try {
                    mergeExpression(expression, complexity, targetProperty, parser);
                    RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                }  catch (RuntimeException e) {
                    log.error("Fail to merge expression.", e);
                }
            }
        }

        return ctx;
    }


    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        // For efficiency, do not select the expression node for checking.
        return ctx.getRuleIndex() == parser.getRuleExpStmt() || ctx.getRuleIndex() == parser.getRuleParExpression() || parser.isVariableInitializer(ctx);
    }

    @Override
    public void extractFinalize() {
        complexityMap.forEach((styleContext, complexityList) -> {
            List<Double> lengthList = complexityList.stream().map(e -> e.textLength).toList();
            List<Double> depthList = complexityList.stream().map(e -> e.depth).toList();
            ExpressionComplexity maxComplexity = new ExpressionComplexity(Collections.max(lengthList), Collections.max(depthList));
            ExpressionComplexity avgComplexity = new ExpressionComplexity(lengthList.stream().mapToDouble(e -> e).average().orElse(0.0),
                    depthList.stream().mapToDouble(e -> e).average().orElse(0.0));
            style.addRule(styleContext, new ExpressionProperty(maxComplexity, avgComplexity));
        });
    }

    private ExpressionContext extractStyleContext(ExtendContext node, MyParser parser) {
        ExpType expType = null;
        if(parser.isVariableInitializer(node)) {
            expType = ExpType.INITIALIZER_EXP;
        } else if (parser.getRuleExpressionStmt() == node.getRuleIndex()) {
            expType = node.getFirstCtxChildIf(parser::isExpression)
                    .getAllTerminalsIf(ter -> ter.getText().equals("?") || ter.getText().equals(":")).size() == 2
                    ? ExpType.TERNARY_EXP
                    : ExpType.TOP_EXP;
        } else if (parser.getRuleParExpression() == node.getRuleIndex()) {
            expType = ExpType.CONDITIONAL_EXP;
        }
        return expType == null ? null : new ExpressionContext(expType);
    }

    private ExpressionComplexity calExpComplexity(ExtendContext expression) {
        int length = expression.getText().length();
        int expDepth = ParseTreeUtil.getInstance().getTreeDepth(expression);
        return new ExpressionComplexity(length, expDepth);
    }


    private void mergeExpression(ExtendContext expression, final ExpressionComplexity curComplexity, ExpressionProperty targetProperty, MyParser parser) {
        ExtendContext statement = expression.getFirstParentIf(parser::isStatement);
        if (statement == null) {
            return;
        }

        ExtendContext block = statement.getFirstParentIf(parser::isBlock);
        if (block == null) {
            return;
        }

        // Store all successive "lv = rv" precede current expression in map.
        int index = block.indexOfFirstChild(child -> child == statement);
        Function<ExtendContext, Integer> getExpressionNode = exp -> {
            if (exp == null) {
                return -1;
            }
            int assignIndex = exp.indexOfIf(child -> child instanceof TerminalNode ter && ter.getText().equals("="));
            return assignIndex >= 0 ? assignIndex : -1;
        };
        Map<String, ExtendContext> lVrVMap = new HashMap<>();
        for (int i = index - 1; i >= 0; i--) {
            if (block.getChild(i) instanceof ExtendContext ctx && parser.getRuleExpressionStmt() == parser.getSpecificStmtType(ctx)) {
                ExtendContext expNode = parser.getSpecificStmt(ctx).getFirstCtxChildIf(parser::isExpression);
                int assignIndex = expNode.indexOfFirstChild(child -> child instanceof TerminalNode ter && ter.getText().equals("="));
                if (assignIndex >= 0){
                    String lValue = expNode.getChild(assignIndex - 1).getText();
                    if (!lVrVMap.containsKey(lValue)) {
                        lVrVMap.put(lValue, (ExtendContext) expNode.getChild(assignIndex + 1));
                    }

                }
            }
        }

        // replace the subexpressions in current expression with the last assignment of the subexpressions until the complexity is greater avg and less max.
        Map<String, List<ExtendContext>> subExpressionMap = new HashMap<>();
        extractSubExpression(expression, subExpressionMap, parser);
        Set<String> selectedSubExp = new HashSet<>(subExpressionMap.keySet());
        selectedSubExp.retainAll(lVrVMap.keySet());
        for (String expStr : selectedSubExp) {
            // Replace the subexpression with the last assignment expression.
            List<ExtendContext> oldSubExpressions = subExpressionMap.get(expStr);
            for (ExtendContext exp : oldSubExpressions) {
                ((ExtendContext) exp.getParent()).replaceChild(exp, ParseTreeUtil.getInstance().copyTree(lVrVMap.get(expStr), false));
            }

            // When the new expression is more complex than the max complexity, cancle the replacement.
            ExpressionComplexity newComplexity = calExpComplexity(expression);
            if (newComplexity.isMoreComplex(targetProperty.maxComplexity)) {
                for (ExtendContext exp : oldSubExpressions) {
                    ((ExtendContext) exp.getParent()).replaceChild(lVrVMap.get(expStr), exp);
                }
                break;
            }

            if (calExpComplexity(expression).isMoreComplex(targetProperty.avgComplexity)) {
                break;
            }
        }
    }

    private void splitExpression(ExtendContext expression, final ExpressionComplexity curComplexity, ExpressionProperty targetProperty, MyParser parser) {
        // Create subexpressions to be split.
        Map<String, List<ExtendContext>> expressionMap = new HashMap<>();
        extractSubExpression(expression, expressionMap, parser);
        expressionMap.remove(expression.getText()); // remove ·expression· itself.


        // The expression with the most repetitions has the highest priority, and when the repetition is the same, the expression greater than and closest to the average complexity is prior.
        PriorityQueue<MutablePair<String, List<ExtendContext>>> pq = new PriorityQueue<>(Comparator.comparing(
                (MutablePair<String, List<ExtendContext>> p) -> {
                    ExpressionComplexity pComplexity = calExpComplexity(p.getValue().get(0));
                    double distance = Math.abs(pComplexity.diff(targetProperty.avgComplexity));
                    return -(p.getRight().size() * 10000 - distance);
                }));
        for (Map.Entry<String, List<ExtendContext>> entry : expressionMap.entrySet()) {
            pq.add(new MutablePair<>(entry.getKey(), entry.getValue()));
        }


        ExpressionComplexity newComplexity = calExpComplexity(expression);
        while(newComplexity.isMoreComplex(targetProperty.maxComplexity)) {
            // Remove candidates that are less complex than avg complexity.
            pq.removeIf(e -> e.getValue().size() == 1 && calExpComplexity(e.getValue().get(0)).isNoMoreComplex(targetProperty.avgComplexity));

            MutablePair<String, List<ExtendContext>> selectedSubExp = pq.poll();
            if (selectedSubExp == null) {
                break;
            }

            // Preparation for create declaration statement.
            String name = doSplitExpression(selectedSubExp, parser);

            // Update the priority queue
            for (MutablePair<String, List<ExtendContext>> pair : pq) {
                String newExpressionText = pair.getValue().get(0).getText();
                if (!newExpressionText.equals(pair.getKey())) {
                    pair.setLeft(newExpressionText);
                }
            }

            newComplexity = calExpComplexity(expression);
        }
    }

    private String doSplitExpression(MutablePair<String, List<ExtendContext>> selectedSubExp, MyParser parser) {
        // Create a variable declaration statement for the expressions.
        MyCaseFormat caseFormat = MyCaseFormat.LOWER_CAMEL;
        String name = NameGenerator.generateName("",caseFormat );
        Type type = GlobalInfo.getTypeResolver().getType(selectedSubExp.getValue().get(0), parser);
        if (type == null) {
            return "";
        }
        ExtendContext decStmt = addVarDeclaration(type, name, selectedSubExp.getValue().get(0), parser);

        // Set a meaningful name for the newly created variable
        VarDeclarationSearcher varDeclarationSearcher = GlobalInfo.getConf().getLanguageConfig().getNodeSearcherFactory().createVarDeclarationSearcher();
        ExtendContext identifier = varDeclarationSearcher.searchIdentifiers(decStmt, parser).get(0);
        String newName = NameGenerator.generateMeaningfulName(identifier, parser, GlobalInfo.getConf().getLlmConfig().getIdentifierLengthLimit());
        if (newName != null && identifier.getStart() instanceof ExtendToken extendToken) {
            extendToken.setText(newName);
        }

        // Add number suffix to the variable name until naming conflicts removed.
        name = identifier.getText();
        for (int i = 1; mayConflict(name, parser); i++) {
            name = identifier.getText() + Integer.toString(i);
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
        SymbolTableManager.getSymbolTable(parser).addSymbol(newSym, parser);

        return identifier.getText();
    }

    private void extractSubExpression(ExtendContext expression, Map<String, List<ExtendContext>> expressionMap, MyParser parser) {
        expressionMap.computeIfAbsent(expression.getText(), k -> new ArrayList<>()).add(expression);
        for (ParseTree child : expression.children) {
            if (child instanceof ExtendContext ctx && ctx.getRuleIndex() == parser.getRuleExpression() && ctx.getChildCount() > 1) {
                extractSubExpression(ctx,  expressionMap, parser);
            }
        }
    }

    private boolean mayConflict(String name, MyParser parser) {
        return GlobalInfo.getResolver().getSymbolTable(parser).hasSymbol(name);
    }

    private ExtendContext addVarDeclaration(Type type, String name, ExtendContext initializer, MyParser parser) {
        StringBuilder code = new StringBuilder();
        code.append(type.getName()).append(" ").append(name).append(" = ").append(initializer.getText()).append(";\n");
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

            if (!isImported && referenceType.getQualifiedName() != null) {
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

}
