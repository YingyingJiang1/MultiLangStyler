package org.example.styler.format.newline.bodylayout;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.Stage;
import org.example.styler.format.newline.NewlineApplicator;
import org.example.styler.format.newline.bodylayout.style.BodyContext;
import org.example.styler.format.newline.bodylayout.style.BodyLayoutProperty;
import org.example.styler.format.newline.bodylayout.style.BodyLayoutStyle;
import org.example.utils.NodeUtil;

import java.util.*;

public class BodyLayoutStyler extends BodyStyler {
	private static Set<Integer> relevantRules = null;

	public BodyLayoutStyler() {
//		executeWhenExit = false;
		style = new BodyLayoutStyle();
	}



	@Override
	public void extractStyle(ExtendContext ctx, MyParser parser) {
		List<ExtendContext> bodyNodes = getBodyNodes(ctx, parser);
		for (ExtendContext bodyNode : bodyNodes) {
			BodyContext styleContext = extractBodyContext(bodyNode, ctx, parser);

			Token startToken = bodyNode.getStart(), stopToken = bodyNode.getStop();

			ParserRuleContext targetAncestor = ctx.getParent();
			while (targetAncestor != null && targetAncestor.getChildCount() == 1) {
				targetAncestor = targetAncestor.getParent();
			}
			if (targetAncestor == null) {
				targetAncestor = ctx;
			}
			List<Token> tokens = ((ExtendContext) targetAncestor).getAllTokensRec();
			BodyLayoutProperty property = extractProperty(tokens, startToken, stopToken, parser);

			if (styleContext != null) {
				style.addRule(styleContext, property);

			}
		}
	}

	@Override
	public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
		List<ExtendContext> bodyNodes = getBodyNodes(ctx, parser);
		for (ExtendContext bodyNode : bodyNodes) {
			BodyContext styleContext = extractBodyContext(bodyNode, ctx, parser);
			if (styleContext == null) {
				continue;
			}

			// 获取token list: ... startToken ... stopToken
			Token startToken = bodyNode.getStart(), stopToken = bodyNode.getStop();
			ParserRuleContext targetAncestor = ctx.getParent();
			while (targetAncestor != null && targetAncestor.getChildCount() == 1) {
				targetAncestor = targetAncestor.getParent();
			}
			if (targetAncestor == null) {
				targetAncestor = ctx;
			}
			List<Token> tokens = ((ExtendContext) targetAncestor).getAllTokensRec();


			BodyLayoutProperty property = extractProperty(tokens, startToken, stopToken, parser);

			if (style.getProperty(styleContext) instanceof BodyLayoutProperty targetProperty
					&& property != null ) {
				if (startToken != null) {
					if (property.beforeLB != targetProperty.beforeLB) {
						Token targetToken = tokens.get(tokens.indexOf(startToken) - 1);
						int diff = targetProperty.beforeLB - property.beforeLB;
						if (diff > 0) {
							NewlineApplicator.addNewline(targetToken, diff, parser);
						} else if (diff < 0) {
							NewlineApplicator.removeNewline(targetToken, Math.abs(diff), parser);
						}
					}
					if (property.afterLB != targetProperty.afterLB) {
						Token targetToken = startToken;
						int diff = targetProperty.afterLB - property.afterLB;
						if (diff > 0) {
							NewlineApplicator.addNewline(targetToken, diff, parser);
						} else if (diff < 0) {
							NewlineApplicator.removeNewline(targetToken, Math.abs(diff), parser);
						}
					}
//					if (property.beforeRB != targetProperty.beforeRB) {
//						Token targetToken = tokens.get(tokens.indexOf(stopToken) - 1);
//						if (targetProperty.beforeRB) {
//							NewlineApplicator.addNewline(targetToken, 1, parser);
//						} else {
//							NewlineApplicator.removeNewline(targetToken, 1, parser);
//						}
//					}
					if (property.afterRB != targetProperty.afterRB) {
						Token targetToken = stopToken;
						int diff = targetProperty.afterRB - property.afterRB;
						if (diff > 0) {
							NewlineApplicator.addNewline(targetToken, diff, parser);
						} else if (diff < 0) {
							NewlineApplicator.removeNewline(targetToken, Math.abs(diff), parser);
						}
					}
				}
			}
		}

		return ctx;
	}

	@Override
	public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
		if (relevantRules == null) {
			relevantRules = new HashSet<>(Arrays.asList(
					parser.getRuleTypeDeclaration(),
					parser.getRuleSwitchBlockStatementGroup(),
					parser.getRuleConstructorDeclaration(),
					parser.getRuleMethodDeclaration(),
					parser.getRuleSyncStmt(),
					parser.getRuleInitializer(),
					parser.getRuleArrayInitializer(),
					parser.getRuleCatchClause(),
					parser.getRuleFinallyBlock(),
					parser.getRuleElementValueArrayInitializer()
			));
			relevantRules.addAll(parser.getCompoundStmts());
		}

		return relevantRules.contains(ctx.getRuleIndex());
	}

	private BodyLayoutProperty extractProperty(List<Token> tokens, Token startToken, Token stopToken, MyParser parser) {
		if (startToken == null || stopToken == null) {
			return null;
		}

		int startIndex = 0, stopIndex = 0;
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i) == startToken) {
				startIndex = i;
			}
			if (tokens.get(i) == stopToken) {
				stopIndex = i;
				break;
			}
		}

		int beforeLB = startIndex - 1 >= 0 ? NodeUtil.countNewlineBetween((ExtendToken) tokens.get(startIndex - 1), (ExtendToken) startToken, parser) : 0;

		if (!startToken.getText().equals("{")) {
			return new BodyLayoutProperty(beforeLB);
		}

		int afterLB =  NodeUtil.countNewlineBetween((ExtendToken) startToken, (ExtendToken)  tokens.get(startIndex + 1), parser) ;
		int beforeRB =  NodeUtil.countNewlineBetween((ExtendToken) tokens.get(stopIndex - 1), (ExtendToken) stopToken, parser) ;
		int afterRB = stopIndex + 1 < tokens.size() ?  NodeUtil.countNewlineBetween((ExtendToken) stopToken, (ExtendToken) tokens.get(stopIndex + 1), parser) : 0;

		// 只处理一个换行
		afterLB = Math.min(afterLB, 1);
		beforeLB = Math.min(beforeLB, 1);
		afterRB = Math.min(afterRB, 1);
		return new BodyLayoutProperty(beforeLB, afterLB, afterRB);
	}


}
