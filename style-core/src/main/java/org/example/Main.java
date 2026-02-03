package org.example;

import org.example.config.MyConfiguration;
import org.example.stylekit.Coordinator;
import org.example.stylekit.TaskOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example.config"})
public class Main {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        MyConfiguration config = context.getBean(MyConfiguration.class);

        MyEnvironment.setConf(config);
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