import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static Scanner scan;
    
    public static void main(final String[] array) {
        final String next = next();
        if (next.contains("RRR")) {
            print(3);
        }
        else if (next.contains("RR")) {
            print(2);
        }
        else if (next.contains("R")) {
            print(1);
        }
        else {
            print(0);
        }
    }
    
    public static int nextInt() {
        return Integer.parseInt(Main.scan.next());
    }
    
    public static long nextLong() {
        return Long.parseLong(Main.scan.next());
    }
    
    public static String next() {
        return Main.scan.next();
    }
    
    public static double nextDouble() {
        return Double.parseDouble(Main.scan.next());
    }
    
    public static float nextFloat() {
        return Float.parseFloat(Main.scan.next());
    }
    
    public static void yesNo(final boolean b) {
        if (b) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
    
    public static void print(final Object x) {
        System.out.println(x);
    }
    
    public static int gcd(int n, int n2) {
        int n3;
        while ((n3 = n % n2) != 0) {
            n = n2;
            n2 = n3;
        }
        return n2;
    }
    
    public static int lcm(int n, int n2) {
        final long n3 = n * (long)n2;
        int n4;
        while ((n4 = n % n2) != 0) {
            n = n2;
            n2 = n4;
        }
        return (int)(n3 / n2);
    }
    
    static {
        Main.scan = new Scanner(System.in);
    }
}
