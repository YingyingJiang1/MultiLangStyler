package org.example.styler.comment.density;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.comment.density.style.CommentDensityProperty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CommentDensityStyler extends Styler {
    private boolean executed = false;
    public CommentDensityStyler() {
        style.setStyleName("comment_density");
    }

    @Override
    public void extractStyle(List<Token> tokens, int index, MyParser parser) {
        if (executed) {
            return;
        }
        executed = true;
        List<Token> commentTokens = getAllCommentTokens(tokens, parser);
        int totalLines = getTotalLines(parser);
        double commentLines = commentTokens.stream()
                .reduce(0, (acc, t) -> acc + t.getText().split("\n").length, Integer::sum);
        if (totalLines > 0) {
            style.addRule(null, new CommentDensityProperty(commentLines / totalLines));
        }
    }

    @Override
    public void applyStyle(List<Token> tokens, int index, MyParser parser) {
        if (executed) {
            return;
        }
        executed = true;
        List<Token> commentTokens = getAllCommentTokens(tokens, parser);
        int totalLines = getTotalLines(parser);
        double commentLines = commentTokens.stream()
                .reduce(0, (acc, t) -> acc + t.getText().split("\n").length, Integer::sum);
        if (totalLines > 0) {
            double lineDensity = commentLines / totalLines;
            StyleProperty property = style.getProperty(null);
            // Shorten line density by removing arbitrary comment tokens
            if (property instanceof CommentDensityProperty densityProperty && lineDensity > densityProperty.lineDensity) {
                int linesToRemoved = (int) (totalLines * (lineDensity - densityProperty.lineDensity));
                tokens.sort(Comparator.comparing(t -> t.getText().split("\n").length));
                for (int i = 0; i < commentTokens.size() && linesToRemoved > 0; i++) {
                    if (commentTokens.get(i) instanceof ExtendToken extToken) {
                        extToken.setType(-1); // remove the token
                        linesToRemoved--;
                    }
                }
            }
        }

    }


    @Override
    public boolean isRelevant(List<Token> tokens, int i, Stage stage, MyParser parser) {
        return parser.belongToComment(tokens.get(i).getType());
    }

    private List<Token> getAllCommentTokens(List<Token> tokens, MyParser parser) {
        List<Token> commentTokens = new ArrayList<>();
        for (Token token : tokens) {
            if (parser.belongToComment(token.getType())) {
                commentTokens.add(token);
            }
        }
        return commentTokens;
    }

    private int getTotalLines(MyParser parser) {
        return parser.getTokenStream().getText().split("\n").length;
    }
}
