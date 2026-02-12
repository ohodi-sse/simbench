import java.util.ArrayList;

// 
// Decompiled by Procyon v0.6.0
// 

final class Edge extends ArrayList<P>
{
}
import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static int MOD = 1000000007;
    private static int ans;
    
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static void sieve(final ArrayList<Long> list) {
        final boolean[] array = new boolean[50000001];
        final int[] array2 = new int[50000000];
        for (int i = 0; i <= 50000000; ++i) {
            array[i] = true;
        }
        list.add(1L);
        for (int j = 2; j <= 50000000; ++j) {
            if (array[j]) {
                list.add((long)j);
                for (int k = 2 * j; k <= 50000000; k += j) {
                    array[k] = false;
                }
            }
        }
    }
    
    private static int upperbond(final int n, int n2, final int[] array) {
        int length = array.length;
        while (length - n2 > 1) {
            final int n3 = (length + n2) / 2;
            if (array[n3] >= n) {
                length = n3;
            }
            else {
                n2 = n3;
            }
        }
        return length;
    }
    
    private static int lowerbond(final int n, int n2, final int[] array) {
        int length = array.length;
        while (length - n2 > 1) {
            final int n3 = (length + n2) / 2;
            if (array[n3] >= n) {
                length = n3;
            }
            else {
                n2 = n3;
            }
        }
        return n2;
    }
    
    private static int gcd(int n, int i) {
        while (i != 0) {
            final int n2 = i;
            i = n % i;
            n = n2;
        }
        return n;
    }
    
    private static long gcd(long n, long n2) {
        while (n2 != 0L) {
            final long n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n;
    }
    
    private static long lcm(final long n, final long n2) {
        long n3;
        long n4;
        long n5;
        for (n3 = n2, n4 = n; n3 != 0L; n3 = n4 % n3, n4 = n5) {
            n5 = n3;
        }
        return n / n4 * n2;
    }
}
// 
// Decompiled by Procyon v0.6.0
// 

final class P
{
    private int to;
    private long cost;
    
    private P(final int to, final long cost) {
        this.to = to;
        this.cost = cost;
    }
}
// 
// Decompiled by Procyon v0.6.0
// 

final class Pair implements Comparable
{
    private int from;
    private int end;
    
    private Pair(final int from, final int end) {
        this.from = from;
        this.end = end;
    }
    
    @Override
    public final int compareTo(final Object o) {
        return ((Pair)o).from - this.from;
    }
}
// 
// Decompiled by Procyon v0.6.0
// 

final class Town
{
    private int index;
    private int x;
    private int y;
    
    private Town(final int index, final int x, final int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }
}
