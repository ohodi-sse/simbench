import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Scanner sc;
    
    private static void main$3231c38a() {
        Main.sc = new Scanner();
        try {
            final long long1 = Long.parseLong(Main.sc.next());
            String next;
            if ((next = Main.sc.next()).contains(".")) {
                next = next.substring(0, 1) + next.substring(2);
            }
            long x = long1 * Integer.parseInt(next);
            for (int i = 0; i < next.length() - 1; ++i) {
                x /= 10L;
            }
            System.out.println(x);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void solve() {
        try {
            final long long1 = Long.parseLong(Main.sc.next());
            String next;
            if ((next = Main.sc.next()).contains(".")) {
                next = next.substring(0, 1) + next.substring(2);
            }
            long x = long1 * Integer.parseInt(next);
            for (int i = 0; i < next.length() - 1; ++i) {
                x /= 10L;
            }
            System.out.println(x);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private final class Scanner
    {
        private String[] s;
        private int i;
        private BufferedReader br;
        private String regex;
        
        public Scanner(final Main obj) {
            Objects.requireNonNull(obj);
            this.regex = " ";
            this.s = new String[0];
            this.i = 0;
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        @Override
        protected final void finalize() throws Throwable {
            try {
                super.finalize();
            }
            finally {
                this.destruction();
            }
        }
        
        private void destruction() throws IOException {
            if (this.br != null) {
                this.br.close();
            }
        }
        
        public final String next() throws IOException {
            if (this.i < this.s.length) {
                return this.s[this.i++];
            }
            String line;
            while ((line = this.br.readLine()) == "") {}
            this.s = line.split(this.regex, 0);
            this.i = 0;
            return this.s[this.i++];
        }
        
        private int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(this.next());
        }
        
        public final Long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(this.next());
        }
        
        private Double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(this.next());
        }
    }
}
