package org.example.style;

import org.example.utils.FileCollection;

import java.util.HashMap;
import java.util.Map;

public class SelfStyleManager {
    private static Map<FileCollection, StyleProfile> styleMap = new HashMap<>();

    public static void addStyle(FileCollection fileCollection, StyleProfile styleProfile) {
        styleMap.put(fileCollection, styleProfile);
    }

    public static Style getStyle(FileCollection fileCollection, String styleName) {
        if (styleMap.get(fileCollection) == null) {
            return null;
        }
        return styleMap.get(fileCollection).getStyle(styleName);
    }
}
