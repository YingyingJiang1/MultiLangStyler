package org.example.semantic.intf;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

import java.util.List;

public interface DefUseGetter {
	/**
	 *
	 * @param identifier
	 * @param parser
	 * @return all statements before `identifier` and in the same method with `identifier` that modifies the value of `identifier`
	 */
	List<ExtendContext> getAllDefsBefore(ExtendContext identifier, MyParser parser);

	/**
	 *
	 * @param identifier
	 * @param parser
	 * @return the last statement before `identifier` and in the same method with `identifier` that modifies the value of `identifier`
	 */
	ExtendContext getLastDefBefore(ExtendContext identifier, MyParser parser);
}
