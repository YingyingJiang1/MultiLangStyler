package org.example.styler.arrangement.classmember;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.style.Style;
import org.example.styler.Stage;
import org.example.styler.arrangement.classmember.style.*;
import org.example.utils.DistanceCalculator;
import org.example.utils.Helper;
import org.example.parser.common.context.ExtendContext;
import org.example.utils.PermutationGenerator;
import org.example.styler.Styler;


import java.util.*;
import java.util.function.Predicate;

/*
 * @author       Yingying Jiang
 * @create       2024/3/25 6:34
 */
public class ArrangementStyler extends Styler {

	private static Set<Integer> relevantRules = null;

	public ArrangementStyler() {
        style = new ArrangementStyle();
		executeWhenExit = false;
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
	@Override
	public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
		ArrangementContext context = extractContentContext(ctx, parser);
		ArrangementProperty property = (ArrangementProperty) style.getProperty(context);
		if (property == null) {
			return ctx;
		}

		List<ArrangementProperty.ContentArea> areas = property.getAreas();
		List<ExtendContext> newListCtxs = new ArrayList<>(Collections.nCopies(property.getAreas().size(), null));


		// Create a new list of declaration lists for the body of type declaration.
		ExtendContext bodyCtx = (ExtendContext) ctx
				.getFirstInnerChildByType(parser.getRuleBody());
		if (bodyCtx == null) {
			return ctx;
		}
		int from = -1, to =  -1;
		for (int i = 0; i < bodyCtx.getChildCount(); ++i) {
			ParseTree child = bodyCtx.getChild(i);
			if (child instanceof ExtendContext && parser.belongToMemberList(child)) {
				if(from == -1) {
					from = i;
				}
				to = i;
				ExtendContext listCtx = (ExtendContext) child;
				Feature feature = extractFeature(listCtx, parser);
				ArrangementProperty.ContentArea area = createArea(listCtx, parser);
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
					arrangeChildren(listCtx, areas.get(count), parser);
				}
			}
			++count;
		}

		if (from >= 0) {
			// Update the order of all declaration lists in the newly created list.
			bodyCtx.replaceChildren(from, to + 1, newListCtxs);
		}

