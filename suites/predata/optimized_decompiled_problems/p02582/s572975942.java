import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// 
// Decompiled by Procyon v0.6.0
// 

final class FastScanner
{
    private BufferedReader br;
    private StringTokenizer st;
    
    FastScanner() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.st = new StringTokenizer("");
    }
    
    public final String next() {
        while (!this.st.hasMoreTokens()) {
            try {
                this.st = new StringTokenizer(this.br.readLine());
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
        return this.st.nextToken();
    }
    
    private static long pow(long n, long n2) {
        long n3 = 1L;
        while (n2 > 0L) {
            if (n2 % 2L != 0L) {
                n3 *= n;
                --n2;
            }
            else {
                final long n4 = n;
                n = n4 * n4;
                n2 /= 2L;
            }
        }
        return n3;
    }
    
    private static int gcd(int n, int i) {
        while (i != 0) {
            final int n2 = i;
            i = n % i;
            n = n2;
        }
        return n;
    }
    
    private static long longgcd(long n, long n2) {
        while (n2 != 0L) {
            final long n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n;
    }
    
    private static int[] sort(final int[] array) {
        final ArrayList list = new ArrayList();
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(array[i]);
        }
        Collections.sort((List<Comparable>)list);
        for (int j = 0; j < array.length; ++j) {
            array[j] = (int)list.get(j);
        }
        return array;
    }
    
    private static char[] charsort(final char[] array) {
        final ArrayList list = new ArrayList();
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(array[i]);
        }
        Collections.sort((List<Comparable>)list);
        for (int j = 0; j < list.size(); ++j) {
            array[j] = (char)list.get(j);
        }
        return array;
    }
    
    private static long[] longsort(final long[] array) {
        final ArrayList list = new ArrayList();
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(array[i]);
        }
        Collections.sort((List<Comparable>)list);
        for (int j = 0; j < array.length; ++j) {
            array[j] = (long)list.get(j);
        }
        return array;
    }
    
    private int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    private int[] readArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(this.next());
        }
        return array;
    }
    
    private long nextLong() {
        return Long.parseLong(this.next());
    }
    
    private double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    private long[] longreadArray(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = Long.parseLong(this.next());
        }
        return array;
    }
}
// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static int mod = 1000000007;
    private static int inf = 1000000000;
    private static int INF = Integer.MAX_VALUE;
    
    private static void main$3231c38a() {
        final char[] charArray = new FastScanner().next().toCharArray();
        int n = 0;
        int x = 0;
        for (int i = 0; i < charArray.length - 1; ++i) {
            if (charArray[i] == charArray[i + 1] && charArray[i] == 'R') {
                ++n;
            }
            else if (charArray[i] == 'R') {
                x = Math.max(x, n + 1);
                n = 0;
            }
        }
        if (charArray[2] == 'R') {
            x = Math.max(x, n + 1);
        }
        System.out.println(x);
    }
}
