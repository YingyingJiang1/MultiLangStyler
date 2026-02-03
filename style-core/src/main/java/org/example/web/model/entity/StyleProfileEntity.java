package org.example.web.model.entity;

import lombok.Data;

import java.time.Instant;

@Data
public class StyleProfileEntity {
    private final String styleProfileId;
    private final String storagePath;
    private final String projectKey;
    private final String language;
    private volatile StyleProfileStatus status;
    private volatile int version; // adopted style profile in order, for rollback
    private final Instant createdAt; // creation timestamp
    private final String msg; // additional message or description
}

