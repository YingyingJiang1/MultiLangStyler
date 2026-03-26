package org.example;

import org.example.stylekit.TaskOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.DefaultApplicationArguments;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class CliRunnerTest {

    private final PrintStream originalOut = System.out;
    private final java.io.InputStream originalIn = System.in;

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void run_shouldContinuouslyAcceptInputAndHandleEachValidCommand_untilExit() {
        // run

        // test extract command

        // test transfer command

        // test analyze command
    }

    @Test
    void run_shouldExitOnQuit_ignoreCase() {
        String input = "QuIt" + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8));

        RecordingCliRunner runner = new RecordingCliRunner();
        assertTimeoutPreemptively(Duration.ofSeconds(3),
                () -> runner.run(new DefaultApplicationArguments(new String[0])));

        assertThat(runner.handledOpIds).isEmpty();
        String output = out.toString(StandardCharsets.UTF_8);
        assertThat(countOccurrences(output, "stylekit> ")).isEqualTo(1);
    }

    static class RecordingCliRunner extends CliRunner {
        final List<Integer> handledOpIds = new ArrayList<>();

        @Override
        protected void handleOnce(TaskOptions taskOptions) {
            handledOpIds.add(taskOptions.getOpId());
        }
    }

    private static int countOccurrences(String source, String target) {
        int count = 0;
        int idx = 0;
        while ((idx = source.indexOf(target, idx)) != -1) {
            count++;
            idx += target.length();
        }
        return count;
    }
}
