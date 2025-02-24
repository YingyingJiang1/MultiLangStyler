package org.example.analysis.style;

import org.example.analysis.feature.featurevalue.StyleVector;
import org.example.parser.common.MyParser;

import java.util.Map;

public interface ParserFeatureExtractor {
    void toFeatureVector(MyParser parser, Map<String, StyleVector> st2svMap);

}
