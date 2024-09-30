package org.example.styler;

import org.antlr.v4.runtime.Token;
import org.example.interfaces.Style;

import java.util.List;

public interface TSStyler {
    int extractStyle(List<Token> tokens, int curIndex, Style style);
    int applyStyle(List<Token> tokens, int curIndex, Style style);
}
