package org.example.styler.arrangement.modifier;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.RunStatistic;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.style.InconsistencyInfo;
import org.example.style.InconsistencyType;
import org.example.style.StyleApplyData;
import org.example.style.codecontext.CodeContext;
import org.example.style.codecontext.ListASTBasedCodeContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.arrangement.modifier.style.ModifierOrderProperty;
import org.example.styler.arrangement.modifier.style.ModifierOrderStyle;

import java.util.*;

/**
 * @implNote : style application rely on the hypothesis:
 * 1. all the modifier nodes are the direct children of the input {@code ctx} node.
 * */
public class ModifierOrderStyler extends Styler {
	public ModifierOrderStyler() {
		style = new ModifierOrderStyle();
	}

//	@Override
//	public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
//		if (style.getProperty(null) == null) {
//			return ctx;
//		}
//
//		List<String> target = ((ModifierOrderProperty) style.getProperty(null)).order;
//		Map<ParseTree, Integer> inTargetMap = new HashMap<>();
//		Map<ParseTree, Integer> indexInOriginalMap = new HashMap<>();
//		int index = -1;
//		for (int i = 0; i < ctx.getChildCount(); i++) {
//			index = target.indexOf(getModifierName(ctx.getChild(i), parser));
//			if (index >= 0) {
//				inTargetMap.put(ctx.getChild(i), index);
//				indexInOriginalMap.put(ctx.getChild(i), i);
//			}
//		}
//
//		if (!inTargetMap.equals(indexInOriginalMap)) {
//			// Resort modifier which are in the target order list.
//			List<ParseTree> ordered = inTargetMap.keySet().stream().sorted(Comparator.comparing(inTargetMap::get)).toList();
//			// 相关modifier在原始children中的索引按照从小到大顺序排列
//			List<Integer> originalIndices = indexInOriginalMap.values().stream().sorted().toList();
//			for (int i = 0; i < originalIndices.size(); i++) {
//				ctx.setChild(originalIndices.get(i), ordered.get(i));
//			}
//			ctx.updateStartToken();
//			ctx.updateStopToken();
//
//			RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
//		}
//
//		return ctx;
//	}

	@Override
	protected CodeContext constructCodeContext(ExtendContext ctx, MyParser parser) {
		List<ParseTree> modifiers = LangAdapterCreator.createASTNodeSearcher(parser.getLanguage()).searchAllModifiers(ctx);
		List<Integer> indices = new ArrayList<>();
		for (ParseTree modifier : modifiers) {
			indices.add(ctx.children.indexOf(modifier));
		}
		return new ListASTBasedCodeContext(modifiers, indices);
	}

	@Override
	protected StyleProperty extractStyleProperty(CodeContext codeContext, MyParser parser) {
		if (codeContext instanceof ListASTBasedCodeContext listContext) {
			List<String> modifiers = new ArrayList<>();
			for (ParseTree node : listContext.getNodes()) {
				String modifierName = getModifierName(node, parser);
				if (!modifierName.isEmpty()) {
					modifiers.add(modifierName);
				}
			}
			return new ModifierOrderProperty(modifiers);
		}
		return null;
	}

	@Override
	protected ExtendContext doApply(List<InconsistencyInfo> infos, StyleProperty targetProperty, MyParser parser) {
		ModifierOrderProperty property = (ModifierOrderProperty) targetProperty;
		List<String> target = property.order;

		for (InconsistencyInfo info : infos) {
			StyleApplyData applyData = info.getStyleApplyData();
			ListASTBasedCodeContext codeContext = (ListASTBasedCodeContext) applyData.codeContext;

			// mapping from modifier node to its index in the target order list,
			// and mapping from modifier node to its index in the original children list.
			Map<ParseTree, Integer> inTargetMap = new HashMap<>();
			Map<ParseTree, Integer> indexInOriginalMap = new HashMap<>();
			int index = -1;
			for (int i = 0; i < codeContext.size(); i++) {
				ParseTree node = codeContext.getNode(i);
				index = target.indexOf(getModifierName(node, parser));
				if (index >= 0) {
					inTargetMap.put(node, index);
					indexInOriginalMap.put(node, i);
				}
			}

			// Resort modifier which are in the target order list.
			List<ParseTree> ordered = inTargetMap.keySet().stream().sorted(Comparator.comparing(inTargetMap::get)).toList();
			ExtendContext parent = (ExtendContext) codeContext.getNode(0).getParent();
			// 相关modifier在原始children中的索引按照从小到大顺序排列
			List<Integer> originalIndices = indexInOriginalMap.values().stream().sorted().toList();
			for (int i = 0; i < originalIndices.size(); i++) {
				parent.setChild(originalIndices.get(i), ordered.get(i));
			}
			parent.updateStartToken();
			parent.updateStopToken();

//			RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
		}

		return null;
	}

	@Override
	protected List<InconsistencyInfo> generateInconsistencyInfo(CodeContext codeContext, StyleProperty currentProperty,
														   StyleProperty targetProperty, boolean fillApplyData, MyParser parser) {
		if (currentProperty instanceof ModifierOrderProperty current && targetProperty instanceof ModifierOrderProperty target) {
			 List[] filteredLists = alignModifiers(current.order, target.order);
			InconsistencyInfo info = new InconsistencyInfo(
					InconsistencyType.MODIFIER_ORDER,
					filteredLists[1].toString().substring(1, filteredLists[1].toString().length() - 1),
					filteredLists[0].toString().substring(1, filteredLists[0].toString().length() - 1), "",
					new InconsistencyInfo.Location(codeContext.getStartRow(), codeContext.getStartColumn(),
							codeContext.getEndRow(), codeContext.getEndColumn())
			);

			if (fillApplyData) {
				info.setStyleApplyData(new StyleApplyData(codeContext));
			}

			return List.of(info);
		}
		return null;
	}

	@Override
	protected boolean isInconsistent(StyleProperty currentProperty, StyleProperty targetProperty, MyParser parser) {
		if (currentProperty instanceof ModifierOrderProperty current && targetProperty instanceof ModifierOrderProperty target) {
			List[] filteredLists = alignModifiers(current.order, target.order);
			return !filteredLists[0].equals(filteredLists[1]);
		}
		return false;
	}

	private List[] alignModifiers(List<String> list1, List<String> list2) {
		List<String> list2Filtered = new ArrayList<>();
		for (String modifier : list2) {
			if (list1.contains(modifier)) {
				list2Filtered.add(modifier);
			}
		}
		List<String> list1Filtered = new ArrayList<>();
		for (String modifier : list1) {
			if (list2.contains(modifier)) {
				list1Filtered.add(modifier);
			}
		}
		return new List[]{list1Filtered, list2Filtered};
	}

	private String getModifierName(ParseTree t, MyParser parser) {
		if (parser.isAnnotation(t)) {
			return "ANNOTATION";
		} else if (isAccessControl(t.getText())) {

			return "ACCESS_CONTROL";
		} else {
			return t.getText();
		}
	}

	@Override
	public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
		int ruleIndex = ctx.getRuleIndex();
		return ruleIndex == parser.getRuleModifierList();
	}

	private boolean isAccessControl(String text) {
		return text.equals("public") || text.equals("private") || text.equals("protected");
	}

}
