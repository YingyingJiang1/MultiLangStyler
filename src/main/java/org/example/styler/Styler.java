package org.example.styler;

import org.antlr.v4.runtime.Token;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.MyParser;
import org.example.style.CommonStyle;
import org.example.style.Style;
import org.example.style.Style;

import java.util.List;
import java.util.Set;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/21 10:44
 */
public abstract class Styler implements Extractor, Applicator {
    protected MyParser parser;
    protected Style style;
    protected boolean enableExtraction = true;
    protected boolean enableApplication = true;
    public boolean executeWhenExit = true;
//  protected String filePath;
//  protected ProgramStyle programStyle;
//  protected Configuration conf;
//  protected FileCollector.FileCollection files;

    public static final int EXTRACTION_PROCESS = 1;
    public static final int APPLICATION_PROCESS = 2;

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

    @Override
    public void applyStyle(List<Token> tokens, int index) {
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx) {
        return null;
    }

    @Override
    public void extractStyle(List<Token> tokens, int index) {}

    @Override
    public void extractStyle(ExtendContext ctx) {}

    public boolean isEnable(int process) {
        if (process == EXTRACTION_PROCESS) {
            return enableExtraction;
        }
        if (process == APPLICATION_PROCESS) {
            return enableApplication;
        }
        return true;
    }

    public void enable(int process) {
        if (process == EXTRACTION_PROCESS) {
            enableExtraction = true;
        }
        if (process == APPLICATION_PROCESS) {
            enableApplication = true;
        }
    }

    public void disable(int process) {
        if (process == EXTRACTION_PROCESS) {
            enableExtraction = false;
        }
        if (process == APPLICATION_PROCESS) {
            enableApplication = false;
        }
    }

    public void doFinalize() {
        style.fillStyle();
    }

    protected Set<Integer> getRelevantRules() {return null;}

    protected Set<String> getRelevantTokens() { return null;}

    public boolean isRelevant(ExtendContext ctx){
        Set<Integer> relevantRules = getRelevantRules();
        // Special case: all rules is relevant.
        if (relevantRules == null) {
            return true;
        }
        int targetRule = ctx.getRuleIndex();
        return relevantRules.contains(targetRule);
    }

    public boolean isRelevant(Token token){
        Set<String> relevantTokens = getRelevantTokens();
        // Special case: all tokens is relevant.
        if (relevantTokens == null) {
            return true;
        }
        return relevantTokens.contains(token.getText());
    }

    public void setParser(MyParser parser) {
        this.parser = parser;
    }
}
