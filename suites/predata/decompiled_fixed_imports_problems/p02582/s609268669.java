import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main
{
    FastScanner in;
    PrintWriter out;
    static final int MOD = 1000000007;
    
    void solve() {
        final String nextStr = this.in.nextStr();
        if (nextStr.equals("RSR")) {
            this.out.println("1");
        }
        else {
            int x = 0;
            for (int i = 0; i < 3; ++i) {
                if (nextStr.charAt(i) == 'R') {
                    ++x;
                }
            }
            this.out.println(x);
        }
    }
    
    public static void main(final String[] array) {
        new Main().m();
    }
    
    private void m() {
        this.in = new FastScanner(System.in);
        this.out = new PrintWriter(System.out);
        this.solve();
        this.out.flush();
        this.in.close();
        this.out.close();
    }
    
    static class FastScanner
    {
        private Reader input;
        
        public FastScanner() {
            this(System.in);
        }
        
        public FastScanner(final InputStream in) {
            this.input = new BufferedReader(new InputStreamReader(in));
        }
        
        public void close() {
            try {
                this.input.close();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
        
        public int nextInt() {
            final long nextLong = this.nextLong();
            if (nextLong < -2147483648L || nextLong > 2147483647L) {
                throw new NumberFormatException();
            }
            return (int)nextLong;
        }
        
        public long nextLong() {
            try {
                int n = 1;
                int n2;
                for (n2 = this.input.read(); (n2 < 48 || 57 < n2) && n2 != 45 && n2 != 43; n2 = this.input.read()) {}
                if (n2 == 45) {
                    n = -1;
                    n2 = this.input.read();
                }
                else if (n2 == 43) {
                    n2 = this.input.read();
                }
                long n3 = n2 - 48;
                while (true) {
                    final int read = this.input.read();
                    if (read < 48 || 57 < read) {
                        break;
                    }
                    n3 = n3 * 10L + (read - 48);
                }
                return n3 * n;
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return -1L;
            }
        }
        
        public double nextDouble() {
            try {
                double n = 1.0;
                int n2;
                for (n2 = this.input.read(); (n2 < 48 || 57 < n2) && n2 != 45 && n2 != 43; n2 = this.input.read()) {}
                if (n2 == 45) {
                    n = -1.0;
                    n2 = this.input.read();
                }
                else if (n2 == 43) {
                    n2 = this.input.read();
                }
                double n3 = n2 - 48;
                int read;
                while (true) {
                    read = this.input.read();
                    if (read < 48 || 57 < read) {
                        break;
                    }
                    n3 = n3 * 10.0 + (read - 48);
                }
                if (read != 46) {
                    return n * n3;
                }
                double n4 = 1.0;
                for (int n5 = this.input.read(); 48 <= n5 && n5 <= 57; n5 = this.input.read()) {
                    n3 = n3 * 10.0 + (n5 - 48);
                    n4 *= 10.0;
                }
                return n * n3 / n4;
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return Double.NaN;
            }
        }
        
        public char nextChar() {
            try {
                int codePoint;
                for (codePoint = this.input.read(); Character.isWhitespace(codePoint); codePoint = this.input.read()) {}
                return (char)codePoint;
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return '\0';
            }
        }
        
        public String nextStr() {
            try {
                final StringBuilder sb = new StringBuilder();
                int n;
                for (n = this.input.read(); Character.isWhitespace(n); n = this.input.read()) {}
                while (n != -1 && !Character.isWhitespace(n)) {
                    sb.append((char)n);
                    n = this.input.read();
                }
                return sb.toString();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return "";
            }
        }
        
        public String nextLine() {
            try {
                final StringBuilder sb = new StringBuilder();
                for (int n = this.input.read(); n != -1 && n != 10; n = this.input.read()) {
                    sb.append((char)n);
                }
                return sb.toString();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return "";
            }
        }
        
        public int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        public int[] nextIntArrayDec(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt() - 1;
            }
            return array;
        }
        
        public int[] nextIntArray1Index(final int n) {
            final int[] array = new int[n + 1];
            for (int i = 0; i < n; ++i) {
                array[i + 1] = this.nextInt();
            }
            return array;
        }
        
        public long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
        
        public long[] nextLongArrayDec(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong() - 1L;
            }
            return array;
        }
        
        public long[] nextLongArray1Index(final int n) {
            final long[] array = new long[n + 1];
            for (int i = 0; i < n; ++i) {
                array[i + 1] = this.nextLong();
            }
            return array;
        }
        
        public double[] nextDoubleArray(final int n) {
            final double[] array = new double[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextDouble();
            }
            return array;
        }
    }
}