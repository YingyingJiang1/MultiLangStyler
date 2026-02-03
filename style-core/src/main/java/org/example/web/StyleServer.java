package org.example.web;

import org.example.Main;
import org.example.MyEnvironment;
import org.example.config.MyConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example"})
public class StyleServer {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(StyleServer.class);
//        application.addInitializers(new org.example.MyEnvironmentInitializer());
        application.run(args);
    }
}
