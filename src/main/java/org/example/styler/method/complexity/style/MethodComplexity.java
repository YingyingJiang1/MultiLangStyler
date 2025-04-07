package org.example.styler.method.complexity.style;


import org.dom4j.Element;

import java.io.Serializable;
import java.util.Objects;

public class MethodComplexity implements Serializable {
	public int lineNumber;
	public String methodName;
	public double lines; // lines of method body
	public double nestingDepth; // max nesting depth of statements.
	public double nestingLoop;
	public double branchCount; // the number of if/switch branches.
	public double paraCount;
	public double cyclomaticComplexity;
	public double cognitiveComplexity;

	public MethodComplexity() {
	}

	public MethodComplexity(double lines, double maxNestedDepth) {
		this.lines = lines;
		this.nestingDepth = maxNestedDepth;
	}


	public boolean isMoreComplex(MethodComplexity other) {
		return this.diff(other) > 0;
	}

	private double diff(MethodComplexity other) {
		double linesWeight = 0.4, depthWeight = 0.6;
		return depthWeight * (nestingDepth - other.nestingDepth) + linesWeight * (lines - other.lines);
	}

	public void addElement(Element parent) {
		parent.addAttribute("lines", String.valueOf(lines));
		parent.addAttribute("nestingDepth", String.valueOf(nestingDepth));
	}

	public void parseElement(Element parent) {
		lines = Double.parseDouble(parent.attributeValue("lines"));
		nestingDepth = Double.parseDouble(parent.attributeValue("nestingDepth"));
	}

	public String toReadableString() {
		return String.format(
				"%s@%s--------------------------------------------------\n" +
				"lines: %.2f\nnestingDepth: %.2f\nnestingLoop: %.2f\nbranchCount: %.2f\nparaCount: %.2f\n" +
				"cyclomaticComplexity: %.2f\ncognitiveComplexity: %.2f\n",
				methodName, lineNumber, lines, nestingDepth, nestingLoop, branchCount, paraCount,
				cyclomaticComplexity, cognitiveComplexity);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MethodComplexity other) {
			return lines == other.lines && nestingDepth == other.nestingDepth;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lines, nestingDepth);
	}
}
