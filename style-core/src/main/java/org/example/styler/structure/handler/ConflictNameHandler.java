package org.example.styler.structure.handler;

import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;

import java.util.List;

public class ConflictNameHandler extends Handler{
	public ConflictNameHandler(String[][] argsList) {
		super(argsList);
	}

	/**
	 * TODO: handle conflicts of variable name in specified domain.
	 * @param structure
	 * @param args [variable declaration, domain of declaration]
	 * @param parser
	 */
	@Override
	protected void doHandle(EquivalentStructure structure, List<String> args, MyParser parser) {
		super.doHandle(structure, args, parser);
	}
}
