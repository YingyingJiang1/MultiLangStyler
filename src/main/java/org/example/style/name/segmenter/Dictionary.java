package org.example.style.name.segmenter;

import com.hankcs.algorithm.AhoCorasickDoubleArrayTrie;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/11 2:30
 */
public class Dictionary {
  private AhoCorasickDoubleArrayTrie<String> dictionary = new AhoCorasickDoubleArrayTrie<>();

  private Dictionary() {}

  private static final class InstanceHolder {
    static final Dictionary instance = new Dictionary();
  }

  public static Dictionary getInstance() {
    return InstanceHolder.instance;
  }
}
