package org.example.analysis.feature;

import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.parser.common.MyParser;

import java.util.Map;

public abstract class ParserFeatureExtractor {
    public void toFeatureVector(MyParser parser, Map<String, StyleVector> st2svMap) {}

}
