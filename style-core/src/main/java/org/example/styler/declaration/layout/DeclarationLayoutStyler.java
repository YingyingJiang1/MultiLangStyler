package org.example.styler.declaration.layout;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.RunStatistic;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.ASTNodeSearcher;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.common.token.ExtendToken;
import org.example.style.ApplyOperation;
import org.example.style.InconsistencyInfo;
import org.example.style.InconsistencyType;
import org.example.style.StyleApplyData;
import org.example.style.codecontext.CodeContext;
import org.example.style.codecontext.ListASTBasedCodeContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.declaration.layout.style.DeclarationLayoutContext;
import org.example.styler.declaration.layout.style.DeclarationLayoutProperty;
import org.example.styler.declaration.layout.style.DeclarationLayoutStyle;
import org.example.lang.intf.searcher.VarDeclarationSearcher;

import java.util.*;

public class DeclarationLayoutStyler extends Styler {
    private Map<DeclarationLayoutContext, Integer> maxLengthMap = new HashMap<>();

    public DeclarationLayoutStyler() {
        style = new DeclarationLayoutStyle();
    }


    /**
     * @param ctx Local variable declaration statement node or field declaration statement node.
     */
    @Override
    protected List<CodeContext> constructCodeContext(ExtendContext ctx, MyParser parser) {
        List<List<ExtendContext>> decGroup = getMergeableDecGroup(ctx, parser);
        List<CodeContext> codeContexts = new ArrayList<>();

        for (List<ExtendContext> group : decGroup) {
            codeContexts.add(new ListASTBasedCodeContext(group));
        }

        return codeContexts;
    }



    @Override
    protected ExtendContext doApply(CodeContext codeContext, StyleProperty currentProperty,
                                    StyleProperty targetProperty, MyParser parser) {
        List<ExtendContext> nodes = (List<ExtendContext>) ((ListASTBasedCodeContext) codeContext).getNodes();

        if (targetProperty instanceof DeclarationLayoutProperty target && target.isMerge()) {
            LangAdapterCreator.createASTRewriter(parser.getLanguage()).mergeVarDeclarations(nodes, parser);
        } else {
            LangAdapterCreator.createASTRewriter(parser.getLanguage()).splitVarDeclarations(nodes, parser);
        }
        return null;
    }

    @Override
    protected InconsistencyInfo generateInconsistencyInfo(CodeContext codeContext, StyleProperty currentProperty,
                                                          StyleProperty targetProperty, MyParser parser) {
        if (currentProperty instanceof DeclarationLayoutProperty current &&
                targetProperty instanceof DeclarationLayoutProperty target) {

            if (current.isMerge() == target.isMerge()) {
                return null;
            }

            InconsistencyInfo info = new InconsistencyInfo(
                    InconsistencyType.DECLARATION_LAYOUT,
                    target.isMerge() ? "merge" : "split",
                    current.isMerge() ? "merged" : "separate", "",
                    new InconsistencyInfo.Location(codeContext)
            );

            return info;
        }
        return null;
    }


    @Override
    protected boolean isInconsistent(StyleProperty currentProperty, StyleProperty targetProperty, MyParser parser) {
        if (currentProperty instanceof DeclarationLayoutProperty current &&
                targetProperty instanceof DeclarationLayoutProperty target) {
            return target.isMerge() && current.hasSingleDec()
                    || !target.isMerge() && current.hasMergedDec();
        }
        return false;
    }

    @Override
    protected DeclarationLayoutProperty extractStyleProperty(CodeContext codeContext, MyParser parser) {
        if (codeContext instanceof ListASTBasedCodeContext listContext) {
            List<ExtendContext> decNodes = (List<ExtendContext>) listContext.getNodes();
            ASTNodeSearcher searcher = LangAdapterCreator.createASTNodeSearcher(parser.getLanguage());
            int mergedCount = 0;
            int totalVarCount = 0;
            for (ExtendContext decNode : decNodes) {
                int count = searcher.searchAllDeclaredIdentifiers(decNode).size();
                totalVarCount += count;
                if (count > 1) {
                    mergedCount += count;
                }
            }

            return new DeclarationLayoutProperty(mergedCount, totalVarCount);
        }
        return null;
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
                        LangAdapterCreator.createNodeSearcherFactory(parser.getLanguage()).createVarDeclarationSearcher()
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
            VarDeclarationSearcher searcher = LangAdapterCreator.createNodeSearcherFactory(parser.getLanguage()).createVarDeclarationSearcher();
            searcher.searchModifiers(decNode, parser).forEach(e -> ctx.modifiers.add(e.getText()));
            ctx.type = searcher.searchTypeNode(decNode, parser).getText();
            ctx.hasComment = ((ExtendToken) decNode.getStop()).indexOfFirstTokenAfterIf(parser::isComment) >= 0;
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
