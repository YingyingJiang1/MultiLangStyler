package org.example.styler.structure;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.RunStatistic;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.factory.MyParserFactory;
import org.example.parser.java.MyJavaParser;
import org.example.parser.java.Spot;
import org.example.style.InconsistencyInfo;
import org.example.style.rule.StyleContext;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.structure.style.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/2 23:51
 */
public class StructureStyler extends Styler {
    public static boolean TEST_MODE = false;

    private static final String CONF_FILE = "/equivalences.xml";
    private static final Map<Integer, List<EquivalentStructure>> equivalencesMap = new HashMap<>();
    private Map<EquivalentStructure, Set<Integer>> convertionPerformed = new HashMap<>();
    private int recursiveDepth = 0;

    public static Logger logger = LoggerFactory.getLogger(StructureStyler.class);

    static {
        List<EquivalentStructure> equivalences = EquivalentStructureManager.getInstance().loadEquivalences(MyJavaParser.class, CONF_FILE); // TBD: extend for other languages
        for (EquivalentStructure equivalence : equivalences) {
            for (int rule : equivalence.rules) {
                // create map for efficiency, avoid to traverse all configured structures.
                equivalencesMap.computeIfAbsent(rule, v -> new ArrayList<>()).add(equivalence);
            }
        }

    }

    public StructureStyler() {
        style = new StructureStyle();
        // executeWhenExit is true
    }


    /**
     *
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
        List<EquivalentStructure> equivalentStructures = equivalencesMap.get(ruIndex);
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
        int ruIndex = ctx.getRuleIndex();
        if (ctx.getRuleIndex() == parser.getRuleStmt()) {
            ruIndex = parser.getSpecificStmt(ctx).getRuleIndex();
        }
        ++recursiveDepth;
        ParseTree newTree = ctx;
        List<EquivalentStructure> equivalentStructures = equivalencesMap.get(ruIndex);
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
                        RunStatistic.addTriggeredStyle(parser.getSourceFile(), style.getStyleName());
                        RunStatistic.addTriggeredStructureID(parser.getSourceFile(), matchedStructure.structure.id);
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



    /**
     * Apply the structure to the context. This method is specifically used for the mutator experiment.
     * @param ctx the context to be matched
     * @param parser the parser
     * @param from the spot of the source structure
     * @param to the index of the target structure
     */
    public static void applyStructure(ExtendContext ctx, MyParser parser, Spot from, int to) {
        int ruleIndex = ctx.getRuleIndex();
        if (ctx.getRuleIndex() == parser.getRuleStmt()) {
            ruleIndex = parser.getSpecificStmt(ctx).getRuleIndex();
        }
        if (ruleIndex != from.ruleIndex()) {
            logger.info("Fiailed to apply structure due to mismatched rule index ({} vs {}).", ruleIndex, from.ruleIndex());
            return;
        }
        List<EquivalentStructure> equivalentStructures = equivalencesMap.get(ruleIndex);
        for (EquivalentStructure structure : equivalentStructures) {
            if (structure.getId() == from.structureIndex()) {
                if (structure.match(ctx, parser) != from.treeIndex()) {
                    logger.info("Failed to apply structure due to mismatched tree index ({} vs {}).", structure.match(ctx, parser), from.treeIndex());
                    return;
                }
                ParseTree newTree = structure.convert(from.treeIndex(), to, ctx, parser);
                if (newTree == null) {
                    logger.info("Failed to convert from {} to {} when structure id = {}.", from.treeIndex(), to, from.structureIndex());
                }
                logger.info("Converted from {} to {} when structure id = {}.", from.treeIndex(), to, from.structureIndex());
                return;
            }
        }
        logger.info("Note: Fail to apply structure when structure id = {}.", from.treeIndex(), to, from.structureIndex());
    }

    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        int ruleIndex = ctx.getRuleIndex();
        if (ctx.getRuleIndex() == parser.getRuleStmt()) {
            ruleIndex = parser.getSpecificStmt(ctx).getRuleIndex();
        }
        List<EquivalentStructure> equivalentStructures = equivalencesMap.get(ruleIndex);
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

    /**
     * Sets structure preference rules based on the given sequence in order.
     * @param language the language of the parser
     * @param sequence the sequence of preference indices
     */
    public void setAs(String language, List<Integer> sequence) {
        style = new StructureStyle();
        MyParser parser = MyParserFactory.createParser(language);
        List<EquivalentStructure> equivalences = EquivalentStructureManager.getInstance().loadEquivalences(parser.getClass(), CONF_FILE);
        for (int i = 0; i < equivalences.size(); i++) {
            EquivalentStructure structure = equivalences.get(i);
            int index = sequence.get(i);
            StyleContext context = extractContext(structure);
            StructPreferenceProperty property = extractProperty(structure, index);
            style.addRule(context, property);
        }
    }

    /**
     * Matches the context with the equivalent structures and returns the structure id. This method is specifically used for the mutator experiment.
     * @param ctx the context to be matched
     * @param parser the parser
     * @return the structure id if matched, otherwise -1
     */
    public static Spot extractSpot(ExtendContext ctx, MyParser parser) {
        int ruleIndex = ctx.getRuleIndex();
        if (ctx.getRuleIndex() == parser.getRuleStmt()) {
            ruleIndex = parser.getSpecificStmt(ctx).getRuleIndex();
        }
        List<EquivalentStructure> equivalentStructures = equivalencesMap.get(ruleIndex);
        if (equivalentStructures != null) {
            for (EquivalentStructure structure : equivalentStructures) {
                int treeId = structure.match(ctx, parser);
                if (treeId != -1) {
                    return new Spot(ruleIndex, structure.getId(), treeId);
                }
            }
        }
        return null;
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
