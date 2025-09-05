package org.example.styler.naming.format;

import org.antlr.v4.runtime.Token;
import org.apache.commons.lang3.StringUtils;
import org.example.RunStatistic;
import org.example.global.GlobalInfo;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.semantic.intf.symbol.Symbol;
import org.example.semantic.intf.symbol.VarSym;
import org.example.semantic.intf.type.ReferenceType;
import org.example.style.InconsistencyInfo;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.style.rule.StyleRule;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.semantic.SymbolTableManager;
import org.example.styler.naming.MyCaseFormat;
import org.example.styler.naming.NameType;
import org.example.styler.naming.format.style.NamingFormatContext;
import org.example.styler.naming.format.style.NamingFormatProperty;
import org.example.styler.naming.format.style.NamingFormatStyle;
import org.example.styler.naming.format.style.NamingInconsistencyInfo;

import java.util.*;

public class NamingStyler extends Styler {
    Map<StyleContext, Integer> maxLengthMap = new HashMap<>();

    public NamingStyler() {
        style = new NamingFormatStyle();
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        List<Symbol> symbols = SymbolTableManager.getAllSymbols(parser);
        for (Symbol symbol : symbols) {
            NamingFormatContext context = extractStyleContext(symbol, parser);

            style.addRule(context, extractProperty(symbol, context, parser));
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        List<Symbol> symbols = SymbolTableManager.getAllSymbols(parser);
        for (Symbol symbol : symbols) {
            if (!isMutable(symbol)) {
                continue;
            }

            NamingFormatContext context = extractStyleContext(symbol, parser);

            NamingFormatProperty property = (NamingFormatProperty) style.getProperty(context);
            if (property != null ) {
                String name = symbol.getText();
                MyCaseFormat curFormat = getCaseFormat(name);
                String newName = AbbreviationLibrary.getInstance().getAbbreviation(name, property.maxLength);

                if (curFormat != null && curFormat.isConvertible(property.caseFormat)) {
                    newName = curFormat.to(property.caseFormat, name);
                }

                if (property.startsWithUnderScore && !newName.startsWith("_")) {
                    newName = "_" + newName;
                }

                if (!newName.equals(name)) {
                    symbol.modifyName(newName);

                    RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                }
            }
        }
        return ctx;
    }

    @Override
    public List<InconsistencyInfo> analyzeInconsistency(ExtendContext ctx, MyParser parser) {
        List<InconsistencyInfo> infos = new ArrayList<>();
        List<Symbol> symbols = SymbolTableManager.getAllSymbols(parser);
        for (Symbol symbol : symbols) {
            if (!isMutable(symbol)) {
                continue;
            }

            NamingFormatContext context = extractStyleContext(symbol, parser);
            NamingFormatProperty property = extractProperty(symbol, context, parser);

            NamingFormatProperty targetProperty = (NamingFormatProperty) style.getProperty(context);
            if (!Objects.equals(property, targetProperty)) {
                Token token = symbol.getDecIdentifierNode().getStop();
                int[] loc = {token.getLine(), token.getCharPositionInLine()};
                infos.add(new NamingInconsistencyInfo(loc, loc, ""));
            }
        }
        return infos;
    }

    private NamingFormatProperty extractProperty(Symbol symbol, NamingFormatContext context, MyParser parser) {
        String name = symbol.getText();
        MyCaseFormat caseFormat = getCaseFormat(name);

        int curLength = name.length();
        if (!maxLengthMap.containsKey(context) || maxLengthMap.get(context) < curLength) {
            maxLengthMap.put(context, curLength);
            // Update max length;
            List<StyleProperty> properties = style.getProperties(context);
            if (properties != null) {
                for (StyleProperty property : properties) {
                    if (property instanceof NamingFormatProperty namingProperty) {
                        namingProperty.maxLength = curLength;
                    }
                }
            }
        }

        NamingFormatProperty property = new NamingFormatProperty(name.charAt(0) == '_', caseFormat, maxLengthMap.get(context));
        return property;
    }

    private NamingFormatContext extractStyleContext(Symbol symbol, MyParser parser) {
        NameType nameType = symbol.getSymbolType();
        NamingFormatContext context = new NamingFormatContext(nameType);

        // Add attributes for variables
        if (symbol.getSymbolType() == NameType.LOCAL_VARIABLE || symbol.getSymbolType() == NameType.FIELD) {
            if (symbol.hasModifier(parser.getConstKeyword())) {
                context.addAttr(SymbolAttr.EXPLICIT_CONST);
            } else {
                if (symbol instanceof VarSym varSym && varSym.getType() != null) {
                    // A rough check for Java input.
                    if (varSym.getType() instanceof ReferenceType refType &&
                            (refType.getName().equals("Scanner") || refType.getName().equals("Console"))) {
                        context.addAttr(SymbolAttr.IMPLICIT_CONST);
                    }
                }
//                ModelClient modelClient = ModelClient.getInstance();
//                if (modelClient != null) {
//                    ExtendContext stmt = symbol.getDecIdentifierNode().getFirstParentIf(node -> parser.isBlock(node) || parser.isBody(node));
//                    String prompt = String.format("Does variable %s use user input? Answer only \"yes\" or \"no." +
//                            "// Code：\\n" + "\"%s\"", symbol.getText(), stmt.getFormattedText());
//                    String res = modelClient.sendRequest(prompt);
//                    if (res != null && res.contains("yes")) {
//                        context.addAttr(SymbolAttr.IMPLICIT_CONST);
//                    }
//                }
            }
        }

        return context;
    }


    private MyCaseFormat getCaseFormat(String name) {
        String noNumName = name.replaceAll("[0-9]", "");
        int underScoreIndex = noNumName.indexOf("_");
        if (StringUtils.isAllUpperCase(noNumName)) {
            return MyCaseFormat.ALL_UPPER_CASE;
        } else if (StringUtils.isAllLowerCase(noNumName)) {
            return MyCaseFormat.ALL_LOWER_CASE;
        }
        if (underScoreIndex > 0) { // contains a underscore and it is not the first character
            return StringUtils.isAllUpperCase(noNumName) ? MyCaseFormat.UPPER_UNDERSCORE :MyCaseFormat.LOWER_UNDERSCORE;
        } else if (underScoreIndex < 0 && StringUtils.isMixedCase(noNumName)) {
            return Character.isUpperCase(noNumName.charAt(0)) ? MyCaseFormat.UPPER_CAMEL : MyCaseFormat.LOWER_CAMEL;
        }
        return null;
    }

    private boolean isMutable(Symbol symbol) {
        if (symbol.isPrivate()) {
            return true;
        }
        return symbol.getSymbolType() == NameType.LOCAL_VARIABLE || symbol.getSymbolType() == NameType.PARAMETER;
    }


    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return parser.isCompilationUnit(ctx);
    }

    @Override
    public void extractFinalize() {
        super.extractFinalize();
        if (GlobalInfo.getConf().getLlmConfig().getIdentifierLengthLimit() < 0) {
            int lengthLimit = 0;
            for (StyleRule rule : style.getRules())  {
                if (rule.getStyleProperty() instanceof NamingFormatProperty property && property.maxLength > lengthLimit) {
                    lengthLimit = property.maxLength;
                }
            }
            GlobalInfo.getConf().getLlmConfig().setIdentifierLengthLimit(lengthLimit);
        }

    }
}
