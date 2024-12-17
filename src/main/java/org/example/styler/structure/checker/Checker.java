package org.example.styler.structure.checker;

import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/4 23:41
 */
public abstract class Checker {
  public static Logger logger = LoggerFactory.getLogger(Checker.class);

  String[][] argsList;

  public Checker(String[][] argsList) {
    this.argsList = argsList;
  }

  /**
   * @param index  index of writing to be checked.
   * @param parser
   */
  public boolean check(EquivalentStructure structure, int index, MyParser parser) {return true;}

  public static Checker createChecker(String cls, String[][] argsList) {
    Checker checker = switch (cls) {
      case "ContinuePreferenceChecker" -> new ContinuePreferenceChecker(argsList);
      case "EqualChecker" -> new equalChecker(argsList);
      case "NotIntegerChecker" -> new NotIntegerChecker(argsList);
      case "NotIdentifierExpChecker" -> new NotIdentifierExpChecker(argsList);
      case "IdentifierExpChecker" -> new IdentifierExpChecker(argsList);
      default -> null;
    };
    if (checker == null) {
      logger.error("No checker {} was found!", cls);
    }
    return checker;
  }

}
