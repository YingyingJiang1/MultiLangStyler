package org.example.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.web.model.dto.*;
import org.example.web.model.entity.ProjectEntity;
import org.example.web.model.entity.StyleProfileEntity;
import org.example.web.repository.ProjectRepository;
import org.example.web.repository.StyleProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class StyleServiceTest {

    @Mock
    private ProjectRepository mockProjectRepository;
    @Mock
    private StyleProfileRepository mockStyleProfileRepository;

    private StyleService styleServiceUnderTest;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        styleServiceUnderTest = new StyleService(mockProjectRepository, mockStyleProfileRepository);
    }

    @Test
    void testRegisterProject_projectKeyExists() {
        // Setup
        final RegisterRequest request = new RegisterRequest();
        request.setClientId("clientId");
        request.setLocalPath("localPath");

        when(mockProjectRepository.findProjectKey("clientId", "localPath")).thenReturn("projectKey");
        CompletableFuture<Result> result = styleServiceUnderTest.registerProject(request);
        assertTrue(result.isDone());
        final Result actual = result.join();
        assertTrue(actual.isSuccess());
        assertEquals(ResultCode.SUCCESS.name(), actual.getCode());
        assertEquals("projectKey", actual.getData());
    }

    @Test
    void testRegisterProject_projectKeyNotExist() {
        // Setup
        final RegisterRequest request = new RegisterRequest();
        request.setClientId("clientId");
        request.setLocalPath("localPath");

        // project key not exist
        when(mockProjectRepository.findProjectKey("clientId", "localPath")).thenReturn(null);
        CompletableFuture<Result> result = styleServiceUnderTest.registerProject(request);
        assertTrue(result.isDone());
        verify(mockProjectRepository).findProjectKey("clientId", "localPath");
        verify(mockProjectRepository).save(any(ProjectEntity.class));
    }

    @Test
    void testFindStyleProfileId_StyleProfileRepositoryReturnsAbsent() {
        // Setup
        when(mockStyleProfileRepository.findActiveProfile("projectKey", "java")).thenReturn(Optional.empty());

        // Run the test
        final CompletableFuture<Result> result = styleServiceUnderTest.findStyleProfileId("projectKey", "java");
        assertTrue(result.isDone());
        final Result actual = result.join();
        assertFalse(actual.isSuccess());
        assertEquals(ResultCode.LOOKUP_FAILURE.name(), actual.getCode());
        assertNull( actual.getData());
    }

    @Test
    void testGetStyleProfileEntity() throws JsonProcessingException {
        // Setup
        // Configure StyleProfileRepository.findById(...).
        final Optional<StyleProfileEntity> styleProfileEntity = Optional.of(
                new StyleProfileEntity("styleProfileId", "storagePath", "projectKey", "language",
                        new Date(), ""));
        when(mockStyleProfileRepository.findById("profileId")).thenReturn(styleProfileEntity);

        // Run the test
        final CompletableFuture<Result> result = styleServiceUnderTest.getStyleProfileEntity("profileId");
        assertTrue(result.isDone());
        final Result actual = result.join();
        assertTrue(actual.isSuccess());
        assertEquals(objectMapper.writeValueAsString(styleProfileEntity.get()), objectMapper.writeValueAsString(actual.getData()));
    }

    @Test
    void testExtractStyle() {
        // Setup
        final ExtractRequest request = new ExtractRequest();
        request.setProjectKey("projectKey");
        request.setLanguage("java");
        request.setSourceType(SourceType.STRING);
        request.setSource("class Main{}");

        final CompletableFuture<Result> result = styleServiceUnderTest.extractStyle(request);
        assertTrue(result.isDone());
        Result actual = result.join();
        verify(mockStyleProfileRepository).save(any(StyleProfileEntity.class));
    }
}
