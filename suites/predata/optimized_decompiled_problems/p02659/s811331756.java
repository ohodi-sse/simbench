import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.io.BufferedReader;
import java.math.BigDecimal;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Scanner sc;
    
    private static void main$3231c38a() {
        Main.sc = new Scanner();
        try {
            System.out.println(new BigDecimal(Long.parseLong(Main.sc.next())).multiply(new BigDecimal(Main.sc.next())).setScale(0, 1));
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void solve() {
        try {
            System.out.println(new BigDecimal(Long.parseLong(Main.sc.next())).multiply(new BigDecimal(Main.sc.next())).setScale(0, 1));
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
        
        private Long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(this.next());
        }
        
        private Double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(this.next());
        }
    }
}
