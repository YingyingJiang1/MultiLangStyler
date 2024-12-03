package org.example.analysis.feature.featurevalue;

import java.io.Serializable;

public interface AttrValue extends Serializable {
    double calculateDistance(AttrValue other);
}
