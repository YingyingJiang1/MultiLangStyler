package org.example.web;

import org.example.MyEnvironment;
import org.example.config.MyConfiguration;
import org.example.style.StylerContainer;
import org.example.web.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.*;

@RestController
@RequestMapping("/api/v1")
public class Controller {
    private final ExecutorService extractPool;
    private final ExecutorService shortTaskPool;
    private StyleService styleService;

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
        if (!(request.getSourceType() == SourceType.FILE || request.getSourceType() == SourceType.STRING)) {
            return CompletableFuture.completedFuture(
                    new Result(false, ResultCode.EXTRACT_FAILURE, "Invalid source type", null)
            );
        }
        Future<Result> langValidation = validateLanguage(request.getLanguage());
        if (langValidation != null) {
            return langValidation;
        }

        return extractPool.submit(() -> styleService.extractStyle(request));
    }

    /**
     * Get current style profile ID for the specified project and language.
     */
    @GetMapping("style-profiles/{projectKey}/{language}")
    public Future<Result> getStyleProfileId(@PathVariable String projectKey, @PathVariable String language) {
        Future<Result> langValidation = validateLanguage(language);
        if (langValidation != null) {
            return langValidation;
        }
       return shortTaskPool.submit(() -> styleService.findStyleProfileId(projectKey, language));
    }

    private Future<Result> validateLanguage(String language) {
        if (language.equalsIgnoreCase("java")
                || language.equalsIgnoreCase("cpp")
                || language.equalsIgnoreCase("python")) {
            return null;
        }
        return CompletableFuture.completedFuture(
                Result.fail(ResultCode.EXTRACT_FAILURE, "Supported language: java, cpp, python"));
    }

}
