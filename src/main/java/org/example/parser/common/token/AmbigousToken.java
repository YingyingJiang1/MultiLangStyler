package org.example.parser.common.token;

public enum AmbigousToken {
    NEGATIVE("-"),
    LEFT_ANGLE_BRACKET("<"),
    RIGHT_ANGLE_BRACKET(">"),
    WILDCARD("*")
    ;

    final String value;
    AmbigousToken(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
