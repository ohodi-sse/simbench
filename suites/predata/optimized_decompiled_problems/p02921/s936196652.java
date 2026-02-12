import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int n = 1;
        final HashMap hashMap;
        (hashMap = new HashMap()).put("SUN", 7);
        hashMap.put("MON", 6);
        hashMap.put("TUE", 5);
        hashMap.put("WED", 4);
        hashMap.put("THU", 3);
        hashMap.put("FRI", 2);
        hashMap.put("SAT", 1);
        while (n-- > 0) {
            int x = 0;
            final String next = scanner.next();
            final String next2 = scanner.next();
            for (int i = 0; i < 3; ++i) {
                if (next.charAt(i) == next2.charAt(i)) {
                    ++x;
                }
            }
            System.out.println(x);
        }
    }
    
    private static int binary_search(final int[] array, int i, int n, final int n2) {
        while (i <= n) {
            final int n3 = (i + n) / 2;
            if (array[n3] <= n2) {
                i = n3 + 1;
            }
            else {
                n = n3 - 1;
            }
        }
        return n;
    }
    
    private static int gcd(int n, int i) {
        while (i != 0) {
            final int n2 = i;
            i = n % i;
            n = n2;
        }
        return n;
    }
    
    private static boolean isPrime(final int n) {
        if (n == 2) {
            return true;
        }
        if ((n % 2 == 0 && n > 2) || n < 2) {
            return false;
        }
        for (int i = 3; i <= (int)Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        private String next() {
            while (true) {
                if (this.st != null) {
                    if (this.st.hasMoreElements()) {
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
    }
}
