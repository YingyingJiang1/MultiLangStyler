package org.example.styler.structure;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.antlr.JavaParser;
import org.example.interfaces.StyleProperty;
import org.example.parser.AntlrHelper;
import org.example.parser.ExtendContext;
import org.example.myException.StylizationException;
import org.example.parser.ExtendTokenFactory;
import org.example.parser.ParseTreeFactory;
import org.example.interfaces.Style;
import org.example.style.format.FormatStyle;
import org.example.styler.StylerBase;
import org.example.styler.brace.style.OptionalBraceProperty;
import org.example.styler.structure.style.EquivalencesStyle;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/2 23:51
 */
public class StructureStyler extends StylerBase {
  private Map<Integer, List<EquivalentStructure>> equivalences;
  public static Map<Integer, Integer> triggerMap = new HashMap<>();
  private Map<EquivalentStructure, Set<Integer>> convertionPerformed = new HashMap<>();
  private int recursiveDepth = 0;

  private static Set<Integer> relevantRules = new HashSet<>(Arrays.asList(
      JavaParser.RULE_block,JavaParser.RULE_initializer,
      JavaParser.RULE_localVariableDeclarationStmt,JavaParser.RULE_ifStmt,
      JavaParser.RULE_ifElseStmt, JavaParser.RULE_forStmt,JavaParser.RULE_whileStmt,
      JavaParser.RULE_doWhileStmt, JavaParser.RULE_tryCatchStmt,JavaParser.RULE_tryResourceStmt,
      JavaParser.RULE_switchStmt, JavaParser.RULE_syncStmt, JavaParser.RULE_returnStmt,
      JavaParser.RULE_yieldStmt,JavaParser.RULE_expressionStmt, JavaParser.RULE_expression
  ));


  public StructureStyler() {
    equivalences = EquivalentStructureManager.getInstance().loadEquivalences();
  }

  public ExtendContext applyStyle(ExtendContext ctx, Style style) {
    applySingleBlockStyle(ctx, style);
    ++recursiveDepth;
    ParseTree newTree = ctx;
    try {
      EquivalencesStyle equivalencesStyle = (EquivalencesStyle) style;
      List<EquivalentStructure> equivalentStructures = equivalences.get(ctx.getRuleIndex());
      if (equivalentStructures != null) {
        /*if (ctx instanceof JavaParser.LocalVariableDeclarationStmtContext) {
          System.out.println("--------------------waiting to match---------------------");
          System.out.println(ctx.getText());
          System.out.println(ctx.toStringTree(new JavaParser(null)));
        }*/
        Set<MatchedStructure> matchedStructures = new TreeSet<>();
        for(EquivalentStructure structure : equivalentStructures) {
          int matchedIndex = structure.match(ctx);
          int targetIndex = equivalencesStyle.getProperty(structure.getId());
          if(matchedIndex != -1 && targetIndex != -1 && targetIndex != matchedIndex) {
            matchedStructures.add(new MatchedStructure(structure, matchedIndex));
          }
        }

        if(!matchedStructures.isEmpty()){
          Iterator<MatchedStructure> it = matchedStructures.iterator();
          boolean converted = false;
          while(it.hasNext()) {
            MatchedStructure matchedStructure = it.next();
            EquivalentStructure targetStructure = matchedStructure.structure;
            int to = equivalencesStyle.getProperty(matchedStructure.structure.getId());
            int from = matchedStructure.index;
            // Check whether the conversion is performed before.
            if(convertionPerformed.get(targetStructure) != null &&
                convertionPerformed.get(targetStructure).contains(to)) {
              break;
            }
            newTree = targetStructure.convert(from, to, ctx);
            // If converting operation is performed successfully then record the conversion and call recursively.
            if(newTree instanceof ExtendContext newCtx) {
              convertionPerformed.computeIfAbsent(targetStructure, v -> new HashSet<>());
              convertionPerformed.get(targetStructure).add(to);
              ++triggerCount;
              triggerMap.compute(targetStructure.getId(), (k, v) -> v == null ? 1 : v + 1);
              applyStyle(newCtx, style);
              break;
            }
          }
        }
      }
    } catch (RuntimeException e) {
      e.printStackTrace();
      throw new StylizationException("apply equivalences style failed:" + e.getMessage());
    }
    --recursiveDepth;
    if(recursiveDepth == 0) {
      convertionPerformed.clear();
    }
    return (ExtendContext) newTree;
  }

