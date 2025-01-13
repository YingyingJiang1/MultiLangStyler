package org.example.utils.searcher.javaimpl;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.utils.searcher.intf.FunctionDecSearcher;

public class JavaFunctionDecSearcher implements FunctionDecSearcher {
    private final static JavaFunctionDecSearcher instance = new JavaFunctionDecSearcher();

    private JavaFunctionDecSearcher() {
    }

    public static JavaFunctionDecSearcher getInstance() {
        return instance;
    }

    @Override
    public ExtendContext searchFunctionName(ExtendContext functionDec, MyParser parser) {
        if (functionDec.getChild(1) instanceof ExtendContext functionHead) {
            return functionHead.getFirstInnerChildByType(parser.getRuleIdentifier());
        }
        return null;
    }

    @Override
    public int indexOfParameter(ExtendContext functionDec, ExtendContext parameter, MyParser parser) {
        if (functionDec.getChild(1) instanceof ExtendContext functionHead) {
            ExtendContext paramList = functionHead.getContextRecIf(ctx -> ctx.getRuleIndex() == parser.getRuleformalParameterList());
            return paramList.indexOfIf(child -> child == parameter);
        }
        return -1;
    }
}
