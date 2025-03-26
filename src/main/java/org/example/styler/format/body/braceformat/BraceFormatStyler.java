package org.example.styler.format.body.braceformat;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.parser.common.MyParser;
import org.example.parser.common.context.ExtendContext;
import org.example.parser.common.token.ExtendToken;

import org.example.styler.format.body.BodyContext;
import org.example.styler.format.body.BodyNumType;
import org.example.styler.format.body.BodyStyler;
import org.example.styler.format.body.braceformat.style.BraceFormatProperty;
import org.example.styler.format.body.braceformat.style.BraceFormatStyle;
import org.example.styler.format.body.BodyTypeEnum;

import java.util.*;

public class BraceFormatStyler extends BodyStyler {
    private static Set<Integer> relevantRules = null;

    public BraceFormatStyler() {
        style = new BraceFormatStyle();
    }

    @Override
    public ExtendContext applyStyle(ExtendContext ctx, MyParser parser) {
        List<ExtendContext> blocks = getAllBlocks(ctx, parser);

        // Apply brace information.
        int lastIndex = blocks.size() - 1;
        for (int i = 0; i < blocks.size(); ++i) {
            ExtendContext block = parser.getSpecificStmt(blocks.get(i));
            BodyContext context = extractStyleContext(ctx, block, parser);

            BraceFormatProperty property = (BraceFormatProperty) style.getSimilarProperty(context);
            // Insert VWS terminal node near LBRACE and RBRACE terminal nodes.
            if (property != null) {
                boolean beforeLB = property.beforeLB, afterLB = property.afterLB, beforeRB = property.beforeRB, afterRB = property.afterRB;
                // Specially process the last block of multi-block statement.
                if (context.bodyType == BodyTypeEnum.MULTI_BLOCK_STMT_BODY && i == lastIndex) {
                    context.bodyType = BodyTypeEnum.NORMAL_BODY;
                    BraceFormatProperty property1 = (BraceFormatProperty) style.getProperty(context);
                    if (property1 != null) {
                        beforeLB = property1.beforeLB;
                        afterLB = property1.afterLB;
                        beforeRB = property1.beforeRB;
                        afterRB = property1.afterRB;
                    } else if (!afterRB) {
                        afterRB = true;
                    }
                }

                // Process empty body specially.
                if (context.bodyNumType == BodyNumType.EMPTY && afterLB && beforeRB) {
                    beforeRB = false;
                }

                // Process continuous }}
//                Token nextToken = block.getNextToken();
//                if (nextToken != null && nextToken.getType() == parser.getRBrace()) {
//                    afterRB = false;
//                }

                // Add vws around braces.
                if (beforeLB) {
                    addVwsBefore(block, parser.getLBrace(), parser);
                }
                if (afterLB) {
                    addVwsAfter(block, parser.getLBrace(), parser);
                }
                if (beforeRB) {
                    addVwsBefore(block, parser.getRBrace(), parser);
                }
                if (afterRB) {
                    addVwsAfter(block, parser.getRBrace(), parser);
                }
            }
        }
        return ctx;
    }


    @Override
    public void extractStyle(ExtendContext ctx, MyParser parser) {
        List<ExtendContext> blocks = getAllBlocks(ctx, parser);
        int ruleIndex = parser.getSpecificStmtType(ctx);
        boolean isMultiBlockStmt = ruleIndex == parser.getRuleIfElseStmt() || ruleIndex == parser.getRuleTryCatchStmt();
        // Extract brace information.
        for (int i = 0; i < blocks.size(); ++i) {
            ExtendContext block = parser.getSpecificStmt(blocks.get(i));
            // Skip the last block of multi-block statement.
            int blockIndex = ctx.indexOfFirstChild(child -> child instanceof ExtendContext childCtx && parser.getSpecificStmt(childCtx) == parser.getSpecificStmt(block));
            if (isMultiBlockStmt && blockIndex == ctx.getChildCount() - 1) {
                continue;
            }

            BodyContext context = extractStyleContext(ctx, block, parser);
            BraceFormatProperty styleProperty = extractProperty(block);
            style.addRule(context, styleProperty);
        }
    }

