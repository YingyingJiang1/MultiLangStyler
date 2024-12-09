package org.example.styler.boolexp.style;

import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.Objects;

public class ComplexBoolExpProperty extends StyleProperty {
    public int expressionLength;
    public int predicateNum;
    public int logicalOpKind;

    public ComplexBoolExpProperty(int length, int predicateNum, int logicalOpKind) {
        this.expressionLength = length;
        this.predicateNum = predicateNum;
        this.logicalOpKind = logicalOpKind;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {
        parent.addAttribute("expressionLength", Integer.toString(expressionLength));
        parent.addAttribute("predicateNum", Integer.toString(predicateNum));
        parent.addAttribute("logicalOpKind", Integer.toString(logicalOpKind));
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
        expressionLength = Integer.parseInt(parent.attributeValue("expressionLength"));
        predicateNum = Integer.parseInt(parent.attributeValue("predicateNum"));
        logicalOpKind = Integer.parseInt(parent.attributeValue("logicalOpKind"));
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                expressionLength,
                predicateNum,
                logicalOpKind

        );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ComplexBoolExpProperty property) {
            return expressionLength == property.expressionLength
                    && predicateNum == property.predicateNum
                    && logicalOpKind == property.logicalOpKind;
        }
        return false;
    }

    private static final int EXPRESSION_LENGTH_MIN = 0;
    private static final int EXPRESSION_LENGTH_MAX = 300;
    private static final int PREDICATE_NUM_MIN = 1;
    private static final int PREDICATE_NUM_MAX = 10;
    private static final int LOGICAL_OP_KIND_MIN = 0;
    private static final int LOGICAL_OP_KIND_MAX = 3;

    // 权重
    private static final double EXPRESSION_LENGTH_WEIGHT = 0.6;  // expressionLength的权重较大
    private static final double PREDICATE_NUM_WEIGHT = 0.2;
    private static final double LOGICAL_OP_KIND_WEIGHT = 0.2;

    @Override
    public int compareTo(StyleProperty o) {
        if (o instanceof ComplexBoolExpProperty other) {
            double normExpressionLength = normalize(expressionLength, EXPRESSION_LENGTH_MIN, EXPRESSION_LENGTH_MAX);
            double normPredicateNum = normalize(predicateNum, PREDICATE_NUM_MIN, PREDICATE_NUM_MAX);
            double normLogicalOpKind = normalize(logicalOpKind, LOGICAL_OP_KIND_MIN, LOGICAL_OP_KIND_MAX);

            double otherNormExpressionLength = normalize(other.expressionLength, EXPRESSION_LENGTH_MIN, EXPRESSION_LENGTH_MAX);
            double otherNormPredicateNum = normalize(other.predicateNum, PREDICATE_NUM_MIN, PREDICATE_NUM_MAX);
            double otherNormLogicalOpKind = normalize(other.logicalOpKind, LOGICAL_OP_KIND_MIN, LOGICAL_OP_KIND_MAX);
            return Double.compare(
                    mod(normExpressionLength, normPredicateNum, normLogicalOpKind),
                    mod(otherNormExpressionLength, otherNormPredicateNum, otherNormLogicalOpKind)
            );
        }
        return -1;
    }

    private double normalize(int value, int min, int max) {
        return (double) (value - min) / (max - min);
    }

    private double mod(double length, double predicateNum, double logicalOpKind) {
        return EXPRESSION_LENGTH_WEIGHT * length + PREDICATE_NUM_WEIGHT * predicateNum + LOGICAL_OP_KIND_WEIGHT * logicalOpKind;
    }
}
