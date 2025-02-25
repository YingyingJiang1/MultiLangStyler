package org.example.experiment;

import org.example.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Transform {
    public static final Logger logger = LoggerFactory.getLogger(Transform.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        if (args.length < 4) {
            logger.error("Wrong number of arguments, 2 are required.Arguments:<input_file>, <code_directory>, <output_directory>, <the number of threads>");
        }

        String inputFile = args[0];
        String codesDir = args[1];
        String outputDirectory = args[2];
        int numberOfThreads = Integer.parseInt(args[3]);

        List<ExpUnit> expUnits = FileIO.read(inputFile);

        int chunkSize = (int) Math.ceil((double) expUnits.size() / numberOfThreads);

        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, expUnits.size());
            List<ExpUnit> chunk = expUnits.subList(start, end);

            // 提交任务给线程池
            Future<Integer> future = executorService.submit(() -> worker(chunk, codesDir, outputDirectory));

            futures.add(future);
        }

        int expUnitCount = 0;
        String outputFile = inputFile.replace(".jsonl", "-transformer.jsonl");
        for (Future<Integer> future : futures) {
            expUnitCount = future.get();  // 通过future.get()获取线程的返回值（此处为null）
            FileIO.write(outputFile, expUnits);
        }
        logger.info("{}/{} experiment units have been transformed successfully.", expUnitCount, expUnits.size());

        // 关闭线程池并等待所有任务完成
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        // 关闭线程池
        executorService.shutdown();
    }

    // 模拟数据处理的方法
    private static int worker(List<ExpUnit> data, String codeDirectory, String outputDirectory) {
        int count = 0;
        for  (ExpUnit expUnit : data) {
            Path srcFile = Paths.get(codeDirectory, expUnit.src.problem_id, expUnit.src.file_name);
            Path targetFile = Paths.get(codeDirectory, expUnit.target.problem_id, expUnit.target.file_name);
            String resultFileName = srcFile.getFileName().toString().replace(".java", "-") +
                    targetFile.getFileName().toString();
            String resultPath = Paths.get(outputDirectory, expUnit.src.problem_id, resultFileName).toString();
            String[] args = {"-src", srcFile.toString(), "-target", targetFile.toString(), "-f", resultPath};
            try {
                logger.info("thread {} is working... problem_id:{}, src:{}, target:{}",
                        Thread.currentThread().getId(), expUnit.src.problem_id,expUnit.src.file_name, expUnit.target.file_name);
                Main.main(args);  // 调用主方法进行处理
                File resultFile = new File(resultPath);
                if (resultFile.exists()) {
                    expUnit.result = new ExpUnit.Solution();
                    expUnit.result.problem_id = expUnit.src.problem_id;
                    expUnit.result.author_name = resultFileName.replace(".java", "");
                    expUnit.result.file_name = resultPath;
                    expUnit.result.author_type = "transformer";
                    expUnit.result.correct = false;
                    ++count;
                }
            } catch (Exception e) {
                logger.error("Error processing unit: problem_id:{}, src:{}, target:{}",
                        expUnit.src.problem_id,expUnit.src.file_name, expUnit.target.file_name, e);
            }

        }
        logger.info("Worker processed {} units successfully.", count);
        return count;
    }
}

