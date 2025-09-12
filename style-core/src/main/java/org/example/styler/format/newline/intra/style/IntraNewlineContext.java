package org.example.styler.format.newline.intra.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.Objects;

public class IntraNewlineContext extends StyleContext {
	public double length;

	public IntraNewlineContext(double length) {
		this.length = length;
	}

	@Override
	public void addElement(Element parent, MyParser parser) {
		parent.addAttribute("length", String.valueOf(length));
	}

	@Override
	public void parseElement(Element parent, MyParser parser) {
		length = Double.parseDouble(parent.attributeValue("length"));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IntraNewlineContext that = (IntraNewlineContext) o;
		return Double.compare(length, that.length) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(length);
	}
}
