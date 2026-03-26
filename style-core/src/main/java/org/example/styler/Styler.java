package org.example.styler;

import lombok.Getter;
import org.antlr.v4.runtime.Token;
import org.example.antlr.common.context.ExtendContext;
import org.example.lang.intf.MyParser;
import org.example.style.CommonStyle;
import org.example.style.InconsistencyInfo;
import org.example.style.Style;
import org.example.style.codecontext.ASTBasedCodeContext;
import org.example.style.codecontext.CodeContext;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/21 10:44
 */
public abstract class Styler {
	protected Style style;
	protected boolean enableExtraction = true;
	protected boolean enableApplication = true;
	public boolean executeWhenExit = true;
	@Getter
	protected List<InconsistencyInfo> inconsistencyInfos = new ArrayList<>();

	public Styler(boolean enableExtraction, boolean enableApplication) {
		this.enableExtraction = enableExtraction;
		this.enableApplication = enableApplication;
	}

	public Styler() {
		style = new CommonStyle();
	}

	public Styler(boolean executeWhenExit) {
		style = new CommonStyle();
		this.executeWhenExit = executeWhenExit;
	}

	public Style getStyle() {
		return style;
	}

	public List<Token> applyStyle(List<Token> tokens, int index, MyParser parser) {
		List<CodeContext> codeContexts = constructCodeContext(tokens, index, parser);
		for (CodeContext codeContext : codeContexts) {
			StyleContext styleContext = extractStyleContext(codeContext, parser);
			StyleProperty currentProperty = extractStyleProperty(codeContext, parser);
			StyleProperty targetProperty = style.getProperty(styleContext);
			if (targetProperty != null && isInconsistent(currentProperty, targetProperty, parser)) {
				doApply(codeContext, currentProperty, targetProperty, parser);
			}
		}
		return tokens;
	}

	public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
		List<CodeContext> codeContexts = constructCodeContext(ctx, parser);
		ExtendContext ret = null;
		for (CodeContext codeContext : codeContexts) {
			StyleContext styleContext = extractStyleContext(codeContext, parser);
			StyleProperty currentProperty = extractStyleProperty(codeContext, parser);
			StyleProperty targetProperty = style.getProperty(styleContext);
			if (targetProperty == null) {
				return ctx;
			}

			if (isInconsistent(currentProperty, targetProperty, parser)) {
				ret = doApply(codeContext, currentProperty, targetProperty, parser);
			}
		}

