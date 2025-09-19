package org.example.styler.format;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.context.FineGrainedRuleGrouper;
import org.example.parser.common.token.ExtendToken;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.RuleGroup;
import org.example.parser.common.token.TokenGroup;
import org.example.parser.common.token.TokenGrouper;
import org.example.styler.Stage;
import org.example.styler.format.style.NewlineContext;
import org.example.styler.format.style.NewlineProperty;
import org.example.styler.Styler;
import org.example.styler.format.style.NewlineStyle;

import java.util.*;
import java.util.function.Function;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 11:45
 */
public class BlankLineStyler extends Styler {
    Set<Integer> relevantRules = null;
    Class<? extends MyParser> parserClass = null;


    public BlankLineStyler() {
        style = new NewlineStyle();
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        Function<AdjacentCodeBlock, Void> extractor = new Function<AdjacentCodeBlock, Void>() {
            @Override
            public Void apply(AdjacentCodeBlock adjacentCode) {
                NewlineContext context = extractContext(adjacentCode, parser);
                NewlineProperty property = extractProperty(adjacentCode, parser);

                // A newline adjacent to a brace is seen as a part of brace format.
                if (adjacentCode.child1.token.getType() == parser.getRBrace() ||
                        adjacentCode.child1.token.getType() == parser.getSemi() && context.typeName1.equals(RuleGroup.FUNCTION_DEC.name())) {
                    --property.newlines;
                }
                if (adjacentCode.child2.token.getType() == parser.getLBrace()) {
                    --property.newlines;
                }
                // The first new line between two adjacent single statements(statement ends with ;) will be processed by LineStmtStyler.
                if (RuleGroup.isSingleStmt(context.typeName1) && RuleGroup.isSingleStmt(context.typeName2)) {
                    --property.newlines;
                }

                setMinTextLength(adjacentCode, context, property, parser);
                style.addRule(context, property);
                return null;
            }
        };

        framework(ctx, extractor, parser);
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        Function<AdjacentCodeBlock, Void> applicator = new Function<AdjacentCodeBlock, Void>() {
            @Override
            public Void apply(AdjacentCodeBlock adjacentCodeBlock) {
                // First try to add some blank lines, second try to add a newline.
                NewlineContext newlineContext = extractContext(adjacentCodeBlock, parser);
                newlineContext.minTextLength = adjacentCodeBlock.calculateTextLength(2, parser, Stage.APPLY);
                NewlineProperty newlineProperty = (NewlineProperty) style.getSimilarProperty(newlineContext);
                if (newlineProperty == null) {
                    newlineContext.minTextLength = adjacentCodeBlock.calculateTextLength(1,parser, Stage.APPLY);
                    newlineProperty = (NewlineProperty) style.getSimilarProperty(newlineContext);
                }

                if (newlineProperty == null) {
                    return null;
                }

                int insertionPoint = adjacentCodeBlock.child1.index + 1;
                if (newlineProperty.newlines > 0) {
                    // child1: comment. child2: a syntax rule.
                    if(parser.belongToComment(adjacentCodeBlock.child1.token.getType())) {
                        String vwsStr = StringUtils.repeat(System.lineSeparator(), newlineProperty.newlines);
                        Token vwsToken = parser.getTokenFactory().create(parser.getVws(), vwsStr);
                        // Insert vws before the leading comment.
                        adjacentCodeBlock.child2.token.addToken(
                                adjacentCodeBlock.child2.token.indexOfFirstTokenBeforeIf(parser::belongToComment),
                                vwsToken
                        );
                    } else if(insertionPoint >= 0) { // codeBlock1: a rule info
                        ExtendToken token1 = adjacentCodeBlock.child1.token;
                        int newlines = newlineProperty.newlines;
                        newlines -= getNewlineAfter(adjacentCodeBlock.parentCtx, adjacentCodeBlock.child1, parser);
                        if (newlines > 0) {
                            Token vws = parser.getTokenFactory().create(parser.getVws(), StringUtils.repeat(System.lineSeparator(), newlines));
                            adjacentCodeBlock.child1.token.addTokenAfter(vws, parser);
                            return null;
                        }
                    }
                }
                return null;
            }
        };

        framework(ctx, applicator,parser);
        return ctx;
    }

