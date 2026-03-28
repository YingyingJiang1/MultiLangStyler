package org.example.styler.format.newline.inter;

import org.antlr.v4.runtime.Token;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.common.token.ExtendToken;
import org.example.style.InconsistencyInfo;
import org.example.style.NewlineInconsistencyInfo;
import org.example.styler.InconsistencyInfoGenerator;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.newline.NewlineAnalyzer;
import org.example.styler.format.newline.NewlineApplicator;
import org.example.styler.format.newline.inter.style.InterNewlineProperty;
import org.example.styler.format.newline.inter.style.InterNewlineStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 用于语句或者import后面的换行
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

	@Override
	public List<InconsistencyInfo> analyzeInconsistency(ExtendContext ctx, MyParser parser) {
		Token stop = ctx.getStop();
		InterNewlineProperty property = extractProperty(ctx, parser);
		if (property == null) {
			return null;
		}

		List<InconsistencyInfo> inconsistencies = new ArrayList<>();
		if (style.getProperty(null) instanceof InterNewlineProperty targetProperty
				&& !property.equals(targetProperty)) {
			int num = 1;
			if (targetProperty.hasNewline) {
				NewlineInconsistencyInfo info = NewlineAnalyzer.analyzeWhenAdding(stop, num, parser);
				info.setPriority(this.getClass());
				inconsistencies.add(info);
			} else  {
				NewlineInconsistencyInfo info = NewlineAnalyzer.analyzeWhenRemoving(stop, num, parser);
				info.setPriority(this.getClass());
				inconsistencies.add(info);
			}
		}

		return inconsistencies.stream().filter(Objects::nonNull).toList();
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
		return parser.belongToSimpleStmt(ctx) ||
		parser.isStatement(ctx) && ctx.getText().equals(";") // empty statement
				|| parser.getRuleImportDeclaration() == ctx.getRuleIndex();
	}
}
