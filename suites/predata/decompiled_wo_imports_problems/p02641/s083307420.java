public class Main
{
    public static void main(final String[] array) {
        final FastScanner fastScanner = new FastScanner();
        final int nextInt = fastScanner.nextInt();
        final int nextInt2 = fastScanner.nextInt();
        final int[] array2 = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            array2[fastScanner.nextInt()] = 1;
        }
        int x = 0;
        int abs = Integer.MAX_VALUE;
        for (int j = 0; j <= 101; ++j) {
            if (nextInt2 == 0) {
                x = nextInt;
                break;
            }
            if (array2[j] != 1) {
                if (abs > Math.abs(nextInt - j)) {
                    abs = Math.abs(nextInt - j);
                    x = j;
                }
            }
        }
        System.out.println(x);
    }
}class FastScanner
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
    
    public boolean hasNext() {
        while (this.hasNextByte() && !isPrintableChar(this.buffer[this.ptr])) {
            ++this.ptr;
        }
        return this.hasNextByte();
    }
    
    public String next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        final StringBuilder sb = new StringBuilder();
        for (int codePoint = this.readByte(); isPrintableChar(codePoint); codePoint = this.readByte()) {
            sb.appendCodePoint(codePoint);
        }
        return sb.toString();
    }
    
    public long nextLong() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        long n = 0L;
        boolean b = false;
        int n2 = this.readByte();
        if (n2 == 45) {
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
        if (n2 == -1 || !isPrintableChar(n2)) {
            return b ? (-n) : n;
        }
        throw new NumberFormatException();
    }
    
    public int nextInt() {
        final long nextLong = this.nextLong();
        if (nextLong < -2147483648L || nextLong > 2147483647L) {
            throw new NumberFormatException();
        }
        return (int)nextLong;
    }
    
    public double nextDouble() {
        return Double.parseDouble(this.next());
    }
}