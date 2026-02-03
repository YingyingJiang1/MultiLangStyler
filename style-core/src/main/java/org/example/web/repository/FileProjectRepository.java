package org.example.web.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.MyEnvironment;
import org.example.web.model.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@Repository
public class FileProjectRepository implements ProjectRepository {
    private static final Logger logger = Logger.getLogger(FileProjectRepository.class.getName());

    private final Map<String, ProjectEntity> projectKeyMap = new ConcurrentHashMap<>();
    private final Map<String, String> clientPathIndex = new ConcurrentHashMap<>();

    ObjectMapper objectMapper = new ObjectMapper();
    private final File storageFile;

    public FileProjectRepository(@Value("${project.projectsFile}") String storageFilePath) throws IOException {
        this.storageFile = new File(storageFilePath);
        if (!storageFile.getParentFile().exists()) {
            storageFile.getParentFile().mkdirs();
        }
        loadFromFile();
    }


    @Override
    public void save(ProjectEntity project) {
        if (project == null) return;

        projectKeyMap.put(project.getProjectKey(), project);
        clientPathIndex.put(buildClientPathKey(project.getClientId(), project.getLocalPath()), project.getProjectKey());
        flushToFile(); // 保存到文件
    }

    @Override
    public String findProjectKey(String clientId, String localPath) {
        return clientPathIndex.get(buildClientPathKey(clientId, localPath));
    }

    @Override
    public void deleteByProjectKey(String projectKey) {
        ProjectEntity removed = projectKeyMap.remove(projectKey);
        if (removed != null) {
            clientPathIndex.remove(buildClientPathKey(removed.getClientId(), removed.getLocalPath()));
            flushToFile(); // 更新文件
        }
    }

    private String buildClientPathKey(String clientId, String localPath) {
        return clientId + "::" + localPath;
    }

    /**
     * 启动加载文件
     */
    private void loadFromFile() throws IOException {
        if (!storageFile.exists()) return;

        Map<String, ProjectEntity> map = objectMapper.readValue(
                storageFile,
                new TypeReference<Map<String, ProjectEntity>>() {}
        );

        projectKeyMap.putAll(map);
        // 重建索引
        map.values().forEach(p -> clientPathIndex.put(buildClientPathKey(p.getClientId(), p.getLocalPath()), p.getProjectKey()));
    }

    private synchronized void flushToFile() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(storageFile, projectKeyMap);
        } catch (IOException e) {
            logger.warning("Failed to flush project data to file: " + e.getMessage());
        }
    }

}