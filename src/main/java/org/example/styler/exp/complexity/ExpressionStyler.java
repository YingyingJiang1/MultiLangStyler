package org.example.styler.exp.complexity;

import com.google.common.base.CaseFormat;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.common.factory.ParseTreeUtil;
import org.example.semantic.intf.type.PrimitiveType;
import org.example.semantic.intf.type.ReferenceType;
import org.example.semantic.intf.type.Type;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.exp.ExpType;
import org.example.styler.exp.complexity.style.ExpressionContext;
import org.example.styler.exp.complexity.style.ExpressionProperty;
import org.example.utils.NameGenerator;
import org.example.utils.searcher.intf.CompilationUnitSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ExpressionStyler extends Styler {
    private static final Logger log = LoggerFactory.getLogger(ExpressionStyler.class);

    public ExpressionStyler() {
        style.setStyleName("most_complex_expression");
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
            boolean moreComplex = styleProperty.maxExpressionLength > targetProperty.maxExpressionLength
                    || styleProperty.maxSubExpNum > targetProperty.maxSubExpNum;
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
        return ctx.getRuleIndex() == parser.getRuleExpStmt() || ctx.getRuleIndex() == parser.getRuleParExpression();
    }

    private ExpressionContext extractStyleContext(ExtendContext expression, MyParser parser) {
        ExpType expType = null;
        if (expression.getRuleIndex() == parser.getRuleExpStmt()) {
            expType = expression.getAllTerminalsIf(ter -> ter.getText().equals("?") || ter.getText().equals(":")).size() == 2
                    ? ExpType.TERNARY_EXP
                    : ExpType.TOP_EXP;
        } else if (expression.getRuleIndex() == parser.getRuleParExpression()) {
            expType = ExpType.CONDITIONAL_EXP;
        }
        return expType == null ? null : new ExpressionContext(expType);
    }

    private ExpressionProperty extractStyleProperty(ExtendContext expression, MyParser parser) {
        int length = expression.getText().length();
        int subExpNum = expression.getAllTokensRecIf(ctx -> ctx.getRuleIndex() == parser.getRuleExpression()).size();
        return new ExpressionProperty(length, subExpNum);
    }


    private void mergeExpression(ExtendContext expression, ExpressionProperty curProperty, ExpressionProperty targetProperty, MyParser parser) {

    }

    private void splitExpression(ExtendContext expression, ExpressionProperty curProperty, ExpressionProperty targetProperty, MyParser parser) {
        Map<String, List<ExtendContext>> expressionMap = new HashMap<>();
        extractSameExpression(expression, expressionMap, parser);

        int count = 1;
        CaseFormat caseFormat = CaseFormat.LOWER_CAMEL;
        List<Map.Entry<String, List<ExtendContext>>> sortedEntries = new ArrayList<>(expressionMap.entrySet().stream().toList());
        sortedEntries.sort(Comparator.comparing((Map.Entry<String, List<ExtendContext>> e) -> e.getValue().size())
                        .thenComparing((Map.Entry<String, List<ExtendContext>> e) -> e.getKey().length() * e.getValue().size()));
        for (Map.Entry<String, List<ExtendContext>> entry : sortedEntries) {
            // Preparation for create declaration statement.
            String name = NameGenerator.generateName("", caseFormat);
            while (mayConflict(name, parser)) {
                name = NameGenerator.generateName(String.valueOf(count++), caseFormat);
            }
            Type type = GlobalInfo.getResolver().resolveExpression(entry.getValue().get(0), parser);

            // do split
            ExtendContext decStmt = addVarDeclaration(type, name, entry.getValue().get(0), parser);
            if (decStmt == null) {
                log.info("Fail to split expression because of adding variable declaration failed.");
                return;
            }
            ExtendContext identifier = parser.getDecStmtSearcher().searchIdentifiers(decStmt, parser).get(0);
            replaceChildren(entry.getValue(), List.of(identifier), parser);

            curProperty.maxExpressionLength -= (entry.getKey().length() - name.length()) * entry.getValue().size();
            if (curProperty.maxExpressionLength <= targetProperty.maxExpressionLength) {
                break;
            }
        }
    }

    private void extractSameExpression(ExtendContext expression, Map<String, List<ExtendContext>> expressionMap, MyParser parser) {
        expressionMap.computeIfAbsent(expression.getText(), k -> new ArrayList<>()).add(expression);
        for (ParseTree child : expression.children) {
            if (child instanceof ExtendContext ctx && ctx.getRuleIndex() == parser.getRuleExpression() && ctx.getChildCount() > 1) {
                extractSameExpression(expression,  expressionMap, parser);
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
            CompilationUnitSearcher cuSearcher = parser.getCUSearcher();
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
