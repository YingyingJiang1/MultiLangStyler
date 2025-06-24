package org.example.styler.format.newline.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class NewlineProperty extends StyleProperty {
	public int newlines;

	public NewlineProperty() {
	}

	public NewlineProperty(int newlines) {
		this.newlines = newlines;
	}

	@Override
	public void addElement(Element parent, MyParser parser) {
		parent.addAttribute("newlines", Integer.toString(newlines));
	}

	@Override
	public void parseElement(Element parent, MyParser parser) {
		String newlinesStr = parent.attributeValue("newlines");
		if (newlinesStr != null) {
			newlines = Integer.parseInt(newlinesStr);
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(newlines);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NewlineProperty property) {
			return newlines == property.newlines;
		}
		return false;
	}
}
