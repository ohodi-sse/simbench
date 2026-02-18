import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static int mod;
    
    private static int binarySearch(final int[] array, final int n, int i, int n2) {
        while (i <= n2) {
            final int n3 = (i + n2) / 2;
            if (array[n3] == n) {
                return n3;
            }
            if (array[n3] > n) {
                n2 = n3 - 1;
            }
            else {
                if (array[n3] >= n) {
                    continue;
                }
                i = n3 + 1;
            }
        }
        return -1;
    }
    
    private static String reverse(final String s) {
        char[] charArray;
        for (int n = (charArray = s.toCharArray()).length - 1, i = 0; i < n; ++i, --n) {
            final char c = charArray[i];
            charArray[i] = charArray[n];
            charArray[n] = c;
        }
        return String.valueOf(charArray);
    }
    
    private static int gcd(int i, int n) {
        while (i != 0) {
            if (n == 0) {
                return i;
            }
            if (i == n) {
                return i;
            }
            if (i > n) {
                i -= n;
            }
            else {
                final int n2 = i;
                n -= i;
                i = n2;
            }
        }
        return n;
    }
    
    private static int lcm(int i, int n) {
        final int n2 = i * n;
        i = i;
        while (i != 0) {
            int n3;
            if (n == 0) {
                n3 = i;
            }
            else if (i == n) {
                n3 = i;
            }
            else {
                if (i > n) {
                    i -= n;
                    continue;
                }
                final int n4 = i;
                n -= i;
                i = n4;
                continue;
            }
            return n2 / n3;
        }
        int n3 = n;
        return n2 / n3;
    }
    
    private static int solve(final int n, final int n2) {
        int n3 = 0;
        for (int i = 0; i < 21; ++i) {
            if ((n >> i & 0x1) != (n2 >> i & 0x1)) {
                ++n3;
            }
        }
        return n3;
    }
    
    private static long nCr(final int n, final int n2) {
        return fact(n) / (fact(n2) * fact(n - n2));
    }
    
    private static long fact(final int n) {
        long n2 = 1L;
        for (int i = 2; i <= n; ++i) {
            n2 *= i;
        }
        return n2;
    }
    
    private static long count(final long n) {
        return n * (n - 1L) / 2L;
    }
    
    private static boolean isPrime(final int n) {
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int n2 = 3; n2 <= Math.sqrt(n); n2 += 2) {
            if (n % n2 == 0) {
                return false;
            }
        }
        return true;
    }
    
    private static int negMod(final int n) {
        return (n % 1000000007 + 1000000007) % 1000000007;
    }
    
    private static String value(int i) {
        String s = "";
        while (i > 0) {
            if (i % 2 == 1) {
                s = s;
            }
            else {
                s = s;
            }
            i /= 2;
        }
        char[] charArray;
        for (int n = (charArray = s.toCharArray()).length - 1, j = 0; j < n; ++j, --n) {
            final char c = charArray[j];
            charArray[j] = charArray[n];
            charArray[n] = c;
        }
        return String.valueOf(charArray);
    }
    
    private static int sum(long n) {
        int n2 = 0;
        while (n > 0L) {
            n2 += (int)(n % 10L);
            n /= 10L;
        }
        return n2;
    }
    
    private static void main$3231c38a() throws Exception {
        final PrintWriter printWriter = new PrintWriter(System.out);
        final String next = new FastReader().next();
        int a = 0;
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++a;
            }
            else {
                max = Math.max(a, max);
                a = 0;
            }
        }
        if (max == 0) {
            max = a;
        }
        printWriter.print(max);
        printWriter.close();
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
