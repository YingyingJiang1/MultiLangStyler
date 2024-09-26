package org.example.style.name;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.antlr.JavaParser;
import org.example.parser.ExtendContext;
import org.example.style.Modifier;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/4 11:43
 */
public class SymbolItem {
  public SymbolCategory symbolCategory;
  public String name;
  public DataType dataType;
  public String dataTypeName;
  public Modifier accessControl;
  public int attr; // 1:final, 0:static
  public Object identifierNode;
  private static final int INIT_CAPACITY = 4;

  public SymbolItem(String name) {
    this.name = name;
  }

  public SymbolItem(SymbolCategory symbolCategory, String name) {
    this.symbolCategory = symbolCategory;
    this.name = name;
  }

  public SymbolItem(SymbolCategory symbolCategory) {
    this.symbolCategory = symbolCategory;
  }

  public SymbolItem() {
  }

  public void print() {
    System.out.println("symbol category:" + symbolCategory.name());
    System.out.println("name:" + name);
    System.out.println("data type:" + dataType);
    System.out.println("data type name:" + dataTypeName);
    System.out.println("access control:" + accessControl.name());
    System.out.println("attr:" + attr);

  }


  /**
   * @param ctx ModifierListContext
   */
  public void setAttr(ExtendContext ctx) {
    if (ctx == null) {
      return;
    }
    for (ParseTree modifierNode : ctx.children) {
      if (modifierNode instanceof TerminalNode) {
        int tokenIndex = ((TerminalNode) modifierNode).getSymbol().getTokenIndex();
        switch (tokenIndex) {
          case JavaParser.PUBLIC:
            accessControl = Modifier.PUBLIC;
            break;
          case JavaParser.PRIVATE:
            accessControl = Modifier.PRIVATE;
            break;
          case JavaParser.PROTECTED:
            accessControl = Modifier.PROTECTED;
            break;
          case JavaParser.FINAL:
            attr |= 2;
            break;
          case JavaParser.STATIC:
            attr |= 1;
            break;
        }
      }
    }
  }

  public void setAttr(String[] modifiers) {
    for(String modifier : modifiers) {
      switch (modifier) {
        case "public":
          accessControl = Modifier.PUBLIC;
          break;
        case "private":
          accessControl = Modifier.PRIVATE;
          break;
        case "protected":
          accessControl = Modifier.PROTECTED;
          break;
        case "final":
          attr |= 2;
          break;
        case "static":
          attr |= 1;
          break;
      }
    }
    if (accessControl == null) {
      accessControl = Modifier.PACKAGE;
    }
  }

}
