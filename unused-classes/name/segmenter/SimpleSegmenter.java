package org.example.style.name.segmenter;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/*
 * @description Words are distinguished by specific separators or written style(camel case).
 * @author       Yingying Jiang
 * @create       2024/3/11 2:28
 */
public class SimpleSegmenter implements Segmenter {
  public Dictionary dictionary;

  public SimpleSegmenter(Dictionary dictionary) {
    this.dictionary = dictionary;
  }

  /**
   *
   * @param name
   * @return
   */
  @Override
  public List<String> segment(String name) {
    String[] words = StringUtils.splitByCharacterTypeCamelCase(name);
    return Arrays.asList(words);
  }
}
