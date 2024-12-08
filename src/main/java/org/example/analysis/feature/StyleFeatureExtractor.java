package org.example.analysis.feature;

import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.parser.common.MyParser;
import org.example.style.Style;

import java.util.Map;

public interface StyleFeatureExtractor {

    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap);


}
