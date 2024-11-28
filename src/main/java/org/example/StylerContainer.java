package org.example;

import org.example.styler.Styler;
import org.example.styler.arrangement.ArrangementStyler;
import org.example.styler.body.braceformat.BraceFormatStyler;
import org.example.styler.body.layout.BodyLayoutStyler;
import org.example.styler.body.optionalbrace.OptionalBraceStyler;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.linestmt.LineStmtStyler;
import org.example.styler.format.linewrapping.LineWrappingStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.space.SpaceStyler;
import org.example.styler.structure.StructureStyler;

import java.util.ArrayList;
import java.util.List;

public class StylerContainer {
    List<Styler> stylers = new ArrayList<>();

    public StylerContainer() {
        stylers.add(new ArrangementStyler());
//        stylers.add(new StructureStyler());
//        stylers.add(new OptionalBraceStyler());
//        stylers.add(new BraceFormatStyler());
//        stylers.add(new LineWrappingStyler());
//        stylers.add(new LineStmtStyler());
//        stylers.add(new NewlineStyler());
        stylers.add(new SpaceStyler());
//        stylers.add(new BraceFormatStyler());
//        stylers.add(new BodyLayoutStyler());
//        stylers.add(new IndentionStyler());// `IndentionStyler` must be the last styler.

    }

    public List<Styler> getStylers() {
        return stylers;
    }

    public List<Styler> getAstStylers() {
        return null;
    }

    public List<Styler> getTStreamStylers() {
        return null;
    }

}
