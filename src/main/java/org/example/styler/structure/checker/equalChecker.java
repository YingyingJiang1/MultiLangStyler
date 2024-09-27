package org.example.styler.structure.checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.styler.structure.EquivalentStructure;

import java.util.Arrays;
import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/4 19:44
 */
public class equalChecker extends Checker {

  public equalChecker(String[][] argsList) {
    this.argsList = argsList;
  }

  @Override
  public boolean check(EquivalentStructure structure, int index) {
    for(String[] arg : argsList) {
      int checkIndex = Integer.parseInt(arg[0]);
      if (index != checkIndex) {
        continue;
      }
      List<String> holderNames = Arrays.stream(arg).toList().subList(1, arg.length);
      for (int i = 0; i < holderNames.size() - 1; i++) {
        String holder1 = holderNames.get(i), holder2 = holderNames.get(i + 1);
        EquivalentStructure.VirtualNode vNode1 = structure.getVNode(holder1);
        EquivalentStructure.VirtualNode vNode2 = structure.getVNode(holder2);
        StringBuilder builder1 = new StringBuilder(), builder2 = new StringBuilder();
        for(ParseTree t : vNode1.matchedNodes) {
          builder1.append(t.getText());
        }
        for(ParseTree t : vNode2.matchedNodes) {
          builder2.append(t.getText());
        }
        if (builder1.compareTo(builder2) != 0) {
          return false;
        }
      }
    }
    return true;
  }
}
