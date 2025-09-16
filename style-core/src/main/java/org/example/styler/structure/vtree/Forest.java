package org.example.styler.structure.vtree;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;

import javax.swing.text.StyledEditorKit;
import java.util.*;
import java.util.Objects;

public class Forest implements Comparable {

    List<ParseTree> trees = new ArrayList<>(1);
    List<VirtualNode> vNodes = new ArrayList<>();
    int priority = 0;
    String style;


    public Forest(List<ParseTree> trees, int priority, String style) {
        this.trees = trees;
        this.priority = priority;
        this.style = style;
    }

    @Override
    public int compareTo(Object o) {
        Forest forest = (Forest) o;
        if (this.equals(o)) {
            return 0;
        }
        return priority > forest.priority ? -1 : 1;
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

    public String getStyle() {
        return style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trees, priority);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Forest forest) {
            return trees.equals(forest.trees) && priority == forest.priority;
        }
       return false;
    }

    public void addVNode(VirtualNode vNode) {
        if (!vNodes.contains(vNode)) {
            vNodes.add(vNode);
        }
    }

    public List<VirtualNode> getvNodes() {
        return vNodes;
    }

    public int getRealForestSize() {
        int size = 0;
        for (ParseTree t : trees) {
            VirtualNode vNode = getVirtual(t);
            if (vNode != null) {
                size += vNode.matchedTrees.size();
            } else {
                size++;
            }
        }
        return size;
    }

    private VirtualNode getVirtual(ParseTree t) {
        for (VirtualNode vNode : vNodes) {
            if (vNode.tree == t) {
                return vNode;
            }
        }
        return null;
    }
}
