package org.example.lang.java;

import org.antlr.v4.runtime.Token;
import org.example.lang.base.CodeContextPredicateBase;
import org.example.lang.intf.CodeContextPredicate;
import org.example.lang.intf.MyParser;

import java.util.List;

public class JavaCodeContextPredicate extends CodeContextPredicateBase {
	private static JavaCodeContextPredicate instance = new JavaCodeContextPredicate();

	protected JavaCodeContextPredicate() {}

	public static JavaCodeContextPredicate getInstance() {
		return instance;
	}
}
