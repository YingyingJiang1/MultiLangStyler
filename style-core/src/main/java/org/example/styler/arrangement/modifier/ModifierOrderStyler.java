package org.example.styler.arrangement.modifier;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.RunStatistic;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.arrangement.modifier.style.ModifierOrderProperty;
import org.example.styler.arrangement.modifier.style.ModifierOrderStyle;

import java.util.*;

public class ModifierOrderStyler extends Styler {
    public ModifierOrderStyler() {
        style = new ModifierOrderStyle();
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        List<String> modifiers = new ArrayList<>();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String modifierName = getModifierName(ctx.getChild(i), parser);
            if (!modifierName.isEmpty()) {
                modifiers.add(modifierName);
            }
        }
        style.addRule(null, new ModifierOrderProperty(modifiers));
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        if (style.getProperty(null) == null) {
            return ctx;
        }

        // Create a map to store modifier nodes and their indices in ctx.children.
        List<String> target = ((ModifierOrderProperty) style.getProperty(null)).order;
        Map<ParseTree, Integer> inTargetMap = new HashMap<>();
        Map<ParseTree, Integer> indexInOriginalMap = new HashMap<>();
        int index = -1;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            index = target.indexOf(getModifierName(ctx.getChild(i), parser));
            if (index >= 0) {
                inTargetMap.put(ctx.getChild(i), index);
                indexInOriginalMap.put(ctx.getChild(i), i);
            }
        }

        if (!inTargetMap.equals(indexInOriginalMap)) {
            // Resort modifier which are in the target order list.
            List<ParseTree> ordered = inTargetMap.keySet().stream().sorted(Comparator.comparing(inTargetMap::get)).toList();
            // 相关modifier在原始children中的索引按照从小到大顺序排列
            List<Integer> originalIndices = indexInOriginalMap.values().stream().sorted().toList();
            for (int i = 0; i < originalIndices.size(); i++) {
                ctx.setChild(originalIndices.get(i), ordered.get(i));
            }
            ctx.updateStartToken();
            ctx.updateStopToken();

            RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
        }

        return ctx;
    }

    private String getModifierName(ParseTree t, MyParser parser) {
        if (parser.isAnnotation(t)) {
            return  "ANNOTATION";
        } else if (isAccessControl(t.getText())) {

            return "ACCESS_CONTROL";
        }else {
            return t.getText();
        }
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        int ruleIndex = ctx.getRuleIndex();
        return ruleIndex == parser.getRuleModifierList();
    }

    private boolean isAccessControl(String text) {
        return text.equals("public") || text.equals("private") || text.equals("protected");
    }

}
