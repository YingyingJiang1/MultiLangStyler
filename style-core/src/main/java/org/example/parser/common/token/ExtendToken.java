package org.example.parser.common.token;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Pair;
import org.example.parser.common.MyParser;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/1 14:59
 */
public class ExtendToken extends CommonToken {

    protected int hierarchy = 0;
    public String indention = ""; // Added indention by NewlineStyler.
    // Tokens those are not in default channel (comment tokens and format tokens) and the token itself.
    private List<Token> contextTokens = null;
    public boolean hasTrailingComment = false;
    public int astRule;

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


    @Override
    public ExtendToken clone() {
        // Here we must call this.getText(), cannot use this.text because it might be null.
        ExtendToken ret = new ExtendToken(this.getType(), this.getText());
        ret.hierarchy = hierarchy;
        if (this.contextTokens == null) {
            ret.contextTokens = null;
        } else {
            ret.contextTokens = new ArrayList<>();
            for (Token token : this.contextTokens) {
                if (token == this) {
                    ret.contextTokens.add(ret);
                } else if (token instanceof ExtendToken extToken) {
                    ret.contextTokens.add(extToken.clone());
                }
            }
        }
        return ret;
    }

    public void addToken(int index, Token token) {
        if (contextTokens == null) {
            contextTokens = new ArrayList<>();
            contextTokens.add(this);
        }
        contextTokens.add(index, token);
    }

    public void addTokens(int index, List<Token> tokens) {
        if (contextTokens == null) {
            contextTokens = new ArrayList<>();
            contextTokens.add(this);
        }
        contextTokens.addAll(index, tokens);
    }

    public void addTokenBefore(Token token, MyParser parser) {
        if (contextTokens == null) {
            contextTokens = new ArrayList<>();
            contextTokens.add(this);
        }
        if (parser.getVws() == token.getType()) {
            contextTokens.add(0, token);
        } else {
            int index = contextTokens.indexOf(this);
            contextTokens.add(index, token);
            if (!parser.belongToComment(token.getType()) && !(parser.getHws() == token.getType())) {
                LoggerFactory.getLogger(ExtendToken.class).warn("Add a default token {} into the non-default context tokens of a token.", token.getText());
            }
        }
    }

    /**
     * Add `token` after current token.
     * @param token Token to be added.
     * @param parser
     */
    public void addTokenAfter(Token token, MyParser parser) {
        if (contextTokens == null) {
            contextTokens = new ArrayList<>();
            contextTokens.add(this);
        }
        contextTokens.add(token) ;
        int type = token.getType();
        if (!parser.belongToComment(type) && !(parser.getHws() == type) && !(parser.getVws() == type)) {
            LoggerFactory.getLogger(ExtendToken.class).warn("Add a default token {} into the non-default context tokens of a token.", token.getText());
        }
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

    public int indexOfFirstTokenAfterIf(Predicate<Integer> cond) {
        int ret = -1;
        if (contextTokens != null) {
            int start = contextTokens.indexOf(this);
            for (int i = start + 1; i < contextTokens.size(); i++) {
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

    public boolean hasContextTokens(Predicate<Integer> cond) {
        return contextTokens != null && contextTokens.stream().anyMatch(t -> cond.test(t.getType()));
    }

    public int getTrailingCommentIndex(MyParser parser) {
        if (contextTokens == null) {
            return -1;
        }

        for ( int i = indexInContextTokens() + 1; i < contextTokens.size(); i++) {
            if (parser.belongToComment(contextTokens.get(i).getType())) {
                return i;
            }
            if (contextTokens.get(i).getText().contains("\n")) {
                return -1;
            }

        }
        return -1;
    }

    public int getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(int depth) {
        this.hierarchy = depth;
    }

    public void resetContextTokens() {
        contextTokens = null;
    }

    public void setContextTokens(List<Token> newCtxTokens) {
        this.contextTokens = newCtxTokens;
    }

	public String getFormattedText() {
        if (contextTokens == null) {
            return getText();
        }

        StringBuilder builder = new StringBuilder();
        for (Token t : contextTokens) {
            builder.append(t.getText());
        }
        return  builder.toString();
	}

    public void setExtraIndention(String str) {
        this.indention = str;
    }

    public void addAllContextTokens(List<Token> tokens, MyParser parse) {
        if (contextTokens == null) {
            contextTokens = new ArrayList<>();
            contextTokens.add(this);
        }
        for (Token token : tokens) {
            ExtendToken lastToken = (ExtendToken) contextTokens.get(contextTokens.size() - 1);
            if (lastToken.getType() == token.getType() &&
             (token.getType() == parse.getHws() || token.getType() == parse.getVws())) {
                    lastToken.setText(lastToken.getText() + token.getText());
            } else {
                contextTokens.add(token);
            }
        }
    }
}
