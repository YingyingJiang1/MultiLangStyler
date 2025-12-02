package org.example.lang.intf.searcher;

import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;

public interface ArgumentsSearcher {
    ExtendContext searchArgument(ExtendContext arguments, int index, MyParser parser);
}
