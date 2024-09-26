package org.example.style.format;

import org.dom4j.Element;
import org.example.style.DomIO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @description Style property of statement(not block) in block statement.
 * for example:
 * if(a > 1)
 *  return true;
 * @author       Yingying Jiang
 * @create       2024/4/18 21:39
 */
public class SingleLineBlockProperty implements DomIO {

	public boolean useBrace;
	public boolean isInlineBlock; // The field is meaningful when @useBrace == false
	List<Integer> counts = new ArrayList<>();

	public SingleLineBlockProperty() {
		counts.add(0);
		counts.add(0);
	}

	public SingleLineBlockProperty(boolean useBrace, boolean isInlineBlock) {
		this.useBrace = useBrace;
		this.isInlineBlock = isInlineBlock;
	}

	public void addUseBrace(boolean useBrace){
		counts.set(0, useBrace ? counts.get(0) + 1 : counts.get(0) - 1);
	}

	public void addIsInlineBlock(boolean isInlineBlock){
		counts.set(1, isInlineBlock ? counts.get(1) + 1 : counts.get(1) - 1);
	}

	@Override
	public void addElement(Element parent) {
		parent.addElement("use_brace").addText(Boolean.toString(useBrace));
		if(!useBrace) {
			parent.addElement("is_inline_block").addText(Boolean.toString(isInlineBlock));
		}
	}

	@Override
	public void parseElement(Element parent) {
		useBrace = Boolean.parseBoolean(parent.elementText("use_brace"));
		if(!useBrace) {
			isInlineBlock = Boolean.parseBoolean(parent.elementText("is_inline_block"));
		}
	}

	public void merge(SingleLineBlockProperty property) {
		counts.set(0, property.useBrace ? counts.get(0) + 1 : counts.get(0) - 1);
		counts.set(1, property.isInlineBlock ? counts.get(1) + 1 : counts.get(1) - 1);
	}

	void fill() {
		useBrace = counts.get(0) >= 0;
		isInlineBlock = counts.get(1) >= 0;
	}
}
