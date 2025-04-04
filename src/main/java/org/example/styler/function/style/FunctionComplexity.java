package org.example.styler.function.style;


import org.dom4j.Element;

import java.util.Objects;

public class FunctionComplexity {
	public double lines;
	public double nestingDepth;

	public FunctionComplexity() {
	}

	public FunctionComplexity(double lines, double maxNestedDepth) {
		this.lines = lines;
		this.nestingDepth = maxNestedDepth;
	}

	public boolean isMoreComplex(FunctionComplexity other) {
		return lines > other.lines || nestingDepth > other.nestingDepth;
	}

	public void addElement(Element parent) {
		parent.addAttribute("lines", String.valueOf(lines));
		parent.addAttribute("nestingDepth", String.valueOf(nestingDepth));
	}

	public void parseElement(Element parent) {
		lines = Double.parseDouble(parent.attributeValue("lines"));
		nestingDepth = Double.parseDouble(parent.attributeValue("nestingDepth"));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FunctionComplexity other) {
			return lines == other.lines && nestingDepth == other.nestingDepth;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lines, nestingDepth);
	}
}
