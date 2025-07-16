package org.example.styler.structure.handler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.*;
import org.example.utils.ParseTreeUtil;
import org.example.parser.java.antlr.JavaParser;
import org.example.styler.structure.EquivalentStructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/4 23:48
 */
public class CondReverserHandler extends Handler{
  // key: compare operator, value: reversed compare operator
  static Map<String, String> compareOpMap ;
  static Map<String, String> logicalOpMap;

  static {
    compareOpMap = new HashMap<>();
    compareOpMap.put(">", "<=");
    compareOpMap.put("<", ">=");
    compareOpMap.put(">=", "<");
    compareOpMap.put("<=", ">");
    compareOpMap.put("==", "!=");
    compareOpMap.put("!=", "==");

    logicalOpMap = new HashMap<>();
    logicalOpMap.put("&&", "||");
    logicalOpMap.put("||", "&&");
  }

  public CondReverserHandler(String[][] argsList) {
    super(argsList);
  }


  @Override
  protected void doHandle(EquivalentStructure structure, List<String> args, MyParser parser) {
    for (int i = 0; i < args.size(); i++) {
      String holderName = args.get(i);
      List<ParseTree> matchedTrees = structure.getVNode(holderName).matchedTrees;
      for (int j = 0; j < matchedTrees.size(); j++) {
        ParseTree t = matchedTrees.get(j);
        if (t instanceof JavaParser.ExpressionContext ctx) {
          matchedTrees.set(j, ParseTreeUtil.getInstance().negateExpressionSmart(ctx, parser));
        }
      }
    }
  }
}
