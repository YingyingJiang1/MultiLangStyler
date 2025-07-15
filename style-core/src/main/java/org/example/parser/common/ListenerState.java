package org.example.parser.common;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.context.ExtendContext;

public class ListenerState {
    public ExtendContext curClassBody = null;
    public ExtendContext curMethodBody = null;
    public ExtendContext curBlock = null;

    public ExtendContext getLowestLevel() {
        if (curBlock!= null) {
            return curBlock;
        } else if (curMethodBody!= null) {
            return curMethodBody;
        } else if (curClassBody!= null) {
            return curClassBody;
        } else {
            return null;
        }
    }

    public ExtendContext getHighestLevel() {
        if (curClassBody!= null) {
            return curClassBody;
        } else if (curMethodBody!= null) {
            return curMethodBody;
        } else if (curBlock!= null) {
            return curBlock;
        } else {
            return null;
        }
    }
}
