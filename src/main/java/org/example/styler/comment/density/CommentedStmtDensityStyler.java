package org.example.styler.comment.density;

import org.antlr.v4.runtime.Token;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.comment.CommentContext;
import org.example.styler.comment.CommentType;
import org.example.styler.comment.density.style.CommentDensityProperty;
import org.example.utils.ModelClient;
import org.example.utils.NodeUtil;

import java.util.*;
import java.util.ArrayList;

public class CommentedStmtDensityStyler extends Styler {
	private List<Double> densities = new ArrayList<>();

	private static CommentContext DEFAULT_CONTEXT = new CommentContext(CommentType.ON_STMT);

	public CommentedStmtDensityStyler() {
		style.setStyleName("comment_density");
	}

	@Override
	public void extractStyle(ExtendContext ctx, MyParser parser) {
		CommentDensityProperty property = extractProperty(ctx, parser);
		densities.add(property.commentDensity);
	}

	@Override
	public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
		CommentDensityProperty property = extractProperty(ctx, parser);
		if (style.getProperty(DEFAULT_CONTEXT) instanceof CommentDensityProperty targetProperty) {
			if (property.compareTo(targetProperty) > 0) {
				removeComment(ctx,parser, targetProperty);
			} else if (property.compareTo(targetProperty) < 0) {
				addComment(ctx, parser, targetProperty);
			}
		}

		return ctx;
	}

	private void addComment(ExtendContext ctx, MyParser parser, CommentDensityProperty targetProperty) {
		String taskDescription = String.format(
				"Your task is to add comments to appropriate statements in the given code. " +
						"The goal is to ensure that the proportion of commented statements among all code statements is as close as possible to the target ratio %s.\n" +
						"A commented statement is a code statement that has an accompanying comment explaining its behavior or purpose.\n" +
						"You may only add comments. Do not modify, delete, reorder, or insert any code other than comments.\n"  +
						"###Here is the input code:\n" +
						"%s\\n",
						targetProperty.commentDensity, ctx.getFormattedText(parser));
		String constraints = "1. Output the resulting Java code only. Do not include any explanations or additional text outside the code block.\n" +
				"2. You may only add, delete or modify comments.";
		List<String> candidates = ModelClient.getInstance().sendRequestWithTemplate(taskDescription, constraints, GlobalInfo.getLanguage());
		if (candidates == null) {
			return;
		}
		for (String candidate : candidates) {
			MyParser newParser = MyParserFactory.createParser(GlobalInfo.getLanguage());
			newParser.parseFromString(candidate);
			if (newParser.getRoot() == null) {
				continue;
			}

			ExtendContext newMethodNode = (ExtendContext) newParser.getRoot();
			boolean isValid = newMethodNode.getText().equals(ctx.getText());

			if (isValid && ctx.getParent() instanceof ExtendContext parent) {
				parent.replaceChild(ctx, newMethodNode);
				break;
			}
		}
	}

	private void removeComment(ExtendContext ctx, MyParser parser, CommentDensityProperty targetProperty) {
		List<ExtendContext> allStmts = ctx.getAllCtxsRecIf(parser::isStatement);
		List<ExtendContext> commentedStmts = getCommentedStmts(allStmts, parser);
		int removeCount = commentedStmts.size() - (int) (allStmts.size() * targetProperty.commentDensity);
		if (removeCount > 0) {
			Collections.shuffle(commentedStmts);
			for (int i = 0; i < removeCount; i++) {
				ExtendContext stmt = commentedStmts.get(i);
				if (stmt.getStart() instanceof ExtendToken token) {
					token.getContextTokens().removeIf(t -> parser.belongToComment(t.getType()));
				}
				if (stmt.getStop() instanceof ExtendToken token) {
					token.getContextTokens().removeIf(t -> parser.belongToComment(t.getType()));
				}
			}
		}
	}

	@Override
	public void extractFinalize() {
		double avgDensity = densities.stream().mapToDouble(e -> e).average().orElse(0);
		style.addRule(DEFAULT_CONTEXT, new CommentDensityProperty(avgDensity));
	}



	@Override
	public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
		return parser.belongToMethodDec(ctx.getRuleIndex());
	}

	protected List<ExtendContext> getCommentedStmts(List<ExtendContext> stmts, MyParser parser) {
		List<ExtendContext> commentedStmts = new ArrayList<>();
		for (ExtendContext stmt : stmts) {
			if (stmt.getStart() instanceof ExtendToken extToken) {
				Optional<Token> commentToken = extToken.getContextTokens().stream()
						.filter(t -> parser.belongToComment(t.getType())).findAny();
				if (commentToken.isPresent()) {
					commentedStmts.add(stmt);
					continue;
				}
			}

			if (stmt.getStop() instanceof ExtendToken extToken) {
				Optional<Token> commentToken = extToken.getContextTokens().stream()
						.filter(t -> parser.belongToComment(t.getType())).findAny();
				if (commentToken.isPresent()) {
					commentedStmts.add(stmt);
				}
			}
		}
		return commentedStmts;
	}

	protected CommentDensityProperty extractProperty(ExtendContext ctx, MyParser parser) {
		List<ExtendContext> allStmts = ctx.getAllCtxsRecIf(parser::isStatement);
		double commentedStmtCount = getCommentedStmts(allStmts, parser).size();

		return new CommentDensityProperty(commentedStmtCount / allStmts.size());
	}



//	protected CommentType getCommentType(ExtendContext ctx, MyParser parser) {
//		if (parser.isStatement(ctx)) {
//			return CommentType.ON_STMT;
//		} else if (parser.isTypeDeclaration(ctx)) {
//			return CommentType.ON_TYPE;
//		} else if (parser.belongToMethodDec(ctx.getRuleIndex())) {
//			return CommentType.ON_METHOD;
//		} else {
//			return null;
//		}
//	}
}
