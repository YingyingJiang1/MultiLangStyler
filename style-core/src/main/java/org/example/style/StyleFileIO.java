package org.example.style;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.example.controller.StylerContainer;
import org.example.parser.common.MyParser;
import org.example.style.rule.*;
import org.example.styler.Styler;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;
import org.example.styler.structure.style.StructureStyle;
import org.slf4j.Logger;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/20 22:15
 */
public class StyleFileIO {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(StyleFileIO.class);

    public static ProgramStyle read(String file, MyParser parser) {
        ProgramStyle programStyle = new ProgramStyle();
        final List<Styler> stylers = new StylerContainer().getStylers();
        stylers.forEach(styler -> programStyle.add(styler.getStyle()));
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(file));
            Element root = document.getRootElement();
            programStyle.parseElement(root, parser);
            for (Style style : programStyle.getStyles()) {
                style.fillStyle();
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

            File dir = new File(file).getParentFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }
            XMLWriter writer = new XMLWriter(new FileWriter(new File(file)),
                    OutputFormat.createPrettyPrint());
            writer.write(document);
            writer.close();
            logger.info("style result saved in:{}", file);
        } catch (IOException e) {
            logger.error("write style file error. target path:{}", file, e);
        }
    }


    private static Map<Integer, Map<Integer, Integer>> getStructureStyleRuleMap(StructureStyle style) {
        RuleSet ruleset = style.getRuleSet();
        if (ruleset instanceof StatisticRuleSet statisticRuleSet) {
            Map<StyleContext, Map<StyleProperty, Integer>> ruleMap = statisticRuleSet.getRuleMap();
            Map<Integer, Map<Integer, Integer>> statisticRuleMap = new HashMap<>();
            for (Map.Entry<StyleContext, Map<StyleProperty, Integer>> entry : ruleMap.entrySet()) {
                int cnumber = ((StructPreferenceContext) entry.getKey()).getStructID();
                Map<Integer, Integer> propertyMap = new HashMap<>();
                for (Map.Entry<StyleProperty, Integer> propertyEntry : entry.getValue().entrySet()) {
                    propertyMap.put(((StructPreferenceProperty) propertyEntry.getKey()).getPreferenceIndex(), propertyEntry.getValue());
                }
                statisticRuleMap.computeIfAbsent(cnumber, k -> propertyMap);
            }
            return statisticRuleMap;
        }
        return null;
    }

    private static Map<Integer, Map<Integer, Integer>> getStyleStatisticRuleMap(Style style) {
        Map<StyleContext, Integer> contextNumberMap = new HashMap<>();
        Map<StyleProperty, Integer> propertyNumberMap = new HashMap<>();
        int contextNumber = 1, propertyNumber = 1;
        for (StyleRule rule : style.getRules()) {
            if (!contextNumberMap.containsKey(rule.getStyleContext())) {
                contextNumberMap.put(rule.getStyleContext(), contextNumber++);
            }
            if (!propertyNumberMap.containsKey(rule.getStyleProperty())) {
                propertyNumberMap.put(rule.getStyleProperty(), propertyNumber++);
            }
        }

        RuleSet ruleset = style.getRuleSet();
        if (ruleset instanceof StatisticRuleSet statisticRuleSet) {
            Map<StyleContext, Map<StyleProperty, Integer>> ruleMap = statisticRuleSet.getRuleMap();
            Map<Integer, Map<Integer, Integer>> statisticRuleMap = new HashMap<>();
            for (Map.Entry<StyleContext, Map<StyleProperty, Integer>> entry : ruleMap.entrySet()) {
                int cnumber = contextNumberMap.get(entry.getKey());
                Map<Integer, Integer> propertyMap = new HashMap<>();
                for (Map.Entry<StyleProperty, Integer> propertyEntry : entry.getValue().entrySet()) {
                    propertyMap.put(propertyNumberMap.get(propertyEntry.getKey()), propertyEntry.getValue());
                }
                statisticRuleMap.computeIfAbsent(cnumber, k -> propertyMap);
            }
            return statisticRuleMap;
        }
        return null;
    }

    public static void writeStatistic(ProgramStyle programStyle, String file) {
        List<Style> styles = programStyle.getStyles();
        Map<String, Map<Integer, Map<Integer, Integer>>> styleMap = new HashMap<>();
        // 为style context 和style property编号
        for (Style style : styles) {
            if (style instanceof StructureStyle structureStyle) {
                styleMap.put(style.getStyleName(), getStructureStyleRuleMap(structureStyle));
            } else {
                styleMap.put(style.getStyleName(), getStyleStatisticRuleMap(style));
            }
        }


        try {
            // 创建xml文件并写入内容
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("program_style");
            for (String styleName : styleMap.keySet())  {
                Element styleEle = root.addElement("style");
                styleEle.addAttribute("name", styleName);
            }
            File dir = new File(file).getParentFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }
            XMLWriter writer = new XMLWriter(new FileWriter(new File(file)),
                    OutputFormat.createPrettyPrint());
            writer.write(document);
            writer.close();

        } catch (Exception e) {
            logger.error("write statistic file error. target path:{}", file, e);
        }
    }

}
