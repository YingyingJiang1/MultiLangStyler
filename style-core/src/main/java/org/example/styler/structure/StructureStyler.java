package org.example.styler.structure;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.MyEnvironment;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.MyParser;
import org.example.antlr.common.context.ExtendContext;
import org.example.style.InconsistencyInfo;
import org.example.style.rule.StyleContext;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.structure.style.*;
import org.example.styler.structure.vtree.Forest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/2 23:51
 */
public class StructureStyler extends Styler {
    public static boolean TEST_MODE = false;

    private Map<Integer, Set<EquivalentStructure>> equivalencesMap = null;
    private Map<EquivalentStructure, Set<Integer>> convertionPerformed = new HashMap<>();
    private int recursiveDepth = 0;

    public static Logger logger = LoggerFactory.getLogger(StructureStyler.class);

    static {


    }

    public StructureStyler() {
        style = new StructureStyle();
        // executeWhenExit is true
    }

    private void loadData(String lang) {
        List<EquivalentStructure> equivalences = EquivalentStructureManager.getInstance().loadEquivalences(MyEnvironment.getIConfig().getEquivalencesConfig(lang), lang); // TBD: extend for other languages
        // create map for efficiency, avoid to traverse all configured structures.
        equivalencesMap = new HashMap<>();
        MyParser parser = LangAdapterCreator.createParser(lang);
        for (EquivalentStructure equivalence : equivalences) {
            for (Forest forest : equivalence.getForests()) {
                ParseTree root = forest.getTree(0);
                if (parser.isStatement(root)) {
                    equivalencesMap.computeIfAbsent(parser.getSpecificStmtType((ExtendContext) root), v -> new HashSet<>()).add(equivalence);
                } else {
                    equivalencesMap.computeIfAbsent(((ExtendContext) root).getRuleIndex(), v -> new HashSet<>()).add(equivalence);

                }
            }
        }
    }


