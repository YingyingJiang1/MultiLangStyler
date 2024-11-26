package org.example.analysis.diff.feature;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class OneHotEncoder {
    public static List<Boolean> encode(int value) {
        List<Boolean> encodedData = new ArrayList<>(Collections.nCopies(value, Boolean.FALSE));
        encodedData.set(value, Boolean.TRUE);
        return encodedData;
    }
}
