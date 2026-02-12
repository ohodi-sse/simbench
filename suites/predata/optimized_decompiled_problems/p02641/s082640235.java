import java.util.ArrayList;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.io.OutputStream;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final OutputWriter outputWriter = new OutputWriter(out);
        final CForbiddenList list = new CForbiddenList();
        final InputReader inputReader2 = inputReader;
        final OutputWriter outputWriter2 = outputWriter;
        final InputReader inputReader3 = inputReader2;
        final CForbiddenList list2 = list;
        final int nextInt = inputReader3.nextInt();
        final int nextInt2 = inputReader3.nextInt();
        int n = list2.IINF;
        int n2 = 0;
        final HashSet set = new HashSet(inputReader3.nextIntArrayList$60dab9ef(nextInt2));
        for (int i = 0; i <= 101; ++i) {
            if (!set.contains(i) && n > Math.abs(nextInt - i)) {
                n2 = i;
                n = Math.abs(nextInt - i);
            }
        }
        outputWriter2.writer.println((long)n2);
        outputWriter.writer.close();
    }
    
    static final class CForbiddenList
    {
        int IINF;
        
        CForbiddenList() {
            this.IINF = 1000000331;
        }
        
        private void solve$6e5309c7(InputReader inputReader, final OutputWriter outputWriter) {
            final int nextInt = inputReader.nextInt();
            final int nextInt2 = inputReader.nextInt();
            int n = this.IINF;
            int n2 = 0;
            final InputReader inputReader2 = inputReader;
            final int n3 = nextInt2;
            inputReader = inputReader2;
            final HashSet set = new HashSet(inputReader2.nextIntArrayList$60dab9ef(n3));
            for (int i = 0; i <= 101; ++i) {
                if (!set.contains(i) && n > Math.abs(nextInt - i)) {
                    n2 = i;
                    n = Math.abs(nextInt - i);
                }
            }
            outputWriter.writer.println((long)n2);
        }
    }
    
    static final class OutputWriter
    {
        final PrintWriter writer;
        
        public OutputWriter(final OutputStream out) {
            this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));
        }
        
        private OutputWriter(final Writer out) {
            this.writer = new PrintWriter(out);
        }
        
        private void close() {
            this.writer.close();
        }
        
        public final void println(final long x) {
            this.writer.println(x);
        }
    }
    
    static final class InputReader
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
        
        private int read() {
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
        
        public final int nextInt() {
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
        
        private boolean isSpaceChar(final int n) {
            final SpaceCharFilter filter = this.filter;
            return isWhitespace(n);
        }
        
        private static boolean isWhitespace(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        public final ArrayList<Integer> nextIntArrayList(final int n) {
            return this.nextIntArrayList$60dab9ef(n);
        }
        
        public final ArrayList<Integer> nextIntArrayList$60dab9ef(final int initialCapacity) {
            final ArrayList list = new ArrayList(initialCapacity);
            for (int i = 0; i < initialCapacity; ++i) {
                list.add(this.nextInt());
            }
            return list;
        }
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar$134632();
        }
    }
}
