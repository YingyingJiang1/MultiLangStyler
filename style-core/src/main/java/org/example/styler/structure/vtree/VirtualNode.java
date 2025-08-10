package org.example.styler.structure.vtree;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.parser.common.MyParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VirtualNode {

    public ParseTree tree = null;
    // Real nodes the virtual node matched.
    public List<ParseTree> matchedTrees = new ArrayList<>(0);
    public String type; // The type of corresponding placeholder.
    public String repetition; // The number of matches allowed.


    public VirtualNode(String type, String repetition) {
        this.type = type;
        this.repetition = repetition;
    }

    public void addMatchedTree(ParseTree tChild) {
        matchedTrees.add(tChild);
    }

    public void cleanState() {
        matchedTrees.clear();
    }

    public boolean isEmpty() {
        return tree == null;
    }

    public boolean matches(ParseTree t1, MyParser parser) {
        // Check node
        boolean isMatched = VirtualNodeMatcher.getInstance(parser).isMatched(type, t1, parser);
        // Check state
        int step = moveStep();

        if (isMatched && step == 0) {
            addMatchedTree(t1);
            return true;
        }
        return false;
    }

    public boolean checkState(MyParser parser) {
        // Check tree type correct.
        for (ParseTree tree : matchedTrees) {
            if (!VirtualNodeMatcher.getInstance(parser).isMatched(type, tree, parser)) {
                return false;
            }
        }

        // Check size correct.
        int sizeBefore = matchedTrees.size();
        return repetition.isEmpty() && sizeBefore == 1 ||
                repetition.equals("*") ||
                repetition.equals("+") && sizeBefore >= 1 ||
                repetition.equals("?") && sizeBefore <= 1;
    }

    public int moveStep() {
        if (repetition.equals("*") || repetition.equals("+") || repetition.equals("?") && matchedTrees.isEmpty()) {
            return 0;
        }
        return matchedTrees.size() == 1 ? 1 : 0;
    }


    @Override
    public boolean equals(Object o) {
       if (o instanceof VirtualNode vnode) {
           return Objects.equals(tree, vnode.tree) &&
                   Objects.equals(matchedTrees, vnode.matchedTrees) &&
                   Objects.equals(type, vnode.type) &&
                   Objects.equals(repetition, vnode.repetition);
       }
       return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tree, matchedTrees, type, repetition);
    }

    public boolean isRollback() {
        if (matchedTrees.isEmpty()) {
            return false;
        }
        return repetition.equals("*") ||  repetition.equals("+") && matchedTrees.size() > 1 || repetition.equals("?");
    }

    public ParseTree removeLastMatchedTree() {
        if (matchedTrees.isEmpty()) {
            return null;
        }
        return matchedTrees.remove(matchedTrees.size() - 1);
    }
}
