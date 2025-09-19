package org.example.parser.common.context;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.example.parser.common.MyParser;
import org.example.parser.common.token.ExtendToken;
import org.example.parser.java.antlr.JavaLexer;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/20 22:42
 */
public class ExtendContext extends ParserRuleContext {
    public int hierarchy = 0;
    protected static int braceDepth = 0;

    public ExtendContext getFirstCtxChildIf(Predicate<ExtendContext> test) {
        for (ParseTree child : children) {
            if (child instanceof ExtendContext childCtx && test.test(childCtx)) {
                return childCtx ;
            }
        }
        return null;
    }

    @Override
    public Token getStop() {
        return getChildCount() > 0 ? super.getStop() : null;
    }

    @Override
    public Token getStart() {
        return getChildCount() > 0 ?  super.getStart() : null;
    }

    /**
     * This method isn't suitable here.
     */
//    public void updateHierarchy(MyParser parser) {
//        ExtendContext targetAncestor = findFirstParentIf(p -> {
//            int specificType = parser.getSpecificStmtType(p);
//            return parser.getCompoundStmts().contains(specificType) || parser.getRuleBody() == specificType || parser.getRuleBlock() == specificType;
//                });
//        if (targetAncestor != null) {
//            boolean isDependentBlock = parser.getSpecificStmtType(this) == parser.getRuleBlock() &&
//                    findFirstParentIf(p -> parser.getCompoundStmts().contains(p.getRuleIndex())) == targetAncestor;
//            if (isDependentBlock) {
//                if (getParent() instanceof ExtendContext parentCtx) {
//                    hierarchy = parentCtx.hierarchy;
//                }
//            } else {
//                hierarchy = targetAncestor.hierarchy + 1;
//            }
//        }
//    }


    public ExtendContext() {
        children = new ArrayList<>(0);
    }


    public ExtendContext(ParserRuleContext parent, int invokingStateNumber) {
        super(parent, invokingStateNumber);
        children = new ArrayList<>(0);
    }

    @Override
    public ExtendContext clone() throws CloneNotSupportedException {
        return null;
    }

    public void addChild(ParseTree t) {
        children.add(t);
        t.setParent(this);
        updateStartToken();
        updateStopToken();
    }

    public void addChildren(List<ParseTree> trees) {
        for (ParseTree t : trees) {
            children.add(t);
            t.setParent(this);
        }
        updateStartToken();
        updateStopToken();
    }

    public void addTerNode(int type, String text, int insertionPoint) {
        TerminalNode t = new TerminalNodeImpl(new ExtendToken(type, text));
        t.setParent(this);
        children.add(insertionPoint, t);
    }

    public TerminalNode getFirstTerChildByType(int type) {
        for (ParseTree child : children) {
            if (child instanceof TerminalNode && ((TerminalNode) child).getSymbol().getType() == type) {
                return (TerminalNode) child;
            }
        }
        return null;
    }

    public ExtendContext getFirstContextRecIf(Predicate<ExtendContext> cond) {
        for (ParseTree child : children) {
            if (child instanceof ExtendContext) {
                ExtendContext ctx1 = (ExtendContext) child;
                if (cond.test(ctx1)) {
                    return ctx1;
                }
                ExtendContext res = ctx1.getFirstContextRecIf(cond);
                if (res != null) {
                    return res;
                }
            }
        }
        return null;
    }

    public ExtendContext getFirstParentIf(Predicate<ExtendContext> cond) {
        ParseTree parent = getParent();
        while (parent != null) {
            if (parent instanceof ExtendContext parentCtx && cond.test(parentCtx)) {
                return parentCtx;
            }
            parent = parent.getParent();
        }
        return parent == null ? null : (ExtendContext) parent;
    }

    public ExtendContext findFirstParentIf(Predicate<ExtendContext> cond) {
        ParseTree parent = getParent();
        while (parent != null) {
            if (parent instanceof ExtendContext parentCtx && cond.test(parentCtx)) {
                return parentCtx;
            }
            parent = parent.getParent();
        }
        return null;
    }

