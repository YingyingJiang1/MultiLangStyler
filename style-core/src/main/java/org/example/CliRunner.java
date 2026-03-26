package org.example;

import org.example.stylekit.Coordinator;
import org.example.stylekit.TaskOptions;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("cli")
public class CliRunner implements ApplicationRunner {

    private final Coordinator coordinator = new Coordinator();

    @Override
    public void run(ApplicationArguments args) {
        // 只获取非选项参数，即 "--xxx" 这种 spring boot 的参数会被剔除
        String[] sourceArgs = args.getSourceArgs();
        TaskOptions taskOptions = CLIArgumentParser.parseArgs(sourceArgs);
        if (taskOptions == null) {
            System.out.println("Invalid arguments.");
            CLIArgumentParser.printHelp();
            return;
        }

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
        }
    }
}
