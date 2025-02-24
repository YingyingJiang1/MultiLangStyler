package org.example.analysis;

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

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceCalculator {

    private static final List<ComputableStyleExtractor> FEATURE_EXTRACTORS = List.of(
            new BlankLineFeature(),
            new LineLengthFeature(),
            new LoopFeature()
    );


    public static void main(String[] args) {

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

    public static void writeResult(Map<String, List<Double>> distanceMap, String outputPath) {
        // 将结果写入excel文件
        // 以distanceMap的key为表格的列名

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
}
