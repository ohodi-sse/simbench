import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final FastInput fastInput = new FastInput(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new ABC175A().solve(1, fastInput, printWriter);
        printWriter.close();
    }
    
    static class ABC175A
    {
        public void solve(final int n, final FastInput fastInput, final PrintWriter printWriter) {
            final String next = fastInput.next();
            int b = 0;
            int max = 0;
            for (int i = 0; i < 3; ++i) {
                if (next.charAt(i) == 'R') {
                    ++b;
                    max = Math.max(max, b);
                }
                else {
                    b = 0;
                }
            }
            printWriter.println(max);
        }
    }
    
    static class FastInput
    {
        private final BufferedReader in;
        private String[] buff;
        private int index;
        
        public FastInput(final InputStream in) {
            this.index = 0;
            this.in = new BufferedReader(new InputStreamReader(in));
        }
        
        String nextLine() {
            try {
                return this.in.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }
        
        String next() {
            while (this.buff == null || this.index >= this.buff.length) {
                this.buff = this.nextLine().split(" ");
                this.index = 0;
            }
            return this.buff[this.index++];
        }
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
        
        Double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        BigInteger nextBigInteger() {
            return new BigInteger(this.next());
        }
        
        BigDecimal nextBigDecimal() {
            return new BigDecimal(this.next());
        }
        
        public int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
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
        
        public double[] nextDoubleArray(final int n) {
            final double[] array = new double[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextDouble();
            }
            return array;
        }
        
        public int[][] nextInt2DArray(final int n, final int n2) {
            final int[][] array = new int[n][n2];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n2; ++j) {
                    array[i][j] = this.nextInt();
                }
            }
            return array;
        }
        
        public long[][] nextLong2DArray(final int n, final int n2) {
            final long[][] array = new long[n][n2];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n2; ++j) {
                    array[i][j] = this.nextLong();
                }
            }
            return array;
        }
        
        public char[][] nextChar2DArray(final int n) {
            final char[][] array = new char[n][];
            for (int i = 0; i < n; ++i) {
                array[i] = this.next().toCharArray();
            }
            return array;
        }
    }
}