		// If there's only one code context derived from ctx and the reference to ctx has been changed, return the changed ctx;
		// otherwise, return the original ctx to avoid.
		return ret == null ?  ctx : ret;
	}


	public void extractStyle(ExtendContext ctx, MyParser parser) {
		List<CodeContext> codeContexts = constructCodeContext(ctx, parser);
		commonExtractStyle(codeContexts, parser);
	}
	
	public void extractStyle(List<Token> tokens, int index, MyParser parser) {
		List<CodeContext> codeContexts = constructCodeContext(tokens, index, parser);
		commonExtractStyle(codeContexts, parser);
	}

	private void commonExtractStyle(List<CodeContext> codeContexts, MyParser parser) {
		for (CodeContext codeContext : codeContexts) {
			StyleContext styleContext = extractStyleContext(codeContext, parser);
			StyleProperty property = extractStyleProperty(codeContext, parser);
			if (testStyleContext(styleContext) && testStyleProperty(property)) {
				style.addRule(styleContext, property);
			}
		}
	}

	protected boolean testStyleContext(StyleContext context) {
		return true;
	}

	protected boolean testStyleProperty(StyleProperty property) {
		return property != null;
	}

	public @NonNull List<InconsistencyInfo> analyzeInconsistency(ExtendContext ctx, MyParser parser) {
		List<CodeContext> codeContexts = constructCodeContext(ctx, parser);
		return commonAnalyzeInconsistency(codeContexts, parser);
	}

	public @NonNull List<InconsistencyInfo> analyzeInconsistency(List<Token> tokens, int index, MyParser parser) {
		List<CodeContext> codeContexts = constructCodeContext(tokens, index, parser);
		return commonAnalyzeInconsistency(codeContexts, parser);
	}

	private @NonNull List<InconsistencyInfo> commonAnalyzeInconsistency(List<CodeContext> codeContexts, MyParser parser) {
		List<InconsistencyInfo> infos = new ArrayList<>();
		for (CodeContext codeContext : codeContexts) {
			StyleContext styleContext = extractStyleContext(codeContext, parser);
			StyleProperty currentProperty = extractStyleProperty(codeContext, parser);
			StyleProperty targetProperty = style.getProperty(styleContext);
			if (targetProperty == null) {
				continue;
			}
			if (isInconsistent(currentProperty, targetProperty, parser)) {
				infos.add(generateInconsistencyInfo(codeContext, styleContext, currentProperty, targetProperty, parser));
			}
		}

		inconsistencyInfos.addAll(infos);
		return infos;
	}

	protected List<CodeContext> constructCodeContext(List<Token> tokens, int index, MyParser parser) {
		return new ArrayList<>();
	}

	/**
	 * @param ctx
	 * @param parser
	 * @return a list of code contexts derived from the given context, which are relevant for style extraction and application.
	 */
	protected List<CodeContext> constructCodeContext(ExtendContext ctx, MyParser parser) {
		return List.of(new ASTBasedCodeContext(ctx));
	}

	protected StyleContext extractStyleContext(CodeContext codeContext, MyParser parser) {
		return null;
	}

	protected StyleProperty extractStyleProperty(CodeContext codeContext, MyParser parser) {
		return null;
	}

	protected ExtendContext doApply(CodeContext codeContext, StyleProperty currentProperty,
									StyleProperty targetProperty, MyParser parser) {
		return null;
	}

	protected InconsistencyInfo generateInconsistencyInfo(CodeContext codeContext, StyleContext styleContext, StyleProperty currentProperty,
														  StyleProperty targetProperty, MyParser parser) {
		return null;
	}

	protected boolean isInconsistent(StyleProperty currentProperty, StyleProperty targetProperty, MyParser parser) {
		if (currentProperty == null || targetProperty == null) {
			return false;
		}
		return !Objects.equals(currentProperty, targetProperty);
	}

	public boolean isEnable(Stage stage) {
		if (stage == Stage.EXTRACT) {
			return enableExtraction;
		}
		if (stage == Stage.APPLY) {
			return enableApplication;
		}
		return true;
	}

	public void enable() {
		enableExtraction = true;
		enableApplication = true;
	}

	public void disable() {
		enableExtraction = false;
		enableApplication = false;
	}

	public void extractFinalize() {
		style.fillStyle();
		style.filterRules();
	}

	public void applicationFinalize() {
	}


	protected Set<Integer> getRelevantRules(MyParser parser) {
		return null;
	}

	protected Set<String> getRelevantTokens(MyParser parser) {
		return null;
	}

	/**
	 * @param ctx
	 * @param stage  EXTRACT or APPLY
	 * @param parser
	 * @return
	 * @implNote
	 */
	public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
		Set<Integer> relevantRules = getRelevantRules(parser);
		// Special case: all rules is relevant.
		if (relevantRules == null) {
			return true;
		}
		int targetRule = ctx.getRuleIndex();
		return relevantRules.contains(targetRule);
	}

	public boolean isRelevant(List<Token> tokens, int i, Stage stage, MyParser parser) {
		Set<String> relevantTokens = getRelevantTokens(parser);
		// Special case: all tokens is relevant.
		if (relevantTokens == null) {
			return true;
		}
		return relevantTokens.contains(tokens.get(i).getText());
	}

	public void setStyle(Style style) {
		this.style = style;
	}
}
