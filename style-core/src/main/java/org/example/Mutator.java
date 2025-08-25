package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.controller.Applicator;
import org.example.controller.Extractor;
import org.example.controller.StylerContainer;
import org.example.controller.TokenAugmentor;
import org.example.global.GlobalInfo;
import org.example.myException.ApplyException;
import org.example.myException.ExtractException;
import org.example.parser.common.MyParseTreeWalker;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.java.Spot;
import org.example.parser.java.SpotDetectorListener;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.style.StyleFileIO;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.format.indention.IndentionStyler;
import org.example.styler.format.newline.NewlineStyler;
import org.example.styler.format.space.SpaceStyler;
import org.example.styler.structure.EquivalentStructure;
import org.example.styler.structure.EquivalentStructureManager;
import org.example.styler.structure.StructureStyler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mutator {
    private static final String CONF_FILE = "/equivalences.xml";
    private static final Set<Class<? extends Styler>> FORMAT_STYLERS = Set.of(
                NewlineStyler.class, SpaceStyler.class, IndentionStyler.class);

    private static final Logger logger = LoggerFactory.getLogger(Mutator.class);

    private Mutator() {
    }

    /**
     * Given a style file, applies the rules in the style file to the input snippet.
     *
     * @param language  the language of the input code
     * @param snippet   the input code
     * @param styleFile the path of the style file
     * @return the transformed code
     */
    public static String apply(String language, String snippet, String styleFile) {
        GlobalInfo.setConf(new Configuration());
        GlobalInfo.setLanguage(language);

        StylerContainer container = extractFromFile(language, styleFile);
        return applyWithContainer(language, snippet, container);
    }

    /**
     * Given a sequence of structure indices, applies the rules in the style file to
     * the input snippet.
     *
     * @param language the language of the input code
     * @param snippet  the input code
     * @param sequence the sequence of structure indices. -1 means no transformation
     * @return the transformed code
     */
    public static synchronized String span(String language, String snippet, List<Integer> sequence) {
        GlobalInfo.setConf(new Configuration());
        GlobalInfo.setLanguage(language);

        StylerContainer container = new StylerContainer();
        StructureStyler structureStyler = container.getStylers().stream()
                .filter(StructureStyler.class::isInstance)
                .map(StructureStyler.class::cast)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("StructureStyler not found"));
        structureStyler.setAs(language, sequence);
        ProgramStyle selfStyle = extractFromCode(language, snippet);
        if (selfStyle == null) {
            return null;
        }
        for (Styler styler : container.getStylers()) {
            if (styler.isEnable(Stage.APPLY) && FORMAT_STYLERS.contains(styler.getClass())) {
                styler.setStyle(selfStyle.getStyle(styler.getStyle().getStyleName()));
            }
        }
        /*
         * TODO: 1. optional brace configuration
         *       2. newline, space, and indentation configuration
         */
        return applyWithContainer(language, snippet, container);
    }

    private static String applyWithContainer(String language, String snippet, StylerContainer container) {
        try {
            MyParser parser = MyParserFactory.createParser(language);
            if (parser.parseFromString(snippet) == null) {
                logger.info("Compilation error.");
                return null;
            }
            TokenAugmentor tokenAugmentor = new TokenAugmentor();
            List<Token> tokens = Applicator.applyRules(parser, container, tokenAugmentor);
            if (tokens.get(tokens.size() - 1).getType() == parser.getEOF()) {
                tokens.remove(tokens.size() - 1); // remove EOF token
            }
            tokenAugmentor.restoreState(tokens, parser);
            return tokens.stream()
                    .map(Token::getText)
                    .reduce("", String::concat);
        } catch (ApplyException e) {
            logger.error("Failed to apply rules.");
        }
        return null;
    }

    private static StylerContainer extractFromFile(String language, String styleFile) {
        MyParser parser = MyParserFactory.createParser(language);
        ProgramStyle programStyle = StyleFileIO.read(styleFile, parser);
        StylerContainer container = new StylerContainer();
        for (Styler styler : container.getStylers()) {
            Style style = programStyle.getStyle(styler.getStyle().getStyleName());
            if (style != null) {
                styler.setStyle(style);
            }
        }
        return container;
    }

    public static ProgramStyle extractFromCode(String language, String snippet) {
        GlobalInfo.setConf(new Configuration());
        GlobalInfo.setLanguage(language);

        MyParser parser = MyParserFactory.createParser(language);
        if (parser.parseFromString(snippet) == null) {
            logger.info("Compilation error.");
            return null;
        }
        StylerContainer container = new StylerContainer();
        TokenAugmentor tokenAugmentor = new TokenAugmentor();
        try {
            Extractor.extractRules(parser, container, tokenAugmentor);
        } catch (ExtractException e) {
            logger.error("Failed to extract rules: {}", e.getMessage());
            return null;
        }
        ProgramStyle programStyle = new ProgramStyle();
        for (Styler styler : container.getStylers()) {
            if (styler.isEnable(Stage.EXTRACT)) {
                styler.extractFinalize();
            }
            programStyle.add(styler.getStyle());
        }
        return programStyle;
    }

    public static int countSpots(String language, String snippet) {
        Map<Integer, Spot> spots = new HashMap<>();
        MyParser parser = MyParserFactory.createParser(language);
        SpotDetectorListener listener = new SpotDetectorListener(spots, parser);
        ParseTree tree = parser.parseFromString(snippet);
        MyParseTreeWalker walker = new MyParseTreeWalker();
        walker.walk(listener, tree);
        return spots.size();
    }

    /**
     * Counts the number of variants of given code snippet transformed in pairwise
     * fashion.
     *
     * @param language the language of the input code
     * @param snippet  the input code
     * @return the number of variants
     */
    public static long countPairwiseCases(String language, String snippet) {
        Map<Integer, Spot> spots = new HashMap<>();
        MyParser parser = MyParserFactory.createParser(language);
        SpotDetectorListener listener = new SpotDetectorListener(spots, parser);
        ParseTree tree = parser.parseFromString(snippet);
        MyParseTreeWalker walker = new MyParseTreeWalker();
        walker.walk(listener, tree);
        var combinations = generateCombinations(language, spots);
        return combinations.size();
    }

    private static List<List<Integer>> generateCombinations(String language, Map<Integer, Spot> spots) {
        Map<Integer, Integer> equivalentsCounts = getEquivalentsCounts(language);
        Path modelFile = null;
        try {
            modelFile = Files.createTempFile("model", ".txt");
            List<String> lines = new ArrayList<>();
            for (var entry : spots.entrySet()) {
                int tokenIndex = entry.getKey();
                Spot spot = entry.getValue();
                int equivalentCount = equivalentsCounts.getOrDefault(spot.structureIndex(), 0);
                lines.add(String.format("SpotAt%d: %s", tokenIndex, IntStream.range(0, equivalentCount)
                        .mapToObj(String::valueOf).collect(Collectors.joining(", "))));
            }
            Files.write(modelFile, lines, StandardCharsets.UTF_8);

            // execute `pict model_file`, count the number of pairwise cases and return
            String[] command = { "pict", modelFile.toString() };
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                return reader.lines()
                        .skip(1)
                        .map(line -> line.split("\\s+"))
                        .map(Arrays::asList)
                        .map(list -> list.stream()
                                .map(Integer::parseInt)
                                .toList())
                        .toList();
            }
        } catch (IOException e) {
            logger.error("An I/O error occurred: {}", e.getMessage());
        } finally {
            if (modelFile != null) {
                try {
                    Files.delete(modelFile);
                } catch (IOException e) {
                    logger.error("An I/O error occurred: {}", e.getMessage());
                }
            }
        }
        return new ArrayList<>();
    }

    /**
     * For each structure, gets the number of equivalents for each structure in the
     * equivalent config file.
     *
     * @param parserClass the parser class
     * @return a map from structure id to equivalent count
     */
    public static Map<Integer, Integer> getEquivalentsCounts(String language) {
        MyParser parser = MyParserFactory.createParser(language);
        List<EquivalentStructure> equivalences = EquivalentStructureManager.getInstance()
                .loadEquivalences(parser.getClass(), CONF_FILE);
        return equivalences.stream()
                .collect(Collectors.toMap(EquivalentStructure::getId, structure -> structure.getForests().size()));
    }
}
