public class Main
{
    private final PrintWriter out;
    private final InputStream in;
    private final byte[] buffer;
    private int ptr;
    private int buflen;
    
    public Main() {
        this.out = new PrintWriter(System.out);
        this.in = System.in;
        this.buffer = new byte[1024];
        this.ptr = 0;
        this.buflen = 0;
    }
    
    public static void main(final String[] array) throws IOException {
        new Main().solve();
    }
    
    private void solve() throws IOException {
        try {
            this.solveB();
        }
        finally {
            if (this.in != null) {
                this.in.close();
            }
            if (this.out != null) {
                this.out.flush();
                this.out.close();
            }
        }
    }
    
    private void solveA() {
        this.out.println("ABC" + this.nextInt());
    }
    
    private void solveB() {
        final int nextInt = this.nextInt();
        int n = 0;
        int x = 0;
        for (int i = nextInt; i > 0; --i) {
            final int chkB = this.chkB(i);
            if (n <= chkB) {
                n = chkB;
                x = i;
            }
        }
        this.out.println(x);
    }
    
    private int chkB(int n) {
        int n2;
        for (n2 = 0; n > 0 && n % 2 == 0; n /= 2, ++n2) {}
        return n2;
    }
    
    private void solveC() {
        this.nextInt();
        this.out.println("");
    }
    
    private void solveD() {
        this.nextInt();
        this.out.println("");
    }
    
    private void solveE() {
        this.nextInt();
        this.out.println("");
    }
    
    private void solveF() {
        this.nextInt();
        this.out.println("");
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
    
    private void skipUnprintable() {
        while (this.hasNextByte() && !isPrintableChar(this.buffer[this.ptr])) {
            ++this.ptr;
        }
    }
    
    public boolean hasNext() {
        this.skipUnprintable();
        return this.hasNextByte();
    }
    
    public int nextInt() {
        return Integer.parseInt(this.next());
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
}