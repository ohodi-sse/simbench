import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static Scanner sc;
    static StringBuilder sb;
    
    public static void main(final String[] array) {
        final int nextInt = nextInt();
        final int nextInt2 = nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
        }
        else {
            final int[] array2 = new int[210];
            for (int i = 0; i < nextInt2; ++i) {
                final int[] array3 = array2;
                final int nextInt3 = nextInt();
                ++array3[nextInt3];
            }
            int n = 999;
            int x = 0;
            for (int j = -100; j < 105; ++j) {
                if (j >= 0 && array2[j] == 0) {
                    final int abs = Math.abs(j - nextInt);
                    if (abs < n) {
                        n = abs;
                        x = j;
                    }
                }
                if (j < 0) {
                    final int abs2 = Math.abs(j - nextInt);
                    if (abs2 < n) {
                        n = abs2;
                        x = j;
                    }
                }
            }
            System.out.println(x);
        }
    }
    
    static int lcm(final int n, final int n2) {
        return n * n2 * gcd(n, n2);
    }
    
    static int gcd(final int n, final int n2) {
        if (n % n2 != 0) {
            return gcd(n2, n % n2);
        }
        return n2;
    }
    
    static String toSmall(final String s) {
        return s.toLowerCase();
    }
    
    static String toBig(final String s) {
        return s.toUpperCase();
    }
    
    static String next() {
        return Main.sc.next();
    }
    
    static int nextInt() {
        return Integer.parseInt(Main.sc.next());
    }
    
    static long nextLong() {
        return Long.parseLong(Main.sc.next());
    }
    
    static double nextDouble() {
        return Double.parseDouble(Main.sc.next());
    }
    
    static String[] splitString(final String s) {
        return s.split("");
    }
    
    static char[] splitChar(final String s) {
        return s.toCharArray();
    }
    
    static int charToInt(final char c) {
        return c - '0';
    }
    
    public static int max(final int[] array) {
        final int length = array.length;
        int max = array[0];
        for (int i = 1; i < length; ++i) {
            max = Math.max(max, array[i]);
        }
        return max;
    }
    
    public static long max(final long[] array) {
        final int length = array.length;
        long max = array[0];
        for (int i = 1; i < length; ++i) {
            max = Math.max(max, array[i]);
        }
        return max;
    }
    
    public static int min(final int[] array) {
        final int length = array.length;
        int min = array[0];
        for (int i = 1; i < length; ++i) {
            min = Math.min(min, array[i]);
        }
        return min;
    }
    
    public static long min(final long[] array) {
        final int length = array.length;
        long min = array[0];
        for (int i = 1; i < length; ++i) {
            min = Math.min(min, array[i]);
        }
        return min;
    }
    
    static {
        Main.sc = new Scanner(System.in);
        Main.sb = new StringBuilder();
    }
}
