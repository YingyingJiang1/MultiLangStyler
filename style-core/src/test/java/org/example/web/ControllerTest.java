package org.example.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.web.model.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(Controller.class)
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StyleService mockStyleService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testRegisterProject() throws Exception {
        // Setup
        // Configure StyleService.registerProject(...).
        Result result = Result.ok("data");
        final CompletableFuture<Result> resultCompletableFuture = CompletableFuture.completedFuture(result);
        final RegisterRequest request = new RegisterRequest();
        request.setClientId("clientId");
        request.setLocalPath("localPath");
        when(mockStyleService.registerProject(request)).thenReturn(resultCompletableFuture);

        comparePostResults(post("/api/v1/projects"), request, result);
    }

    @Test
    void testRegisterProject_StyleServiceReturnsFailure() throws Exception {
        // Setup
        // Configure StyleService.registerProject(...).
        Result result = Result.fail(ResultCode.REGISTER_FAILURE, "Invalid parameters for project register");
        final CompletableFuture<Result> resultCompletableFuture = CompletableFuture.completedFuture(result);
        final RegisterRequest request = new RegisterRequest();
        when(mockStyleService.registerProject(request)).thenReturn(resultCompletableFuture);

        comparePostResults(post("/api/v1/projects"), request, result);
    }


    @Test
    void testExtractStyle() throws Exception {
        Result result = Result.ok("data");
        final CompletableFuture<Result> resultCompletableFuture = CompletableFuture.completedFuture(result);
        final ExtractRequest request = new ExtractRequest();
        request.setProjectKey("projectKey");
        request.setLanguage("java");
        request.setSourceType(SourceType.FILE);
        request.setSource("source");
        when(mockStyleService.extractStyle(request)).thenReturn(resultCompletableFuture);

        comparePostResults(post("/api/v1/style-profiles"), request, result);
    }

    @Test
    void testExtractStyle_StyleServiceReturnsFailure() throws Exception {
        // Setup
        Result result = Result.fail(ResultCode.EXTRACT_FAILURE, "");
        final CompletableFuture<Result> resultCompletableFuture = CompletableFuture.completedFuture(result);
        final ExtractRequest request = new ExtractRequest();
        request.setProjectKey("projectKey");
        request.setLanguage("cpp");
        request.setSource("source");
        when(mockStyleService.extractStyle(request)).thenReturn(resultCompletableFuture);

        mockMvc.perform(post("/api/v1/style-profiles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.code").value("EXTRACT_FAILURE"))
                .andExpect(jsonPath("$.data").isEmpty());

        verify(mockStyleService, never()).extractStyle(any());

    }


    @Test
    void testGetStyleProfileId() throws Exception {
        Result result = Result.ok("data");
        final CompletableFuture<Result> resultCompletableFuture = CompletableFuture.completedFuture(result);
        when(mockStyleService.findStyleProfileId("proj-1", "java")).thenReturn(resultCompletableFuture);

        // Run the test and verify the results
        MockHttpServletRequestBuilder getBuilder = get("/api/v1/style-profiles/{projectKey}/{language}", "proj-1", "java");
        compareGetResults(getBuilder, null, result);
    }

    @Test
    void testGetStyleProfileId_StyleServiceReturnsFailure() throws Exception {
        Result result = Result.fail(ResultCode.EXTRACT_FAILURE, "");
        final CompletableFuture<Result> resultCompletableFuture = CompletableFuture.completedFuture(result);
        when(mockStyleService.findStyleProfileId("proj-1", "language")).thenReturn(resultCompletableFuture);

        // Run the test and verify the results
        mockMvc.perform(get("/api/v1/style-profiles/{projectKey}/{language}", "proj-1", "language")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.code").value("EXTRACT_FAILURE"))
                .andExpect(jsonPath("$.data").isEmpty());
    }


    private void comparePostResults(MockHttpServletRequestBuilder requestBuilder, Object request, Result expected) throws Exception {
        MvcResult mvcResult = mockMvc.perform(requestBuilder
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(request().asyncStarted())
                .andReturn();

        // 第二次 dispatch，真正拿结果
        mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        objectMapper.writeValueAsString(expected), false));
    }

    private void compareGetResults(MockHttpServletRequestBuilder requestBuilder, Object request, Result expected) throws Exception {
        MvcResult mvcResult = mockMvc.perform(requestBuilder.accept(MediaType.APPLICATION_JSON))
                .andExpect(request().asyncStarted())
                .andReturn();

        // 第二次 dispatch，真正拿结果
        mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        objectMapper.writeValueAsString(expected), false));
    }
}
