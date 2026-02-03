package org.example.web.model.dto;

import lombok.Data;

@Data
public class ExtractRequest {
    private String projectKey;
    private String language;
    private SourceType sourceType; // "file" or "string"
    private String source; // code string or file and directory paths separated by semicolon
}

