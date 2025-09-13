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
	public double lineLengthRatio; // 每行的平均行长
	public Map<String, Boolean> breakAfter = new HashMap<>();

	{
		breakAfter.put("&&", Boolean.TRUE);
		breakAfter.put("||", Boolean.TRUE);
		breakAfter.put(",", Boolean.TRUE);
		breakAfter.put("@", Boolean.FALSE);
		breakAfter.put(".", Boolean.FALSE);
		breakAfter.put("->", Boolean.TRUE);
		breakAfter.put("?", Boolean.TRUE);
		breakAfter.put(":", Boolean.TRUE);
	}

	public IntraNewlineProperty(int newlines) {
		this.newlines = newlines;
	}

	public IntraNewlineProperty(int newlines, List<String> relativeIndention, double lineLengthRatio) {
		this.newlines = newlines;
		this.relativeIndention = relativeIndention;
		this.lineLengthRatio = lineLengthRatio;
	}

	public boolean isBreakLoc(String text) {
		return breakAfter.containsKey(text);
	}

	public boolean isBreakAfter(String text) {
		return breakAfter.get(text) != null;
	}

	public void updateBreakLoc(String text, boolean after) {
		if (breakAfter.containsKey(text)) {
			breakAfter.put(text, after);
		}
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
				&& Objects.equals(relativeIndention, property.relativeIndention)
				&& Objects.equals(breakAfter, property.breakAfter);
	}

	@Override
	public int hashCode() {
		return Objects.hash(newlines, relativeIndention, lineLengthRatio, breakAfter);
	}
}
