final class AtCoder
{
    final String S;
    final String T;
    
    AtCoder(final FastScanner fastScanner) {
        this.S = fastScanner.next();
        this.T = fastScanner.next();
    }
    
    private void solve(final PrintWriter printWriter) {
        int x = 0;
        for (int i = 0; i < this.S.length(); ++i) {
            if (this.S.charAt(i) == this.T.charAt(i)) {
                ++x;
            }
        }
        printWriter.println(x);
    }
}








final class FastScanner
{
    private final InputStream in;
    private final byte[] buffer;
    private int ptr;
    private int buflen;
    
    FastScanner() {
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
    
    public final String next() {
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
    
    private int nextInt() {
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
        final long n3;
        if ((n3 = (b ? (-n) : n)) < -2147483648L || n3 > 2147483647L) {
            throw new NumberFormatException();
        }
        return (int)n3;
    }
    
    private double nextDouble() {
        return Double.parseDouble(this.next());
    }
}







public final class Main
{
    private static void main$3231c38a() {
        final FastScanner fastScanner = new FastScanner();
        final PrintWriter printWriter = new PrintWriter(System.out);
        final AtCoder atCoder = new AtCoder(fastScanner);
        final PrintWriter printWriter2 = printWriter;
        final AtCoder atCoder2 = atCoder;
        int x = 0;
        for (int i = 0; i < atCoder2.S.length(); ++i) {
            if (atCoder2.S.charAt(i) == atCoder2.T.charAt(i)) {
                ++x;
            }
        }
        printWriter2.println(x);
        printWriter.flush();
    }
}