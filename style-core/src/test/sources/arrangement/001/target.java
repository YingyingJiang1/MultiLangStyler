import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Tarek
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BMultiplication2 solver = new BMultiplication2();
        solver.solve(1, in, out);
        out.close();
    }

    static class BMultiplication2 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long a[] = new long[n];
            int f = 0;
            long sum2 = (long) Math.pow(10, 18);
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
                if (a[i] == 0) f = 1;
            }
            if (f == 1) out.println("0");
            else {
                int m = 0;
                long sum = 1;
                for (int i = 0; i < n; i++) {
                    if ((sum * a[i]) > sum2) {
                        out.println("-1");
                        return;
                    }
                    if (1000000000000000000L / sum < a[i]) {
                        out.println("-1");
                        return;
                    } else {
                        sum = sum * a[i];
                    }
                }
                out.println(sum);
            }
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

