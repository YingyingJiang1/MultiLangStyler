package org.example.lang.java.searcher;

import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.antlr.java.JavaParser;
import org.example.lang.intf.searcher.MethodSearcher;

import java.util.List;

public class JavaMethodSearcher implements MethodSearcher {

    public JavaMethodSearcher() {
    }


    @Override
    public ExtendContext searchMethodHead(ExtendContext methodDec, MyParser parser) {
        return methodDec.getFirstCtxChildIf(t -> t instanceof JavaParser.MethodHeadContext || t instanceof JavaParser.ConstructorHeadContext);
    }

    @Override
    public ExtendContext searchMethodBody(ExtendContext methodDec, MyParser parser) {
        return methodDec.getFirstCtxChildIf(parser::isBlock);
    }

    @Override
    public ExtendContext searchMethodName(ExtendContext methodHead, MyParser parser) {
        return methodHead.getFirstCtxChildIf(parser::isIdentifier);
    }

    @Override
    public ExtendContext searchRetType(ExtendContext methodHead, MyParser parser) {
        return methodHead.getFirstCtxChildIf(parser::isTypeType);
    }

    @Override
    public List<ExtendContext> searchParaTypes(ExtendContext methodHead, MyParser parser) {
        ExtendContext formalParametersNode = methodHead.getFirstCtxChildIf(t -> t instanceof JavaParser.FormalParametersContext);
        return formalParametersNode.getAllCtxsRecIf(parser::isTypeType);
    }

    @Override
    public int indexOfParameter(ExtendContext methodHead, ExtendContext parameter, MyParser parser) {
        ExtendContext paramList = methodHead.getFirstContextRecIf(t -> t instanceof JavaParser.FormalParameterListContext);
        return paramList.indexOfIf(child -> child == parameter);
    }
}
