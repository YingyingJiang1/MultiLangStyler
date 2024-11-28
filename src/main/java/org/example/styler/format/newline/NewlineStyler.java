package org.example.styler.format.newline;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.ExtendToken;
import org.example.parser.common.group.RuleGroup;
import org.example.parser.common.group.RuleGrouper;
import org.example.parser.common.group.TokenGrouper;
import org.example.parser.java.antlr.JavaParser;
import org.example.styler.Stage;
import org.example.styler.format.newline.style.NewlineContext;
import org.example.styler.format.newline.style.NewlineProperty;
import org.example.styler.Styler;
import org.example.styler.format.newline.style.NewlineStyle;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 11:45
 */
public class NewlineStyler extends Styler {
    private NewlineContext defaultContext = new NewlineContext(RuleGroup.SINGLE_STMT.name(), "");

    public NewlineStyler() {
        style = new NewlineStyle();
        style.setStyleName("newline");
        executeWhenExit = false;

        // In most cases: add a newline after single statement.
        style.addRule(defaultContext, new NewlineProperty(1));
        style.addRule(new NewlineContext(RuleGroup.FILE_HEAD_DEC.name(), ""), new NewlineProperty(1));
    }

    private static Set<Integer> relevantRules = new HashSet<>(Arrays.asList(
            JavaParser.RULE_compilationUnit,
            JavaParser.RULE_importDeclarationList, JavaParser.RULE_typeDeclarationList,
            JavaParser.RULE_fieldDeclarationList,
            JavaParser.RULE_constructorDeclarationList, JavaParser.RULE_methodDeclarationList,
            JavaParser.RULE_initializerList,
            JavaParser.RULE_block,JavaParser.RULE_body, JavaParser.RULE_switchBlockStatementGroup,
            JavaParser.RULE_annotationList, JavaParser.RULE_annotation, JavaParser.RULE_modifierList
    ));

