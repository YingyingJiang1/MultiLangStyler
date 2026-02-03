package org.example;

import org.example.config.MyConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example.config"})
public class StyleServer {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        MyConfiguration config = context.getBean(MyConfiguration.class);
        MyEnvironment.setConf(config);
        SpringApplication.run(StyleServer.class, args);
    }
}
