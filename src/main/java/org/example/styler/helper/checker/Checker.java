package org.example.styler.helper.checker;

import org.example.styler.helper.EquivalentStructure;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/4 23:41
 */
public abstract class Checker {
  String[][] argsList;
  /**
   * index1, index2 are the indexes of holders in an equivalent structure.
   */
  public boolean check(EquivalentStructure structure, int index) {return true;}

  public static Checker createChecker(String cls, String[][] argsList) {
    if(cls.equals("EqualChecker")) {
      return new equalChecker(argsList);
    }
    if(cls.equals("NotIntegerCheck")) {
      return new NotIntegerCheck(argsList);
    }
    throw new RuntimeException("wrong checker name:" + cls);
  }

}
