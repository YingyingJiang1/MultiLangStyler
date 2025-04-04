package org.example.utils.searcher.javaimpl;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.java.antlr.JavaParser;
import org.example.utils.searcher.intf.FunctionHeadSearcher;

import java.util.List;

public class JavaFunctionHeadSearcher implements FunctionHeadSearcher {

    public JavaFunctionHeadSearcher() {
    }


    @Override
    public ExtendContext searchFunctionName(ExtendContext functionHead, MyParser parser) {
        return functionHead.getFirstCtxChildIf(parser::isIdentifier);
    }

    @Override
    public ExtendContext searchRetType(ExtendContext functionHead, MyParser parser) {
        return functionHead.getFirstCtxChildIf(parser::isTypeType);
    }

    @Override
    public List<ExtendContext> searchParaTypes(ExtendContext functionHead, MyParser parser) {
        ExtendContext formalParametersNode = functionHead.getFirstCtxChildIf(t -> t instanceof JavaParser.FormalParametersContext);
        return formalParametersNode.getAllCtxsRecIf(parser::isTypeType);
    }

    @Override
    public int indexOfParameter(ExtendContext functionHead, ExtendContext parameter, MyParser parser) {
        ExtendContext paramList = functionHead.getContextRecIf(t -> t instanceof JavaParser.FormalParameterListContext);
        return paramList.indexOfIf(child -> child == parameter);
    }
}
