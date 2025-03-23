package org.example.styler.naming;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public enum MyCaseFormat {
    UPPER_UNDERSCORE,
    LOWER_UNDERSCORE,
    UPPER_CAMEL,
    LOWER_CAMEL,
    ALL_UPPER_CASE,
    ALL_LOWER_CASE
    ;


    public String to(MyCaseFormat targetFormat, String str) {
        List<String> caseFormatNames = Arrays.stream(CaseFormat.values()).map(Enum::name).toList();
        boolean isAllCaseFormatName = caseFormatNames.contains(name()) && caseFormatNames.contains(targetFormat.name());
        if (isAllCaseFormatName) {
            return CaseFormat.valueOf(name()).to(CaseFormat.valueOf(targetFormat.name()), str);
        } else if (targetFormat == ALL_UPPER_CASE) {
            return str.toUpperCase();
        } else if (targetFormat == ALL_LOWER_CASE) {
            return str.toLowerCase();
        }
        return str;
    }

    public boolean isConvertible(MyCaseFormat targetFormat) {
        if (targetFormat == ALL_LOWER_CASE && this != ALL_UPPER_CASE ||
        targetFormat == ALL_UPPER_CASE && this != ALL_LOWER_CASE) {
            return false;
        }
        return true;
    }
}
