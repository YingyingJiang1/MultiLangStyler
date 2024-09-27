package org.example.styler.arrangement.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.antlr.JavaParser;
import org.example.style.StyleProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrangementProperty extends StyleProperty {
    List<ContentArea> areas = new ArrayList<>();

    public List<ContentArea> getAreas() {
        return areas;
    }

    @Override
    public void addElement(Element parent, Parser parser) {

    }

    @Override
    public Object parseElement(Element parent, Parser parser) {
        return null;
    }


    public static class ContentArea {

        private int category; // @category is JavaParser.RULE_XXXList
        public Feature feature; // The @feature is used when matching areas of the same category.
        public Order order;

        public ContentArea(int category) {
            this.category = category;
        }

        public int calDistance(ContentArea area) {
            if (area.category == category) {
                return feature.calDistance(area.feature);
            }
            return isSimilarCategory(category, area.category) ? 1 : Integer.MAX_VALUE;
        }

        private boolean isSimilarCategory(int category, int category1) {
            List<Integer> methods = Arrays.asList(JavaParser.RULE_methodDeclarationList,
                    JavaParser.RULE_constructorDeclarationList);
            return methods.contains(category) && methods.contains(category1);
        }

        public void fillArea(Feature feature, Order order) {
            this.feature = feature;
            this.order = order;
        }

        public Order getOrder() {
            return order;
        }

        public void addElement(Element root, Parser parser) {
            Element areaEle = root.addElement(parser.getRuleNames()[category] + "_area");
            feature.addElement(areaEle, parser);
            order.addElement(areaEle, parser);
        }

        public static ContentArea parseElement(Element root, Parser parser) {
            String areaName = root.getText();
            ContentArea area = null;
            switch (areaName) {
                case "typeDeclarationList_area":
                    area = new TypeDecArea(JavaParser.RULE_typeDeclaration);
                    break;
                case "fieldDeclarationList_area":
                    area = new FieldDecArea(JavaParser.RULE_fieldDeclaration);
                    break;
                case "constructorDeclarationList_area":
                    area = new ConstructorDecArea(JavaParser.RULE_constDeclaration);
                    break;
                case "methodDeclarationList_area":
                    area = new MethodDecArea(JavaParser.RULE_methodDeclaration);
                    break;
                case "initializer_area":
                    area = new InitializerArea(JavaParser.RULE_initializer);
                    break;
            }
            area.feature = Feature.parseElement(root, parser);
            area.order = Order.parseElement(root, parser);
            return area;
        }

        public String toReadableString(Parser parser) {
            String areaName = parser.getRuleNames()[category];
            return areaName + " area: {" + System.lineSeparator() +
                    "feature: {" + feature.toReadableString(parser) + "}" + System.lineSeparator() +
                    "order: {" + order.toReadableString(parser) + "}" + System.lineSeparator() +
                    "}" + System.lineSeparator();
        }
    }

    public static class FieldDecArea extends ContentArea {
        public FieldDecArea(int category) {
            super(category);
        }
    }

    public static class ConstructorDecArea extends ContentArea {
        public ConstructorDecArea(int category) {
            super(category);
        }
    }

    public static class MethodDecArea extends ContentArea {

        private boolean isOverloadsSplit;

        public MethodDecArea(int category) {
            super(category);
        }
    }

    public static class TypeDecArea extends ContentArea {
        public TypeDecArea(int category) {
            super(category);
        }
    }

    public static class InitializerArea extends ContentArea {
        public InitializerArea(int category) {
            super(category);
        }
    }
}
