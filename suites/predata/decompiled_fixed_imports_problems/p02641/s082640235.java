import java.util.ArrayList;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final OutputWriter outputWriter = new OutputWriter(out);
        new CForbiddenList().solve(1, inputReader, outputWriter);
        outputWriter.close();
    }
    
    static class CForbiddenList
    {
        int IINF;
        
        CForbiddenList() {
            this.IINF = 1000000331;
        }
        
        public void solve(final int n, final InputReader inputReader, final OutputWriter outputWriter) {
            final int nextInt = inputReader.nextInt();
            final int nextInt2 = inputReader.nextInt();
            int n2 = this.IINF;
            int n3 = 0;
            final HashSet set = new HashSet(inputReader.nextIntArrayList(nextInt2));
            for (int i = 0; i <= 101; ++i) {
                if (!set.contains(i) && n2 > Math.abs(nextInt - i)) {
                    n3 = i;
                    n2 = Math.abs(nextInt - i);
                }
            }
            outputWriter.println(n3);
        }
    }
    
    static class OutputWriter
    {
        private final PrintWriter writer;
        
        public OutputWriter(final OutputStream out) {
            this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));
        }
        
        public OutputWriter(final Writer out) {
            this.writer = new PrintWriter(out);
        }
        
        public void close() {
            this.writer.close();
        }
        
        public void println(final long x) {
            this.writer.println(x);
        }
    }
    
    static class InputReader
    {
        private InputStream stream;
        private byte[] buf;
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        
        public InputReader(final InputStream stream) {
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
        
        public boolean isSpaceChar(final int n) {
            if (this.filter != null) {
                return this.filter.isSpaceChar(n);
            }
            return isWhitespace(n);
        }
        
        public static boolean isWhitespace(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        public ArrayList<Integer> nextIntArrayList(final int n) {
            return this.nextIntArrayList(n, 0);
        }
        
        public ArrayList<Integer> nextIntArrayList(final int initialCapacity, final int n) {
            final ArrayList list = new ArrayList(initialCapacity);
            for (int i = 0; i < n; ++i) {
                list.add(0);
            }
            for (int j = n; j < initialCapacity; ++j) {
                list.add(this.nextInt());
            }
            return list;
        }
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar(final int p0);
        }
    }
}