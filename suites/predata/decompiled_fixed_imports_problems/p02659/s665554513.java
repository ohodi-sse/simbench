import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main
{
    private static final int MOD;
    private static final long EIGHT = 1000000000000000000L;
    private static final int[][] DIRS;
    
    public static void main(final String[] array) {
        final FastReader fastReader = new FastReader();
        final long nextLong = fastReader.nextLong();
        final String next = fastReader.next();
        System.out.println(nextLong * (0 + (next.charAt(0) - '0') * 100 + (next.charAt(2) - '0') * 10 + (next.charAt(3) - '0') * 1) / 100L);
    }
    
    static Boolean isOverflowByMul(final long n, final long n2) {
        if (n == 0L || n2 == 0L) {
            return false;
        }
        if (n == n * n2 / n2) {
            return false;
        }
        return true;
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
    
    private static boolean findNextPermutation(final int[] array) {
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
        reverse(array, n + 1, array.length - 1);
        return true;
    }
    
    private static int[] generateNArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = i + 1;
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
        print("");
    }
    
    private static int log2(final int n) {
        return (int)(Math.log(n) / Math.log(2.0));
    }
    
    private static long gcd(final long n, final long n2) {
        if (n < n2) {
            return gcd(n2, n);
        }
        if (n % n2 == 0L) {
            return n2;
        }
        return gcd(n2, n % n2);
    }
    
    static {
        MOD = (int)Math.pow(10.0, 9.0);
        DIRS = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    }
    
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
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
        
        int nextInt() {
            return Integer.parseInt(this.next());
        }
        
        long nextLong() {
            return Long.parseLong(this.next());
        }
        
        double nextDouble() {
            return Double.parseDouble(this.next());
        }
        
        String nextLine() {
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