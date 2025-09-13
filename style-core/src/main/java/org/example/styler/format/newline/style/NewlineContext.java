package org.example.styler.format.newline.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.*;
import java.util.stream.Collectors;

public class NewlineContext extends StyleContext {
	// 节点类型序列（必须按顺序匹配）
	private List<String> nodeTypes;
	private List<Double> lengths;


	public NewlineContext(List<String> nodeTypes, List<Double> lengths) {
		this.nodeTypes = nodeTypes;
		this.lengths = lengths;
	}

	public List<String> getNodeTypes() {
		return nodeTypes;
	}

	public void setNodeTypes(List<String> nodeTypes) {
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
		String str = nodeTypes.toString();
		parent.addAttribute("nodeTypes", str.substring(1, str.length() - 1));
		if (lengths != null) {
			str = lengths.toString();
			parent.addAttribute("lengths", str.substring(1, str.length() - 1));
		}
	}

	@Override
	public void parseElement(Element parent, MyParser parser) {
		nodeTypes = Arrays.stream(parent.attributeValue("nodeTypes").split(",")).toList();
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
}
