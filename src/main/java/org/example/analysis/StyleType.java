package org.example.analysis;

import java.util.ArrayList;
import java.util.List;

public class StyleType {
    private static List<String> styleTypes = null;
    public static List<String> getAllStyleTypes() {
         if (styleTypes != null) {
             return styleTypes;
         }
         styleTypes = new ArrayList<>();
         styleTypes.add(Indention.styleType);
         styleTypes.add(Space.styleType);
         styleTypes.add(OneStatementInOneLine.styleType);
         styleTypes.add(BlankLine.styleType);
         styleTypes.add(LineLength.styleType);
         styleTypes.add(BraceFormat.styleType);
         styleTypes.add(LayoutOfControlStmtWithoutBraces.styleType);
         styleTypes.add(CommentSyntax.styleType);
         styleTypes.add(CommentDensity.styleType);
         styleTypes.add(LiteralUsage.styleType);
         styleTypes.add(NamingFormat.styleType);
         styleTypes.add(ModifiersOrder.styleType);
         styleTypes.add(OptionalBrace.styleType);
         styleTypes.add(NumberOfVarInOneDecStmt.styleType);
         styleTypes.add(MostComplexExp.styleType);
         styleTypes.add(VarUpdating.styleType);
         styleTypes.add(LocOfVarDeclaration.styleType);
         styleTypes.add(Mutlibranch.styleType);
         styleTypes.add(OrderOfIfElseBodies.styleType);
         styleTypes.add(OrderOfFunctionPara.styleType);
         styleTypes.add(FunctionComplexity.styleType);
         styleTypes.add(Arrangement.styleType);

         styleTypes.add("Increment or decrement preferences");
         styleTypes.add("Assignment statement preferences");
         styleTypes.add("Continuous logic and preferences");
         styleTypes.add("Continuous logic or preferences");
         styleTypes.add("Continuous assignments or calls preferences");
         styleTypes.add("Check then return preferences");
         styleTypes.add("Check then assign preferences");
         styleTypes.add("Operator preferences");
         styleTypes.add("Literal position in bool expression");
         styleTypes.add("Return statements");
         styleTypes.add("Array declaration style");
         styleTypes.add("Continue preferences");
         styleTypes.add("Redundant code");
        return styleTypes;
    }


    public static class UnusedVar {
        public static String styleType = "Contain unused local variables";
        public static String unusedVarAttr = "Contain";
    }

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
        public static String styleType = "One statement a line";
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
        public static String styleType = "Layout of control statement";
        public static String inCompactModeAttr = "In compact mode";
    }

    public static class CommentSyntax {
        public static String styleType = "Comment syntax";
        public static String commentSyntaxAttr = "Comment syntax";
    }

    public static class CommentDensity {
        public static String styleType = "Comment density";
        public static String LineDensityAttr = "Line density";
    }

    public static class LiteralUsage {
        public static String styleType = "Literal usage";
        public static String decCons = "Declare variable for constant";
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
        public static String styleType = "Number of a declaration";
        public static String varsPerDec = "The number of variables per declaration";
    }

    public static class MostComplexExp {
        public static String styleType = "Expression complexity";
        public static String maxLengthAttr = "Max text length of all expressions";
        public static String maxSubExpNum = "Max number of sub-expressions of all expressions";
    }

    public static class VarUpdating {
        public static String styleType = "Variable updating";
    }


    public static class LocOfVarDeclaration {
        public static String styleType = "Location of local variable declaration";
        public static String locationAttr = "Location";
    }


    public static class Mutlibranch {
        public static String styleType = "Mutlibranch";
    }

    public static class OrderOfIfElseBodies {
        public static String styleType = "Order of if-else bodies";
        public static String shortBodyComesFirstAttr = "body with less lines comes first";
    }

    public static class Loops {
        public static String styleType = "Loops";
        public static String forAttr = "for";
        public static String whileAttr = "while";
        public static String doWhileAttr = "do-while";
        public static String forEachAttr = "for-each";
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
