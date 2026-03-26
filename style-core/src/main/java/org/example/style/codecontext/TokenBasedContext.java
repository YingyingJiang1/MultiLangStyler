package org.example.style.codecontext;

import java.util.List;

import org.antlr.v4.runtime.Token;

public class TokenBasedContext extends CodeContext{
    List<Token> tokens;
    List<Integer> indices;

    public TokenBasedContext(List<Token> tokens, List<Integer> indices) {
        this.tokens = tokens;
        this.indices = indices;
        if (tokens.isEmpty() || indices.isEmpty()) {
            this.startLoc = new int[]{-1, -1};
            this.endLoc = new int[]{-1, -1};
        } else {
            this.startLoc = new int[]{tokens.get(indices.get(0)).getLine(), tokens.get(indices.get(0)).getCharPositionInLine()};
            Token lastToken = tokens.get(indices.get(indices.size() - 1));
            this.endLoc = new int[]{lastToken.getLine(), lastToken.getCharPositionInLine() + lastToken.getText().length() - 1};
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public Token getToken(int index) {
        return tokens.get(indices.get(index));
    }

    public int getIndexInTS(int index) {
        return indices.get(index);
    }
}
