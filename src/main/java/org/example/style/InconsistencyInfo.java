package org.example.style;

import pascal.taie.analysis.pta.core.heap.Obj;

public class InconsistencyInfo {
	private int row, column; // start from 0
	private String message;
	private Object styleSpecificInfo;
}
