package org.example.styler;

import org.example.parser.ExtendContext;
import org.example.interfaces.Style;

public interface ASTStyler {
    ExtendContext applyStyle(ExtendContext ctx, Style style);

    void extractStyle(ExtendContext ctx, Style style);
}
