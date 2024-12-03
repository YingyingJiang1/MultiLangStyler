package org.example.analysis.feature;

import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.parser.common.MyParser;
import org.example.style.Style;

import java.util.Map;

public abstract class StyleFeature {

    public void toFeatureVector(Style style, Map<String, StyleVector> st2svMap) {}

    public void toFeatureVector(MyParser parser, Map<String, StyleVector> st2svMap) {}

}
