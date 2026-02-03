package org.example.web;

import org.example.MyEnvironment;
import org.example.config.MyConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class StyleTaskExecutorConfig {

    @Bean("ioTaskPool")
    public ExecutorService ioTaskPool() {
        MyConfiguration.ProjectConfig.ThreadPoolConfig tp = MyEnvironment.getProjectConfig().getThreadPool();
        return new ThreadPoolExecutor(
                tp.getCorePoolSize(),
                tp.getMaxPoolSize(),
                tp.getKeepAliveSeconds(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(tp.getQueueCapacity()),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

    @Bean("shortTaskPool")
    public ExecutorService shortTaskPool() {
        MyConfiguration.ProjectConfig.ThreadPoolConfig tp = MyEnvironment.getProjectConfig().getThreadPool();
        return new ThreadPoolExecutor(
                tp.getCorePoolSize(),
                tp.getMaxPoolSize(),
                tp.getKeepAliveSeconds(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(tp.getQueueCapacity()),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}