  /**
   * Try to add or remove {}
   * @param ctx
   * @param style
   */
  private void applySingleBlockStyle(ExtendContext ctx, Style style) {
    if(!AntlrHelper.isBraceOptionalBlocks(ctx.getRuleIndex())) {
      return;
    }
    OptionalBraceProperty property = (OptionalBraceProperty) style.getProperty(null);
    for (int i = 0; i < ctx.getChildCount(); i++) {
      ParseTree child = ctx.getChild(i);
      if(AntlrHelper.isStmt(child) && child instanceof ExtendContext stmtCtx) {
        if (property.useBrace) {
          // Add {}
          if(stmtCtx.getRuleIndex() != JavaParser.RULE_block) {
            ExtendContext block = new JavaParser.BlockContext(ctx, stmtCtx.invokingState);
            TerminalNode lb = ParseTreeFactory.createTerminalNode(ExtendTokenFactory.DEFAULT.create(JavaParser.LBRACE, "{"));
            TerminalNode rb = ParseTreeFactory.createTerminalNode(ExtendTokenFactory.DEFAULT.create(JavaParser.RBRACE, "}"));
            List<ParseTree> children = new ArrayList<>();
            children.add(lb);
            children.add(stmtCtx);
            children.add(rb);
            block.addChildren(children);
            ctx.replaceChild(stmtCtx, block);
          }
        } else if(stmtCtx.getRuleIndex() == JavaParser.RULE_block &&
            stmtCtx.countChildIf(AntlrHelper::isStmt) == 1) {
          ExtendContext innerStmtCtx = stmtCtx.getFirstCtxChildIf(AntlrHelper::isStmt);
          // Skip empty statement(;).
          if (innerStmtCtx != null) {
            int innerStmtRule = innerStmtCtx.getRuleIndex();
            if(AntlrHelper.isSingleStmt(innerStmtRule)) {
              // Remove {}
              ctx.replaceChild(stmtCtx, innerStmtCtx);
            }
          }
        }
      }
    }
  }

  public void extractStyle(ExtendContext ctx, Style style) {
    EquivalencesStyle equivalencesStyle = (EquivalencesStyle) style;
    List<EquivalentStructure> equivalentStructures = equivalences.get(ctx.getRuleIndex());
    if (equivalentStructures != null) {
      /*if(ctx instanceof JavaParser.ForStmtContext) {
        System.out.println("--------------------waiting to match---------------------");
        System.out.println(ctx.getText());
        System.out.println(ctx.toStringTree(new JavaParser(null)));
      }*/
      for(EquivalentStructure structure : equivalentStructures) {
        int index = structure.match(ctx);
        if(index != -1) {
          equivalencesStyle.addRule(structure.getId(), index);
          // break; // Can't break,because ctx may match multiple structures with different id.
        }
      }
    }
  }

  @Override
  protected Set<Integer> getRelevantRules() {
    return relevantRules;
  }

  static class MatchedStructure implements Comparable<MatchedStructure>{

    EquivalentStructure structure;
    int index;
    int priority;

    public MatchedStructure(EquivalentStructure structure, int index) {
      this.structure = structure;
      this.index = index;
      priority = structure.getPriority(index);
    }

    @Override
    public int compareTo(MatchedStructure o) {
      return Integer.compare(o.priority, priority);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      MatchedStructure that = (MatchedStructure) o;
      return index == that.index && Objects.equals(structure, that.structure);
    }

    @Override
    public int hashCode() {
      return Objects.hash(structure, index);
    }
  }
}