    /**
     * @param ctx
     * @param parser
     * @return the inconsistency info if found, otherwise null
     */
    @Override
    public @Nullable List<InconsistencyInfo> analyzeInconsistency(ExtendContext ctx, MyParser parser) {
        List<InconsistencyInfo> infos = null;

        int ruIndex = ctx.getRuleIndex();
        if (ctx.getRuleIndex() == parser.getRuleStmt()) {
            ruIndex = parser.getSpecificStmt(ctx).getRuleIndex();
        }
        Set<EquivalentStructure> equivalentStructures = equivalencesMap.get(ruIndex);
        if (equivalentStructures != null) {
            Set<MatchedStructure> matchedStructures = new TreeSet<>();
            for (EquivalentStructure structure : equivalentStructures) {
                int matchedIndex = structure.match(ctx, parser);
                StyleContext context = extractContext(structure);
                StructPreferenceProperty property = (StructPreferenceProperty) style.getProperty(context);
                int targetIndex = getTargetIndex(property, structure);
                if (matchedIndex != -1 && targetIndex != -1 && targetIndex != matchedIndex) {
                    // Create inconsistency info
                    int[] startLoc = { ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine() };
                    Token stopToken = ctx.getStop();
                    int off = structure.getForests().get(targetIndex).getTrees().size() - 1;
                    if (off > 0) {
                        ExtendContext parent = (ExtendContext) ctx.getParent();
                        ParseTree lastMatchedTreeRoot = parent.getChild(parent.children.indexOf(ctx) + off);
                        if (lastMatchedTreeRoot instanceof ExtendContext ctx1) {
                            stopToken = ctx1.getStop();
                        } else if (lastMatchedTreeRoot instanceof TerminalNode ter) {
                            stopToken = ter.getSymbol();
                        }
                    }
                    int[] endLoc = { stopToken.getLine(), stopToken.getCharPositionInLine() };

                    infos = new ArrayList<>();
                    infos.add(new StructureInconsistencyInfo(startLoc, endLoc, "Inconsistent syntax structure"));
                    break; // Meet first matched structure, break
                }
            }

        }

        return infos;
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        if (equivalencesMap == null) {
            loadData(parser.getLanguage());
        }

        int ruIndex = ctx.getRuleIndex();
        if (ctx.getRuleIndex() == parser.getRuleStmt()) {
            ruIndex = parser.getSpecificStmt(ctx).getRuleIndex();
        }
        ++recursiveDepth;
        ParseTree newTree = ctx;
        Set<EquivalentStructure> equivalentStructures = equivalencesMap.get(ruIndex);
        if (equivalentStructures != null) {
            // Get all matched structures
            Set<MatchedStructure> matchedStructures = new TreeSet<>();
            for (EquivalentStructure structure : equivalentStructures) {
                int matchedIndex = structure.match(ctx, parser);
                StyleContext context = extractContext(structure);
                StructPreferenceProperty property = (StructPreferenceProperty) style.getProperty(context);
                int targetIndex = getTargetIndex(property, structure);
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
                    StyleContext context = extractContext(matchedStructure.structure);
                    StructPreferenceProperty property = (StructPreferenceProperty) style.getProperty(context);
                    int to = getTargetIndex(property, targetStructure);
                    int from = matchedStructure.index;
                    // Check whether the conversion is performed before.
                    if (convertionPerformed.get(targetStructure) != null &&
                            convertionPerformed.get(targetStructure).contains(to)) {
                        break;
                    }
                    try {
                        newTree = targetStructure.convert(from, to, ctx, parser);
//                        RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
//                        RunStatistic.addTriggeredStructureID(parser.getSourceFile(), matchedStructure.structure.id);
                        break;
                    } catch (Exception e) {
                        logger.error("Note: Fail to convert from {} to {} when structure id = {}.", from, to, targetStructure.getId(), e);
                    }
                    // If converting operation is performed successfully then record the conversion and call recursively.
//                    if (newTree instanceof ExtendContext newCtx) {
//                        convertionPerformed.computeIfAbsent(targetStructure, v -> new HashSet<>());
//                        convertionPerformed.get(targetStructure).add(to);
//                        applyStyle(newCtx, parser);
//                        break;
//                    }
                }
            }
        }
        --recursiveDepth;
        if (recursiveDepth == 0) {
            convertionPerformed.clear();
        }
        return (ExtendContext) newTree;
    }


    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        if (equivalencesMap == null) {
            loadData(parser.getLanguage());
        }

        int ruleIndex = ctx.getRuleIndex();
        if (ctx.getRuleIndex() == parser.getRuleStmt()) {
            ruleIndex = parser.getSpecificStmt(ctx).getRuleIndex();
        }
        Set<EquivalentStructure> equivalentStructures = equivalencesMap.get(ruleIndex);
        if (equivalentStructures != null) {
//            if (ctx.getRuleIndex() == parser.getRuleIfElseStmt()) {
//                System.out.println("--------------------waiting to match---------------------");
//                System.out.println(ctx.getText());
//                TreePrinter.printTree(ctx, parser);
//            }
            for (EquivalentStructure structure : equivalentStructures) {
                int index = structure.match(ctx, parser);
                if (index != -1) {
                    style.addRule(
                            extractContext(structure),
                            extractProperty(structure, index));
                    // break; // Can't break,because ctx may match multiple structures with different id.
                }
            }
        }
    }



    private StructPreferenceProperty extractProperty(EquivalentStructure structure, int targetIndex) {
        return new StructPreferenceProperty(targetIndex, structure.getStyleOf(targetIndex));
    }

    private StructPreferenceContext extractContext(EquivalentStructure structure) {
        StyleCategory category = null;
        try {
            category = StyleCategory.valueOf(structure.getCategory());
        } catch (Exception e) {

        }
        return new StructPreferenceContext(category, structure.getId());
    }

    private int getTargetIndex(StructPreferenceProperty property, EquivalentStructure structure) {
        if (property == null) {
            return -1;
        }

        int targetIndex = structure.getIndexOf(property.getStyle());
        if (targetIndex == -1) {
            targetIndex = property.getPreferenceIndex();
        }
        return targetIndex;
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleStmt() || ctx.getRuleIndex() == parser.getRuleExpression();
    }


    public static class MatchedStructure implements Comparable<MatchedStructure> {

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
