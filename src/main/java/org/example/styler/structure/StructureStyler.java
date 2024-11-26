package org.example.styler.structure;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.ExtendTokenFactory;
import org.example.parser.common.ParseTreeFactory;
import org.example.parser.java.antlr.JavaParser;
import org.example.myException.StylizationException;
import org.example.style.CommonStyle;
import org.example.style.rule.StyleContext;
import org.example.styler.Styler;
import org.example.styler.brace.style.OptionalBraceProperty;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;
import org.example.styler.structure.style.StructPreferenceCommonStyle;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/2 23:51
 */
public class StructureStyler extends Styler {
    private Map<Integer, List<EquivalentStructure>> equivalences;
    public static Map<Integer, Integer> triggerMap = new HashMap<>();
    private Map<EquivalentStructure, Set<Integer>> convertionPerformed = new HashMap<>();
    private int recursiveDepth = 0;

    private static Set<Integer> relevantRules = null;


    public StructureStyler() {
        equivalences = EquivalentStructureManager.getInstance().loadEquivalences(parser);
    }

    public ExtendContext applyStyle(ExtendContext ctx, CommonStyle commonStyle) {
        applySingleBlockStyle(ctx, commonStyle);
        ++recursiveDepth;
        ParseTree newTree = ctx;
        try {
            StructPreferenceCommonStyle structPreferenceStyle = (StructPreferenceCommonStyle) commonStyle;
            List<EquivalentStructure> equivalentStructures = equivalences.get(ctx.getRuleIndex());
            if (equivalentStructures != null) {
        /*if (ctx instanceof JavaParser.LocalVariableDeclarationStmtContext) {
          System.out.println("--------------------waiting to match---------------------");
          System.out.println(ctx.getText());
          System.out.println(ctx.toStringTree(new JavaParser(null)));
        }*/
                Set<MatchedStructure> matchedStructures = new TreeSet<>();
                for (EquivalentStructure structure : equivalentStructures) {
                    int matchedIndex = structure.match(ctx, parser);
                    StyleContext context = new StructPreferenceContext(structure.getName(), structure.getId());
                    StructPreferenceProperty property = (StructPreferenceProperty) structPreferenceStyle.getProperty(context);
                    int targetIndex = property == null ? -1 : property.preferenceIndex;
                    if (matchedIndex != -1 && targetIndex != -1 && targetIndex != matchedIndex) {
                        matchedStructures.add(new MatchedStructure(structure, matchedIndex));
                    }
                }

                if (!matchedStructures.isEmpty()) {
                    Iterator<MatchedStructure> it = matchedStructures.iterator();
                    boolean converted = false;
                    while (it.hasNext()) {
                        MatchedStructure matchedStructure = it.next();
                        EquivalentStructure targetStructure = matchedStructure.structure;
                        StyleContext context = new StructPreferenceContext(matchedStructure.structure.getName(), matchedStructure.structure.getId());
                        StructPreferenceProperty property = (StructPreferenceProperty) structPreferenceStyle.getProperty(context);
                        int to = property.preferenceIndex;
                        int from = matchedStructure.index;
                        // Check whether the conversion is performed before.
                        if (convertionPerformed.get(targetStructure) != null &&
                                convertionPerformed.get(targetStructure).contains(to)) {
                            break;
                        }
                        newTree = targetStructure.convert(from, to, ctx, parser);
                        // If converting operation is performed successfully then record the conversion and call recursively.
                        if (newTree instanceof ExtendContext newCtx) {
                            convertionPerformed.computeIfAbsent(targetStructure, v -> new HashSet<>());
                            convertionPerformed.get(targetStructure).add(to);
//              ++triggerCount;
                            triggerMap.compute(targetStructure.getId(), (k, v) -> v == null ? 1 : v + 1);
                            applyStyle(newCtx, commonStyle);
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
        if (recursiveDepth == 0) {
            convertionPerformed.clear();
        }
        return (ExtendContext) newTree;
    }

    /**
     * Try to add or remove {}
     *
     * @param ctx
     * @param commonStyle
     */
    private void applySingleBlockStyle(ExtendContext ctx, CommonStyle commonStyle) {
        if (!parser.belongToBraceOptionalStmt(ctx.getRuleIndex())) {
            return;
        }
        OptionalBraceProperty property = (OptionalBraceProperty) commonStyle.getProperty(null);
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (parser.isStatement(child) && child instanceof ExtendContext stmtCtx) {
                if (property.useBrace) {
                    // Add {}
                    if (stmtCtx.getRuleIndex() != parser.getRuleBlock()) {
                        ExtendContext block = new JavaParser.BlockContext(ctx, stmtCtx.invokingState);
                        TerminalNode lb = ParseTreeFactory.createTerminalNode(ExtendTokenFactory.DEFAULT.create(parser.getLBrace(), "{"));
                        TerminalNode rb = ParseTreeFactory.createTerminalNode(ExtendTokenFactory.DEFAULT.create(parser.getRBrace(), "}"));
                        List<ParseTree> children = new ArrayList<>();
                        children.add(lb);
                        children.add(stmtCtx);
                        children.add(rb);
                        block.addChildren(children);
                        ctx.replaceChild(stmtCtx, block);
                    }
                } else if (stmtCtx.getRuleIndex() == JavaParser.RULE_block &&
                        stmtCtx.countChildIf(parser::isStatement) == 1) {
                    ExtendContext innerStmtCtx = stmtCtx.getFirstCtxChildIf(parser::isStatement);
                    // Skip empty statement(;).
                    if (innerStmtCtx != null) {
                        if (parser.belongToSingleStmt(innerStmtCtx)) {
                            // Remove {}
                            ctx.replaceChild(stmtCtx, innerStmtCtx);
                        }
                    }
                }
            }
        }
    }

    public void extractStyle(ExtendContext ctx, CommonStyle commonStyle) {
        StructPreferenceCommonStyle structPreferenceStyle = (StructPreferenceCommonStyle) commonStyle;
        List<EquivalentStructure> equivalentStructures = equivalences.get(ctx.getRuleIndex());
        if (equivalentStructures != null) {
      /*if(ctx instanceof JavaParser.ForStmtContext) {
        System.out.println("--------------------waiting to match---------------------");
        System.out.println(ctx.getText());
        System.out.println(ctx.toStringTree(new JavaParser(null)));
      }*/
            for (EquivalentStructure structure : equivalentStructures) {
                int index = structure.match(ctx, parser);
                if (index != -1) {
                    structPreferenceStyle.addRule(
                            new StructPreferenceContext(structure.getName(), structure.getId()),
                            new StructPreferenceProperty(index));
                    // break; // Can't break,because ctx may match multiple structures with different id.
                }
            }
        }
    }

    @Override
    protected Set<Integer> getRelevantRules() {
        if (relevantRules == null) {
            relevantRules = parser.getAllStmts();
        }
        return relevantRules;
    }

    static class MatchedStructure implements Comparable<MatchedStructure> {

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