    public String getFormattedText(MyParser parser) {
        StringBuilder builder = new StringBuilder();
        List<Token> tokens = getAllTokensRec();
        BiPredicate<Token, Token> isSpaceNecessary = new BiPredicate<Token, Token>() {
            @Override
            public boolean test(Token token, Token token2) {
                return (parser.getIdentifier() == token.getType() || parser.belongToKeyword(token)) &&
                        (parser.getIdentifier() == token2.getType() || parser.belongToKeyword(token2));
            }
        };

        for (Token token : tokens) {
            if (token instanceof ExtendToken extendToken) {
                builder.append(extendToken.getFormattedText());
            }
        }
//        for (int i = 0; i < tokens.size() - 1; i++) {
//            builder.append(tokens.get(i).getText());
//            if (isSpaceNecessary.test(tokens.get(i), tokens.get(i + 1))) {
//                builder.append(" ");
//            }
//        }
//        builder.append(tokens.get(tokens.size() - 1).getText());
        return builder.toString();
    }

    /*
     * Put the children of the context instance on one line,
     * then calculate and return the column length(excluding all horizontal whitespace length).
     * */
    public int calColumnSumInOneLine(ExtendContext ctx) {
        int columnLength = 0;
        for (ParseTree root : ctx.children) {
            if (root instanceof ExtendContext) {
                columnLength += calColumnSumInOneLine((ExtendContext) root);
            } else {
                columnLength += ((TerminalNode) root).getSymbol().getText().length();
            }
        }
        return columnLength;
    }

    public int countCtxChildren() {
        int count = 0;
        for (ParseTree child : children) {
            if (child instanceof ExtendContext) {
                ++count;
            }
        }
        return count;
    }


    public int countChildIf(Predicate<ParseTree> cond) {
        int count = 0;
        for (ParseTree child : children) {
            if (cond.test(child)) {
                ++count;
            }
        }
        return count;
    }

    public void decBraceDepth() {
        --braceDepth;
    }

    public int getBraceDepth() {
        return braceDepth;
    }

    public void incBraceDepth() {
        ++braceDepth;
    }

    /**
     *
     * @return The next token of the ctx.stop
     */
    public Token getNextToken() {
        ExtendContext parent = (ExtendContext) this.parent;
        ExtendContext cur = this;
        Token nextToken = null;
        while (parent != null) {
            if (parent.getChild(parent.getChildCount() - 1) != cur) {
                ParseTree nextTree = parent.getChild(parent.children.indexOf(cur) + 1);
                nextToken = nextTree instanceof TerminalNode ter ? ter.getSymbol() : ((ExtendContext) nextTree).start;
                break;
            }
            cur = parent;
            parent = (ExtendContext) parent.parent;
        }
        return nextToken;
    }

    /**
     * @return The previous token of the ctx.start
     */
    public Token getPrevToken() {
        ExtendContext parent = (ExtendContext) this.parent;
        ExtendContext cur = this;
        Token preToken = null;
        while (parent != null) {
            if (parent.getChild(0) != cur) {
                ParseTree preTree = parent.getChild(parent.children.indexOf(cur) - 1);
                preToken = preTree instanceof TerminalNode ter ? ter.getSymbol() : ((ExtendContext) preTree).stop;
                break;
            }
            cur = parent;
            parent = (ExtendContext) parent.parent;
        }
        return preToken;
    }

    @Override
    public List<TerminalNode> getTokens(int ttype) {
        return super.getTokens(ttype);
    }

    public void expandChildren(MyParser parser) {
        expandChildIf(parser::belongToExpandChildren);
    }


