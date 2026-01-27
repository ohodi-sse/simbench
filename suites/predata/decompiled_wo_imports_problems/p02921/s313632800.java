static class InputReader
{
    private InputStream stream;
    private byte[] buf;
    private int curChar;
    private int numChars;
    
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
}public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final InputReader inputReader = new InputReader(in);
        final OutputWriter outputWriter = new OutputWriter(out);
        new ATenki().solve(1, inputReader, outputWriter);
        outputWriter.close();
    }
    
    static class ATenki
    {
        public void solve(final int n, final InputReader inputReader, final OutputWriter outputWriter) {
            final String line = inputReader.readLine();
            final String line2 = inputReader.readLine();
            int n2 = 0;
            for (int i = 0; i < line.length(); ++i) {
                if (line.charAt(i) == line2.charAt(i)) {
                    ++n2;
                }
            }
            outputWriter.printLine(n2);
        }
    }
    
    static class InputReader
    {
        private InputStream stream;
        private byte[] buf;
        private int curChar;
        private int numChars;
        
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
        
        public void printLine(final int x) {
            this.writer.println(x);
        }
    }
}static class ATenki
{
    public void solve(final int n, final InputReader inputReader, final OutputWriter outputWriter) {
        final String line = inputReader.readLine();
        final String line2 = inputReader.readLine();
        int n2 = 0;
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == line2.charAt(i)) {
                ++n2;
            }
        }
        outputWriter.printLine(n2);
    }
}static class OutputWriter
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
    
    public void printLine(final int x) {
        this.writer.println(x);
    }
}