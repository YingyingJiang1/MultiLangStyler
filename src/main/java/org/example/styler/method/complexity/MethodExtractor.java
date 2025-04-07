package org.example.styler.method.complexity;

import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.lang3.tuple.MutablePair;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.java.antlr.JavaParser;
import org.example.styler.method.complexity.style.MethodComplexityProperty;
import org.example.utils.ModelClient;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MethodExtractor {

    private MutablePair<String, List<String>> codelines;

    private static MethodExtractor instance = new MethodExtractor();

    public static MethodExtractor getInstance() {
        return instance;
    }

    private MethodExtractor() {
    }

    public ExtendContext extractMethod(ExtendContext methodDec, MyParser parser, MethodComplexityProperty targetProperty) {
        List<Candidate> candidates = getAllCandidates(methodDec, parser, targetProperty);
        candidates = validateAndRankCandidates(methodDec, candidates, parser);

        return null;
    }


    protected List<Candidate> getAllCandidates(ExtendContext methodDec, MyParser parser, MethodComplexityProperty targetProperty) {
        List<Candidate> candidates = new ArrayList<Candidate>();

        StringBuilder promptBuilder = new StringBuilder();
        promptBuilder.append("Task Description:\n");
        promptBuilder.append("Given a method `m` " +
//                "and a target method complexity `C`, " +
        ", your task is to generate a list of candidate code snippets (candidates) that can be encapsulated into seperated methods. " +
                "Please follow the principles of high cohesion and low coupling when determining candidates."
//        "The goal is to ensure that the complexity of each resulting method is as close as possible to the target complexity C, " +
//        "while adhering to the principles of high cohesion and low coupling."
        );
        promptBuilder.append(String.format("\n### Method `m`:\n%s", readCodeLines(methodDec, parser)));
//        promptBuilder.append(String.format("\n### Target Complexity `C`:\n%s", targetProperty.avgComplexity.toReadableString()));

        promptBuilder.append("\nOutput:\n");
        promptBuilder.append("A list of candidates, where each candidate is represented by its start-line number and end-line number). Don't output any explanation!\n");
        promptBuilder.append("Output template: ```json[(<start-line>, <end-line>), (<start-line>, <end-line>)]```");


        String response = ModelClient.getInstance().sendRequest(promptBuilder.toString());


        return candidates;
    }

    protected List<Candidate> validateAndRankCandidates(ExtendContext methodDec, List<Candidate> candidates, MyParser parser) {
       return candidates;
    }

    protected String readCodeLines(ExtendContext methodDec, MyParser parser) {
        try {
            String filePath = parser.getSourceFile();
            if (codelines == null || !codelines.getLeft().equals(filePath)) {
                codelines = new MutablePair<>(filePath, Files.readAllLines(Paths.get(parser.getSourceFile())));
            }
        } catch (Exception e) {
            LoggerFactory.getLogger(MethodExtractor.class).error("Fail to read code lines.", e);
            codelines = null;
        }

        if (codelines == null) {
            return null;
        }

        int startLine = methodDec.getStart().getLine();
        int endLine = methodDec.getStop().getLine();
        return String.join("\n", codelines.getRight().subList(startLine - 1, endLine + 1));
    }


    static class Candidate {
        int startLine;
        int endLine;

    }

}
