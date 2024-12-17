package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;
import org.example.styler.structure.EquivalentStructure;
import org.example.styler.structure.vtree.VirtualNode;

import java.util.Arrays;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/4 19:44
 */
public class equalChecker extends Checker {

  public equalChecker(String[][] argsList) {
    super(argsList);
  }

  @Override
  protected boolean doCheck(EquivalentStructure structure, List<String> args, MyParser parser) {
    for (int i = 0; i < args.size() - 1; i++) {
      String holder1 = args.get(i), holder2 = args.get(i + 1);
      VirtualNode vNode1 = structure.getVNode(holder1);
      VirtualNode vNode2 = structure.getVNode(holder2);
      StringBuilder builder1 = new StringBuilder(), builder2 = new StringBuilder();
      for(ParseTree t : vNode1.matchedTrees) {
        builder1.append(t.getText());
      }
      for(ParseTree t : vNode2.matchedTrees) {
        builder2.append(t.getText());
      }
      if (builder1.compareTo(builder2) != 0) {
        return false;
      }
    }
    return true;
  }

}
