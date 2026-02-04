package org.example.web;

import org.example.MyEnvironment;
import org.example.config.MyConfiguration;
import org.example.style.StylerContainer;
import org.example.web.exception.InvalidRequestException;
import org.example.web.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    private final StyleService styleService;

    private static final Set<String> SUPPORTED_LANGUAGES = Set.of("java", "cpp", "python");

    @Autowired
    public Controller(StyleService styleService) {
        this.styleService = styleService;
    }

    @PostMapping("/projects")
    public CompletableFuture<Result> registerProject(@RequestBody RegisterRequest request) {
        // 参数校验
        if (request.getClientId() == null || request.getClientId().isEmpty()
                || request.getLocalPath() == null || request.getLocalPath().isEmpty()) {
            return CompletableFuture.completedFuture(
                    Result.fail(ResultCode.REGISTER_FAILURE, "Invalid parameters for project register")
            );
        }

        return styleService.registerProject(request);
    }

    @PostMapping("/style-profiles")
    public CompletableFuture<Result> extractStyle(@RequestBody ExtractRequest request) {

        validateCodeSource(request.getSourceType(), request.getSource());
        validateLanguage(request.getLanguage());

        return styleService.extractStyle(request);
    }

    /**
     * Get current style profile ID for the specified project and language.
     */
    @GetMapping("style-profiles/{projectKey}/{language}")
    public CompletableFuture<Result> getStyleProfileId(@PathVariable String projectKey, @PathVariable String language) {
        validateLanguage(language);
       return styleService.findStyleProfileId(projectKey, language);
    }

    /**
     * Get current style profile entity for the specified project and language.
     */
    @GetMapping("style-profiles/{profileId}")
    public CompletableFuture<Result> getStyleProfileEntity(@PathVariable String profileId) {
        return styleService.getStyleProfileEntity(profileId);
    }

    private void validateLanguage(String language) {
        if (!SUPPORTED_LANGUAGES.contains(language)) {
            throw new InvalidRequestException(ResultCode.EXTRACT_FAILURE.name(),  "Supported language: " + SUPPORTED_LANGUAGES);
        }
    }

    private void validateCodeSource(SourceType sourceType, String source) {
        if (!(sourceType == SourceType.FILE || sourceType == SourceType.STRING)) {
            throw new InvalidRequestException(ResultCode.EXTRACT_FAILURE.name(), "Invalid source type");
        }
    }

}
