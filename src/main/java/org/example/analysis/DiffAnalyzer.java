package org.example.analysis;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import org.example.analysis.io.input.InputGenerator;
import org.example.controller.Controller;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.StyleFeatureFactory;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.io.InputPair;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.utils.FileCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffAnalyzer {
    public static Logger logger =LoggerFactory.getLogger(DiffAnalyzer.class);

    static String dir = "D:\\jyy\\科研\\style\\style-transformation\\dataset\\data\\codes";
    public static final List<StyleFeature> styleFeatures = List.of(

    );
    public static String language = "java";

    public static void main(String[] args) throws IOException {
        String metaFile = "D:\\jyy\\科研\\style\\style-transformation\\dataset\\data\\meta.json";
        List<InputPair> programPairs = InputGenerator.generateHumanLLMPairs(metaFile);
        Map<String, Table> result = analyze(programPairs, "human-llm.json");
    }


    public static Map<String, Table> analyze(List<InputPair> programPairs, String resultFileName) throws IOException {
        String tempResultFile = "tmp_result.json";
        FileOutputStream out = new FileOutputStream(tempResultFile, true);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator generator = objectMapper.getFactory().createGenerator(out);
        SequenceWriter tmpWriter = objectMapper.writer().writeValuesAsArray(generator);

        Map<String, Table> disOfStyles = new HashMap<>();
        int count = 0;
        try {
            for (InputPair pair : programPairs) {
                ++count;
                logger.info("Analyzing {} pair, problem number:{}", count, pair.getProblemNumber());
                String problemNumber = pair.getProblemNumber();
                Path path1 = Paths.get(dir, problemNumber, pair.getFile1());
                Path path2 = Paths.get(dir, problemNumber, pair.getFile2());
                // extract style
                FileCollection files1 = new FileCollection();
                files1.add(path1);
                ProgramStyle programStyle1 = new Controller().extractStyle(files1);
                FileCollection files2 = new FileCollection();
                files2.add(path2);
                ProgramStyle programStyle2 = new Controller().extractStyle(files2);


                // transform a program style into a styl vector.
                Map<String, StyleVector> styleVecs1 = new HashMap<>();
                Map<String, StyleVector> styleVecs2 = new HashMap<>();
                extractStyleFeatures(programStyle1.getStyles(), styleVecs1);
                extractStyleFeatures(programStyle2.getStyles(), styleVecs2);

                // extract specific type of styles which can not be gained from previous step.
                MyParser parser1 = MyParserFactory.createParser(language);
                parser1.parse(path1);
                MyParser parser2 = MyParserFactory.createParser(language);
                parser2.parse(path2);
                for (StyleFeature  feature : styleFeatures) {
                    feature.toFeatureVector(parser1, styleVecs1);
                    feature.toFeatureVector(parser2, styleVecs2);
                }

                // 写入中间结果
                tmpWriter.write(styleVecs1);
                tmpWriter.write(System.lineSeparator());
                tmpWriter.write(styleVecs1);
                tmpWriter.write(System.lineSeparator());


                // 为每种风格计算每一对程序对之间的风格距离向量，并以表格形式存储
                for (String styleName : styleVecs1.keySet()) {
                    StyleVector vec1 = styleVecs1.get(styleName);
                    if (styleVecs2.get(styleName) != null) {
                        Map<String,Double> disOfAttrs = styleVecs1.get(styleName).calculateDistance(styleVecs2.get(styleName));
                        disOfStyles.putIfAbsent(styleName, Table.create(styleName));
                        Table table = disOfStyles.get(styleName);
                        for (Map.Entry<String, Double> entry : disOfAttrs.entrySet()) {
                            Column<Double> column = DoubleColumn.create(entry.getKey(), entry.getValue());
                            table.addColumns(column);
                        }
                    }
                }
            }
        } catch (Exception e) {
            LoggerFactory.getLogger(DiffAnalyzer.class).error("Analysis terminated at the {}/{} pair.", count, programPairs.size(), e);
        }

        logger.info("Get style distance vector of program pairs on {} style types. Result are saved in {}", disOfStyles.size(), resultFileName);
        new ObjectMapper().writeValue(new FileOutputStream(resultFileName), disOfStyles.values());
        return disOfStyles;
    }

    private static List<InputPair> generatePairs(String file) {
        List<InputPair> inputPairs = new ArrayList<>();
        return inputPairs;
    }


    private static void extractStyleFeatures(List<Style> styles, Map<String, StyleVector> styleFeatures) {
        for (Style style: styles) {
            StyleFeature styleFeature = StyleFeatureFactory.createStyleDiff(style.getStyleName());
            if (styleFeature != null) {
                styleFeature.toFeatureVector(style, styleFeatures);
            }
        }
    }



}
