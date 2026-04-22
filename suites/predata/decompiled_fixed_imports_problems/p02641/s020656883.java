import java.util.Arrays;
import java.math.BigInteger;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.HashSet;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        final Solver solver = new Solver();
        int n = 1;
        while (n-- != 0) {
            solver.solve(inputReader, printWriter);
        }
        printWriter.close();
    }
    
    static class Solver
    {
        public void solve(final InputReader inputReader, final PrintWriter printWriter) {
            final int nextInt = inputReader.nextInt();
            final int nextInt2 = inputReader.nextInt();
            final HashSet set = new HashSet();
            for (int i = 0; i < nextInt2; ++i) {
                set.add(inputReader.nextInt());
            }
            int n;
            for (n = 0; set.contains(nextInt - n); ++n) {
                if (!set.contains(nextInt + n)) {
                    printWriter.println(nextInt + n);
                    return;
                }
            }
            printWriter.println(nextInt - n);
        }
    }
    
    static class InputReader
    {
        private boolean finished;
        private InputStream stream;
        private byte[] buf;
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        
        public InputReader(final InputStream stream) {
            this.finished = false;
            this.buf = new byte[1024];
            this.stream = stream;
        }
        
        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            }
            if (this.curChar >= this.numChars) {
                this.curChar = 0;
                try {
                    this.numChars = this.stream.read(this.buf);
                }
                catch (final IOException ex) {
                    throw new InputMismatchException();
                }
                if (this.numChars <= 0) {
                    return -1;
                }
            }
            return this.buf[this.curChar++];
        }
        
        public int peek() {
            if (this.numChars == -1) {
                return -1;
            }
            if (this.curChar >= this.numChars) {
                this.curChar = 0;
                try {
                    this.numChars = this.stream.read(this.buf);
                }
                catch (final IOException ex) {
                    return -1;
                }
                if (this.numChars <= 0) {
                    return -1;
                }
            }
            return this.buf[this.curChar];
        }
        
        public int nextInt() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            int n3 = 0;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10 + (n - 48);
                n = this.read();
                if (this.isSpaceChar(n)) {
                    return n3 * n2;
                }
            }
            throw new InputMismatchException();
        }
        
        public long nextLong() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            long n3 = 0L;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10L + (n - 48);
                n = this.read();
                if (this.isSpaceChar(n)) {
                    return n3 * n2;
                }
            }
            throw new InputMismatchException();
        }
        
        public String nextString() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            final StringBuilder sb = new StringBuilder();
            do {
                if (Character.isValidCodePoint(n)) {
                    sb.appendCodePoint(n);
                }
                n = this.read();
            } while (!this.isSpaceChar(n));
            return sb.toString();
        }
        
        public boolean isSpaceChar(final int n) {
            if (this.filter != null) {
                return this.filter.isSpaceChar(n);
            }
            return isWhitespace(n);
        }
        
        public static boolean isWhitespace(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private String readLine0() {
            final StringBuilder sb = new StringBuilder();
            for (int codePoint = this.read(); codePoint != 10 && codePoint != -1; codePoint = this.read()) {
                if (codePoint != 13) {
                    sb.appendCodePoint(codePoint);
                }
            }
            return sb.toString();
        }
        
        public String readLine() {
            String s;
            for (s = this.readLine0(); s.trim().length() == 0; s = this.readLine0()) {}
            return s;
        }
        
        public String readLine(final boolean b) {
            if (b) {
                return this.readLine();
            }
            return this.readLine0();
        }
        
        public BigInteger readBigInteger() {
            try {
                return new BigInteger(this.nextString());
            }
            catch (final NumberFormatException ex) {
                throw new InputMismatchException();
            }
        }
        
        public char nextCharacter() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            return (char)n;
        }
        
        public double nextDouble() {
            int n;
            for (n = this.read(); this.isSpaceChar(n); n = this.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = this.read();
            }
            double n3 = 0.0;
            while (!this.isSpaceChar(n) && n != 46) {
                if (n == 101 || n == 69) {
                    return n3 * Math.pow(10.0, this.nextInt());
                }
                if (n < 48 || n > 57) {
                    throw new InputMismatchException();
                }
                n3 = n3 * 10.0 + (n - 48);
                n = this.read();
            }
            if (n == 46) {
                int n4 = this.read();
                double n5 = 1.0;
                while (!this.isSpaceChar(n4)) {
                    if (n4 == 101 || n4 == 69) {
                        return n3 * Math.pow(10.0, this.nextInt());
                    }
                    if (n4 < 48 || n4 > 57) {
                        throw new InputMismatchException();
                    }
                    n5 /= 10.0;
                    n3 += (n4 - 48) * n5;
                    n4 = this.read();
                }
            }
            return n3 * n2;
        }
        
        public boolean isExhausted() {
            int peek;
            while (this.isSpaceChar(peek = this.peek()) && peek != -1) {
                this.read();
            }
            return peek == -1;
        }
        
        public String next() {
            return this.nextString();
        }
        
        public SpaceCharFilter getFilter() {
            return this.filter;
        }
        
        public void setFilter(final SpaceCharFilter filter) {
            this.filter = filter;
        }
        
        public int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        public int[] nextSortedIntArray(final int n) {
            final int[] nextIntArray = this.nextIntArray(n);
            Arrays.sort(nextIntArray);
            return nextIntArray;
        }
        
        public int[] nextSumIntArray(final int n) {
            final int[] array = new int[n];
            array[0] = this.nextInt();
            for (int i = 1; i < n; ++i) {
                array[i] = array[i - 1] + this.nextInt();
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
        
        public long[] nextSumLongArray(final int n) {
            final long[] array = new long[n];
            array[0] = this.nextInt();
            for (int i = 1; i < n; ++i) {
                array[i] = array[i - 1] + this.nextInt();
            }
            return array;
        }
        
        public long[] nextSortedLongArray(final int n) {
            final long[] nextLongArray = this.nextLongArray(n);
            Arrays.sort(nextLongArray);
            return nextLongArray;
        }
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar(final int p0);
        }
    }
}