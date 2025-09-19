package org.example.styler.declaration.layout;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.logging.log4j.spi.Terminable;
import org.example.RunStatistic;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.declaration.layout.style.DeclarationLayoutContext;
import org.example.styler.declaration.layout.style.DeclarationLayoutProperty;
import org.example.styler.declaration.layout.style.DeclarationLayoutStyle;
import org.example.utils.ParseTreeUtil;
import org.example.utils.searcher.NodeSearcherFactory;
import org.example.utils.searcher.intf.VarDeclarationSearcher;

import java.util.*;

public class DeclarationLayoutStyler extends Styler {
    private Map<DeclarationLayoutContext, Integer> maxLengthMap = new HashMap<>();

    public DeclarationLayoutStyler() {
        style = new DeclarationLayoutStyle();
    }


    /**
     *
     * @param ctx Local variable declaration statement node or field declaration statement node.
     * @param parser
     */
    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        List<List<ExtendContext>> decGroup = getMergeableDecGroup(ctx, parser);
        for (List<ExtendContext> group : decGroup) {
            DeclarationLayoutProperty property = extractProperty(group,parser);
            style.addRule(null, property);
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        List<List<ExtendContext>> decGroup = getMergeableDecGroup(ctx, parser);
        for (List<ExtendContext> group : decGroup) {
            DeclarationLayoutProperty property = extractProperty(group,parser);
            if (style.getProperty(null) instanceof DeclarationLayoutProperty targetProperty) {
                if (targetProperty.isMerge() && property.hasSingleDec()) {
                    ParseTreeUtil.getInstance().mergeDeclarations(group, parser);
                    RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                } else if (!targetProperty.isMerge() && property.hasMergedDec()) {
                    ParseTreeUtil.getInstance().splitDeclarations(group, parser);
                    RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                }
            }
        }
        return ctx;
    }

    private DeclarationLayoutProperty extractProperty(List<ExtendContext> decNodes, MyParser parser) {
        VarDeclarationSearcher searcher = NodeSearcherFactory.getInstance().createVarDeclarationSearcher();
        int mergedCount = 0;
        int totalVarCount = 0;
        for (ExtendContext decNode : decNodes) {
            int count = searcher.searchIdentifiers(decNode, parser).size();
            totalVarCount += count;
            if (count > 1) {
                mergedCount += count;
            }
        }

        return new DeclarationLayoutProperty(mergedCount, totalVarCount);
    }

    /**
     * @param ctx block or body
     * @param parser
     * @return
     */
    private List<List<ExtendContext>> getMergeableDecGroup(ExtendContext ctx, MyParser parser) {
        List<List<ExtendContext>> groups = new ArrayList<>();
        // 临时存储同类型变量声明的连续组
        List<ExtendContext> currentGroup = new ArrayList<>();
        VarDecContext curVarDecContext = null;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (isVarDeclaration(child, parser)) {
                ExtendContext curNode = (ExtendContext) child;
                if (curVarDecContext == null) {
                    curVarDecContext = VarDecContext.parseContext(curNode, parser);
                    curVarDecContext.indexInParent = i;
                    currentGroup.add(curNode);
                } else {
                    VarDecContext varDecContext = VarDecContext.parseContext(curNode, parser);
                    varDecContext.indexInParent = i;
                    if (curVarDecContext.hasSameContext(varDecContext)) {
                        currentGroup.add(curNode);
                        curVarDecContext = varDecContext; // 必须更新，因为hasSameContext的实现不是单纯地判断值相等
                    } else {
                        if (isValidDecGroup(currentGroup, parser)) {
                            groups.add(new ArrayList<>(currentGroup));
                        }
                        currentGroup.clear();
                        curVarDecContext = varDecContext;
                        currentGroup.add(curNode);
                    }
                }
            } else {
                if (isValidDecGroup(currentGroup, parser)) {
                    groups.add(new ArrayList<>(currentGroup));
                }
                currentGroup.clear();
                curVarDecContext = null;
            }
        }

        if (isValidDecGroup(currentGroup, parser)) {
            groups.add(new ArrayList<>(currentGroup));
        }
        return groups;
    }

    private boolean isValidDecGroup(List<ExtendContext> decGroup, MyParser parser) {
        return decGroup.size() > 1 ||
                ( decGroup.size() == 1 &&
                        NodeSearcherFactory.getInstance().createVarDeclarationSearcher()
                                .searchVarDeclaratorList(decGroup.get(0), parser).size() > 1);
    }


    private boolean isVarDeclaration(ParseTree node, MyParser parser) {
        if (node == null || node instanceof TerminalNode) return false;
        int rule = parser.getSpecificStmtType(((ExtendContext) node));
        return rule == parser.getRuleLocalVarDeclarationStmt()
                || rule == parser.getRuleFieldDeclaration();
    }



    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return parser.isBlock(ctx) || parser.isFieldDeclarationList(ctx);
    }


    private boolean hasSameDeclarationPrefix(ExtendContext declarators1, ExtendContext declarators2, MyParser parser) {
        ExtendContext parent1 = (ExtendContext) declarators1.parent;
        ExtendContext parent2 = (ExtendContext) declarators2.parent;
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        parent1.children.subList(0, parent1.children.indexOf(declarators1))
                .forEach(p -> str1.append(p.getText()));
        parent2.children.subList(0, parent2.children.indexOf(declarators2))
                .forEach(p -> str2.append(p.getText()));
        return str1.toString().contentEquals(str2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeclarationLayoutStyler that = (DeclarationLayoutStyler) o;
        return Objects.equals(maxLengthMap, that.maxLengthMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(maxLengthMap);
    }


    private static class VarDecContext {
        String type;
        List<String> modifiers = new ArrayList<>();
        boolean hasComment;
        boolean hasTrailingComment;
        int indexInParent;

        public static VarDecContext parseContext(ExtendContext decNode, MyParser parser) {
            decNode = parser.getSpecificStmt(decNode);
            VarDecContext ctx = new VarDecContext();
            VarDeclarationSearcher searcher = NodeSearcherFactory.getInstance().createVarDeclarationSearcher();
            searcher.searchModifiers(decNode, parser).forEach(e -> ctx.modifiers.add(e.getText()));
            ctx.type = searcher.searchTypeNode(decNode, parser).getText();
            ctx.hasComment = ((ExtendToken) decNode.getStop()).indexOfFirstTokenAfterIf(parser::belongToComment) >= 0;
            ctx.hasTrailingComment = ((ExtendToken) decNode.getStop()).getTrailingCommentIndex(parser) >= 0;
            return ctx;
        }

        public boolean hasSameContext(VarDecContext that) {
            boolean valueEquals = Objects.equals(type, that.type) && Objects.equals(modifiers, that.modifiers);

            VarDecContext leftCtx = this, rightCtx = that;
            if (that.indexInParent < this.indexInParent) {
                leftCtx = that;
                rightCtx = this;
            }
            boolean hasCommentBetween = leftCtx.hasComment;
            return valueEquals && !hasCommentBetween && !rightCtx.hasTrailingComment;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof VarDecContext that)) return false;
			return Objects.equals(type, that.type) && Objects.equals(modifiers, that.modifiers);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, modifiers);
        }
    }
}
