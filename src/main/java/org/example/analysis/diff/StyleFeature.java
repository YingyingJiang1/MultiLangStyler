package org.example.analysis.diff;

import org.example.analysis.diff.feature.FeatureVector;
import org.example.parser.common.MyParser;
import org.example.style.CommonStyle;

import java.util.Map;

public abstract class StyleFeature {

    public void toFeatureVector(CommonStyle commonStyle, Map<String, FeatureVector> styleFeatures) {}

    public void toFeatureVector(MyParser parser, Map<String, FeatureVector> styleFeatures) {}

}
