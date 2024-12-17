package org.example.styler.comment.density;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.comment.density.style.CommentDensityProperty;

import java.util.ArrayList;
import java.util.List;

public class CommentDensityStyler extends Styler {
    private List<Token> commentTokens = null;
    private int totalLines = -1;
    public CommentDensityStyler() {
        style.setStyleName("comment_density");
    }

    @Override
    public void extractStyle(List<Token> tokens, int index, MyParser parser) {
        if (commentTokens == null) {
            commentTokens = new ArrayList<>();
        }
        commentTokens.add(tokens.get(index));
        if (totalLines == -1) {
            totalLines = parser.getTokenStream().getText().split("\n").length;
        }
    }

    @Override
    public void applyStyle(List<Token> tokens, int index, MyParser parser) {
//        System.out.println("to do: implement CommentDensityStyler@applyStyle");
    }

    @Override
    public void doFinalize() {
        double commentLines = commentTokens.stream()
                .reduce(0, (acc, t) -> acc + t.getText().split("\n").length, Integer::sum);
        style.addRule(null, new CommentDensityProperty(commentLines / totalLines));
        // Reset
        commentTokens = null;
        totalLines = -1;
    }

    @Override
    public boolean isRelevant(List<Token> tokens, int i, Stage stage, MyParser parser) {
        return parser.belongToComment(tokens.get(i).getType());
    }
}
