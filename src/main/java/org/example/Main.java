package org.example;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

  public static void main(String[] args) throws IOException {
    File file = new File("C:\\Users\\pity\\IdeaProjects\\code-style-transfer\\testProgram\\testName");
    File[] files = file.listFiles();
    System.out.println(files.length);
    
/*    String[] codes = {
        """
if (arg - a == 1) {
      a = 1;
    } else  {
      a = 2;
    }
    }
"""
    };
   for(String code : codes) {
     Lexer lexer = new JavaLexer(CharStreams.fromString(code));
     CommonTokenStream tokenStream = (CommonTokenStream) new CommonTokenStream(lexer);
     JavaParser parser = new JavaParser(tokenStream);
     ParseTree tree = parser.ifElseStmt();
     ParseTreeWalker.DEFAULT.walk(new ExtendParserListener(), tree);
     System.out.
     println(tree.toStringTree(parser));
   }*/

    Pattern pattern = Pattern.compile("(\\$(O|OA|CO|COA))");
    Matcher matcher = pattern.matcher("$C");
    if(matcher.matches()) {
      System.out.println(matcher.group(1));
    }

    /*Configuration conf = new Configuration();
    try {
      conf.loadConf(null);
      new Controller().execute(conf);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }*/
  }
}