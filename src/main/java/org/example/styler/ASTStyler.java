package org.example.styler;

import org.example.parser.ExtendContext;
import org.example.style.ProgramStyle;
import org.example.style.Style;

public interface ASTStyler {
    ExtendContext applyStyle(ExtendContext ctx, Style style);

    void extractStyle(ExtendContext ctx, Style style);
}