		return ctx;
	}


	@Override
	public void extractStyle(ExtendContext ctx, MyParser parser) {
		ArrangementContext context = extractContentContext(ctx, parser);
		if (context != null && !style.contains(context)) {
			ExtendContext bodyCtx = (ExtendContext) ctx
					.getFirstInnerChildByType(parser.getRuleBody());
			if (bodyCtx == null) {
				return ;
			}

			ArrangementProperty property = new ArrangementProperty();
			List<ArrangementProperty.ContentArea> areas = property.getAreas();
			for (ParseTree child : bodyCtx.children) {
				if (child instanceof ExtendContext && parser.belongToMemberList(child)) {
					ExtendContext listCtx = (ExtendContext) child;
					ArrangementProperty.ContentArea area = createArea(listCtx, parser);
					area.fillArea(extractFeature(listCtx, parser), extractOrder(listCtx, parser));
					areas.add(area);
				}
			}
			style.addRule(context, property);
		}
	}

	/**
	 * @param ctx TypeDeclarationContext
	 * @return
	 */
	private ArrangementContext extractContentContext(ExtendContext ctx, MyParser parser) {
		ExtendContext headCtx = (ExtendContext) ctx.getChild(1);
		String typeType = headCtx.getStart().getText();
		Map<String, Integer> statistic = new HashMap<>();
		ExtendContext bodyCtx = ctx.getFirstInnerChildByType(parser.getRuleBody());
		if (bodyCtx == null) {
			return null;
		}
		for (ParseTree child : bodyCtx.children) {
			if (child instanceof ExtendContext childCtx) {
				int count = childCtx.countCtxChildren();
				statistic.compute(parser.getRuleName(childCtx.getRuleIndex()), (k, v) -> v == null ? count : v + count);
			}
		}
		return new ArrangementContext(typeType, statistic);
	}

	private Feature extractFeature(ExtendContext decListCtx, MyParser parser) {
		Feature feature = new Feature();
		for (ParseTree root : decListCtx.children) {
			if (root instanceof TerminalNode) {
				continue;
			}
			ExtendContext dec = (ExtendContext) root;
			int modifierListIndex = dec.indexOfFirstInnerChildByType(parser.getRuleModifierList());

			if (modifierListIndex >= 0) {
				ExtendContext modifierListCtx = (ExtendContext) dec.children.get(modifierListIndex);
				boolean noModifier = true;
				for (ParseTree modifier : modifierListCtx.children) {
					if (!(parser.isAnnotation(modifier))) {
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


	private Info extractInfo(ExtendContext ctx, MyParser parser) {
		Info info = new Info();
		for (int decIndex = 0; decIndex < ctx.getChildCount(); ++decIndex) {
			if (ctx.children.get(decIndex) instanceof TerminalNode) {
				continue;
			}
			Info.DeclarationInfo decInfo = new Info.DeclarationInfo();

			ExtendContext dec = (ExtendContext) ctx.children.get(decIndex);
			ExtendContext modifierListCtx = dec.getFirstInnerChildByType(parser.getRuleModifierList());
			// Add modifiers.
			if (modifierListCtx != null) {
				// Delete JavaParser.AnnotationContext.
				List<ParseTree> modifiers = modifierListCtx.children
						.stream().
						filter(modifier -> !(parser.isAnnotation(modifier))).toList();

				for (ParseTree t : modifiers) {
					if(t instanceof TerminalNode ter) {
						decInfo.modifiers.add(ter.getSymbol().getType());
					}
				}
			}

			// Add identifier.
			decInfo.identifier = getIdentifierText(dec, parser);
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
	private Order extractOrder(ExtendContext ctx, MyParser parser) {

		Order order = new Order();

		Info info = extractInfo(ctx, parser);
		extractModifierOrder(info, order);
		extractAlphabeticOrder(info, order);

		return order;
	}

	private void extractAlphabeticOrder(Info info, Order order) {
		// Extract lexicographical order from @identifierText.
		if (order.isInModifierOrder()) {
			List<List<Integer>> modifierOrderPercolumn = order.getModifierOrder();
			// Find the modifier column that has the most diverse modifiers.
			List<Integer> targetModifierOrder = new ArrayList<>();
			int column = 0;
			for (int i = 0; i < modifierOrderPercolumn.size(); i++) {
				List<Integer> modifierOrder = modifierOrderPercolumn.get(i);
				if(modifierOrder.size() > targetModifierOrder.size()) {
					targetModifierOrder = modifierOrder;
					column = i;
				}
			}

			boolean inAlphabeticOrder = true;
			for(int modifier : targetModifierOrder) {
				List<String> identifiers = info.getIdentifiers(modifier, column);
				if (identifiers.isEmpty()) {
					continue;
				}
				int editDistance = DistanceCalculator.calculateEditDistance(identifiers, identifiers.stream().sorted().toList());
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
			int editDistance = DistanceCalculator.calculateEditDistance(identifiers, sortedIdentifiers);
			if (order.inOrder((double) editDistance / identifiers.size())) {
				order.setLogicalOrder(EnumType.LEXI_ORDER);
			}
		}
	}

	private void extractModifierOrder(Info info, Order order) {
		for (int i = 0; i < info.maxModifiercolumn; i++) {
			List<Integer> curModifierList = info.getModifiercolumn(i);
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
				int editDistance = DistanceCalculator.calculateEditDistance(curModifierList, targetModifierList);
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

	private void arrangeChildren(ExtendContext ctx, ArrangementProperty.ContentArea area, MyParser parser) {

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
			ExtendContext modifierListCtx = (ExtendContext) decCtx.getChild(decCtx.indexOfFirstInnerChildByType(parser.getRuleModifierList()));
			String identifierText = getIdentifierText(decCtx, parser);
			List<Integer> modifiers = new ArrayList<>();
			for (ParseTree modifier : modifierListCtx.children) {
				if (!(parser.isAnnotation(modifier))) {
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
	public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
		return ctx.getRuleIndex() == parser.getRuleTypeDeclaration();
	}

	/*
	 * @param ctx: An instance of FieldDeclarationContext, ConstructorDeclarationContext,
	 * MethodDeclarationContext, TypeDeclarationContext, InitializerContext
	 */
	protected String getIdentifierText(ExtendContext ctx, MyParser parser) {
		if (parser.isInitializer(ctx)) {
			return "";
		}
		ExtendContext idCtx = null;
		if (parser.isFieldDeclaration(ctx)) {
			idCtx = ctx.getFirstContextRecIf(context -> parser.isIdentifier(context));
		} else {
			idCtx = ((ExtendContext) ctx.getChild(1)).getFirstInnerChildByType(parser.getRuleIdentifier());
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
		for (int column = 0; column < modifierOrder.size(); ++column) {
			List<Integer> modifierOrdercolumn = modifierOrder.get(column);
			List<List<Declaration>> tmp = new ArrayList<>();
			// pair: (modifier, a list of declarations)
			// Use List to ensure the order of modifiers is consistent with the order of insertion.
			List<Helper.Pair<Integer, List<Declaration>>> groupHelper = new ArrayList<>();
			for (Integer modifier : modifierOrdercolumn) {
				groupHelper.add(new Helper.Pair<>(modifier, new ArrayList<>()));
			}
			groupHelper.add(new Helper.Pair<>(-1, new ArrayList<>()));

			for (List<Declaration> declarations1 : declarationGroups) {
				for (Declaration declaration : declarations1) {
					int groupIndex = -1;
					for (int i = 0; i < modifierOrdercolumn.size(); ++i) {
						if (declaration.modifiers.contains(modifierOrdercolumn.get(i))) {
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

		int dis = DistanceCalculator.calculateEditDistance(identifierText, sortedList);
		return dis / (double) len < allowedDeviation;
	}

	@Override
	public Style getStyle() {
		return style;
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

	private ArrangementProperty.ContentArea createArea(ExtendContext ctx, MyParser parser) {
		int rule = ctx.getRuleIndex();
		if (parser.isFieldDeclarationList(ctx)) {
			return new ArrangementProperty.FieldDecArea(rule);
		} else if(parser.isMethodDeclarationList(ctx)) {
			return new ArrangementProperty.MethodDecArea(rule);
		} else if(parser.isConstructorDeclarationList(ctx)) {
			return new ArrangementProperty.ConstructorDecArea(rule);
		} else if(parser.isInitializerList(ctx)) {
			return new ArrangementProperty.InitializerArea(rule);
		} else if(parser.isTypeDeclarationList(ctx)) {
			return new ArrangementProperty.TypeDecArea(rule);
		}
		return null;
	}


	private int getFirstListCtxIndex(ExtendContext ctx, MyParser parser) {
		return ctx.indexOfFirstChild(
				root -> parser.isMethodDeclarationList(root) ||
						parser.isFieldDeclarationList(root) ||
						parser.isConstructorDeclarationList(root) ||
						parser.isTypeDeclarationList(root) ||
						parser.isInitializerList(root));
	}

	static class Info {
		int maxModifiercolumn = 0;
		List<Map<Integer, Integer>> modifierMapPercolumn = null;
		List<DeclarationInfo> declarations = new ArrayList<>();

		public void add(DeclarationInfo decInfo) {
			declarations.add(decInfo);
			if(decInfo.modifiers.size() > maxModifiercolumn) {
				maxModifiercolumn = decInfo.modifiers.size();
				for(DeclarationInfo dec : declarations) {
					if(dec.modifiers.size() < maxModifiercolumn) {
						dec.modifiers.addAll(Collections.nCopies(maxModifiercolumn - dec.modifiers.size(), -1));
					}
				}
			} else if(decInfo.modifiers.size() < maxModifiercolumn) {
				decInfo.modifiers.addAll(Collections.nCopies(maxModifiercolumn - decInfo.modifiers.size(), -1));
			}
		}

		public Map<Integer, Integer> getModifierMap(int column) {
			if (modifierMapPercolumn == null) {
				fillModifierMap();
			}
			return modifierMapPercolumn.get(column);
		}

		public List<String> getIdentifiers() {
			List<String> identifiers = new ArrayList<>();
			for(DeclarationInfo declarationInfo : declarations) {
				identifiers.add(declarationInfo.identifier);
			}
			return identifiers;
		}

		public List<String> getIdentifiers(int modifier, int column) {
			List<String> identifiers = new ArrayList<>();
			for (DeclarationInfo declarationInfo : declarations) {
				if (declarationInfo.modifiers.get(column) == modifier) {
					identifiers.add(declarationInfo.identifier);
				}
			}
			return identifiers;
		}


		public List<Integer> getModifiercolumn(int i) {
			List<Integer> modifiercolumn = new ArrayList<>();
			for(DeclarationInfo dec : declarations) {
				modifiercolumn.add(dec.modifiers.get(i));
			}
			return modifiercolumn;
		}

		private void fillModifierMap() {
			modifierMapPercolumn = new ArrayList<>();
			for (int i = 0; i < maxModifiercolumn; i++) {
				modifierMapPercolumn.add(new HashMap<>());
			}
			for (DeclarationInfo decInfo : declarations) {
				for (int i = 0; i < maxModifiercolumn; i++) {
					modifierMapPercolumn.get(i).compute(decInfo.modifiers.get(i), (k, v) -> v == null ? 1 : v + 1);
				}
			}
		}

		public void resort(List<Integer> targetModifierOrder, int column) {
			List<DeclarationInfo> newDeclarations = new ArrayList<>();
			for (int modifier : targetModifierOrder) {
				List<DeclarationInfo> list = declarations.stream().filter(new Predicate<DeclarationInfo>() {
					@Override
					public boolean test(DeclarationInfo declarationInfo) {
						return declarationInfo.modifiers.get(column) == modifier;
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
		 * Then we should have two modifier column:
		 * The first modifier column is a @Modifiercolumn instance:
		 * {
		 *  modifiers: [public, protected, private]
		 *  indexPairsPerModifier: [[(0, 1)], [(2,2)], [(3,3)]]
		 *  pairsId: [[(1, 2)], [(2, 1)], [(3, 1)]]
		 * }
		 * The second modifier column is a @Modifiercolumn instance:
		 * {
		 *  modifiers: [static, empty]
		 *  indexPairsPerModifier: [[(0, 0), (3,3)], [(1,2)]]
		 *  pairsId: [[(1, 1), (3, 1)], [(2, 2)]]
		 * }
		 *
		 * */

	}

}
