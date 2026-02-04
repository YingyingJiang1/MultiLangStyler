package org.example.web.repository;

import org.example.web.model.entity.StyleProfileEntity;
import org.example.web.model.entity.StyleProfileStatus;

import java.util.Optional;

public interface StyleProfileRepository {
    Optional<StyleProfileEntity> findById(String styleProfileId);

    /**
     * Find the active style profile for a given project.
     */
    Optional<StyleProfileEntity> findActiveProfile(String projectKey, String language);

    void save(StyleProfileEntity profile);

    /**
     * Sets the status of the specified style profile to ACTIVE.
     * <p>
     * Ensures that only one style profile per project and language is ACTIVE at any time.
     * If another profile in the same project and language is currently ACTIVE, it will
     * be set to INACTIVE.
     * </p>
     */
    void setActiveStat(String styleProfileId);

    /**
     * Deletes the style profile with the specified ID.
     * If no ACTIVE style profile, choose the one with the highest version as ACTIVE.
     */
    StyleProfileEntity deleteById(String styleProfileId);
}