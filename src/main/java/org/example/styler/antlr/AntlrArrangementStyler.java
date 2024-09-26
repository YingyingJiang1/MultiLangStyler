package org.example.styler.antlr;

import groovy.util.PermutationGenerator;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.Helper;
import org.example.antlr.JavaParser;
import org.example.parser.ExtendContext;
import org.example.myException.StylizationException;
import org.example.style.ProgramStyle;
import org.example.style.arrangement.*;

import java.util.*;
import java.util.function.Predicate;

/*
 * @description
 * Please ensure: the relevant AST structure is consistent with the definition in JavaParser.g4
 * @author       Yingying Jiang
 * @create       2024/3/25 6:34
 */
public class AntlrArrangementStyler extends AntlrConcreteStylerBase {
	private static AntlrArrangementStyler instance = new AntlrArrangementStyler();

	private AntlrArrangementStyler() {
	}

	private static Set<Integer> relevantRules = new HashSet<>(Arrays.asList(
			JavaParser.RULE_typeDeclaration
	));

	public static AntlrArrangementStyler getInstance() {
		return instance;
	}

	/*
	 * @description: This method resorts all list context instances in type declaration body
	 * according to @areas of structure style.
	 * The implementation description:
	 * 1. Create a corresponding list context for each area of @areas in the structure style.
	 * 2. Find the matched area with the current list context in @areas,
	 *  and move the children of the current list context to the corresponding list context of the matched area.
	 * 3. Append the list contexts without matched areas in @areas to the end of the matched list contexts
	 *  in relative order.
	 * 4. Replace the old list contexts with new list contexts in the type declaration body.
	 *  The new list contexts are arranged with all the list contexts having matched area first,
	 *  followed by the list contexts without matched area in their original relative order.
	 *
	 */
	public ExtendContext applyStyle(ExtendContext ctx, ProgramStyle programStyle) {
		try {
			ContentContext contentContext = extractContentContext(ctx);
			if (contentContext == null) {
				return ctx;
			}
			Arrangement arrangement = (Arrangement) programStyle.getStyle(ProgramStyle.ARRANGEMENT);
			List<Area.ContentArea> areas = arrangement.getContentArrangement(contentContext);
			List<ExtendContext> newListCtxs = new ArrayList<>(Collections.nCopies(areas.size(), null));


			// Create a new list of declaration lists for the body of type declaration.
			ExtendContext bodyCtx = (ExtendContext) ctx
					.getFirstInnerChildByType(JavaParser.RULE_body);
			if (bodyCtx == null) {
				return ctx;
			}
			int from = -1, to =  -1;
			for (int i = 0; i < bodyCtx.getChildCount(); ++i) {
				ParseTree child = bodyCtx.getChild(i);
				if (child instanceof ExtendContext && isList(((ExtendContext) child).getRuleIndex())) {
					if(from == -1) {
						from = i;
					}
					to = i;
					ExtendContext listCtx = (ExtendContext) child;
					Feature feature = extractFeature(listCtx);
					Area.ContentArea area = createArea(listCtx);
					area.fillArea(feature, null);
					int minDistance = Integer.MAX_VALUE, targetAreaIndex = -1;
					for (int j = 0; j < areas.size(); ++j) {
						int distance = areas.get(j).calDistance(area);
						if (distance < minDistance) {
							minDistance = distance;
							targetAreaIndex = j;
						}
					}
					if (targetAreaIndex == -1) {
						newListCtxs.add(listCtx);
					} else {
						if (newListCtxs.get(targetAreaIndex) == null) {
							newListCtxs.set(targetAreaIndex, listCtx);
						} else {
							ExtendContext savedListCtx = newListCtxs.get(targetAreaIndex);
							for (ParseTree root : listCtx.children) {
								root.setParent(savedListCtx);
								savedListCtx.children.add(root);
							}
						}
					}
				}
			}

			int count = 0;
			for (int i = 0; i < newListCtxs.size(); ++i) {
				ExtendContext listCtx = newListCtxs.get(i);
				// The children of a list context that has a matched area needed to be arranged.
				if (count < areas.size()) {
					if (listCtx == null) {
						newListCtxs.remove(i);
						--i;
					} else {
						arrangeChildren(listCtx, areas.get(count));
					}
				}
				++count;
			}

			if (from >= 0) {
				// Update the order of all declaration lists in the newly created list.
				bodyCtx.replaceChildren(from, to + 1, newListCtxs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new StylizationException("apply arrangement style failed:" + e.getMessage());
		}
		return ctx;
	}


	public void extractStyle(ExtendContext ctx, ProgramStyle programStyle) {
		try {
			// Extract order info in top level type declaration.
			boolean isTopLevelDec = ctx.getParent().getParent() instanceof JavaParser.CompilationUnitContext;
			if (isTopLevelDec) {
				Arrangement arrangement = (Arrangement) programStyle.getStyle(ProgramStyle.ARRANGEMENT);
				ContentContext contentContext = extractContentContext(ctx);
				if (contentContext != null && !arrangement.contains(contentContext)) {
					ExtendContext bodyCtx = (ExtendContext) ctx
							.getFirstInnerChildByType(JavaParser.RULE_body);
					if (bodyCtx == null) {
						return;
					}
					List<Area.ContentArea> areas = new ArrayList<>();
					for (ParseTree child : bodyCtx.children) {
						if (child instanceof ExtendContext && isList(((ExtendContext) child).getRuleIndex())) {
							ExtendContext listCtx = (ExtendContext) child;
							Area.ContentArea area = createArea(listCtx);
							area.fillArea(extractFeature(listCtx), extractOrder(listCtx));
							areas.add(area);
						}
					}
					arrangement.addContentArrangement(contentContext, areas);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new StylizationException("extract arrangement style failed:" + e.getMessage());
		}
	}

	/**
	 * @param ctx TypeDeclarationContext
	 * @return
	 */
	private ContentContext extractContentContext(ExtendContext ctx) {
		ExtendContext headCtx = (ExtendContext) ctx.getChild(1);
		String typeType = headCtx.getStart().getText();
		Map<String, Integer> statistic = new HashMap<>();
		ExtendContext bodyCtx = ctx.getFirstInnerChildByType(JavaParser.RULE_body);
		// ExtendContext bodyDecCtx = bodyCtx.getFirstInnerChildByType(JavaParser.RULE_classBodyDeclaration);
		if (bodyCtx == null) {
			return null;
		}
		for (ParseTree child : bodyCtx.children) {
			if (child instanceof ExtendContext) {
				int count = ((ExtendContext) child).countCtxChildren();
				statistic.compute(child.getClass().getSimpleName(), (k, v) -> v == null ? count : v + count);
			}
		}
		return new ContentContext(typeType, statistic);
	}

	private Feature extractFeature(ExtendContext decListCtx) {
		Feature feature = new Feature();
		for (ParseTree root : decListCtx.children) {
			if (root instanceof TerminalNode) {
				continue;
			}
			ExtendContext dec = (ExtendContext) root;
			int modifierListIndex = dec.indexOfFirstInnerChildByType(JavaParser.RULE_modifierList);

			if (modifierListIndex >= 0) {
				ExtendContext modifierListCtx = (ExtendContext) dec.children.get(modifierListIndex);
				boolean noModifier = true;
				for (ParseTree modifier : modifierListCtx.children) {
					if (!(modifier instanceof JavaParser.AnnotationContext)) {
						int type = ((TerminalNode) modifier).getSymbol().getType();
						feature.updateModifierStatistic(type);
						noModifier = false;
					}
				}
				if (noModifier) {
					feature.updateModifierStatistic(-1);
				}
			}
		}
		return feature;
	}

	private static int calculateEditDistance(List<?> list1, List<?> list2) {
		int n = list1.size();
		int m = list2.size();

		// 有一个字符串为空串
		if (n * m == 0) {
			return n + m;
		}

		// DP 数组
		int[][] D = new int[n + 1][m + 1];

		// 边界状态初始化
		for (int i = 0; i < n + 1; i++) {
			D[i][0] = i;
		}
		for (int j = 0; j < m + 1; j++) {
			D[0][j] = j;
		}

		// 计算所有 DP 值
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				int left = D[i - 1][j] + 1;
				int down = D[i][j - 1] + 1;
				int left_down = D[i - 1][j - 1];
				if (!list1.get(i - 1).equals(list2.get(j - 1))) {
					left_down += 1;
				}
				D[i][j] = Math.min(left, Math.min(down, left_down));
			}
		}
		return D[n][m];
	}

	private Info extractInfo(ExtendContext ctx) {
		Info info = new Info();
		for (int decIndex = 0; decIndex < ctx.getChildCount(); ++decIndex) {
			if (ctx.children.get(decIndex) instanceof TerminalNode) {
				continue;
			}
			Info.DeclarationInfo decInfo = new Info.DeclarationInfo();

			ExtendContext dec = (ExtendContext) ctx.children.get(decIndex);
			ExtendContext modifierListCtx = dec.getFirstInnerChildByType(JavaParser.RULE_modifierList);
			// Add modifiers.
			if (modifierListCtx != null) {
				// Delete JavaParser.AnnotationContext.
				List<ParseTree> modifiers = modifierListCtx.children
						.stream().
						filter(modifier -> !(modifier instanceof JavaParser.AnnotationContext)).toList();

				for (ParseTree t : modifiers) {
					if(t instanceof TerminalNode ter) {
						decInfo.modifiers.add(ter.getSymbol().getType());
					}
				}
			}

			// Add identifier.
			decInfo.identifier = getIdentifierText(dec);
			info.add(decInfo);
		}
		return info;
	}


	/*
	 * @description:
	 * @param ctx:An instance of FieldDeclarationListContext, ConstructorDeclarationListContext,
	 *  MethodDeclarationListContext, TypeDeclarationListContext.
	 * @param identifierTextList: Each element is the first identifier text of each single declaration.
	 * @return org.example.style.StructureStyle.Order:
	 */
	private Order extractOrder(ExtendContext ctx) {

		Order order = new Order();

		Info info = extractInfo(ctx);
		extractModifierOrder(info, order);
		extractAlphabeticOrder(info, order);

		return order;
	}

	private void extractAlphabeticOrder(Info info, Order order) {
		// Extract lexicographical order from @identifierText.
		if (order.isInModifierOrder()) {
			List<List<Integer>> modifierOrderPerLayer = order.getModifierOrder();
			// Find the modifier layer that has the most diverse modifiers.
			List<Integer> targetModifierOrder = new ArrayList<>();
			int layer = 0;
			for (int i = 0; i < modifierOrderPerLayer.size(); i++) {
				List<Integer> modifierOrder = modifierOrderPerLayer.get(i);
				if(modifierOrder.size() > targetModifierOrder.size()) {
					targetModifierOrder = modifierOrder;
					layer = i;
				}
			}

			boolean inAlphabeticOrder = true;
			for(int modifier : targetModifierOrder) {
				List<String> identifiers = info.getIdentifiers(modifier, layer);
				if (identifiers.isEmpty()) {
					continue;
				}
				int editDistance = calculateEditDistance(identifiers, identifiers.stream().sorted().toList());
				if(!order.inOrder((double) editDistance / identifiers.size())) {
					inAlphabeticOrder = false;
					break;
				}
			}
			if (inAlphabeticOrder) {
				order.setLogicalOrder(EnumType.MODIFIER_LEXI_ORDER);
			}
		} else {
			List<String> identifiers = info.getIdentifiers();
			List<String> sortedIdentifiers = identifiers.stream().sorted().toList();
			int editDistance = calculateEditDistance(identifiers, sortedIdentifiers);
			if (order.inOrder((double) editDistance / identifiers.size())) {
				order.setLogicalOrder(EnumType.LEXI_ORDER);
			}
		}
	}

	private void extractModifierOrder(Info info, Order order) {
		for (int i = 0; i < info.maxModifierLayer; i++) {
			List<Integer> curModifierList = info.getModifierLayer(i);
			Map<Integer, Integer> modifierMap = info.getModifierMap(i);
			PermutationGenerator<Integer> permutationGenerator = new PermutationGenerator<>(modifierMap.keySet());
			int minEditDistance = Integer.MAX_VALUE;
			List<Integer> targetModifierOrder = null;

			// Calculate edit distance.
			while(permutationGenerator.hasNext()) {
				List<Integer> modifierOrder = permutationGenerator.next();
				List<Integer> targetModifierList = new ArrayList<>();
				for (int modifier : modifierOrder) {
					targetModifierList.addAll(Collections.nCopies(modifierMap.get(modifier), modifier));
				}
				int editDistance = calculateEditDistance(curModifierList, targetModifierList);
				if (editDistance < minEditDistance) {
					minEditDistance = editDistance;
					targetModifierOrder = modifierOrder;
				}
			}

			if (targetModifierOrder != null && order.inOrder((double) minEditDistance / curModifierList.size())) {
				order.addModifierOrder(targetModifierOrder);
			} else {
				break;
			}

			// Resort declaration infos according to the modifier order.
			info.resort(targetModifierOrder, i);
		}
		if (order.isInModifierOrder()) {
			order.setLogicalOrder(EnumType.MODIFIER_ORDER);
		}
	}

	private void arrangeChildren(ExtendContext ctx, Area.ContentArea area) {

		Order order = area.getOrder();
		EnumType logicalOrder = order.getLogicalOrder();
		if (logicalOrder.equals(EnumType.UNKNOWN)) {
			return;
		}

		// Fill @declarations.
		List<Declaration> declarations = new ArrayList<>();
		for (int i = 0; i < ctx.getChildCount(); ++i) {
			if (ctx.getChild(i) instanceof TerminalNode) {
				continue;
			}
			ExtendContext decCtx = (ExtendContext) ctx.getChild(i);
			ExtendContext modifierListCtx = (ExtendContext) decCtx.getChild(decCtx.indexOfFirstInnerChildByType(JavaParser.RULE_modifierList));
			String identifierText = getIdentifierText(decCtx);
			List<Integer> modifiers = new ArrayList<>();
			for (ParseTree modifier : modifierListCtx.children) {
				if (!(modifier instanceof JavaParser.AnnotationContext)) {
					modifiers.add(((TerminalNode) modifier).getSymbol().getType());
				}
			}
			if (modifiers.isEmpty()) {
				modifiers.add(-1);
			}
			declarations.add(new Declaration(modifiers, identifierText, i));
		}

		// Get the new position of the children of the list context.
		if (logicalOrder.equals(EnumType.LEXI_ORDER)) {
			declarations.sort(Comparator.comparing(Declaration::getIdentifierText));
		} else if (logicalOrder.equals(EnumType.MODIFIER_ORDER)) {
			arrangeByModifier(declarations, order.getModifierOrder());
		} else if (logicalOrder.equals(EnumType.MODIFIER_LEXI_ORDER)) {
			List<Helper.Pair<Integer, Integer>> declarationGroups = arrangeByModifier(declarations, order.getModifierOrder());
			;
			for (Helper.Pair<Integer, Integer> group : declarationGroups) {
				declarations.subList(group.first, group.second).sort(Comparator.comparing(Declaration::getIdentifierText));
			}
		}

		// Update the order of children of the list context.
		List<ParseTree> newChildren = new ArrayList<>();
		for (Declaration declaration : declarations) {
			newChildren.add(ctx.getChild(declaration.getOriginalIndex()));
		}
		ctx.children = newChildren;
		ctx.updateStartToken();
		ctx.updateStopToken();
	}

	@Override
	protected Set<Integer> getRelevantRules() {
		return relevantRules;
	}

	/*
	 * @param ctx: An instance of FieldDeclarationContext, ConstructorDeclarationContext,
	 * MethodDeclarationContext, TypeDeclarationContext, InitializerContext
	 */
	protected String getIdentifierText(ExtendContext ctx) {
		if (ctx instanceof JavaParser.InitializerContext) {
			return "";
		}
		ExtendContext idCtx = null;
		if (ctx instanceof JavaParser.FieldDeclarationContext) {
			idCtx = ctx.getContextRecIf(context -> context instanceof JavaParser.IdentifierContext);
		} else {
			idCtx = ((ExtendContext) ctx.getChild(1)).getFirstInnerChildByType(JavaParser.RULE_identifier);
		}
		if (idCtx != null) {
			return idCtx.getText();
		}
		return "";
	}

	private List<Helper.Pair<Integer, Integer>> arrangeByModifier(List<Declaration> declarations, List<List<Integer>> modifierOrder) {
		List<Helper.Pair<Integer, Integer>> declarationGroupRanges = new ArrayList<>();
		List<List<Declaration>> declarationGroups = new ArrayList<>();
		declarationGroups.add(declarations);
		for (int layer = 0; layer < modifierOrder.size(); ++layer) {
			List<Integer> modifierOrderLayer = modifierOrder.get(layer);
			List<List<Declaration>> tmp = new ArrayList<>();
			// pair: (modifier, a list of declarations)
			// Use List to ensure the order of modifiers is consistent with the order of insertion.
			List<Helper.Pair<Integer, List<Declaration>>> groupHelper = new ArrayList<>();
			for (Integer modifier : modifierOrderLayer) {
				groupHelper.add(new Helper.Pair<>(modifier, new ArrayList<>()));
			}
			groupHelper.add(new Helper.Pair<>(-1, new ArrayList<>()));

			for (List<Declaration> declarations1 : declarationGroups) {
				for (Declaration declaration : declarations1) {
					int groupIndex = -1;
					for (int i = 0; i < modifierOrderLayer.size(); ++i) {
						if (declaration.modifiers.contains(modifierOrderLayer.get(i))) {
							groupIndex = i;
							break;
						}
					}
					if (groupIndex == -1) {
						groupIndex = groupHelper.size() - 1;
					}
					groupHelper.get(groupIndex).second.add(declaration);
				}
				for (Helper.Pair<Integer, List<Declaration>> pair : groupHelper) {
					List<Declaration> decGroup = pair.second;
					if (!decGroup.isEmpty()) {
						tmp.add(decGroup);
						pair.second = new ArrayList<>();
					}
				}
			}
			declarationGroups = tmp;
		}

		int start = 0;
		for (List<Declaration> decGroup : declarationGroups) {
			int end = start + decGroup.size();
			declarationGroupRanges.add(new Helper.Pair<>(start, end));
			for (int i = start; i < end; ++i) {
				declarations.set(i, decGroup.get(i - start));
			}
			start = end;
		}

		return declarationGroupRanges;
	}

	// range: [start, end)
	private boolean inOrder(List<String> identifierText, int start, int end, double allowedDeviation) {
		int opTimes = 0;
		List<String> sortedList = new ArrayList<>(identifierText);
		sortedList.sort(Comparator.naturalOrder());


		Map<String, Integer> newPositions = new HashMap<>();
		int index = 0;
		for (String text : sortedList) {
			newPositions.put(text, index++);
		}

		int len = sortedList.size();

		int dis = calculateEditDistance(identifierText, sortedList);
		return dis / (double) len < allowedDeviation;
	}

	private static class Declaration {
		List<Integer> modifiers;
		String identifierText;
		int originalIndex;

		public Declaration(List<Integer> modifiers, String identifierText, int originalIndex) {
			this.modifiers = modifiers;
			this.identifierText = identifierText;
			this.originalIndex = originalIndex;
		}

		public String getIdentifierText() {
			return identifierText;
		}

		public int getOriginalIndex() {
			return originalIndex;
		}

		public int getModifier(int i) {
			if (i < modifiers.size())
				return modifiers.get(i);
			else
				return -1;
		}
	}

	private Area.ContentArea createArea(ExtendContext ctx) {
		int rule = ctx.getRuleIndex();
		switch (rule) {
			case JavaParser.RULE_fieldDeclarationList:
				return new Area.FieldDecArea(rule);
			case JavaParser.RULE_methodDeclarationList:
				return new Area.MethodDecArea(rule);
			case JavaParser.RULE_constructorDeclarationList:
				return new Area.ConstructorDecArea(rule);
			case JavaParser.RULE_initializerList:
				return new Area.InitializerArea(rule);
			case JavaParser.RULE_typeDeclarationList:
				return new Area.TypeDecArea(rule);
		}
		return null;
	}


	private int getFirstListCtxIndex(ExtendContext ctx) {
		return ctx.findFirstChild(
				root -> root instanceof JavaParser.MethodDeclarationListContext ||
						root instanceof JavaParser.FieldDeclarationListContext ||
						root instanceof JavaParser.ConstructorDeclarationListContext ||
						root instanceof JavaParser.TypeDeclarationListContext ||
						root instanceof JavaParser.InitializerListContext);
	}

	private boolean isList(int rule) {
		Set<Integer> listCtxs = new HashSet<>(Arrays.asList(
				JavaParser.RULE_fieldDeclarationList, JavaParser.RULE_constructorDeclarationList,
				JavaParser.RULE_methodDeclarationList, JavaParser.RULE_typeDeclarationList,
				JavaParser.RULE_initializerList
		));
		return listCtxs.contains(rule);
	}

	static class Info {
		int maxModifierLayer = 0;
		List<Map<Integer, Integer>> modifierMapPerLayer = null;
		List<DeclarationInfo> declarations = new ArrayList<>();

		public void add(DeclarationInfo decInfo) {
			declarations.add(decInfo);
			if(decInfo.modifiers.size() > maxModifierLayer) {
				maxModifierLayer = decInfo.modifiers.size();
				for(DeclarationInfo dec : declarations) {
					if(dec.modifiers.size() < maxModifierLayer) {
						dec.modifiers.addAll(Collections.nCopies(maxModifierLayer - dec.modifiers.size(), -1));
					}
				}
			} else if(decInfo.modifiers.size() < maxModifierLayer) {
				decInfo.modifiers.addAll(Collections.nCopies(maxModifierLayer - decInfo.modifiers.size(), -1));
			}
		}

		public Map<Integer, Integer> getModifierMap(int layer) {
			if (modifierMapPerLayer == null) {
				fillModifierMap();
			}
			return modifierMapPerLayer.get(layer);
		}

		public List<String> getIdentifiers() {
			List<String> identifiers = new ArrayList<>();
			for(DeclarationInfo declarationInfo : declarations) {
				identifiers.add(declarationInfo.identifier);
			}
			return identifiers;
		}

		public List<String> getIdentifiers(int modifier, int layer) {
			List<String> identifiers = new ArrayList<>();
			for (DeclarationInfo declarationInfo : declarations) {
				if (declarationInfo.modifiers.get(layer) == modifier) {
					identifiers.add(declarationInfo.identifier);
				}
			}
			return identifiers;
		}


		public List<Integer> getModifierLayer(int i) {
			List<Integer> modifierLayer = new ArrayList<>();
			for(DeclarationInfo dec : declarations) {
				modifierLayer.add(dec.modifiers.get(i));
			}
			return modifierLayer;
		}

		private void fillModifierMap() {
			modifierMapPerLayer = new ArrayList<>();
			for (int i = 0; i < maxModifierLayer; i++) {
				modifierMapPerLayer.add(new HashMap<>());
			}
			for (DeclarationInfo decInfo : declarations) {
				for (int i = 0; i < maxModifierLayer; i++) {
					modifierMapPerLayer.get(i).compute(decInfo.modifiers.get(i), (k, v) -> v == null ? 1 : v + 1);
				}
			}
		}

		public void resort(List<Integer> targetModifierOrder, int layer) {
			List<DeclarationInfo> newDeclarations = new ArrayList<>();
			for (int modifier : targetModifierOrder) {
				List<DeclarationInfo> list = declarations.stream().filter(new Predicate<DeclarationInfo>() {
					@Override
					public boolean test(DeclarationInfo declarationInfo) {
						return declarationInfo.modifiers.get(layer) == modifier;
					}
				}).toList();
				newDeclarations.addAll(list);
			}
			declarations = newDeclarations;
		}

		static class DeclarationInfo {
			public void addModifier(int type) {
				modifiers.add(type);
			}

			List<Integer> modifiers = new ArrayList<>();
			String identifier = "";
		}
		/*
		 *  If there's a field list:
		 *   public static int a = 1;
		 *   public double b;
		 *   protected int c;
		 *   private static int d;
		 * Then we should have two modifier layer:
		 * The first modifier layer is a @ModifierLayer instance:
		 * {
		 *  modifiers: [public, protected, private]
		 *  indexPairsPerModifier: [[(0, 1)], [(2,2)], [(3,3)]]
		 *  pairsId: [[(1, 2)], [(2, 1)], [(3, 1)]]
		 * }
		 * The second modifier layer is a @ModifierLayer instance:
		 * {
		 *  modifiers: [static, empty]
		 *  indexPairsPerModifier: [[(0, 0), (3,3)], [(1,2)]]
		 *  pairsId: [[(1, 1), (3, 1)], [(2, 2)]]
		 * }
		 *
		 * */

	}

}
