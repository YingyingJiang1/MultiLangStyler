package org.example.web;

import org.example.MyEnvironment;
import org.example.lang.LangAdapterCreator;
import org.example.style.Style;
import org.example.style.StyleFileIO;
import org.example.style.StyleProfile;
import org.example.style.StylerContainer;
import org.example.stylekit.Extractor;
import org.example.web.model.dto.*;
import org.example.web.model.entity.ProjectEntity;
import org.example.web.model.entity.StyleProfileEntity;
import org.example.web.repository.ProjectRepository;
import org.example.web.repository.StyleProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StyleService {
    private final ProjectRepository projectRepository;
    private final StyleProfileRepository styleProfileRepository;

    /**
     * key: style profile id
     * value: container filled with the style profile>
     * This field is used to avoid re-creating objects for the same style profile.
     */
    private Map<String, StylerContainer> stylerCache;

    @Autowired
    public StyleService(ProjectRepository projectRepository, StyleProfileRepository styleProfileRepository) {
        this.projectRepository = projectRepository;
        this.styleProfileRepository = styleProfileRepository;
        this.stylerCache = new ConcurrentHashMap<>();
    }

    public Result registerProject(RegisterRequest request) {
        // 检查是否已有相同项目
        String existingKey = projectRepository.findProjectKey(request.getClientId(), request.getLocalPath());
        if (existingKey != null) {
            return new Result(true, ResultCode.SUCCESS,
                    "Project already registered", existingKey);
        }

        // 构建新的实体并保存
        String projectKey = String.format("proj-%s", UUID.randomUUID());
        ProjectEntity project = new ProjectEntity(projectKey, request.getClientId(), request.getLocalPath());
        projectRepository.save(project);

        return new Result(true, ResultCode.SUCCESS,
                "Project registered successfully", projectKey);
    }

    public Result findStyleProfileId(String projectKey, String language) {
        Optional<StyleProfileEntity> styleProfile = styleProfileRepository.findActiveProfile(projectKey, language);
        if (styleProfile.isPresent()) {
            return Result.ok(styleProfile.get().getStyleProfileId());
        } else {
            return Result.fail(ResultCode.LOOKUP_FAILURE, "No style profile found for the given project and language");
        }
    }

    public Result extractStyle(ExtractRequest request) {
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
            return Result.fail(ResultCode.EXTRACT_FAILURE, "Invalid extraction options");
        }

        return executeExtraction(task, request, container);
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
                    Instant.now(), ""));

            stylerCache.put(styleProfileId, container);
            return Result.ok(styleProfileId);
        } catch (Exception e) {
            return Result.fail(ResultCode.EXTRACT_FAILURE, "Extraction failed: " + e.getMessage());
        }
    }
}