    /**
     * Set `minTextLength` for statement-level code blocks.
     */
    private void setMinTextLength(AdjacentCodeBlock adjacentCode, NewlineContext context, NewlineProperty property, MyParser parser) {
        // When there are more than one newline between two statement-level code blocks, text length of these two blocks are taken into consideration.
        Set<String> stmtNames = new HashSet<>();
        for (RuleGroup ruleGroup : RuleGroup.values()) {
            stmtNames.add(ruleGroup.name());
        }
        boolean isStmtLevel = (RuleGroup.isSingleStmt(context.typeName1) || RuleGroup.isCompoundStmt(context.typeName1)) &&
                (RuleGroup.isSingleStmt(context.typeName2) || RuleGroup.isCompoundStmt(context.typeName2));
        if (isStmtLevel && property.newlines > 0) {
            context.minTextLength = adjacentCode.calculateTextLength(property.newlines, parser, Stage.EXTRACT);
        }
    }


    @Override
    protected Set<Integer> getRelevantRules(MyParser parser) {
        if (parserClass == null || parserClass != parser.getClass()) {
            relevantRules = new HashSet<>();
            relevantRules.add(parser.getRuleCompilationUnit());
            relevantRules.add(parser.getRuleImportDeclarationList());
            relevantRules.addAll(parser.getMemberLists());
            relevantRules.add(parser.getRuleAnnotationList());
            relevantRules.add(parser.getRuleBody());    
            relevantRules.add(parser.getRuleBlock());
            relevantRules.add(parser.getRuleModifierList());
        }
        return relevantRules;
    }

    private void framework(ExtendContext ctx, Function<AdjacentCodeBlock, Void> executor, MyParser parser) {
        for (int i = 0; i < ctx.getChildCount() - 1; i++) {
            if (ctx.getChild(i) instanceof TerminalNode) {
                continue;
            }
            if (ctx.getChild(i + 1) instanceof TerminalNode && !parser.isAnnotation(ctx.getChild(i))) {
                ++i;
                continue;
            }

            List<AdjacentCodeBlock> codes = extractCodeBlocks(ctx, i, i + 1, Stage.EXTRACT, parser);
            for(AdjacentCodeBlock adjacentCode : codes) {
                executor.apply(adjacentCode);
            }
        }
    }

//    @Override
//    public void doFinalize() {
//        // Add derived rules.
//        Map<StyleContext, StyleProperty> derivedRules = new HashMap<>();
//        for (StyleRule rule : style.getRules()) {
//            if (rule.getStyleContext() instanceof NewlineContext styleContext) {
//                RuleGroup superGroup1 = RuleGroup.getSuperGroup(styleContext.typeName1);
//                RuleGroup superGroup2 = RuleGroup.getSuperGroup(styleContext.typeName2);
//                if (superGroup1 != null && superGroup2 != null) {
//                    StyleContext newContext = new NewlineContext(superGroup1.name(), superGroup2.name(), styleContext.minTextLength, styleContext.hasSameDecType);
//                    if (style.getProperty(newContext) == null) {
//                        derivedRules.put(newContext, rule.getStyleProperty());
//                    }
//                }
//            }
//        }
//
//        for (Map.Entry<StyleContext, StyleProperty> entry : derivedRules.entrySet()) {
//            style.addRule(entry.getKey(), entry.getValue());
//        }
//    }

    private AdjacentCodeBlock.CodeBlock generateCodeBlock(ExtendContext parent, int index, int blockNumber, MyParser parser) {
        AdjacentCodeBlock.CodeBlock info = new AdjacentCodeBlock.CodeBlock();
        ParseTree node = parent.getChild(index);
        if (node instanceof ExtendContext ctx) {
            info.token = (ExtendToken) (blockNumber == 1 ? ctx.getStop() : ctx.getStart());
            info.type = ctx.getRuleIndex();
            if (parser.isStatement(ctx)) {
                info.type = parser.getSpecificStmtType(ctx);
            }
        } else {
            info.token = (ExtendToken) ((TerminalNode) node).getSymbol();
            info.type = -info.token.getType();
        }

        info.line = info.token.getLine();
        info.textLength = node.getText().length();
        info.index = index;
        info.treeNode = node;
        return info;
    }

    private NewlineContext extractContext(AdjacentCodeBlock adjacentCodeBlock, MyParser parser) {
        AdjacentCodeBlock.CodeBlock codeBlock1 = adjacentCodeBlock.child1, codeBlock2 = adjacentCodeBlock.child2;
        String typeName1 = getTypeName(codeBlock1, parser), typeName2 = getTypeName(codeBlock2, parser);

        boolean hasSameDataType = false;
        boolean is2declarationStmts = typeName1.equals(RuleGroup.DECLARATION_STMT.name()) && typeName2.equals(typeName1);
        if (is2declarationStmts) {
            if (codeBlock1.treeNode instanceof ExtendContext decStmt1 && codeBlock2.treeNode instanceof ExtendContext decStmt2) {
                String dataType1 = decStmt1.getFirstContextRecIf(parser::isTypeType).getText();
                String dataType2 = decStmt2.getFirstContextRecIf(parser::isTypeType).getText();
                hasSameDataType = dataType1.equals(dataType2);
            }
        }

        boolean hasComment = false;
        if (codeBlock2.treeNode instanceof ExtendContext ctx && ctx.getStart() instanceof ExtendToken token) {
            hasComment = token.getContextTokens().stream().anyMatch(t -> parser.belongToComment(t.getType()));
        }
        NewlineContext context = new NewlineContext(typeName1, typeName2, 0, hasSameDataType);
        context.hasComment = hasComment;
        return context;
    }


