package org.example;

import org.example.config.MyConfiguration;
import org.example.controller.Controller;
import org.example.controller.TaskOptions;
import org.example.style.ProgramStyle;
import org.example.utils.FileCollection;
import org.example.utils.FileCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example.config"})
public class Main {


//    public static void main(String[] args) {
//        test();
//        ConfigurationManager config = CLIArgumentParser.parseArgs(args);
//        long start = System.currentTimeMillis();
//
//        if (config != null) {
//            MyEnvironment.setConf(config);
//            Controller controller = new Controller(config, new CppStylerContainer());
//            if (config.styleCheckOnly) {
//                controller.checkStyle(config.applicationCollection);
//            } else {
//                controller.execute();
//            }
//
//            if (!RunStatistic.stat.isEmpty()) {
////                RunStatistic.save(RunStatistic.getDefaultOutputPath(config.getSrc(), config.getResOutDir()));
//            }
//
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("执行时间: " + (end - start) + " ms");
//    }


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        MyConfiguration config = context.getBean(MyConfiguration.class);

//        MyEnvironment.setConf(config);

        // 解析命令行参数
        TaskOptions taskOptions = CLIArgumentParser.parseArgs(args);

        long start = System.currentTimeMillis();

        if (config != null) {
            Controller controller = new Controller();

            controller.execute(config, taskOptions);

            if (!RunStatistic.stat.isEmpty()) {
                // RunStatistic.save(...)
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("执行时间: " + (end - start) + " ms");
    }



}