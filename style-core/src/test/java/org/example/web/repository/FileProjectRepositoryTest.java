package org.example.web.repository;

import org.example.web.model.entity.ProjectEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class FileProjectRepositoryTest {

    @Autowired
    private FileProjectRepository fileProjectRepositoryUnderTest;

    @Test
    void test() {
        // Save
        final ProjectEntity project = new ProjectEntity("projectKey", "clientId", "localPath");
        fileProjectRepositoryUnderTest.save(project);

        // Find
        final String result = fileProjectRepositoryUnderTest.findProjectKey("clientId", "localPath");
        assertThat(result).isEqualTo("projectKey");

        // Delete
        fileProjectRepositoryUnderTest.deleteByProjectKey("projectKey");
        assertNull(fileProjectRepositoryUnderTest.findProjectKey("clientId", "localPath"));

        // Delete
        fileProjectRepositoryUnderTest.deleteByProjectKey("projectKey");
        assertNull(fileProjectRepositoryUnderTest.findProjectKey("clientId", "localPath"));

        fileProjectRepositoryUnderTest.save(project);
    }

    @Test
    void test1()  {
        // Save
        final ProjectEntity project = new ProjectEntity("projectKey", "clientId", "localPath");
        fileProjectRepositoryUnderTest.save(project);

        // Find
        final String result = fileProjectRepositoryUnderTest.findProjectKey("clientId", "localPath");
        assertThat(result).isEqualTo("projectKey");

    }
}
