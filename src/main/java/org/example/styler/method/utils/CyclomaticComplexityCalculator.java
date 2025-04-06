/**
 * The implementation of this class if based on https://github.com/yangxiyucs/CyclomaticComplexity/blob/master/src/antlr4/CyclomaticComplexityVisitor.java
 */

package org.example.styler.method.utils;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

import java.util.Stack;

public class CyclomaticComplexityCalculator {
	protected Stack<Entry> entryStack = new Stack<Entry>();

	private CyclomaticComplexityCalculator() {}

	public static CyclomaticComplexityCalculator createCalculator() {
		return new CyclomaticComplexityCalculator();
	}

	public int calculateMethod(ExtendContext methodDeclaration, MyParser parser) {
		return 0;
	}



	class Entry {
		private Object node;
		public int decisionPoints = 1;
		public int highestDecisionPoints;
		public int methodCount;

		Entry(Object node) {
			this.node = node;
		}

		public void bumpDecisionPoints() {
			decisionPoints++;
		}

		public void bumpDecisionPoints(int size) {
			decisionPoints += size;
		}

		public int getComplexityAverage() {
			return (double) methodCount == 0 ? 1
					: (int) Math.rint( (double) decisionPoints / (double) methodCount );
		}

}