    @Override
    protected Set<Integer> getRelevantRules(MyParser parser) {
        if (relevantRules == null) {
            relevantRules = new HashSet<>(Arrays.asList(
                    parser.getRuleTypeDeclaration(),
                    parser.getRuleSwitchBlockStatementGroup(),
                    parser.getRuleConstructorDeclaration(),
                    parser.getRuleMethodDeclaration(),
                    parser.getRuleSyncStmt(),
                    parser.getRuleInitializer(),
                    parser.getRuleArrayInitializer(),
                    parser.getRuleElementValueArrayInitializer()
            ));
            relevantRules.addAll(parser.getCompoundStmts());
        }
        return relevantRules;
    }

    //--------------------------------------------------- Private methods ---------------------------------------------------

    private void addVwsBefore(ExtendContext ctx, int braceType, MyParser parser) {
        ExtendToken token = (ExtendToken) ctx.getFirstTokenByType(braceType);
        Token vwsToken = parser.getTokenFactory().create(parser.getVws(), System.lineSeparator());
        token.addToken(token.indexInContextTokens(), vwsToken);
    }

    private void addVwsAfter(ExtendContext ctx, int braceType, MyParser parser) {
        ExtendToken token = (ExtendToken) ctx.getFirstTokenByType(braceType);
        boolean hasTrailingComment = token.indexOfLastTokenAfterIf(type -> type == parser.getLineComment()) >= 0;
        if (!hasTrailingComment) {
            Token vwsToken = parser.getTokenFactory().create(parser.getVws(), System.lineSeparator());
            token.addToken(token.indexInContextTokens() + 1, vwsToken);
        }
    }


    private List<ExtendContext> getAllBlocks(ExtendContext ctx, MyParser parser) {
        int ruleIndex = ctx.getRuleIndex();
        List<ExtendContext> blocks = new ArrayList<>();

        if (ruleIndex == parser.getRuleBody() ||
                ruleIndex == parser.getRuleArrayInitializer() || ruleIndex == parser.getRuleElementValueArrayInitializer()) {
            blocks.add(ctx);
        } else {
            for (ParseTree child : ctx.children) {
                if (parser.isBlock(child) || parser.isBody(child)) {
                    blocks.add((ExtendContext) child);
                } else if (parser.isCatchClause(child)) {
                    blocks.add(((ExtendContext) child).getFirstCtxChildIf(parser::isBlock));
                }
            }
        }
        return blocks;
    }

    private BraceFormatProperty extractProperty(ExtendContext block) {
        Token lbToken = block.start, rbToken = block.stop;
        Token afterLBToken = getStartToken(block.getChild(1));
        Token beforeRBToken = getStopToken(block.getChild(block.getChildCount() - 2));
        Token beforeLBToken = block.getPrevToken();
        Token afterRBToken = block.getNextToken();

        boolean beforeLB = true, afterLB = true, beforeRB = true, afterRB = true;
        if (beforeLBToken != null) {
            beforeLB = beforeLBToken.getLine() != lbToken.getLine();
        }
        if (afterLBToken != null) {
            afterLB = afterLBToken.getLine() != lbToken.getLine();
        }
        if (beforeRBToken != null) {
            beforeRB = beforeRBToken.getLine() - rbToken.getLine() > 1; // "token\n\n}": the first \n is after `token`, the second \n if before `}`
        } if (afterRBToken != null) {
            afterRB = afterRBToken.getLine() != rbToken.getLine();
        }

        // Empty block.
        if (afterLBToken == rbToken) {
            afterLB = false;
        }

        return new BraceFormatProperty(beforeLB, afterLB, beforeRB, afterRB);
    }

    private Token getStopToken(ParseTree t) {
        if (t == null) {
            return null;
        }
        if (t instanceof TerminalNode ter) {
            return ter.getSymbol();
        } else {
            return ((ExtendContext) t).stop;
        }
    }

    private Token getStartToken(ParseTree t) {
        if (t == null) {
            return null;
        } else if (t instanceof TerminalNode ter) {
            return ter.getSymbol();
        } else {
            return ((ExtendContext) t).start;
        }
    }
}
