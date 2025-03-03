package org.example.io;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.example.Configuration;
import org.example.StylerContainer;
import org.example.parser.common.MyParser;
import org.example.parser.java.antlr.JavaParser;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.style.rule.StyleContext;
import org.example.styler.Styler;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/20 22:15
 */
public class StyleFileIO {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(StyleFileIO.class);

    public static ProgramStyle read(String file, MyParser parser) throws DocumentException {
        ProgramStyle programStyle = new ProgramStyle();
        for (Styler styler : new StylerContainer().getStylers()) {
            programStyle.add(styler.getStyle());
        }
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(file));
            Element root = document.getRootElement();
            programStyle.parseElement(root, parser);
            for (Style style : programStyle.getStyles()) {
                List<StyleContext> removedContexts = style.filterRules();
                if (removedContexts != null) {
                    for (StyleContext context : removedContexts) {
                        logger.warn("the rule of {} style with a style context {} has been removed, because you configured more than one property for the same context.",
                                style.getStyleName(), context);
                    }
                }
            }
        } catch (DocumentException e) {
            logger.error("read style file error. Target path: {}", file);
        }
        return programStyle;
    }

    public static void write(ProgramStyle programStyle, String file, MyParser parser) {
        if (programStyle == null) {
            logger.info("no style to save in file {}, because `programStyle` is null.", file);
            return;
        }
        try {
            // 创建xml文件并写入内容
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("program_style");
            programStyle.addElement(root, parser);

            XMLWriter writer = new XMLWriter(new FileWriter(new File(file)),
                    OutputFormat.createPrettyPrint());
            writer.write(document);
            writer.close();
            logger.info("style result saved in:{}", file);
        } catch (IOException e) {
            logger.error("write style file error. target path:{}", file, e);
        }
    }

}
