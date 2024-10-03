package org.example.styler.newline.style;

import org.example.antlr.JavaParser;
import org.example.interfaces.StyleRule;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/28 23:04
 */
public class NewlineRule extends StyleRule {
  public static NewlineProperty defaultNewlineProperty = new NewlineProperty(1);

  public NewlineContext newlineContext = new NewlineContext();
  public NewlineProperty newlineProperty = new NewlineProperty();

  private static Set<Integer> defaultCases = new HashSet<>(Arrays.asList(
      JavaParser.RULE_packageDeclaration,JavaParser.RULE_importDeclaration,JavaParser.RULE_importDeclarationList,
      JavaParser.RULE_fieldDeclaration, JavaParser.RULE_fieldDeclarationList,
      JavaParser.RULE_localVariableDeclarationStmt,JavaParser.RULE_assertStmt,
      JavaParser.RULE_returnStmt, JavaParser.RULE_throwStmt, JavaParser.RULE_breakStmt, JavaParser.RULE_continueStmt,
      JavaParser.RULE_yieldStmt,JavaParser.RULE_expressionStmt,JavaParser.RULE_labelStmt,
      JavaParser.RULE_annotation, JavaParser.RULE_annotationList
  ));

  public NewlineRule() {

  }

  public NewlineRule(NewlineContext newlineContext, NewlineProperty newlineProperty) {
    this.newlineContext = newlineContext;
    this.newlineProperty = newlineProperty;
  }

  public static boolean isDefaultCase(NewlineContext newlineContext) {
		return defaultCases.contains(newlineContext.type1);
  }

}
