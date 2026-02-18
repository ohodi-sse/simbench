public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new CMultiplication3();
        CMultiplication3.solve$6080e082(inputReader, printWriter);
        printWriter.close();
    }
    
    static final class CMultiplication3
    {
        public static void solve$6080e082(final InputReader inputReader, final PrintWriter printWriter) {
            int n;
            for (n = inputReader.read(); inputReader.isSpaceChar(n); n = inputReader.read()) {}
            int n2 = 1;
            if (n == 45) {
                n2 = -1;
                n = inputReader.read();
            }
            long n3 = 0L;
            while (n >= 48 && n <= 57) {
                n3 = n3 * 10L + (n - 48);
                n = inputReader.read();
                if (inputReader.isSpaceChar(n)) {
                    final long n4 = n3 * n2;
                    int n5;
                    for (n5 = inputReader.read(); inputReader.isSpaceChar(n5); n5 = inputReader.read()) {}
                    final StringBuilder sb = new StringBuilder();
                    do {
                        if (Character.isValidCodePoint(n5)) {
                            sb.appendCodePoint(n5);
                        }
                        n5 = inputReader.read();
                    } while (!inputReader.isSpaceChar(n5));
                    final String string = sb.toString();
                    printWriter.println(n4 * Long.parseLong(string.substring(0, 1) + string.substring(2, 4)) / 100L);
                    return;
                }
            }
            throw new InputMismatchException();
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
        
        public final int read() {
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
        
        private long nextLong() {
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
        
        private String nextString() {
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
        
        public final boolean isSpaceChar(final int n) {
            final SpaceCharFilter filter = this.filter;
            return isWhitespace(n);
        }
        
        private static boolean isWhitespace(final int n) {
            return n == 32 || n == 10 || n == 13 || n == 9 || n == -1;
        }
        
        private String next() {
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
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar$134632();
        }
    }
}