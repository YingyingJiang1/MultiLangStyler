package org.example.web.repository;

import org.example.web.model.entity.ProjectEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.logging.Logger;

@Repository
public interface ProjectRepository {

    void save(ProjectEntity project);

    String findProjectKey(String clientId, String localPath);

    void deleteByProjectKey(String projectKey);
}
