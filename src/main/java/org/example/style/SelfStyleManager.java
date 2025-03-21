package org.example.style;

import org.example.Configuration;
import org.example.controller.Controller;
import org.example.utils.FileCollection;

import java.util.HashMap;
import java.util.Map;

public class SelfStyleManager {
    private static Map<FileCollection, ProgramStyle> styleMap = new HashMap<>();

    public static void addStyle(FileCollection fileCollection, ProgramStyle programStyle) {
        styleMap.put(fileCollection, programStyle);
    }

    public static Style getStyle(FileCollection fileCollection, String styleName) {
        if (styleMap.get(fileCollection) == null) {
            return null;
        }
        return styleMap.get(fileCollection).getStyle(styleName);
    }
}
