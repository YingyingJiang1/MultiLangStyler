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
	public List<String> relativeIndention;
	public double lineLengthRatio;
	public boolean breakAfter;
//	public Map<String, BreakLoc> breakAfter = new HashMap<>();
//
//	{
//		breakAfter.put("?", new BreakLoc("?", 1));
//		breakAfter.put(":", new BreakLoc(":",  1));
//		breakAfter.put("&&", new BreakLoc("&&", 2));
//		breakAfter.put("||",  new BreakLoc("||", 2));
//		breakAfter.put(".",  new BreakLoc(".", 3));
//		breakAfter.put("+", new BreakLoc("+", 4));
//		breakAfter.put("-", new BreakLoc("-", 4));
//		breakAfter.put("*", new BreakLoc("*", 4));
//		breakAfter.put("/", new BreakLoc("/", 4));
//		breakAfter.put("%", new BreakLoc("%", 4));
//		breakAfter.put("@",  new BreakLoc("@", 8));
//		breakAfter.put("->",new BreakLoc("->",true, 8));
//		breakAfter.put("=", new BreakLoc("=", 9));
//		breakAfter.put(",",  new BreakLoc(",",true, 10));
//
//	}

	public IntraNewlineProperty(int newlines) {
		this.newlines = newlines;
	}

	public IntraNewlineProperty(int newlines, List<String> relativeIndention, double lineLengthRatio) {
		this.newlines = newlines;
		this.relativeIndention = relativeIndention;
		this.lineLengthRatio = lineLengthRatio;
	}



	public String getRelativeIndention(int line) {
		if (relativeIndention == null) {
			return "";
		}

		int index = line - 1;
		if (index < relativeIndention.size()) {
			return relativeIndention.get(index);
		}
		return relativeIndention.get(relativeIndention.size() - 1);
	}


	@Override
	public void addElement(Element parent, MyParser parser) {
		parent.addAttribute("newlines", Integer.toString(newlines));
		if (relativeIndention != null) {
			parent.addAttribute("relativeIndention", relativeIndention.toString().substring(1, relativeIndention.toString().length() - 1));
		}
		parent.addAttribute("lineLengthRatio", String.valueOf(lineLengthRatio));
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
		lineLengthRatio = Double.parseDouble(parent.attributeValue("lineLengthRatio"));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IntraNewlineProperty property = (IntraNewlineProperty) o;
		return newlines == property.newlines
				&& Double.compare(lineLengthRatio, property.lineLengthRatio) == 0
				&& Objects.equals(relativeIndention, property.relativeIndention);
	}

	@Override
	public int hashCode() {
		return Objects.hash(newlines, relativeIndention, lineLengthRatio);
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
