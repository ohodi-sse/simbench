import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new MyScanner().nextInt();
        int x = 1;
        int n2;
        for (int n = 0; n < 10 && (n2 = x << 1) <= nextInt; x = n2, ++n) {}
        System.out.println(x);
    }
    
    private void solve$3231c38a() {
        final int nextInt = new MyScanner().nextInt();
        int n = 1;
        for (int i = 0; i < 10; ++i) {
            final int n2;
            if ((n2 = n << 1) > nextInt) {
                System.out.println(n);
                return;
            }
            n = n2;
        }
        System.out.println(n);
    }
    
    private final class MyScanner
    {
        private String[] s;
        private int i;
        private BufferedReader br;
        private String reg;
        
        MyScanner(final Main obj) {
            Objects.requireNonNull(obj);
            this.reg = " ";
            this.s = new String[0];
            this.i = 0;
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        private String next() {
            try {
                if (this.i < this.s.length) {
                    return this.s[this.i++];
                }
                String s;
                for (s = this.br.readLine(); s.equals(""); s = this.br.readLine()) {}
                this.s = s.split(this.reg, 0);
                this.i = 0;
                return this.s[this.i++];
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
        
        public final int nextInt() {
            try {
                return Integer.parseInt(this.next());
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return -1;
            }
        }
        
        private double nextDouble() {
            try {
                return Double.parseDouble(this.next());
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return -1.0;
            }
        }
        
        private long nextLong() {
            try {
                return Long.parseLong(this.next());
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return -1L;
            }
        }
    }
}
