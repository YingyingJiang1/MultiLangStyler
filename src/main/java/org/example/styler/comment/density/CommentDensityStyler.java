package org.example.styler.comment.density;

import org.antlr.v4.runtime.Token;
import org.example.styler.Styler;
import org.example.styler.comment.density.style.CommentDensityProperty;
import org.example.styler.comment.syntax.style.CommentSyntaxProperty;

import java.util.List;

public class CommentDensityStyler extends Styler {
    public CommentDensityStyler() {
        style.setStyleName("comment_density");
    }

    @Override
    public void extractStyle(List<Token> tokens, int index) {
        List<Token> commentTokens = tokens.stream().filter(t -> parser.isComment(t.getType())).toList();
        double commentLines = commentTokens.stream().reduce(0, (acc, t) -> acc + t.getText().split("\n").length, Integer::sum);
        double totalLines = parser.getTokenStream().getText().split("\n").length;
        style.addRule(null, new CommentDensityProperty(commentLines / totalLines));
    }
}
