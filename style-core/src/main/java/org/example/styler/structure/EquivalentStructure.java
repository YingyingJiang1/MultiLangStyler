package org.example.styler.structure;


import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
import org.dom4j.Element;
import org.example.myException.TreeConvertException;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.ExtendTokenFactory;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.common.token.ExtendToken;
import org.example.styler.structure.handler.ExceptionHandler;
import org.example.styler.structure.vtree.VirtualNodeMatcher;
import org.example.utils.ParseTreeUtil;
import org.example.myException.CompilationException;
import org.example.parser.java.MyJavaParser;
import org.example.styler.structure.checker.Checker;
import org.example.styler.structure.handler.Handler;
import org.example.styler.structure.vtree.VirtualNode;
import org.example.styler.structure.vtree.PlaceholderContainer;
import org.example.styler.structure.vtree.Forest;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.w3c.dom.*;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/2 23:40
 */
public class EquivalentStructure {
	public static Logger logger = LoggerFactory.getLogger(EquivalentStructure.class);

	int id;
	String category;
	// Each style of writing will be transformed into a forest.
	List<Forest> forests = new ArrayList<>();
	// Stores the corresponding virtual node for a placeholder with the same name.
	PlaceholderContainer placeholderContainer = null;
	Map<Integer, List<Integer>> bannedTransfer;
	// key: tree generated from the placeholder, value: The virtual node corresponding to the placeholder.
	Map<ParseTree, VirtualNode> vTreeMap = new HashMap<>();
	List<Checker> checkers = null;
	List<Handler> handlers = null;
	Set<Integer> rules = new HashSet<>();

	public EquivalentStructure(int id, String category,List<Checker> checkers,
	                           List<Handler> handlers, Map<Integer, List<Integer>> bannedTransfer) {
		this.category = category;
		this.id = id;
		this.checkers = checkers;
		this.handlers = handlers;
		this.bannedTransfer = bannedTransfer;
	}

	public static EquivalentStructure create(Element node, Class<? extends MyParser> parserClass) {
		XmlRuleParser.Rule rule =  XmlRuleParser.parseRule(node);
		if (rule == null) {
			return null;
		}
		EquivalentStructure structure = new EquivalentStructure(Integer.parseInt(rule.id), rule.category, rule.checkers, rule.handlers, rule.bannedTransfer);
		structure.compile(rule);

		return structure;
	}

	public void setHandlers(List<Handler> handlers) {
		this.handlers = handlers;
	}

	public void setCheckers(List<Checker> checkers) {
		this.checkers = checkers;
	}

	public int getIndexOf(String style) {
		if (style == null) {
			return -1;
		}
		for (int i = 0; i < forests.size(); i++) {
			if (Objects.equals(forests.get(i).getStyle(), style)) {
				return i;
			}
		}
		return -1;
	}

	public String getStyleOf(int index) {
		return forests.get(index).getStyle();
	}

