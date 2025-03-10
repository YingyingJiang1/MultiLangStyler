package org.example.experiment;

import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.dom4j.DocumentException;
import org.example.StylerContainer;
import org.example.controller.Applicator;
import org.example.controller.Preprocessor;
import org.example.global.GlobalInfo;
import org.example.io.StyleFileIO;
import org.example.myException.ApplyException;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.styler.Styler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mutator {
    private final Logger logger = LoggerFactory.getLogger(Mutator.class);
    private final StylerContainer container = new StylerContainer();
    private final MyParser parser;

    private Mutator(String language) {
        this.parser = MyParserFactory.createParser(language);
    }

    public static Mutator createMutator(String language, String path) {
        var mutator = new Mutator(language);
        try {
            ProgramStyle programStyle = StyleFileIO.read(path, mutator.parser);
            for (Styler styler : mutator.container.getStylers()) {
                Style style = programStyle.getStyle(styler.getStyle().getStyleName());
                if (style != null) {
                    styler.setStyle(style);
                }
            }
            GlobalInfo.setLanguage(language);
            return mutator;
        } catch (DocumentException e) {
            mutator.logger.error("Failed to read style from {}.", path);
            return null;
        }
    }
    
    public String apply(String snippet) {
        ParseTree tree = parser.parseFromString(snippet);
        if (tree == null) {
            logger.info("Compilation error.");
            return null;
        }
        Preprocessor preprocessor = new Preprocessor();
        try {
            List<Token> tokens = Applicator.applyRules(parser, container, preprocessor);
            tokens.removeIf(token -> token.getType() == parser.getEOF());
            preprocessor.restoreState(tokens, parser);
            StringBuilder mutant = new StringBuilder();
            for (Token token : tokens) {
                mutant.append(token.getText());
            }
            return mutant.toString();
        } catch (ApplyException e) {
            logger.error("Failed to apply rules.");
            return null;
        }
    }

    public static void main(String[] args) {
        Mutator mutator = Mutator.createMutator("java", "/home/fantasia/playground/research/samples/ref.xml");
        if (mutator == null) {
            return;
        }
        String snippet = "import java.util.*;\nimport java.lang.*;\n\nclass Solution {\n\tpublic int isBored(String S) {\n\t\tString [] sentences = S.split(\"[.?!]\\\\s*\");\n\t\tint count = 0;\n\t\tfor (String sentence : sentences) {\n\t\t\tif (sentence.subSequence(0, 2).equals(\"I \")) {\n\t\t\t\tcount += 1;\n\t\t\t}\n\t\t}\n\t\treturn count;\n\t}\n}\n";
        String mutant = mutator.apply(snippet);
        System.out.println(mutant);
    }
}
