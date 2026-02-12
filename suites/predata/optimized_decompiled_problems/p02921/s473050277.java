import java.io.Reader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.io.BufferedReader;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        new Main();
        final Scanner scanner;
        final char[] charArray = (scanner = new Scanner(System.in)).next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static void solve$3231c38a() {
        final Scanner scanner;
        final char[] charArray = (scanner = new Scanner(System.in)).next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private final class MyScanner
    {
        private String[] s;
        private int i;
        private BufferedReader br;
        private String reg;
        
        private MyScanner(final Main obj) {
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
        
        private int nextInt() {
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
