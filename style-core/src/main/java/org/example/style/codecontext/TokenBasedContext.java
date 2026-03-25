package org.example.style.codecontext;

import java.util.List;

import org.antlr.v4.runtime.Token;

public class TokenBasedContext extends CodeContext{
    List<Token> tokens;
    int startIndex, length;

    public TokenBasedContext(List<Token> tokens, int startIndex, int length) {
        this.tokens = tokens;
        this.startIndex = startIndex;
        this.length = length;
        if (tokens.isEmpty()) {
            this.startLoc = new int[]{-1, -1};
            this.endLoc = new int[]{-1, -1};
        } else {
            this.startLoc = new int[]{tokens.get(0).getLine(), tokens.get(0).getCharPositionInLine()};
            Token lastToken = tokens.get(tokens.size() - 1);
            this.endLoc = new int[]{lastToken.getLine(), lastToken.getCharPositionInLine() + lastToken.getText().length()};
        }
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getLength() {
        return length;
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
