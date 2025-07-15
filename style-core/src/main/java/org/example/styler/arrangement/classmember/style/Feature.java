package org.example.styler.arrangement.classmember.style;

import org.dom4j.Element;
import org.example.style.DomIO;
import org.example.parser.common.MyParser;

import java.util.*;
import java.util.Objects;

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


    public String toReadableString(MyParser parser) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : modifierStatistics.entrySet()) {
            if (entry.getKey() == -1) {
                builder.append("DEFAULT");
            } else {
                builder.append(parser.getTokenName(entry.getKey()));
            }
            builder.append("=").append(entry.getValue()).append(",");
        }
        return !builder.isEmpty() ? builder.substring(0, builder.length() - 1) : "";
    }

    public void updateModifierStatistic(int modifierType) {
        modifierStatistics.compute(modifierType, (k, v) -> v == null ? 1 : v + 1);
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        Element featureEle = parent.addElement("feature");
        featureEle.addAttribute("statistic", toReadableString(parser));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        Element featureEle = parent.element("feature");
        if (featureEle.attribute("statistic") != null) {
            String[] arr = featureEle.attributeValue("statistic").split("[,=]");
            for (int i = 0; i < arr.length; i += 2) {
                modifierStatistics.put(parser.getType(arr[i]), Integer.valueOf(arr[i + 1]));
            }
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(modifierStatistics);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Feature feature) {
            return Objects.equals(modifierStatistics, feature.modifierStatistics);
        }
        return false;
    }
}
