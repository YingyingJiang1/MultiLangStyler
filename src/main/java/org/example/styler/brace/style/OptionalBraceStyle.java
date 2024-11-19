package org.example.styler.brace.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.Style;
import org.example.style.rule.*;
import org.example.styler.format.body.style.BodyLayoutContext;
import org.example.styler.format.body.style.BodyLayoutProperty;

public class OptionalBraceStyle extends Style {
    public OptionalBraceStyle(MyParser parser) {
        super(parser);
    }
}
