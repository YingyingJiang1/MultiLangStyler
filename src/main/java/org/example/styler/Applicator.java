package org.example.styler;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.context.ExtendContext;

import java.util.List;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/20 22:15
 */
public interface Applicator {
    ExtendContext applyStyle(ExtendContext ctx);
    void applyStyle(List<Token> tokens, int index);
}
