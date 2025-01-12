package org.example.utils.searcher.intf;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

public interface FunctionDecSearcher {
    ExtendContext searchFunctionName(ExtendContext functionDec, MyParser parser);

    int indexOfParameter(ExtendContext functionDec, ExtendContext parameter, MyParser parser);

}
