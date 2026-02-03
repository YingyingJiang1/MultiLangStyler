package org.example.web.model.dto;

public class StyleTaskRequest {
    private String styleProfileId;   // target style profile ID
    private String language;         // programming language

    private String source;           // paths seperated by ';' or raw code string
    private SourceType sourceType;

    /**
     * A target directory or file path where the processed code or analysis results will be saved.
     * <p>
     * If {@link #source} contains multiple paths and {@link #outputPath} is a directory,
     * each input source will generate a corresponding output file in this directory, preserving
     * the original file names.
     * <p>
     * If {@link #outputPath} is a file path and {@link #source} contains only a single file or
     * code string, the result will be saved to this file.
     */
    private String outputPath;
    /**
     * For FILE sourceType, whether to overwrite the source files.
     * Higher priority than {@link #outputPath}.
     */
    private boolean overwrite = true;
}