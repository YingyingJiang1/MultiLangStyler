package org.example.styler.arrangement.classmember.style;

import org.dom4j.Element;
import org.example.style.DomIO;
import org.example.parser.common.MyParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/1 14:34
 */
public class Order implements DomIO {


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

    public int getColumnNumberWithMostModifiers() {
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

    String toReadableString(MyParser parser) {
        StringBuilder builder = new StringBuilder();
        builder.append("logic order: ").append(logicalOrder.name().toLowerCase()).append(System.lineSeparator());
        if (!modifierOrder.isEmpty()) {
            builder.append("modifier order of each column: ").append(System.lineSeparator());
        }
        for (int i = 0; i < modifierOrder.size(); ++i) {
            builder.append(i + 1).append("th column: ");
            for (int modifier : modifierOrder.get(i)) {
                if (modifier == -1) {
                    builder.append("empty");
                } else {
                    builder.append(parser.getTokenName(modifier));
                }
                builder.append(",");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        Element orderEle = parent.addElement("order");
        orderEle.addElement("logical_order").addText(logicalOrder.name());
        if (!modifierOrder.isEmpty()) {
            Element modifierOrderEle = orderEle.addElement("modifier_order");
            for (int i = 0; i < modifierOrder.size(); ++i) {
                StringBuilder builder = new StringBuilder();
                for (int modifier : modifierOrder.get(i)) {
                    if (modifier == -1) {
                        builder.append("EMPTY");
                    } else {
                        builder.append(parser.getTokenName(modifier));
                    }
                    builder.append(",");
                }
                modifierOrderEle.addElement("column" + (i + 1)).addText(
                        builder.length() > 0 ? builder.substring(0, builder.length() - 1) : "");
            }
        }
        orderEle.addAttribute("allowedOrderDeviation", Double.toString(allowedOrderDeviation));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        Element orderEle = parent.element("order");
        logicalOrder = EnumType.valueOf(orderEle.element("logical_order").getText());
        Element modifierOrderEle = orderEle.element("modifier_order");
        if (modifierOrderEle != null) {
            List<Element> columns = modifierOrderEle.elements();
            for (Element column : columns) {
                String[] arr = column.getText().split(",");
                List<Integer> modifierColumn = new ArrayList<>();
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equals("EMPTY")) {
                        modifierColumn.add(-1);
                    } else {
                        modifierColumn.add(parser.getType(arr[i]));
                    }
                }
                modifierOrder.add(modifierColumn);
            }
        }
        Order.allowedOrderDeviation = orderEle.attribute("allowedOrderDeviation") == null ?
                0.3 : Double.parseDouble(orderEle.attributeValue("allowedOrderDeviation"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(logicalOrder, modifierOrder);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Order order) {
            return Objects.equals(logicalOrder, order.logicalOrder) && Objects.equals(modifierOrder, order.modifierOrder);
        }
        return false;
    }
}