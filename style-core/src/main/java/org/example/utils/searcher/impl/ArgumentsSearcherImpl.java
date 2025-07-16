package org.example.utils.searcher.impl;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.utils.searcher.intf.ArgumentsSearcher;

public class ArgumentsSearcherImpl implements ArgumentsSearcher {

    public ArgumentsSearcherImpl() {
    }

    @Override
    public ExtendContext searchArgument(ExtendContext arguments, int index, MyParser parser) {
        if (arguments.getChild(1) instanceof ExtendContext argsList) {
            return (ExtendContext) argsList.getChild(index);
        }
        return null;
    }
}
