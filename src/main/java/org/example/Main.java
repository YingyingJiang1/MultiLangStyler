package org.example;

import org.example.controller.Controller;
import org.example.global.GlobalInfo;
import org.example.styler.ModelClient;

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
//          SpringApplication.run(Application.class, args);
        }
    }



}