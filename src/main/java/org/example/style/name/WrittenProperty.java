package org.example.style.name;


import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Vocabulary;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;
import org.example.style.name.segmenter.Dictionary;
import org.example.style.name.segmenter.Segmenter;
import org.example.style.name.segmenter.SimpleSegmenter;

import java.lang.reflect.Parameter;
import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/28 21:28
 */
public class WrittenProperty {

  private static final int UPPER_CASE = 1;
  private static final int LOWER_CASE = 2;
  private static final int CAMEL_CASE = 3;
  private static final int DIFF_FROM_PREVIOUS_CHAR = 4;

  private int startingUnderscoreLength;
  private int endingUnderscoreLength;
  private int nameCase;
  private boolean isFirstCharUpperCase;
  private int separatorUnderscoreLength;
  int count = 0; // Record the number of  the same Property instance.

  public WrittenProperty() {}

  public void addElement(Element parent, Parser parser) {
    Element property = parent.addElement("property");
    property.addComment("1: UPPER_CASE, 2: LOWER_CASE, 3: CAMEL_CASE");
    property.addAttribute("startingUnderscoreLength", Integer.toString(startingUnderscoreLength));
    property.addAttribute("endingUnderscoreLength", Integer.toString(endingUnderscoreLength));
    property.addAttribute("nameCase", Integer.toString(nameCase));
    property.addAttribute("isFirstCharUpperCase", Boolean.toString(isFirstCharUpperCase));
    property.addAttribute("separatorUnderscoreLength", Integer.toString(separatorUnderscoreLength));

  }

  public static WrittenProperty parseElement(Element parent, Parser parser) {
    Element propertyEle = parent.element("property");
    WrittenProperty property = new WrittenProperty();
    property.startingUnderscoreLength = Integer.parseInt(propertyEle.attributeValue("startingUnderscoreLength"));
    property.endingUnderscoreLength = Integer.parseInt(propertyEle.attributeValue("endingUnderscoreLength"));
    property.nameCase = Integer.parseInt(propertyEle.attributeValue("nameCase"));
    property.isFirstCharUpperCase = Boolean.parseBoolean(propertyEle.attributeValue("isFirstCharUpperCase"));
    property.separatorUnderscoreLength = Integer.parseInt(propertyEle.attributeValue("separatorUnderscoreLength"));
    return property;
  }

  public String newWrittenName(List<String> words) {
    StringBuilder builder = new StringBuilder(StringUtils.repeat('_', startingUnderscoreLength));
    int i = 0;
    String firstWord = words.get(0).matches("_+") ? words.get(++i) : words.get(i++);
    if(nameCase == UPPER_CASE) {
      firstWord = firstWord.toUpperCase();
    } else {
      firstWord = firstWord.toLowerCase();
    }
    if (isFirstCharUpperCase) {
      firstWord = Character.toUpperCase(firstWord.charAt(0)) + firstWord.substring(1);
    }
    builder.append(firstWord);
    for(; i < words.size(); ++i) {
      String word = words.get(i);
      if(word.matches("[a-zA-Z]+")) {
        if (nameCase == CAMEL_CASE) {
          String lowerWord = word.toLowerCase();
          if(Character.isAlphabetic(builder.charAt(builder.length() - 1)) &&
              Character.isAlphabetic(word.charAt(0))) {
            builder.append(Character.toUpperCase(lowerWord.charAt(0))).append(lowerWord.substring(1));
          } else {
            builder.append(lowerWord);
          }
        } else {
          if(Character.isAlphabetic(builder.charAt(builder.length() - 1)) &&
          Character.isAlphabetic(word.charAt(0))) {
            builder.append(StringUtils.repeat('_', separatorUnderscoreLength));
          }
          if (nameCase == UPPER_CASE) {
            builder.append(word.toUpperCase());
          } else {
            builder.append(word.toLowerCase());
          }
        }
      } else if(word.matches("[0-9]+")) {
        builder.append(word);
      }
    }

    builder.append(StringUtils.repeat('_', endingUnderscoreLength));
    return builder.toString();
  }




  public void fill(List<String> words) {

    WrittenProperty property = new WrittenProperty();
    int index = 0;
    int end = words.size() - 1;
    String word = words.get(index);
    if (word.matches("_*")) {
      property.startingUnderscoreLength = word.length();
      ++index;
    } else {
      isFirstCharUpperCase = Character.isUpperCase(word.charAt(0));
    }
    word = words.get(end);
    if(word.matches("_*")) {
      property.endingUnderscoreLength = word.length();
    } else {
      end = words.size();
    }

    Map<Integer, Integer> underScoreCounts = new HashMap<>();
    for(; index < end; ++index) {
      word = words.get(index);
      if (word.isEmpty()) {
        continue;
      }
      if(word.contains("_")) {
        underScoreCounts.compute(word.length(), (k, v) -> v == null ? 1 : v + 1);
      } else if(!word.matches("[0-9]+")) {
        updatenameCase(getCaseInfo(word));
      }
    }
    if (!underScoreCounts.isEmpty()) {
      property.separatorUnderscoreLength = (Integer) getTheMostObj(underScoreCounts);
    }
  }


  @Override
  public int hashCode() {
    return Objects.hash(startingUnderscoreLength, endingUnderscoreLength, nameCase,
        isFirstCharUpperCase,separatorUnderscoreLength
        );
  }

  @Override
  public boolean equals(Object obj) {
    WrittenProperty writtenProperty = (WrittenProperty) obj;
    return startingUnderscoreLength == writtenProperty.startingUnderscoreLength &&
        endingUnderscoreLength == writtenProperty.endingUnderscoreLength &&
        separatorUnderscoreLength == writtenProperty.separatorUnderscoreLength &&
        nameCase == writtenProperty.nameCase &&
        isFirstCharUpperCase == writtenProperty.isFirstCharUpperCase;
  }


  @Override
  public String toString() {
    List<String> attrs = new ArrayList<>();
    return attrs.toString();
  }

  private static Object getTheMostObj(Map<? extends Object, Integer> map) {
    int maxCount = 0;
    Object targetObj = null;
    for(Map.Entry<? extends Object, Integer> entry : map.entrySet()) {
      if(entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        targetObj = entry.getKey();
      }
    }
    return targetObj;
  }

  private int getCaseInfo(String letters) {
    int state = 0;
    char letter = letters.charAt(0);
    state = Character.isUpperCase(letter) ? UPPER_CASE : LOWER_CASE;
    for (int i = 1; i < letters.length(); i++) {
      letter = letters.charAt(i);
      if(state == UPPER_CASE && Character.isLowerCase(letter) ||
      state == LOWER_CASE && Character.isUpperCase(letter)) {
        return CAMEL_CASE;
      }
    }
    return state;
  }


  private void updatenameCase(int caseInfo) {
    if(nameCase == 0) {
      nameCase = caseInfo;
    } else if(nameCase != caseInfo) {
      nameCase = CAMEL_CASE;
    }
  }
}
