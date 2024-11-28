package org.example.styler.structure;


import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.MyParser;
import org.example.parser.common.ParseTreeFactory;
import org.example.myException.CompilationException;
import org.example.parser.java.MyJavaParser;
import org.example.styler.structure.checker.Checker;
import org.example.styler.structure.handler.Handler;
import org.example.styler.structure.vtree.VirtualNode;
import org.example.styler.structure.vtree.PlaceholderContainer;
import org.example.styler.structure.vtree.Forest;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/2 23:40
 */
public class EquivalentStructure {

	int id;
	String category;
	int[] rules;
	// Each style of writing will be transformed into a forest.
	List<Forest> forests = new ArrayList<>();
	// Stores the corresponding virtual node for a placeholder with the same name.
	PlaceholderContainer placeholderContainer = null;
	Map<Integer, List<Integer>> bannedTransfer;
	// key: tree generated from the placeholder, value: The virtual node corresponding to the placeholder.
	Map<ParseTree, VirtualNode> vTreeMap = new HashMap<>();
	List<Checker> checkers = null;
	List<Handler> handlers = null;

	public EquivalentStructure(int id, String category, int[] rules, List<Checker> checkers,
	                           List<Handler> handlers, Map<Integer, List<Integer>> bannedTransfer) {
		this.category = category;
		this.id = id;
		this.rules = rules;
		this.checkers = checkers;
		this.handlers = handlers;
		this.bannedTransfer = bannedTransfer;
	}

	public void setHandlers(List<Handler> handlers) {
		this.handlers = handlers;
	}

	public void setCheckers(List<Checker> checkers) {
		this.checkers = checkers;
	}

	void compile(String[] codes, String[] placeholders) {
		try {
			placeholderContainer = new PlaceholderContainer(placeholders);
			int rule = rules[0];
			for (int i = 0; i < codes.length; i++) {
				boolean flag = codes[i].startsWith("$^");
				String code = replacePlaceholder(codes[i]);
				MyJavaParser parser = new MyJavaParser(code);
				if (i < rules.length) {
					rule = rules[i];
				}
				int priority = getPriority(code);
				forests.add(new Forest(parser.parse(rule, flag), priority));
				uniqueVNodes(placeholderContainer);
			}
		} catch (CompilationException e) {
			System.err.println("The equivalent structure with id:" + id + " has a compilation error:" + e.getMessage());
			System.err.println("Please ensure adjacent tokens in configured codes are seperated by space!");
		}
	}

