package org.example.styler.structure.vtree;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;

import javax.swing.text.StyledEditorKit;
import java.util.*;
import java.util.Objects;

public class Forest implements Comparable {

    List<ParseTree> trees = new ArrayList<>(1);
    Map<ParseTree, VirtualNode> realTreeVnodeMap = new HashMap<>();
    int priority = 0;

    public void addVNodeMap(ParseTree t, VirtualNode virtualNode) {
        realTreeVnodeMap.put(t, virtualNode);
    }

    public boolean addMatchedRealTree(ParseTree t, ParseTree treeBefore) {
        // Only tree with previous  r"\\$.\\d*[*+?] can successfully add.
        if (realTreeVnodeMap.get(t) == null) {
            return false;
        }
        realTreeVnodeMap.get(t).matchedTrees.add(treeBefore);
        return true;
    }

    public boolean isContextMatched(MyParser parser) {
        for (VirtualNode vNode : realTreeVnodeMap.values()) {
            if (!vNode.checkState(parser)) {
                return false;
            }
        }
        return true;
    }

    public List<ParseTree> getMatchedRealTrees(ParseTree t) {
        VirtualNode vNode = realTreeVnodeMap.get(t);
        return vNode != null ? vNode.matchedTrees : new ArrayList<>(0);
    }

    public Forest(List<ParseTree> trees, int priority) {
        this.trees = trees;
        this.priority = priority;
    }

    @Override
    public int compareTo(Object o) {
        Forest forest = (Forest) o;
        if (this.equals(o)) {
            return 0;
        }
        return priority > forest.priority ? -1 : 1;
    }

    public void cleanContextState() {
        for (VirtualNode vNode : realTreeVnodeMap.values()) {
            vNode.matchedTrees.clear();
        }
    }

    public int getPriority() {
        return priority;
    }

    public int size() {
        return trees.size();
    }

    public ParseTree getTree(int index) {
        return trees.get(index);
    }

    public List<ParseTree> getTrees() {
        return trees;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trees, realTreeVnodeMap, priority);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Forest forest) {
            return trees.equals(forest.trees) && realTreeVnodeMap.equals(forest.realTreeVnodeMap) && priority == forest.priority;
        }
       return false;
    }
}
