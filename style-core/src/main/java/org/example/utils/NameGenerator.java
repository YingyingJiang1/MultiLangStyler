package org.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.antlr.v4.runtime.RuleContext;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.naming.MyCaseFormat;
import org.example.styler.naming.format.AbbreviationLibrary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameGenerator {
    public static List<AlternativeNames> names = new ArrayList<>();

    static {
        names.add(new AlternativeNames(List.of("i", "j", "k")));
    }

    private static final Pattern pattern = Pattern.compile("(\"|```|`|')([a-zA-Z_][a-zA-Z0-9_]*)(\"|```|`|')");;

    public static String generateName(String suffix, MyCaseFormat caseFormat) {
        String name = "tmp";
        if (!suffix.isEmpty()) {
            name +=  "_" + suffix;
        }
        return MyCaseFormat.LOWER_UNDERSCORE.to(caseFormat, name);
    }

    public static String getAlternativeName(String oldName, List<String> conflictNames) {
        String newName = oldName;

        for (AlternativeNames name : names) {
            if (name.isAlternative(oldName)) {
                do {
                    newName = name.getName();
                } while (newName != null && (newName.equals(oldName) || conflictNames.contains(newName)));
                name.reset();
            }
        }
        return newName;
    }

    public static String generateMeaningfulName(ExtendContext identifier, MyParser parser, int nameLengthLimit) {
        ModelClient client = ModelClient.getInstance();
        if (client != null) {
            String codeContext = CodeContextExtractor.extractCodeContext(identifier, parser);
            String prompt = createPrompt(identifier, parser, codeContext, nameLengthLimit);
            String response = client.sendRequest(prompt);
            if (response == null) {
                return null;
            }
            try {
                List<String> existedNames = identifier.getFirstParentIf(parser::belongToStmt).getAllCtxsRecIf(parser::isIdentifier)
                        .stream().map(RuleContext::getText).toList();
                String name = extractNameFromResponse(response, codeContext);
                if (name != null && name.length() > nameLengthLimit) {
                    name = AbbreviationLibrary.getInstance().getAbbreviation(name, nameLengthLimit);
                }
				if (name != null) {
					return name.length() > nameLengthLimit ? null : name;
				}
			} catch (JsonProcessingException e) {
                System.out.println("Failed to parse response");
            }
            return  null;
        }
        return null;
    }

    private static String extractNameFromResponse(String response, String codeContext) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response);
        String str = root.get("response").asText().replace("\n", " ").trim();

        // Response is a single name
        if (str.matches("[a-zA-Z_][a-zA-Z0-9_]*") && !codeContext.contains(str)) {
            return str;
        }

        Matcher matcher = pattern.matcher(str);

        List<String> matches = new ArrayList<>();
        while(matcher.find()) {
            String name = matcher.group(2).trim();
            if (codeContext.contains(name)) {
                continue;
            }
            matches.add(name);
        }
        matches.sort(Comparator.comparing(String::length));
        if (!matches.isEmpty()) {
            return matches.get(0);
        }
        return null;
    }

    private static String createPrompt(ExtendContext identifier, MyParser parser, String codeContext, int nameLengthLimit) {
        ExtendContext minStmt = identifier.findFirstParentIf(parser::belongToStmt);
        if (minStmt == null) {
            return null;
        }
        StringBuilder promptBuilder = new StringBuilder();
        promptBuilder.append("You are a programming expert specializing in variable name recommendations based on code context. " +
                String.format("Your task is to determine the most suitable variable name for \"%s\" in the statement \"%s\". The length of name you provide should be less than %s characters.",
                        identifier.getText(), minStmt.getFormattedText(parser), nameLengthLimit)
                + "\n");
        if (codeContext != null) {
            promptBuilder.append(
                    String.format("Here is the %s code snippet:\n", GlobalInfo.getLanguage()) +
                            "\n" +
                            "\"" + codeContext + "\"\n");
        }

        promptBuilder.append("\n### Output Format\n");
        promptBuilder.append("Return only the new variable name without any explanation, punctuation, or extra text.\n");
        promptBuilder.append("Output format:\n");
        promptBuilder.append("```\n<new_name>\n```\n");
        promptBuilder.append("Now, provide the best variable name:");
        return promptBuilder.toString();
    }



    private static class AlternativeNames {
        private List<String> names;
        private Iterator<String> iterator;

        public AlternativeNames(List<String> names) {
            this.names = names;
            iterator = names.iterator();
        }

        public String getName() {
            if (iterator.hasNext()) {
                return iterator.next();
            }
            iterator = names.iterator();
            return null;
        }

        public boolean isAlternative(String name) {
            return names.contains(name);
        }

        public void reset() {
            iterator = names.iterator();
        }
    }

}
