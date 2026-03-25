package org.example.styler.naming.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.Token;
import org.apache.commons.lang3.StringUtils;
import org.example.RunStatistic;
import org.example.antlr.common.context.ExtendContext;
import org.example.lang.intf.MyParser;
import org.example.semantic.SymbolTable;
import org.example.semantic.SymbolTableManager;
import org.example.semantic.intf.symbol.Symbol;
import org.example.semantic.intf.symbol.VarSym;
import org.example.semantic.intf.type.ReferenceType;
import org.example.style.InconsistencyInfo;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.InconsistencyInfoGenerator;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.naming.MyCaseFormat;
import org.example.styler.naming.NameType;
import org.example.styler.naming.format.style.NamingFormatContext;
import org.example.styler.naming.format.style.NamingFormatProperty;
import org.example.styler.naming.format.style.NamingFormatStyle;

public class NamingStyler extends Styler {
    private static final Pattern IDENTIFIER_PATTERN = Pattern.compile("^[a-zA-Z_][a-zA-Z0-9_]*$");
    Map<StyleContext, Integer> maxLengthMap = new HashMap<>();

    public NamingStyler() {
        style = new NamingFormatStyle();
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        List<Symbol> symbols = SymbolTableManager.getAllSymbols(parser);
        for (Symbol symbol : symbols) {
            NamingFormatContext context = extractStyleContext(symbol, parser);
            NamingFormatProperty currentProperty = extractProperty(symbol, context, parser);

            if (currentProperty.caseFormat != MyCaseFormat.ALL_LOWER_CASE) {
                if (style.getProperty(context) == null) {
                    style.addRule(context, currentProperty);
                } else {
                    // update length
                    int curLength = currentProperty.maxLength;
                    // Update max length;
                    List<StyleProperty> properties = style.getProperties(context);
                    if (properties != null) {
                        for (StyleProperty property : properties) {
                            if (property instanceof NamingFormatProperty namingProperty &&
                            namingProperty.maxLength < curLength) {
                                namingProperty.maxLength = curLength;
                            }
                        }
                    }
                }

            }

        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        SymbolTableManager.removeCache(parser.getRoot());
        SymbolTable st = SymbolTableManager.getSymbolTable(parser);
        List<Symbol> symbols = st.getAllSymbols();
        for (Symbol symbol : symbols) {
            if (!isMutable(symbol)) {
                continue;
            }

            NamingFormatContext context = extractStyleContext(symbol, parser);
            NamingFormatProperty property = extractProperty(symbol, context, parser);

            NamingFormatProperty targetProperty = (NamingFormatProperty) style.getProperty(context);
            if (isInconsistent(property, targetProperty, parser)) {
                String name = symbol.getText();
                String newName = generateNewName(name, targetProperty);

                if (!newName.equals(name) && isValidName(newName, parser)) {
                    // 预修改
                    symbol.setText(newName);

                    if (!st.hasConflictSymbol(symbol, parser)) {
                        symbol.modifyName(newName);
                        RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                    } else {
                        symbol.setText(name);
                    }


                }
            }
        }
        return ctx;
    }

    @Override
    public List<InconsistencyInfo> analyzeInconsistency(ExtendContext ctx, MyParser parser) {
        List<InconsistencyInfo> infos = new ArrayList<>();
        List<Symbol> symbols = SymbolTableManager.getAllSymbols(parser);
        SymbolTable st = SymbolTableManager.getSymbolTable(parser);
        for (Symbol symbol : symbols) {
            if (!isMutable(symbol)) {
                continue;
            }

            NamingFormatContext context = extractStyleContext(symbol, parser);
            NamingFormatProperty property = extractProperty(symbol, context, parser);

            NamingFormatProperty targetProperty = (NamingFormatProperty) style.getProperty(context);
            if (isInconsistent(property, targetProperty, parser)) {
                Token token = symbol.getDecIdentifierNode().getStop();
                String newName = generateNewName(token.getText(), targetProperty);
                String originalName = symbol.getText();
                if (!newName.equals(symbol.getText()) && isValidName(newName, parser)) {
                    symbol.setText(newName);

                    if (!st.hasConflictSymbol(symbol, parser)) {
                        symbol.setText(originalName);
                        infos.add(InconsistencyInfoGenerator.generateForNaming(symbol, newName, targetProperty));
                    } 
                    symbol.setText(originalName);
                }
            }
        }

        inconsistencyInfos.addAll(infos);
        return infos;
    }

    @Override
    protected boolean isInconsistent(StyleProperty currentProperty, StyleProperty targetProperty, MyParser parser) {
        if (targetProperty instanceof NamingFormatProperty target && currentProperty instanceof NamingFormatProperty current
        && (current.caseFormat != target.caseFormat || current.maxLength > target.maxLength
        || current.startsWithUnderScore != target.startsWithUnderScore)) {
            return true;
        }
        return false;
    }

    private String generateNewName(String oldName, NamingFormatProperty property) {
        MyCaseFormat curFormat = getCaseFormat(oldName);
        if (curFormat == null || !curFormat.isConvertible(property.caseFormat)) {
            return oldName;
        }

        String lowerUnderscoreName = AbbreviationLibrary.getInstance().getAbbreviation(oldName, property.maxLength);
        String newName = MyCaseFormat.LOWER_UNDERSCORE.to(property.caseFormat, lowerUnderscoreName);

        if (property.startsWithUnderScore && !newName.startsWith("_")) {
            newName = "_" + newName;
        }
        return newName;
    }

    private NamingFormatProperty extractProperty(Symbol symbol, NamingFormatContext context, MyParser parser) {
        String name = symbol.getText();
        MyCaseFormat caseFormat = getCaseFormat(name);

        int curLength = name.length();
        NamingFormatProperty property = new NamingFormatProperty(name.charAt(0) == '_',
                caseFormat, curLength);
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

    private boolean isValidName(String name, MyParser parser) {
        return IDENTIFIER_PATTERN.matcher(name).matches() && !parser.isKeyword(name);
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
        return ctx == parser.getRoot();
    }

    @Override
    public void extractFinalize() {
        super.extractFinalize();
        maxLengthMap.clear();
    }
}
