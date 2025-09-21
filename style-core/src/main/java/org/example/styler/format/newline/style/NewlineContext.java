package org.example.styler.format.newline.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class NewlineContext extends StyleContext {
	// 节点类型序列（必须按顺序匹配）
	private List<NodeType> nodeTypes;
	private List<Double> lengths;

	public NewlineContext() {}

	public NewlineContext(List<NodeType> nodeTypes, List<Double> lengths) {
		this.nodeTypes = nodeTypes;
		this.lengths = lengths;
	}

	public List<NodeType> getNodeTypes() {
		return nodeTypes;
	}

	public void setNodeTypes(List<NodeType> nodeTypes) {
		this.nodeTypes = nodeTypes;
	}

	public List<Double> getLengths() {
		return lengths;
	}

	public void setLengths(List<Double> lengths) {
		this.lengths = lengths;
	}

	public double calLengthDistance(NewlineContext other) {
		if (lengths == null || other.lengths == null) {
			return 0.0;
		}
		double distance = 0;
		for (double len1 : lengths) {
			for (double len2 : other.lengths) {
				distance += Math.abs(len1 - len2);
			}
		}

		return distance / (lengths.size() * other.lengths.size());
	}

	@Override
	public void addElement(Element parent, MyParser parser) {
		String str = nodeTypes.stream().map(e -> e.nodeName).toList().toString();
		parent.addAttribute("nodeNames", str.substring(1, str.length() - 1));
		str = nodeTypes.stream().map(e ->e.isAstNode).toList().toString();
		parent.addAttribute("isAstNode", str.substring(1, str.length() - 1));
		if (lengths != null) {
			str = lengths.toString();
			parent.addAttribute("lengths", str.substring(1, str.length() - 1));
		}
	}

	@Override
	public void parseElement(Element parent, MyParser parser) {
		List<String> nodeNames = Arrays.stream(parent.attributeValue("nodeNames").split(","))
				.map(String::trim)       // 去掉空格
				.filter(s -> !s.isEmpty()) // 去掉空字符串
				.toList();
		List<Boolean> isAstNodes = Arrays.stream(parent.attributeValue("isAstNode").split(","))
				.filter(s -> !s.isEmpty())
				.map(e -> Boolean.parseBoolean(e.trim()))
				.toList();
		nodeTypes = new ArrayList<>();
		for (int i = 0; i < nodeNames.size(); i++) {
			nodeTypes.add(new NodeType(nodeNames.get(i), isAstNodes.get(i)));
		}

		String str = parent.attributeValue("lengths");
		if (str != null) {
			lengths = Arrays.stream(str.split(","))
					.map(Double::parseDouble)
					.collect(Collectors.toList());
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NewlineContext context = (NewlineContext) o;
		return Objects.equals(nodeTypes, context.nodeTypes) && Objects.equals(lengths, context.lengths);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nodeTypes, lengths);
	}


	public static class NodeType {
		private String nodeName;
		private boolean isAstNode;

		public NodeType(String nodeName) {
			this.nodeName = nodeName;
			this.isAstNode = true;
		}

		public NodeType(String nodeName, boolean isAstNode) {
			this.nodeName = nodeName;
			this.isAstNode = isAstNode;
		}

		public boolean isAstNode() {
			return isAstNode;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof NodeType nodeType)) return false;
			return isAstNode == nodeType.isAstNode && Objects.equals(nodeName, nodeType.nodeName);
		}

		@Override
		public int hashCode() {
			return Objects.hash(nodeName, isAstNode);
		}
	}
}
