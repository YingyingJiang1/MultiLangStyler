package org.example.analysis;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.analysis.feature.ParserFeatureExtractor;
import org.example.analysis.feature.impl.parser.BlankLineFeature;
import org.example.analysis.feature.impl.parser.LineLengthFeature;
import org.example.analysis.io.input.InputGenerator;
import org.example.controller.Controller;
import org.example.analysis.feature.StyleFeatureExtractor;
import org.example.analysis.feature.FeatureExtractorFactory;
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
import java.util.*;

public class DiffAnalyzer {
    public static Logger logger =LoggerFactory.getLogger(DiffAnalyzer.class);

    static String dir = "D:\\jyy\\科研\\style\\style-transformation\\dataset\\data\\codes";
    public static final List<ParserFeatureExtractor> FEATURE_EXTRACTORS = List.of(
            new BlankLineFeature(),
            new LineLengthFeature()
    );
    public static String language = "java";

    public static void main(String[] args) throws IOException {
        String metaFile = "D:\\jyy\\科研\\style\\style-transformation\\dataset\\data\\meta.json";
        List<InputPair> programPairs = null;
        List<Table> result = null;

        programPairs = InputGenerator.generateHumanLLMPairs(metaFile);
        System.out.println("human-llm pairs: " + programPairs.size());
        result = analyze(programPairs);
        writeResult2excel(result, "human-llm-result");

        programPairs = InputGenerator.generateHumanPairs(metaFile);
        System.out.println("human pairs: " + programPairs.size());
//        result = analyze(programPairs);
//        writeResult2excel(result, "human-human-result");

        programPairs = InputGenerator.generateLLMPairs(metaFile);
        System.out.println("llm pairs: " + programPairs.size());
//        result = analyze(programPairs);
//        writeResult2excel(result, "llm-llm-result");

    }


    public static List<Table> analyze(List<InputPair> programPairs) throws IOException {
        String tempResultFile = "tmp_result.json";
        FileOutputStream out = new FileOutputStream(tempResultFile, true);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator generator = objectMapper.getFactory().createGenerator(out);
        SequenceWriter tmpWriter = objectMapper.writer().writeValuesAsArray(generator);

        Map<String, Map<String, List<Double>>> disOfStyles = new HashMap<>();
        int count = 0;
        try {
            for (InputPair pair : programPairs) {
                ++count;
                logger.info("Analyzing {} pair, problem number:{}", count, pair.getProblemNumber());

                String problemNumber = pair.getProblemNumber();
                Path path1 = Paths.get(dir, problemNumber, pair.getFile1());
                Path path2 = Paths.get(dir, problemNumber, pair.getFile2());
                Map<String, StyleVector> style2vecMap1 = new HashMap<>();
                Map<String, StyleVector> style2vecMap2 = new HashMap<>();

                extractStyleVectorFromStyleObj(path1, style2vecMap1);
                extractStyleVectorFromStyleObj(path2, style2vecMap2);
                extractStyleVectorFromTree(path1, style2vecMap1);
                extractStyleVectorFromTree(path2, style2vecMap2);

                // 为每种风格计算每一对程序对之间的风格距离向量，并以表格形式存储
                for (String styleName : style2vecMap1.keySet()) {
                    StyleVector vec1 = style2vecMap1.get(styleName);
                    if (style2vecMap2.get(styleName) != null) {
                        Map<String,Double> disOfAttrs = style2vecMap1.get(styleName).calculateDistance(style2vecMap2.get(styleName));
                        Map<String, List<Double>> column = disOfStyles.computeIfAbsent(styleName, k -> new HashMap<>());
                        for (Map.Entry<String, Double> entry : disOfAttrs.entrySet()) {
                            column.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(entry.getValue());
                        }
                    }
                }
            }
        } catch (Exception e) {
            LoggerFactory.getLogger(DiffAnalyzer.class).error("Analysis terminated at the {}/{} pair.", count, programPairs.size(), e);
        }

        List<Table> result = new ArrayList<>();
        for (Map.Entry<String, Map<String, List<Double>>> entry : disOfStyles.entrySet()) {
            Table table = Table.create(entry.getKey());
            try {
                for (Map.Entry<String, List<Double>> distanceEntry : entry.getValue().entrySet()) {
                    Column<Double> column = DoubleColumn.create(distanceEntry.getKey(), distanceEntry.getValue().toArray(Double[]::new));
                    table.addColumns(column);
                }
            } catch (Exception e) {
                logger.error("Failed to create table {}.", table.name());
            }
            result.add(table);
        }


        logger.info("Get style distance vector of program pairs on {} style types.", disOfStyles.size());
        return result;
    }

    private static void extractStyleVectorFromStyleObj(Path path, Map<String, StyleVector> style2vecMap) {
        FileCollection files = new FileCollection();
        files.add(path);
        ProgramStyle programStyle = new Controller().extractStyle(files);

        for (Style style: programStyle.getStyles()) {
            StyleFeatureExtractor featureExtractor = FeatureExtractorFactory.createExtractor(style.getStyleName());
            if (featureExtractor != null) {
                featureExtractor.toFeatureVector(style, style2vecMap);
            }
        }
    }
    private static void extractStyleVectorFromTree(Path path, Map<String, StyleVector> style2vecMap) throws IOException {
        MyParser parser = MyParserFactory.createParser(language);
        parser.parse(path);
        for (ParserFeatureExtractor feature : FEATURE_EXTRACTORS) {
            feature.toFeatureVector(parser, style2vecMap);
        }
    }


    public static void writeResult2excel(List<Table> result, String resultFileName) {
        // 创建一个工作簿
        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(resultFileName + ".xlsx")) {

            // 遍历每个Table并将其写入不同的工作表
            for (Table table : result) {
                // 获取表名（作为工作表名称）
                String sheetName = table.name();

                // 创建工作表
                Sheet sheet = workbook.createSheet(sheetName);

                // 添加表头（列名）
                Row headerRow = sheet.createRow(0);
                for (int i = 0; i < table.columnCount(); i++) {
                    headerRow.createCell(i).setCellValue(table.column(i).name());
                }

                // 填充数据
                try {
                    for (int i = 0; i < table.rowCount(); i++) {
                        Row row = sheet.createRow(i + 1);
                        for (int j = 0; j < table.columnCount(); j++) {
                            Object cellValue = table.get(i, j);
                            row.createCell(j).setCellValue(cellValue.toString());
                        }
                    }
                } catch (Exception e) {
                    logger.error("Failed to write table {}.", table.name());
                }

            }

            // 将工作簿写入文件
            workbook.write(fileOut);
            logger.info("Successfully write result to {}", resultFileName);
        } catch (IOException e) {
            logger.error("Failed to write result to {}", resultFileName, e);
        }
    }

}
