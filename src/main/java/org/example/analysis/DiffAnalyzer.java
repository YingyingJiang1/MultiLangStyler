package org.example.analysis;

import org.example.Controller;
import org.example.analysis.feature.StyleFeature;
import org.example.analysis.feature.StyleFeatureFactory;
import org.example.analysis.feature.featurevalue.FeatureVector;
import org.example.analysis.ioformat.DiffResult;
import org.example.analysis.ioformat.InputPair;
import org.example.style.style;
import org.example.style.ProgramStyle;
import org.example.utils.FileCollection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

            for (style commonStyle1 : programStyle1.getStyles()) {
                List<style> result = programStyle2.getStyles().stream().filter(style2 -> commonStyle1.getClass() == style2.getClass()).toList();
                if (!result.isEmpty()) {
                    StyleFeature styleFeature = StyleFeatureFactory.createStyleDiff(commonStyle1.getClass());
                    if (styleFeature != null) {
                        FeatureVector fv1 = styleFeature.toFeatureVector(commonStyle1);
                        FeatureVector fv2 = styleFeature.toFeatureVector(result.get(0));
                        boolean consistent = isConsistent(fv1, fv2);
                        diffResult.add(commonStyle1.getStyleName(), pair, consistent);
                    }
                }
            }

        }
        return diffResult;
    }

    private static List<InputPair> generatePairs(String file) {
        List<InputPair> inputPairs = new ArrayList<>();
        return inputPairs;
    }


    public boolean isConsistent(FeatureVector fv1, FeatureVector fv2) {
        return fv1.calculateDistance(fv2) < 0.5;
    }

}
