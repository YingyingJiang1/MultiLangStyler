package org.example.style.codecontext;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.common.context.ExtendContext;
import org.example.styler.structure.EquivalentStructure;

public class StructureCodeContext extends ListASTBasedCodeContext {
    private final EquivalentStructure structure; // the skeleton structure of the code context
    private final int index; // the index of the code context in the skeleton structure

    public StructureCodeContext(EquivalentStructure structure, int index, ExtendContext startNode) {
        super(collectNodes(structure, index, startNode));
        this.structure = structure;
        this.index = index;
    }

    private static List<? extends ParseTree> collectNodes(EquivalentStructure structure, int index, ExtendContext startNode) {
        List<ParseTree> nodes = new ArrayList<>();
        int size = structure.getForests().get(index).size();
        if (size == 1) {
            nodes.add(startNode);
        } else {
            int idxInParent = startNode.getParent().children.indexOf(startNode);
            nodes.addAll(startNode.getParent().children.subList(idxInParent, idxInParent + size));
        }
        return nodes;
    }

    public EquivalentStructure getStructure() {
        return structure;
    }

    public int getMatchedIdx() {
        return index;
    }

    public ExtendContext getStartNode() {
        return (ExtendContext) getNodes().get(0);
    }
}
