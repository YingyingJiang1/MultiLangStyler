package org.example.web.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.web.model.entity.ProjectEntity;
import org.example.web.model.entity.StyleProfileEntity;
import org.example.web.model.entity.StyleProfileStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Persistent style profile repository based on file (json format) storage.
 * Provides basic CRUD operations and maintains an in-memory index for efficient access.
 */
@Repository
public class FileStyleProfileRepository implements StyleProfileRepository {
    private static final Logger logger = Logger.getLogger(FileStyleProfileRepository.class.getName());

    private final File storageFile;
    private final ObjectMapper objectMapper = new ObjectMapper();

    // 内存索引
    private final Map<String, StyleProfileEntity> profileMap = new ConcurrentHashMap<>(); // profileId -> entity
    private final Map<String, List<String>> projectIndex = new ConcurrentHashMap<>(); // projectKey -> profileId list

    public FileStyleProfileRepository(@Value("${project.styleProfilesFile}") String storageFilePath) throws IOException {
        this.storageFile = new File(storageFilePath);
        if (!storageFile.getParentFile().exists()) {
            storageFile.getParentFile().mkdirs();
        }

        loadFromFile();
        // 注册 shutdown hook，保证退出前 flush
        Runtime.getRuntime().addShutdownHook(new Thread(this::flush));
    }

    /** ------------------------ 接口实现 ------------------------ */

    @Override
    public Optional<StyleProfileEntity> findById(String styleProfileId) {
        return Optional.ofNullable(profileMap.get(styleProfileId));
    }

    @Override
    public Optional<StyleProfileEntity> findActiveProfile(String projectKey, String language) {
        List<String> ids = projectIndex.getOrDefault(projectKey, Collections.emptyList());
        return ids.stream()
                .map(profileMap::get)
                .filter(p -> p != null && p.getStatus() == StyleProfileStatus.ACTIVE && p.getLanguage().equals(language))
                .findFirst();
    }

    @Override
    public void save(StyleProfileEntity profile) {
        Objects.requireNonNull(profile, "profile cannot be null");

        // Ensure only one active profile per project
        if (profile.getStatus() == StyleProfileStatus.ACTIVE &&
                projectIndex.get(profile.getProjectKey()) != null) {
            projectIndex.get(profile.getProjectKey()).stream().map(profileMap::get)
                    .filter(p -> p.getStatus() == StyleProfileStatus.ACTIVE)
                    .forEach(p -> p.setStatus(StyleProfileStatus.INACTIVE));
        }

        profileMap.put(profile.getStyleProfileId(), profile);
        projectIndex.computeIfAbsent(profile.getProjectKey(), k -> new CopyOnWriteArrayList<>())
                .add(profile.getStyleProfileId());
        if (profile.getStatus() == StyleProfileStatus.ACTIVE) {
            setActiveStat(profile.getStyleProfileId());
        }

       flush();
    }

    @Override
    public void setActiveStat(String styleProfileId) {
        synchronized (this) {
            StyleProfileEntity profileEntity = profileMap.get(styleProfileId);
            if (profileEntity == null) {
                logger.warning("Style profile not found: " + styleProfileId);
                return;
            }
            if (profileEntity.getStatus() == StyleProfileStatus.ACTIVE) return;

            // 先将同项目下的其他 profile 设为 INACTIVE
            String language = profileEntity.getLanguage();
            String projectKey = profileEntity.getProjectKey();
            List<String> ids = projectIndex.getOrDefault(projectKey, Collections.emptyList());
            for (String id : ids) {
                StyleProfileEntity p = profileMap.get(id);
                if (p != null && p.getStatus() == StyleProfileStatus.ACTIVE && p.getLanguage().equals(language)) {
                    p.setStatus(StyleProfileStatus.INACTIVE);
                }
            }
            profileEntity.setStatus(StyleProfileStatus.ACTIVE);
            int maxVersion = ids.stream().map(profileMap::get)
                    .max(Comparator.comparingInt(StyleProfileEntity::getVersion)).get().getVersion();
            profileEntity.setVersion(maxVersion + 1);
        }
        flush();
    }

    @Override
    public StyleProfileEntity deleteById(String styleProfileId) {
        StyleProfileEntity profile = profileMap.remove(styleProfileId);
        if (profile != null) {
            List<String> ids = projectIndex.getOrDefault(profile.getProjectKey(), Collections.emptyList());
            ids.remove(styleProfileId);

            // Ensure there is always an active profile
            if (profile.getStatus() == StyleProfileStatus.ACTIVE) {
                Optional<StyleProfileEntity> maxVersionProfile =
                        ids.stream().map(profileMap::get).max(Comparator.comparingInt(StyleProfileEntity::getVersion));
                if (maxVersionProfile.isPresent()) {
                    setActiveStat(maxVersionProfile.get().getStyleProfileId());
                }
            }
            File profileFile = new File(profile.getStoragePath());
            profileFile.delete();
            flush();
        }
        return profile;
    }

    public List<StyleProfileEntity> findByProject(String projectKey) {
        List<String> ids = projectIndex.getOrDefault(projectKey, Collections.emptyList());
        return ids.stream()
                .map(profileMap::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private synchronized void flush() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(storageFile, profileMap);
        } catch (IOException e) {
            logger.severe("Failed to flush style profiles to file: " + e.getMessage());
        }
    }

    /** 从文件加载到内存 */
    private void loadFromFile() throws IOException {
        if (!storageFile.exists()) return;
        Map<String, StyleProfileEntity> map = objectMapper.readValue(
                storageFile,
                new TypeReference<>() {}
        );
        profileMap.putAll(map);
        profileMap.values().forEach(p -> {
            projectIndex.computeIfAbsent(p.getProjectKey(), k -> new CopyOnWriteArrayList<>())
                    .add(p.getStyleProfileId());
        });
    }

}
