package org.example.style.codecontext;

import org.example.antlr.common.context.ExtendContext;

public abstract class CodeContext {
    protected int[] startLoc, endLoc;

     public CodeContext() {}

     public CodeContext(int[] startLoc, int[] endLoc) {
         this.startLoc = startLoc;
         this.endLoc = endLoc;
     }

     public int getStartRow() {
         return startLoc[0];
     }

     public int getStartColumn() {
         return startLoc[1];
     }

     public int getEndRow() {
         return endLoc[0];
     }

     public int getEndColumn() {
         return endLoc[1];
     }
}
