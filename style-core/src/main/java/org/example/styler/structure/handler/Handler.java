package org.example.styler.structure.handler;

import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/4 19:44
 */
public abstract class Handler {
  public static Logger logger = LoggerFactory.getLogger(Handler.class);
  String[][] argsList;

  public Handler(String[][] argsList) {
    this.argsList = argsList;
  }

  public void handle(EquivalentStructure structure, int from, int to, MyParser parser) {
    for(String[] args : argsList) {
      if (args.length < 2) {
        logger.error("Arguments error: at least 2 arguments required but got {}", args.length);
        continue;
      }
      int index1 = Integer.parseInt(args[0]), index2 = Integer.parseInt(args[1]);
      if(index1 == from && index2 == to) {
        doHandle(structure, Arrays.stream(args).toList().subList(2, args.length),  parser);
      }
    }
  }

  public static Handler create(String cls, String[][] argsList) {
    Handler handler =  switch (cls) {
      case "CondReverserHandler" -> new CondReverserHandler(argsList);
      case "ReplicationHandler" -> new ReplicationHandler(argsList);
      case "WrapCondHandler" -> new WrapCondHandler(argsList);
      case "OpOpAssignConvertHandler" -> new OpOpAssignConvertHandler(argsList);
      case "ExpStmt2ExpHandler" -> new ExpStmt2ExpHandler(argsList);
      case "Exp2ExpStmtHandler" -> new Exp2ExpStmtHandler(argsList);
      case "AssignCallExpHandler" -> new AssignCallExpHandler(argsList);
      case "ReplaceHandler" -> new ReplaceHandler(argsList);
      case "AppendTreeHandler" -> new AppendTreeHandler(argsList);
      case "RedundantCodeHandler" -> new RedundantCodeHandler(argsList);
      case "BraceWrapHandler" -> new BraceWrapHandler(argsList);
      case "ConflictNameHandler" -> new ConflictNameHandler(argsList);
      case "DecThenAssignExceptionHandler" -> new DecThenAssignExceptionHandler(argsList);
      case "VarUndefExceptionHandler" -> new VarUndefExceptionHandler(argsList);
      case "For2whileHandler" -> new For2whileHandler(argsList);
      case "RemoveCommonSuffixHandler" -> new RemoveCommonSuffixHandler(argsList);
      default -> null;
    };
    if (handler == null) {
      LoggerFactory.getLogger(Handler.class).error("Handler not found: " + cls);
    }
    return handler;
  }

  protected void doHandle(EquivalentStructure structure, List<String> args, MyParser parser) {

  }
}
