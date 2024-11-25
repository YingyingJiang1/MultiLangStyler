package org.example.styler.format.newline.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.Style;

public class NewlineStyle extends Style {
    public NewlineStyle(MyParser parser) {
        super(parser);
        styleName = "newline";
    }
}
