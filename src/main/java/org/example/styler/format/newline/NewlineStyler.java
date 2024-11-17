package org.example.styler.format.newline;

import org.example.styler.Styler;
import org.example.styler.format.newline.style.NewlineStyle;

public class NewlineStyler extends Styler {
    public NewlineStyler() {
        style = new NewlineStyle(parser);
    }
}
