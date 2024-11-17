package org.example.style.name;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/4 11:54
 */
public enum SymbolCategory {
  INTERFACE, CLASS, RECORD, ENUM, ANNOTATION, METHOD, CONSTRUCTOR,
  FIELD, LOCAL_VARIABLE, FOR_VARIABLE, CATCH_PARA, CONSTRUCTOR_PARA, LAMBDA_PARA, PARAMETER,  ENUM_CONT,
  UNKNOWN,
  ;

	private static Set<SymbolCategory> members = new HashSet<>(Arrays.asList(
      INTERFACE, CLASS, RECORD, ENUM, ANNOTATION, METHOD, CONSTRUCTOR,
      FIELD, ENUM_CONT
  ));

  public static boolean isMember(SymbolCategory category) {
    return members.contains(category);
  }
}
