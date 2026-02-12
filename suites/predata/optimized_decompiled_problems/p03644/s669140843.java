import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static String Y;
    private static String N;
    private static long MOD;
    private static Scanner sc;
    
    private static void main$3231c38a() {
        final int nextInt = Main.sc.nextInt();
        int n = 0;
        int x = 1;
        for (int i = 1; i <= nextInt; ++i) {
            int n2 = i;
            int n3 = 0;
            while (n2 % 2 == 0) {
                ++n3;
                n2 /= 2;
            }
            if (n <= n3) {
                n = n3;
                x = i;
            }
        }
        System.out.println(x);
    }
    
    private static int ketasuu(final int n) {
        return ("" + n).length();
    }
    
    private static int abcount(final String s) {
        int n = 0;
        for (int length = s.length(), i = 0; i < length - 1; ++i) {
            final String s2 = "AB";
            final int beginIndex = i;
            if (s2.equals(s.substring(beginIndex, beginIndex + 2))) {
                ++n;
            }
        }
        return n;
    }
    
    private static int ni() {
        return Main.sc.nextInt();
    }
    
    private static long nl() {
        return Main.sc.nextLong();
    }
    
    private static double nd() {
        return Main.sc.nextDouble();
    }
    
    private static String n() {
        return Main.sc.next();
    }
    
    private static char[] nc() {
        return Main.sc.next().toCharArray();
    }
    
    private static int kaijo(final int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * kaijo(n - 1);
    }
    
    private static int fib(final int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return fib(n - 2) + fib(n - 1);
    }
    
    private static long lcm(final long n, final long n2) {
        final long n3 = n * n2;
        long n4;
        long n5;
        long n6;
        for (n4 = n2, n5 = n; n4 != 0L; n4 = n5 % n4, n5 = n6) {
            n6 = n4;
        }
        return n3 / n5;
    }
    
    private static int lcm(int n, int i) {
        final int n2 = n * i;
        final int n3 = n;
        int n4;
        for (i = i, n = n3; i != 0; i = n % i, n = n4) {
            n4 = i;
        }
        return n2 / n;
    }
    
    private static long gcd(long n, long n2) {
        while (n2 != 0L) {
            final long n3 = n2;
            n2 = n % n2;
            n = n3;
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
    
    private static void out(final String x) {
        System.out.println(x);
    }
    
    private static void out(final int x) {
        System.out.println(x);
    }
    
    private static void out(final double x) {
        System.out.println(x);
    }
    
    private static void out(final long x) {
        System.out.println(x);
    }
    
    private static void out(final char x) {
        System.out.println(x);
    }
    
    private static void out(final Object o) {
        System.out.println(o.toString());
    }
    
    private static void outn(final String s) {
        System.out.print(s);
    }
    
    private static void outn(final int i) {
        System.out.print(i);
    }
    
    private static void outn(final double d) {
        System.out.print(d);
    }
    
    private static void outn(final long l) {
        System.out.print(l);
    }
    
    private static void outn(final char c) {
        System.out.print(c);
    }
    
    private static double max(final double a, final double b) {
        return Math.max(a, b);
    }
    
    private static long max(final long a, final long b) {
        return Math.max(a, b);
    }
    
    private static double min(final double a, final double b) {
        return Math.min(a, b);
    }
    
    private static long min(final long a, final long b) {
        return Math.min(a, b);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}
// 
// Decompiled by Procyon v0.6.0
// 

final class XY
{
    private int h;
    private int c;
    
    private XY(final int h, final int c) {
        this.h = h;
        this.c = c;
    }
}
