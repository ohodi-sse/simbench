import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    private static Scanner sc;
    
    public static void main(final String[] array) {
        final Main main = new Main();
        Main.sc = new Scanner();
        main.solve();
    }
    
    private void solve() {
        try {
            final long longValue = Main.sc.nextLong();
            String next = Main.sc.next();
            if (next.contains(".")) {
                next = next.substring(0, 1) + next.substring(2);
            }
            long x = longValue * Integer.parseInt(next);
            for (int i = 0; i < next.length() - 1; ++i) {
                x /= 10L;
            }
            System.out.println(x);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private class Scanner
    {
        String[] s;
        int i;
        BufferedReader br;
        String regex;
        
        public Scanner(final Main obj) {
            Objects.requireNonNull(obj);
            this.regex = " ";
            this.s = new String[0];
            this.i = 0;
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        @Override
        protected void finalize() throws Throwable {
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
        
        public String next() throws IOException {
            if (this.i < this.s.length) {
                return this.s[this.i++];
            }
            String s;
            for (s = this.br.readLine(); s == ""; s = this.br.readLine()) {}
            this.s = s.split(this.regex, 0);
            this.i = 0;
            return this.s[this.i++];
        }
        
        public int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(this.next());
        }
        
        public Long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(this.next());
        }
        
        public Double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(this.next());
        }
    }
}
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

private class Scanner
{
    String[] s;
    int i;
    BufferedReader br;
    String regex;
    
    public Scanner(final Main obj) {
        Objects.requireNonNull(obj);
        this.regex = " ";
        this.s = new String[0];
        this.i = 0;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    @Override
    protected void finalize() throws Throwable {
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
    
    public String next() throws IOException {
        if (this.i < this.s.length) {
            return this.s[this.i++];
        }
        String s;
        for (s = this.br.readLine(); s == ""; s = this.br.readLine()) {}
        this.s = s.split(this.regex, 0);
        this.i = 0;
        return this.s[this.i++];
    }
    
    public int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(this.next());
    }
    
    public Long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(this.next());
    }
    
    public Double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(this.next());
    }
}
