package org.example.analysis;

import org.example.controller.Controller;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.StyleFeatureFactory;
import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.analysis.ioformat.DiffResult;
import org.example.analysis.ioformat.InputPair;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.utils.FileCollection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffAnalyzer {
    public static void main(String[] args) {
        List<InputPair> programPairs = generatePairs("");
        DiffResult result = analyze(programPairs);

        try(FileOutputStream fout = new FileOutputStream("result.txt")) {
            fout.write(result.getResult().getBytes());
        } catch (IOException e) {
            System.err.println("结果写入失败！");
        }
    }

    public static DiffResult analyze(List<InputPair> programPairs) {
        DiffResult diffResult = new DiffResult();
        for (InputPair pair : programPairs) {
            FileCollection files1 = new FileCollection();
            files1.add(Paths.get(pair.getFile1()));
            ProgramStyle programStyle1 = new Controller().extractStyle(files1);

            FileCollection files2 = new FileCollection();
            files2.add(Paths.get(pair.getFile2()));
            ProgramStyle programStyle2 = new Controller().extractStyle(files2);

            Map<String, StyleVector> styleVecs1 = new HashMap<>();
            Map<String, StyleVector> styleVecs2 = new HashMap<>();
            extractStyleFeatures(programStyle1.getStyles(), styleVecs1);
            extractStyleFeatures(programStyle2.getStyles(), styleVecs2);

            for (String styleName : styleVecs1.keySet()) {
                StyleVector vec1 = styleVecs1.get(styleName);
                if (styleVecs2.get(styleName) != null) {
                    boolean consistent = isConsistent(vec1, styleVecs2.get(styleName));
                    diffResult.add(styleName, pair, consistent);
                }
            }

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
