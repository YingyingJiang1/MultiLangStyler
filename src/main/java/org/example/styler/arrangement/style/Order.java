package org.example.styler.arrangement.style;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Vocabulary;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/1 14:34
 */
public class Order {


    private EnumType logicalOrder; // @orders may contain multiple logic orders. The order's occurrence determines its priority.
    private List<List<Integer>> modifierOrder; // Only meaningful when @order satisfy modifier order.
    public static double allowedOrderDeviation = 0.3; // When the distance to a strict logical order less than @allowedOrderDeviation, @order is set to the order.

    public Order() {
        modifierOrder = new ArrayList<>();
        logicalOrder = EnumType.UNKNOWN;
    }

    public void addModifierOrder(List<Integer> modifierOrder) {
        for (int i = 0; i < modifierOrder.size(); ) {
            if (modifierOrder.get(i) == -1) {
                modifierOrder.remove(i);
            } else {
                ++i;
            }
        }
        this.modifierOrder.add(modifierOrder);
    }

    public boolean isInModifierOrder() {
        return !modifierOrder.isEmpty();
    }

    public int getLayerNumberWithMostModifiers() {
        int maxLenIndex = 0, maxLen = 0;
        for (int i = 0; i < modifierOrder.size(); ++i) {
            int curLen = modifierOrder.get(i).size();
            if (curLen > maxLen) {
                maxLen = curLen;
                maxLenIndex = i;
            }
        }
        return maxLenIndex;
    }

    public EnumType getLogicalOrder() {
        return logicalOrder;
    }

    public List<List<Integer>> getModifierOrder() {
        return modifierOrder;
    }


    public boolean inOrder(double deviation) {
        return deviation < allowedOrderDeviation;
    }

    public void setLogicalOrder(EnumType logicalOrder) {
        this.logicalOrder = logicalOrder;
    }

    public void addElement(Element root, Parser parser) {
        Element orderEle = root.addElement("order_info");
        orderEle.addElement("logical_order").addText(logicalOrder.name());
        Vocabulary vocabulary = parser.getVocabulary();
        if (!modifierOrder.isEmpty()) {
            Element modifierOrderEle = orderEle.addElement("modifier_order");
            for (int i = 0; i < modifierOrder.size(); ++i) {
                StringBuilder builder = new StringBuilder();
                for (int modifier : modifierOrder.get(i)) {
                    if (modifier == -1) {
                        builder.append("EMPTY");
                    } else {
                        builder.append(vocabulary.getSymbolicName(modifier));
                    }
                    builder.append(",");
                }
                modifierOrderEle.addElement("layer" + (i + 1)).addText(
                        builder.length() > 0 ? builder.substring(0, builder.length() - 1) : "");
            }
        }
        orderEle.addElement("allowed_order_deviation").addText(Double.toString(allowedOrderDeviation));
    }

    public static Order parseElement(Element root, Parser parser) {
        Element orderEle = root.element("order_info");
        Order order = new Order();
        order.logicalOrder = EnumType.valueOf(orderEle.element("logical_order").getText());
        Element modifierOrderEle = orderEle.element("modifier_order");
        if (modifierOrderEle != null) {
            List<Element> layers = modifierOrderEle.elements();
            for (Element layer : layers) {
                String[] arr = layer.getText().split(",");
                List<Integer> modifierLayer = new ArrayList<>();
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equals("EMPTY")) {
                        modifierLayer.add(-1);
                    } else {
                        modifierLayer.add(parser.getTokenType(arr[i]));
                    }
                }
                order.modifierOrder.add(modifierLayer);
            }
        }
        Order.allowedOrderDeviation = Double.valueOf(orderEle.element("allowed_order_deviation").getText());
        return order;
    }

    public String toReadableString(Parser parser) {
        StringBuilder builder = new StringBuilder();
        Vocabulary vocabulary = parser.getVocabulary();
        builder.append("logic order: ").append(logicalOrder.name().toLowerCase()).append(System.lineSeparator());
        if (!modifierOrder.isEmpty()) {
            builder.append("modifier order of each layer: ").append(System.lineSeparator());
        }
        for (int i = 0; i < modifierOrder.size(); ++i) {
            builder.append(i + 1).append("th layer: ");
            for (int modifier : modifierOrder.get(i)) {
                if (modifier == -1) {
                    builder.append("empty");
                } else {
                    builder.append(vocabulary.getSymbolicName(modifier).toLowerCase());
                }
                builder.append(",");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}