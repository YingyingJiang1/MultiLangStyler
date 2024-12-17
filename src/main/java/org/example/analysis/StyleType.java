package org.example.analysis;

public class StyleType {

    // Token style types
    public static class Indention {
        public static String styleType = "Indention";
        public static String indentionTypeAttr = "Indention type";
        public static String indentationUnitAttr = "Indentation unit";
    }

    public static class Space {
        public static String styleType = "Space";
        public static String spaceAroundAttr = "Space around";
        public static String spaceBetweenAttr = "Space between";
    }

    public static class OneStatementInOneLine {
        public static String styleType = "One statement in one line";
        public static String oneStmtPerLineAttr = "One statement per line";
    }

    public static class BlankLine {
        public static String styleType = "Blank line";
        public static String percentOfAllLinesAttr = "Percent of all lines";
        public static String reasonablenessAttr = "Avg distance of adjacent blank lines";
    }

    public static class LineLength {
        public static String styleType = "Line length";
        public static String maxLineLengthAttr = "Max line length";
        public static String avgLineLengthAttr = "Avg line length";
        public static String varianceAttr = "Variance of line length";
    }

    public static class BraceFormat {
        public static String styleType = "Brace format";
        public static String newlineAroundBraceAttr = "newline around braces";
    }

    public static class LayoutOfControlStmtWithoutBraces {
        public static String styleType = "Layout of control statement without braces";
        public static String inCompactModeAttr = "In compact mode";
    }

    public static class CommentSyntax {
        public static String styleType = "Comment syntax";
    }

    public static class CommentDensity {
        public static String styleType = "Comment density";
        public static String LineDensityAttr = "Line density";
    }

    public static class LiteralUsage {
        public static String styleType = "Literal usage";
    }

    public static class NamingFormat {
        public static String styleType = "Naming format";
        public static String caseFormatAttr = "Case format";
        public static String maxLengthAttr = "Max length";
    }

    public static class ModifiersOrder {
        public static String styleType = "Modifiers order";
        public static String orderAttr = "Order";
    }

    // Statement style types
    public static class OptionalBrace {
        public static String styleType = "Optional brace";
        public static String useBracesAttr = "Use braces";
    }

    public static class NumberOfVarInOneDecStmt {
        public static String styleType = "Number of variables in one declaration statement";
    }

    public static class MostComplexExp {
        public static String styleType = "The most complex expression";
        public static String maxLengthAttr = "Max text length of all expressions";
        public static String maxSubExpNum = "Max number of sub-expressions of all expressions";
    }

    public static class ArrayDeclarationStyle {
        public static String styleType = "Array declaration style";
    }

    public static class VarUpdating {
        public static String styleType = "Variable updating";
    }

    public static class LocOfLoopVar {
        public static String styleType = "Location of looping variable";
    }

    public static class LocOfVarDeclaration {
        public static String styleType = "Location of variable declaration";
        public static String locationAttr = "Location";
    }

    public static class LocOfVarInitialization {
        public static String styleType = "Location of variable initialization";
    }

    public static class Mutlibranch {
        public static String styleType = "Mutlibranch";
    }


    public static class PresenceOfDefaultLabel {
        public static String styleType = "Presence of the `default` label";
    }

    public static class CreateVarForMultiUses {
        public static String styleType = "Create a variable for multiple uses";
    }

    public static class RedundantCode {
        public static String styleType = "Redundant code";
    }

    public static class ContainUnusedCode {
        public static String styleType = "Contain unused code";
    }

    public static class OrderOfIfElseBodies {
        public static String styleType = "Order of if-else bodies";
        public static String shortBodyComesFirstAttr = "body with less lines comes first";
    }

    // Expression style types
    public static class LiteralPosInBoolExp {
        public static String styleType = "Literal position in bool expression";
    }

    public static class FieldAccess {
        public static String styleType = "Field access in class";
    }

    public static class StaticMembersAccess {
        public static String styleType = "Static members access";
    }

    public static class ParenInExp {
        public static String styleType = "Parentheses in expressions";
    }

    // Function style types
    public static class OrderOfFunctionPara {
        public static String styleType = "Order of function parameters";
        public static String logicalOrderAttr = "Logical order";
        public static String separateSameTypeAttr = "Separate parameters of same type";
    }

    public static class FunctionComplexity {
        public static String styleType = "Function complexity";
        public static String maxNestingDepth = "Max nesting depth of all functions";
        public static String maxLines = "Max number of lines of all functions";
    }

    // Class style types
    public static class Arrangement {
        public static String styleType = "Ordering of class contents";
        public static String memberListOrderAttr = "Member list order";
        public static String logicalOrderAttr = "Logical order";
    }
}
