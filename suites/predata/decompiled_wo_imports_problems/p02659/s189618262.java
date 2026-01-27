static class InputStreamScanner
{
    private InputStream in;
    private byte[] buf;
    private int len;
    private int off;
    
    InputStreamScanner(final InputStream in) {
        this.buf = new byte[1024];
        this.len = 0;
        this.off = 0;
        this.in = in;
    }
    
    String next() {
        final StringBuilder sb = new StringBuilder();
        for (int codePoint = this.skip(); !this.isSpace(codePoint); codePoint = this.read()) {
            sb.appendCodePoint(codePoint);
        }
        return sb.toString();
    }
    
    int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    long nextLong() {
        return Long.parseLong(this.next());
    }
    
    double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    char nextChar() {
        return (char)this.skip();
    }
    
    int skip() {
        int read;
        while ((read = this.read()) != -1) {
            if (!this.isSpace(read)) {
                return read;
            }
        }
        return -1;
    }
    
    private boolean isSpace(final int n) {
        return n < 33 || n > 126;
    }
    
    private int read() {
        if (this.len == -1) {
            throw new InputMismatchException("End of Input");
        }
        if (this.off >= this.len) {
            this.off = 0;
            try {
                this.len = this.in.read(this.buf);
            }
            catch (final IOException ex) {
                throw new InputMismatchException(ex.getMessage());
            }
            if (this.len <= 0) {
                return -1;
            }
        }
        return this.buf[this.off++];
    }
}public class Main
{
    public static void main(final String[] array) {
        final PrintWriter printWriter = new PrintWriter(System.out);
        new Main().solve(new InputStreamScanner(System.in), printWriter);
        printWriter.flush();
    }
    
    private void solve(final InputStreamScanner inputStreamScanner, final PrintWriter printWriter) {
        printWriter.println(new BigDecimal(inputStreamScanner.next()).multiply(new BigDecimal(inputStreamScanner.next())).setScale(0, RoundingMode.DOWN));
    }
    
    static class InputStreamScanner
    {
        private InputStream in;
        private byte[] buf;
        private int len;
        private int off;
        
        InputStreamScanner(final InputStream in) {
            this.buf = new byte[1024];
            this.len = 0;
            this.off = 0;
            this.in = in;
        }
        
        String next() {
            final StringBuilder sb = new StringBuilder();
            for (int codePoint = this.skip(); !this.isSpace(codePoint); codePoint = this.read()) {
                sb.appendCodePoint(codePoint);
            }
            return sb.toString();
        }
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
        
        double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        char nextChar() {
            return (char)this.skip();
        }
        
        int skip() {
            int read;
            while ((read = this.read()) != -1) {
                if (!this.isSpace(read)) {
                    return read;
                }
            }
            return -1;
        }
        
        private boolean isSpace(final int n) {
            return n < 33 || n > 126;
        }
        
        private int read() {
            if (this.len == -1) {
                throw new InputMismatchException("End of Input");
            }
            if (this.off >= this.len) {
                this.off = 0;
                try {
                    this.len = this.in.read(this.buf);
                }
                catch (final IOException ex) {
                    throw new InputMismatchException(ex.getMessage());
                }
                if (this.len <= 0) {
                    return -1;
                }
            }
            return this.buf[this.off++];
        }
    }
}