import java.io.*;
import java.util.*;



public class Main {

    private static int[][] st;
    private static int [] logs;
    private static Set<List<Integer>> permutations;
    private static int index = 0;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        InputReader.OutputWriter out = new InputReader.OutputWriter(outputStream);
        Scanner scanner = new Scanner(System.in);

        double n = in.nextDouble();
        double odd = n%2 == 0 ? (int)n/2 : (int)n/2 + 1;
        out.println(odd/n);
        out.flush();
    }
    private static int dfs(int [] a, int index, int s, int sum) {
        int ss = sum - s;
        int diff = Math.abs(ss - s);
        min = Math.min(min,diff);

        for (int i = index; i < a.length; i++) {
            s+=a[i];
            dfs(a,i+1,s,sum);
            s-=a[i];
        }
        return min;

    }
    static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i<=j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    static long gcd(long a,long b) {
        return b == 0 ? a : gcd(b,a%b);
    }

    private static void permute(int [] a, int l, int r) {
        if(l == r) {
            List<Integer> list = new ArrayList<>();
            for(int i : a) list.add(i);
            permutations.add(list);
        }
        else {
            for (int i = l; i <=r; i++) {
                swap(a,l,i);
                permute(a,l+1,r);
                swap(a,l,i);
            }
        }
    }
    private static void swap(int [] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

}

class InputReader extends BufferedReader {
    StringTokenizer tokenizer;

    public InputReader(InputStream inputStream) {
        super(new InputStreamReader(inputStream), 32768);
    }

    public InputReader(String filename) {
        super(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(readLine());
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
        return tokenizer.nextToken();
    }

    public Integer nextInt(){
        return Integer.valueOf(next());
    }
    public Long nextLong() {
        return  Long.valueOf(next());
    }
    public Double nextDouble() {
        return Double.valueOf(next());
    }
    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream outputStream) {
            super(outputStream);
        }

        public OutputWriter(Writer writer) {
            super(writer);
        }

        public OutputWriter(String filename) throws FileNotFoundException {
            super(filename);
        }

        public void close() {
            super.close();
        }
    }
}