import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    static PrintWriter out;
    
    private static void main$3231c38a() {
        final FastReader fastReader = new FastReader();
        final StringBuilder x = new StringBuilder();
        int n = 1;
        while (n-- > 0) {
            final int int1 = Integer.parseInt(fastReader.next());
            final int int2;
            final int[] array = new int[int2 = Integer.parseInt(fastReader.next())];
            final HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < int2; ++i) {
                array[i] = Integer.parseInt(fastReader.next());
                set.add(array[i]);
            }
            int j = int1;
            int n2 = Integer.MAX_VALUE;
            int k = int1;
            while (true) {
                final int n3 = int1 - j;
                if (!set.contains(j) && n3 < n2) {
                    n2 = n3;
                    k = j;
                }
                if (n3 > n2) {
                    break;
                }
                --j;
            }
            int l = int1;
            while (true) {
                final int n4 = l - int1;
                if (!set.contains(l) && n4 < n2) {
                    n2 = n4;
                    k = l;
                }
                if (n4 > n2) {
                    break;
                }
                ++l;
            }
            x.append(k).append('\n');
        }
        final StringBuilder sb = x;
        sb.deleteCharAt(sb.length() - 1);
        Main.out.println(x);
    }
    
    private static boolean isPrime(final int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= (int)Math.sqrt(n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private static void print(final int[] array, int i, final int n) {
        while (i <= n) {
            Main.out.print("" + array[i]);
            ++i;
        }
        Main.out.println();
    }
    
    private static long fastexpo(long n, long n2, final long n3) {
        long n4 = 1L;
        while (n2 > 0L) {
            if ((n2 & 0x1L) == 0x1L) {
                n4 = n4 % n3 * (n % n3) % n3;
            }
            n2 >>= 1;
            n = n % n3 * (n % n3) % n3;
        }
        return n4;
    }
    
    private static boolean[] sieve(final int n) {
        final boolean[] array;
        Arrays.fill(array = new boolean[n + 1], true);
        array[0] = (array[1] = false);
        int n2 = 2;
        while (true) {
            final int n3 = n2;
            if (n3 * n3 > n) {
                break;
            }
            if (array[n2]) {
                final int n4 = n2;
                for (int i = n4 * n4; i <= n; i += n2) {
                    array[i] = false;
                }
            }
            ++n2;
        }
        return array;
    }
    
    private static long gcd(final long val, final long val2) {
        return BigInteger.valueOf(val).gcd(BigInteger.valueOf(val2)).longValue();
    }
    
    private static void merge(final long[] array, int n, final int n2, int n3) {
        final int n4 = n2 - n + 1;
        n3 -= n2;
        final long[] array2 = new long[n4];
        final long[] array3 = new long[n3];
        for (int i = 0; i < n4; ++i) {
            array2[i] = array[n + i];
        }
        for (int j = 0; j < n3; ++j) {
            array3[j] = array[n2 + 1 + j];
        }
        int k = 0;
        int l = 0;
        while (k < n4 && l < n3) {
            if (array2[k] <= array3[l]) {
                array[n] = array2[k];
                ++k;
            }
            else {
                array[n] = array3[l];
                ++l;
            }
            ++n;
        }
        while (k < n4) {
            array[n] = array2[k];
            ++k;
            ++n;
        }
        while (l < n3) {
            array[n] = array3[l];
            ++l;
            ++n;
        }
    }
    
    private static void sort(long[] array, int n, int n2) {
        if (n < n2) {
            final int n3 = (n + n2) / 2;
            sort(array, n, n3);
            sort(array, n3 + 1, n2);
            final long[] array2 = array;
            final int n4 = n;
            final int n5 = n3;
            final int n6 = n2;
            n2 = n5;
            n = n4;
            array = array2;
            final int n7 = n2 - n + 1;
            final int n8 = n6 - n2;
            final long[] array3 = new long[n7];
            final long[] array4 = new long[n8];
            for (int i = 0; i < n7; ++i) {
                array3[i] = array[n + i];
            }
            for (int j = 0; j < n8; ++j) {
                array4[j] = array[n2 + 1 + j];
            }
            int k = 0;
            int l = 0;
            while (k < n7 && l < n8) {
                if (array3[k] <= array4[l]) {
                    array[n] = array3[k];
                    ++k;
                }
                else {
                    array[n] = array4[l];
                    ++l;
                }
                ++n;
            }
            while (k < n7) {
                array[n] = array3[k];
                ++k;
                ++n;
            }
            while (l < n8) {
                array[n] = array4[l];
                ++l;
                ++n;
            }
        }
    }
    
    static final class FastReader
    {
        private BufferedReader br;
        private StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            Main.out = new PrintWriter(System.out, true);
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
