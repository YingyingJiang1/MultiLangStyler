package org.example.web;

import org.checkerframework.checker.units.qual.A;
import org.example.MyEnvironment;
import org.example.lang.LangAdapterCreator;
import org.example.style.StyleFileIO;
import org.example.style.StyleProfile;
import org.example.style.StylerContainer;
import org.example.stylekit.Extractor;
import org.example.web.model.dto.*;
import org.example.web.model.entity.ProjectEntity;
import org.example.web.model.entity.StyleProfileEntity;
import org.example.web.model.entity.StyleProfileStatus;
import org.example.web.repository.ProjectRepository;
import org.example.web.repository.StyleProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.*;

@Service
public class StyleService {

    private final ProjectRepository projectRepository;
    private final StyleProfileRepository styleProfileRepository;
    /**
     * key: style profile id
     * value: container filled with the style profile>
     * This field is used to avoid re-creating objects for the same style profile.
     */
    private final Map<String, StylerContainer> stylerCache = new ConcurrentHashMap<>();

    @Autowired
    public StyleService(
            ProjectRepository projectRepository,
            StyleProfileRepository styleProfileRepository) {
        this.projectRepository = projectRepository;
        this.styleProfileRepository = styleProfileRepository;
    }

    @Async("shortTaskPool")
    public CompletableFuture<Result> registerProject(RegisterRequest request) {
        String existingKey =
                projectRepository.findProjectKey(
                        request.getClientId(), request.getLocalPath());

        if (existingKey != null) {
            return CompletableFuture.completedFuture(Result.ok(existingKey));
        }

        String projectKey = "proj-" + UUID.randomUUID();
        projectRepository.save(
                new ProjectEntity(projectKey,
                        request.getClientId(), request.getLocalPath()));
        return CompletableFuture.completedFuture(Result.ok(projectKey));
    }

    @Async("shortTaskPool")
    public CompletableFuture<Result> findStyleProfileId(String projectKey, String language) {
        Optional<StyleProfileEntity> styleProfile = styleProfileRepository.findActiveProfile(projectKey, language);
        if (styleProfile.isPresent()) {
            return CompletableFuture.completedFuture(
                    Result.ok(styleProfile.get().getStyleProfileId()));
        } else {
            return CompletableFuture.completedFuture(
                    Result.fail(ResultCode.LOOKUP_FAILURE, "No style profile found for the given project and language"));
        }
    }

    @Async("ioTaskPool")
    public CompletableFuture<Result> getStyleProfileEntity(String profileId) {
        Optional<StyleProfileEntity> profileEntity = styleProfileRepository.findById(profileId);
        if (profileEntity.isPresent()) {
            return CompletableFuture.completedFuture(Result.ok(profileEntity.get()));
        }
        return CompletableFuture.completedFuture(
                Result.fail(ResultCode.LOOKUP_FAILURE, "Style profile entity not found"));
    }

    @Async("ioTaskPool")
    public CompletableFuture<Result> extractStyle(ExtractRequest request) {
        StylerContainer container = LangAdapterCreator.createStylerContainer(request.getLanguage());

        // 根据类型选择不同的处理方法
        Callable<StyleProfile> task;
        if (request.getSourceType() == SourceType.FILE) {
            task = () -> Extractor.extractStyle(
                    request.getSource(), request.getLanguage(), container);
        } else if (request.getSourceType() == SourceType.STRING) {
            task = () -> Extractor.extractStyleFromString(
                    request.getSource(), request.getLanguage(), container);
        } else {
            return CompletableFuture.completedFuture(
                    Result.fail(ResultCode.EXTRACT_FAILURE, "Unsupported source type"));
        }

        try {
            return CompletableFuture.completedFuture(
                    executeExtraction(task, request, container));
        } catch (Exception e) {
            return CompletableFuture.completedFuture(Result.fail(ResultCode.EXTRACT_FAILURE,
                    "Server internal execution exception"));
        }
    }


    // 公共执行方法，统一异常捕获和 StylerContainer 缓存
    private Result executeExtraction(Callable<StyleProfile> task, ExtractRequest extractRequest, StylerContainer container) {
        try {
            StyleProfile styleProfile = task.call();
            File dir = new File(MyEnvironment.getProjectConfig().getStyleOutputDir());
            dir.mkdirs();

            String styleProfileId = String.format("style-%s", UUID.randomUUID());
            String storagePath = Paths.get(dir.toString(), String.format("style-%s.xml", styleProfileId)).toString();

            StyleFileIO.write(styleProfile, storagePath, extractRequest.getLanguage());
            styleProfileRepository.save(new StyleProfileEntity(
                    styleProfileId, storagePath,
                    extractRequest.getProjectKey(), extractRequest.getLanguage(),
                    StyleProfileStatus.ACTIVE, 0,
                    new Date(), ""));

            stylerCache.put(styleProfileId, container);
            return Result.ok(styleProfileId);
        } catch (Exception e) {
            return Result.fail(ResultCode.EXTRACT_FAILURE, "Extraction failed: " + e.getMessage());
        }
    }
}
