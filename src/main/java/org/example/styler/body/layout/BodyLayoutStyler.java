package org.example.styler.body.layout;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.ExtendToken;
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
    public void extractStyle(ExtendContext ctx) {
        int bodyIndex = ctx.indexOfIf(child -> parser.belongToStmt(child));
        if (bodyIndex >= 0) {
            ExtendContext body = (ExtendContext) ctx.getChild(bodyIndex);
            BodyContext context = extractStyleContext(ctx, body);
            BodyLayoutProperty property = new BodyLayoutProperty();
            ParseTree preChild = ctx.getChild(bodyIndex - 1);
            int preChildLine = preChild instanceof TerminalNode ? ((TerminalNode) preChild).getSymbol().getLine() :
                    ((ExtendContext) preChild).stop.getLine();
            property.compactStyle = preChildLine == body.start.getLine();
            style.addRule(context, property);
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx) {
        int bodyIndex = ctx.indexOfIf(child -> parser.belongToStmt(child));
        if (bodyIndex >= 0) {
            ExtendContext body = (ExtendContext) ctx.getChild(bodyIndex);
            StyleContext context = extractStyleContext(ctx, body);
            BodyLayoutProperty property = (BodyLayoutProperty) style.getProperty(context);
            ExtendToken stop = (ExtendToken) body.stop;
            if(!property.compactStyle) {
                ExtendToken extStart = (ExtendToken) body.start;
                extStart.addToken(extStart.indexInContextTokens(), parser.getTokenFactory().create(parser.getVws(), System.lineSeparator()));
            } else {
                ExtendToken start = (ExtendToken) body.start;
                // Move leading comment of the statement to the end of the statement.
                int firstLeadingCommentIndex = start.indexOfFirstTokenBeforeIf(parser::belongToComment);
                boolean hasLeadingComment = firstLeadingCommentIndex >= 0;
                if(hasLeadingComment) {
                    int lastLeadingCommentIndex = start.indexOfLastTokenBeforeIf(parser::belongToComment);
                    stop = (ExtendToken) body.stop;
                    stop.hasTrailingComment = true;
                    List<Token> comments = start.getContextTokens().subList(firstLeadingCommentIndex, lastLeadingCommentIndex + 1);
                    stop.addAllToken(stop.indexInContextTokens(), comments);
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
    protected Set<Integer> getRelevantRules() {
        if (relevantRules == null) {
            relevantRules = new HashSet<Integer>(List.of(
                    parser.getRuleIfStmt(), parser.getRuleIfElseStmt(),
                    parser.getRuleForStmt(), parser.getRuleWhileStmt()
            ));
        }
        return relevantRules;
    }
}