    @Override
    public void extractStyle(ExtendContext ctx) {
        int len = ctx.getChildCount() - 1;
        for(int i = 0; i < len; ++i) {
            // Skip terminal node
            if (ctx.getChild(i) instanceof TerminalNode) {
                continue;
            }

            List<AdjacentCodeBlock> codes = extractCodeBlocks(ctx, i, i + 1, Stage.EXTRACT);
            for(AdjacentCodeBlock adjacentCode : codes) {
                NewlineProperty property = extractProperty(adjacentCode);
                NewlineContext context = extractContext(adjacentCode, property);

                // More than one single statement in a line.
                if (context.typeName1.equals(RuleGroup.SINGLE_STMT.name()) && property.newlines == 0) {
                    style.remove(defaultContext);
                }

                Set<String> typeNames = new HashSet<>();
                typeNames.add(context.typeName1);
                typeNames.add(context.typeName2);
                boolean isMemberDecBlocks = typeNames.contains(RuleGroup.MEMBER_LIST.name()) || typeNames.contains(RuleGroup.MEMBER_DEC.name());
                if (isMemberDecBlocks) {
                    context.minTextLength = 0; // Useless
                }

                style.addRule(context, property);
            }
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx) {
        for(int i = 0; i < ctx.getChildCount() - 1; ++i) {
            // Skip terminal node
            if (ctx.getChild(i) instanceof TerminalNode) {
                continue;
            }

            List<AdjacentCodeBlock> adjacentCodes = extractCodeBlocks(ctx, i, i + 1, Stage.APPLY);
            for(AdjacentCodeBlock adjacentCodeBlock : adjacentCodes) {
                // Must update index here! Because index will change after insertion operation.
                adjacentCodeBlock.child1.index = i;
                adjacentCodeBlock.child2.index = i + 1;
                i += applyProperty(ctx, adjacentCodeBlock);
            }
        }
        return ctx;
    }

    @Override
    protected Set<Integer> getRelevantRules() {
        return  relevantRules;
    }

    private AdjacentCodeBlock.CodeBlock generateCodeBlock(ExtendContext parent, int index, int flag) {
        AdjacentCodeBlock.CodeBlock info = new AdjacentCodeBlock.CodeBlock();
        ParseTree node = parent.getChild(index);
        if (node instanceof ExtendContext) {
            ExtendContext ctx = (ExtendContext) node;
            info.token = (ExtendToken) (flag == 1 ? ctx.getStop() : ctx.getStart());
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

    private NewlineContext extractContext(AdjacentCodeBlock adjacentCodeBlock, NewlineProperty property) {
        AdjacentCodeBlock.CodeBlock codeBlock1 = adjacentCodeBlock.child1, codeBlock2 = adjacentCodeBlock.child2;
        String typeName1 = getTypeName(codeBlock1), typeName2 = getTypeName(codeBlock2);
        int totalLength = adjacentCodeBlock.getTextLength(property.newlines);
        return new NewlineContext(typeName1, typeName2, totalLength);
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

    private List<AdjacentCodeBlock> extractCodeBlocks(ExtendContext ctx, int index1, int index2, Stage stage) {
        List<AdjacentCodeBlock> adjacentCodes = new ArrayList<>();
        AdjacentCodeBlock.CodeBlock codeBlock1 = generateCodeBlock(ctx, index1, 1);
        AdjacentCodeBlock.CodeBlock codeBlock2 = generateCodeBlock(ctx, index2, 2);
        if(codeBlock1.token.getType() == parser.getVws() || codeBlock2.token.getType() == parser.getVws()) {
            return adjacentCodes;
        }
        // Application process
        if (stage == Stage.APPLY) {
            adjacentCodes.add(new AdjacentCodeBlock(ctx, codeBlock1, codeBlock2));
            return adjacentCodes;
        }

        // Extraction process: consider the case where second code block has a leading comment.
        List<Token> nonDefaultTokens = codeBlock2.token.getContextTokens();
        int lastCommentIndexBefore = codeBlock2.token.indexOfLastTokenBeforeIf(parser::belongToComment);
        boolean hasCommentBefore = lastCommentIndexBefore >= 0;
        if(!hasCommentBefore) {
            adjacentCodes.add(new AdjacentCodeBlock(ctx, codeBlock1, codeBlock2));
        } else {
            int firstCmtIndexBefore = codeBlock2.token.indexOfFirstTokenBeforeIf(parser::belongToComment);
            ExtendToken firstCmtToken = (ExtendToken) nonDefaultTokens.get(firstCmtIndexBefore);
            ExtendToken lastCmtToken = (ExtendToken) nonDefaultTokens.get(lastCommentIndexBefore);
            AdjacentCodeBlock.CodeBlock firstCmtInfo = new AdjacentCodeBlock.CodeBlock(-2, -firstCmtToken.getType(), firstCmtToken.getText().length(),
                    firstCmtToken);
            AdjacentCodeBlock.CodeBlock lastCmtInfo = new AdjacentCodeBlock.CodeBlock(-2, -lastCmtToken.getType(), lastCmtToken.getText().length(),
                    lastCmtToken);
            lastCmtInfo.line = getLine(lastCmtToken.getLine(), lastCmtToken.getText());

            adjacentCodes.add(new AdjacentCodeBlock(ctx, codeBlock1, firstCmtInfo));
            adjacentCodes.add(new AdjacentCodeBlock(ctx, lastCmtInfo, codeBlock2));

            /*
             * line1:a = 1;
             * line2:// comment
             * line3:b = 2;
             * extraction: get a newline between (line1, line2),(line2,line3),(line1,line3)
             * application: insert a newline between (line1,line2),(line2,line3)
             */
            if (stage == Stage.EXTRACT) {
                AdjacentCodeBlock.CodeBlock info3 = new AdjacentCodeBlock.CodeBlock(codeBlock2);
                info3.line = firstCmtToken.getLine();
                adjacentCodes.add(new AdjacentCodeBlock(ctx, codeBlock1, info3));
            }
        }

        return adjacentCodes;
    }

    private NewlineProperty extractProperty(AdjacentCodeBlock adjacentCodeBlock) {
        AdjacentCodeBlock.CodeBlock codeBlock1 = adjacentCodeBlock.child1, codeBlock2 = adjacentCodeBlock.child2;
        int newlines = codeBlock2.line - codeBlock1.line;

        if (parser.belongToBrace(codeBlock1.token.getType()) ||
                (parser.belongToBraceOptionalStmt(codeBlock1.type) && codeBlock1.token.getType() == parser.getSemi())) {
            --newlines;
        }
        if(parser.belongToBrace(codeBlock2.token.getType())) {
            --newlines;
        }
        if (newlines < 0) {
            newlines = 0;
        }
        return new NewlineProperty(newlines);
    }

    /**
     *
     * @param adjacentCodeBlock
     * @return the length of the shift to right.
     */
    private int applyProperty(ExtendContext parent, AdjacentCodeBlock adjacentCodeBlock) {
        // First try to add some blank lines, second try to add a newline.
        NewlineProperty tryProperty = new NewlineProperty(2);
        NewlineContext newlineContext = extractContext(adjacentCodeBlock, tryProperty);
        NewlineProperty newlineProperty = (NewlineProperty) style.getProperty(newlineContext);
        if (newlineProperty == null) {
            tryProperty.newlines = 1;
            newlineProperty = (NewlineProperty) style.getProperty(newlineContext);
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
                newlines -= getNewlineAfter(parent, adjacentCodeBlock.child1);
                if (newlines > 0) {
                    adjacentCodeBlock.parentCtx.addTerNode(parser.getVws(), StringUtils.repeat(System.lineSeparator(), newlines), insertionPoint);
                    return 1;
                }
            }
        }
        return 0;
    }

    private int getNewlineAfter(ExtendContext parent, AdjacentCodeBlock.CodeBlock info) {
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

    private String getTypeName(AdjacentCodeBlock.CodeBlock codeBlock) {
        int type= codeBlock.type;
        if (codeBlock.type < 0) {
            return TokenGrouper.getInstance().getGroup(codeBlock.token, parser).name();
        }

        RuleGroup group = RuleGrouper.getInstance().getGroup(type, parser);
        if (group == RuleGroup.SELF_RULE) {
            parser.getRuleName(type);
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

        public int getTextLength(int newline) {
            // child1 and child2 may be comments.
            if (newline > 1) {
                for (int i = child2.index + 1; i < parentCtx.getChildCount(); i++) {
                    if (noBlankLineBetween(parentCtx.getChild(i - 1), parentCtx.getChild(i))) {
                        child2.textLength += parentCtx.getChild(i).getText().length();
                    }
                }

                ParseTree next = parentCtx.getChild(child1.index);
                for (int i = child1.index - 1; i >= 0; i--) {
                    if (noBlankLineBetween(parentCtx.getChild(i), parentCtx.getChild(i + 1))) {
                        child1.textLength += parentCtx.getChild(i).getText().length();
                    }
                }
            }
            return child1.textLength + child2.textLength;
        }

        private boolean noBlankLineBetween(ParseTree pre, ParseTree cur) {
            Token lastToken = pre instanceof TerminalNode ter ? ter.getSymbol() : ((ExtendContext) pre).getStop();
            Token firstToken = cur instanceof TerminalNode ter ? ter.getSymbol() : ((ExtendContext) cur).getStart();
            return firstToken.getLine() - lastToken.getLine() < 1;
        }
    }
}
