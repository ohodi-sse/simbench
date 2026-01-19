// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static final int mod = 1000000007;
    static final int inf = 1000000000;
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(final String[] array) {
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

class FastScanner
{
    BufferedReader br;
    StringTokenizer st;
    
    FastScanner() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.st = new StringTokenizer("");
    }
    
    public String next() {
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
    
    long pow(long n, long n2) {
        long n3 = 1L;
        while (n2 > 0L) {
            if (n2 % 2L != 0L) {
                n3 *= n;
                --n2;
            }
            else {
                n *= n;
                n2 /= 2L;
            }
        }
        return n3;
    }
    
    int gcd(final int n, final int n2) {
        if (n2 == 0) {
            return n;
        }
        return this.gcd(n2, n % n2);
    }
    
    long longgcd(final long n, final long n2) {
        if (n2 == 0L) {
            return n;
        }
        return this.longgcd(n2, n % n2);
    }
    
    int[] sort(final int[] array) {
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
    
    char[] charsort(final char[] array) {
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
    
    long[] longsort(final long[] array) {
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
    
    public int nextInt() {
        return Integer.parseInt(this.next());
    }
    
    public int[] readArray(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextInt();
        }
        return array;
    }
    
    public long nextLong() {
        return Long.parseLong(this.next());
    }
    
    public double nextDouble() {
        return Double.parseDouble(this.next());
    }
    
    public long[] longreadArray(final int n) {
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = this.nextLong();
        }
        return array;
    }
}
