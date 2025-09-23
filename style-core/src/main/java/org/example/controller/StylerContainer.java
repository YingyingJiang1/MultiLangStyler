package org.example.controller;

import org.example.styler.Styler;
import org.example.styler.arrangement.modifier.ModifierOrderStyler;
import org.example.styler.declaration.layout.DeclarationLayoutStyler;
import org.example.styler.exp.complexity.ExpressionStyler;
import org.example.styler.optionalbrace.OptionalBraceStyler;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.newline.bodylayout.BodyLayoutStyler;
import org.example.styler.format.newline.inter.InterNewlineStyler;
import org.example.styler.format.newline.intra.IntraNewlineStyler;
import org.example.styler.format.space.SpaceStyler;
import org.example.styler.ifelse.bodyorder.IfElseBodyOrderStyler;
import org.example.styler.naming.format.NamingStyler;
import org.example.styler.structure.StructureStyler;

import java.util.ArrayList;
import java.util.List;

public class StylerContainer {

	// AST stylers
	List<Styler> firstRoundStylers = new ArrayList<>();
	List<Styler> secondRoundStylers = new ArrayList<>();

	List<Styler> tsStylers = new ArrayList<>();

	public StylerContainer() {
		/**********************************************************  Structure Styles(Syntactic) **********************************************************/
		firstRoundStylers.add(new StructureStyler());
		firstRoundStylers.add(new IfElseBodyOrderStyler());
		firstRoundStylers.add(new OptionalBraceStyler());
        firstRoundStylers.add(new DeclarationLayoutStyler());
//        firstRoundStylers.add(new DeclarationLocationStyler());
        firstRoundStylers.add(new ExpressionStyler());

        /********************************************************** Naming Styles(Lexical) **********************************************************/
        firstRoundStylers.add(new NamingStyler());


        // firstRoundStylers.add(new ArrangementStyler());
        // firstRoundStylers.add(new LiteralUsageStyler());
        // firstRoundStylers.add(new UpdateVarStyler());
        // firstRoundStylers.add(new MethodComplexityStyler());
        // firstRoundStylers.add(new ParameterOrderStyler());
        // firstRoundStylers.add(new MultiBranchStyler());
        // firstRoundStylers.add(new CommentSyntaxStyler());
        // firstRoundStylers.add(new CommentedStmtDensityStyler());
        // firstRoundStylers.add(new UnusedCodeStyler()); // FIXME: causes crash
        // tsStylers.add(new CommentLineDensityStyler());

		/********************************************************** Lexical **********************************************************/
		firstRoundStylers.add(new ModifierOrderStyler());

		/**********************************************************  Format Styles(Lexical) **********************************************************/
        secondRoundStylers.add(new NewlineStyler());
		secondRoundStylers.add(new IntraNewlineStyler());
		secondRoundStylers.add(new InterNewlineStyler());
		secondRoundStylers.add(new BodyLayoutStyler());


        tsStylers.add(new SpaceStyler());
        tsStylers.add(new IndentionStyler()); // `IndentionStyler` must be the last styler.

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

	/**
	 * @param target
	 * @return The styler that was disabled.
	 */
	public Styler removeStyler(Class<? extends Styler> target) {
		List<Styler> stylers = getStylers();
		for (Styler styler : stylers) {
			if (styler.getClass().equals(target)) {
				styler.disable();
				return styler;
			}
		}
		return null;
	}

}
