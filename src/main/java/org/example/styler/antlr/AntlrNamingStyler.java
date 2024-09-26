package org.example.styler.antlr;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.JavaParser;
import org.example.parser.ExtendContext;
import org.example.style.name.SymbolItem;
import org.example.style.Modifier;
import org.example.style.ProgramStyle;
import org.example.style.name.DataType;
import org.example.style.name.NamingStyle;
import org.example.style.name.SymbolCategory;

import java.util.*;

/*
 * @description
 * Relevant contexts: TypeDeclarationContext, MethodDeclarationContext,EnumConstantsContext,
 * FormalParametersContext, LambdaParametersContext, CatchClauseContext, LocalVariableDeclarationContext,
 * FieldDeclarationContext.
 * @author       Yingying Jiang
 * @symbols = create       2024/3/11 16:58
 */
public class AntlrNamingStyler extends AntlrConcreteStylerBase {
  private static AntlrNamingStyler instance = new AntlrNamingStyler();
  private static Set<Integer> relevantRules = new HashSet<>(Arrays.asList(
      JavaParser.RULE_typeDeclaration,JavaParser.RULE_methodDeclaration,
      JavaParser.RULE_enumConstants,JavaParser.RULE_formalParameters,
      JavaParser.RULE_lambdaParameters,JavaParser.RULE_localVariableDeclaration,
      JavaParser.RULE_fieldDeclaration
  ));


  public AntlrNamingStyler() {}
  public static AntlrNamingStyler getInstance() {
    return instance;
  }

  @Override
  public void extractStyle(ExtendContext ctx, ProgramStyle programStyle) {
    List<SymbolItem> symbols = null;
    int ruleIndex = ctx.getRuleIndex();
	  symbols = switch (ruleIndex) {
		  case JavaParser.RULE_typeDeclaration -> createTypeSymbol(ctx);
		  case JavaParser.RULE_methodDeclaration -> createMethodSymbol(ctx);
		  case JavaParser.RULE_enumConstants -> createEnumConsSymbol(ctx);
		  case JavaParser.RULE_formalParameters, JavaParser.RULE_lambdaParameters -> createParaSymbol(ctx);
		  case JavaParser.RULE_localVariableDeclaration, JavaParser.RULE_fieldDeclaration -> createVarSymbol(ctx);
		  default -> null;
	  };
    if (symbols != null) {
      NamingStyle namingStyle = (NamingStyle) programStyle.getStyle(ProgramStyle.NAMING);
      namingStyle.addRule(symbols);
    }
  }

  public void printDefinedSymbols(List<SymbolItem> symbols) {
    System.out.println("total nubmer:" + symbols.size());
    for (SymbolItem item : symbols) {
      System.out.println("---------------------------------------------------------------------");
      System.out.println("category: " + item.symbolCategory.name());
      System.out.println("full name: " + item.name);
      System.out.println("data type: " + item.dataTypeName);
      System.out.println("---------------------------------------------------------------------");
    }
  }

  @Override
  protected Set<Integer> getRelevantRules() {
    return relevantRules;
  }

  /**
   *
   * @param ctx EnumConstantsContext
   * @return
   */
  private List<SymbolItem> createEnumConsSymbol(ExtendContext ctx) {
    List<SymbolItem> symbols = new ArrayList<>();
    SymbolCategory symbolCategory = SymbolCategory.ENUM_CONT;
    for (ParseTree child : ctx.children) {
      if (child instanceof JavaParser.IdentifierContext) {
        Token token = ((JavaParser.IdentifierContext) child).getStart();
        SymbolItem item = createSymbol(symbolCategory, null, token.getText(), null);
        symbols.add(item);
      }
    }
    return symbols;
  }

  /**
   *
   * @param ctx MethodDeclarationContext
   * @return
   */
  private List<SymbolItem> createMethodSymbol(ExtendContext ctx) {
    List<SymbolItem> symbols = new ArrayList<>();
    SymbolCategory symbolCategory;
    ExtendContext headContext;
    if (ctx instanceof JavaParser.MethodDeclarationContext) {
      symbolCategory = SymbolCategory.METHOD;
      headContext = ctx.getFirstInnerChildByType(JavaParser.RULE_methodHead);
    } else {
      symbolCategory = SymbolCategory.CONSTRUCTOR;
      headContext = ctx.getFirstInnerChildByType(JavaParser.RULE_constructorHead);
    }
    String name = headContext.getFirstInnerChildByType(JavaParser.RULE_identifier).getText();
    SymbolItem innerItem = createSymbol(symbolCategory, null, name, headContext.getFirstInnerChildByType(JavaParser.RULE_modifierList));
    symbols.add(innerItem);
    return symbols;
  }

