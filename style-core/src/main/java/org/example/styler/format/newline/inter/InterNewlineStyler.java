package org.example.styler.format.newline.inter;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.newline.NewlineApplicator;
import org.example.styler.format.newline.inter.style.InterNewlineProperty;
import org.example.styler.format.newline.inter.style.InterNewlineStyle;

/**
 * 专注于相邻语句之间，import之间的换行符使用习惯
 */
public class InterNewlineStyler extends Styler {
	public InterNewlineStyler() {
//		executeWhenExit = false;
		style = new InterNewlineStyle();
	}

	@Override
	public void extractStyle(ExtendContext ctx, MyParser parser) {
		style.addRule(null, new InterNewlineProperty(true)); // 默认添加换行
	}

	@Override
	public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
		Token stop = ctx.getStop();
		InterNewlineProperty property = extractProperty(ctx, parser);
		if (property == null) {
			return null;
		}
		if (style.getProperty(null) instanceof InterNewlineProperty targetProperty
		&& !property.equals(targetProperty)) {
			int num = 1;
			if (targetProperty.hasNewline) {
				NewlineApplicator.addNewline(stop, num, parser);
			} else  {
				NewlineApplicator.removeNewline(stop, num, parser);
			}
		}
		return ctx;
	}

	private InterNewlineProperty extractProperty(ExtendContext ctx, MyParser parser) {
		Token stop = ctx.getStop();
		if (stop instanceof ExtendToken extendToken) {
			long newlines = extendToken.getContextTokens().stream()
					.mapToLong(t -> t.getText().chars().filter(c -> c == '\n').count()).sum();
			return new InterNewlineProperty(newlines > 0);
		}
		return null;
	}

	@Override
	public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
		return parser.belongToSingleStmt(ctx) ||
		parser.isStatement(ctx) && ctx.getText().equals(";") // empty statement
				|| parser.getRuleImportDeclaration() == ctx.getRuleIndex();
	}
}
