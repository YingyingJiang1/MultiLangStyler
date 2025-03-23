package org.example.styler.naming.format;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.symbol.Symbol;
import org.example.style.rule.StyleProperty;
import org.example.styler.ModelAdapter;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.semantic.SymbolTableManager;
import org.example.styler.naming.MyCaseFormat;
import org.example.styler.naming.SymbolType;
import org.example.styler.naming.format.style.NamingFormatContext;
import org.example.styler.naming.format.style.NamingFormatProperty;
import org.example.styler.naming.format.style.NamingFormatStyle;

import java.util.List;

public class NamingFormatStyler extends Styler {
    public NamingFormatStyler() {
        style = new NamingFormatStyle();
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        List<Symbol> symbols = SymbolTableManager.getAllSymbols(parser);
        for (Symbol symbol : symbols) {
            String name = symbol.getName();
            MyCaseFormat caseFormat = getCaseFormat(name);

            NamingFormatContext context = extractStyleContext(symbol, parser);
            // Update max length;
            int curLength = name.length();
            List<StyleProperty> properties = style.getProperties(context);
            if (properties != null) {
                for (StyleProperty property : properties) {
                    if (property instanceof NamingFormatProperty namingProperty) {
                        if (namingProperty.maxLength >= curLength) {
                            curLength = namingProperty.maxLength;
                            break;
                        } else {
                            namingProperty.maxLength = curLength;
                        }
                    }
                }
            }

            NamingFormatProperty property = new NamingFormatProperty(name.charAt(0) == '_', caseFormat, curLength);
            style.addRule(context, property);
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        List<Symbol> symbols = SymbolTableManager.getAllSymbols(parser);
        for (Symbol symbol : symbols) {
            NamingFormatContext context = extractStyleContext(symbol, parser);

            NamingFormatProperty property = (NamingFormatProperty) style.getProperty(context);
            if (property != null ) {
                String name = symbol.getName();
                MyCaseFormat curFormat = getCaseFormat(name);
                String newName = abbreviateName(name, property.maxLength);

                if (curFormat != null && curFormat.isConvertible(property.caseFormat)) {
                    newName = curFormat.to(property.caseFormat, name);
                }

                if (property.startsWithUnderScore && !newName.startsWith("_")) {
                    newName = "_" + newName;
                }

                if (!newName.equals(name)) {
                    symbol.modifyName(newName);
                }
            }
        }
        return ctx;
    }

    private NamingFormatContext extractStyleContext(Symbol symbol, MyParser parser) {
        SymbolType symbolType = symbol.getSymbolType();
        NamingFormatContext context = new NamingFormatContext(symbolType);

        // Add attributes for variables
        if (symbol.getSymbolType() == SymbolType.LOCAL_VARIABLE || symbol.getSymbolType() == SymbolType.FIELD) {
            if (symbol.hasModifier(parser.getConstKeyword())) {
                context.addAttr(SymbolAttr.EXPLICIT_CONST);
            } else {
                ModelAdapter modelAdapter = ModelAdapter.getInstance();
                if (modelAdapter != null) {
                    ExtendContext stmt = symbol.getDecIdentifierNode().getFirstParentIf(parser::isBlock);
                    String prompt = String.format("Does variable %s use user input? Answer only \"yes\" or \"no." +
                            "// Code：\n" + "%s", symbol.getName(), stmt.getText());
                    String res = modelAdapter.callModel(prompt);
                    if (res != null && res.contains("yes")) {
                        context.addAttr(SymbolAttr.IMPLICIT_CONST);
                    }
                }
            }
        }

        return context;
    }


    private String abbreviateName(String name, int maxLength) {
        if (name.length() <= maxLength) {
            return name;
        }

        String[] words = name.split("(?<=\\D)(?=\\p{Upper})|_");
        AbbreviationLibrary  abbreviationLibrary = AbbreviationLibrary.getInstance();
        int curLen = name.length();
        int i = 0;
        while (curLen > maxLength && i < words.length) {
            String word = words[i];
            String abbreviation = abbreviationLibrary.lookUpAbbreviation(words[0]);
            if (abbreviation != null) {
                name = name.replace(words[0], abbreviation);
                curLen -= words[0].length() - abbreviation.length();
            }
            i++;
        }

        return name;
    }

    private MyCaseFormat getCaseFormat(String name) {
        int underScoreIndex = name.indexOf("_");
        if (StringUtils.isAllUpperCase(name)) {
            return MyCaseFormat.ALL_UPPER_CASE;
        } else if (StringUtils.isAllLowerCase(name)) {
            return MyCaseFormat.ALL_LOWER_CASE;
        }
        if (underScoreIndex > 0) { // contains a underscore and it is not the first character
            return StringUtils.isAllUpperCase(name) ? MyCaseFormat.UPPER_UNDERSCORE :MyCaseFormat.LOWER_UNDERSCORE;
        } else if (underScoreIndex < 0 && StringUtils.isMixedCase(name)) {
            return Character.isUpperCase(name.charAt(0)) ? MyCaseFormat.UPPER_CAMEL : MyCaseFormat.LOWER_CAMEL;
        }
        return null;
    }


    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return parser.isCompilationUnit(ctx);
    }
}
