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

    public static class LineWrapping {
        public static String styleType = "Line wrapping";
    }

    public static class BraceFormat {
        public static String styleType = "Brace format";
        public static String newlineAroundBraceAttr = "newline around braces";
    }

    public static class LayoutOfControlStmtWithoutBraces {
        public static String styleType = "Layout of control statement without braces";
        public static String inCompactModeAttr = "In compact mode";
    }

    public static class MultiLineCommentSyntax {
        public static String styleType = "Mutliple-line comment syntax";

    }

    public static class CommentDensity {
        public static String styleType = "Comment density";
    }

    public static class OperatorPreferences {
        public static String styleType = "Operator preferences";
    }

    public static class NumericalLiterals {
        public static String styleType = "Numerical literals";
    }

    public static class NamingConvention {
        public static String styleType = "Naming convention";
    }

    public static class ModifiersOrder {
        public static String styleType = "Modifiers order";
    }

    // Statement style types
    public static class OptionalBrace {
        public static String styleType = "Optional brace";
        public static String useBracesAttr = "Use braces";
    }

    public static class NumberOfVarInOneDecStmt {
        public static String styleType = "Number of variables in one declaration statement";
    }

    public static class AssignmentStmtPreferences {
        public static String styleType = "Assignment statement preferences";
    }

    public static class IncrementDecrementPreferences {
        public static String styleType = "Increment/decrement preferences";
    }

    public static class ContinuousAndCondPreferences {
        public static String styleType = "Continuous logic and conditions preferences";
    }

    public static class ContinuousOrCondPreferences {
        public static String styleType = "Continuous logic or conditions preferences";
    }

    public static class Mutlibranch {
        public static String styleType = "Mutlibranch";
    }

    public static class ContinuousAssignOrCallPreferences {
        public static String styleType = "Continuous assignments or calls preferences";
    }

    public static class ContainComplexBoolExp {
        public static String styleType = "Contain complex bool expression";
    }

    public static class ArrayDeclarationStyle {
        public static String styleType = "Array declaration style";
    }

    public static class UpdateMultiVarsInOneStmt {
        public static String styleType = "Update multiple variables in one statement";
    }

    public static class LocOfLoopVar {
        public static String styleType = "Location of looping variable";
    }

    public static class LocOfVarDeclaration {
        public static String styleType = "Location of variabe declaration";
    }

    public static class LocOfVarInitialization {
        public static String styleType = "Location of variable initialization";
    }

    public static class Loops {
        public static String styleType = "Loops";
    }

    public static class ReturnStmt {
        public static String styleType = "Return statements";
    }

    // Block style types
    public static class CheckThenReturnPreferences {
        public static String styleType = "Check then return preferences";
    }

    public static class CheckThenAssignPreferences {
        public static String styleType = "Check then assign preferences";
    }

    public static class ContinuePreferences {
        public static String styleType = "Continue preferences";
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
    }

    public static class FunctionComplexity {
        public static String styleType = "Function complexity";
    }

    // Class style types
    public static class Arrangement {
        public static String styleType = "Ordering of class contents";
        public static String memberListOrderAttr = "Member list order";
        public static String logicalOrderAttr = "Logical order";
    }
}
