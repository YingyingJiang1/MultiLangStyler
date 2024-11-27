package org.example.styler.structure;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.ExtendContext;
import org.example.parser.common.factory.ExtendTokenFactory;
import org.example.parser.common.ParseTreeFactory;
import org.example.parser.java.antlr.JavaParser;
import org.example.myException.StylizationException;
import org.example.style.Style;
import org.example.style.rule.StyleContext;
import org.example.styler.Styler;
import org.example.styler.body.optionalbrace.style.OptionalBraceProperty;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;

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
        style.setStyleName("equivalences");
    }

    public ExtendContext applyStyle(ExtendContext ctx, Style style) {
        ++recursiveDepth;
        ParseTree newTree = ctx;
        try {
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
                    StyleContext context = new StructPreferenceContext(structure.getCategory(), structure.getId());
                    StructPreferenceProperty property = (StructPreferenceProperty) style.getProperty(context);
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
                        StyleContext context = new StructPreferenceContext(matchedStructure.structure.getCategory(), matchedStructure.structure.getId());
                        StructPreferenceProperty property = (StructPreferenceProperty) style.getProperty(context);
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
        if (recursiveDepth == 0) {
            convertionPerformed.clear();
        }
        return (ExtendContext) newTree;
    }

    public void extractStyle(ExtendContext ctx, Style style) {
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
                    style.addRule(
                            new StructPreferenceContext(structure.getCategory(), structure.getId()),
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