	void compile(XmlRuleParser.Rule xmlRule) {
		String[] codes = xmlRule.codes.toArray(new String[0]);
		try {
			placeholderContainer = PlaceholderContainer.createInstance(codes);
			for (int i = 0; i < codes.length; i++) {
				boolean multiStmts = codes[i].startsWith("$^");
				String code = replacePlaceholder(codes[i]);
				MyJavaParser parser = new MyJavaParser();

				int priority = getPriority(code);
				ParseTree tree = parser.parseFromString(code);
				if (tree == null) {
					throw new CompilationException("The equivalent structure with id:" + id + " has a compilation error. " +
							"Please ensure adjacent tokens in configured codes are seperated by space!");
				}
				List<ParseTree> trees = new ArrayList<>();
				if (multiStmts) {
					if (tree instanceof ExtendContext ctx) {
						ExtendContext blockCtx = (ExtendContext) ctx.children.get(0);
						trees.addAll(blockCtx.children.subList(1, blockCtx.children.size() - 1));
					}
				} else {
					trees.add(tree);
				}

				for (ParseTree t : trees) {
					if (t instanceof ExtendContext ctx) {
						int ruleIndex = ctx.getRuleIndex();
						if (ctx.getRuleIndex() == parser.getRuleStmt()) {
							ruleIndex = parser.getSpecificStmtType(ctx);
						}
						rules.add(ruleIndex);
					}
				}

				// 优化format
//				if (parser.getTokenStream() instanceof CommonTokenStream ts) {
//					ts.getTokens().forEach(t -> {
//						if (t.getType() == parser.getSemi() || t.getType() == parser.getRBrace() || t.getType() == parser.getLBrace()) {
//							((ExtendToken) t).addTokenAfter(parser.getTokenFactory().create(parser.getVws(), "\n"), parser);
//						}
//					});
//				}

				forests.add(new Forest(trees, priority, xmlRule.styles.get(i)));
				uniqueVNodes(placeholderContainer, parser);
			}
		} catch (CompilationException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public int getPriority(int index) {
		return forests.get(index).getPriority();
	}

	public Set<Integer> rulesContained() {
		return rules;
	}

	// get priority for the code.
	private int getPriority(String code) {
		String[] strs = code.split(" ");
		int priority = strs.length;
		for(String str : strs) {
			if(str.isEmpty() || str.matches("\\$.\\d*[+*?]")){
				priority -= 1;
			}
		}
		return priority;
	}


	public Integer getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

    public List<Forest> getForests() {
        return forests;
    }
	public VirtualNode getVNode(String placeholderName) {
		return placeholderContainer.getVNodeByPlaceholderName(placeholderName);
	}

	public List<VirtualNode> getAllVNodes() {
		return new ArrayList<>(vTreeMap.values());
	}

	public synchronized int match(ParseTree t, MyParser parser) {
		// Virtual tree that has a greater priority is matched first.
		Map<Forest, Integer> vtMap = new TreeMap<>();
		for (int i = 0; i < forests.size(); i++) {
			Forest forest = forests.get(i);
			vtMap.put(forest, i);
		}

		// Considering the case where codes of equivalent structure are configured with "$^"
		int startIndex = 0;
		List<ParseTree> realTrees = null;
		if (t.getParent() != null) {
			ExtendContext tParent = (ExtendContext) t.getParent();
			startIndex = tParent.children.indexOf(t);
			realTrees = tParent.children;
		} else {
			realTrees = List.of(t);
		}

		// Try to match structure.
		for (Map.Entry<Forest, Integer> entry : vtMap.entrySet()) {
			Forest forest = entry.getKey();
			int index = entry.getValue();
			cleanState();

			int vi = 0, ti = startIndex;
			for (; vi < forest.size() && ti < realTrees.size(); ++ti) {
				ParseTree vt = forest.getTree(vi);
				ParseTree t1 = realTrees.get(ti);
				if (t1 instanceof TerminalNode || vt instanceof TerminalNode) {
					break;
				}
				int rule1 = ((ExtendContext) t1).getRuleIndex();
				int rule2 = ((ExtendContext) vt).getRuleIndex();
				if (rule1 != rule2) {
					break;
				}
//				TreePrinter.printTree(t1, parser);
//				TreePrinter.printTree(vt, parser);
				if (!isMatched(vt, t1, forest, parser)) {
					break;
				}

				VirtualNode virtualNode = vTreeMap.get(vt);
				if (virtualNode != null) {
					vi += virtualNode.moveStep();
				} else {
					++vi;
				}
			}

			// Check context of code
			boolean isLastNodeRepeatable = vi == forest.size() - 1 && vTreeMap.get(forest.getTree(vi)) != null && vTreeMap.get(forest.getTree(vi)).moveStep() == 0;
			boolean isASTMatched = vi == forest.size() || isLastNodeRepeatable;
			if(isASTMatched && isContextMatched(forest.getvNodes(), parser) && check(index, parser))  {
				return index;
			}
		}
		cleanState();
		return -1;
	}


	private boolean isContextMatched(List<VirtualNode> vNodes, MyParser parser) {
		for (VirtualNode vNode :vNodes) {
			if (!vNode.checkState(parser)) {
				return false;
			}
		}
		return true;
	}

	private boolean check(int index, MyParser parser) {
		if (checkers == null) {
			return true;
		}
		for (Checker checker : checkers) {
			if (!checker.check(this, index, parser)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Note: call `cleanState()` before exiting this method.
	 * @param from
	 * @param to
	 * @param oldTree
	 * @param parser
	 * @return
	 */
	public ParseTree convert(int from, int to, ParseTree oldTree, MyParser parser) {
		if(bannedTransfer != null && bannedTransfer.get(from) != null && bannedTransfer.get(from).contains(to)) {
			return null;
		}

		if (handlers != null) {
			try {
				handlers.stream().filter(h -> h instanceof ExceptionHandler).forEach(handler -> {
					((ExceptionHandler) handler).handleException(this, from, to, parser);
				});
			} catch (TreeConvertException e) {
				cleanState();
				return oldTree; // Exception caught, don't do any convert.
			}

			for (Handler handler : handlers) {
				if (! (handler instanceof ExceptionHandler)) {
					handler.handle(this, from, to, parser);
				}
			}
		}

		Forest toforest = forests.get(to);
		int fromSize = forests.get(from).getRealForestSize(); // size of matched real trees(real trees are subtrees of input codes).
		List<ParseTree> newTrees = new ArrayList<>();
		for(ParseTree t : toforest.getTrees()) {
			newTrees.addAll(createTree(t));
		}

		// Update old trees to new trees.
		if (oldTree.getParent() != null) {
			ExtendContext parent = (ExtendContext) oldTree.getParent();
			int startIndex = parent.children.indexOf(oldTree);
			parent.replaceChildren(startIndex, startIndex + fromSize, newTrees);
		}
		cleanState();
		return newTrees.isEmpty() ? null : newTrees.get(0);
	}

	/**
	 * @implNote For virtual node, use the real tree it matched. For real node, do deep copy.
	 * @apiNote Before calling this method, ensure there's a virtual tree matching with a real tree.
	 * @return
	 */
	private List<ParseTree> createTree(ParseTree t) {
		// Check whether root of `t` is a virtual node.
		VirtualNode vNode = vTreeMap.get(t);
		if (vNode != null) {
			return vNode.matchedTrees;
		}


		// Create root
		ParseTree root = ParseTreeUtil.getInstance().copyNode(t);

		// Create children
		if (t instanceof ExtendContext ctx) {
			List<ParseTree> children = new ArrayList<>();
			for (ParseTree child : ctx.children) {
				vNode = vTreeMap.get(child);
				if (vNode != null) {
					children.addAll(vNode.matchedTrees);
				} else if(child instanceof TerminalNode) {
					children.add(ParseTreeUtil.getInstance().copyTree(child, false));
				} else {
					children.addAll(createTree(child));
				}
			}

			if (root instanceof ExtendContext rootCtx) {
				rootCtx.children.clear();
				rootCtx.addChildren(children);
			}
		}

		return List.of(root);
	}

	private void cleanState() {
		for(VirtualNode vNode : vTreeMap.values()) {
			vNode.cleanState();
		}
	}

	private boolean ruleMatches(ExtendContext ctx1, ExtendContext ctx2) {
		return ctx1.getRuleIndex() == ctx2.getRuleIndex();
	}

	/**
	 * todo: replace this implementation with state machine.
	 * @param vt
	 * @param t
	 * @return
	 */
	private boolean isMatched(ParseTree vt, ParseTree t, Forest forest, MyParser parser) {
		if (vt instanceof TerminalNode && t instanceof TerminalNode) {
			return vt.getText().equals(t.getText());
		}
		if (vt instanceof ExtendContext vtCtx && t instanceof ExtendContext ctx) {
			// Match root.
			boolean matchResult = ruleMatches(vtCtx, ctx);
			VirtualNode virtualNode = vTreeMap.get(vt);
			if (virtualNode != null) {
				return virtualNode.matches(t, parser);
			}
			// A second try to match the root when real tree has a body without {}.
			if(!matchResult) {
				boolean isBraceOptionalCase = vtCtx.getRuleIndex() == parser.getRuleBlock()
						&& vtCtx.getAllChildContextsIf(parser::belongToStmt).size() == 1;
				// When brace is optional, remove the {} of virtual tree and try to match again.
				if (isBraceOptionalCase) {
					ExtendContext stmtCtx = (ExtendContext) vtCtx.getChild(1);
					return isMatched(stmtCtx, t.getParent(), forest, parser);
				}
				return false;
			}



			// Match children
			int vi = 0, i = 0;
			int state = 0;
			while (vi < vt.getChildCount() && i < t.getChildCount()) {
				ParseTree vtChild = vt.getChild(vi), tChild = t.getChild(i);
				virtualNode = vTreeMap.get(vtChild);
				boolean matched = false;

				// Different match strategies for virtual node and non-virtual node.
				if (virtualNode != null) {
					matched = virtualNode.matches(tChild, parser);
				} else {
					matched = isMatched(vtChild, tChild, forest, parser);
				}

				if (matched) {
					if (virtualNode != null) {
						vi += virtualNode.moveStep();
					} else {
						++vi;
					}
					++i;
				} else {
					if (virtualNode != null && virtualNode.moveStep() == 0) {
						// case: current virtual node can be matched repeatedly.
						vi++; // Use next child of vt as the matching node.
						matched = isMatched(vt.getChild(vi), tChild, forest, parser);
						if (matched) {
							vi++;
							i++;
						}

						if (!matched && virtualNode.isRollback()) {
							ParseTree matchedTree = virtualNode.removeLastMatchedTree();
							if (matchedTree != null) {
								matched = isMatched(vt.getChild(vi), matchedTree, forest, parser);
								if (matched) {
									vi++;
								}
							}
						}
					} else {
						// case: left sibling of vtChild can be matched repeatedly.
						if (vi - 1 >= 0) {
							ParseTree preVtChild = vt.getChild(vi - 1);
							VirtualNode preVNode = vTreeMap.get(preVtChild);
							if (preVNode != null && preVNode.isRollback()) {
								ParseTree matchedTree = preVNode.removeLastMatchedTree();
								if (matchedTree != null) {
									matched = isMatched(vtChild, matchedTree, forest, parser);
									if (matched) {
										if (virtualNode != null) {
											vi += virtualNode.moveStep();
										}
									}
								}
							}
						}
					}
				}

				if (!matched) {
					return false;
				}

			}
			return vi == vt.getChildCount() && i == t.getChildCount();
		}
		return false;
	}


	/**
	 * @apiNote After the method is called, parent filed of ParseTree is invalid.
	 */
	private void uniqueVNodes(PlaceholderContainer placeholderContainer, MyParser parser) {
		for (Forest forest : forests) {
			for(ParseTree t : forest.getTrees()) {
				doUnique(t, forest, parser);
			}
		}
	}

	// param t is a real tree.

	/**
	 * Associates a placeholder-generated tree in the tree to a specific virtual node.
	 *
	 */
	private void doUnique(ParseTree node, Forest forest, MyParser parser) {
		if (!(node instanceof ExtendContext)) {
			return;
		}
		VirtualNode vNode = placeholderContainer.getVNode(node, parser);
		if (vNode != null && VirtualNodeMatcher.getInstance(parser).isMatched(vNode.type, node, parser)) {
			if (vNode.isEmpty()) {
				vTreeMap.put(node, vNode);
				vNode.tree = node;
			} else {
				// ?? 这是干啥的
				if (node.getParent() != null) {
					((ExtendContext) node.getParent()).replaceChild(node, vNode.tree);
				}
			}
			forest.addVNode(vNode);
			return;
		}

		for (ParseTree child : ((ExtendContext) node).children) {
			doUnique(child, forest, parser);
		}
	}

	private String replacePlaceholder(String code) {
		// Placeholder name with a longer prefix should be replaced first.
		List<String> placeholderNames = placeholderContainer.getPlaceholderNames().stream().sorted(Comparator.comparing(s -> -s.length())).toList();
		boolean flag = code.startsWith("$^");
		String[] strs = code.split(" ");
		StringBuilder retCode = new StringBuilder();
		for(String str : strs) {
			for(String placeholderName : placeholderNames) {
				str = str.replace(placeholderName, placeholderContainer.getValue(placeholderName));
			}
			retCode.append(str);
			retCode.append(" ");
		}
		if (flag) {
			return "{" + retCode.toString().replace("$^", "") + "}";
		}
		return retCode.toString();

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, category, rules, forests, placeholderContainer, bannedTransfer, vTreeMap, checkers, handlers);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EquivalentStructure structure) {
			return Objects.equals(id, structure.id) &&
					Objects.equals(category, structure.category) &&
					Objects.equals(rules, structure.rules) &&
					Objects.equals(forests, structure.forests) &&
					Objects.equals(placeholderContainer, structure.placeholderContainer) &&
					Objects.equals(bannedTransfer, structure.bannedTransfer) &&
					Objects.equals(vTreeMap, structure.vTreeMap) &&
					Objects.equals(checkers, structure.checkers) &&
					Objects.equals(handlers, structure.handlers);
		}
		return false;
	}

}



class XmlRuleParser {
	private static Logger logger = LoggerFactory.getLogger(XmlRuleParser.class);

	public static class Rule {
		public String id;
		public String name;
		public String category;
		public List<String> codes = new ArrayList<>();
		public List<String> styles = new ArrayList<>();
		public List<Checker> checkers = new ArrayList<>();
		public List<Handler> handlers = new ArrayList<>();
		Map<Integer, List<Integer>> bannedTransfer;
		public String comments;

		@Override
		public String toString() {
			return "Rule{id='" + id + "', name='" + name + "', category='" + category + "', codes=" + codes +
					 ", checkers=" + checkers + ", handlers=" + handlers +
					", comments='" + comments + "'}";
		}
	}


	public static Rule parseRule(Element node) {
		Rule rule = new Rule();

		if (!StructureStyler.TEST_MODE) {
			if (node.attribute("enable") != null && node.attributeValue("enable").equals("false")) {
				return null;
			}
		}


		rule.id = node.attributeValue("id");
		rule.name = node.attributeValue("name");
		rule.category = node.attribute("category") != null ? node.attributeValue("category") : "";
		if (rule.category.isEmpty()) {
			rule.category = null;
		}
		try {
			// Codes
			node.element("codes").elements().forEach(e -> {
				rule.codes.add(e.getText());
				if (e.attribute("style") != null) {
					rule.styles.add(e.attributeValue("style"));
				} else {
					rule.styles.add(null);
				}
			});

			rule.checkers = parseCheckers(node);
			rule.handlers = parseHandlers(node);
			rule.bannedTransfer = parseBannedTransfer(node);
		} catch (Exception e) {
			logger.error("Failed to parse rule: id={}", rule.id, e);
		}




		return rule;
	}

	private static List<Checker> parseCheckers(Element node) {
		List<Checker> checkers = new ArrayList<>();
		if (node.element("checkers") == null) {
			return checkers;
		}
		node.element("checkers").elements().forEach(e -> {
			List<String[]> argsList = new ArrayList<>();
			e.element("argsList").elements().forEach(args -> argsList.add(args.getText().split(",")));
			Checker checker = Checker.create(e.elementText("class"), argsList.toArray(new String[argsList.size()][]));
			checkers.add(checker);
		});
		return checkers;
	}

	private static List<Handler> parseHandlers(Element node) {
		List<Handler> handlers = new ArrayList<>();
		if (node.element("handlers") == null) {
			return handlers;
		}
		node.element("handlers").elements().forEach(e -> {
			List<String[]> argsList = new ArrayList<>();
			e.element("argsList").elements().forEach(args -> argsList.add(args.getText().split(",")));
			Handler handler = Handler.create(e.elementText("class"), argsList.toArray(new String[argsList.size()][]));
			handlers.add(handler);
		});
		return handlers;
	}

	private static Map<Integer, List<Integer>> parseBannedTransfer(Element node) {
		Map<Integer, List<Integer>> bannedTransferMap = new HashMap<>();

		Element transfers = node.element("transfers");
		if (transfers == null) {
			return bannedTransferMap;
		}

		transfers.elements().forEach(e -> {
			int from = Integer.parseInt(e.attributeValue("from"));
			int to = Integer.parseInt(e.attributeValue("to"));
			bannedTransferMap.computeIfAbsent(from, k -> new ArrayList<>());
			bannedTransferMap.get(from).add(to);
		});
		return bannedTransferMap;
	}
}


