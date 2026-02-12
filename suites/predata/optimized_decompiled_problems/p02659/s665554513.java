import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static final int MOD;
    private static final long EIGHT = 1000000000000000000L;
    private static final int[][] DIRS;
    
    private static void main$3231c38a() {
        final FastReader fastReader;
        final long long1 = Long.parseLong((fastReader = new FastReader()).next());
        final String next = fastReader.next();
        System.out.println(long1 * (0 + (next.charAt(0) - '0') * 100 + (next.charAt(2) - '0') * 10 + (next.charAt(3) - '0')) / 100L);
    }
    
    private static Boolean isOverflowByMul(final long n, final long n2) {
        if (n == 0L || n2 == 0L) {
            return Boolean.FALSE;
        }
        if (n == n * n2 / n2) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    
    private static void swap(final int[] array, final int n, final int n2) {
        final int n3 = array[n];
        array[n] = array[n2];
        array[n2] = n3;
    }
    
    private static void reverse(final int[] array, int i, int n) {
        while (i < n) {
            swap(array, i, n);
            ++i;
            --n;
        }
    }
    
    private static boolean findNextPermutation(int[] array) {
        if (array.length <= 1) {
            return false;
        }
        int n;
        for (n = array.length - 2; n >= 0 && array[n] >= array[n + 1]; --n) {}
        if (n < 0) {
            return false;
        }
        int n2 = array.length - 1;
        for (int i = array.length - 1; i > n; --i) {
            if (array[i] > array[n]) {
                n2 = i;
                break;
            }
        }
        swap(array, n2, n);
        final int[] array2 = array;
        final int n3 = n + 1;
        int n4 = array.length - 1;
        int j = n3;
        array = array2;
        while (j < n4) {
            swap(array, j, n4);
            ++j;
            --n4;
        }
        return true;
    }
    
    private static int[] generateNArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            final int[] array2 = array;
            final int n2 = i;
            array2[n2] = n2 + 1;
        }
        return array;
    }
    
    private static void print(final String x) {
        System.out.println(x);
    }
    
    private static void printArray(final int[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            System.out.print("" + array[i]);
        }
        System.out.println("");
    }
    
    private static int log2(final int n) {
        return (int)(Math.log(n) / Math.log(2.0));
    }
    
    private static long gcd(long n, long n2) {
        while (true) {
            if (n < n2) {
                final long n3 = n2;
                n2 = n;
                n = n3;
            }
            else {
                if (n % n2 == 0L) {
                    break;
                }
                final long n4 = n2;
                n2 = n % n2;
                n = n4;
            }
        }
        return n2;
    }
    
    static {
        final int[][] array = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
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
