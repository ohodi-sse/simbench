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

public class Main
{
    static PrintWriter out;
    
    public static void main(final String[] array) {
        final FastReader fastReader = new FastReader();
        final StringBuilder x = new StringBuilder();
        int n = 1;
        while (n-- > 0) {
            final int nextInt = fastReader.nextInt();
            final int nextInt2 = fastReader.nextInt();
            final int[] array2 = new int[nextInt2];
            final HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < nextInt2; ++i) {
                array2[i] = fastReader.nextInt();
                set.add(array2[i]);
            }
            int j = nextInt;
            int n2 = Integer.MAX_VALUE;
            int k = nextInt;
            while (true) {
                final int n3 = nextInt - j;
                if (!set.contains(j) && n3 < n2) {
                    n2 = n3;
                    k = j;
                }
                if (n3 > n2) {
                    break;
                }
                --j;
            }
            int l = nextInt;
            while (true) {
                final int n4 = l - nextInt;
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
        x.deleteCharAt(x.length() - 1);
        Main.out.println(x);
    }
    
    public static boolean isPrime(final int n) {
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
    
    public static void print(final int[] array, final int n, final int n2) {
        for (int i = n; i <= n2; ++i) {
            Main.out.print("" + array[i]);
        }
        Main.out.println();
    }
    
    public static long fastexpo(long n, long n2, final long n3) {
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
    
    public static boolean[] sieve(final int n) {
        final boolean[] a = new boolean[n + 1];
        Arrays.fill(a, true);
        a[0] = (a[1] = false);
        for (int n2 = 2; n2 * n2 <= n; ++n2) {
            if (a[n2]) {
                for (int i = n2 * n2; i <= n; i += n2) {
                    a[i] = false;
                }
            }
        }
        return a;
    }
    
    public static long gcd(final long val, final long val2) {
        return BigInteger.valueOf(val).gcd(BigInteger.valueOf(val2)).longValue();
    }
    
    public static void merge(final long[] array, final int n, final int n2, final int n3) {
        final int n4 = n2 - n + 1;
        final int n5 = n3 - n2;
        final long[] array2 = new long[n4];
        final long[] array3 = new long[n5];
        for (int i = 0; i < n4; ++i) {
            array2[i] = array[n + i];
        }
        for (int j = 0; j < n5; ++j) {
            array3[j] = array[n2 + 1 + j];
        }
        int k = 0;
        int l = 0;
        int n6 = n;
        while (k < n4 && l < n5) {
            if (array2[k] <= array3[l]) {
                array[n6] = array2[k];
                ++k;
            }
            else {
                array[n6] = array3[l];
                ++l;
            }
            ++n6;
        }
        while (k < n4) {
            array[n6] = array2[k];
            ++k;
            ++n6;
        }
        while (l < n5) {
            array[n6] = array3[l];
            ++l;
            ++n6;
        }
    }
    
    public static void sort(final long[] array, final int n, final int n2) {
        if (n < n2) {
            final int n3 = (n + n2) / 2;
            sort(array, n, n3);
            sort(array, n3 + 1, n2);
            merge(array, n, n3, n2);
        }
    }
    
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
            Main.out = new PrintWriter(System.out, true);
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
