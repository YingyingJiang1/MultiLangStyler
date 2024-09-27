package org.example.styler.structure.handler;

import org.example.styler.structure.EquivalentStructure;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/4 19:44
 */
public abstract class Handler {
  String[][] argsList;

  public void handle(EquivalentStructure structure, int from, int to) {}

  public static Handler createHandler(String cls, String[][] argsList) {
    if(cls.equals("CondReverser")) {
      return new CondReverserHandler(argsList);
    }
    if(cls.equals("ReplicationHandler")) {
      return new ReplicationHandler(argsList);
    }
    if(cls.equals("WrapCondHandler")) {
      return new WrapCondHandler(argsList);
    }
    if(cls.equals("OpOpAssignConvertHandler")) {
      return new OpOpAssignConvertHandler(argsList);
    }
    throw new RuntimeException("wrong handler name:" + cls);
  }
}
