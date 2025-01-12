package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
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
      if (args.length < 2) {
        logger.error("Arguments of LoopEndChecker error: length < 2");
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

  public static Checker createChecker(String cls, String[][] argsList) {
    Checker checker = switch (cls) {
      case "ContinuePreferenceChecker" -> new ContinuePreferenceChecker(argsList);
      case "EqualChecker" -> new equalChecker(argsList);
      case "NotIntegerChecker" -> new NotIntegerChecker(argsList);
      case "NotIdentifierExpChecker" -> new NotIdentifierExpChecker(argsList);
      case "IdentifierExpChecker" -> new IdentifierExpChecker(argsList);
      case "NoStmtChecker" -> new NoStmtChecker(argsList);
      case "ContainExpChecker" -> new ContainExpChecker(argsList);
      default -> null;
    };
    if (checker == null) {
      logger.error("No checker {} was found!", cls);
    }
    return checker;
  }

}
