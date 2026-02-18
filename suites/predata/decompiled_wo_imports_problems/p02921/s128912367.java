public final class Main
{
    private InputStream is;
    private PrintWriter out;
    private String INPUT;
    private byte[] inbuf;
    private int lenbuf;
    private int ptrbuf;
    
    public Main() {
        this.INPUT = "";
        this.inbuf = new byte[1024];
        this.lenbuf = 0;
        this.ptrbuf = 0;
    }
    
    private void solve() {
        final char[] ns = this.ns(3);
        final char[] ns2 = this.ns(3);
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (ns[i] == ns2[i]) {
                ++x;
            }
        }
        this.out.println(x);
    }
    
    private void run() throws Exception {
        this.is = (this.INPUT.isEmpty() ? System.in : new ByteArrayInputStream(this.INPUT.getBytes()));
        this.out = new PrintWriter(System.out);
        final long currentTimeMillis = System.currentTimeMillis();
        final char[] ns = this.ns(3);
        final char[] ns2 = this.ns(3);
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (ns[i] == ns2[i]) {
                ++x;
            }
        }
        this.out.println(x);
        this.out.flush();
        if (!this.INPUT.isEmpty()) {
            System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - currentTimeMillis + "ms" }));
        }
    }
    
    private static void main$3231c38a() throws Exception {
        final Main main2;
        final Main main = main2 = new Main();
        main.is = (main.INPUT.isEmpty() ? System.in : new ByteArrayInputStream(main2.INPUT.getBytes()));
        main2.out = new PrintWriter(System.out);
        final long currentTimeMillis = System.currentTimeMillis();
        final Main main3;
        final char[] ns = (main3 = main2).ns(3);
        final char[] ns2 = main3.ns(3);
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (ns[i] == ns2[i]) {
                ++x;
            }
        }
        main3.out.println(x);
        main2.out.flush();
        if (!main2.INPUT.isEmpty()) {
            System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - currentTimeMillis + "ms" }));
        }
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
    
    private int skip() {
        int byte1;
        while ((byte1 = this.readByte()) != -1 && isSpaceChar(byte1)) {}
        return byte1;
    }
    
    private double nd() {
        return Double.parseDouble(this.ns());
    }
    
    private float nf() {
        return Float.parseFloat(this.ns());
    }
    
    private char nc() {
        return (char)this.skip();
    }
    
    private String ns() {
        int codePoint = this.skip();
        final StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(codePoint)) {
            sb.appendCodePoint(codePoint);
            codePoint = this.readByte();
        }
        return sb.toString();
    }
    
    private char[] ns(final int n) {
        char[] original;
        int n2;
        int newLength;
        for (original = new char[n], n2 = this.skip(), newLength = 0; newLength < n && !isSpaceChar(n2); original[newLength++] = (char)n2, n2 = this.readByte()) {}
        if (n == newLength) {
            return original;
        }
        return Arrays.copyOf(original, newLength);
    }
    
    private char[][] nm(final int n, final int n2) {
        final char[][] array = new char[n][];
        for (int i = 0; i < n; ++i) {
            array[i] = this.ns(n2);
        }
        return array;
    }
    
    private int[] na(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            final int[] array2 = array;
            final int n2 = i;
            int n3 = 0;
            boolean b = false;
            int n4;
            while ((n4 = this.readByte()) != -1 && (n4 < 48 || n4 > 57) && n4 != 45) {}
            if (n4 == 45) {
                b = true;
                n4 = this.readByte();
            }
            while (n4 >= 48 && n4 <= 57) {
                n3 = n3 * 10 + (n4 - 48);
                n4 = this.readByte();
            }
            array2[n2] = (b ? (-n3) : n3);
        }
        return array;
    }
    
    private int ni() {
        int n = 0;
        boolean b = false;
        int n2;
        while ((n2 = this.readByte()) != -1 && (n2 < 48 || n2 > 57) && n2 != 45) {}
        if (n2 == 45) {
            b = true;
            n2 = this.readByte();
        }
        while (n2 >= 48 && n2 <= 57) {
            n = n * 10 + (n2 - 48);
            n2 = this.readByte();
        }
        if (b) {
            return -n;
        }
        return n;
    }
    
    private long nl() {
        long n = 0L;
        boolean b = false;
        int n2;
        while ((n2 = this.readByte()) != -1 && (n2 < 48 || n2 > 57) && n2 != 45) {}
        if (n2 == 45) {
            b = true;
            n2 = this.readByte();
        }
        while (n2 >= 48 && n2 <= 57) {
            n = n * 10L + (n2 - 48);
            n2 = this.readByte();
        }
        if (b) {
            return -n;
        }
        return n;
    }
    
    private static void tr(final Object... a) {
        System.out.println(Arrays.deepToString(a));
    }
}