package org.example.web.model.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
public class StyleProfileEntity {
    private final String styleProfileId;
    private final String storagePath;
    private final String projectKey;
    private final String language;
    private volatile StyleProfileStatus status;
    private volatile int version; // adopted style profile in order, for rollback
    private final Date createdAt; // creation timestamp
    private final String msg; // additional message or description

    @JsonCreator
    public StyleProfileEntity(
            @JsonProperty("styleProfileId") String styleProfileId,
            @JsonProperty("storagePath") String storagePath,
            @JsonProperty("projectKey") String projectKey,
            @JsonProperty("language") String language,
            @JsonProperty("status") StyleProfileStatus status,
            @JsonProperty("version") int version,
            @JsonProperty("createdAt") Date createdAt,
            @JsonProperty("msg") String msg
    ) {
        this.styleProfileId = styleProfileId;
        this.storagePath = storagePath;
        this.projectKey = projectKey;
        this.language = language;
        this.status = status;
        this.version = version;
        this.createdAt = createdAt;
        this.msg = msg;
    }

    public StyleProfileEntity(
            String styleProfileId,
            String storagePath,
            String projectKey,
            String language,
            Date date,
            String msg
    ) {
        this(styleProfileId, storagePath, projectKey, language,
                StyleProfileStatus.ACTIVE, 0, date, msg);
    }

}

