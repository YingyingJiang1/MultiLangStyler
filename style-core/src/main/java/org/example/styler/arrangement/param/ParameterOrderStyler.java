package org.example.styler.arrangement.param;

import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.arrangement.LogicalOrder;
import org.example.styler.arrangement.param.style.ParameterOrderProperty;
import org.example.styler.arrangement.param.style.ParameterOrderStyle;

import java.util.*;

public class ParameterOrderStyler extends Styler {
    private Map<LogicalOrder, Integer> orderFre = new HashMap<>();
    private Map<Boolean, Integer> sameTypeSeparateFre = new HashMap<>();

    public ParameterOrderStyler() {
        style = new ParameterOrderStyle();
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        List<String> typeOfParams = new ArrayList<>();
        ctx.children.forEach(child -> {
            if (child instanceof ExtendContext param) {
                ExtendContext type = param.getFirstCtxChildIf(parser::isTypeType);
                typeOfParams.add(type.getText());
            }
        });
        if (typeOfParams.size() < 2) {
            return;
        }


        boolean isIncreasing = true;
        boolean isDecreasing = true;
        Map<String, List<Integer>> strIndexMap = new HashMap<>();
        for (int i = 0; i < typeOfParams.size() - 1; i++) {
            String current = typeOfParams.get(i);
            String next = typeOfParams.get(i + 1);

            if (current.length() > next.length()) {
                isIncreasing = false;
            } else if (current.length() < next.length()) {
                isDecreasing = false;
            }
            strIndexMap.computeIfAbsent(current, k -> new ArrayList<>()).add(i);
        }
        strIndexMap.computeIfAbsent(typeOfParams.get(typeOfParams.size() - 1), k -> new ArrayList<>()).add(typeOfParams.size() - 1);


        if (isIncreasing) {
            orderFre.put(LogicalOrder.LENGTH_ASC_ORDER, orderFre.getOrDefault(LogicalOrder.LENGTH_ASC_ORDER, 0) + 1);
        } else if (isDecreasing) {
            orderFre.put(LogicalOrder.LENGTH_DESC_ORDER, orderFre.getOrDefault(LogicalOrder.LENGTH_DESC_ORDER, 0) + 1);
        }


        Boolean isSeparated = null;
        for (List<Integer> indices : strIndexMap.values()) {
            if (indices.size() == 1) {
                continue;
            }

            isSeparated = false;
            int max = indices.stream().max(Comparator.comparing(i -> i)).get();
            int min = indices.stream().max(Comparator.comparing(i -> i)).get();
            if (max - min + 1 != indices.size()) {
                isSeparated = true;
                break;
            }
        }
        if (isSeparated != null) {
            sameTypeSeparateFre.put(isSeparated, sameTypeSeparateFre.getOrDefault(isSeparated, 0) + 1);
        }
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        return super.applyStyle(ctx, parser);
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleformalParameterList();
    }

    @Override
    public void extractFinalize() {
        LogicalOrder order = null;
        Optional<Map.Entry<LogicalOrder, Integer>> maxEntry = orderFre.entrySet()
                .stream().max(Comparator.comparing(Map.Entry::getValue));
        if (maxEntry.isPresent() &&
                orderFre.values().stream().filter(v -> Objects.equals(v, maxEntry.get().getValue())).count() == 1) {
            order = maxEntry.get().getKey();
        }

        Boolean isSameTypeSeparated = null;
        Optional<Map.Entry<Boolean, Integer>> maxEntry2 = sameTypeSeparateFre.entrySet()
                .stream().max(Comparator.comparing(Map.Entry::getValue));
        if (maxEntry2.isPresent() &&
                sameTypeSeparateFre.values().stream().filter(v -> Objects.equals(v, maxEntry2.get().getValue())).count() == 1) {
            isSameTypeSeparated = maxEntry2.get().getKey();
        }

        style.addRule(null, new ParameterOrderProperty(order, isSameTypeSeparated));


    }
}
