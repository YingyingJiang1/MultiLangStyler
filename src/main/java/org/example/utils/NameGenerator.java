package org.example.utils;

import com.google.common.base.CaseFormat;

public class NameGenerator {
    public static String generateName(String suffix, CaseFormat caseFormat) {
        String name = "tmp";
        if (!suffix.isEmpty()) {
            name +=  "_" + suffix;
        }
        return CaseFormat.LOWER_UNDERSCORE.to(caseFormat, name);
    }
}
