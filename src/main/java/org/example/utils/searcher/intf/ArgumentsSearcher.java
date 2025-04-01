package org.example.utils.searcher.intf;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;

public interface ArgumentsSearcher {
    ExtendContext searchArgument(ExtendContext arguments, int index, MyParser parser);
}
