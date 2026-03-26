package org.example.utils;

import lombok.Data;

@Data
public class CodeWrapResult {
    private String wrappedCode;
    private String prefix;
    private String suffix;

    public CodeWrapResult(String wrappedCode, String prefix, String suffix) {
        this.wrappedCode = wrappedCode;
        this.prefix = prefix;
        this.suffix = suffix;
    }
}
