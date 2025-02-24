package org.example.analysis;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.analysis.style.ParserFeatureExtractor;
import org.example.analysis.style.extractor.parser.BlankLineFeature;
import org.example.analysis.style.extractor.parser.LineLengthFeature;
import org.example.analysis.style.extractor.parser.LoopFeature;
import org.example.analysis.io.input.InputGenerator;
import org.example.controller.Controller;
import org.example.analysis.style.FeatureExtractorFactory;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.io.InputPair;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.utils.FileCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.tablesaw.api.Table;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DiffAnalyzer {
    public static Logger logger =LoggerFactory.getLogger(DiffAnalyzer.class);

//    static String dir = "D:\\jyy\\科研\\style\\style-transformation\\dataset\\data\\codes";
    static String dir = "C:\\Users\\dell\\jyy\\科研\\code-style-transformation\\dataset\\data\\codes";

    public static final List<ParserFeatureExtractor> FEATURE_EXTRACTORS = List.of(
            new BlankLineFeature(),
            new LineLengthFeature(),
            new LoopFeature()
    );
    public static String language = "java";

    public static void main(String[] args) throws IOException {

    }

    private static void analyzeAll() throws IOException {
        //        String metaFile = "D:\\jyy\\科研\\style\\style-transformation\\dataset\\data\\meta.json";
        String metaFile = "C:\\Users\\dell\\jyy\\科研\\code-style-transformation\\dataset\\data\\meta.json";

        List<InputPair> programPairs = null;
        List<Table> result = null;
        int authorPairs = 0;

        programPairs = InputGenerator.generateHumanLLMPairs(metaFile);
        authorPairs = calculateAuthorGroup(programPairs);
        System.out.println("human-llm pairs: " + programPairs.size());
        System.out.println("human-llm author pairs: " + authorPairs);
//        result = analyze(programPairs);
//        writeResult2excel(result, "human-llm-result");
//        saveFinalResult(result, programPairs.size(), "human-llm-final-result");

        programPairs = InputGenerator.generateLLMPairs(metaFile);
        authorPairs = calculateAuthorGroup(programPairs);
        System.out.println("llm pairs: " + programPairs.size());
        System.out.println("llm author pairs: " + authorPairs);
//        result = analyze(programPairs);
//        writeResult2excel(result, "llm-llm-result");


        programPairs = InputGenerator.generateHumanPairs(metaFile);
        authorPairs = calculateAuthorGroup(programPairs);
        System.out.println("human pairs: " + programPairs.size());
        System.out.println("human author pairs: " + authorPairs);
//        result = analyze(programPairs);
//        writeResult2excel(result, "human-human-result");
    }


    private static int calculateAuthorGroup(List<InputPair> pairs) {
        Set<String> authorGroup = new HashSet<>();
        for (InputPair pair : pairs) {
            String group = Arrays.toString(pair.getAuthors());
            String reversedGroup = Arrays.toString(new String[]{pair.getAuthors()[1], pair.getAuthors()[0]});
            if (!authorGroup.contains(group) && !authorGroup.contains(reversedGroup)) {
                authorGroup.add(group);
            }
        }
        return authorGroup.size();
    }

//    private static void calculateAvgDistance(List<Table> result, int totalPair, String filename) {
//        Map<String, Double> avgDistanceMap = new HashMap<>();
//        for (Table table : result) {
//            String styleType = table.name();
//            for (int i = 0; i < table.rowCount(); i++) {
//                Row row = table.row(i);
//                for (int j = 0; j < row.columnCount(); j++) {
//
//                }
//            }
//        }
//    }

//    private static void saveFinalResult(List<Table> result, int totalPair, String filename) {
//
//        List<String> styleTypes = new ArrayList<String>();
//        Map<String, List<Integer>> statistics = Map.of(
//                "consistency", new ArrayList<Integer>(),
//                "inconsistency", new ArrayList<Integer>(),
//                "no style", new ArrayList<Integer>()
//        );
//        for (Table table : result) {
//            int consistency = 0, inconsistency = 0;
//            for (int i = 0; i < table.rowCount(); i++) {
//                Row row = table.row(i);
//                List<Double> attrDistances = new ArrayList<Double>();
//                for (int j = 0; j < row.columnCount(); j++) {
//                    if (row.getDouble(j) >= 0) {
//                        attrDistances.add(row.getDouble(j));
//                    }
//                }
//                double normalizedMod = Math.sqrt(attrDistances.stream().reduce(0.0, (sum, d) -> Math.pow(d, 2))) / Math.sqrt(attrDistances.size());
//                if (normalizedMod == 0) {
//                    consistency++;
//                } else {
//                    inconsistency++;
//                }
//            }
//            int noStyle = totalPair - table.rowCount();
//            styleTypes.add(table.name());
//            statistics.get("consistency").add(consistency);
//            statistics.get("inconsistency").add(inconsistency);
//            statistics.get("no style").add(noStyle);
//        }
//
//        Table finalResult = Table.create("final-result")
//                        .addColumns(
//
//                                StringColumn.create("style type", styleTypes),
//                                DoubleColumn.create("consistency", statistics.get("consistency")),
//                                DoubleColumn.create("inconsistency", statistics.get("inconsistency")),
//                                DoubleColumn.create("no style", statistics.get("no style"))
//                        );
//        finalResult.write().csv(filename + ".csv");
//
//    }

    private static PairDistance calculateStyleDis(InputPair pair, List<String> allStyles) throws IOException {
        Map<String, DistanceVec> style2disMap = new HashMap<>();
        String problemNumber = pair.getProblemId();
        Path path1 = Paths.get(dir, problemNumber, pair.getFile1());
        Path path2 = Paths.get(dir, problemNumber, pair.getFile2());
        Map<String, StyleVector> style2vecMap1 = new HashMap<>();
        Map<String, StyleVector> style2vecMap2 = new HashMap<>();
        initStyleMap(style2vecMap1);
        initStyleMap(style2vecMap2);

        extractStyleVectorFromStyleObj(path1, style2vecMap1);
        extractStyleVectorFromStyleObj(path2, style2vecMap2);
        extractStyleVectorFromTree(path1, style2vecMap1);
        extractStyleVectorFromTree(path2, style2vecMap2);

        // 为每种风格计算每一对程序对之间的风格距离向量，并以表格形式存储
        for (String styleName : style2vecMap1.keySet()) {
            StyleVector vec1 = style2vecMap1.get(styleName);
            StyleVector vec2 = style2vecMap2.get(styleName);
            if (vec2 == null) {
                System.out.println(styleName);
            }
            DistanceVec distanceVec = new DistanceVec(vec1.calculateDistance(vec2));
            style2disMap.put(styleName, distanceVec);
        }

        for (String styleName : allStyles) {
            if (!style2disMap.containsKey(styleName)) {
                style2disMap.put(styleName, new DistanceVec(null));
            }
        }

        PairDistance pairDistance = new PairDistance(pair.getProblemId(),
                pair.getAuthor1(), pair.getAuthor2(),
                Paths.get(pair.getFile1()).getFileName().toString(), Paths.get(pair.getFile2()).getFileName().toString(),
                style2disMap);
        return pairDistance;
    }


    public static List<PairDistance> calculateStyleDis(List<InputPair> programPairs, List<String> allStyles) throws IOException {

        List<PairDistance> result = new ArrayList<>();
        int count = 0;
        try {
            for (InputPair pair : programPairs) {
                ++count;
                logger.info("Analyzing {} pair, problem number:{}", count, pair.getProblemId());
                PairDistance styleDis = calculateStyleDis(pair, allStyles);
                result.add(styleDis);
            }
        } catch (Exception e) {
            LoggerFactory.getLogger(DiffAnalyzer.class).error("Analysis terminated at the {}/{} pair.", count, programPairs.size(), e);
        }
        return result;
    }

    private static void initStyleMap(Map<String, StyleVector> styleMap) {
        List<String> styleTypes = StyleType.getAllStyleTypes();
        for (String type : styleTypes) {
            if (!styleMap.containsKey(type)) {
                styleMap.put(type, new StyleVector());
            }
        }
    }

    private static void extractStyleVectorFromStyleObj(Path path, Map<String, StyleVector> style2vecMap) {
        FileCollection files = new FileCollection();
        files.add(path);
        ProgramStyle programStyle = new Controller().extractStyle(files);

        for (Style style: programStyle.getStyles()) {
            ComputableStyleExtractor featureExtractor = FeatureExtractorFactory.createExtractor(style.getStyleName());
            if (featureExtractor != null) {
                featureExtractor.toComputableStyle(style, style2vecMap);
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

   private static void appendResult2excel(PairDistance pairDistance, Workbook workbook) {
        Map<String, DistanceVec> styleDistance = pairDistance.distanceMap;
       for (Map.Entry<String, DistanceVec> entry : styleDistance.entrySet()) {
           try {
               // 获取工作表名称
               String sheetName = entry.getKey();
               Sheet sheet = workbook.getSheet(sheetName);

               List<String> headers = entry.getValue().getNames();
               if (sheet == null) {
                   sheet = workbook.createSheet(sheetName);
                   Row headRow = sheet.createRow(0);
                   int index = 0;
                   headRow.createCell(index++).setCellValue("problem_id");
                   headRow.createCell(index++).setCellValue("author1");
                   headRow.createCell(index++).setCellValue("author2");
                   for (int i = index; i < headers.size(); i++) {
                       headRow.createCell(i).setCellValue(headers.get(i));
                   }
               }

               // 添加一行数据
               Row row = sheet.createRow(sheet.getLastRowNum() + 1);
               int index = 0;
               row.createCell(index++).setCellValue(pairDistance.problemId);
               row.createCell(index++).setCellValue(pairDistance.author1);
               row.createCell(index++).setCellValue(pairDistance.author2);
               for (String header : headers) {
                   double value = entry.getValue() == null ? -1.0 : entry.getValue().getValue(header);
                   row.createCell(index++).setCellValue(value);
               }
           } catch (Exception e) {
               logger.error("Failed to add a row for sheet {}.", entry.getKey());
           }

       }
   }

    public static void appendResult2excel(List<PairDistance> pairDistanceList, String resultFilePath) {
        // 创建一个工作簿
        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(resultFilePath, true)) {

            // 遍历每个Table并将其写入不同的工作表
            for (PairDistance pairDistance : pairDistanceList) {
                appendResult2excel(pairDistance, workbook);
            }
            // 将工作簿写入文件
            workbook.write(fileOut);
            logger.info("Successfully write result to {}", resultFilePath);
        } catch (IOException e) {
            logger.error("Failed to write result to {}", resultFilePath, e);
        }
    }

    private static class DistanceVec {
        Map<String, Double> distanceMap = new HashMap<>();

        public DistanceVec(Map<String, Double> distanceMap) {
            this.distanceMap = distanceMap;
        }

        public List<String> getNames() {
            return distanceMap.keySet().stream().toList();
        }

        public List<Double> getValues() {
            return distanceMap.values().stream().toList();
        }

        public Double getValue(String name) {
            return distanceMap.get(name);
        }
    }

    private static class PairDistance{
        String problemId;
        String author1, author2;
        String file1;
        String file2;
        Map<String, DistanceVec> distanceMap;

        public PairDistance(String problemId, String author1, String author2, String file1, String file2, Map<String, DistanceVec> distanceMap) {
            this.problemId = problemId;
            this.author1 = author1;
            this.author2 = author2;
            this.file1 = file1;
            this.file2 = file2;
            this.distanceMap = distanceMap;
        }

        public PairDistance() {

        }
    }

}
