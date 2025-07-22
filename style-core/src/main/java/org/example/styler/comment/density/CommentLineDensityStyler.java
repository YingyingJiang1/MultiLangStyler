package org.example.styler.comment.density;

import org.antlr.v4.runtime.Token;
import org.example.RunStatistic;
import org.example.parser.common.MyParser;
import org.example.parser.common.token.ExtendToken;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.comment.density.style.CommentDensityProperty;

import java.util.*;

public class CommentLineDensityStyler extends Styler {

    public CommentLineDensityStyler() {
        style.setStyleName("comment_density");
    }

    @Override
    public void extractStyle(List<Token> tokens, int index, MyParser parser) {
        int totalLines = getTotalLines(parser);
        List<Token> commentTokens = getAllCommentTokens(tokens, parser).keySet().stream().toList();
        double commentLines = commentTokens.stream()
                .reduce(0, (acc, t) -> acc + t.getText().split("\n").length, Integer::sum);
        if (totalLines > 0) {
            style.addRule(null, new CommentDensityProperty(commentLines / totalLines));
        }
    }

    @Override
    public List<Token> applyStyle(List<Token> tokens, int index, MyParser parser) {
        Map<Token, Integer> commentMap = getAllCommentTokens(tokens, parser);
        int totalLines = getTotalLines(parser);
        double commentLines = commentMap.keySet().stream()
                .reduce(0, (acc, t) -> acc + t.getText().split("\n").length, Integer::sum);
        if (totalLines > 0) {
            double lineDensity = commentLines / totalLines;
            StyleProperty property = style.getProperty(null);

            // Shorten line density by removing arbitrary comment tokens
            if (property instanceof CommentDensityProperty densityProperty && lineDensity > densityProperty.commentDensity) {
                int linesToRemoved = (int) (totalLines * (lineDensity - densityProperty.commentDensity));
                removeComment(commentMap, tokens, linesToRemoved, parser);

            }
        }
        return null;
    }

    @Override
    public boolean isRelevant(List<Token> tokens, int i, Stage stage, MyParser parser) {
        // Only execute extraction or application once at the end of tokens.
        return stage == Stage.APPLY ? i == tokens.size() - 1 : i == tokens.size() - 2;
    }

    private void removeComment(Map<Token, Integer> commentMap, List<Token> tokens, int linesToRemoved, MyParser parser) {
        List<Token> commentTokens = new ArrayList<>(commentMap.keySet());
        commentTokens.sort(
                Comparator.comparing((Token t) -> t.getText().split("\n").length)
                        .thenComparing(t -> t.getText().length())
        );
        for (int i = 0; i < commentTokens.size() && linesToRemoved > 0; i++) {
            if (commentTokens.get(i) instanceof ExtendToken extToken) {
                // Get previous token that is not vws and hws
                int preIndex = commentMap.get(extToken) - 1;
                while (preIndex >= 0 && (tokens.get(preIndex).getType() == parser.getHws() || tokens.get(preIndex).getType() == parser.getVws())) {
                    --preIndex;
                }

                linesToRemoved -= extToken.getText().split("\n").length;
                if (preIndex >= 0 && tokens.get(preIndex).getLine() == extToken.getLine()) {
                    extToken.setText("\n"); // Change the trailing comment into vws
                    extToken.setType(parser.getVws());
                } else {
                    extToken.setType(-1);
                    extToken.setText("");
                }

                // Remove the hws before the comment
                for (int j = commentMap.get(extToken) - 1; j >= 0; j--) {
                    if (tokens.get(j).getType() == parser.getHws() && tokens.get(j) instanceof ExtendToken preToken) {
                        preToken.setText("");
                        preToken.setType(-1);
                        continue;
                    }
                    break;
                }
            }
        }
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