    private List<AdjacentCodeBlock> extractCodeBlocks(ExtendContext parent, int index1, int index2, Stage stage, MyParser parser) {
        List<AdjacentCodeBlock> adjacentCodes = new ArrayList<>();
        AdjacentCodeBlock.CodeBlock codeBlock1 = generateCodeBlock(parent, index1, 1, parser);
        AdjacentCodeBlock.CodeBlock codeBlock2 = generateCodeBlock(parent, index2, 2, parser);
        if(codeBlock1.token.getType() == parser.getVws() || codeBlock2.token.getType() == parser.getVws()) {
            return adjacentCodes;
        }

        adjacentCodes.add(new AdjacentCodeBlock(parent, codeBlock1, codeBlock2));


        return adjacentCodes;
    }

    private NewlineProperty extractProperty(AdjacentCodeBlock adjacentCodeBlock, MyParser parser) {
        AdjacentCodeBlock.CodeBlock codeBlock1 = adjacentCodeBlock.child1, codeBlock2 = adjacentCodeBlock.child2;
        int newlines = codeBlock2.line - codeBlock1.line;

        // delete comments line between codeBlock1 and codeBlock2.
        List<Token> contextTokens = codeBlock2.token.getContextTokens();
        if (contextTokens != null) {
            int i = codeBlock2.token.indexInContextTokens();
            for (int j = 0; j < i; j++) {
                Token  token = contextTokens.get(j);
                if (parser.belongToComment(token.getType())) {
                    newlines -= token.getText().split("\n").length;
                }
            }
        }
        return new NewlineProperty(newlines);
    }


    /**
     *
     * @param adjacentCodeBlock
     * @return the length of the shift to right.
     */
    private int applyProperty(ExtendContext parent, AdjacentCodeBlock adjacentCodeBlock, MyParser parser) {
        // First try to add some blank lines, second try to add a newline.
        NewlineContext newlineContext = extractContext(adjacentCodeBlock, parser);
        newlineContext.minTextLength = adjacentCodeBlock.calculateTextLength(2, parser, Stage.APPLY);
        NewlineProperty newlineProperty = (NewlineProperty) style.getSimilarProperty(newlineContext);
        if (newlineProperty == null) {
            newlineContext.minTextLength = adjacentCodeBlock.calculateTextLength(1,parser, Stage.APPLY);
            newlineProperty = (NewlineProperty) style.getSimilarProperty(newlineContext);
        }

        if (newlineProperty == null) {
            return 0;
        }

        int insertionPoint = adjacentCodeBlock.child1.index + 1;
        if (newlineProperty.newlines > 0) {
            // child1: comment. child2: a syntax rule.
            if(parser.belongToComment(adjacentCodeBlock.child1.token.getType())) {
                String vwsStr = StringUtils.repeat(System.lineSeparator(), newlineProperty.newlines);
                Token vwsToken = parser.getTokenFactory().create(parser.getVws(), vwsStr);
                // Insert vws before the leading comment.
                adjacentCodeBlock.child2.token.addToken(
                        adjacentCodeBlock.child2.token.indexOfFirstTokenBeforeIf(parser::belongToComment),
                        vwsToken
                );
            } else if(insertionPoint >= 0) { // codeBlock1: a rule info
                ExtendToken token1 = adjacentCodeBlock.child1.token;
                int newlines = newlineProperty.newlines;
                newlines -= getNewlineAfter(parent, adjacentCodeBlock.child1, parser);
                if (newlines > 0) {
                    adjacentCodeBlock.parentCtx.addTerNode(parser.getVws(), StringUtils.repeat(System.lineSeparator(), newlines), insertionPoint);
                    return 1;
                }
            }
        }
        return 0;
    }

