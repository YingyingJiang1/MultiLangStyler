package org.example.styler.format.newline.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class NewlineProperty extends StyleProperty {
	public int newlines;
	public String hwsStr; // hws string after vws (hierarchy indention is excluded).
	public int hierarchy; // Temp variable

	public NewlineProperty() {
	}

	public NewlineProperty(int newlines, String hwsStr, int hierarchy) {
		this.newlines = newlines;
		this.hwsStr = hwsStr;
		this.hierarchy = hierarchy;
	}

	@Override
	public void addElement(Element parent, MyParser parser) {
		parent.addAttribute("newlines", Integer.toString(newlines));
		parent.addAttribute("hwsStr", hwsStr);
	}

	@Override
	public void parseElement(Element parent, MyParser parser) {
		String newlinesStr = parent.attributeValue("newlines");
		if (newlinesStr != null) {
			newlines = Integer.parseInt(newlinesStr);
		}

		hwsStr = parent.attributeValue("hwsStr");

	}

	@Override
	public int hashCode() {
		return Objects.hash(newlines, hwsStr, hierarchy);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NewlineProperty property) {
			return newlines == property.newlines && Objects.equals(property.hwsStr, hwsStr) && hierarchy == property.hierarchy;
		}
		return false;
	}
}
