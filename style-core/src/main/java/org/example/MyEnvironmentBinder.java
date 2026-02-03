package org.example;

import jakarta.annotation.PostConstruct;
import org.example.config.MyConfiguration;
import org.springframework.stereotype.Component;

@Component
public class MyEnvironmentBinder {

    private final MyConfiguration conf;

    public MyEnvironmentBinder(MyConfiguration conf) {
        this.conf = conf;
    }

    @PostConstruct
    public void bind() {
        MyEnvironment.setConf(conf);
    }
}
