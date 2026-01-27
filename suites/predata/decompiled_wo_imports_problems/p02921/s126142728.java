static class FastReader
{
    private InputStream stream;
    private byte[] buf;
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
    
    public FastReader(final InputStream stream) {
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
    
    public interface SpaceCharFilter
    {
        boolean isSpaceChar(final int p0);
    }
}public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final FastReader fastReader = new FastReader(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new ATenki().solve(1, fastReader, printWriter);
        printWriter.close();
    }
    
    static class ATenki
    {
        public void solve(final int n, final FastReader fastReader, final PrintWriter printWriter) {
            final String nextString = fastReader.nextString();
            final String nextString2 = fastReader.nextString();
            int x = 0;
            for (int i = 0; i < nextString.length(); ++i) {
                if (nextString.charAt(i) == nextString2.charAt(i)) {
                    ++x;
                }
            }
            printWriter.println(x);
        }
    }
    
    static class FastReader
    {
        private InputStream stream;
        private byte[] buf;
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        
        public FastReader(final InputStream stream) {
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
        
        public interface SpaceCharFilter
        {
            boolean isSpaceChar(final int p0);
        }
    }
}static class ATenki
{
    public void solve(final int n, final FastReader fastReader, final PrintWriter printWriter) {
        final String nextString = fastReader.nextString();
        final String nextString2 = fastReader.nextString();
        int x = 0;
        for (int i = 0; i < nextString.length(); ++i) {
            if (nextString.charAt(i) == nextString2.charAt(i)) {
                ++x;
            }
        }
        printWriter.println(x);
    }
}public interface SpaceCharFilter
{
    boolean isSpaceChar(final int p0);
}