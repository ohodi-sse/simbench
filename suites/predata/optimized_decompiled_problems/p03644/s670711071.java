import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static int[] a1;
    private static int[] b1;
    private static Scanner sc;
    private static int K;
    
    private static void p(final String x) {
        System.out.println(x);
    }
    
    private static void p(final int x) {
        System.out.println(x);
    }
    
    private static void p(final long x) {
        System.out.println(x);
    }
    
    private static void p(final double x) {
        System.out.println(x);
    }
    
    private static void main$3231c38a() {
        final int nextInt = Main.sc.nextInt();
        int n = 0;
        int x = 1;
        int n2 = 0;
        for (int i = 1; i <= nextInt; ++i) {
            for (int n3 = i; n3 % 2 != 1; n3 /= 2, ++n2) {}
            if (n < n2) {
                n = n2;
                x = i;
            }
            n2 = 0;
        }
        System.out.println(x);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}
