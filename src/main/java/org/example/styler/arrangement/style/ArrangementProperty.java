package org.example.styler.arrangement.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.parser.java.antlr.JavaParser;
import org.example.io.DomIO;
import org.example.style.rule.StyleProperty;

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
        for (ArrangementProperty.ContentArea area : areas) {
            area.addElement(parent, parser);
        }
    }

    private ContentArea createArea(String areaName) {
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
        return area;
    }

    @Override
    public ArrangementProperty parseElement(Element parent, Parser parser) {
        for (Element areaEle : parent.elements()) {
            ContentArea area = createArea(areaEle.getName());
            area.parseElement(areaEle, parser);
            areas.add(area);
        }
        return this;
    }


    public static class ContentArea implements DomIO {

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


        public String toReadableString(Parser parser) {
            String areaName = parser.getRuleNames()[category];
            return areaName + " area: {" + System.lineSeparator() +
                    "feature: {" + feature.toReadableString(parser) + "}" + System.lineSeparator() +
                    "order: {" + order.toReadableString(parser) + "}" + System.lineSeparator() +
                    "}" + System.lineSeparator();
        }

        @Override
        public void addElement(Element parent, Parser parser) {
            Element areaEle = parent.addElement(parser.getRuleNames()[category] + "_area");
            feature.addElement(areaEle, parser);
            order.addElement(areaEle, parser);
        }

        @Override
        public Object parseElement(Element parent, Parser parser) {
            feature.parseElement(parent, parser);
            order.parseElement(parent, parser);
            return this;
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
