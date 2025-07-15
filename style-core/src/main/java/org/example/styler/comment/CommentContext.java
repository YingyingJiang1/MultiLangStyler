package org.example.styler.comment;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleContext;

import java.util.Objects;

public class CommentContext extends StyleContext {
	CommentType commentType;


	public CommentContext(CommentType commentType) {
		this.commentType = commentType;
	}

	@Override
	public void addElement(Element parent, MyParser parser) {
		parent.addAttribute("type", commentType.toString());
	}

	@Override
	public void parseElement(Element parent, MyParser parser) {
		commentType = CommentType.valueOf(parent.attributeValue("type"));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CommentContext other) {
			return Objects.equals(commentType, other.commentType);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(commentType);
	}
}
