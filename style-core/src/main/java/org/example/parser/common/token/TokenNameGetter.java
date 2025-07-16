package org.example.parser.common.token;

import java.util.HashMap;
import java.util.Map;

public class TokenNameGetter {
    private static TokenNameGetter instance = new TokenNameGetter();

    static final Map<String, String> map = new HashMap<>();

    static {
        // operators
        map.put("<", "LT");
        map.put(">", "GT");
        map.put("<=", "LE");
        map.put(">=", "GE");
        map.put("==", "EQUAL");
        map.put("!=", "NOTEQUAL");
        map.put("&&", "AND");
        map.put("||", "OR");
        map.put("=", "ASSIGN");
        map.put("+", "ADD");
        map.put("-", "SUB");
        map.put("*", "MUL");
        map.put("/", "DIV");
        map.put("%", "MOD");
        map.put("&", "BITAND");
        map.put("|", "BITOR");
        map.put("^", "CARET");
        map.put("~", "TILDE");
        map.put("!", "BANG");
        map.put("++", "INC");
        map.put("--", "DEC");
        map.put("+=", "ADD_ASSIGN");
        map.put("-=", "SUB_ASSIGN");
        map.put("*=", "MUL_ASSIGN");
        map.put("/=", "DIV_ASSIGN");
        map.put("&=", "AND_ASSIGN");
        map.put("|=", "OR_ASSIGN");
        map.put("^=", "XOR_ASSIGN");
        map.put("%=", "MOD_ASSIGN");
        map.put("<<=", "LSHIFT_ASSIGN");
        map.put(">>=", "RSHIFT_ASSIGN");
        map.put(">>>=", "URSHIFT_ASSIGN");
    }
    private TokenNameGetter() {}

    public static TokenNameGetter getInstance() {
        return instance;
    }

    public String getName(String text) {
        String name = map.get(text);
        return name == null ? text : name;
    }

}
