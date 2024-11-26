package org.example.analysis.feature.featurevalue;

import java.util.ArrayList;
import java.util.List;

public class OrderedFeatureValue implements FeatureValue{
    private List<String> orderedStrs = new ArrayList<String>();

    public OrderedFeatureValue(List<String> orderedStrs) {
        this.orderedStrs = orderedStrs;
    }


}
