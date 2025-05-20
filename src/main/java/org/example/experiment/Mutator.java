package org.example.experiment;

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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.dom4j.DocumentException;
import org.example.Configuration;
import org.example.controller.Applicator;
import org.example.controller.Extractor;
import org.example.controller.Preprocessor;
import org.example.controller.StylerContainer;
import org.example.global.GlobalInfo;
import org.example.myException.ApplyException;
import org.example.myException.ExtractException;
import org.example.parser.common.MyParseTreeWalker;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.java.Spot;
import org.example.parser.java.SpotDetectorListener;
import org.example.style.ProgramStyle;
import org.example.style.SelfStyleManager;
import org.example.style.Style;
import org.example.style.StyleFileIO;
import org.example.styler.Styler;
import org.example.styler.structure.EquivalentStructure;
import org.example.styler.structure.EquivalentStructureManager;
import org.example.styler.structure.StructureStyler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mutator {
    private static final String CONF_FILE = "/equivalencesConf.json";

    private static final Logger logger = LoggerFactory.getLogger(Mutator.class);
    private final MyParser parser;

    private Mutator(String language) {
        Configuration config = new Configuration();
        GlobalInfo.setConf(config);
        GlobalInfo.setLanguage(language);
        this.parser = MyParserFactory.createParser(language);
    }

    /**
     * Given a style file, applies the rules in the style file to the input snippet.
     * @param language the language of the input code
     * @param snippet the input code
     * @param styleFile the path of the style file
     * @return the transformed code
     */
    public static String apply(String language, String snippet, String styleFile) {
        Mutator mutator = new Mutator(language);
        try {
            StylerContainer container = mutator.extractStyleFile(styleFile);
            return applyWithContainer(mutator, snippet, container);
        } catch (DocumentException e) {
            logger.error("Failed to read the style file: {}", e.getMessage());
        }
        return null;
    }

    /**
     * Given a sequence of structure indices, applies the rules in the style file to the input snippet.
     * @param language the language of the input code
     * @param snippet the input code
     * @param sequence the sequence of structure indices
     * @return the transformed code
     */
    public static String span(String language, String snippet, List<Integer> sequence) {
        StylerContainer container = new StylerContainer();
        StructureStyler structureStyler = container.getStylers().stream()
                .filter(StructureStyler.class::isInstance)
                .map(StructureStyler.class::cast)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("StructureStyler not found"));
        structureStyler.setAs(language, sequence);
        Mutator mutator = new Mutator(language);
        return applyWithContainer(mutator, snippet, container);
    }

    private static String applyWithContainer(Mutator mutator, String snippet, StylerContainer container) {
        try {
            if (mutator.parser.parseFromString(snippet) == null) {
                logger.info("Compilation error.");
                return null;
            }
            ProgramStyle selfStyle = mutator.extractSelf();
            SelfStyleManager.addStyle(null, selfStyle);
            Preprocessor preprocessor = new Preprocessor();
            List<Token> tokens = Applicator.applyRules(mutator.parser, container, preprocessor);
            tokens.removeIf(token -> token.getType() == mutator.parser.getEOF());
            preprocessor.restoreState(tokens, mutator.parser);
            return tokens.stream()
                    .map(Token::getText)
                    .reduce("", String::concat);
        } catch (ExtractException e) {
            logger.error("Failed to extract rules from the input code.");
        } catch (ApplyException e) {
            logger.error("Failed to apply rules.");
        }
        return null;
    }

    private StylerContainer extractStyleFile(String styleFile) throws DocumentException {
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

    private ProgramStyle extractSelf() throws ExtractException {
        Preprocessor preprocessor = new Preprocessor();
        StylerContainer selfContainer = new StylerContainer();
        Extractor.extractRules(parser, selfContainer, preprocessor);
        ProgramStyle selfStyle = new ProgramStyle();
        for (Styler styler : selfContainer.getStylers()) {
            styler.extractFinalize();
            selfStyle.add(styler.getStyle());
        }
        return selfStyle;
    }

    public static int countSpots(String language, String snippet) {
        Mutator mutator = new Mutator(language);
        Map<Integer, Spot> spots = new HashMap<>();
        SpotDetectorListener listener = new SpotDetectorListener(spots, mutator.parser);
        ParseTree tree = mutator.parser.parseFromString(snippet);
        MyParseTreeWalker walker = new MyParseTreeWalker();
        walker.walk(listener, tree);
        return spots.size();
    }

    /**
     * Counts the number of variants of given code snippet transformed in pairwise fashion.
     * @param language the language of the input code
     * @param snippet the input code
     * @return the number of variants
     */
    public static long countPairwiseCases(String language, String snippet) {
        Mutator mutator = new Mutator(language);
        Map<Integer, Spot> spots = new HashMap<>();
        SpotDetectorListener listener = new SpotDetectorListener(spots, mutator.parser);
        ParseTree tree = mutator.parser.parseFromString(snippet);
        MyParseTreeWalker walker = new MyParseTreeWalker();
        walker.walk(listener, tree);
        var combinations = generateCombinations(language, spots);
        return combinations.size();
    }

    private static List<List<Integer>> generateCombinations(String language, Map<Integer, Spot> spots) {
        Map<Integer, Integer> equivalentsCounts = getEquivalentsCounts(language);
        Path modelFile = null;
        try {
            // create a model file contains lines in the format of "<spot key>: 1, 2, 3, ..., <equivalent count>"
            modelFile = Files.createTempFile("model", ".txt");
            List<String> lines = new ArrayList<>();
            for (var entry : spots.entrySet()) {
                int tokenIndex = entry.getKey();
                Spot spot = entry.getValue();
                int equivalentCount = equivalentsCounts.getOrDefault(spot.structureIndex(), 0);
                lines.add(String.format("SpotAt%d: %s", tokenIndex, IntStream.range(0, equivalentCount).mapToObj(String::valueOf).collect(Collectors.joining(", "))));
            }
            Files.write(modelFile, lines, StandardCharsets.UTF_8);

            // execute `pict model_file`, count the number of pairwise cases and return
            String[] command = {"pict", modelFile.toString()};
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
     * For each structure, gets the number of equivalents for each structure in the equivalent config file.
     * @param parserClass the parser class
     * @return a map from structure id to equivalent count
     */
    public static Map<Integer, Integer> getEquivalentsCounts(String language) {
        Mutator mutator = new Mutator(language);
        List<EquivalentStructure> equivalences = EquivalentStructureManager.getInstance().loadEquivalences(mutator.parser.getClass(), CONF_FILE);
        return equivalences.stream()
                .collect(Collectors.toMap(EquivalentStructure::getId, structure -> structure.getForests().size()));
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            logger.error("Usage: java Mutator <input file>");
        }
        final List<String> snippets = List.of(
                "public class Foo {\n    public static void main(String[] args) {\n        bar();\n    }\n\n    private static boolean bar() {\n        return true;\n    }\n}\n",
                "import java.util.*;\nimport java.io.*;\npublic class EdE {\n\n\tpublic static void main(String[] args) throws Exception{\n\t\tlong num = 1000000007;\n\n\t\t// TODO Auto-generated method stub\n \t\tBufferedReader bf = new BufferedReader(new InputStreamReader(System.in));\n \t\tPrintWriter out = new PrintWriter(System.out);\n \t\tint n = Integer.parseInt(bf.readLine());\n \t\tlong[] dp = new long[n+1];\n \t\tint[] isPrime = new int[n+1];\n\t\tArrays.fill(isPrime, 1);\n\t\tint[] mu = new int[n+1];\n\t\tArrays.fill(mu,  1);\n\t\tfor(int i = 2;i<=n;i++){\n\t\t\tif (isPrime[i] == 1){\n\t\t\t\tfor(int j = i;j<=n;j+=i){\n\t\t\t\t\tif (j > i)\n\t\t\t\t\t\tisPrime[j] = 0;\n\t\t\t\t\tif (j%(i*i) == 0)\n\t\t\t\t\t\tmu[j] = 0;\n\t\t\t\t\tmu[j] = -mu[j];\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tlong sum = 0;\n\t\tfor(int i = 2;i<=n;i++){\n\t\t\tsum+=(((long)(0-mu[i])*((((long)(n/i))*power(n-n/i, num-2, num))%num))%num+num)%num;\n\t\t\tsum%=num;\n\t\t\t\n\t\t}\n\t\tsum+=1;\n\t\tsum%=num;\n \t\tout.println(sum);\n\t \t\t\n \t\tout.close();\n \t\t\n \t\t\n \t\t\n \t}\n\tpublic static long power(long x, long y, long mod){\n\t\tlong ans = 1;\n\t\twhile(y>0){\n\t\t\tif (y%2==1)\n\t\t\t\tans = (ans*x)%mod;\n\t\t\tx = (x*x)%mod;\n\t\t\ty/=2;\n\t\t}\n\t\treturn ans;\n\t}\n}\n \t\n \n//StringJoiner sj = new StringJoiner(\" \"); \n//sj.add(strings)\n//sj.toString() gives string of those stuff w spaces or whatever that sequence is\n\n \t\t\n \t\t\n \t\t\n \t\t\n\t\n\n");
        List<Integer> sequence = List.of(2, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 0, 0, 0, 0, 2, 1, 0, 0);
        var mutant = span("java", snippets.get(1), sequence);
        logger.info(mutant.toString());
    }
}
