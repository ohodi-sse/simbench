import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static String alpha;
    
    private static int getGcd(int i, int n) {
        while (i != n) {
            if (i > n) {
                i -= n;
            }
            else {
                n -= i;
            }
        }
        return i;
    }
    
    private static boolean isSorted(final int[] array, final int n) {
        for (int i = 1; i < n; ++i) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isPrime(final long n) {
        if (n == 2L) {
            return true;
        }
        if (n % 2L == 0L) {
            return false;
        }
        for (int n2 = 3; n2 <= n / 2L; n2 += 2) {
            if (n % n2 == 0L) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isPrime(final int n) {
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= n / 2; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private static void printArray(final int[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            System.out.print("" + array[i]);
        }
        System.out.println();
    }
    
    private static long Fact(final int n) {
        long n2 = 1L;
        for (int i = 1; i <= n; ++i) {
            n2 *= i;
        }
        return n2;
    }
    
    private static int findLargestDiv(final int n) {
        if (n % 2 == 0) {
            return n / 2;
        }
        for (int i = 3; i <= n / 2; i += 2) {
            if (n % i == 0) {
                return n / i;
            }
        }
        return 1;
    }
    
    private static void main$3231c38a() throws NumberFormatException, IOException {
        final String nextLine = new FastReader().nextLine();
        int n = 0;
        int x = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i) == 'R') {
                ++n;
                if (i == 2) {
                    x = Math.max(x, n);
                }
            }
            else {
                x = Math.max(x, n);
                n = 0;
            }
        }
        System.out.println(x);
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
        
        private int[] readArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(this.next());
            }
            return array;
        }
        
        private long[] readLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = Long.parseLong(this.next());
            }
            return array;
        }
        
        final String nextLine() {
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
