package org.example.styler.structure.vtree;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;

import java.util.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * $I: identifier
 * $C： conditional expression
 * $E: expression
 * $S: any statement
 * $M: modifier list
 * $T: typeType
 * $V: variableDeclaratorId
 * $S(type): statement with type.
 * $^: for example: "$^ if($C) { return true;} return false;", this structure will be considered as a ifStmt.
 * When we get a ifStmt, this statement will be tried to match the structure. If matched, we'll see the next
 * statement,that's returnStmt.
 * $HOMO_BOP: binary operator whose operands has the same type.
 * $HOMO_BOP_ASSIGN: assign and compound assign
 * $LITERAL: literal
 */
public class PlaceholderContainer {


    // key: placeholder value, value:placeholder names
    Map<String, List<String>> valueNameMap = new HashMap<>();
    Map<String, Placeholder> placeholders = new HashMap<>();
    static int TYPE_GROUP = 1;
    static int DIGITAL_GROUP = 2;
    static int REPETITION_GROUP = 3;
    // Ensure each pattern has three groups. If regular1 is a prefix of regular2 then regular1 should be put after regular2.
    static Pattern[] placeholderPatterns = {
            Pattern.compile("(\\$S\\([a-zA-Z]+\\))(\\d*)([*+?]?)"),
            Pattern.compile("(\\$ARRAY_INITIALIZER)(\\d*)()"),
            Pattern.compile("(\\$VAR_DEC)(\\d*)([*+?]?)"),
            Pattern.compile("(\\$EXP_LIST)(\\d*)([*+?]?)"),
            Pattern.compile("(\\$HOMO_BOP_ASSIGN)(\\d*)()"),
            Pattern.compile("(\\$HOMO_BOP)(\\d*)()"),
            Pattern.compile("(\\$[ISEMVT^])(\\d*)([*+?]?)"),
            Pattern.compile("(\\$HOMO_BOP_ASSIGN)(\\d*)()"),
            Pattern.compile("(\\$HOMO_BOP)(\\d*)()"),
            Pattern.compile("(\\$LITERAL)(\\d*)()")
    };

    // Make sure each placeholder type has a different placeholder values.
    // For the placeholder has the same value, such as $M,$ARRAY_INITIALIZER,$HOMO_BOP..., if a configured structure has more
    // than one kind of that placeholder($M1,$M2 is seen as two kinds of $M), it may go wrong.
    private static final Map<String, String> placeholderMap = new HashMap<>() {{
        put("$I", "I#id");
        put("$E", "E#id");
        put("$V", "V#id");
        put("$T", "T#id");
        put("$M", "");
        put("$ARRAY_INITIALIZER", "{}");
        put("$EXP_LIST", "I#id=0,J#id=1");
        put("$S(ifStmt)", "if(IFCOND#id>0){}");
        put("$S(ifElseStmt)", "if(IFELSECOND#id>0){}else{}");
        put("$S(expStmt)", "I#id=0;");
        put("$S", "RV#id=LV#id;");
        put("$HOMO_BOP", "+");
        put("$HOMO_BOP_ASSIGN", "+=");
        put("$LITERAL", "1#id");
        put("$VAR_DEC", "int VAR#id");
    }};


    public static PlaceholderContainer createInstance(String[] codes) {
        PlaceholderContainer container = new PlaceholderContainer();
        for(String code : codes) {
            String[] tokens = code.split(" ");
            for (String token : tokens) {
                if (token.startsWith("$")) {
                    Placeholder placeholderObj = container.createPlaceholder(token);
                    placeholderObj.vNode = new VirtualNode(placeholderObj.type, placeholderObj.repetition);
                    container.placeholders.put(token, placeholderObj);
                }
            }
        }
        return container;
    }

    public Placeholder getPlaceholder(String placeholderName) {
        return placeholders.get(placeholderName);
    }

    public String getValue(String placeholderName) {
        Placeholder placeholder = placeholders.get(placeholderName);
        if (placeholder != null) {
            return placeholder.placeholderValue;
        }
        return null;
    }

    public Set<String> getPlaceholderNames() {
        return placeholders.keySet();
    }

