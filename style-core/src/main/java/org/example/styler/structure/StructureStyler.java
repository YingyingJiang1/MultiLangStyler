package org.example.styler.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.MyEnvironment;
import org.example.antlr.common.context.ExtendContext;
import org.example.lang.LangAdapterCreator;
import org.example.lang.intf.MyParser;
import org.example.style.InconsistencyInfo;
import org.example.style.codecontext.CodeContext;
import org.example.style.codecontext.StructureCodeContext;
import org.example.style.rule.StyleContext;
import org.example.style.rule.StyleProperty;
import org.example.styler.InconsistencyInfoGenerator;
import org.example.styler.Stage;
import org.example.styler.Styler;
import org.example.styler.structure.style.StructPreferenceContext;
import org.example.styler.structure.style.StructPreferenceProperty;
import org.example.styler.structure.style.StructureStyle;
import org.example.styler.structure.style.StyleCategory;
import org.example.styler.structure.vtree.Forest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        List<EquivalentStructure> equivalences = EquivalentStructureManager.getInstance()
                .loadEquivalences(MyEnvironment.getIConfig().getEquivalencesConfig(lang), lang); // TBD: extend for other languages
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


    // /**
    //  * @param ctx
    //  * @param parser
    //  * @return the inconsistency info if found, otherwise null
    //  */
    // @Override
    // public @Nullable List<InconsistencyInfo> analyzeInconsistency(ExtendContext ctx, MyParser parser) {
    //     List<CodeContext> codeContexts = constructCodeContext(ctx, parser);
    //     if (codeContexts.isEmpty()) {
    //         return List.of();
    //     }
    //     List<InconsistencyInfo> infos = new ArrayList<>();
    //     // These code contexts are derived from the same start ast node, so we can only apply once because that
    //     // after an refactoring, the code context may not be valid anymore.
    //     StructureCodeContext codeContext = selectCodeContext(codeContexts);
    //     StructPreferenceContext styleContext = extractStyleContext(codeContext, parser);
    //     StructPreferenceProperty currentProperty = extractStyleProperty(codeContext, parser);
    //     StyleProperty targetProperty = style.getProperty(styleContext);
    //     if (isInconsistent(currentProperty, targetProperty, parser)) {
    //         infos.add(InconsistencyInfoGenerator.generateForStructuralStyle(codeContext, styleContext, 
    //             currentProperty, (StructPreferenceProperty) targetProperty));
    //     }

    //     return infos;
    // }



    // @Override
    // public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
    //     List<CodeContext> codeContexts = constructCodeContext(ctx, parser);
    //     if (codeContexts.isEmpty()) {
    //         return ctx;
    //     }
    //     // These code contexts are derived from the same start ast node, so we can only apply once because that
    //     // after an refactoring, the code context may not be valid anymore.
    //     // Default to apply the first code context.
    //     StructureCodeContext codeContext = selectCodeContext(codeContexts);
    //     StyleContext styleContext = extractStyleContext(codeContext, parser);
    //     StyleProperty currentProperty = extractStyleProperty(codeContext, parser);
    //     StyleProperty targetProperty = style.getProperty(styleContext);
    //     if (isInconsistent(currentProperty, targetProperty, parser)) {
    //         return doApply(codeContext, currentProperty, targetProperty, parser);
    //     }
    //     return ctx;
    // }

    
    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        if (equivalencesMap == null) {
            loadData(parser.getLanguage());
        }

        ExtendContext startNode = ctx;
        boolean applied = false;
        do {
            applied = false;
            int ruleIndex = startNode.getRuleIndex();
            if (startNode.getRuleIndex() == parser.getRuleStmt()) {
                ruleIndex = parser.getSpecificStmt(startNode).getRuleIndex();
            }
    
            Set<EquivalentStructure> equivalentStructures = equivalencesMap.get(ruleIndex);
            if (equivalentStructures != null) {
                for (EquivalentStructure structure : equivalentStructures) {
                    int index = structure.match(startNode, parser);
                    if (index != -1) {
                        StructureCodeContext codeContext = new StructureCodeContext(structure, index, startNode);
                        StructPreferenceContext styleContext = extractStyleContext(codeContext, parser);
                        StyleProperty currentProperty = extractStyleProperty(codeContext, parser);
                        StyleProperty targetProperty = style.getProperty(styleContext);
                        ExtendContext oldStartNode = startNode;
                        if (isInconsistent(currentProperty, targetProperty, parser)) {
                            startNode = doApply(codeContext, currentProperty, targetProperty, parser);
                            applied = oldStartNode!=startNode  ;
                            break;
                        }
                    }
                }
            }
    
        } while (applied);

        return startNode;
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

    private StructureCodeContext selectCodeContext(List<CodeContext> codeContexts) {
        if (codeContexts.isEmpty()) {
            return null;
        }
        return (StructureCodeContext) codeContexts.get(0);
    }

    @Override
    public boolean isRelevant(ExtendContext ctx, Stage stage, MyParser parser) {
        return ctx.getRuleIndex() == parser.getRuleStmt() || ctx.getRuleIndex() == parser.getRuleExpression();
    }

    @Override
    protected InconsistencyInfo generateInconsistencyInfo(CodeContext codeContext, 
        StyleContext styleContext, StyleProperty currentProperty, StyleProperty targetProperty, 
        MyParser parser) {

        if (codeContext instanceof StructureCodeContext structureCodeContext
            && styleContext instanceof StructPreferenceContext structPreferenceContext
            && currentProperty instanceof StructPreferenceProperty current
            && targetProperty instanceof StructPreferenceProperty target
        ) {
            return InconsistencyInfoGenerator.generateForStructuralStyle(structureCodeContext, structPreferenceContext, 
                current, target, parser);
        }
        return null;
    }


    /**
     * @return the new ast node if refactoring is performed, otherwise return the original start ast node.
     */
    @Override
    protected ExtendContext doApply(CodeContext codeContext, StyleProperty currentProperty,
         StyleProperty targetProperty, MyParser parser) {
        
        if (codeContext instanceof StructureCodeContext targetCodeContext
            && currentProperty instanceof StructPreferenceProperty current
            && targetProperty instanceof StructPreferenceProperty target
        ) {
            EquivalentStructure targetStructure = targetCodeContext.getStructure();
            int from = current.getPreferenceIndex();
            int to = target.getPreferenceIndex();
            ParseTree newTree = targetStructure.convert(from, to, targetCodeContext.getStartNode(), parser);
            return (ExtendContext) newTree;
        }
        return ((StructureCodeContext) codeContext).getStartNode();
    }

    @Override
    protected StructPreferenceProperty extractStyleProperty(CodeContext codeContext, MyParser parser) {
        if (codeContext instanceof StructureCodeContext struturereCodeContext) {
            return new StructPreferenceProperty(struturereCodeContext.getMatchedIdx(),
             struturereCodeContext.getStructure().getStyleOf(struturereCodeContext.getMatchedIdx()));
        }
        return null;
    }

    @Override
    protected StructPreferenceContext extractStyleContext(CodeContext codeContext, MyParser parser) {
        if (codeContext instanceof StructureCodeContext struturereCodeContext) {
            StyleCategory category = null;
            try {
                category = StyleCategory.valueOf(struturereCodeContext.getStructure().getCategory());
            } catch (Exception e) {
            }
            return new StructPreferenceContext(category, struturereCodeContext.getStructure().getId());
        }
        return null;
    }

    @Override
    protected List<CodeContext> constructCodeContext(ExtendContext ctx, MyParser parser) {
        if (equivalencesMap == null) {
            loadData(parser.getLanguage());
        }

        int ruleIndex = ctx.getRuleIndex();
        if (ctx.getRuleIndex() == parser.getRuleStmt()) {
            ruleIndex = parser.getSpecificStmt(ctx).getRuleIndex();
        }

        List<CodeContext> candidates = new ArrayList<>();
        Set<EquivalentStructure> equivalentStructures = equivalencesMap.get(ruleIndex);
        if (equivalentStructures != null) {
            for (EquivalentStructure structure : equivalentStructures) {
                int index = structure.match(ctx, parser);
                if (index != -1) {
                    candidates.add(new StructureCodeContext(structure, index, ctx));
                    // break; // Can't break,because ctx may match multiple structures with different id.
                }
            }
        }
        return candidates;
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
