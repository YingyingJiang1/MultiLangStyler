package org.example;

import org.example.styler.Styler;
import org.example.styler.arrangement.ArrangementStyler;
import org.example.styler.body.braceformat.BraceFormatStyler;
import org.example.styler.body.optionalbrace.OptionalBraceStyler;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.linestmt.LineStmtStyler;
import org.example.styler.format.linewrapping.LineWrappingStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.space.SpaceStyler;
import org.example.styler.structure.StructureStyler;

import java.util.List;

public class StylerContainer {
    Styler arrangementStyler;
    Styler optionalBraceStyler;
    Styler structureStyler;
    Styler braceFormatStyler;
    Styler bodyLayoutStyler;
    Styler lineWrappingStyler;
    Styler lineStmtStyler;
    Styler newlineStyler;
    Styler spaceStyler;
    Styler indentionStyler;

    public StylerContainer() {
        arrangementStyler = new ArrangementStyler();
        optionalBraceStyler = new OptionalBraceStyler();
        structureStyler = new StructureStyler();
        braceFormatStyler = new BraceFormatStyler();
        lineWrappingStyler = new LineWrappingStyler();
        lineStmtStyler = new LineStmtStyler();
        newlineStyler = new NewlineStyler();
        spaceStyler = new SpaceStyler();
        indentionStyler = new IndentionStyler();
        bodyLayoutStyler = new BraceFormatStyler();
    }

    public List<Styler> getAstStylers() {
        return List.of(arrangementStyler, optionalBraceStyler, structureStyler, braceFormatStyler, lineWrappingStyler, lineStmtStyler, newlineStyler);
    }

    public List<Styler> getTSstylers() {
    }

}
