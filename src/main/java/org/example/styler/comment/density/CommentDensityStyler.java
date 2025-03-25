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

import java.util.*;

public class CommentDensityStyler extends Styler {
    private boolean executed = false; // Used to make sure the extraction and application is executed only once.
    public CommentDensityStyler() {
        style.setStyleName("comment_density");
    }

    @Override
    public void extractStyle(List<Token> tokens, int index, MyParser parser) {
        if (executed) {
            return;
        }
        executed = true;
        int totalLines = getTotalLines(parser);
        List<Token> commentTokens = getAllCommentTokens(tokens, parser).keySet().stream().toList();
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
        Map<Token, Integer> commentMap = getAllCommentTokens(tokens, parser);
        List<Token> commentTokens = new ArrayList<>(commentMap.keySet());
        int totalLines = getTotalLines(parser);
        double commentLines = commentTokens.stream()
                .reduce(0, (acc, t) -> acc + t.getText().split("\n").length, Integer::sum);
        if (totalLines > 0) {
            double lineDensity = commentLines / totalLines;
            StyleProperty property = style.getProperty(null);

            // Shorten line density by removing arbitrary comment tokens
            if (property instanceof CommentDensityProperty densityProperty && lineDensity > densityProperty.lineDensity) {
                int linesToRemoved = (int) (totalLines * (lineDensity - densityProperty.lineDensity));
                commentTokens.sort(Comparator.comparing(t -> t.getText().split("\n").length));
                List<Token> removedTokens = new ArrayList<>();
                for (int i = 0; i < commentTokens.size() && linesToRemoved > 0; i++) {
                    if (commentTokens.get(i) instanceof ExtendToken extToken) {
                        int preIndex = commentMap.get(extToken) - 1;
                        while (preIndex >= 0 && (tokens.get(preIndex).getType() == parser.getHws() || tokens.get(preIndex).getType() == parser.getVws())) {
                            --preIndex;
                        }

                        linesToRemoved -= extToken.getText().split("\n").length;
                        if (preIndex >= 0 && tokens.get(preIndex).getLine() == extToken.getLine()) {
                            extToken.setText("\n"); // Change the trailing comment into vws
                            extToken.setType(parser.getVws());
                        } else {
                            removedTokens.add(extToken);
                        }

                    }
                }
                tokens.removeAll(removedTokens);
            }
        }

    }


    @Override
    public void doFinalize() {
        executed = false;
    }

    private Map<Token, Integer> getAllCommentTokens(List<Token> tokens, MyParser parser) {
        Map<Token, Integer> commentTokens = new HashMap<>();
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if (parser.belongToComment(token.getType())) {
                commentTokens.put(token, i);
            }
        }

        return commentTokens;
    }

    private int getTotalLines(MyParser parser) {
        return parser.getTokenStream().getText().split("\n").length;
    }

}
