package org.example.styler.format.newline;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.ExtendToken;
import org.example.parser.java.antlr.JavaParser;
import org.example.style.Style;
import org.example.styler.Stage;
import org.example.styler.format.newline.style.NewlineContext;
import org.example.styler.format.newline.style.NewlineProperty;
import org.example.styler.Styler;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/30 11:45
 */
public class NewlineStyler extends Styler {

    public NewlineStyler() {
        style.setStyleName("newline");
        executeWhenExit = false;
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


    public void extractStyle(ExtendContext ctx, Style style) {
        int len = ctx.getChildCount() - 1;
        for(int i = 0; i < len; ++i) {
            List<Info> infos1 = extractInfos(ctx, i, i + 1, Stage.EXTRACT);
            List<Info> infos = infos1;
            for(Info info : infos) {
                style.addRule(extractContext(info), extractProperty(info));
            }
        }
    }

    public ExtendContext applyStyle(ExtendContext ctx, Style style) {
        for(int i = 0; i < ctx.getChildCount() - 1; ++i) {
            List<Info> infos = extractInfos(ctx, i, i + 1, Stage.APPLY);
            for(Info info : infos) {
                NewlineContext newlineContext = extractContext(info);
                NewlineProperty newlineProperty = (NewlineProperty) style.getProperty(newlineContext);

                // Must update index here! Because index will change after insertion operation.
                info.child1.index = i;
                info.child2.index = i + 1;
                if (newlineProperty != null) {
                    i += applyProperty(ctx, info, newlineProperty);
                }
            }
        }
        return ctx;
    }

    @Override
    protected Set<Integer> getRelevantRules() {
        return  relevantRules;
    }

    private Info.InnerInfo getInfo(ExtendContext parent, int index, int flag) {
        Info.InnerInfo info = new Info.InnerInfo();
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
        info.textLen = node.getText().length();
        info.index = index;
        return info;
    }

    private NewlineContext extractContext(Info info) {
        Info.InnerInfo info1 = info.child1, info2 = info.child2;
        return new NewlineContext(info1.type, info2.type, info1.textLen + info2.textLen);
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

    private List<Info> extractInfos(ExtendContext ctx, int index1, int index2, Stage stage) {
        List<Info> infos = new ArrayList<>();
        Info.InnerInfo info1 = getInfo(ctx, index1, 1);
        Info.InnerInfo info2 = getInfo(ctx, index2, 2);
        if(info1.token.getType() == parser.getVws() || info2.token.getType() == parser.getVws()) {
            return  infos;
        }
        // Application process
        if (stage == Stage.APPLY) {
            infos.add(new Info(ctx, info1, info2));
            return infos;
        }

        // Extraction process
        List<Token> nonDefaultTokens = info2.token.getContextTokens();
        int lastCommentIndexBefore = info2.token.indexOfLastTokenBeforeIf(parser::belongToComment);
        boolean hasCommentBefore = lastCommentIndexBefore >= 0;
        if(hasCommentBefore) {
            int firstCmtIndexBefore = info2.token.indexOfFirstTokenBeforeIf(parser::belongToComment);
            ExtendToken firstCmtToken = (ExtendToken) nonDefaultTokens.get(firstCmtIndexBefore);
            ExtendToken lastCmtToken = (ExtendToken) nonDefaultTokens.get(lastCommentIndexBefore);
            Info.InnerInfo firstCmtInfo = new Info.InnerInfo(-2, -firstCmtToken.getType(), firstCmtToken.getText().length(),
                    firstCmtToken);
            Info.InnerInfo lastCmtInfo = new Info.InnerInfo(-2, -lastCmtToken.getType(), lastCmtToken.getText().length(),
                    lastCmtToken);
            lastCmtInfo.line = getLine(lastCmtToken.getLine(), lastCmtToken.getText());

            infos.add(new Info(ctx, info1, firstCmtInfo));
            infos.add(new Info(ctx, lastCmtInfo, info2));

            /*
             * line1:a = 1;
             * line2:// comment
             * line3:b = 2;
             * extraction: get a newline between (line1, line2),(line2,line3),(line1,line3)
             * application: insert a newline between (line1,line2),(line2,line3)
             */
            if (stage == Stage.EXTRACT) {
                Info.InnerInfo info3 = new Info.InnerInfo(info2);
                info3.line = firstCmtToken.getLine();
                infos.add(new Info(ctx, info1, info3));
            }
        } else {
            infos.add(new Info(ctx, info1, info2));
        }

        return infos;
    }

    private NewlineProperty extractProperty(Info info) {
        Info.InnerInfo info1 = info.child1, info2 = info.child2;
        int newlines = info2.line - info1.line;

        if (parser.belongToBrace(info1.token.getType()) ||
                (parser.belongToBraceOptionalStmt(info1.type) && info1.token.getType() == parser.getSemi())) {
            --newlines;
        }
        if(parser.belongToBrace(info2.token.getType())) {
            --newlines;
        }
        if (newlines < 0) {
            newlines = 0;
        }
        return new NewlineProperty(newlines);
    }

    /**
     *
     * @param info
     * @param newlineProperty
     * @return the length of the shift to right.
     */
    private int applyProperty(ExtendContext parent, Info info, NewlineProperty newlineProperty) {
        int insertionPoint = info.child1.index + 1;
        if (newlineProperty.newlines > 0) {
            // child1: comment. child2: a syntax rule.
            if(parser.belongToComment(info.child1.token.getType())) {
                String vwsStr = StringUtils.repeat(System.lineSeparator(), newlineProperty.newlines);
                Token vwsToken = parser.getTokenFactory().create(parser.getVws(), vwsStr);
                // Insert vws before the leading comment.
                info.child2.token.addToken(
                        info.child2.token.indexOfFirstTokenBeforeIf(parser::belongToComment),
                        vwsToken
                );
            } else if(insertionPoint >= 0) { // info1: a rule info
                ExtendToken token1 = info.child1.token;
                int newlines = newlineProperty.newlines;
                newlines -= getNewlineAfter(parent, info.child1);
                if (newlines > 0) {
                    info.parentCtx.addTerNode(parser.getVws(), StringUtils.repeat(System.lineSeparator(), newlines), insertionPoint);
                    return 1;
                }
            }
        }
        return 0;
    }

    private int getNewlineAfter(ExtendContext parent, Info.InnerInfo info) {
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


    // Information of relevant structure.
    static class Info {
        ExtendContext parentCtx;
        InnerInfo child1, child2;
        static class InnerInfo {
            public InnerInfo() {
            }

            int index;
            int type,line, textLen;
            ExtendToken token;

            public InnerInfo(int index, int type, int textLen, ExtendToken token) {
                this.index = index;
                this.type = type;
                this.textLen = textLen;
                this.token = token;
                this.line = token.getLine();
            }

            public InnerInfo(InnerInfo info) {
                index = info.index;
                type = info.type;
                line = info.line;
                token = info.token;
            }
        }

        public Info() {}

        public Info(ExtendContext parentCtx, InnerInfo child1, InnerInfo child2) {
            this.parentCtx = parentCtx;
            this.child1 = child1;
            this.child2 = child2;
        }
    }
}
