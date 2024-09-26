package org.example.style.name;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.style.Modifier;

import java.util.Objects;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/2/28 21:28
 */
public class WrittenContext {

  private SymbolCategory category;
  private Modifier accessControl;
  private int attr;

  public WrittenContext() {}

  public WrittenContext(SymbolItem symbol) {
    if(symbol != null) {
      category = symbol.symbolCategory;
      accessControl = symbol.accessControl;
      attr = symbol.attr;
    }
  }

  public int calculateDistance(WrittenContext context) {
    int distance = category == context.category ? 0 : 10;
    distance += accessControl == context.accessControl ? 0 : 1;
    int diff = attr ^ context.attr;
    while(diff > 0) {
      if ((diff & 1) == 1) {
        ++distance;
      }
      diff >>= 1;
    }
    return distance;
  }

  public void addElement(Element parent, Parser parser) {
    Element context = parent.addElement("context");
    if (category != null) {
      context.addAttribute("category", category.name());
    }
    if(SymbolCategory.isMember(category)) {
      context.addAttribute("accessControl", accessControl.name());
    } else {
      context.addAttribute("accessControl", "");
    }
    context.addAttribute("attr", Integer.toString(attr));
  }

  public static WrittenContext parseElement(Element parent, Parser parser) {
    Element contextEle = parent.element("context");
    WrittenContext writtenContext = new WrittenContext();
    writtenContext.category = SymbolCategory.valueOf(contextEle.attributeValue("category"));
    if (contextEle.attributeValue("accessControl").isEmpty()) {
      writtenContext.accessControl = Modifier.PACKAGE;
    } else {
      writtenContext.accessControl = Modifier.valueOf(contextEle.attributeValue("accessControl"));
    }
    writtenContext.attr = Integer.parseInt(contextEle.attributeValue("attr"));
    return writtenContext;
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, accessControl, attr);
  }

  @Override
  public boolean equals(Object obj) {
    WrittenContext writtenContext = (WrittenContext) obj;
    return category == writtenContext.category && accessControl == writtenContext.accessControl && attr == writtenContext.attr;
  }

  public enum Category {
    INTERFACE, CLASS, RECORD, ENUM, ANNOTATION, METHOD,
    FIELD, LOCAL_VARIABLE, FOR_VARIABLE, CATCH_PARA, ENUM_CONT, PARA,
  }
}