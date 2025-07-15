package org.example.utils;

import java.util.*;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/9 17:25
 */
public class Helper {
  /*
   * @return int[]: An array of length of 2:[start, end].'start' is inclusive while 'end' is exclusive.
   * @author     : Jiang Yingying
   * @create     : 2024/1/9 15:15
   */
  public static <T> int[] binarySearch(List<? extends Comparable<? super T>> list, T target) {
    int index = Collections.binarySearch(list, target);
    int[] range = {index, index};
    if(index < 0)
      return range;

    int start = index - 1, end = index + 1;
    while(start >= 0 && list.get(start).equals(target))
      --start;
    while(end < list.size() && list.get(end).equals(target))
      ++end;
    ++start;
    range[0] = start;
    range[1] = end;
    return range;
  }

  public static class Pair<K extends Comparable<K>, V> implements Comparable<Pair<K, V>> {
    public final K first;
    public V second;

    public Pair(K first, V second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int compareTo(Pair<K, V> p) {
      return this.first.compareTo(p.first);
    }
  }
}
