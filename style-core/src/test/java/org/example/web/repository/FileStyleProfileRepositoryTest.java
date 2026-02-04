package org.example.web.repository;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.example.web.model.entity.StyleProfileEntity;
import org.example.web.model.entity.StyleProfileStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileStyleProfileRepositoryTest {
    private FileStyleProfileRepository fileStyleProfileRepositoryUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        fileStyleProfileRepositoryUnderTest = new FileStyleProfileRepository("./test-style-data/style-profiles.json");
    }

    @Test
    void test() {
        String projectKey = "projectKey";
        String language = "language";
        long timestamp = 1675507200000L; // 1970-01-01 00:00:00 UTC 以来的毫秒数
        Date date = new Date(timestamp);
        final StyleProfileEntity activeProfile = new StyleProfileEntity("id1", "storagePath", projectKey,
                language, StyleProfileStatus.ACTIVE, 0, date,
                "msg");
        final StyleProfileEntity inactiveProfile = new StyleProfileEntity("id2", "storagePath", projectKey,
                language, StyleProfileStatus.INACTIVE, 0, date,
                "msg");
        // save (id1 is active)
        fileStyleProfileRepositoryUnderTest.save(activeProfile);
        fileStyleProfileRepositoryUnderTest.save(inactiveProfile);
        // find active profile
        final Optional<StyleProfileEntity> result = fileStyleProfileRepositoryUnderTest.findActiveProfile(projectKey, language);
        assertThat(result.get()).isEqualTo(activeProfile);
        // find by projectKey
        final List<StyleProfileEntity> result1 = fileStyleProfileRepositoryUnderTest.findByProject(projectKey);
        assertEquals(2, result1.size());
        // set active (id2 is active)
        fileStyleProfileRepositoryUnderTest.setActiveStat("id2");
        final Optional<StyleProfileEntity> result2 =
                fileStyleProfileRepositoryUnderTest.findActiveProfile(projectKey, language);
        assertThat(result2.get()).isEqualTo(inactiveProfile);
        assertEquals(StyleProfileStatus.INACTIVE, fileStyleProfileRepositoryUnderTest.findById("id1").get().getStatus());
        assertTrue(result2.get().getVersion() > activeProfile.getVersion());

        // check ACTIVE profile uniqueness (id3 is active)
        final StyleProfileEntity newProfile = new StyleProfileEntity("id3", "storagePath", projectKey,
                language, StyleProfileStatus.ACTIVE, 0, date,
                "msg");
        fileStyleProfileRepositoryUnderTest.save(newProfile);
        final Optional<StyleProfileEntity> result3 =
                fileStyleProfileRepositoryUnderTest.findActiveProfile(projectKey, language);
        assertTrue(result3.get().getVersion() == newProfile.getVersion());
        assertTrue(fileStyleProfileRepositoryUnderTest.findByProject(projectKey)
                .stream().filter(profile -> profile.getStatus() == StyleProfileStatus.ACTIVE)
                .toList().size() == 1);

        // delete
        fileStyleProfileRepositoryUnderTest.deleteById("id3");
        assertEquals(fileStyleProfileRepositoryUnderTest.findActiveProfile(projectKey, language).get().getStyleProfileId(), "id2");
        fileStyleProfileRepositoryUnderTest.deleteById("id2");
        assertEquals(fileStyleProfileRepositoryUnderTest.findActiveProfile(projectKey, language).get().getStyleProfileId(), "id1");
        fileStyleProfileRepositoryUnderTest.deleteById("id1");
        assertTrue(fileStyleProfileRepositoryUnderTest.findActiveProfile(projectKey, language).isEmpty());
    }

}
