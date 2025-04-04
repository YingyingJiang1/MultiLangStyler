package org.example.utils.searcher.intf;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

import java.util.List;

public interface FunctionHeadSearcher {
    ExtendContext searchFunctionName(ExtendContext functionHead, MyParser parser);

    ExtendContext searchRetType(ExtendContext functionHead, MyParser parser);

    List<ExtendContext> searchParaTypes(ExtendContext functionHead, MyParser parser);

    int indexOfParameter(ExtendContext functionHead, ExtendContext parameter, MyParser parser);

}
