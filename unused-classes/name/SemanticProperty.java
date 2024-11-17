package org.example.style.name;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/11 13:55
 */
public class SemanticProperty {
  private List<String> preferredNames = new ArrayList<>();

  private static Map<String, List<String>> typeStrMap;

  private Map<String, Integer> nameCounts = new HashMap<>();


  static {
    typeStrMap = new HashMap<>();
    typeStrMap.put("class", Arrays.asList("c", "cls", "class"));
    typeStrMap.put("interface", Arrays.asList("i", "intf", "interface"));
    typeStrMap.put("enum", Arrays.asList("e", "enum"));
    typeStrMap.put("record", Arrays.asList("r", "rec", "record"));
    typeStrMap.put("short", Arrays.asList("s", "short"));
    typeStrMap.put("int", Arrays.asList("i", "int"));
    typeStrMap.put("long", Arrays.asList("l", "long"));
    typeStrMap.put("float", Arrays.asList("f", "float"));
    typeStrMap.put("double", Arrays.asList("d", "double"));
    typeStrMap.put("char", Arrays.asList("c", "char"));
    typeStrMap.put("byte", Arrays.asList("b", "byte"));
    typeStrMap.put("boolean", Arrays.asList("b", "bool", "boolean"));
  }
}
