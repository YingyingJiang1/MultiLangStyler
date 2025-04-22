package org.example.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.Configuration;
import org.example.global.GlobalInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModelClient {

	private static final Logger log = LoggerFactory.getLogger(ModelClient.class);
	private static URL modelURL = null;
    private static ModelClient instance = new ModelClient();

    public static ModelClient getInstance() {
        String url = GlobalInfo.getConf().getLlmConfig().getModelURL();
        if (url == null) {
            System.err.println("Model URL is not set.");
            return instance;
        }
        try {
            modelURL = new URL(url);
        } catch (Exception e) {
            System.err.println("Model URL is not valid.");
            return instance;
        }

        return instance;
    }

    private ModelClient() {}

    public List<String> sendRequestWithTemplate(String taskDescription, String constraints, String output_type) {
        String prompt = String.format(
                "Task Description:\n%s" +
                "Output in this template:\n" + "\n```%s<your output here>```\n" +
                "Constraints:\n%s",
        taskDescription, constraints, output_type);
        List<String> candidates = extractAnswer(sendRequest(prompt),  output_type);
        return candidates;
    }

    public String sendRequest(String prompt) {
        String serverType = GlobalInfo.getConf().getLlmConfig().getServerType();
        String jsonBody =  switch (serverType) {
            case "self" -> createSelfJsonBody(prompt);
            case "openrouter" -> createOpenrouterJsonBody(prompt);
            default -> null;
        };

        String response = communicate(jsonBody);
        return response;
    }


    private String toValidJsonStr(String str) {
        if (str == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            switch (c) {
                case '"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                default:
                    if (c < 0x20 || c > 0x7E) {
                        sb.append(String.format("\\u%04x", (int) c));
                    } else {
                        sb.append(c);
                    }
            }
        }
        return sb.toString();
    }

    private String createSelfJsonBody(String promptStr) {
        return String.format("{\"question\": \"%s\"}", toValidJsonStr(promptStr));
    }

    private String createOpenrouterJsonBody(String promptStr) {

        Configuration.LLMConfig llmConfig = GlobalInfo.getConf().getLlmConfig();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode requestBody = objectMapper.createObjectNode();
        requestBody.put("model", llmConfig.getModel());
        requestBody.put("prompt", toValidJsonStr(promptStr));
        requestBody.put("temperature", llmConfig.getTemperature());
        requestBody.put("max_new_tokens", llmConfig.getMaxNewTokens());

        // 将请求体转为 JSON 字符串
        try {
            String jsonBody = objectMapper.writeValueAsString(requestBody);
            System.out.println("Request Body: " + jsonBody);
            return jsonBody;
            // 发送请求代码...
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String communicate(String jsonBody) {
        if (modelURL == null || jsonBody == null) {
            return null;
        }
        try {
            // 打开连接
            HttpURLConnection con = (HttpURLConnection) modelURL.openConnection();

            con.setRequestMethod("POST");
            String apikey = GlobalInfo.getConf().getLlmConfig().getApikey();
            if (apikey != null) {
                con.setRequestProperty("Authorization", String.format("Bearer %s", apikey));
            }
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            // 发送POST请求
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // 读取响应内容
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                // 打印服务器返回的响应
                System.out.println("Response: " + response);
                ObjectMapper objectMapper = new ObjectMapper();
                Response responseObj = objectMapper.readValue(response.toString().getBytes(), Response.class);

                // 输出提取的 response 字段
                System.out.println("Response: " + responseObj.getResponse());
                return responseObj.response;
            }
        } catch (Exception e) {
            log.warn("Failed to communicate with llm.");
        }
        return null;
    }

    public List<String> extractAnswer(String response, String output_type) {
        if (response == null) {
            return null;
        }

        String reg = String.format("```%s(.*?)```", output_type);
        if (!response.contains(String.format("```%s", output_type))) {
            reg = "```(.*?)```";
        }
        Matcher matcher = Pattern.compile(reg, Pattern.DOTALL).matcher(response);
        List<String> allMatches = matcher.results().map(mr -> mr.group(1)).toList();
        return allMatches;
    }

    static class Response {
        private String response;

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }

        @Override
        public String toString() {
            return response;
        }
    }

}
