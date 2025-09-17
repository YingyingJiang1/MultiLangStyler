package org.example.styler.format.newline.intra.style;


import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.*;

public class IntraNewlineProperty extends StyleProperty {
	public int newlines;
	// relativeIndention[i] is the indention of line i+1 relative to line i
	// line 0: the first line
	// line 1:  the first succeed line.
	// 当数组长度不足时，默认返回最后一个元素。关于相对缩进的实现，只区分一种情况：后继行（line1-linen)相对起始行（line0)的缩进
	public List<String> relativeIndention;
	public double length;
	public double minLen;
//	public boolean breakAfter;
	public Map<String, Boolean> breakAfter = new HashMap<>();

	{
		breakAfter.put(",",  true);

	}

	public IntraNewlineProperty(int newlines) {
		this.newlines = newlines;
	}

	public IntraNewlineProperty(int newlines, List<String> relativeIndention, double length) {
		this.newlines = newlines;
		this.relativeIndention = relativeIndention;
		this.length = length;
	}

	public boolean isBreakAfter(String tokenStr) {
		if (breakAfter.containsKey(tokenStr)) return breakAfter.get(tokenStr);
		return false; // 默认在token前面换行
	}

	public String getRelativeIndention(int line) {
		if (relativeIndention == null) {
			return "";
		}

		int index = line - 1;
		if (index < relativeIndention.size()) {
			return relativeIndention.get(index);
		}
		// line超过数组长度时，默认返回最后一个元素
		return relativeIndention.get(relativeIndention.size() - 1);
	}


	@Override
	public void addElement(Element parent, MyParser parser) {
		parent.addAttribute("newlines", Integer.toString(newlines));
		if (relativeIndention != null) {
			parent.addAttribute("relativeIndention", String.join(",", relativeIndention));
		}
		parent.addAttribute("length", String.valueOf(length));
		parent.addAttribute("minLen", String.valueOf(minLen));
	}

	@Override
	public void parseElement(Element parent, MyParser parser) {
		String newlinesStr = parent.attributeValue("newlines");
		if (newlinesStr != null) {
			newlines = Integer.parseInt(newlinesStr);
		}

		String relativeIndentionStr = parent.attributeValue("relativeIndention");
		if (relativeIndentionStr != null) {
			relativeIndention = Arrays.stream(relativeIndentionStr.split(",")).toList();
		}
		length = Double.parseDouble(parent.attributeValue("length"));
		minLen = Double.parseDouble(parent.attributeValue("minLen"));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IntraNewlineProperty property = (IntraNewlineProperty) o;
		return newlines == property.newlines
				&& Double.compare(length, property.length) == 0
				&& Objects.equals(relativeIndention, property.relativeIndention)
				&& Double.compare(minLen, property.minLen) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(newlines, relativeIndention, length, minLen);
	}

	public static class BreakLoc {
		String text;
		boolean after;
		int priority;

		public BreakLoc(String text, boolean after, int priority) {
			this.text = text;
			this.after = after;
			this.priority = priority;
		}

		public BreakLoc(String text, int priority) {
			after = false;
			this.text = text;
			this.priority = priority;
		}
	}
}
