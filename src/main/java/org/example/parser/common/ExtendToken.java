package org.example.parser.common;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
    // Tokens those are not in default channel (comment tokens and format tokens) and the token itself.
    private List<Token> contextTokens = null;
    public boolean hasTrailingComment = false;
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
        ret.contextTokens = contextTokens;
        return ret;
    }

    public void addToken(int index, Token token) {
        if (contextTokens == null) {
            contextTokens = new ArrayList<>();
            contextTokens.add(this);
        }
        contextTokens.add(index, token);
    }

    public void addAllToken(int index, List<Token> tokens) {
        if (contextTokens == null) {
            contextTokens = new ArrayList<>();
            contextTokens.add(this);
        }
        contextTokens.addAll(index, tokens);
    }

    public int indexInContextTokens() {
        if (contextTokens == null) {
            contextTokens = new ArrayList<>();
            contextTokens.add(this);
            return 0;
        }
        return contextTokens.indexOf(this);
    }

    public int indexOfLastTokenBeforeIf(Predicate<Integer> cond) {
        int ret = -1;
        if (contextTokens != null) {
            int start = contextTokens.indexOf(this);
            for (int i = start - 1; i >= 0; i--) {
                Token token = contextTokens.get(i);
                if (cond.test(token.getType())) {
                    return i;
                }
            }
        }
        return  ret;
    }

    public int indexOfLastTokenAfterIf(Predicate<Integer> cond) {
        int ret = -1;
        if (contextTokens != null) {
            int start = contextTokens.indexOf(this);
            for (int i = start + 1; i <= contextTokens.size(); i++) {
                Token token = contextTokens.get(i);
                if (cond.test(token.getType())) {
                    return i;
                }
            }
        }
        return  ret;
    }

    public int indexOfFirstTokenBeforeIf(Predicate<Integer> cond) {
        int ret = -1;
        if (contextTokens != null) {
            int start = contextTokens.indexOf(this);
            for (int i = 0; i < start; i++) {
                Token token = contextTokens.get(i);
                if (cond.test(token.getType())) {
                    return i;
                }
            }
        }
        return  ret;
    }


    public List<Token> getContextTokens() {
        if (contextTokens == null) {
            contextTokens = new ArrayList<>();
            contextTokens.add(this);
        }
        return contextTokens;
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
