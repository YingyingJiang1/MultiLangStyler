package org.example.styler.naming;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;
import org.example.global.GlobalInfo;
import org.example.semantic.ResolverFactory;
import org.example.semantic.SymbolTable;
import org.example.semantic.intf.Resolver;
import org.example.semantic.intf.Symbol;
import org.example.style.rule.StyleProperty;
import org.example.styler.Styler;
import org.example.styler.naming.style.NamingFormatContext;
import org.example.styler.naming.style.NamingFormatProperty;

import java.io.File;
import java.util.List;

public class NamingFormatStyler extends Styler {
    public NamingFormatStyler() {
        style.setStyleName("naming_format");
    }

    public void extractStyle(String code) {Resolver resolver = ResolverFactory.createResolver(GlobalInfo.getLanguage());
        SymbolTable st = resolver.parse(code);
        List<Symbol> symbols = st.getAllSymbols();
        for (Symbol symbol : symbols) {
            String name = symbol.getName();
            SymbolType symbolType = symbol.getSymbolType();

            CaseFormat caseFormat = getCaseFormat(name);
            if (caseFormat != null) {
                NamingFormatContext context = new NamingFormatContext(symbolType);
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

                style.addRule(context,
                        new NamingFormatProperty(name.charAt(0) == '_', caseFormat, curLength));
            }
        }
    }

    public String applyStyle(String code) {
        Resolver resolver = ResolverFactory.createResolver(GlobalInfo.getLanguage());
        SymbolTable st = resolver.parse(code);
        List<Symbol> symbols = st.getAllSymbols();
        for (Symbol symbol : symbols) {
            SymbolType symbolType = symbol.getSymbolType();
            NamingFormatContext context = new NamingFormatContext(symbolType);

            NamingFormatProperty property = (NamingFormatProperty) style.getProperty(context);
            if (property != null) {
                String name = symbol.getName();
                String newName = abbreviateName(name, property.maxLength);
                CaseFormat curFormat = getCaseFormat(name);
                if (curFormat != null) {
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
        return resolver.getParsedSourceCode();
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
        }

        return name;
    }

    private CaseFormat getCaseFormat(String name) {
        int underScoreIndex = name.indexOf("_");
        if (underScoreIndex > 0) { // contains a underscore and it is not the first character
            return StringUtils.isAllUpperCase(name) ? CaseFormat.UPPER_UNDERSCORE :CaseFormat.LOWER_UNDERSCORE;
        } else if (underScoreIndex < 0 && StringUtils.isMixedCase(name)) {
            return Character.isUpperCase(name.charAt(0)) ? CaseFormat.UPPER_CAMEL : CaseFormat.LOWER_CAMEL;
        }
        return null;
    }
}
