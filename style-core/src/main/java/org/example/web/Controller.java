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
    private final ExecutorService extractPool;
    private final ExecutorService shortTaskPool;
    private final StyleService styleService;

    private static final Set<String> SUPPORTED_LANGUAGES = Set.of("java", "cpp", "python");

    @Autowired
    public Controller(StyleService styleService) {
        this.styleService = styleService;
        MyConfiguration.ProjectConfig.ThreadPoolConfig tpConfig = MyEnvironment.getIConfig().getProjectConfig().getThreadPool();
        this.extractPool = new ThreadPoolExecutor(tpConfig.getCorePoolSize(),
                tpConfig.getMaxPoolSize(),
                tpConfig.getKeepAliveSeconds(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(tpConfig.getQueueCapacity()));
        this.shortTaskPool = new ThreadPoolExecutor(tpConfig.getCorePoolSize(),
                tpConfig.getMaxPoolSize(),
                tpConfig.getKeepAliveSeconds(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(tpConfig.getQueueCapacity()));
    }

    @PostMapping("/projects")
    public Future<Result> registerProject(@RequestBody RegisterRequest request) {
        // 参数校验
        if (request.getClientId() == null || request.getClientId().isEmpty()
                || request.getLocalPath() == null || request.getLocalPath().isEmpty()) {
            return CompletableFuture.completedFuture(
                    new Result(false, ResultCode.REGISTER_FAILURE, "Invalid parameters for project register", null)
            );
        }

        return shortTaskPool.submit(() -> styleService.registerProject(request));
    }

    @PostMapping("/style-profiles")
    public Future<Result> extractStyle(@RequestBody ExtractRequest request) {
        validateCodeSource(request.getSourceType(), request.getSource());
        validateLanguage(request.getLanguage());

        return extractPool.submit(() -> styleService.extractStyle(request));
    }

    /**
     * Get current style profile ID for the specified project and language.
     */
    @GetMapping("style-profiles/{projectKey}/{language}")
    public Future<Result> getStyleProfileId(@PathVariable String projectKey, @PathVariable String language) {
        validateLanguage(language);
       return shortTaskPool.submit(() -> styleService.findStyleProfileId(projectKey, language));
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
