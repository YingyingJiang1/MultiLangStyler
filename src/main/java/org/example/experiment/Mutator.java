package org.example.experiment;

import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.dom4j.DocumentException;
import org.example.controller.StylerContainer;
import org.example.controller.Applicator;
import org.example.controller.Preprocessor;
import org.example.global.GlobalInfo;
import org.example.io.StyleFileIO;
import org.example.myException.ApplyException;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.ProgramStyle;
import org.example.style.Style;
import org.example.styler.Styler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mutator {
    private final Logger logger = LoggerFactory.getLogger(Mutator.class);
    private final StylerContainer container = new StylerContainer();
    private final MyParser parser;

    private Mutator(String language) {
        this.parser = MyParserFactory.createParser(language);
    }

    public static Mutator createMutator(String language, String path) {
        var mutator = new Mutator(language);
        try {
            ProgramStyle programStyle = StyleFileIO.read(path, mutator.parser);
            for (Styler styler : mutator.container.getStylers()) {
                Style style = programStyle.getStyle(styler.getStyle().getStyleName());
                if (style != null) {
                    styler.setStyle(style);
                }
            }
            GlobalInfo.setLanguage(language);
            return mutator;
        } catch (DocumentException e) {
            mutator.logger.error("Failed to read style from {}.", path);
            return null;
        }
    }

    public String apply(String snippet) {
        ParseTree tree = parser.parseFromString(snippet);
        if (tree == null) {
            logger.info("Compilation error.");
            return null;
        }
        Preprocessor preprocessor = new Preprocessor();
        try {
            List<Token> tokens = Applicator.applyRules(parser, container, preprocessor);
            tokens.removeIf(token -> token.getType() == parser.getEOF());
            preprocessor.restoreState(tokens, parser);
            StringBuilder mutant = new StringBuilder();
            for (Token token : tokens) {
                mutant.append(token.getText());
            }
            return mutant.toString();
        } catch (ApplyException e) {
            logger.error("Failed to apply rules.");
            return null;
        }
    }

    public static void main(String[] args) {
        Mutator mutator = Mutator.createMutator("java", "/home/fantasia/playground/research/samples/ref.xml");
        if (mutator == null) {
            return;
        }
        final List<String> snippets = List.of(
                "import java.util.*;\nimport java.io.*;\npublic class EdE {\n\n\tpublic static void main(String[] args) throws Exception{\n\t\tlong num = 1000000007;\n\n\t\t// TODO Auto-generated method stub\n \t\tBufferedReader bf = new BufferedReader(new InputStreamReader(System.in));\n \t\tPrintWriter out = new PrintWriter(System.out);\n \t\tint n = Integer.parseInt(bf.readLine());\n \t\tlong[] dp = new long[n+1];\n \t\tint[] isPrime = new int[n+1];\n\t\tArrays.fill(isPrime, 1);\n\t\tint[] mu = new int[n+1];\n\t\tArrays.fill(mu,  1);\n\t\tfor(int i = 2;i<=n;i++){\n\t\t\tif (isPrime[i] == 1){\n\t\t\t\tfor(int j = i;j<=n;j+=i){\n\t\t\t\t\tif (j > i)\n\t\t\t\t\t\tisPrime[j] = 0;\n\t\t\t\t\tif (j%(i*i) == 0)\n\t\t\t\t\t\tmu[j] = 0;\n\t\t\t\t\tmu[j] = -mu[j];\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tlong sum = 0;\n\t\tfor(int i = 2;i<=n;i++){\n\t\t\tsum+=(((long)(0-mu[i])*((((long)(n/i))*power(n-n/i, num-2, num))%num))%num+num)%num;\n\t\t\tsum%=num;\n\t\t\t\n\t\t}\n\t\tsum+=1;\n\t\tsum%=num;\n \t\tout.println(sum);\n\t \t\t\n \t\tout.close();\n \t\t\n \t\t\n \t\t\n \t}\n\tpublic static long power(long x, long y, long mod){\n\t\tlong ans = 1;\n\t\twhile(y>0){\n\t\t\tif (y%2==1)\n\t\t\t\tans = (ans*x)%mod;\n\t\t\tx = (x*x)%mod;\n\t\t\ty/=2;\n\t\t}\n\t\treturn ans;\n\t}\n}\n \t\n \n//StringJoiner sj = new StringJoiner(\" \"); \n//sj.add(strings)\n//sj.toString() gives string of those stuff w spaces or whatever that sequence is\n\n \t\t\n \t\t\n \t\t\n \t\t\n\t\n\n",
                "import java.util.*;\nimport java.lang.*;\n\nclass Solution {\n\tpublic int isBored(String S) {\n\t\tString [] sentences = S.split(\"[.?!]\\\\s*\");\n\t\tint count = 0;\n\t\tfor (String sentence : sentences) {\n\t\t\tif (sentence.subSequence(0, 2).equals(\"I \")) {\n\t\t\t\tcount += 1;\n\t\t\t}\n\t\t}\n\t\treturn count;\n\t}\n}\n",
                "public class Foo {\n    public static void main(String[] args) {\n        bar();\n    }\n\n    private static boolean bar() {\n        return true;\n    }\n}\n");
        String mutant = mutator.apply(snippets.get(2));
        System.out.println(mutant);
    }
}
