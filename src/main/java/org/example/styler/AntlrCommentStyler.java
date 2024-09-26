package org.example.styler;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.JavaLexer;
import org.example.antlr.JavaParser;
import org.example.parser.AntlrHelper;
import org.example.parser.ExtendContext;
import org.example.parser.ExtendToken;
import org.example.parser.LexerErrorListener;
import org.example.style.ProgramStyle;
import org.example.style.comment.Comment;
import org.example.style.comment.CommentRule;

import java.util.*;
import java.util.regex.Pattern;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/31 16:04
 */
public class AntlrCommentStyler extends AntlrConcreteStylerBase{
  private static Set<Integer> relevantRules = new HashSet<>(Arrays.asList(
      JavaParser.RULE_typeDeclaration,JavaParser.RULE_methodDeclaration,
      JavaParser.RULE_constructorDeclaration,JavaParser.RULE_initializer,
      JavaParser.RULE_fieldDeclaration,JavaParser.RULE_body,
      JavaParser.RULE_block
  ));

  static Pattern pattern = Pattern.compile("\\b*([a-z]+)\\s+([a-z]+)\\s+([a-z]+).*\\b*");

  @Override
  public ExtendContext applyStyle(ExtendContext ctx, ProgramStyle programStyle) {
    List<Info> infos = extractInfos(ctx);
    Comment comment = (Comment) programStyle.getStyle(ProgramStyle.COMMENT);
    for(Info info : infos) {
      CommentRule.Context context = extractContext(info);
      CommentRule.Property property = comment.getProperty(context);
      if (property != null) {
        if (property.indention == CommentRule.Property.NO_INDENTION) {
          for(Token token : info.commentContainer.comments) {
            ((ExtendToken) token).setHierarchy(0);
          }
        }
      }
    }
    return ctx;
  }

  @Override
  public void extractStyle(ExtendContext ctx, ProgramStyle programStyle) {
    Comment comment = (Comment) programStyle.getStyle(ProgramStyle.COMMENT);
    List<Info> infos = extractInfos(ctx);
    List<CommentRule> rules = new ArrayList<>();
    for(Info info : infos) {
      CommentRule.Context context = extractContext(info);
      CommentRule.Property property = extractProperty(info);
      rules.add(new CommentRule(context, property));
    }
    comment.addRules(rules);
  }

  @Override
  protected Set<Integer> getRelevantRules() {
    return relevantRules;
  }

  private CommentRule.Property extractProperty(Info info) {
    CommentRule.Property property = new CommentRule.Property();
    if(!info.commentContainer.trailingComment) {
      int count = 0;
      for(Token comment : info.commentContainer.comments) {
        if(comment.getCharPositionInLine() == 0) {
          ++count;
        }
      }
      if (count > info.commentContainer.comments.size() / 2) {
        property.indention = CommentRule.Property.NO_INDENTION;
      } else {
        property.indention = CommentRule.Property.ALIGN;
      }
    }
    return property;
  }

  private CommentRule.Context extractContext(Info info) {
    return new CommentRule.Context(info.commentContainer.trailingComment, info.commentedRule);
  }

  static class Info {
    ExtendToken commentContainer;
    int commentedRule;

    public Info(ExtendToken commentContainer, int commentedRule) {
      this.commentContainer = commentContainer;
      this.commentedRule = commentedRule;
    }
  }

  private List<Info> extractInfos(ExtendContext ctx) {
    List<Info> infos = new ArrayList<>();
    ExtendToken container = (ExtendToken) ctx.start;
    if(container.comments.isEmpty()) {
      container = (ExtendToken) ctx.stop;
    }
    if(!container.comments.isEmpty()) {
      if(isCode(container.comments)) {
        infos.add(new Info(container, -1));
      } else {
        if(ctx.getRuleIndex() == JavaParser.RULE_block) {
          infos.add(new Info(container, ctx.parent.getRuleIndex()));
        } else {
          infos.add(new Info(container, ctx.getRuleIndex()));
        }
      }
    }

    if(ctx.getRuleIndex() == JavaParser.RULE_block) {
      for(ParseTree child : ctx.children) {
        // Recursive depth:1
        if(child instanceof ExtendContext && !(child instanceof JavaParser.BlockContext)) {
          infos.addAll(extractInfos((ExtendContext) child));
        }
      }
    }
    return infos;
  }

  private boolean isCode(List<Token> comments) {
    StringBuilder comment = new StringBuilder();
    for(Token token : comments) {
      String text = token.getText();
      if (text.startsWith("/*")) {
        comment.append(text.substring(2, text.length() - 2)).append(System.lineSeparator());
      } else {
        comment.append(text.substring(2));
      }
    }

    Lexer lexer = new JavaLexer(CharStreams.fromString(comment.toString()));
    lexer.removeErrorListeners();
    LexerErrorListener errorListener = new LexerErrorListener();
    lexer.addErrorListener(errorListener);
    Token token = new CommonToken(JavaLexer.EOF, "<EOF>");
    int continuesIdentifier = 0;
    do {
      token = lexer.nextToken();
      if(errorListener.isError() || continuesIdentifier == 2) {
        return false;
      }
      if (AntlrHelper.isIdentifier(token)) {
        ++continuesIdentifier;
      } else if(!AntlrHelper.isWs(token)) {
        continuesIdentifier = 0;
      }
    } while(AntlrHelper.isEOF(token));
    return true;
  }
}
