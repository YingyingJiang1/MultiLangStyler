package org.example.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.MyEnvironment;
import org.example.config.MyConfiguration;
import org.example.web.model.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(Controller.class)
//@Import(MyConfiguration.class)
@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StyleService mockStyleService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testRegisterProject() throws Exception {
        // Setup
        // Configure StyleService.registerProject(...).
        final Result result1 = new Result(false, ResultCode.SUCCESS, "msg", "data");
        final RegisterRequest request = new RegisterRequest();
        request.setClientId("clientId");
        request.setLocalPath("localPath");
        when(mockStyleService.registerProject(request)).thenReturn(result1);

        // Run the test and verify the results
        mockMvc.perform(post("/api/v1/projects")
                        .content(objectMapper.writeValueAsString(request)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(result1), true));
    }

    @Test
    void testRegisterProject_StyleServiceReturnsFailure() throws Exception {
        // Setup
        // Configure StyleService.registerProject(...).
        final Result result1 = Result.fail(ResultCode.SUCCESS, "msg");
        final RegisterRequest request = new RegisterRequest();
        request.setClientId("clientId");
        request.setLocalPath("localPath");
        when(mockStyleService.registerProject(request)).thenReturn(result1);

        // Run the test and verify the results
        mockMvc.perform(post("/api/v1/projects")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{}", true));
    }

    @Test
    void testExtractStyle() throws Exception {
        // Setup
        // Configure StyleService.extractStyle(...).
        final Result result1 = new Result(false, ResultCode.SUCCESS, "msg", "data");
        final ExtractRequest request = new ExtractRequest();
        request.setProjectKey("projectKey");
        request.setLanguage("language");
        request.setSourceType(SourceType.FILE);
        request.setSource("source");
        when(mockStyleService.extractStyle(request)).thenReturn(result1);

        // Run the test and verify the results
        mockMvc.perform(post("/api/v1/style-profiles")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{}", true));
    }

    @Test
    void testExtractStyle_StyleServiceReturnsFailure() throws Exception {
        // Setup
        // Configure StyleService.extractStyle(...).
        final Result result1 = Result.fail(ResultCode.SUCCESS, "msg");
        final ExtractRequest request = new ExtractRequest();
        request.setProjectKey("projectKey");
        request.setLanguage("language");
        request.setSourceType(SourceType.FILE);
        request.setSource("source");
        when(mockStyleService.extractStyle(request)).thenReturn(result1);

        // Run the test and verify the results
        mockMvc.perform(post("/api/v1/style-profiles")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{}", true));
    }

    @Test
    void testGetStyleProfileId() throws Exception {
        // Setup
        // Configure StyleService.findStyleProfileId(...).
        final Result result1 = new Result(false, ResultCode.SUCCESS, "msg", "data");
        when(mockStyleService.findStyleProfileId("projectKey", "language")).thenReturn(result1);

        // Run the test and verify the results
        mockMvc.perform(get("/api/v1/style-profiles/{projectKey}/{language}", "projectKey", "language")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{}", true));
    }

    @Test
    void testGetStyleProfileId_StyleServiceReturnsFailure() throws Exception {
        // Setup
        // Configure StyleService.findStyleProfileId(...).
        final Result result1 = Result.fail(ResultCode.SUCCESS, "msg");
        when(mockStyleService.findStyleProfileId("projectKey", "language")).thenReturn(result1);

        // Run the test and verify the results
        mockMvc.perform(get("/api/v1/style-profiles/{projectKey}/{language}", "projectKey", "language")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{}", true));
    }
}
