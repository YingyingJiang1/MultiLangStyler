package org.example;

import org.example.config.MyConfiguration;
import org.example.stylekit.Coordinator;
import org.example.stylekit.TaskOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"org.example"})
public class Main {

    public static void main(String[] args) {

        Coordinator coordinator = new Coordinator();

        // 解析命令行参数
        TaskOptions taskOptions = CLIArgumentParser.parseArgs(args);
        switch (taskOptions.getOpId()) {
            case TaskOptions.APPLY:
                coordinator.transferStyle(taskOptions);
                break;
            case TaskOptions.EXTRACT:
                coordinator.extractStyle(taskOptions);
                break;
            case TaskOptions.ANALYZE:
                coordinator.analyzeInconsistency(taskOptions);
                break;
            default:
                System.out.println("无效的操作选项");
        }
    }
}