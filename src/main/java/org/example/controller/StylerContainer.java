package org.example.controller;

import org.example.styler.Styler;
import org.example.styler.arrangement.classmember.ArrangementStyler;
import org.example.styler.comment.density.CommentDensityStyler;
import org.example.styler.format.body.braceformat.BraceFormatStyler;
import org.example.styler.format.body.layout.BodyLayoutStyler;
import org.example.styler.declaration.location.DeclarationLocationStyler;
import org.example.styler.format.body.optionalbrace.OptionalBraceStyler;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.newline.LineStmtStyler;
import org.example.styler.format.linewrapping.LineWrappingStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.space.SpaceStyler;
import org.example.styler.naming.format.NamingFormatStyler;
import org.example.styler.structure.StructureStyler;


import java.util.ArrayList;
import java.util.List;

public class StylerContainer {

    // AST stylers
    List<Styler> firstRoundStylers = new ArrayList<>();
    List<Styler> secondRoundStylers = new ArrayList<>();

    List<Styler> tsStylers = new ArrayList<>();

    public StylerContainer() {
        firstRoundStylers.add(new ArrangementStyler());
        // firstRoundStylers.add(new LiteralUsageStyler()); // empty yet during extraction
//        firstRoundStylers.add(new ModifierOrderStyler());
//        firstRoundStylers.add(new DeclarationNumberStyler());
        firstRoundStylers.add(new DeclarationLocationStyler());
//        firstRoundStylers.add(new IfElseBodyOrderStyler()); // untested
        // firstRoundStylers.add(new ExpressionStyler()); // empty yet during extraction
//        firstRoundStylers.add(new UpdateVarStyler());
//        firstRoundStylers.add(new FunctionComplexityStyler());
//        firstRoundStylers.add(new ParameterOrderStyler());
        firstRoundStylers.add(new StructureStyler());
         firstRoundStylers.add(new OptionalBraceStyler());
        // firstRoundStylers.add(new MultiBranchStyler()); // empty yet during extraction

        // firstRoundStylers.add(new CommentSyntaxStyler()); // empty yet during extraction


        firstRoundStylers.add(new NamingFormatStyler());
        // firstRoundStylers.add(new UnusedCodeStyler()); // FIXME: causes crash

        // Format styles
        secondRoundStylers.add(new BodyLayoutStyler());
        secondRoundStylers.add(new BraceFormatStyler());
        secondRoundStylers.add(new LineWrappingStyler());
        secondRoundStylers.add(new LineStmtStyler());
        secondRoundStylers.add(new NewlineStyler());


        tsStylers.add(new SpaceStyler());
        tsStylers.add(new IndentionStyler()); // `IndentionStyler` must be the last styler.
        tsStylers.add(new CommentDensityStyler());

    }

    public List<Styler> getStylers() {
        List<Styler> allStylers = new ArrayList<>();
        allStylers.addAll(firstRoundStylers);
        allStylers.addAll(secondRoundStylers);
        allStylers.addAll(tsStylers);
        return allStylers;
    }

    public List<Styler> getFirstRoundStylers() {
        return firstRoundStylers;
    }

    public List<Styler> getSecondRoundStylers() {
        return secondRoundStylers;
    }

    public List<Styler> getTsStylers() {
        return tsStylers;
    }

}
