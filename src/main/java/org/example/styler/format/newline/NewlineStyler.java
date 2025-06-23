package org.example.styler.format.newline;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Styler;
import org.example.styler.format.body.braceformat.BraceFormatStyler;

import java.util.ArrayList;
import java.util.List;

public class NewlineStyler extends Styler {
	List<Styler> stylerList = new ArrayList<>();

	public NewlineStyler() {
		stylerList.add(new BlankLineStyler());
		stylerList.add(new BraceFormatStyler());
	}

	@Override
	public void extractStyle(ExtendContext ctx, MyParser parser) {

	}

	@Override
	public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
		return ctx;
	}
}
