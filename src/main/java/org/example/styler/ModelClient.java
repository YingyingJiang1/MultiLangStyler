package org.example.styler;

import org.example.global.GlobalInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class ModelClient {

	private static final Logger log = LoggerFactory.getLogger(ModelClient.class);
	private static URL modelURL = null;
    private static ModelClient instance = new ModelClient();

    public static ModelClient getInstance() {
        String url = GlobalInfo.getConf().getModelURL();
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

    public String sendRequest(String prompt) {
        try {
            // 打开连接
            HttpURLConnection con = (HttpURLConnection) modelURL.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            // 构造请求的JSON体
//            StringBuilder validJsonText = new StringBuilder();
//            for (int i = 0; i < prompt.length(); i++) {
//                char c = prompt.charAt(i);
//                if (c == '"' || c == '{' || c == '}') {
//                    validJsonText.append("\\\\");
//                }
//                validJsonText.append(c);
//            }
            String jsonBody = String.format("{\"question\": \"%s\"}", prompt.replace("\"", "\\\""));
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
//                System.out.println("Response: " + response.toString());
                return response.toString();
            }
        } catch (Exception e) {
            log.error("e: ", e);
        }
        return null;
    }

}