	public int getPriority(int index) {
		return forests.get(index).getPriority();
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

	public VirtualNode getVNode(String placeholderName) {
		return placeholderContainer.getVNodeByPlaceholderName(placeholderName);
	}

	public int match(ParseTree t, MyParser parser) {
		// Virtual tree that has a greater priority is matched first.
		Map<Forest, Integer> vtMap = new TreeMap<>();
		for (int i = 0; i < forests.size(); i++) {
			Forest forest = forests.get(i);
			vtMap.put(forest, i);
		}

		ExtendContext tParent = (ExtendContext) t.getParent();
		int startIndex = tParent.children.indexOf(t);

		for (Map.Entry<Forest, Integer> entry : vtMap.entrySet()) {
			Forest forest = entry.getKey();
			int index = entry.getValue();
			cleanState();

			int vi = 0, ti = startIndex;
			for (; vi < forest.size() && ti < tParent.getChildCount(); ++vi,++ti) {
				ParseTree vt = forest.getTree(vi);
				ParseTree t1 = tParent.getChild(ti);
				if (t1 instanceof TerminalNode || vt instanceof TerminalNode) {
					break;
				}
				int rule1 = ((ExtendContext) t1).getRuleIndex();
				int rule2 = ((ExtendContext) vt).getRuleIndex();
				if (rule1 != rule2) {
					break;
				}
				if (!isMatched(vt, t1, forest, parser)) {
					break;
				}
			}
			if(vi == forest.size() && forest.isContextMatched(parser) && check(index))  {
				return index;
			}
		}
		cleanState();
		return -1;
	}

	private boolean check(int index) {
		if (checkers == null) {
			return true;
		}
		for (Checker checker : checkers) {
			if (!checker.check(this, index)) {
				return false;
			}
		}
		return true;
	}

	public ParseTree convert(int from, int to, ParseTree oldTree, MyParser parser) {
		if(bannedTransfer != null && bannedTransfer.get(from) != null && bannedTransfer.get(from).contains(to)) {
			return null;
		}
		if (handlers != null) {
			for (Handler handler : handlers) {
				handler.handle(this, from, to, parser);
			}
		}

		Forest forest = forests.get(to);
		int fromSize = forests.get(from).size();
		int toSize = forest.size();
		List<ParseTree> newTrees = new ArrayList<>(1);
		for(ParseTree t : forest.getTrees()) {
			// System.out.println(t.toStringTree(new JavaParser(null)));
			newTrees.add(createTree(t, forest));
		}

		// Update old trees to new trees.
		ExtendContext parent = (ExtendContext) oldTree.getParent();
		int startIndex = parent.children.indexOf(oldTree);
		parent.replaceChildren(startIndex, startIndex + fromSize, newTrees);
		cleanState();
		return newTrees.isEmpty() ? null : newTrees.get(0);
	}

	/**
	 * @apiNote Before calling this method, ensure there's a virtual tree matching with a real tree.
	 * @param t t doesn't have an associated virtual node and t is a ExtendContext instance.
	 * @return
	 */
	private ParseTree createTree(ParseTree t, Forest forest) {
		ExtendContext ctx = (ExtendContext) t;

		// Create children
		List<ParseTree> children = new ArrayList<>();
		for (ParseTree child : ctx.children) {
			children.addAll(forest.getMatchedRealTrees(child));
			VirtualNode vNode = vTreeMap.get(child);
			if (vNode != null) {
				children.addAll(vNode.matchedTrees);
			} else if(child instanceof TerminalNode) {
				children.add(ParseTreeFactory.getInstance().copyFrom(child, null, false));
			} else {
				children.add(createTree(child, forest));
			}
		}

		// Create parent
		ParseTree newTree = ParseTreeFactory.getInstance().copyFrom(t, children, false);

		// ParseTreeFactory.getInstance().replaceTree(t.getParent(), newTree, t);
		return newTree;
	}

	private void cleanState() {
		for(VirtualNode vNode : vTreeMap.values()) {
			vNode.cleanState();
		}
		for(Forest vt : forests) {
			vt.cleanContextState();
		}
	}

	private boolean ruleMatches(ExtendContext ctx1, ExtendContext ctx2) {
		return ctx1.getRuleIndex() == ctx2.getRuleIndex();
	}

	/**
	 * @apiNote Both vt and t are common tree nodes, in other words, they are not associated with a virtual node.
	 * @param vt
	 * @param t
	 * @return
	 */
	private boolean isMatched(ParseTree vt, ParseTree t, Forest forest, MyParser parser) {
		if (vt instanceof TerminalNode && t instanceof TerminalNode) {
			return vt.getText().equals(t.getText());
		}
		if (vt instanceof ExtendContext && t instanceof ExtendContext) {
			ExtendContext vtCtx = (ExtendContext) vt;
			ExtendContext ctx = (ExtendContext) t;
			// Match root.
			if(!ruleMatches(vtCtx, ctx)) {
				return false;
			}

			// Match children
			int vi = 0, i = 0;
			while (vi < vt.getChildCount() && i < t.getChildCount()) {
				ParseTree vtChild = vt.getChild(vi), tChild = t.getChild(i);
				VirtualNode virtualNode = vTreeMap.get(vtChild);
				boolean matched = false;

				// Different match strategies for virtual node and non-virtual node.
				if (virtualNode != null) {
					matched = virtualNode.matches(tChild, parser);
					if (matched) {
						virtualNode.addMatchedTree(tChild);
					}
				} else {
					matched = isMatched(vtChild, tChild, forest, parser);
				}

				if (matched) {
					++vi;
					++i;
				} else {
					if(!forest.addMatchedRealTree(vtChild, tChild)) {
						return false;
					}
					++i;
				}
			}
			return vi == vt.getChildCount() && i == t.getChildCount();
		}
		return false;
	}


	/**
	 * @apiNote After the method is called, parent filed of ParseTree is invalid.
	 */
	private void uniqueVNodes(PlaceholderContainer placeholderContainer) {
		for (Forest forest : forests) {
			for(ParseTree t : forest.getTrees()) {
				doUnique(t, forest);
			}
		}
	}

	// param t is a real tree.
	private void doUnique(ParseTree parent, Forest forest) {
		if (!(parent instanceof ExtendContext)) {
			return;
		}
		List<ParseTree> children = ((ExtendContext) parent).children;
		for (int i = 0; i < children.size(); i++) {
			ParseTree child = children.get(i);
			VirtualNode vNode = placeholderContainer.getVNodeByText(child.getText());
			if (vNode != null) {
				if(!vNode.repetition.isEmpty()) { // Handle the virtual node whose placeholder name is end up with '*','+' or '?'.
					checkRepeatableVNode(children, i);
					children.remove(i);
					ParseTree next = children.get(i);
					forest.addVNodeMap(next, vNode);
					--i;
				} else {
					if (vNode.isEmpty()) {
						vTreeMap.put(child, vNode);
						vNode.t = child;
					} else {
						children.set(i, vNode.t);
					}
				}
			} else {
				doUnique(child, forest);
			}
		}
	}

	private void checkRepeatableVNode (List<ParseTree> children, int i) {
		if (i == children.size() - 1) {
			throw new CompilationException("wrong structure: placeholder name ending with '*','+' or '?' can't occur at the end.");
		}
		ParseTree next = children.get(i + 1);
		VirtualNode vNode = placeholderContainer.getVNodeByText(next.getText());
		if(vNode != null && !vNode.repetition.isEmpty()) {
			throw new CompilationException("wrong structure: placeholder name ending with '*','+' or '?' can't occur continuously.");
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

}
