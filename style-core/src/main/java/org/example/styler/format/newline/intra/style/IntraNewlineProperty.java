package org.example.styler.format.newline.intra.style;


import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.styler.format.newline.block.style.NewlineProperty;

import java.util.*;

public class IntraNewlineProperty extends NewlineProperty {
	public double lineLengthRatio; // 每行的平均行长
	public Map<String, Boolean> breakAfter = new HashMap<>();

	{
		breakAfter.put("&&", Boolean.TRUE);
		breakAfter.put("||", Boolean.TRUE);
		breakAfter.put(",", Boolean.TRUE);
		breakAfter.put("@", Boolean.FALSE);
		breakAfter.put(".", Boolean.FALSE);
		breakAfter.put("->", Boolean.TRUE);
	}

	public IntraNewlineProperty(int newlines) {
		super(newlines);
	}

	public IntraNewlineProperty(int newlines, List<String> relativeIndention, double lineLengthRatio) {
		super(newlines, relativeIndention);
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


	@Override
	public void addElement(Element parent, MyParser parser) {
		super.addElement(parent, parser);
		parent.addAttribute("lineLengthRatio", String.valueOf(lineLengthRatio));
	}

	@Override
	public void parseElement(Element parent, MyParser parser) {
		super.parseElement(parent, parser);
		lineLengthRatio = Double.parseDouble(parent.attributeValue("lineLengthRatio"));
	}

}
