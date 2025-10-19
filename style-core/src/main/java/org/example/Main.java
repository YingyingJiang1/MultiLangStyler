package org.example;

import org.example.controller.Controller;
import org.example.global.GlobalInfo;
import org.slf4j.LoggerFactory;
import pascal.taie.World;
import pascal.taie.config.LoggerConfigs;
import pascal.taie.config.Options;
import pascal.taie.frontend.soot.SootWorldBuilder;
import pascal.taie.language.classes.JClass;
import org.apache.logging.log4j.LogManager;


public class Main {


    public static void main(String[] args) {
        Configuration config = CLIArgumentParser.parseArgs(args);
        long start = System.currentTimeMillis();

        if (config != null) {
            GlobalInfo.setConf(config);
            Controller controller = new Controller(config);
            if (config.styleCheckOnly) {
                controller.checkStyle(config.applicationCollection);
            } else {
                controller.execute();
            }

            if (!RunStatistic.stat.isEmpty()) {
//                RunStatistic.save(RunStatistic.getDefaultOutputPath(config.getSrc(), config.getResOutDir()));
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间: " + (end - start) + " ms");
    }
//
//    public static void main(String[] args) {
//        String code = "List<String> arr = new ArrayList<>();";
//        MyParser parser = MyParserFactory.createParser("java");
//        ParseTree t = parser.parseFromString(code);
//        System.out.println(t.toStringTree(new JavaParser(null)));
//
//    }


}