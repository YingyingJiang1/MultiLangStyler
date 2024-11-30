package org.example.styler;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.MyParser;
import org.example.style.CommonStyle;
import org.example.style.Style;

import java.util.List;
import java.util.Set;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/21 10:44
 */
public abstract class Styler {
    protected MyParser parser;
    protected Style style;
    protected boolean enableExtraction = true;
    protected boolean enableApplication = true;
    public boolean executeWhenExit = true;

    public Styler(MyParser parser, boolean enableExtraction, boolean enableApplication) {
        this.parser = parser;
        this.enableExtraction = enableExtraction;
        this.enableApplication = enableApplication;
    }

    public Styler() {
        style = new CommonStyle();
    }

    public Styler(boolean executeWhenExit) {
        style = new CommonStyle();
        this.executeWhenExit = executeWhenExit;
    }

    public Style getStyle() { return style; }

    public void applyStyle(List<Token> tokens, int index) {
    }

    public ExtendContext applyStyle(ExtendContext ctx) {
        return null;
    }

    public void extractStyle(List<Token> tokens, int index) {}

    public void extractStyle(ExtendContext ctx) {}

    public boolean isEnable(Stage stage) {
        if (stage == Stage.EXTRACT) {
            return enableExtraction;
        }
        if (stage == Stage.APPLY) {
            return enableApplication;
        }
        return true;
    }

//    public void enable(int process) {
//        if (process == EXTRACTION_PROCESS) {
//            enableExtraction = true;
//        }
//        if (process == APPLICATION_PROCESS) {
//            enableApplication = true;
//        }
//    }
//
//    public void disable(int process) {
//        if (process == EXTRACTION_PROCESS) {
//            enableExtraction = false;
//        }
//        if (process == APPLICATION_PROCESS) {
//            enableApplication = false;
//        }
//    }

    public void doFinalize() {
        style.fillStyle();
        style.filterRules();
    }

    public void reset() {
        style.reset();
    }

    protected Set<Integer> getRelevantRules() {return null;}

    protected Set<String> getRelevantTokens() { return null;}

    /**
     * @implNote
     * @param ctx
     * @param stage EXTRACT or APPLY
     * @return
     */
    public boolean isRelevant(ExtendContext ctx, Stage stage){
        Set<Integer> relevantRules = getRelevantRules();
        // Special case: all rules is relevant.
        if (relevantRules == null) {
            return true;
        }
        int targetRule = ctx.getRuleIndex();
        return relevantRules.contains(targetRule);
    }

    public boolean isRelevant(List<Token> tokens, int i, Stage stage){
        Set<String> relevantTokens = getRelevantTokens();
        // Special case: all tokens is relevant.
        if (relevantTokens == null) {
            return true;
        }
        return relevantTokens.contains(tokens.get(i).getText());
    }

    public void setParser(MyParser parser) {
        this.parser = parser;
    }
}
