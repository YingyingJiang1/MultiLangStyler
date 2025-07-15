package org.example.styler;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.MyParser;
import org.example.style.CommonStyle;
import org.example.style.InconsistencyInfo;
import org.example.style.Style;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Set;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/21 10:44
 */
public abstract class Styler {
    protected Style style;
    protected boolean enableExtraction = true;
    protected boolean enableApplication = true;
    public boolean executeWhenExit = true;

    public Styler(boolean enableExtraction, boolean enableApplication) {
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

    public List<Token> applyStyle(List<Token> tokens, int index, MyParser parser) {
        return null;
    }

    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        return ctx;
    }

    public void extractStyle(List<Token> tokens, int index, MyParser parser) {}

    public void extractStyle(ExtendContext ctx, MyParser parser) {}

    public @Nullable List<InconsistencyInfo> analyzeInconsistency(ExtendContext ctx, MyParser parser) {
        return null;
    }

    public @Nullable List<InconsistencyInfo> analyzeInconsistency(List<Token> tokens, int index, MyParser parser) {
        return null;
    }

    public boolean isEnable(Stage stage) {
        if (stage == Stage.EXTRACT) {
            return enableExtraction;
        }
        if (stage == Stage.APPLY) {
            return enableApplication;
        }
        return true;
    }

    public void enable() {
        enableExtraction = true;
        enableApplication = true;
    }

    public void disable() {
        enableExtraction = false;
        enableApplication = false;
    }

    public void extractFinalize() {
        style.fillStyle();
        style.filterRules();
    }

    public void applicationFinalize() {
    }

    protected Set<Integer> getRelevantRules(MyParser parser) {return null;}

    protected Set<String> getRelevantTokens(MyParser parser) { return null;}

    /**
     * @param ctx
     * @param stage  EXTRACT or APPLY
     * @param parser
     * @return
     * @implNote
     */
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser){
        Set<Integer> relevantRules = getRelevantRules(parser);
        // Special case: all rules is relevant.
        if (relevantRules == null) {
            return true;
        }
        int targetRule = ctx.getRuleIndex();
        return relevantRules.contains(targetRule);
    }

    public boolean isRelevant(List<Token> tokens, int i, Stage stage, MyParser parser){
        Set<String> relevantTokens = getRelevantTokens(parser);
        // Special case: all tokens is relevant.
        if (relevantTokens == null) {
            return true;
        }
        return relevantTokens.contains(tokens.get(i).getText());
    }

    public void setStyle(Style style) {
        this.style = style;
    }
}
