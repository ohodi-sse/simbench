import java.io.OutputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.io.BufferedReader;





public class Main
{
    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    final long MOD = 1000000007L;
    private static final int[] dx;
    private static final int[] dy;
    
    void solve() throws IOException {
        final int nextInt = this.nextInt();
        final int[] nextIntArr = this.nextIntArr(this.nextInt());
        final HashSet set = new HashSet();
        final int[] array = nextIntArr;
        for (int length = array.length, i = 0; i < length; ++i) {
            set.add(array[i]);
        }
        int n = Integer.MAX_VALUE;
        int j = -1;
        for (int k = -1; k < 1000; ++k) {
            if (!set.contains(k)) {
                final int abs = Math.abs(k - nextInt);
                if (abs < n) {
                    n = abs;
                    j = k;
                }
            }
        }
        this.outln(j);
    }
    
    void shuffle(final int[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final int n = i + (int)(Math.random() * (length - i));
            final int n2 = array[i];
            array[i] = array[n];
            array[n] = n2;
        }
    }
    
    private void outln(final Object x) {
        this.out.println(x);
    }
    
    private void out(final Object obj) {
        this.out.print(obj);
    }
    
    public Main() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.out = new PrintWriter(System.out);
        this.solve();
        this.out.close();
    }
    
    public static void main(final String[] array) throws IOException {
        new Main();
    }
    
    public long[] nextLongArr(final int n) throws IOException {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextLong();
        }
        return array;
    }
    
    public int[] nextIntArr(final int n) throws IOException {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
    
    public String nextToken() {
        while (true) {
            if (this.st != null) {
                if (this.st.hasMoreTokens()) {
                    break;
                }
            }
            try {
                this.st = new StringTokenizer(this.br.readLine());
                continue;
            }
            catch (final Exception ex) {
                this.eof = true;
                return null;
            }
            break;
        }
        return this.st.nextToken();
    }
    
    public String nextString() {
        try {
            return this.br.readLine();
        }
        catch (final IOException ex) {
            this.eof = true;
            return null;
        }
    }
    
    public int nextInt() throws IOException {
        return Integer.parseInt(this.nextToken());
    }
    
    public long nextLong() throws IOException {
        return Long.parseLong(this.nextToken());
    }
    
    public double nextDouble() throws IOException {
        return Double.parseDouble(this.nextToken());
    }
    
    static {
        dx = new int[] { 0, -1, 0, 1 };
        dy = new int[] { 1, 0, -1, 0 };
    }
}