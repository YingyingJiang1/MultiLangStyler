package org.example.style.name;


import java.util.List;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/28 21:03
 */
public class SpecialNaming {
  public interface NameConverter {
    public String convert(List<String> orginalName, int originalNameLen, AbbreviationRule abbreviationRule);
  }

}
