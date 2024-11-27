package org.example.parser.common;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/1 14:59
 */
public class ExtendToken extends CommonToken {

    // This field, together with the brace depth, determines the indentation of tokens.
    // This field is useful in the case statement,
    // as in most scenarios, the indentation depth is associated with the brace depth.
    // However, in case statements, there might be no braces.
    protected int hierarchy = 0;
    public int indention = 0;
    private List<Token> comments = new ArrayList<>(0);
    private List<Token> formatTokensBefore = null, formatTokensAfter = null;
    // The meaning of @info depends on the type of the token.
    public Object info;

    public ExtendToken(int type) {
        super(type);
    }

    public ExtendToken(Pair<TokenSource, CharStream> source, int type, int channel, int start, int stop) {
        super(source, type, channel, start, stop);
    }

    public ExtendToken(int type, String text) {
        super(type, text);
    }

    public ExtendToken(Token oldToken) {
        super(oldToken);
    }

    public void setIndention(int indention) {
        this.indention = indention;
    }

    @Override
    public ExtendToken clone() {
        ExtendToken ret = new ExtendToken(this);
        ret.hierarchy = hierarchy;
        ret.info = info;
    /*ret.comments.addAll(comments);
    ret.trailingComment = trailingComment;*/
        return ret;
    }

    public void addFormatTokenBefore(Token token) {
        if (formatTokensBefore == null) {
            formatTokensBefore = new ArrayList<>();
        }
        formatTokensBefore.add(token);
    }

    public void addFormatTokenAfter(Token token) {
        if (formatTokensAfter == null) {
            formatTokensAfter = new ArrayList<>();
        }
        formatTokensAfter.add(token);
    }



    /**
     * @apiNote There're some comment and format tokens around the token after style transformation.
     */
    public List<Token> getFullTokens() {
        List<Token> ret = new ArrayList<>();
        if (hasTrailingComment) {
            ret.add(this);
            ret.addAll(comments);
        } else {
            ret.addAll(comments);
            ret.add(this);
        }
        ret.addAll(formatTokens);
        return ret;
    }

    public String getComments() {
        StringBuilder build = new StringBuilder();
        for (Token commentToken : comments) {
            build.append(commentToken.getText());
        }
        return build.toString();
    }

    public int getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(int depth) {
        this.hierarchy = depth;
    }

    public Object getInfo() {
        return this.info;
    }
}
