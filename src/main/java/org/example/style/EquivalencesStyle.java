package org.example.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/4 17:17
 */
public class EquivalencesStyle extends Style {

  public Map<Integer, List<Integer>> equivalences = new HashMap<>();

  public void addRule(Integer id, Integer index) {
    equivalences.computeIfAbsent(id, k -> new ArrayList<>());
    equivalences.get(id).add(index);
  }

  @Override
  public void addElement(Element parent, Parser parser) {
    Element equivalencesEle = parent.addElement("equivalences");
    for(Map.Entry<Integer, List<Integer>> entry : equivalences.entrySet()) {
      equivalencesEle.addElement("equivalence")
          .addText(entry.getKey() + ":id" + "," + entry.getValue().get(0) +
          ":index");
    }
  }

  @Override
  public Object parseElement(Element parent, Parser parser) {
    Element equivalencesEle = parent.element("equivalences");
    for (Element ele : equivalencesEle.elements()) {
      String[] strs = ele.getText().split("[:,]");
      List<Integer> value = new ArrayList<>(1);
      value.set(1, Integer.parseInt(strs[2]));
      equivalences.put(Integer.parseInt(strs[0]), value);
    }
    return this;
  }

  public int getProperty(Integer id) {
    List<Integer> value = equivalences.get(id);
    return value == null ? -1 : value.get(0);
  }

  @Override
  public void fill() {
    for (List<Integer> indexes : equivalences.values()) {
      Map<Integer, Integer> indexCounts = new HashMap<>();
      for(int index : indexes) {
        indexCounts.compute(index, (k, v) -> v == null ? 1 : v + 1);
      }
      int maxCount = 0;
      int targetIndex = 0;
      for(Map.Entry<Integer, Integer> entry : indexCounts.entrySet()) {
        if (entry.getValue() > maxCount || (entry.getValue() == maxCount && entry.getKey() < targetIndex)) {
          maxCount = entry.getValue();
          targetIndex = entry.getKey();
        }
      }
      indexes.clear();
      indexes.add(targetIndex);
    }
    // System.err.println("method @fill of @EquivalenceStyle is commented!");
  }
}
