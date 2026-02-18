final class Main
{
    private static void main$3231c38a() {
        final FastScanner fastScanner = new FastScanner();
        try (final PrintWriter printWriter = new PrintWriter(System.out)) {
            final Solver solver;
            final int nextInt = (solver = new Solver(fastScanner, printWriter)).sc.nextInt();
            final int nextInt2 = solver.sc.nextInt();
            final HashSet set = new HashSet();
            for (int i = 0; i < nextInt2; ++i) {
                set.add(solver.sc.nextInt());
            }
            int n = 0;
            int n2 = 1;
            while (true) {
                if (n2 != 0) {
                    if (!set.contains(nextInt - n)) {
                        solver.writer.println(nextInt - n);
                        break;
                    }
                    n2 = 0;
                }
                else {
                    if (!set.contains(nextInt + n)) {
                        solver.writer.println(nextInt + n);
                        break;
                    }
                    ++n;
                    n2 = 1;
                }
            }
            printWriter.flush();
        }
    }
    
    static final class Solver
    {
        final FastScanner sc;
        final PrintWriter writer;
        
        Solver(final FastScanner sc, final PrintWriter writer) {
            this.sc = sc;
            this.writer = writer;
        }
        
        private void run() {
            final int nextInt = this.sc.nextInt();
            final int nextInt2 = this.sc.nextInt();
            final HashSet set = new HashSet();
            for (int i = 0; i < nextInt2; ++i) {
                set.add(this.sc.nextInt());
            }
            int n = 0;
            int n2 = 1;
            while (true) {
                if (n2 != 0) {
                    if (!set.contains(nextInt - n)) {
                        this.writer.println(nextInt - n);
                        return;
                    }
                    n2 = 0;
                }
                else {
                    if (!set.contains(nextInt + n)) {
                        this.writer.println(nextInt + n);
                        return;
                    }
                    ++n;
                    n2 = 1;
                }
            }
        }
    }
    
    static final class FastScanner
    {
        private final InputStream in;
        private final byte[] buffer;
        private int ptr;
        private int buflen;
        
        public FastScanner() {
            this.in = System.in;
            this.buffer = new byte[1024];
            this.ptr = 0;
            this.buflen = 0;
        }
        
        private boolean hasNextByte() {
            if (this.ptr < this.buflen) {
                return true;
            }
            this.ptr = 0;
            try {
                this.buflen = this.in.read(this.buffer);
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return this.buflen > 0;
        }
        
        private int readByte() {
            if (this.hasNextByte()) {
                return this.buffer[this.ptr++];
            }
            return -1;
        }
        
        private static boolean isPrintableChar(final int n) {
            return 33 <= n && n <= 126;
        }
        
        private boolean hasNext() {
            while (this.hasNextByte() && !isPrintableChar(this.buffer[this.ptr])) {
                ++this.ptr;
            }
            return this.hasNextByte();
        }
        
        private String next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            final StringBuilder sb = new StringBuilder();
            for (int codePoint = this.readByte(); isPrintableChar(codePoint); codePoint = this.readByte()) {
                sb.appendCodePoint(codePoint);
            }
            return sb.toString();
        }
        
        private long nextLong() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            long n = 0L;
            boolean b = false;
            int n2;
            if ((n2 = this.readByte()) == 45) {
                b = true;
                n2 = this.readByte();
            }
            if (n2 < 48 || 57 < n2) {
                throw new NumberFormatException();
            }
            while (48 <= n2 && n2 <= 57) {
                n = n * 10L + (n2 - 48);
                n2 = this.readByte();
            }
            if (n2 != -1 && isPrintableChar(n2)) {
                throw new NumberFormatException();
            }
            if (b) {
                return -n;
            }
            return n;
        }
        
        public final int nextInt() {
            final long nextLong;
            if ((nextLong = this.nextLong()) < -2147483648L || nextLong > 2147483647L) {
                throw new NumberFormatException();
            }
            return (int)nextLong;
        }
        
        private double nextDouble() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            final StringBuilder sb = new StringBuilder();
            for (int codePoint = this.readByte(); isPrintableChar(codePoint); codePoint = this.readByte()) {
                sb.appendCodePoint(codePoint);
            }
            return Double.parseDouble(sb.toString());
        }
        
        private int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextInt();
            }
            return array;
        }
        
        private long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nextLong();
            }
            return array;
        }
    }
}