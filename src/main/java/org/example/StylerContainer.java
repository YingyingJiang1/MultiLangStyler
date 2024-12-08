package org.example;

import org.example.style.Style;
import org.example.styler.Styler;
import org.example.styler.arrangement.classmember.ArrangementStyler;
import org.example.styler.arrangement.modifier.ModifierOrderStyler;
import org.example.styler.body.braceformat.BraceFormatStyler;
import org.example.styler.body.layout.BodyLayoutStyler;
import org.example.styler.body.optionalbrace.OptionalBraceStyler;
import org.example.styler.comment.density.CommentDensityStyler;
import org.example.styler.comment.syntax.CommentSyntaxStyler;
import org.example.styler.declaration.DeclarationNumberStyler;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.linestmt.LineStmtStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.space.SpaceStyler;
import org.example.styler.ifelse.IfElseBodyOrderStyler;
import org.example.styler.literal.usage.LiteralUsageStyler;
import org.example.styler.naming.NamingFormatStyler;
import org.example.styler.structure.StructureStyler;


import java.util.ArrayList;
import java.util.List;

public class StylerContainer {
    List<Styler> stylers = new ArrayList<>();

    public StylerContainer() {
        stylers.add(new ArrangementStyler());
        stylers.add(new StructureStyler());
        stylers.add(new LiteralUsageStyler());
        stylers.add(new ModifierOrderStyler());
        stylers.add(new DeclarationNumberStyler());
        stylers.add(new IfElseBodyOrderStyler());
        stylers.add(new OptionalBraceStyler());
        stylers.add(new BraceFormatStyler());
//        stylers.add(new LineWrappingStyler());
        stylers.add(new LineStmtStyler());
        stylers.add(new NewlineStyler());
        stylers.add(new CommentSyntaxStyler());
        stylers.add(new CommentDensityStyler());
        stylers.add(new SpaceStyler());
        stylers.add(new BodyLayoutStyler());
        stylers.add(new IndentionStyler());// `IndentionStyler` must be the last styler.

        stylers.add(new NamingFormatStyler());

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

    public int indexOfStyler(Class<NamingFormatStyler> namingFormatStylerClass) {
        for (int i = 0; i < stylers.size(); i++) {
            if (stylers.get(i).getClass() == namingFormatStylerClass) {
                return i;
            }
        }
        return -1;
    }

    public Styler remove(int index) {
        return stylers.remove(index);
    }

    public void insert(int index, Styler styler) {
        stylers.add(index, styler);
    }

    public NamingFormatStyler findStyler(Class<? extends Styler> stylerClass) {
        for (Styler styler : stylers) {
            if (styler.getClass() == stylerClass) {
                return (NamingFormatStyler) styler;
            }
        }
        return null;
    }
}
