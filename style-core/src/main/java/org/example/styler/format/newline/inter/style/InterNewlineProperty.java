package org.example.styler.format.newline.inter.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class InterNewlineProperty extends StyleProperty {
	public boolean hasNewline;

	public InterNewlineProperty(boolean hasNewline) {
		this.hasNewline = hasNewline;
	}

	@Override
	public void addElement(Element parent, MyParser parser) {
		parent.addAttribute("hasNewline", String.valueOf(hasNewline));
	}

	@Override
	public void parseElement(Element parent, MyParser parser) {
		hasNewline = Boolean.parseBoolean(Objects.requireNonNull(parent.attributeValue("hasNewline")));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InterNewlineProperty that = (InterNewlineProperty) o;
		return hasNewline == that.hasNewline;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(hasNewline);
	}
}
