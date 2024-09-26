package org.example.style.name;

import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/28 21:00
 */
public class AbbreviationRule {
  private int minLength, minTotalLength;
  private double percent;
  int counts = 0;
  private static final int ABBREVIATION_LEN = 3;
  public static boolean isAbbreviation(String word) {
    return true;
  }

  public String abbreviate(String word, int totalLength) {
    double curPercent = word.length() / totalLength;
    boolean shouldAbbreviate = word.length() > minLength && totalLength > minTotalLength && curPercent > percent;
    if(shouldAbbreviate && word.length() > ABBREVIATION_LEN) {
      return word.substring(0, ABBREVIATION_LEN);
    }
    return word;
  }

  public void extractRule(List<String> words, int nameLength) {
    double percent = 0;
    for(String word : words) {
      if(word.matches("[a-zA-Z]+")) {
        if(isAbbreviation(word)) {
          percent = word.length() / nameLength;
          this.percent += percent / 2;
          this.minLength += word.length() / 2;
          this.minTotalLength += nameLength / 2;
        }
      }
    }
  }

}
