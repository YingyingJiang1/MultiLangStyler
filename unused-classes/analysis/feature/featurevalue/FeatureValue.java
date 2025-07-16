package org.example.analysis.feature.featurevalue;

import java.io.Serializable;

public interface FeatureValue extends Serializable {
    double calculateDistance(FeatureValue other);
}
