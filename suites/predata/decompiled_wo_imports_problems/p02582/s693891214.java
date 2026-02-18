public final class Main
{
    private static void main$3231c38a() throws IOException {
        final FastReader fastReader = new FastReader(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String next = fastReader.next();
        int max = 0;
        int n = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
            }
            else {
                max = Math.max(n, max);
                n = 0;
            }
        }
        printWriter.println(Math.max(max, n));
        printWriter.close();
    }
    
    static final class FastReader
    {
        private InputStream is;
        private byte[] inbuf;
        private int lenbuf;
        private int ptrbuf;
        
        public FastReader(final InputStream is) {
            this.inbuf = new byte[1024];
            this.lenbuf = 0;
            this.ptrbuf = 0;
            this.is = is;
        }
        
        private int readByte() {
            if (this.lenbuf == -1) {
                throw new InputMismatchException();
            }
            if (this.ptrbuf >= this.lenbuf) {
                this.ptrbuf = 0;
                try {
                    this.lenbuf = this.is.read(this.inbuf);
                }
                catch (final IOException ex) {
                    throw new InputMismatchException();
                }
                if (this.lenbuf <= 0) {
                    return -1;
                }
            }
            return this.inbuf[this.ptrbuf++];
        }
        
        private static boolean isSpaceChar(final int n) {
            return n < 33 || n > 126;
        }
        
        private static boolean isEndOfLine(final int n) {
            return n == 10 || n == 13 || n == -1;
        }
        
        private int skip() {
            int byte1;
            while ((byte1 = this.readByte()) != -1 && isSpaceChar(byte1)) {}
            return byte1;
        }
        
        public final String next() {
            int codePoint = this.skip();
            final StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(codePoint)) {
                sb.appendCodePoint(codePoint);
                codePoint = this.readByte();
            }
            return sb.toString();
        }
        
        private String nextLine() {
            int codePoint = this.skip();
            final StringBuilder sb = new StringBuilder();
            int n;
            while ((n = codePoint) != 10 && n != 13 && n != -1) {
                sb.appendCodePoint(codePoint);
                codePoint = this.readByte();
            }
            return sb.toString();
        }
        
        private int nextInt() {
            int n = 0;
            boolean b = false;
            int n2;
            while ((n2 = this.readByte()) != -1 && (n2 < 48 || n2 > 57) && n2 != 45) {}
            if (n2 == 45) {
                b = true;
                n2 = this.readByte();
            }
            while (n2 >= 48 && n2 <= 57) {
                n = (n << 3) + (n << 1) + (n2 - 48);
                n2 = this.readByte();
            }
            if (b) {
                return -n;
            }
            return n;
        }
        
        private long nextLong() {
            long n = 0L;
            boolean b = false;
            int n2;
            while ((n2 = this.readByte()) != -1 && (n2 < 48 || n2 > 57) && n2 != 45) {}
            if (n2 == 45) {
                b = true;
                n2 = this.readByte();
            }
            while (n2 >= 48 && n2 <= 57) {
                n = (n << 3) + (n << 1) + (n2 - 48);
                n2 = this.readByte();
            }
            if (b) {
                return -n;
            }
            return n;
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private char[] next(final int n) {
            char[] original;
            int n2;
            int newLength;
            for (original = new char[n], n2 = this.skip(), newLength = 0; newLength < n && !isSpaceChar(n2); original[newLength++] = (char)n2, n2 = this.readByte()) {}
            if (n == newLength) {
                return original;
            }
            return Arrays.copyOf(original, newLength);
        }
        
        private char readChar() {
            return (char)this.skip();
        }
    }
}