  /**
   *
   * @param ctx FormalParametersContext, LambdaParametersContext, CatchClauseContext.
   * @return
   */
  private List<SymbolItem> createParaSymbol(ExtendContext ctx) {
    List<SymbolItem> symbols = new ArrayList<>();
    SymbolCategory symbolCategory = null;
    if (ctx instanceof JavaParser.CatchClauseContext) {
      symbolCategory = SymbolCategory.CATCH_PARA;
    } else {
      ExtendContext parent = (ExtendContext) ctx.getParent();
      int ruleIndex = parent.getRuleIndex();
      switch (ruleIndex) {
        case JavaParser.RULE_methodHead:
          symbolCategory = SymbolCategory.PARAMETER;
          break;
        case JavaParser.RULE_constructorHead:
          symbolCategory = SymbolCategory.CONSTRUCTOR_PARA;
          break;
        case JavaParser.RULE_lambdaExpression:
          symbolCategory = SymbolCategory.LAMBDA_PARA;
          break;
        default:
          System.err.println("Wrong parent context type in SymbolTable.addParaSymbol!");

      }
    }

    ExtendContext modifierList = ctx.getFirstInnerChildByType(JavaParser.RULE_modifierList);
    ExtendContext dataType = ctx.getFirstInnerChildByType(JavaParser.RULE_typeType);
    if (symbolCategory == SymbolCategory.CATCH_PARA) {
      dataType = ctx.getFirstInnerChildByType(JavaParser.RULE_catchType);
    }
    for(ParseTree child : ctx.children) {
      if(child instanceof JavaParser.IdentifierContext) {
        Token token = ((JavaParser.IdentifierContext) child).getStart();
        SymbolItem item = createSymbol(symbolCategory, dataType, token.getText(), modifierList);
        symbols.add(item);
      }
    }

    return symbols;
  }

  /**
   *
   * @param ctx TypeDeclarationContext.
   * @return
   */
  private List<SymbolItem> createTypeSymbol(ExtendContext ctx) {
    List<SymbolItem> symbols = new ArrayList<>();
    ExtendContext modifierList = (ExtendContext) ctx.getChild(0);
    ExtendContext headContext = (ExtendContext) ctx.getChild(1);
    Token defToken = headContext.getFirstInnerChildByType(JavaParser.RULE_identifier).getStart();
    SymbolCategory symbolCategory = null;
    int ruleIndex = headContext.getRuleIndex();
    switch (ruleIndex) {
      case JavaParser.RULE_classHead:
        symbolCategory = SymbolCategory.CLASS;
        break;
      case JavaParser.RULE_interfaceHead:
        symbolCategory = SymbolCategory.INTERFACE;
        break;
      case JavaParser.RULE_enumHead:
        symbolCategory = SymbolCategory.ENUM;
        break;
      case JavaParser.RULE_recordHead:
        symbolCategory = SymbolCategory.RECORD;
        break;
    }
    SymbolItem item = createSymbol(symbolCategory, null, defToken.getText(), modifierList);
    symbols.add(item);
    return symbols;
  }

  /**
   * @param ctx LocalVariableDeclarationContext， FieldDeclarationContext.
   */
  private List<SymbolItem> createVarSymbol(ExtendContext ctx) {
    List<SymbolItem> symbols = new ArrayList<>();
    SymbolCategory symbolCategory = null;
    ExtendContext parent = (ExtendContext) ctx.getParent();
    if (parent instanceof JavaParser.LocalVariableDeclarationStmtContext) {
      symbolCategory = SymbolCategory.LOCAL_VARIABLE;
    } else if (ctx instanceof JavaParser.FieldDeclarationContext) {
      symbolCategory = SymbolCategory.FIELD;
    } else if (parent instanceof JavaParser.ForInitContext) {
      symbolCategory = SymbolCategory.FOR_VARIABLE;
    } else {
      System.err.println("Wrong parent context type in SymbolTable.addLocalVar!");
    }

    ExtendContext modifierList = null, dataType = null;
    for(ParseTree child : ctx.children) {
      if(child instanceof JavaParser.ModifierListContext) {
        modifierList = (ExtendContext) child;
      } else if (child instanceof JavaParser.TypeTypeContext) {
        dataType = (ExtendContext) child;
      } else if (child instanceof JavaParser.IdentifierContext) {
        Token token = ((ExtendContext) child).getStart();
        SymbolItem item = createSymbol(symbolCategory, dataType, token.getText(), modifierList);
        symbols.add(item);
      }
    }
    return symbols;
  }

  private SymbolItem createSymbol(SymbolCategory symbolCategory, ExtendContext dateType, String name, ExtendContext modifierListCtx) {
    SymbolItem item = null;
    item = new SymbolItem(symbolCategory, name);
    setDataType(dateType, item);
    item.setAttr(modifierListCtx);
    if (item.accessControl == null) {
      item.accessControl = Modifier.PACKAGE;
    }
    return item;
  }

  private void setDataType(ExtendContext ctx, SymbolItem item) {
    if (ctx == null) {
      return;
    }
    if (ctx instanceof JavaParser.CatchTypeContext) {
      item.dataType = DataType.REFERENCE;
      item.dataTypeName = "";
      return;
    }

    ExtendContext typeCtx = ctx.getFirstInnerChildByType(JavaParser.RULE_primitiveType);
    if (typeCtx != null) {
      item.dataType = DataType.PRIMITIVE;
      item.dataTypeName = typeCtx.getText();
    } else {
      item.dataType = DataType.REFERENCE;
      typeCtx = ctx.getFirstInnerChildByType(JavaParser.RULE_classOrInterfaceType)
          .getFirstInnerChildByType(JavaParser.RULE_typeIdentifier);
      item.dataTypeName = typeCtx.getText();
    }
  }
}
