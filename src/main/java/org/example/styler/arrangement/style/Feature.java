package org.example.styler.arrangement.style;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Vocabulary;
import org.dom4j.Element;
import org.example.io.DomIO;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/1 14:34
 */
public class Feature implements DomIO {

    private Map<Integer, Integer> modifierStatistics;
    // List<StyleObj> contentStatistics;

    public Feature() {
        modifierStatistics = new HashMap<>();
    }

    public int calDistance(Feature feature) {
        int distance = 0;
        Set<Integer> interset = modifierStatistics.keySet();
        interset.retainAll(feature.modifierStatistics.keySet());
        for (Integer modifier : interset) {
            distance += Math.abs(modifierStatistics.get(modifier) - feature.modifierStatistics.get(modifier));
        }
        List<Map<Integer, Integer>> list = new ArrayList<>();
        list.add(modifierStatistics);
        list.add(feature.modifierStatistics);
        for (Map<Integer, Integer> map : list) {
            for (Map.Entry<Integer, Integer> entry : modifierStatistics.entrySet()) {
                if (!interset.contains(entry.getKey())) {
                    distance += entry.getValue();
                }
            }
        }
        return distance;
    }


    public String toReadableString(Parser parser) {
        Vocabulary vocabulary = parser.getVocabulary();
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : modifierStatistics.entrySet()) {
            if (entry.getKey() == -1) {
                builder.append("empty");
            } else {
                builder.append(vocabulary.getSymbolicName(entry.getKey()));
            }
            builder.append(":").append(entry.getValue()).append(",");
        }
        return builder.length() > 0 ? builder.substring(0, builder.length() - 1) : "";
    }

    public void updateModifierStatistic(int modifierType) {
        modifierStatistics.compute(modifierType, (k, v) -> v == null ? 1 : v + 1);
    }

    @Override
    public void addElement(Element parent, Parser parser) {
        Element featureEle = parent.addElement("feature").addText(toReadableString(parser));
    }

    @Override
    public Object parseElement(Element parent, Parser parser) {
        Element featureEle = parent.element("feature");
        String[] arr = featureEle.getText().split("[:,]]");
        Feature feature = new Feature();
        for (int i = 0; i < arr.length; i += 2) {
            feature.modifierStatistics.put(parser.getTokenType(arr[i]), Integer.valueOf(arr[i + 1]));
        }
        return feature;
    }
}
