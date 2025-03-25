package org.example.experiment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class TransformAuthorPair {
    public static final Logger logger = LoggerFactory.getLogger(Transform.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        if (args.length < 5) {
            logger.error("Wrong number of arguments, 2 are required.Arguments:<input_file>, <src_code_directory>, <style_example_directory>, <output_directory>, <the number of threads>");
        }

        String inputFile = args[0];
        String srcCodesDir = args[1];
        String style_example_dir = args[2];
        String outputDirectory = args[3];
        int numberOfThreads = Integer.parseInt(args[4]);

        AuthorPairDataset dataset = new AuthorPairDataset();
        dataset.read(inputFile);

        List<AuthorPairDataset> splitedDatasets = dataset.splitData(numberOfThreads);

        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<Integer>> futures = new ArrayList<>();
        for (AuthorPairDataset dataset1 : splitedDatasets) {
            Future<Integer> future = executorService.submit(() -> worker(dataset1, srcCodesDir,style_example_dir, outputDirectory));
            futures.add(future);
        }


        // 关闭线程池并等待所有任务完成
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        // 关闭线程池
        executorService.shutdown();
    }

    // 模拟数据处理的方法
    private static int worker(AuthorPairDataset data, String codeDirectory, String style_example_dir, String outputDirectory) {
        for  (AuthorPairDataset.AuthorPair pair : data.getAllPairs()) {
            Path srcFile = Paths.get(codeDirectory, pair.src_author);
            Path targetFile = Paths.get(style_example_dir, pair.target_author);
            String resultPath = Paths.get(outputDirectory, pair.result_author).toString();
            if  (!new File(resultPath).exists()) {
                new File(resultPath).mkdirs();
            }
            String[] args = {"-src", srcFile.toString(), "-target", targetFile.toString(), "-d", resultPath};
            try {
                logger.info("thread {} is working... src_author:{}, target_author:{}",
                        Thread.currentThread().getId(), pair.src_author, pair.target_author);
                Main.main(args);  // 调用主方法进行处理
            } catch (Exception e) {
                logger.error("Error processing unit: src_author:{}, target_author:{}",
                        pair.src_author, pair.target_author, e);
            }

        }
        logger.info("Worker processed {} pairs successfully.", data.size());
        return 0;
    }
}

class AuthorPairDataset {
    private List<AuthorPair> authorPairList = new ArrayList<>();

    public AuthorPairDataset() {}

    public AuthorPairDataset(List<AuthorPair> data) {
        authorPairList = new ArrayList<>(data);
    }

    public static class AuthorPair {

        public String src_author, target_author, result_author;

    }

    public List<AuthorPair> read(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 每行是一个JSON对象，反序列化成Data对象
                AuthorPair authorPair = objectMapper.readValue(line, AuthorPair.class);
                authorPairList.add(authorPair);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authorPairList;
    }

    public void write(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (AuthorPair authorPair : authorPairList) {
                // 将Data对象序列化为JSON字符串
                String json = objectMapper.writeValueAsString(authorPair);
                writer.write(json);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<AuthorPairDataset> splitData(int chunkNumber) {
        int chunkSize = (int) Math.ceil((double) authorPairList.size() / chunkNumber);
        List<AuthorPairDataset> result = new ArrayList<>();
        for (int i = 0; i < chunkNumber; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, authorPairList.size());
            result.add(new AuthorPairDataset(authorPairList.subList(start, end)));
        }
        return result;
    }

    public int size() {
        return authorPairList.size();
    }

    public List<AuthorPair> getAllPairs() {
        return authorPairList;
    }


}
