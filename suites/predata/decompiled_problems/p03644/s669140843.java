import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static String Y;
    public static String N;
    public static long MOD;
    public static Scanner sc;
    
    public static void main(final String[] array) {
        final int ni = ni();
        int n = 0;
        int n2 = 1;
        for (int i = 1; i <= ni; ++i) {
            int n3 = i;
            int n4 = 0;
            while (n3 % 2 == 0) {
                ++n4;
                n3 /= 2;
            }
            if (n <= n4) {
                n = n4;
                n2 = i;
            }
        }
        out(n2);
    }
    
    static int ketasuu(final int n) {
        return ("" + n).length();
    }
    
    static int abcount(final String s) {
        int n = 0;
        for (int length = s.length(), i = 0; i < length - 1; ++i) {
            if ("AB".equals(s.substring(i, i + 2))) {
                ++n;
            }
        }
        return n;
    }
    
    static int ni() {
        return Main.sc.nextInt();
    }
    
    static long nl() {
        return Main.sc.nextLong();
    }
    
    static double nd() {
        return Main.sc.nextDouble();
    }
    
    static String n() {
        return Main.sc.next();
    }
    
    static char[] nc() {
        return Main.sc.next().toCharArray();
    }
    
    static int kaijo(final int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * kaijo(n - 1);
    }
    
    static int fib(final int n) {
        return (n == 1 || n == 0) ? n : (fib(n - 2) + fib(n - 1));
    }
    
    static long lcm(final long n, final long n2) {
        return n * n2 / gcd(n, n2);
    }
    
    static int lcm(final int n, final int n2) {
        return n * n2 / gcd(n, n2);
    }
    
    static long gcd(final long n, final long n2) {
        return (n2 == 0L) ? n : gcd(n2, n % n2);
    }
    
    static int gcd(final int n, final int n2) {
        return (n2 == 0) ? n : gcd(n2, n % n2);
    }
    
    static void out(final String x) {
        System.out.println(x);
    }
    
    static void out(final int x) {
        System.out.println(x);
    }
    
    static void out(final double x) {
        System.out.println(x);
    }
    
    static void out(final long x) {
        System.out.println(x);
    }
    
    static void out(final char x) {
        System.out.println(x);
    }
    
    static void out(final Object o) {
        System.out.println(o.toString());
    }
    
    static void outn(final String s) {
        System.out.print(s);
    }
    
    static void outn(final int i) {
        System.out.print(i);
    }
    
    static void outn(final double d) {
        System.out.print(d);
    }
    
    static void outn(final long l) {
        System.out.print(l);
    }
    
    static void outn(final char c) {
        System.out.print(c);
    }
    
    static double max(final double a, final double b) {
        return Math.max(a, b);
    }
    
    static long max(final long a, final long b) {
        return Math.max(a, b);
    }
    
    static double min(final double a, final double b) {
        return Math.min(a, b);
    }
    
    static long min(final long a, final long b) {
        return Math.min(a, b);
    }
    
    static {
        Main.Y = "Yes";
        Main.N = "No";
        Main.MOD = (long)(Math.pow(10.0, 9.0) + 7.0);
        Main.sc = new Scanner(System.in);
    }
}
