import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public static class InputReader
{
    private BufferedReader br;
    private StringTokenizer st;
    
    public InputReader(final InputStream in) {
        this.br = new BufferedReader(new InputStreamReader(in));
        this.st = null;
    }
    
    public String ns() {
        if (this.st != null) {
            if (this.st.hasMoreTokens()) {
                return this.st.nextToken();
            }
        }
        try {
            this.st = new StringTokenizer(this.br.readLine());
        }
        catch (final Exception cause) {
            throw new RuntimeException(cause);
        }
        return this.st.nextToken();
    }
    
    public int ni() {
        return Integer.parseInt(this.ns());
    }
    
    public long nl() {
        return Long.parseLong(this.ns());
    }
    
    public double nd() {
        return Double.parseDouble(this.ns());
    }
    
    public char nc() {
        return this.ns().toCharArray()[0];
    }
    
    public int[] ni(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.ni();
        }
        return array;
    }
    
    public long[] nl(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nl();
        }
        return array;
    }
    
    public double[] nd(final int n) {
        final double[] array = new double[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nd();
        }
        return array;
    }
}
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static final long mod = 1000000007L;
    public static final long INF = 4611686018427387903L;
    public static final int inf = 1073741823;
    
    static void solve(final InputReader inputReader, final PrintWriter printWriter) {
        final long nl = inputReader.nl();
        final char[] charArray = inputReader.ns().toCharArray();
        long n = 0L;
        for (int i = 0; i < 4; ++i) {
            if (i != 1) {
                n = (n + (charArray[i] - '0')) * 10L;
            }
        }
        printWriter.println(nl * (n / 10L) / 100L);
    }
    
    public static void main(final String[] array) {
        final InputReader inputReader = new InputReader(System.in);
        final PrintWriter printWriter = new PrintWriter(System.out);
        solve(inputReader, printWriter);
        printWriter.close();
    }
    
    public static class InputReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public InputReader(final InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
            this.st = null;
        }
        
        public String ns() {
            if (this.st != null) {
                if (this.st.hasMoreTokens()) {
                    return this.st.nextToken();
                }
            }
            try {
                this.st = new StringTokenizer(this.br.readLine());
            }
            catch (final Exception cause) {
                throw new RuntimeException(cause);
            }
            return this.st.nextToken();
        }
        
        public int ni() {
            return Integer.parseInt(this.ns());
        }
        
        public long nl() {
            return Long.parseLong(this.ns());
        }
        
        public double nd() {
            return Double.parseDouble(this.ns());
        }
        
        public char nc() {
            return this.ns().toCharArray()[0];
        }
        
        public int[] ni(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.ni();
            }
            return array;
        }
        
        public long[] nl(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nl();
            }
            return array;
        }
        
        public double[] nd(final int n) {
            final double[] array = new double[n];
            for (int i = 0; i < n; ++i) {
                array[i] = this.nd();
            }
            return array;
        }
    }
}
