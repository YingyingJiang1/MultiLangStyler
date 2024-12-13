package org.example.styler.body.layout;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.style.rule.StyleContext;
import org.example.styler.body.BodyContext;
import org.example.styler.body.BodyStyler;
import org.example.styler.body.layout.style.BodyLayoutProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Layout of body without braces.
 */
public class BodyLayoutStyler extends BodyStyler {
    private static Set<Integer> relevantRules = null;

    public BodyLayoutStyler() {
        style.setStyleName("body_layout");
    }

    public BodyLayoutStyler(boolean executeWhenExit) {
        super(executeWhenExit);
        style.setStyleName("body_layout");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        int bodyIndex = ctx.indexOfIf(child -> parser.belongToStmt(child));
        if (bodyIndex >= 0) {
            if (!parser.isBlock(ctx.getChild(bodyIndex))) {
                ParseTree body = ctx.getChild(bodyIndex);
                BodyContext context = extractStyleContext(ctx, body, parser);
                BodyLayoutProperty property = new BodyLayoutProperty();
                ParseTree preChild = ctx.getChild(bodyIndex - 1);
                int preChildLine = preChild instanceof TerminalNode ? ((TerminalNode) preChild).getSymbol().getLine() :
                        ((ExtendContext) preChild).stop.getLine();
                int succeedChildLine = body instanceof TerminalNode  ? ((TerminalNode) body).getSymbol().getLine() :
                        ((ExtendContext) body).start.getLine();
                property.compactStyle = preChildLine == succeedChildLine;
                style.addRule(context, property);
            }
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        int bodyIndex = ctx.indexOfIf(child -> parser.belongToStmt(child));
        if (bodyIndex >= 0 && !parser.isBlock(ctx.getChild(bodyIndex))) {
            ParseTree body = ctx.getChild(bodyIndex);
            StyleContext context = extractStyleContext(ctx, body, parser);
            BodyLayoutProperty property = (BodyLayoutProperty) style.getProperty(context);
            if (property == null) {
                return ctx;
            }

            ExtendToken stop = body instanceof TerminalNode ? (ExtendToken) ((TerminalNode) body).getSymbol() :
                    (ExtendToken) ((ExtendContext) body).stop;
            if(!property.compactStyle) {
                ExtendToken extStart = body instanceof TerminalNode ? (ExtendToken) ((TerminalNode) body).getSymbol() :
                        (ExtendToken) ((ExtendContext) body).start;
                extStart.addToken(extStart.indexInContextTokens(), parser.getTokenFactory().create(parser.getVws(), System.lineSeparator()));
            } else {
                ExtendToken start = body instanceof TerminalNode ? (ExtendToken) ((TerminalNode) body).getSymbol() :
                        (ExtendToken) ((ExtendContext) body).start;
                // Move leading comment of the statement to the end of the statement.
                int firstLeadingCommentIndex = start.indexOfFirstTokenBeforeIf(parser::belongToComment);
                boolean hasLeadingComment = firstLeadingCommentIndex >= 0;
                if(hasLeadingComment) {
                    int lastLeadingCommentIndex = start.indexOfLastTokenBeforeIf(parser::belongToComment);
                    stop = body instanceof TerminalNode ? (ExtendToken) ((TerminalNode) body).getSymbol() :
                            (ExtendToken) ((ExtendContext) body).stop;
                    stop.hasTrailingComment = true;
                    List<Token> comments = start.getContextTokens().subList(firstLeadingCommentIndex, lastLeadingCommentIndex + 1);
                    for (Token comment : comments) {
                        stop.addTokenBefore(comment, parser);
                    }
                    start.getContextTokens().removeAll(comments);
                }
            }
            // Add vws if Body has a trailing comment.
            if(!(stop.hasTrailingComment)) {
                ctx.addTerNode(parser.getVws(), System.lineSeparator(), bodyIndex + 1); // Add vws after statement
            }
        }

        return ctx;
    }

    @Override
    protected Set<Integer> getRelevantRules(MyParser parser) {
        if (relevantRules == null) {
            relevantRules = new HashSet<Integer>(List.of(
                    parser.getRuleIfStmt(), parser.getRuleIfElseStmt(),
                    parser.getRuleForStmt(), parser.getRuleWhileStmt()
            ));
        }
        return relevantRules;
    }
}
