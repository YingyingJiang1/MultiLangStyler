package org.example.analysis;

import org.example.analysis.io.input.InputGenerator;
import org.example.controller.Controller;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.StyleFeatureFactory;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.io.DiffResult;
import org.example.analysis.io.InputPair;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.utils.FileCollection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffAnalyzer {
    public static final List<StyleFeature> styleFeatures = List.of(

    );
    public static String language = "java";

    public static void main(String[] args) throws IOException {
        List<InputPair> programPairs = InputGenerator.generateHumanLLMPairs("");
        DiffResult result = analyze(programPairs, "");

    }


    public static DiffResult analyze(List<InputPair> programPairs, String resultFileName) throws IOException {
        DiffResult diffResult = new DiffResult();
        for (InputPair pair : programPairs) {
            // extract style
            FileCollection files1 = new FileCollection();
            files1.add(Paths.get(pair.getFile1()));
            ProgramStyle programStyle1 = new Controller().extractStyle(files1);
            FileCollection files2 = new FileCollection();
            files2.add(Paths.get(pair.getFile2()));
            ProgramStyle programStyle2 = new Controller().extractStyle(files2);

            // transform a program style into a styl vector.
            Map<String, StyleVector> styleVecs1 = new HashMap<>();
            Map<String, StyleVector> styleVecs2 = new HashMap<>();
            extractStyleFeatures(programStyle1.getStyles(), styleVecs1);
            extractStyleFeatures(programStyle2.getStyles(), styleVecs2);

            // extract specific type of styles which can not be gained from previous step.
            MyParser parser1 = MyParserFactory.createParser(language);
            parser1.parse(Paths.get(pair.getFile1()));
            MyParser parser2 = MyParserFactory.createParser(language);
            parser2.parse(Paths.get(pair.getFile1()));

            for (StyleFeature  feature : styleFeatures) {
                feature.toFeatureVector(parser1, styleVecs1);
                feature.toFeatureVector(parser2, styleVecs2);
            }


            for (String styleName : styleVecs1.keySet()) {
                StyleVector vec1 = styleVecs1.get(styleName);
                if (styleVecs2.get(styleName) != null) {
                    boolean consistent = isConsistent(vec1, styleVecs2.get(styleName));
                    diffResult.add(styleName, pair, consistent);
                }
            }

        }

        try(FileOutputStream fout = new FileOutputStream(resultFileName)) {
            fout.write(diffResult.getResult().getBytes());
        } catch (IOException e) {
            System.err.println("结果写入失败！");
        }
        return diffResult;
    }

    private static List<InputPair> generatePairs(String file) {
        List<InputPair> inputPairs = new ArrayList<>();
        return inputPairs;
    }


    private static boolean isConsistent(StyleVector fv1, StyleVector fv2) {
        return fv1.calculateDistance(fv2) < 0.5;
    }

    private static void extractStyleFeatures(List<Style> styles, Map<String, StyleVector> styleFeatures) {
        for (Style Style : styles) {
            StyleFeature styleFeature = StyleFeatureFactory.createStyleDiff(Style.getStyleName());
            if (styleFeature != null) {
                styleFeature.toFeatureVector(Style, styleFeatures);
            }
        }
    }

}
