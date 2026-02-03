package org.example.web.model.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String clientId;
    private String localPath;
}
