package org.example.style.name;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.Style;
import org.example.style.name.segmenter.Dictionary;
import org.example.style.name.segmenter.Segmenter;
import org.example.style.name.segmenter.SimpleSegmenter;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/28 19:16
 */
public class NamingStyle extends Style {

  private Map<WrittenContext, List<WrittenProperty>> writtenRules = new HashMap<>();
  private Map<SemanticContext, List<SemanticProperty>> semanticRules = new HashMap<>();
  private AbbreviationRule abbreviationRule = new AbbreviationRule();
  private Map<WrittenContext.Category, SpecialNaming.NameConverter> nameConverterMap = new HashMap<>();

  public NamingStyle() {
    styleName = "Naming";
  }

  public void addRule(List<SymbolItem> symbols) {
    for (SymbolItem symbol : symbols) {
      List<String> words = segmentName(symbol.name);

      WrittenContext writtenContext = new WrittenContext(symbol);
      WrittenProperty writtenProperty = new WrittenProperty();
      writtenProperty.fill(words);
      writtenRules.computeIfAbsent(writtenContext, k -> new ArrayList<>());
      List<WrittenProperty> properties = writtenRules.get(writtenContext);
      int index = properties.indexOf(writtenProperty);
      if (index >= 0) {
        ++properties.get(index).count;
      } else {
        properties.add(writtenProperty);
      }

      abbreviationRule.extractRule(words, symbol.name.length());
    }
  }

  public String getResult(SymbolItem symbolItem) {
    WrittenContext writtenContext = new WrittenContext(symbolItem);
    List<WrittenProperty> properties = writtenRules.get(writtenContext);
    if (properties != null) {
      WrittenProperty writtenProperty = properties.get(0);
      return writtenProperty.newWrittenName(segmentName(symbolItem.name));
    }
    return symbolItem.name;
  }

  @Override
  public void fill() {
    for(List<WrittenProperty> properties : writtenRules.values()) {
      if (properties.size() > 1) {
        properties.sort(Comparator.comparing(p -> p.count));
        WrittenProperty target = properties.get(properties.size() - 1);
        properties.clear();
        properties.add(target);
      }
    }
  }

  @Override
  public void addElement(Element root, Parser parser) {
    root.addComment(styleName);
    Element rules = root.addElement("naming");
    Element writtenRules = rules.addElement("written_rules");
    for(Map.Entry<WrittenContext, List<WrittenProperty>> entry : this.writtenRules.entrySet()) {
      Element rule = writtenRules.addElement("rule");
      entry.getKey().addElement(rule, parser);
      entry.getValue().get(0).addElement(rule, parser);
    }
  }

  @Override
  public Object parseElement(Element root, Parser parser) {
    Element rules = root.element("rules");
    Element writtenRulesEle = rules.element("written_rules");
    List<Element> ruleEleList = writtenRulesEle.elements();
    for(Element ruleEle : ruleEleList) {
      List<WrittenProperty> properties = new ArrayList<>();
      properties.add(WrittenProperty.parseElement(ruleEle, parser));
      writtenRules.put(WrittenContext.parseElement(ruleEle, parser), properties);
    }
    return this;
  }

  List<String> segmentName(String name) {
    Segmenter wordSegment = new SimpleSegmenter(Dictionary.getInstance());
    List<String> words = wordSegment.segment(name);
    for(int i = 1; i < words.size(); ++i) {
      String pre = words.get(i - 1), cur = words.get(i);
      char preLastChar = pre.charAt(pre.length() - 1), curFirstChar = cur.charAt(0);
      if(Character.isAlphabetic(preLastChar) &&
      Character.isAlphabetic(curFirstChar) && Character.isLowerCase(curFirstChar)) {
        words.set(i - 1, pre.substring(0, pre.length() - 1));
        words.set(i, preLastChar + cur);
      }
    }
    return words;
  }
}
