package org.example.parser.common;

import org.example.style.InconsistencyInfo;

import java.util.List;

public interface ExtendListener {
	List<InconsistencyInfo> getInconsistencyInfos();

}
