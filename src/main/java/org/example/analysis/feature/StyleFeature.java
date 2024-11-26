package org.example.analysis.feature;

import org.example.analysis.feature.featurevalue.FeatureVector;
import org.example.parser.common.MyParser;
import org.example.style.Style;

import java.util.Map;

public abstract class StyleFeature {

    public void toFeatureVector(Style style, Map<String, FeatureVector> styleFeatures) {}

    public void toFeatureVector(MyParser parser, Map<String, FeatureVector> styleFeatures) {}

}