    public void expandChildIf(Predicate<ParseTree> expand) {
        if (children == null) {
            children = new ArrayList<>();
            return;
        }
        List<ParseTree> newChildren = new ArrayList<>();
        for (ParseTree root : children) {
            if (root != null) {
                if (!expand.test(root) || root instanceof TerminalNode) {
                    newChildren.add(root);
                } else {
                    ExtendContext rootCtx = (ExtendContext) root;
                    if (rootCtx.children != null) {
                        for (ParseTree child : rootCtx.children) {
                            if (child != null) {
                                child.setParent(this);
                                newChildren.add(child);
                            }
                        }
                    }
                }
            }
        }
        children = newChildren;
        updateStartToken();
        updateStopToken();
    }

    public void replaceChild(ParseTree oldChild, ParseTree newChild) {
        int targetIndex = -1;
        for (int i = 0; i < children.size(); i++) {
            ParseTree child = children.get(i);
            if (child == oldChild) {
                targetIndex = i;
                children.set(i, newChild);
                newChild.setParent(this);
                break;
            }
        }
        updateStartToken();
        updateStopToken();
    }

    public void replaceChildren(int from, int to, List<? extends ParseTree> newTrees) {
        children.removeAll(children.subList(from, to));
        children.addAll(from, newTrees);
        for (ParseTree newTree : newTrees) {
            newTree.setParent(this);
        }
        updateStartToken();
        updateStopToken();
    }

    public void deleteStatementCtx(MyParser parser) {
        for (int i = 0; i < getChildCount(); ++i) {
            if (parser.isStatement(getChild(i))) {
                ExtendContext stmtCtx = (ExtendContext) getChild(i);
                this.replaceChild(stmtCtx, stmtCtx.getChild(0));
            }
        }
    }

    public ExtendContext getFirstInnerChildByType(int ruleIndex) {
        for (int i = 0; i < this.children.size(); ++i) {
            ParseTree treeNode = this.children.get(i);
            if (treeNode instanceof ExtendContext) {
                ExtendContext innerNode = (ExtendContext) treeNode;
                if (innerNode.getRuleIndex() == ruleIndex)
                    return innerNode;
            }
        }
        return null;
    }

    public Token getFirstTokenByType(int tokenType) {
        for (int i = 0; i < this.children.size(); ++i) {
            ParseTree treeNode = this.children.get(i);
            if (treeNode instanceof TerminalNode) {
                TerminalNode terNode = (TerminalNode) treeNode;
                if (terNode.getSymbol().getType() == tokenType)
                    return terNode.getSymbol();
            }
        }
        return null;
    }

    public ExtendContext getLastCtxChildIf(Predicate<ExtendContext> test) {
        for (int i = children.size() - 1; i >= 0; --i) {
            if (children.get(i) instanceof ExtendContext childCtx && test.test(childCtx)) {
                return childCtx;
            }
        }
        return null;
    }


    public List<ExtendContext> getAllContextsByType(int ruleIndex) {
        return getAllChildContextsIf(ctx -> ctx.getRuleIndex() == ruleIndex);
    }

    public List<ExtendContext> getAllCtxsRecIf(Predicate<ExtendContext> cond) {
        List<ExtendContext> ctxs = new ArrayList<>();
        for (int i = 0; i < this.children.size(); ++i) {
            ParseTree treeNode = this.children.get(i);
            if (treeNode instanceof ExtendContext innerNode) {
                ctxs.addAll(innerNode.getAllCtxsRecIf(cond));
                if (cond.test(innerNode)) {
                    ctxs.add(innerNode);
                }
            }
        }
        return ctxs;
    }

    public List<TerminalNode> getAllTerminalsIf(Predicate<TerminalNode> cond) {
        List<TerminalNode> ret = new ArrayList<>();
        for (ParseTree child : children) {
            if (child instanceof TerminalNode terChild) {
                if (cond.test(terChild)) {
                    ret.add(terChild);
                }
            }
        }
        return ret;
    }


