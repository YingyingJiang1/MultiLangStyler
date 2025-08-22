package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.Controller;
import org.example.global.GlobalInfo;
import org.example.styler.structure.EquivalentStructureManager;



public class Main {


    public static void main(String[] args) {
//        try {
//            EquivalentStructureManager.getInstance().updateConfFile("equivalencesConf.json");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Configuration config = CLIArgumentParser.parseArgs(args);
        if (config != null) {
            GlobalInfo.setConf(config);
            Controller controller = new Controller(config);
            if (config.styleCheckOnly) {
                controller.checkStyle(config.applicationCollection);
            } else {
                controller.execute();
            }

            if (!RunStatistic.stat.isEmpty()) {
                RunStatistic.save(RunStatistic.getDefaultOutputPath(config.getSrc(), config.getResOutDir()));
            }

        }
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