    /**
     * @param placeholderValue
     * @return
     * @apiNote This method can't handle the case where different placeholder names has the same placeholder value.
     */
    public String getPlaceholderName(String placeholderValue) {
        for (Placeholder placeholder : placeholders.values()) {
            if (placeholderValue.equals(placeholder.placeholderValue.replace(" ", ""))) {
                return placeholder.placeholderName;
            }
        }
        return null;
    }

    /**
     * @param placeholderValue
     * @return
     * @apiNote This method can handle the case where different placeholder names has the same placeholder value.
     * But there may be some bugs.
     */
    public String getPlaceholderName(String placeholderValue, boolean modifyState) {
        List<String> placeholderNames = valueNameMap.get(placeholderValue);
        if (placeholderNames != null) {
            if (modifyState) {
                String first = placeholderNames.get(0);
                placeholderNames.remove(0);
                placeholderNames.add(first);
            }
            return placeholderNames.get(0);
        }
        return null;
    }

    /**
     * @return
     * @apiNote This method can't handle the case where different placeholder names has the same placeholder value.
     */
    public VirtualNode getVNode(ParseTree node, MyParser parser) {

        String placeholderName = getPlaceholderName(node.getText());
        Placeholder placeholder = placeholders.get(placeholderName);

        if (placeholder == null) {
            return null;
        }

        boolean ret = checkNodeType(node, placeholder, parser);
        if (!ret) {
            return null;
        }

        return placeholder.vNode;
    }

    private boolean checkNodeType(ParseTree node, Placeholder placeholder, MyParser parser) {
        // $S(STMT_TYPE) should be linked to a specific statement.
        if (placeholder.type.matches("\\$S\\([a-zA-Z]\\)") && parser.isStatement(node)) {
            return false;
        }

        switch (placeholder.type) {
            case "$LITERAL":
                return parser.isLiteral(node);
            case "$I":
                return parser.isIdentifier(node);
            case "$E":
                boolean isExpression = node instanceof ExtendContext ctx && ctx.getRuleIndex() == parser.getRuleExpression();
                return isExpression;
            case "$T":
                return parser.isTypeType(node);
            case "$M":
                return  node instanceof ExtendContext ctx && ctx.getRuleIndex() == parser.getRuleModifierList();
            default:
                return true;
        }
    }

    public VirtualNode getVNodeByPlaceholderName(String placeholderName) {
        return placeholders.get(placeholderName) == null ? null : placeholders.get(placeholderName).vNode;
    }


    private Placeholder createPlaceholder(String placeholderName) {
        String type = "", digitalId = "", repetition = "";
        for (Pattern placeholderPattern : placeholderPatterns) {
            Matcher matcher = placeholderPattern.matcher(placeholderName);
            if (matcher.matches() && matcher.group(TYPE_GROUP).length() > type.length()) {
                type = matcher.group(TYPE_GROUP);
                digitalId = matcher.group(DIGITAL_GROUP);
                repetition = matcher.group(REPETITION_GROUP);
            }
        }
        String placeholderValue = placeholderMap.getOrDefault(type, "").replace("#id", digitalId);
        valueNameMap.computeIfAbsent(placeholderValue, v -> new ArrayList<>());
        valueNameMap.get(placeholderValue).add(placeholderName);
        return new Placeholder(placeholderName, placeholderValue, repetition, type);
    }

    public static class Placeholder {
        String placeholderName;
        String placeholderValue;
        String repetition;
        String type;
        VirtualNode vNode = null;

        public Placeholder(String placeholderName, String placeholderValue, String repetition, String type) {
            this.placeholderName = placeholderName;
            this.placeholderValue = placeholderValue;
            this.repetition = repetition;
            this.type = type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(placeholderName, placeholderValue, repetition, type, vNode);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Placeholder placeholder) {
                return Objects.equals(placeholderName, placeholder.placeholderName) &&
                        Objects.equals(placeholderValue, placeholder.placeholderValue) &&
                        Objects.equals(repetition, placeholder.repetition) &&
                        Objects.equals(type, placeholder.type) &&
                        Objects.equals(vNode, placeholder.vNode);
            }
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueNameMap, placeholders);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PlaceholderContainer placeholderContainer) {
            return Objects.equals(valueNameMap, placeholderContainer.valueNameMap) &&
                    Objects.equals(placeholders, placeholderContainer.placeholders);
        }
        return false;
    }
}
