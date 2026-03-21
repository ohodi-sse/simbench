import java.util.HashSet;





class Main
{
    static final long MOD = 1000000007L;
    static final int MAX = 2147483646;
    static final int INF = 1000000000;
    
    public static void main(final String[] array) throws Exception {
        final hayami hayami = new hayami();
        final int saori_hayami = hayami.saori_hayami();
        final int saori_hayami2 = hayami.saori_hayami();
        if (saori_hayami2 == 0) {
            System.out.println(saori_hayami);
            return;
        }
        final HashSet set = new HashSet();
        for (int i = 0; i < saori_hayami2; ++i) {
            set.add(hayami.saori_hayami());
        }
        int x = 2147483646;
        for (int j = 0; j <= 101; ++j) {
            if (!set.contains(j)) {
                if (Math.abs(j - saori_hayami) < Math.abs(x - saori_hayami)) {
                    x = j;
                }
            }
        }
        System.out.println(x);
        hayami.close();
    }
}
import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Closeable;





class hayami implements Closeable
{
    private final InputStream in;
    private final byte[] hayami;
    private int Hayami;
    private int saori;
    
    hayami() {
        this.in = System.in;
        this.hayami = new byte[1024];
        this.Hayami = 0;
        this.saori = 0;
    }
    
    private boolean HayamiSaori() {
        if (this.Hayami < this.saori) {
            return true;
        }
        this.Hayami = 0;
        try {
            this.saori = this.in.read(this.hayami);
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
        return this.saori > 0;
    }
    
    private int SaoriHayami() {
        if (this.HayamiSaori()) {
            return this.hayami[this.Hayami++];
        }
        return -1;
    }
    
    private static boolean hayami_saori(final int n) {
        return 33 <= n && n <= 126;
    }
    
    public boolean hayamisaori() {
        while (this.HayamiSaori() && !hayami_saori(this.hayami[this.Hayami])) {
            ++this.Hayami;
        }
        return this.HayamiSaori();
    }
    
    public String nextHayami() {
        if (!this.hayamisaori()) {
            throw new NoSuchElementException();
        }
        final StringBuilder sb = new StringBuilder();
        for (int codePoint = this.SaoriHayami(); hayami_saori(codePoint); codePoint = this.SaoriHayami()) {
            sb.appendCodePoint(codePoint);
        }
        return sb.toString();
    }
    
    public long saorihayami() {
        if (!this.hayamisaori()) {
            throw new NoSuchElementException();
        }
        long n = 0L;
        boolean b = false;
        int n2 = this.SaoriHayami();
        if (n2 == 45) {
            b = true;
            n2 = this.SaoriHayami();
        }
        if (n2 < 48 || 57 < n2) {
            throw new NumberFormatException();
        }
        while (48 <= n2 && n2 <= 57) {
            n = n * 10L + (n2 - 48);
            n2 = this.SaoriHayami();
        }
        if (n2 == -1 || !hayami_saori(n2)) {
            return b ? (-n) : n;
        }
        throw new NumberFormatException();
    }
    
    public int saori_hayami() {
        final long saorihayami = this.saorihayami();
        if (saorihayami < -2147483648L || saorihayami > 2147483647L) {
            throw new NumberFormatException();
        }
        return (int)saorihayami;
    }
    
    public double Hayamin() {
        return Double.parseDouble(this.nextHayami());
    }
    
    @Override
    public void close() {
        try {
            this.in.close();
        }
        catch (final IOException ex) {}
    }
}