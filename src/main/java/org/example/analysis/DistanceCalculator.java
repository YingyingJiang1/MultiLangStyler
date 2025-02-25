package org.example.analysis;

import org.apache.commons.lang3.tuple.MutablePair;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.style.ComputableStyle;
import org.example.analysis.style.ComputableStyleExtractor;
import org.example.analysis.style.FeatureExtractorFactory;
import org.example.analysis.style.extractor.parser.BlankLineFeature;
import org.example.analysis.style.extractor.parser.LineLengthFeature;
import org.example.analysis.style.extractor.parser.LoopFeature;
import org.example.controller.Controller;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.utils.FileCollection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STRestartNumber;
import org.slf4j.LoggerFactory;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DistanceCalculator {

    private static final List<ComputableStyleExtractor> FEATURE_EXTRACTORS = List.of(
            new BlankLineFeature(),
            new LineLengthFeature(),
            new LoopFeature()
    );


    public static void main(String[] args) {
        String inputJsonFile = args[0];
        String codesDir = args[1];
        String outputPath = args[2];

        List<ExperimentUnit> data = DataLoader.loadData(inputJsonFile);
        Result result = new Result();
        for (ExperimentUnit unit : data) {
            String srcFile = Paths.get(codesDir, unit.result.fileName).toString();
            String targetFile = Paths.get(codesDir, unit.target.fileName).toString();
            String transformedFile = "result_tmp.java";
            try(FileOutputStream fous = new FileOutputStream(transformedFile, false);) {
                fous.write(unit.result.fileName.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            Map<String, List<Double>> beforeDistanceMap = calculateStyleDistance(srcFile, targetFile);
            Map<String, List<Double>> afterDistanceMap = calculateStyleDistance(transformedFile, targetFile);
            result.addBeforeMap(beforeDistanceMap);
            result.addAfterMap(afterDistanceMap);
        }
        result.save(outputPath);
    }

    private static boolean checkMap(Map<String, List<Double>> beforeDistanceMap, Map<String, List<Double>> afterDistanceMap) {
        boolean ret = true;
        if (beforeDistanceMap.size() != afterDistanceMap.size()) {
            System.out.println("Error: the number of styles are not the same in two maps!");
            ret = false;
        }
        Set<String> unionKey = new HashSet<>(beforeDistanceMap.keySet());
        unionKey.addAll(afterDistanceMap.keySet());
        for (String  key : unionKey) {
            if (!beforeDistanceMap.containsKey(key)) {
                System.out.println("Error: the style " + key + " is not in before maps!");
                ret = false;
                beforeDistanceMap.put(key, null);
            }
            if (!afterDistanceMap.containsKey(key)) {
                System.out.println("Error: the style " + key + " is not in after maps!");
                ret = false;
                afterDistanceMap.put(key, null);
            }
        }

        return ret;

    }

    public static Map<String, List<Double>> calculateStyleDistance(String file1, String file2) {
        Path file1Path = Paths.get(file1);
        Path file2Path = Paths.get(file2);

        Map<String, ComputableStyle> styleMap1 = getStyleMap(file1Path);
        Map<String, ComputableStyle> styleMap2 = getStyleMap(file2Path);


        Map<String, List<Double>> distanceMap = new HashMap<>();
        for (String styleName : styleMap1.keySet()) {
            if (!styleMap2.containsKey(styleName)) {
                System.err.println("The lengths of two style map are not matched.");
                System.err.println("Styles of map1: " + styleMap1.keySet());
                System.err.println("Styles of map2: " + styleMap2.keySet());
                continue;
            }
            List<Double> distanceVec = styleMap1.get(styleName).calculateDistance(styleMap2.get(styleName));
            distanceMap.put(styleName, distanceVec);
        }

        return distanceMap;
    }


    private static Map<String, ComputableStyle> getStyleMap(Path path) {
        Map<String, ComputableStyle> styleMap = new HashMap<>();

        // Extract computable style from style objects.
        FileCollection files = new FileCollection();
        files.add(path);
        ProgramStyle programStyle = new Controller().extractStyle(files);

        for (Style style: programStyle.getStyles()) {
            ComputableStyleExtractor featureExtractor = FeatureExtractorFactory.createExtractor(style.getStyleName());
            if (featureExtractor != null) {
                featureExtractor.toComputableStyle(style, styleMap);
            }
        }

        // Extract computable style from AST.
        try {
            MyParser parser = MyParserFactory.createParser("java");
            parser.parse(path);
            for (ComputableStyleExtractor extractor : FEATURE_EXTRACTORS) {
                extractor.toComputableStyle(parser, styleMap);
            }

        } catch (IOException e) {
            LoggerFactory.getLogger(DistanceCalculator.class).error(e.getMessage(), e);
        }

        return styleMap;
    }

    private static class Result {
        Map<String, List<List<Double>>> beforeResults = new HashMap<>();
        Map<String, List<List<Double>>> afterResults = new HashMap<>();

        public void addBeforeMap(Map<String, List<Double>> distanceMap) {
            for (String styleName : distanceMap.keySet()) {
                if (!beforeResults.containsKey(styleName)) {
                    beforeResults.put(styleName, new ArrayList<>());
                }
                beforeResults.get(styleName).add(distanceMap.get(styleName));
            }
        }

        public void addAfterMap(Map<String, List<Double>> distanceMap) {
            for (String styleName : distanceMap.keySet()) {
                if (!afterResults.containsKey(styleName)) {
                    afterResults.put(styleName, new ArrayList<>());
                }
                afterResults.get(styleName).add(distanceMap.get(styleName));
            }
        }

        public void save(String outputPath) {
            // 创建Excel工作簿
            Workbook workbook = new XSSFWorkbook();

            // 遍历beforeResults和afterResults的所有key
            for (String styleName : beforeResults.keySet()) {
                Sheet sheet = workbook.createSheet(styleName);

                // 获取before和after的列表
                List<List<Double>> beforeList = beforeResults.get(styleName);
                List<List<Double>> afterList = afterResults.get(styleName);


                // 创建表头
                sheet.createRow(0).createCell(0).setCellValue(styleName);
                Row headerRow = sheet.createRow(1);
                headerRow.createCell(0).setCellValue("Before Distance");
                headerRow.createCell(1).setCellValue("After Distance");

                // 将结果填入表格
                int rowIndex = 2;  // 从第二行开始填充数据
                for (int i = 0; i < beforeList.size(); i++) {
                    Row row = sheet.createRow(rowIndex++);

                    // 填充Before Distance
                    Cell beforeCell = row.createCell(0);
                    Cell afterCell = row.createCell(1);
                    beforeCell.setCellValue(beforeList.get(i) == null ? "null" : listToString(beforeList.get(i)));
                    afterCell.setCellValue(afterList.get(i) == null ? "null" : listToString(afterList.get(i)));
                }
            }

            // 写入文件
            try (FileOutputStream fileOut = new FileOutputStream(outputPath)) {
                workbook.write(fileOut);
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String listToString(List<Double> list) {
            StringBuilder sb = new StringBuilder();
            for (Double val : list) {
                sb.append(val).append(", ");
            }
            return !sb.isEmpty() ? sb.substring(0, sb.length() - 2) : "";  // 去掉最后的 ", "
        }
    }
}
