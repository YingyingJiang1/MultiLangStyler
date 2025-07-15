package org.example.utils.searcher.intf;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

import java.util.List;

public interface MethodSearcher {
    ExtendContext searchMethodHead(ExtendContext methodDec, MyParser parser);

    ExtendContext searchMethodBody(ExtendContext methodDec, MyParser parser);


    ExtendContext searchMethodName(ExtendContext methodHead, MyParser parser);

    ExtendContext searchRetType(ExtendContext methodHead, MyParser parser);

    List<ExtendContext> searchParaTypes(ExtendContext methodHead, MyParser parser);

    int indexOfParameter(ExtendContext methodHead, ExtendContext parameter, MyParser parser);

}
