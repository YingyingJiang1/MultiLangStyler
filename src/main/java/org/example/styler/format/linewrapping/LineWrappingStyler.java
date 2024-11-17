package org.example.styler.format.linewrapping;

import org.example.styler.Styler;
import org.example.styler.format.linewrapping.style.LineWrappingStyle;

public class LineWrappingStyler extends Styler {
    public LineWrappingStyler() {
        style = new LineWrappingStyle(parser);
    }
}
