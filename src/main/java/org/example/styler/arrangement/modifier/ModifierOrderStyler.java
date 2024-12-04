package org.example.styler.arrangement.modifier;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
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
        style.setStyleName("modifier_order");
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        List<String> modifiers = new ArrayList<>();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (parser.isAnnotation(ctx.getChild(i))) {
                modifiers.add("annotation");
            } else {
                modifiers.add(ctx.getChild(i).getText());
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
        int index = -1;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (parser.isAnnotation(ctx.getChild(i))) {
                index = target.indexOf("annotation");
            } else {
                index = target.indexOf(ctx.getChild(i).getText());
            }
            if (index >= 0) {
                inTargetMap.put(ctx.getChild(i), index);
            }
        }

        // Resort modifier which are in the target order list.
        List<ParseTree> ordered = inTargetMap.keySet().stream().sorted(Comparator.comparing(inTargetMap::get)).toList();
        List<Integer> indices = inTargetMap.values().stream().sorted().toList();
        for (int i = 0; i < ordered.size(); i++) {
            ctx.children.set(indices.get(i), ordered.get(i));
        }
        ctx.updateStartToken();
        ctx.updateStopToken();
        return ctx;
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        int ruleIndex = ctx.getRuleIndex();
        return ruleIndex == parser.getRuleModifierList();
    }

}
