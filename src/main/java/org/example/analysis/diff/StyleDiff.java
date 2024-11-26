package org.example.analysis.diff;

import org.example.analysis.FeatureVector;
import org.example.style.Style;

public interface StyleDiff {
    FeatureVector toFeatureVector(Style style);
    boolean isConsistent(FeatureVector fv1, FeatureVector fv2);
}