    private int getNewlineAfter(ExtendContext parent, AdjacentCodeBlock.CodeBlock info, MyParser parser) {
        int count = 0;
        // line comment has a newline at the end, so sub 1.
        boolean hasTrailingLineComment = info.token.indexOfFirstTokenAfterIf(type -> type == parser.getLineComment()) > 0;
        if(hasTrailingLineComment) {
            count = 1;
        }
        if(parent.getChild(info.index) instanceof ExtendContext stmt) {
            for (int i = stmt.getChildCount() - 1; i >= 0 ; i--) {
                if(stmt.getChild(i) instanceof TerminalNode &&
                        ((TerminalNode) stmt.getChild(i)).getSymbol().getType() == parser.getVws()) {
                    ++count;
                } else {
                    break;
                }
            }
        } else {
            for (int i = info.index + 1; i < parent.getChildCount(); i++) {
                if(parent.getChild(i) instanceof TerminalNode &&
                        ((TerminalNode) parent.getChild(i)).getSymbol().getType() == parser.getVws()) {
                    ++count;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    private String getTypeName(AdjacentCodeBlock.CodeBlock codeBlock, MyParser parser) {
        int type= codeBlock.type;
        if (codeBlock.type < 0) {
            TokenGroup group = TokenGrouper.getInstance().getGroup(codeBlock.token, parser);
            if (group == TokenGroup.SELF_TOKEN) {
                return codeBlock.token.getText();
            }
            return group.name();
        }

        RuleGroup group = FineGrainedRuleGrouper.getInstance(parser.getLanguage()).getGroup(type, parser);
        if (group == RuleGroup.SELF_RULE) {
            return parser.getRuleName(type);
        }
        return group.name();
    }


    // Information of relevant structure.
    static class AdjacentCodeBlock {
        ExtendContext parentCtx;
        CodeBlock child1, child2;
        static class CodeBlock {
            int index;
            int type; // type of last rule of a code block.
            int line;
            // If there's one newline between two code blocks, then `textLength` = "text length of last statement of block1" or "text length of first statement of block2".
            // If there are multiple newlines between tow code blocks, then 'textLength` = "text length of block1" or "text length of block2".
            int textLength = 0;
            ParseTree treeNode;
            ExtendToken token;
            
            public CodeBlock() {
            }

            public CodeBlock(int index, int type, int textLength, ExtendToken token) {
                this.index = index;
                this.type = type;
                this.textLength = textLength;
                this.token = token;
                this.line = token.getLine();
            }

            public CodeBlock(CodeBlock info) {
                index = info.index;
                type = info.type;
                line = info.line;
                token = info.token;
            }
        }

        public AdjacentCodeBlock() {}

        public AdjacentCodeBlock(ExtendContext parentCtx, CodeBlock child1, CodeBlock child2) {
            this.parentCtx = parentCtx;
            this.child1 = child1;
            this.child2 = child2;
        }

        public int calculateTextLength(int newline, MyParser parser, Stage stage) {

            if (newline > 1) {
                if (child1.type >= 0) {
                    for (int i = child2.index + 1; i < parentCtx.getChildCount(); i++) {
                        if (noBlankLineBetween(parentCtx.getChild(i - 1), parentCtx.getChild(i),parser, stage)) {
                            child2.textLength += parentCtx.getChild(i).getText().length();
                        }
                    }
                }

                if (child2.type >= 0) {
                    for (int i = child1.index - 1; i >= 0; i--) {
                        if (noBlankLineBetween(parentCtx.getChild(i), parentCtx.getChild(i + 1),parser, stage)) {
                            child1.textLength += parentCtx.getChild(i).getText().length();
                        }
                    }
                }
            }
            return child1.textLength + child2.textLength;
        }

        private boolean noBlankLineBetween(ParseTree pre, ParseTree cur, MyParser parser, Stage stage) {
            Token lastToken = pre instanceof TerminalNode ter ? ter.getSymbol() : ((ExtendContext) pre).getStop();
            Token firstToken = cur instanceof TerminalNode ter ? ter.getSymbol() : ((ExtendContext) cur).getStart();
            if (stage == Stage.EXTRACT) {
                return firstToken.getLine() - lastToken.getLine() < 1;
            } else if (stage == Stage.APPLY) {
                // Note: the value of Token.getLine() is invalid in application stage.
                if (lastToken instanceof ExtendToken lastExtToken && firstToken instanceof  ExtendToken firstExtToken) {
                    int newline = 0;
                    if (lastExtToken.getContextTokens() != null) {
                        for (int i = lastExtToken.getContextTokens().size() - 1; i >= 0; i--) {
                            Token token = lastExtToken.getContextTokens().get(i);
                            if (token.getType() == parser.getVws()) {
                                ++newline;
                            } else {
                                break;
                            }
                        }
                    }
                    if (firstExtToken.getContextTokens() != null) {
                        for (int i = 0; i < firstExtToken.getContextTokens().size(); i++) {
                            Token token = firstExtToken.getContextTokens().get(i);
                            if (token.getType() == parser.getVws()) {
                                --newline;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
}
