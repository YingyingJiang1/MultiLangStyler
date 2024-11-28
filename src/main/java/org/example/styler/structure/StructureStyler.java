package org.example.styler.structure;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.debug.TreePrinter;
import org.example.parser.common.ExtendContext;
import org.example.parser.java.MyJavaParser;
import org.example.myException.StylizationException;
import org.example.parser.java.antlr.JavaParser;
import org.example.style.Style;
import org.example.style.rule.StyleContext;
import org.example.styler.Styler;
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
    private Map<EquivalentStructure, Set<Integer>> convertionPerformed = new HashMap<>();
    private int recursiveDepth = 0;

    private static Set<Integer> relevantRules = null;


    public StructureStyler() {
        style.setStyleName("equivalences");
        equivalences = EquivalentStructureManager.getInstance().loadEquivalences(new MyJavaParser(""));
    }

    public ExtendContext applyStyle(ExtendContext ctx, Style style) {
        ++recursiveDepth;
        ParseTree newTree = ctx;
        try {
            List<EquivalentStructure> equivalentStructures = equivalences.get(ctx.getRuleIndex());
            if (equivalentStructures != null) {
        /*if (ctx.getRuleIndex() == parser.getRuleIfElseStmt()) {
          System.out.println("--------------------waiting to match---------------------");
          System.out.println(ctx.getText());
            TreePrinter.printTree(ctx, parser);
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
            if (ctx.getRuleIndex() == parser.getRuleIfElseStmt()) {
                System.out.println("--------------------waiting to match---------------------");
                System.out.println(ctx.getText());
                TreePrinter.printTree(ctx, parser);
            }
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
