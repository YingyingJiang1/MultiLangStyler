package org.example.utils.searcher.impl;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.utils.searcher.intf.ArgumentsSearcher;

public class ArgumentsSearcherImpl implements ArgumentsSearcher {
    private final static ArgumentsSearcher instance = new ArgumentsSearcherImpl();

    private ArgumentsSearcherImpl() {
    }

    public static ArgumentsSearcher getInstance() {
        return instance;
    }

    @Override
    public ExtendContext getArgument(ExtendContext arguments, int index, MyParser parser) {
        if (arguments.getChild(1) instanceof ExtendContext argsList) {
            return (ExtendContext) argsList.getChild(index);
        }
        return null;
    }
}
