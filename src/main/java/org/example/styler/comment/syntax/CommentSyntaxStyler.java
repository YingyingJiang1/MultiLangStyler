package org.example.styler.comment.syntax;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.comment.CommentType;
import org.example.styler.comment.syntax.style.CommentSyntaxContext;
import org.example.styler.comment.syntax.style.CommentSyntaxProperty;
import org.example.styler.comment.syntax.style.CommentSyntaxStyle;

import java.util.ArrayList;
import java.util.List;

public class CommentSyntaxStyler extends Styler {
    public CommentSyntaxStyler() {
        style = new CommentSyntaxStyle();
    }

    @Override
    public void extractStyle(List<Token> tokens, int index, MyParser parser) {
        style.addRule(extractStyleContext(tokens, index), extractStyleProperty(tokens, index, parser));
    }

    @Override
    public List<Token> applyStyle(List<Token> tokens, int index, MyParser parser) {
        CommentSyntaxContext styleContext = extractStyleContext(tokens, index);
        CommentSyntaxProperty styleProperty = extractStyleProperty(tokens, index, parser);
        if (style.getProperty(styleContext) instanceof CommentSyntaxProperty targetProperty && !styleProperty.equals(targetProperty)) {
            if (targetProperty.syntax.equals("//")) {
                block2lineComment(tokens, index, parser);
            } else if (targetProperty.syntax.equals("/*")) {
                line2blockComment(tokens, index, parser);
            }
        }
        return null;
    }

    @Override
    public boolean isRelevant(List<Token> tokens, int i, Stage stage, MyParser parser) {
        return parser.belongToComment(tokens.get(i).getType());
    }

    private CommentSyntaxContext extractStyleContext(List<Token> tokens, int index) {
        Token token = tokens.get(index);
        int lines = token.getText().split("\n").length;
        // Return MULTI_LINE when there are consecutive comment lines.
        if (lines > 1 || index + 1 < tokens.size() && tokens.get(index + 1).getType() == token.getType()) {
            return new CommentSyntaxContext(CommentType.MULTI_LINE);
        } else {
            return new CommentSyntaxContext((CommentType.SINGLE_LINE));
        }
    }

    private CommentSyntaxProperty extractStyleProperty(List<Token> tokens, int index, MyParser parser) {
        String syntax = tokens.get(index).getType() == parser.getBlockComment() ? "/**/" : "//";;
        return new CommentSyntaxProperty(syntax);
    }

    private int block2lineComment(List<Token> tokens, int index, MyParser parser) {
        String[] commentLines = tokens.get(index).getText().split("\n");
        if (commentLines.length > 1) {
            List<Token> lineComments = new ArrayList<>();
            // handle first line
            if (tokens.get(index) instanceof ExtendToken extendToken) {
                extendToken.setText(commentLines[0].replaceFirst("/\\*+", "//"));
                extendToken.setType(parser.getLineComment());
            }

            // handle middle lines.
            int lastIndex = commentLines.length - 1;
            for (int i = 1; i < lastIndex; i++) {
                String str = commentLines[i];
                int insertion = Math.max(str.lastIndexOf(' '), str.lastIndexOf('\t'));
                StringBuilder newCommentText = new StringBuilder();
                if (insertion + 1 < str.length() && str.charAt(insertion + 1) != '*') {
                    newCommentText.append(str, 0, insertion + 1).append("//")
                            .append(str.substring(insertion + 1));
                } else {
                    newCommentText.append(str.replaceFirst("\\*+", "//"));
                }
                lineComments.add(parser.getTokenFactory().create(parser.getLineComment(), newCommentText.toString()));
            }

            // handle the last line.
            StringBuilder newCommentText = new StringBuilder();
            int insertion = Math.max(commentLines[lastIndex].lastIndexOf(' '), commentLines[lastIndex].lastIndexOf('\t'));
            newCommentText.append(commentLines[lastIndex], 0, insertion + 1).append("//")
                    .append(commentLines[lastIndex].substring(insertion + 1).replaceAll("\\*+/", ""));
            lineComments.add(parser.getTokenFactory().create(parser.getLineComment(), newCommentText.toString()));

            tokens.addAll(index + 1, lineComments);
            return lineComments.size();
        } else {
            List<Token> commentTokens = new ArrayList<>();
            for (int i = index; i < tokens.size() && tokens.get(i).getType() == tokens.get(index).getType(); i++) {
                commentTokens.add(tokens.get(i));
            }

            for (Token token : commentTokens) {
                if (token instanceof ExtendToken extendToken) {
                    extendToken.setType(parser.getLineComment());
                }
            }
        }
        return 0;
    }

    private int line2blockComment(List<Token> tokens, int index, MyParser parser) {
        List<Token> commentTokens = new ArrayList<>();
        for (int i = index; i < tokens.size() && tokens.get(i).getType() == tokens.get(index).getType(); i++) {
            commentTokens.add(tokens.get(i));
        }

        if (commentTokens.size() > 1) {
            List<Token> blockComments = new ArrayList<>();
            int cur = index;
            StringBuilder newCommentText = new StringBuilder();

            newCommentText.append("/**\n");
            for (Token token : commentTokens) {
                newCommentText.append(token.getText().replaceFirst("//", "*"));
            }
            newCommentText.append("*/\n");

            tokens.removeAll(commentTokens.subList(1, commentTokens.size()));
            if (tokens.get(index) instanceof ExtendToken extendToken) {
                extendToken.setType(parser.getBlockComment());
                extendToken.setText(newCommentText.toString());
            }
        } else {
            if (tokens.get(index) instanceof ExtendToken extendToken) {
                extendToken.setText(tokens.get(index).getText().replaceFirst("//", "/*").replace("\n", "*/\n"));
                extendToken.setType(parser.getBlockComment());
            }
        }
        return  0;
    }

}
