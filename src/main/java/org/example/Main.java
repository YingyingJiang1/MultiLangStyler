package org.example;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.controller.Controller;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.java.antlr.JavaParser;
import org.example.styler.ModelClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Configuration config = CLIArgumentParser.parseArgs(args);
        if (config != null) {
            GlobalInfo.setConf(config);
            Controller controller = new Controller(config);
            controller.execute();
            RunStatistic.printStatistic();
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