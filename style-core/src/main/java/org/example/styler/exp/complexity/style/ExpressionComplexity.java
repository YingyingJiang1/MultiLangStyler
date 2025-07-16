package org.example.styler.exp.complexity.style;

import org.dom4j.Element;

import java.util.Objects;

public class ExpressionComplexity {
	public double textLength; // This field is not used when comparing expression complexity.
	public double depth;

	public ExpressionComplexity() {
	}

	public ExpressionComplexity(double length, double expDepth) {
		textLength = length;
		depth = expDepth;
	}

	public boolean isMoreComplex(ExpressionComplexity complexity) {
		return this.diff(complexity) > 0;
	}

	public boolean isNoMoreComplex(ExpressionComplexity complexity) {
		return this.diff(complexity) <= 0;
	}

	public double diff(ExpressionComplexity complexity) {
		return depth - complexity.depth;
	}

	public void addElement(Element parent) {
//		parent.addAttribute("textLength", Double.toString(textLength));
		parent.addAttribute("depth", Double.toString(depth));
	}

	public void parseElement(Element parent) {
//		textLength = Integer.parseInt(parent.attributeValue("textLength"));
		depth = Double.parseDouble(parent.attributeValue("depth"));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ExpressionComplexity complexity) {
			return complexity.depth == depth && complexity.textLength == textLength;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				textLength,
				depth
		);
	}
}
