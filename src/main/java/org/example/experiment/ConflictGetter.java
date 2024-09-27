package org.example.experiment;

import java.util.HashMap;

import org.example.styler.structure.style.EquivalencesStyle;
import org.example.style.format.FormatStyle;

import java.util.List;
import java.util.Map;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/5/3 17:03
 */
public class ConflictGetter {
  public static class StyleConflict {
    // key: style name
    // value: value[0]:conflict number, value[1:]:conflict percentage
    Map<String, List<Double>> conflictMap = new HashMap<>();
  }

  public static void setFormatStyleConflict(FormatStyle formatStyle, StyleConflict conflict) {

  }

  public static void setEquivalenceStyleConflict(EquivalencesStyle equivalencesStyle, StyleConflict conflict) {

  }
}

