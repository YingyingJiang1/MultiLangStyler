package org.example.controller;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.Configuration;
import org.example.global.GlobalInfo;
import org.example.io.StyleFileIO;
import org.example.parser.common.*;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.CommonStyle;
import org.example.style.ProgramStyle;
import org.example.style.SelfStyleManager;
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
    protected ProgramStyle targetProgramStyle, selfProgramStyle;

    public Controller(Configuration conf) {
        this.conf = conf;
        GlobalInfo.setConf(this.conf);
    }

    public Controller() {}


    public ProgramStyle execute() {
        try {
            // extract target style from existing style file or source codes.
            if (conf.styleFile != null) {
                parser = MyParserFactory.createParser(GlobalInfo.getLanguage());
                targetProgramStyle = StyleFileIO.read(conf.styleFile, parser);
            } else {
                targetProgramStyle = extractStyle(conf.extractionCollection);
            }
            // Extract style of src itself, this must precede the style application, because it will change curPath and parser.
            selfProgramStyle = extractStyle(conf.applicationCollection);
            SelfStyleManager.addStyle(conf.applicationCollection, selfProgramStyle);

            if (conf.getStyleOutPath() != null) {
                StyleFileIO.write(targetProgramStyle, conf.getStyleOutPath(), parser);
                if (conf.isSaveSelfStyle) {
                    StyleFileIO.write(selfProgramStyle, conf.getStyleOutPath().replace(".xml", "-self.xml"), parser);
                }
            }

            applyStyle(conf.applicationCollection);

            return targetProgramStyle;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    private void applyStyle(FileCollection files) {
        applyInitialize(files, targetProgramStyle);
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

                Preprocessor preprocessor = new Preprocessor();
                List<Token> tokens = Applicator.applyRules(parser, container, preprocessor);
                code = toString(tokens, preprocessor);
                saveApplyResult(code);
            } catch (Exception e) {
                logger.error("Failed to apply style rules to file: {}", files.getFilePath(i));
                logger.error("Exception details:", e);
            }
        }
        applyFinalize();
    }

    public ProgramStyle extractStyle(FileCollection files) {
        extractInitialize(files);

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


    private void applyInitialize(FileCollection files, ProgramStyle programStyle) {
        // Fill style object of stylers.
        if (programStyle != null) {
            if (container == null) {
                container = new StylerContainer();
            }

            for (Styler styler : container.getStylers()) {
                Style style = programStyle.getStyle(styler.getStyle().getStyleName());
                if (style != null) {
                    styler.setStyle(style);
                }
            }
        }

        for (Styler styler : container.getStylers()) {
            if (styler.getStyle() instanceof CommonStyle commonStyle) {
                commonStyle.srcFileCollection = files;
            }
        }
    }

    private void applyFinalize() {
    }


    private void extractInitialize(FileCollection files) {
        // Make the style attribution of all stylers in empty state.
        container = new StylerContainer();
        for (Styler styler : container.getStylers()) {
            if (styler.getStyle() instanceof CommonStyle commonStyle) {
                commonStyle.targetFileCollection = files;
            }
        }
    }

    private void extractFinalize() {
        for (Styler styler : container.getStylers()) {
            styler.extractFinalize();
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

    private void fillStylers(ProgramStyle programStyle) {

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
