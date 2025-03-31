package org.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.example.styler.Styler;
import org.example.styler.arrangement.classmember.ArrangementStyler;
import org.example.styler.comment.density.CommentDensityStyler;
import org.example.styler.comment.syntax.CommentSyntaxStyler;
import org.example.styler.declaration.location.DeclarationLocationStyler;
import org.example.styler.exp.complexity.ExpressionStyler;
import org.example.styler.format.body.braceformat.BraceFormatStyler;
import org.example.styler.format.body.layout.BodyLayoutStyler;
import org.example.styler.format.body.optionalbrace.OptionalBraceStyler;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.linewrapping.LineWrappingStyler;
import org.example.styler.format.newline.LineStmtStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.space.SpaceStyler;
import org.example.styler.ifelse.bodyorder.IfElseBodyOrderStyler;
import org.example.styler.ifelse.multibranch.MultiBranchStyler;
import org.example.styler.literal.usage.LiteralUsageStyler;
import org.example.styler.naming.format.NamingFormatStyler;
import org.example.styler.structure.StructureStyler;

public class StylerContainer {

    // AST stylers
    List<Styler> firstRoundStylers = new ArrayList<>();
    List<Styler> secondRoundStylers = new ArrayList<>();

    List<Styler> tsStylers = new ArrayList<>();

    public StylerContainer() {
        firstRoundStylers.add(new ArrangementStyler());
        firstRoundStylers.add(new LiteralUsageStyler());
//        firstRoundStylers.add(new ModifierOrderStyler());
//        firstRoundStylers.add(new DeclarationNumberStyler());
//        firstRoundStylers.add(new DeclarationLocationStyler()); // Add static analysis module
       firstRoundStylers.add(new IfElseBodyOrderStyler());
        firstRoundStylers.add(new ExpressionStyler());
//        firstRoundStylers.add(new UpdateVarStyler());
//        firstRoundStylers.add(new FunctionComplexityStyler());
//        firstRoundStylers.add(new ParameterOrderStyler());
        firstRoundStylers.add(new StructureStyler());
         firstRoundStylers.add(new OptionalBraceStyler());
        firstRoundStylers.add(new MultiBranchStyler());

        firstRoundStylers.add(new CommentSyntaxStyler());


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
