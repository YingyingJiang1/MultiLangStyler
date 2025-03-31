package org.example.utils;

import com.google.common.base.CaseFormat;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.ModelClient;
import org.example.styler.naming.MyCaseFormat;

public class NameGenerator {
    public static String generateName(String suffix, MyCaseFormat caseFormat) {
        String name = "tmp";
        if (!suffix.isEmpty()) {
            name +=  "_" + suffix;
        }
        return MyCaseFormat.LOWER_UNDERSCORE.to(caseFormat, name);
    }

    public static String generateName(ExtendContext identifier, MyParser parser, MyCaseFormat caseFormat) {
        ModelClient client = ModelClient.getInstance();
        if (client == null) {
            // Create prompt
            ExtendContext minStmt = identifier.findFirstParentIf(parser::belongToStmt);
            if (minStmt == null) {
                return null;
            }
            ExtendContext codeContext = minStmt.findFirstParentIf(t -> parser.isBlock(t) || parser.isBody(t));
            StringBuilder promptBuilder = new StringBuilder();
            promptBuilder.append("You are a programming expert capable of recommending appropriate variable names based on code context." +
                    String.format(" Below is a code snippet. Based on the context, provide the most suitable variable name for the variable \"%s\" in the statement \"%s\"",
                            identifier.getText(), minStmt.getFormattedText()) +
                    "\n");
            if (codeContext != null) {
                promptBuilder.append(
                        String.format("Here is the %s code snippet:\n" , GlobalInfo.getLanguage()) +
                        "\n" +
                        codeContext.getFormattedText());
            }
        }
        return null;
    }

}
