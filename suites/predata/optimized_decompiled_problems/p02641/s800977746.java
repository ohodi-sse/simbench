import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static int divisors(final long n) {
        long n2 = n;
        int n3 = 0;
        if (n == 1L) {
            return 1;
        }
        for (int n4 = 1; n4 < n2; ++n4) {
            if (n % n4 == 0L) {
                if ((n2 = n / n4) != n4) {
                    ++n3;
                }
                ++n3;
            }
        }
        return n3;
    }
    
    private static void main$3231c38a() throws IOException {
        final FastReader fastReader;
        final int int1 = Integer.parseInt((fastReader = new FastReader()).next());
        final int int2 = Integer.parseInt(fastReader.next());
        final ArrayList list = new ArrayList();
        for (int i = 0; i < int2; ++i) {
            list.add(Integer.parseInt(fastReader.next()));
        }
        int j = 0;
        int n = 0;
        while (j == 0) {
            if (!list.contains(int1 - n)) {
                j = 1;
                System.out.println(int1 - n);
            }
            else if (!list.contains(int1 + n)) {
                j = 1;
                System.out.println(int1 + n);
            }
            ++n;
        }
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        final String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreTokens()) {
                        break;
                    }
                }
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                }
                catch (final IOException ex) {
                    ex.printStackTrace();
                }
            }
            return this.st.nextToken();
        }
        
        private int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        private long nextLong() {
            return Long.parseLong(this.next());
        }
        
        private double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        private String nextLine() {
            String line = "";
            try {
                line = this.br.readLine();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
        
        private static Character charAt$6696934a() {
            return null;
        }
    }
}
