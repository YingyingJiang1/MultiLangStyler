package org.example.styler.structure.checker;

import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

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
   * argsList: [[index of writing, ...]]
   */
  public boolean check(EquivalentStructure structure, int index, MyParser parser) {
    for (String[] args : argsList) {
      if (args.length < 1) {
        logger.error("Arguments of Checker error: length < 1");
        continue;
      }
      int configuredIndex = Integer.parseInt(args[0]);
      if (configuredIndex == index) {
        List<String> args1 = Arrays.stream(args).toList().subList(1, args.length);
        boolean ret = doCheck(structure, args1, parser);
        if (!ret) {
          return false;
        }
      }
    }
    return true;
  }

  protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
    return true;
  }

  public static Checker create(String cls, String[][] argsList) {
    Checker checker = switch (cls) {
      case "ContinuePreferenceChecker" -> new ContinuePreferenceChecker(argsList);
      case "EqualChecker" -> new equalChecker(argsList);
      case "NotIntegerChecker" -> new NotIntegerChecker(argsList);
      case "NotIdentifierExpChecker" -> new NotIdentifierExpChecker(argsList);
      case "IdentifierExpChecker" -> new IdentifierExpChecker(argsList);
      case "UnreachableCauseChecker" -> new UnreachableCauseChecker(argsList);
      case "ContainChecker" -> new ContainChecker(argsList);
      case "HasSameEndingStmtChecker" -> new HasSameEndingStmtChecker(argsList);
      case "StmtComplexityChecker" -> new StmtComplexityChecker(argsList);
      case "EndsWithChecker" -> new EndsWithChecker(argsList);
      case "VarUpdateStmtChecker" -> new VarUpdateStmtChecker(argsList);
      case "NotLiteralExpChecker" -> new NotLiteralExpChecker(argsList);
      case "HasJumpStmtChecker" -> new HasJumpStmtChecker(argsList);
      case "CascadingIfChecker" -> new CascadingIfChecker(argsList);
      case "NoSubExpChecker" -> new NoSubExpChecker(argsList);
      default -> null;
    };
    if (checker == null) {
      logger.error("No checker {} was found!", cls);
    }
    return checker;
  }

}
