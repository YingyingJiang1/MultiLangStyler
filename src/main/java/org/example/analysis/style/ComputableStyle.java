package org.example.analysis.style;

import org.example.analysis.feature.FeatureVector;
import org.example.style.rule.StyleContext;

import java.util.*;

public class ComputableStyle {
    Map<StyleContext, FeatureVector> rules = new HashMap<>();

    public List<Double> calculateDistance(ComputableStyle other) {
        Set<StyleContext> intersection = new HashSet<>(rules.keySet());
        intersection.retainAll(other.rules.keySet());
        List<List<Double>> vectorList = new ArrayList<>();
        for (StyleContext context : intersection) {
            List<Double> distance = rules.get(context).calculateDistance(other.rules.get(context));
            vectorList.add(distance);
        }

        // 计算平均向量
        if (vectorList.isEmpty()) {
            return new ArrayList<>(Collections.nCopies(getDimension(), -1.0));
        }
        List<Double> averageVector = new ArrayList<>(Collections.nCopies(getDimension(), -0.0));
        List<Integer> validValueCounts = new ArrayList<>(Collections.nCopies(getDimension(), 0));
       for (List<Double> distanceVec : vectorList) {
           for (int i = 0; i < averageVector.size(); i++) {
               averageVector.set(i, averageVector.get(i) + distanceVec.get(i));
               if (distanceVec.get(i) >= 0) {
                   validValueCounts.set(i, validValueCounts.get(i) + 1);
               }
           }
       }
        for (int i = 0; i < averageVector.size(); i++) {
            if (validValueCounts.get(i) > 0) {
                averageVector.set(i, averageVector.get(i) / validValueCounts.get(i));
            } else {
                averageVector.set(i, -1.0);
            }
        }

        return averageVector;
    }

    public void addRule(StyleContext context, FeatureVector vector) {
        rules.put(context, vector);
    }

    public boolean isEmpty() {
        return rules.isEmpty();
    }

    private int getDimension() {
        for (StyleContext context : rules.keySet()) {
            return rules.get(context).getDimension();
        }
        System.out.println("请至少为Style添加一条风格规则！");
        return -1;
    }

}