    public List<ExtendContext> getAllChildContextsIf(Predicate<ExtendContext> cond) {
        List<ExtendContext> ctxs = new ArrayList<>();
        for (int i = 0; i < this.children.size(); ++i) {
            ParseTree treeNode = this.children.get(i);
            if (treeNode instanceof ExtendContext innerNode) {
                if (cond.test(innerNode)) {
                    ctxs.add(innerNode);
                }
            }
        }
        return ctxs;
    }

    public List<Token> getAllTokensByType(int tokenType) {
        List<Token> tokens = new ArrayList<>();
        for (int i = 0; i < this.children.size(); ++i) {
            ParseTree treeNode = this.children.get(i);
            if (treeNode instanceof TerminalNode) {
                TerminalNode terNode = (TerminalNode) treeNode;
                if (terNode.getSymbol().getType() == tokenType)
                    tokens.add(terNode.getSymbol());
            }
        }
        return tokens;
    }

    // Return the index of first inner child with type @ruleId;
    public int indexOfFirstInnerChildByType(int ruleIndex) {
        for (int i = 0; i < this.children.size(); ++i) {
            ParseTree treeNode = this.children.get(i);
            if (treeNode instanceof ExtendContext) {
                ExtendContext innerNode = (ExtendContext) treeNode;
                if (innerNode.getRuleIndex() == ruleIndex)
                    return i;
            }
        }
        return -1;
    }

    public int indexOfIf(Predicate<ParseTree> predicate) {
        for (int i = 0; i < this.children.size(); ++i) {
            ParseTree treeNode = this.children.get(i);
            if (predicate.test(treeNode))
                return i;
        }
        return -1;
    }

    // Return the index of the first child satisfying the @cond.
    public int indexOfFirstChild(Predicate<ParseTree> cond) {
        for (int i = 0; i < this.children.size(); ++i) {
            ParseTree treeNode = this.children.get(i);
            if (cond.test(treeNode)) {
                return i;
            }
        }
        return -1;
    }

    // Return the index of the first child satisfying the @cond.
    public int indexOfLastChild(Predicate<ParseTree> cond) {
        for (int i = this.children.size() - 1; i >= 0; --i) {
            ParseTree treeNode = this.children.get(i);
            if (cond.test(treeNode)) {
                return i;
            }
        }
        return -1;
    }


    // find terminal child
    public int findFirstTerChildByType(int tokenType) {
        for (int i = 0; i < this.children.size(); ++i) {
            ParseTree treeNode = this.children.get(i);
            if (treeNode instanceof TerminalNode) {
                TerminalNode terMode = (TerminalNode) treeNode;
                if (terMode.getSymbol().getType() == tokenType)
                    return i;
            }
        }
        return -1;
    }

    // Get all tokens recursively.
    public List<Token> getAllTokensRec() {
        List<Token> tokens = new ArrayList<>();
        for (ParseTree root : children) {
            if (root instanceof TerminalNode terminalNode) {
                if (terminalNode.getSymbol() instanceof ExtendToken extendToken) {
                    extendToken.astRule = ((ExtendContext) root.getParent()).getRuleIndex();
                }
                tokens.add((terminalNode.getSymbol()));
            } else {
                tokens.addAll(((ExtendContext) root).getAllTokensRec());
            }
        }
        return tokens;
    }

    public List<Token> getAllExpandedTokensRec() {
        List<Token> tokens = new ArrayList<>();
        for (ParseTree root : children) {
            if (root instanceof TerminalNode terminalNode) {
                if (terminalNode.getSymbol() instanceof ExtendToken extendToken) {
                    tokens.addAll(extendToken.getContextTokens());
                    int astRule = ((ExtendContext) root.getParent()).getRuleIndex();
                    for (Token t : extendToken.getContextTokens()) {
                        ((ExtendToken) t).astRule = astRule;
                    }
                }
            } else {
                tokens.addAll(((ExtendContext) root).getAllExpandedTokensRec());
            }
        }
        return tokens;
    }


