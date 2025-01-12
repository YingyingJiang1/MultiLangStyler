package org.example.styler.structure.handler;

import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

  public void handle(EquivalentStructure structure, int from, int to, MyParser parser) {}

  public static Handler createHandler(String cls, String[][] argsList, MyParser parser) {
    Handler handler =  switch (cls) {
      case "CondReverserHandler" -> new CondReverserHandler(argsList);
      case "ReplicationHandler" -> new ReplicationHandler(argsList);
      case "WrapCondHandler" -> new WrapCondHandler(argsList);
      case "OpOpAssignConvertHandler" -> new OpOpAssignConvertHandler(argsList);
      case "ExpStmt2ExpHandler" -> new ExpStmt2ExpHandler(argsList);
      case "Exp2ExpStmtHandler" -> new Exp2ExpStmtHandler(argsList);
      case "AssignCallExpHandler" -> new AssignCallExpHandler(argsList);
      case "ReplaceExpHandler" -> new ReplaceExpHandler(argsList);
      default -> null;
    };
    if (handler == null) {
      LoggerFactory.getLogger(Handler.class).error("Handler not found: " + cls);
    }
    return handler;
  }

  protected void doHandle(MyParser parser) {

  }
}
