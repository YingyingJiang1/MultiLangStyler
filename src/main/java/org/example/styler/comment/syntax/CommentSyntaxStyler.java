package org.example.styler.comment.syntax;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;
import org.example.styler.Styler;
import org.example.styler.comment.CommentType;
import org.example.styler.comment.syntax.style.CommentSyntaxContext;
import org.example.styler.comment.syntax.style.CommentSyntaxProperty;

import java.util.List;

public class CommentSyntaxStyler extends Styler {
    public CommentSyntaxStyler() {
        style.setStyleName("comment_syntax");
    }

    @Override
    public void extractStyle(List<Token> tokens, int index, MyParser parser) {
        List<Token> commentTokens = tokens.stream().filter(t -> parser.belongToComment(t.getType())).toList();
        for (int i = 0; i < commentTokens.size(); i++) {
            Token t = commentTokens.get(i);
            String syntax = t.getType() == parser.getBlockComment() ? "/**/" : "//";
            int lines = t.getText().split("\n").length;
            if (lines > 1) {
                style.addRule(new CommentSyntaxContext(CommentType.MULTI_LINE), new CommentSyntaxProperty(syntax));
            } else if(t.getType() == parser.getLineComment()) {
                if (i + 1 < commentTokens.size() && commentTokens.get(i + 1).getLine() == t.getLine() + 1) {
                    style.addRule(new CommentSyntaxContext(CommentType.MULTI_LINE), new CommentSyntaxProperty(syntax));
                }
            }
        }
    }

    @Override
    public void applyStyle(List<Token> tokens, int index, MyParser parser) {
//        System.out.println("TODO: implement CommentSyntaxStyler@applyStyle");
    }
}
