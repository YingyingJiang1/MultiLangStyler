package org.example.styler.structure.vtree;

import java.util.*;
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
    // Ensure each pattern has three groups. If regular1 is a prefix of regular2 then regular1 should be put after regular2.
    static Pattern[] placeholderPatterns = {
            Pattern.compile("(\\$S\\([a-zA-Z]+\\))(\\d*)([*+?]?)"),
            Pattern.compile("(\\$[ICSEMVT^])(\\d*)([*+?]?)"),
            Pattern.compile("(\\$HOMO_BOP_ASSIGN)(\\d*)()"),
            Pattern.compile("(\\$HOMO_BOP)(\\d*)()"),
            Pattern.compile("(\\$LITERAL)(\\d*)()")
    };
    private static final Map<String, String> placeholderMap = new HashMap<>() {{
        put("$I", "I#id");
        put("$C", "C#id");
        put("$E", "E#id");
        put("$V", "V#id");
        put("$T", "T#id");
        put("$M", "");
        put("$S(ifStmt)", "if(true){}");
        put("$S(ifElseStmt)", "if(true){}else{}");
        put("$S", "RV#id=LV#id;");
        put("$HOMO_BOP", "+");
        put("$HOMO_BOP_ASSIGN", "+=");
        put("$LITERAL", "1");
        put("", "");
    }};
    static int TYPE_GROUP = 1;
    static int DIGITAL_GROUP = 2;
    static int REPETITION_GROUP = 3;

    public PlaceholderContainer(String[] placeholderNames) {
        for (int i = 0; i < placeholderNames.length; i++) {
            String placeholderName = placeholderNames[i];
            Placeholder placeholderObj = createPlaceholder(placeholderName, i);
            placeholderObj.vNode = new VirtualNode(placeholderObj.type, placeholderObj.repetition);
            placeholders.put(placeholderName, placeholderObj);
        }
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
            if (placeholder.placeholderValue.equals(placeholderValue)) {
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
    public VirtualNode getVNodeByText(String text) {
        String placeholderName = getPlaceholderName(text);
        Placeholder placeholder = placeholders.get(placeholderName);
        if (placeholder != null) {
            return placeholder.vNode;
        }
        return null;
    }

    public VirtualNode getVNodeByPlaceholderName(String placeholderName) {
        return placeholders.get(placeholderName) == null ? null : placeholders.get(placeholderName).vNode;
    }


    /**
     * @param text
     * @return
     * @apiNote This method can handle the case where different placeholder names has the same placeholder value.
     * But there may be some bugs.
     */
    public VirtualNode getVNodeByText(String text, boolean modifyState) {
        String placeholderName = getPlaceholderName(text, modifyState);
        Placeholder placeholder = placeholders.get(placeholderName);
        if (placeholder != null) {
            return placeholder.vNode;
        }
        return null;
    }


    private Placeholder createPlaceholder(String placeholderName, int index) {
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
        return new Placeholder(placeholderName, placeholderValue, index, repetition, type);
    }

    public static class Placeholder {
        String placeholderName;
        String placeholderValue;
        int index;
        String repetition;
        String type;
        VirtualNode vNode = null;

        public Placeholder(String placeholderName, String placeholderValue, int index, String repetition, String type) {
            this.placeholderName = placeholderName;
            this.placeholderValue = placeholderValue;
            this.index = index;
            this.repetition = repetition;
            this.type = type;
        }
    }
}