    public List<TerminalNode> getAllTerminalsRecIf(Predicate<TerminalNode> cond) {
        List<TerminalNode> terminalNodeList = new ArrayList<>();
        for (ParseTree root : children) {
            if (root instanceof TerminalNode terminalNode) {
                if (cond.test(terminalNode)) {
                    terminalNodeList.add(terminalNode);
                }
            } else {
                terminalNodeList.addAll(((ExtendContext) root).getAllTerminalsRecIf(cond));
            }
        }
        return terminalNodeList;
    }

    public void printChildren() {
        System.out.println(this.getClass().getSimpleName());
        for (ParseTree child : children) {
            if (child instanceof TerminalNode) {
                System.out.print(child.getText());
            } else {
                System.out.print(child.getClass().getSimpleName());
            }
            System.out.print(" ");
        }
        System.out.println(System.lineSeparator());
    }


    // Remove all extra SEMI tokens.
    private void removeAllExtraSemi(ExtendContext ctx) {
        ctx.children.removeIf(root -> root instanceof TerminalNode
                && ((TerminalNode) root).getSymbol().getType() == JavaLexer.SEMI);
    }

    /**
     * @apiNote If the start token is used to do something, then make sure no styler that adds format tokens(vws,hws...) has executed style application.
     * Otherwise, the start token may be hws or vws.
     */
    public void updateStartToken() {
        updateStartTokenRec(this);
    }

    private void updateStartTokenRec(ParseTree cur) {
        if (cur instanceof ExtendContext curCtx && !curCtx.children.isEmpty()) {
            ParseTree startTree = curCtx.children.get(0);
            if (startTree instanceof ExtendContext startCtx && curCtx.start != startCtx.start) {
                curCtx.start = startCtx.start;
                updateStartTokenRec(cur.getParent());
            } else if (startTree instanceof TerminalNode startTer && curCtx.start != startTer.getSymbol()) {
                curCtx.start = startTer.getSymbol();
                updateStartTokenRec(cur.getParent());
            }
        }
    }

    /**
     * @apiNote If the stop token is used to do something, then make sure no styler that adds format tokens(vws,hws...) has executed style application.
     * Otherwise, the stop token may be hws or vws.
     */
    public void updateStopToken() {
        updateStopTokenRec(this);
    }

    private void updateStopTokenRec(ParseTree cur) {
        if (cur instanceof ExtendContext curCtx && !curCtx.children.isEmpty()) {
            ParseTree stopTree = curCtx.children.get(curCtx.children.size() - 1);
            if (stopTree instanceof ExtendContext stopCtx && curCtx.stop != stopCtx.stop) {
                curCtx.stop = stopCtx.stop;
                updateStopTokenRec(cur.getParent());
            } else if (stopTree instanceof TerminalNode stopTer && curCtx.stop != stopTer.getSymbol()) {
                curCtx.stop = stopTer.getSymbol();
                updateStopTokenRec(cur.getParent());
            }
        }
    }

    public void removeChildIf(Predicate<ParseTree> cond) {
        List<ParseTree> newChildren = new ArrayList<>();
        for (ParseTree child : children) {
            if (!cond.test(child)) {
                newChildren.add(child);
            }
        }
        children = newChildren;
        updateStartToken();
        updateStopToken();
    }

    public void removeAll(int start, int end) {
        if (start >= end || start >= children.size()) {
            return;
        }
        int safeEnd = Math.min(end, children.size());
        children.subList(start, safeEnd).clear();
        updateStartToken();
        updateStopToken();
    }


    public void insertChild(int i, ParseTree child) {
        children.add(i, child);
        if (child instanceof ExtendContext childCtx) {
            childCtx.parent = this;
        }
        updateStartToken();
        updateStopToken();
    }

    public boolean isDescendantOf(ExtendContext  ancestor) {
        ParseTree cur = this;
        while (cur != null) {
            if (cur == ancestor) {
                return true;
            }
            cur = cur.getParent();
        }
        return false;
    }

	public void setChild(int index, ParseTree parseTree) {
        children.set(index, parseTree);
        parseTree.setParent(this);
	}
}