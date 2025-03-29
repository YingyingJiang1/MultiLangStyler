package org.example.experiment;

import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.dom4j.DocumentException;
import org.example.controller.StylerContainer;
import org.example.controller.Applicator;
import org.example.controller.Extractor;
import org.example.controller.Preprocessor;
import org.example.global.GlobalInfo;
import org.example.io.StyleFileIO;
import org.example.myException.ApplyException;
import org.example.myException.ExtractException;
import org.example.parser.common.MyParser;
import org.example.parser.common.factory.MyParserFactory;
import org.example.style.ProgramStyle;
import org.example.style.SelfStyleManager;
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
        try {
            ProgramStyle selfStyle = extractSelf();
            SelfStyleManager.addStyle(null, selfStyle); // for falling back when style missing
            Preprocessor preprocessor = new Preprocessor();
            List<Token> tokens = Applicator.applyRules(parser, container, preprocessor);
            tokens.removeIf(token -> token.getType() == parser.getEOF());
            preprocessor.restoreState(tokens, parser);
            StringBuilder mutant = new StringBuilder();
            for (Token token : tokens) {
                mutant.append(token.getText());
            }
            return mutant.toString();
        } catch (ExtractException e) {
            logger.error("Failed to extract rules from the input code.");
            return null;
        } catch (ApplyException e) {
            logger.error("Failed to apply rules.");
            return null;
        }
    }

    private ProgramStyle extractSelf() throws ExtractException {
        Preprocessor preprocessor = new Preprocessor();
        StylerContainer selfContainer = new StylerContainer();
        Extractor.extractRules(parser, selfContainer, preprocessor);
        ProgramStyle selfStyle = new ProgramStyle();
        for (Styler styler : selfContainer.getStylers()) {
            styler.extractFinalize();
            selfStyle.add(styler.getStyle());
        }
        return selfStyle;
    }

    public static void main(String[] args) {
        Mutator mutator = Mutator.createMutator("java", "/home/fantasia/playground/research/samples/ref.xml");
        if (mutator == null) {
            return;
        }
        final List<String> snippets = List.of(
                "import java.util.*;\nimport java.io.*;\npublic class EdE {\n\n\tpublic static void main(String[] args) throws Exception{\n\t\tlong num = 1000000007;\n\n\t\t// TODO Auto-generated method stub\n \t\tBufferedReader bf = new BufferedReader(new InputStreamReader(System.in));\n \t\tPrintWriter out = new PrintWriter(System.out);\n \t\tint n = Integer.parseInt(bf.readLine());\n \t\tlong[] dp = new long[n+1];\n \t\tint[] isPrime = new int[n+1];\n\t\tArrays.fill(isPrime, 1);\n\t\tint[] mu = new int[n+1];\n\t\tArrays.fill(mu,  1);\n\t\tfor(int i = 2;i<=n;i++){\n\t\t\tif (isPrime[i] == 1){\n\t\t\t\tfor(int j = i;j<=n;j+=i){\n\t\t\t\t\tif (j > i)\n\t\t\t\t\t\tisPrime[j] = 0;\n\t\t\t\t\tif (j%(i*i) == 0)\n\t\t\t\t\t\tmu[j] = 0;\n\t\t\t\t\tmu[j] = -mu[j];\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tlong sum = 0;\n\t\tfor(int i = 2;i<=n;i++){\n\t\t\tsum+=(((long)(0-mu[i])*((((long)(n/i))*power(n-n/i, num-2, num))%num))%num+num)%num;\n\t\t\tsum%=num;\n\t\t\t\n\t\t}\n\t\tsum+=1;\n\t\tsum%=num;\n \t\tout.println(sum);\n\t \t\t\n \t\tout.close();\n \t\t\n \t\t\n \t\t\n \t}\n\tpublic static long power(long x, long y, long mod){\n\t\tlong ans = 1;\n\t\twhile(y>0){\n\t\t\tif (y%2==1)\n\t\t\t\tans = (ans*x)%mod;\n\t\t\tx = (x*x)%mod;\n\t\t\ty/=2;\n\t\t}\n\t\treturn ans;\n\t}\n}\n \t\n \n//StringJoiner sj = new StringJoiner(\" \"); \n//sj.add(strings)\n//sj.toString() gives string of those stuff w spaces or whatever that sequence is\n\n \t\t\n \t\t\n \t\t\n \t\t\n\t\n\n",
                "import java.util.*;\nimport java.io.*;\n\npublic class tr0 {\n\tstatic PrintWriter out;\n\tstatic StringBuilder sb;\n\tstatic final double EPS = 1e-9;\n\tstatic long mod = (int) 1e9 + 7;\n\tstatic int inf = (int) 1e9 + 2;\n\tstatic long[] fac;\n\tstatic int[] si;\n\tstatic ArrayList<Integer> primes;\n\tstatic TreeSet<Integer>[] ad;\n\tstatic ArrayList<pair>[] d;\n\tstatic edge[] ed;\n\tstatic boolean f;\n\tstatic int n,p;\n\tstatic int[]l,ch;\n\tstatic Boolean [][]memo;\n\tstatic Queue<Integer>[] can;\n\t\n\tpublic static void main(String[] args) throws Exception {\n\t\tScanner sc = new Scanner(System.in);\n\t\tout = new PrintWriter(System.out);\n\t    String s=sc.next();\n\t    boolean is=false;\n\t    int t=s.length();\n\t    for(int i=1;i<s.length();i++)\n\t    \tif(s.charAt(i)==\'1\')\n\t    \t\tis=true;\n\t    if(is) {\n\t    \tout.print(t/2+t%2);\n\t    }\n\t    else {\n\t    \tt--;\n\t    \tout.print(t/2+t%2);\n\t    }\n\t\tout.close();\n\t}\n   \t// 1-based DS, OOP\n\tstatic class SegmentTree {\n\t\tint N; // the number of elements in the array as a power of 2 (i.e. after padding)\n\t\tint[] array, sTree, lazy;\n\t\tboolean[] isLeaf;\n\n\t\tSegmentTree(int[] in) {\n\t\t\tarray = in;\n\t\t\tN = in.length - 1;\n\t\t\tsTree = new int[N << 1]; // no. of nodes = 2*N - 1, we add one to cross out index zero\n\t\t\tlazy = new int[N << 1];\n\t\t\tisLeaf = new boolean[N << 1];\n\t\t\tArrays.fill(lazy, -1);\n\t\t\tbuild(1, 1, N);\n\t\t}\n\n\t\tvoid build(int node, int b, int e) // O(n)\n\t\t{\n\t\t\tif (b == e) {\n\t\t\t\tsTree[node] = array[b];\n\t\t\t\tisLeaf[node] = true;\n\t\t\t} else {\n\t\t\t\tint mid = b + e >> 1;\n\t\t\t\tbuild(node << 1, b, mid);\n\t\t\t\tbuild(node << 1 | 1, mid + 1, e);\n\t\t\t\tsTree[node] = (sTree[node << 1] + sTree[node << 1 | 1]) % 2010;\n\t\t\t}\n\t\t}\n\n\t\tvoid update_point(int index, int val) // O(log n)\n\t\t{\n\t\t\tindex += N - 1;\n\t\t\tsTree[index] += val;\n\t\t\twhile (index > 1) {\n\t\t\t\tindex >>= 1;\n\t\t\t\tsTree[index] = sTree[index << 1] + sTree[index << 1 | 1];\n\t\t\t}\n\t\t}\n\n\t\tvoid update_range(int i, int j, int val) // O(log n)\n\t\t{\n\t\t\tupdate_range(1, 1, N, i, j, val);\n\t\t}\n\n\t\tvoid update_range(int node, int b, int e, int i, int j, int val) {\n\t\t\tif (i > e || j < b)\n\t\t\t\treturn;\n\t\t\tif (b >= i && e <= j) {\n\t\t\t\tif (b == e) {\n\t\t\t\t\tsTree[node] = (sTree[node] * sTree[node]) % 2010;\n\t\t\t\t} else {\n\t\t\t\t\tsTree[node] = ((sTree[node] * sTree[node]) % 2010\n\t\t\t\t\t\t\t- (sTree[node << 1] * sTree[node << 1 | 1] * 2) % 2010 + 2010) % 2010;\n\t\t\t\t\tlazy[node] = 1;\n\t\t\t\t}\n\t\t\t} else {\n\t\t\t\tint mid = b + e >> 1;\n\t\t\t\tpropagate(node, b, mid, e);\n\t\t\t\tupdate_range(node << 1, b, mid, i, j, val);\n\t\t\t\tupdate_range(node << 1 | 1, mid + 1, e, i, j, val);\n\t\t\t\tsTree[node] = (sTree[node << 1] + sTree[node << 1 | 1]) % 2010;\n\t\t\t}\n\t\t}\n\n\t\tvoid propagate(int node, int b, int mid, int e) {\n\t\t\tif (lazy[node] == 1) {\n\t\t\t\tlazy[node << 1] = lazy[node];\n\t\t\t\tlazy[node << 1 | 1] = lazy[node];\n\t\t\t\tif (isLeaf[node << 1])\n\t\t\t\t\tsTree[node << 1] = sTree[node << 1] * sTree[node << 1] % 2010;\n\t\t\t\telse\n\t\t\t\t\tsTree[node << 1] = ((sTree[node << 1] * sTree[node << 1]) % 2010\n\t\t\t\t\t\t\t- (sTree[(node << 1) << 1] * sTree[(node << 1) << 1 | 1] * 2) % 2010 + 2010) % 2010;\n\t\t\t\tif (isLeaf[node << 1 | 1])\n\t\t\t\t\tsTree[node << 1 | 1] = sTree[node << 1 | 1] * sTree[node << 1 | 1] % 2010;\n\t\t\t\telse\n\t\t\t\t\tsTree[node << 1 | 1] = ((sTree[node << 1 | 1] * sTree[node << 1 | 1]) % 2010\n\t\t\t\t\t\t\t- (sTree[(node << 1 | 1) << 1] * sTree[(node << 1 | 1) << 1 | 1] * 2) % 2010 + 2010) % 2010;\n\t\t\t\tlazy[node] = -1;\n\t\t\t}\n\t\t}\n\n\t\tint query(int i, int j) {\n\t\t\treturn query(1, 1, N, i, j);\n\t\t}\n\n\t\tint query(int node, int b, int e, int i, int j) // O(log n)\n\t\t{\n\t\t\tif (i > e || j < b)\n\t\t\t\treturn 0;\n\t\t\tif (b >= i && e <= j)\n\t\t\t\treturn sTree[node];\n\t\t\tint mid = b + e >> 1;\n\t\t\tpropagate(node, b, mid, e);\n\t\t\tint q1 = query(node << 1, b, mid, i, j);\n\t\t\tint q2 = query(node << 1 | 1, mid + 1, e, i, j);\n\t\t\treturn (q1 + q2) % 2010;\n\n\t\t}\n\n\t}\n\n\tstatic Queue<Integer> k, k1;\n\tstatic boolean hg = false;\n\n\tstatic class Edge implements Comparable<Edge> {\n\t\tint node, cost;\n\n\t\tEdge(int a, int b) {\n\t\t\tnode = a;\n\t\t\tcost = b;\n\t\t}\n\n\t\tpublic int compareTo(Edge e) {\n\t\t\treturn cost - e.cost;\n\t\t}\n\t}\n\n\tstatic void ifCan(int i) {\n\t\tif (i == 6) {\n\t\t\thg = true;\n\t\t\tfor (int j : k)\n\t\t\t\tk1.add(j);\n\t\t\treturn;\n\t\t} else if (k.contains(i))\n\t\t\tifCan(i + 1);\n\t\telse {\n\t\t\tif (!hg) {\n\t\t\t\tfor (int p : can[i]) {\n\t\t\t\t\tif (!k.contains(p)) {\n\t\t\t\t\t\tk.add(i);\n\t\t\t\t\t\tk.add(p);\n\t\t\t\t\t\tifCan(i + 1);\n\t\t\t\t\t\tk.remove(i);\n\t\t\t\t\t\tk.remove(p);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\tstatic class qu implements Comparable<qu> {\n\t\tint a;\n\t\tint b;\n\n\t\tqu(int a, int b) {\n\t\t\tthis.a = a;\n\t\t\tthis.b = b;\n\t\t}\n\n\t\tpublic String toString() {\n\t\t\treturn a + \" \" + b;\n\t\t}\n\n\t\t@Override\n\t\tpublic int compareTo(qu o) {\n\t\t\treturn b - o.b;\n\t\t}\n\t}\n\n\tstatic class pair {\n\t\tint to;\n\t\tint number;\n\n\t\tpair(int t, int n) {\n\t\t\tnumber = n;\n\t\t\tto = t;\n\t\t}\n\n\t\tpublic String toString() {\n\t\t\treturn to + \" \" + number;\n\t\t}\n\t}\n\n\tstatic boolean[] in;\n\n\t/*\n\t * static void mst() { Arrays.sort(ed); UnionFind uf=new UnionFind(n); for(int\n\t * i=0;i<m;i++) { edge w=ed[i]; if(!uf.union(w.from, w.to)) continue;\n\t * in[i]=true; } }\n\t */\n\tstatic class edge implements Comparable<edge> {\n\t\tint from;\n\t\tint to;\n\t\tint number;\n\n\t\tedge(int f, int t, int n) {\n\t\t\tfrom = f;\n\t\t\tto = t;\n\t\t\tnumber = n;\n\t\t}\n\n\t\tpublic String toString() {\n\t\t\treturn from + \" \" + to + \" \" + number;\n\t\t}\n\n\t\tpublic int compareTo(edge f) {\n\t\t\treturn number - f.number;\n\t\t}\n\t}\n\n\tstatic class seg implements Comparable<seg> {\n\t\tint a;\n\t\tint b;\n\n\t\tseg(int s, int e) {\n\t\t\ta = s;\n\t\t\tb = e;\n\t\t}\n\n\t\tpublic String toString() {\n\t\t\treturn a + \" \" + b;\n\t\t}\n\n\t\tpublic int compareTo(seg o) {\n\t\t\t// if(a==o.a)\n\t\t\treturn o.b - b;\n\t\t\t// return\n\t\t}\n\t}\n\n\tstatic long power(int i) {\n\t\t// if(i==0)\n\t\t// return 1;\n\t\tlong a = 1;\n\t\tfor (int k = 0; k < i; k++)\n\t\t\ta *= i;\n\t\treturn a;\n\t}\n\n\tstatic void seive() {\n\t\tsi = new int[1000001];\n\t\tprimes = new ArrayList<>();\n\t\tint N = 1000001;\n\t\tsi[1] = 1;\n\t\tfor (int i = 2; i < N; i++) {\n\t\t\tif (si[i] == 0) {\n\t\t\t\tsi[i] = i;\n\t\t\t\tprimes.add(i);\n\t\t\t}\n\t\t\tfor (int j = 0; j < primes.size() && primes.get(j) <= si[i] && (i * primes.get(j)) < N; j++)\n\t\t\t\tsi[primes.get(j) * i] = primes.get(j);\n\n\t\t}\n\t}\n\n\tstatic long inver(long x) {\n\t\tint a = (int) x;\n\t\tlong e = (mod - 2);\n\t\tlong res = 1;\n\t\twhile (e > 0) {\n\t\t\tif ((e & 1) == 1) {\n\t\t\t\t// System.out.println(res*a);\n\t\t\t\tres = (int) ((1l * res * a) % mod);\n\t\t\t}\n\t\t\ta = (int) ((1l * a * a) % mod);\n\t\t\te >>= 1;\n\t\t}\n\t\t// out.println(res+\" \"+x);\n\t\treturn res % mod;\n\t}\n\n\tstatic long fac(int n) {\n\t\tif (n == 0)\n\t\t\treturn fac[n] = 1;\n\t\tif (n == 1)\n\t\t\treturn fac[n] = 1;\n\t\tlong ans = 1;\n\t\tfor (int i = 1; i <= n; i++)\n\t\t\tfac[i] = ans = (i % mod * ans % mod) % mod;\n\t\treturn ans % mod;\n\t}\n\n\tstatic long gcd(long a, long b) {\n\n\t\tif (b == 0)\n\t\t\treturn a;\n\t\treturn gcd(b, a % b);\n\t}\n\n\tstatic class unionfind {\n\t\tint[] p;\n\t\tint[] size;\n\n\t\tunionfind(int n) {\n\t\t\tp = new int[n];\n\t\t\tsize = new int[n];\n\n\t\t\tfor (int i = 0; i < n; i++) {\n\t\t\t\tp[i] = i;\n\t\t\t}\n\t\t\tArrays.fill(size, 1);\n\t\t}\n\n\t\tint findSet(int v) {\n\t\t\tif (v == p[v])\n\t\t\t\treturn v;\n\t\t\treturn p[v] = findSet(p[v]);\n\t\t}\n\n\t\tboolean sameSet(int a, int b) {\n\t\t\ta = findSet(a);\n\t\t\tb = findSet(b);\n\t\t\tif (a == b)\n\t\t\t\treturn true;\n\t\t\treturn false;\n\t\t}\n\n\t\tint max() {\n\t\t\tint max = 0;\n\t\t\tfor (int i = 0; i < size.length; i++)\n\t\t\t\tif (size[i] > max)\n\t\t\t\t\tmax = size[i];\n\t\t\treturn max;\n\t\t}\n\n\t\tboolean combine(int a, int b) {\n\t\t\ta = findSet(a);\n\t\t\tb = findSet(b);\n\t\t\tif (a == b)\n\t\t\t\treturn true;\n\t\t\tif (size[a] > size[b]) {\n\t\t\t\tp[b] = a;\n\t\t\t\tsize[a] += size[b];\n\n\t\t\t} else {\n\t\t\t\tp[a] = b;\n\t\t\t\tsize[b] += size[a];\n\t\t\t}\n\t\t\treturn false;\n\t\t}\n\t}\n\n\tstatic class Scanner {\n\t\tStringTokenizer st;\n\t\tBufferedReader br;\n\n\t\tpublic Scanner(InputStream system) {\n\t\t\tbr = new BufferedReader(new InputStreamReader(system));\n\t\t}\n\n\t\tpublic Scanner(String file) throws Exception {\n\t\t\tbr = new BufferedReader(new FileReader(file));\n\t\t}\n\n\t\tpublic String next() throws IOException {\n\t\t\twhile (st == null || !st.hasMoreTokens())\n\t\t\t\tst = new StringTokenizer(br.readLine());\n\t\t\treturn st.nextToken();\n\t\t}\n\n\t\tpublic String nextLine() throws IOException {\n\t\t\treturn br.readLine();\n\t\t}\n\n\t\tpublic int nextInt() throws IOException {\n\t\t\treturn Integer.parseInt(next());\n\t\t}\n\n\t\tpublic double nextDouble() throws IOException {\n\t\t\treturn Double.parseDouble(next());\n\t\t}\n\n\t\tpublic char nextChar() throws IOException {\n\t\t\treturn next().charAt(0);\n\t\t}\n\n\t\tpublic Long nextLong() throws IOException {\n\t\t\treturn Long.parseLong(next());\n\t\t}\n\n\t\tpublic boolean ready() throws IOException {\n\t\t\treturn br.ready();\n\t\t}\n\n\t\tpublic void waitForInput() throws InterruptedException {\n\t\t\tThread.sleep(3000);\n\t\t}\n\t}\n}",
                "public class Foo {\n    public static void main(String[] args) {\n        bar();\n    }\n\n    private static boolean bar() {\n        return true;\n    }\n}\n");
        String mutant = mutator.apply(snippets.get(1));
        System.out.println(mutant);
    }
}
