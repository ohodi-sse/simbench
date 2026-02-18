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
        final FastScanner fastScanner;
        final String next = (fastScanner = new FastScanner()).next();
        final String next2 = fastScanner.next();
        final char[] charArray = next.toCharArray();
        final char[] charArray2 = next2.toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static int kaijo(final int n) {
        int n2 = 1;
        for (int i = 1; i <= n; ++i) {
            n2 <<= 1;
        }
        return n2;
    }
}