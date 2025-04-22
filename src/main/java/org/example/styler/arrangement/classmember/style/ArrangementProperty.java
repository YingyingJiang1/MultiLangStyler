package org.example.styler.arrangement.classmember.style;

import com.google.common.base.CaseFormat;
import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.parser.java.antlr.JavaParser;
import org.example.style.DomIO;
import org.example.style.rule.StyleProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArrangementProperty extends StyleProperty {
    List<ContentArea> areas = new ArrayList<>();

    public List<ContentArea> getAreas() {
        return areas;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        for (ArrangementProperty.ContentArea area : areas) {
            area.addElement(parent, parser);
        }
    }

    private ContentArea createArea(String areaName) {
        ContentArea area = null;
        switch (areaName) {
            case "typeDeclarationList_area":
                area = new TypeDecArea(JavaParser.RULE_typeDeclarationList);
                break;
            case "fieldDeclarationList_area":
                area = new FieldDecArea(JavaParser.RULE_fieldDeclarationList);
                break;
            case "constructorDeclarationList_area":
                area = new ConstructorDecArea(JavaParser.RULE_constDeclarationList);
                break;
            case "methodDeclarationList_area":
                area = new MethodDecArea(JavaParser.RULE_methodDeclarationList);
                break;
            case "initializer_area":
                area = new InitializerArea(JavaParser.RULE_initializer);
                break;
        }
        return area;
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        for (Element areaEle : parent.elements()) {
            String name = areaEle.attributeValue("name") + "_area";
            ContentArea area = createArea(name);
            if (area == null) {
                throw new RuntimeException("Unknown area name: " + name);
            }
            area.feature = new Feature();
            area.order = new Order();
            area.parseElement(areaEle, parser);
            areas.add(area);
        }
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


        public String toReadableString(MyParser parser) {
            String areaName = parser.getRuleName(category);
            return areaName + " area: {" + System.lineSeparator() +
                    "feature: {" + feature.toReadableString(parser) + "}" + System.lineSeparator() +
                    "order: {" + order.toReadableString(parser) + "}" + System.lineSeparator() +
                    "}" + System.lineSeparator();
        }

        @Override
        public void addElement(Element parent, MyParser parser) {
            Element areaEle = parent.addElement("member_list");
            areaEle.addAttribute("name", CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_CAMEL,
                    parser.getRuleName(category)));
            feature.addElement(areaEle, parser);
            order.addElement(areaEle, parser);
        }

        @Override
        public void parseElement(Element parent, MyParser parser) {
            feature.parseElement(parent, parser);
            order.parseElement(parent, parser);
        }


        @Override
        public int hashCode() {
            return Objects.hash(category, feature, order);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof ContentArea area) {
                return category == area.category && Objects.equals(feature, area.feature) && Objects.equals(order, area.order);
            }
            return false;
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

    @Override
    public int hashCode() {
        return Objects.hash(areas);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArrangementProperty property) {
            return areas.equals(property.areas);
        }
        return false;
    }
}
