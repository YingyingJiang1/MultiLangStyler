package org.example.styler.format.linewrapping;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.example.parser.java.antlr.JavaParser;
import org.example.style.rule.StyleContext;
import org.example.styler.Styler;
import org.example.styler.format.linewrapping.style.LineWrappingContext;
import org.example.styler.format.linewrapping.style.LineWrappingStyle;
import org.example.styler.format.space.style.SpaceContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LineWrappingStyler extends Styler {
    public LineWrappingStyler() {
        style = new LineWrappingStyle();
    }

    @Override
    public void extractStyle(List<Token> tokens, int index) {
        String[] lines = parser.getTokenStream().getText().split("\n");
        int maxCommentLength = 0, maxCodeLength = 0;
        for (String line : lines) {
            // Comment length are not included in the column limit
            if (line.startsWith("//") || line.startsWith("/*")) {
                if (line.length() > maxCommentLength) {
                    maxCommentLength = line.length();
                }
            } else if (line.length() > maxCodeLength) {
                maxCodeLength = line.length();
            }
        }

    }

    private List<StyleContext> extractContext() {
        String[] lines = parser.getTokenStream().getText().split("\n");
        int maxCommentLength = 0, maxCodeLength = 0;
        int commentCount = 0, codeCount = 0;
        long totalCommentLength = 0, totalCodeLength = 0;
        for (String line : lines) {
            // Comment length are not included in the column limit
            if (line.startsWith("//") || line.startsWith("/*")) {
                if (line.length() > maxCommentLength) {
                    maxCommentLength = line.length();
                }
                commentCount++;
                totalCommentLength += line.length();
            } else {
                if (line.length() > maxCodeLength) {
                    maxCodeLength = line.length();
                }
                codeCount++;
                totalCodeLength += line.length();
            }
        }

        List<StyleContext> contexts = new ArrayList<>();
        if (maxCommentLength > 0) {
            contexts.add(new LineWrappingContext(maxCommentLength, (int) (totalCommentLength / commentCount), LineWrappingContext.Attr.COMMENT));
        }
        if (maxCodeLength > 0) {
            contexts.add(new LineWrappingContext(maxCodeLength, (int) (totalCodeLength / codeCount), LineWrappingContext.Attr.CODE));
        }
        return contexts;
    }
}
