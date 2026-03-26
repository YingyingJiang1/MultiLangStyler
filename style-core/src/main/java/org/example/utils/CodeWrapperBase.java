package org.example.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeWrapperBase implements CodeWrapper {
    /**
     * Wrap statement-level code with {}
     */
    @Override
    public CodeWrapResult wrap(String code) {
        String s = code == null ? "" : code;
        String prefix = "{";
        String suffix = "}";
        return new CodeWrapResult(prefix + s + suffix, prefix, suffix);
    }

    /**
     * unwrap the code. The wrapped code may be formatted.
     */
    @Override
    public String unwrap(CodeWrapResult wrapResult) {
        String wrappedCode = wrapResult.getWrappedCode();
        String prefix = wrapResult.getPrefix();
        String suffix = wrapResult.getSuffix();

        try {
            int startIndex = getStartIndex(wrappedCode, prefix);
            int endIndex = getEndIndex(wrappedCode, suffix);
            return wrappedCode.substring(startIndex, endIndex);
        } catch (RuntimeException e) {
            return wrappedCode;
        }
    }

    /**
     * 从字符串前部移除prefix（忽略首尾空白，但不考虑换行或更多复杂结构）
     */
    private static int getStartIndex(String str, String prefix) {
        int p1 = 0, p2 = 0;
        while (p1 < str.length() && p2 < prefix.length()) {
            if (str.charAt(p1) == prefix.charAt(p2)) {
                p1++;
                p2++;
            } else if (Character.isWhitespace(str.charAt(p1))) {
                p1++;
            } else {
                throw new RuntimeException("The prefix is not matched. str: " + str + ", prefix: " + prefix);
            }
        }
        return p1;
    }

    private static int getEndIndex(String str, String suffix) {
        int p1 = str.length() - 1, p2 = suffix.length() - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (str.charAt(p1) == suffix.charAt(p2)) {
                p1--;
                p2--;
            } else if (Character.isWhitespace(str.charAt(p1))) {
                p1--;
            } else {
                throw new RuntimeException("The suffix is not matched. str: " + str + ", suffix: " + suffix);
            }
        }
       return p1 + 1;
    }

}
