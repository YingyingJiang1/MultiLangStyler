package org.example.style.name;

import java.util.Objects;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/11 13:54
 */
public class SemanticContext {
  private SymbolCategory category;
  private DataType dataType;

  public SemanticContext(SymbolCategory symbolCategory, DataType dataType) {
    this.category = symbolCategory;
    this.dataType = dataType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, dataType);
  }

  @Override
  public boolean equals(Object obj) {
    SemanticContext semanticContext = (SemanticContext) obj;
    return category == semanticContext.category && dataType == semanticContext.dataType;
  }
}
