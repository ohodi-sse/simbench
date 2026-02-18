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
    
    final int readByte() {
        if (this.hasNextByte()) {
            return this.buffer[this.ptr++];
        }
        return -1;
    }
    
    static boolean isPrintableChar(final int n) {
        return 33 <= n && n <= 126;
    }
    
    public final boolean hasNext() {
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
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        final StringBuilder sb = new StringBuilder();
        for (int codePoint = this.readByte(); isPrintableChar(codePoint); codePoint = this.readByte()) {
            sb.appendCodePoint(codePoint);
        }
        return Double.parseDouble(sb.toString());
    }
}






public final class Main
{
    private static void main$3231c38a() {
        final FastScanner fastScanner;
        if (!(fastScanner = new FastScanner()).hasNext()) {
            throw new NoSuchElementException();
        }
        long n = 0L;
        boolean b = false;
        int n2;
        if ((n2 = fastScanner.readByte()) == 45) {
            b = true;
            n2 = fastScanner.readByte();
        }
        if (n2 < 48 || 57 < n2) {
            throw new NumberFormatException();
        }
        while (48 <= n2 && n2 <= 57) {
            n = n * 10L + (n2 - 48);
            n2 = fastScanner.readByte();
        }
        if (n2 != -1 && FastScanner.isPrintableChar(n2)) {
            throw new NumberFormatException();
        }
        final long n3;
        if ((n3 = (b ? (-n) : n)) < -2147483648L || n3 > 2147483647L) {
            throw new NumberFormatException();
        }
        final int n4 = (int)n3;
        int x = 1;
        int n5 = 0;
        for (int i = 1; i <= n4; ++i) {
            int n6 = i;
            int n7 = 0;
            while (n6 % 2 == 0) {
                ++n7;
                n6 /= 2;
            }
            if (n7 > n5) {
                n5 = n7;
                x = i;
            }
        }
        System.out.println(x);
    }
}