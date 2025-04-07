package org.example.styler.method.complexity;

import org.example.parser.common.context.ExtendContext;
import org.example.styler.method.complexity.style.MethodComplexityProperty;
import org.example.utils.ModelClient;

import java.util.ArrayList;
import java.util.List;

public class MethodExtractor {

    public ExtendContext extractMethod(ExtendContext context, MethodComplexityProperty targetProperty) {
        return null;
    }


    protected List<Candidate> getAllCandidates(ExtendContext context, MethodComplexityProperty targetProperty) {
        List<Candidate> candidates = new ArrayList<Candidate>();

        StringBuilder promptBuilder = new StringBuilder();

        String.format("Your are given a method `m` and ")

        ModelClient.getInstance().sendRequest();

    }


    static class Candidate {
        int startLine;
        int endLine;

    }

}
