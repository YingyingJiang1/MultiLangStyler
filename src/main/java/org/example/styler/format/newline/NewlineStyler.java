package org.example.styler.format.newline;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.RuleGroup;
import org.example.parser.common.context.RuleGrouper;
import org.example.parser.common.token.TokenGroup;
import org.example.parser.common.token.TokenGrouper;
import org.example.styler.Stage;
import org.example.styler.format.newline.style.NewlineContext;
import org.example.styler.format.newline.style.NewlineProperty;
import org.example.styler.Styler;
import org.example.styler.format.newline.style.NewlineStyle;

import java.util.*;
import java.util.function.Function;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 11:45
 */
public class NewlineStyler extends Styler {
    private NewlineContext defaultContext = new NewlineContext(RuleGroup.SINGLE_STMT.name(), "");
    Set<Integer> relevantRules = null;
    Class<? extends MyParser> parserClass = null;

    public NewlineStyler() {
        style = new NewlineStyle();
        style.setStyleName("newline");

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

    private void setMinTextLength(AdjacentCodeBlock adjacentCode, NewlineContext context, NewlineProperty property, MyParser parser) {
        // More than one single statement in a line.
        String singleStmt = RuleGroup.SINGLE_STMT.name();
        boolean between2SingleStmts = context.typeName1.equals(singleStmt) && context.typeName2.equals(singleStmt);
        if (between2SingleStmts) {
            if (property.newlines == 0) {
                context.minTextLength = adjacentCode.calculateTextLength(property.newlines, parser, Stage.EXTRACT);
            }
        } else {
            Set<String> stmtNames = Set.of(RuleGroup.SINGLE_STMT.name(), RuleGroup.COMPOUND_STMT.name());
            boolean isStmtLevel = stmtNames.contains(context.typeName1) && stmtNames.contains(context.typeName2);
            if (isStmtLevel && property.newlines > 1) {
                context.minTextLength = adjacentCode.calculateTextLength(property.newlines, parser, Stage.EXTRACT);
            }
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
                NewlineContext context = extractContext(adjacentCode, parser);
                executor.apply(adjacentCode);
            }
        }
    }
    
    
    private AdjacentCodeBlock.CodeBlock generateCodeBlock(ExtendContext parent, int index, int blockNumber) {
        AdjacentCodeBlock.CodeBlock info = new AdjacentCodeBlock.CodeBlock();
        ParseTree node = parent.getChild(index);
        if (node instanceof ExtendContext ctx) {
            info.token = (ExtendToken) (blockNumber == 1 ? ctx.getStop() : ctx.getStart());
            info.type = ctx.getRuleIndex();
        } else {
            info.token = (ExtendToken) ((TerminalNode) node).getSymbol();
            info.type = -info.token.getType();
        }

        info.line = info.token.getLine();
        info.textLength = node.getText().length();
        info.index = index;
        return info;
    }

    private NewlineContext extractContext(AdjacentCodeBlock adjacentCodeBlock, MyParser parser) {
        AdjacentCodeBlock.CodeBlock codeBlock1 = adjacentCodeBlock.child1, codeBlock2 = adjacentCodeBlock.child2;
        String typeName1 = getTypeName(codeBlock1, parser), typeName2 = getTypeName(codeBlock2, parser);
        return new NewlineContext(typeName1, typeName2, 0);
    }


    private int getLine(int startLine, String text) {
        if(text.startsWith("//")) {
            return startLine;
        }
        int countNewline = 0;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '\n') {
                ++countNewline;
            }
        }
        return startLine + countNewline;
    }

    private List<AdjacentCodeBlock> extractCodeBlocks(ExtendContext parent, int index1, int index2, Stage stage, MyParser parser) {
        List<AdjacentCodeBlock> adjacentCodes = new ArrayList<>();
        AdjacentCodeBlock.CodeBlock codeBlock1 = generateCodeBlock(parent, index1, 1);
        AdjacentCodeBlock.CodeBlock codeBlock2 = generateCodeBlock(parent, index2, 2);
        if(codeBlock1.token.getType() == parser.getVws() || codeBlock2.token.getType() == parser.getVws()) {
            return adjacentCodes;
        }

        adjacentCodes.add(new AdjacentCodeBlock(parent, codeBlock1, codeBlock2));

//        List<Token> nonDefaultTokens = codeBlock2.token.getContextTokens();
//        int lastCommentIndexBefore = codeBlock2.token.indexOfLastTokenBeforeIf(parser::belongToComment);
//        boolean hasCommentBefore = lastCommentIndexBefore >= 0;
//        if(hasCommentBefore) {
//            /*
//             * line1:a = 1;
//             * line2:// comment
//             * line3:b = 2;
//             * extraction: get a newline between (line1, line2),(line2,line3)
//             * application: insert a newline between (line1,line2),(line2,line3)
//             */
//            int firstCmtIndexBefore = codeBlock2.token.indexOfFirstTokenBeforeIf(parser::belongToComment);
//            ExtendToken firstCmtToken = (ExtendToken) nonDefaultTokens.get(firstCmtIndexBefore);
//            ExtendToken lastCmtToken = (ExtendToken) nonDefaultTokens.get(lastCommentIndexBefore);
//            int commentLength = firstCmtIndexBefore == lastCommentIndexBefore ? firstCmtToken.getText().length() :
//                    codeBlock2.token.getContextTokens().subList(firstCmtIndexBefore, lastCommentIndexBefore + 1).stream().mapToInt(t -> t.getText().length()).sum();
//            AdjacentCodeBlock.CodeBlock firstCmtBlock = new AdjacentCodeBlock.CodeBlock(firstCmtIndexBefore, -firstCmtToken.getType(), commentLength,
//                    codeBlock2.token);
//            AdjacentCodeBlock.CodeBlock lastCmtBlock = new AdjacentCodeBlock.CodeBlock(lastCommentIndexBefore, -lastCmtToken.getType(), commentLength,
//                    codeBlock2.token);
//            lastCmtBlock.line = getLine(lastCmtToken.getLine(), lastCmtToken.getText());
//
//            adjacentCodes.add(new AdjacentCodeBlock(ctx, codeBlock1, firstCmtBlock));
//            adjacentCodes.add(new AdjacentCodeBlock(ctx, lastCmtBlock, codeBlock2));
//        }

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
                if (parser.belongToComment(contextTokens.get(j).getType())) {
                    newlines -= contextTokens.get(i).getText().split("\n").length;
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
        boolean hasTrailingLineComment = info.token.indexOfLastTokenAfterIf(type -> type == parser.getLineComment()) > 0;
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

        RuleGroup group = RuleGrouper.getInstance().getGroup(type, parser);
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
