package org.example.controller;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.Configuration;
import org.example.StylerContainer;
import org.example.global.GlobalInfo;
import org.example.io.StyleFileIO;
import org.example.parser.common.*;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.ProgramStyle;
import org.example.style.SelfStyle;
import org.example.style.Style;
import org.example.styler.Styler;
import org.example.utils.FileCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/13 20:59
 */
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private MyParser parser;
    private StylerContainer container = null;
    protected Configuration conf;
    Path curPath = null;

    public Controller(Configuration conf) {
        this.conf = conf;
    }

    public Controller() {}


    public ProgramStyle execute() {
        try {
            ProgramStyle programStyle = null;
            // extract style from existing style file or source codes.
            if (conf.styleFile != null) {
                programStyle = StyleFileIO.read(conf.styleFile, parser);
                init(programStyle);
            } else {
                programStyle = extractStyle(conf.extractionCollection);
            }

            if (conf.getStyleOutPath() != null) {
                StyleFileIO.write(programStyle, conf.getStyleOutPath(), parser);
            }

            String code = applyStyle(conf.applicationCollection);
            saveApplyResult(code);
//            Path selfStylePath = Paths.get(Paths.get(conf.getStyleOutPath()).getParent().toString(), "self-style.xml");
//            StyleFileIO.write(SelfStyle.getProgramStyle(), selfStylePath.toString(), parser);
            return programStyle;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public void applyStyle(FileCollection files, ProgramStyle programStyle) {
        init(programStyle);
        applyStyle(files);
    }

    private String applyStyle(FileCollection files) {
        applyInitialize();
        String code = null;
        for (int i = 0; i < files.size(); i++) {
            try {
                curPath = Paths.get(files.getFilePath(i));
                String language = curPath.getFileName().toString().split("\\.")[1].toLowerCase();
                GlobalInfo.setLanguage(language);
                parser = MyParserFactory.createParser(language);
                ParseTree tree = parser.parse(curPath);
                if (tree == null) {
                    logger.info("Failed to apply style rules to file '{}' because of compilation error.", curPath.toString());
                    continue;
                }

                SelfStyle.extractStyle(curPath);

                Preprocessor preprocessor = new Preprocessor();
                List<Token> tokens = Applicator.applyRules(parser, container, preprocessor);
                code = toString(tokens, preprocessor);
            } catch (Exception e) {
                logger.error("Failed to apply style rules to file: {}", files.getFilePath(i));
                logger.error("Exception details:", e);
            }
        }
        applyFinalize();
        return code;
    }

    public ProgramStyle extractStyle(FileCollection files) {
        extractInitialize();

        for (int i = 0; i < files.size(); i++) {
            try {
                curPath = Paths.get(files.getFilePath(i));
                String language = curPath.getFileName().toString().split("\\.")[1].toLowerCase();
                GlobalInfo.setLanguage(language);
                parser = MyParserFactory.createParser(language);
                ParseTree tree = parser.parse(curPath);
                if (tree == null) {
                    logger.info("Failed to extract style rules from file '{}' because of compilation error.", curPath.toString());
                    continue;
                }

                Preprocessor preprocessor = new Preprocessor();
                Extractor.extractRules(parser, container, preprocessor);

            } catch (Exception e) {
                logger.error("Failed to extract style rules from file: {}", files.getFilePath(i), e);
            }
        }

        extractFinalize();
        return combineStyle();
    }


    private void applyInitialize() {

    }

    private void applyFinalize() {
    }


    private void extractInitialize() {
        init(null);
        for (Styler styler : container.getStylers()) {
            styler.reset();
        }
    }

    private void extractFinalize() {
        for (Styler styler : container.getStylers()) {
            styler.doFinalize();
        }
    }

    private ProgramStyle combineStyle() {
        ProgramStyle programStyle = new ProgramStyle();
        for (Styler styler : container.getStylers()) {
            programStyle.add(styler.getStyle());
        }
        return programStyle;
    }

    private String toString(List<Token> tokens, Preprocessor preprocessor) {
        StringBuilder builder = new StringBuilder();
        if (tokens.get(tokens.size() - 1).getType() == parser.getEOF()) {
            tokens = tokens.subList(0, tokens.size() - 1);
        }
        preprocessor.restoreState(tokens, parser);
        for (Token token : tokens) {
            builder.append(token.getText());
        }
        return builder.toString();
    }


    private void init(ProgramStyle programStyle) {
        container = new StylerContainer();
        if (programStyle != null) {
            for (Styler styler : container.getStylers()) {
                Style style = programStyle.getStyle(styler.getStyle().getStyleName());
                if (style != null) {
                    styler.setStyle(style);
                }
            }
        }
    }


    private void saveApplyResult(String code) throws IOException {
        if (code == null) {
            return;
        }
        String resPath = conf.getCodeOutPath(curPath.toString());
        if (resPath != null) {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resPath)))) {
                writer.write(code);
            }
        }

    }


}
