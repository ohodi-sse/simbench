import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Scanner sc;
    private static StringBuilder sb;
    
    private static void main$3231c38a() {
        final int nextInt = nextInt();
        final int nextInt2;
        if ((nextInt2 = nextInt()) == 0) {
            System.out.println(nextInt);
            return;
        }
        final int[] array = new int[210];
        for (int i = 0; i < nextInt2; ++i) {
            final int[] array2 = array;
            final int nextInt3 = nextInt();
            ++array2[nextInt3];
        }
        int n = 999;
        int x = 0;
        for (int j = -100; j < 105; ++j) {
            final int abs;
            if (j >= 0 && array[j] == 0 && (abs = Math.abs(j - nextInt)) < n) {
                n = abs;
                x = j;
            }
            final int abs2;
            if (j < 0 && (abs2 = Math.abs(j - nextInt)) < n) {
                n = abs2;
                x = j;
            }
        }
        System.out.println(x);
    }
    
    private static int lcm(int n, int n2) {
        final int n3 = n * n2;
        int n4;
        for (n = n; n % n2 != 0; n2 = n % n2, n = n4) {
            n4 = n2;
        }
        return n3 * n2;
    }
    
    private static int gcd(int n, int n2) {
        while (n % n2 != 0) {
            final int n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n2;
    }
    
    private static String toSmall(final String s) {
        return s.toLowerCase();
    }
    
    private static String toBig(final String s) {
        return s.toUpperCase();
    }
    
    private static String next() {
        return Main.sc.next();
    }
    
    private static int nextInt() {
        return Integer.parseInt(Main.sc.next());
    }
    
    private static long nextLong() {
        return Long.parseLong(Main.sc.next());
    }
    
    private static double nextDouble() {
        return Double.parseDouble(Main.sc.next());
    }
    
    private static String[] splitString(final String s) {
        return s.split("");
    }
    
    private static char[] splitChar(final String s) {
        return s.toCharArray();
    }
    
    private static int charToInt(final char c) {
        return c - '0';
    }
    
    private static int max(final int[] array) {
        final int length = array.length;
        int max = array[0];
        for (int i = 1; i < length; ++i) {
            max = Math.max(max, array[i]);
        }
        return max;
    }
    
    private static long max(final long[] array) {
        final int length = array.length;
        long max = array[0];
        for (int i = 1; i < length; ++i) {
            max = Math.max(max, array[i]);
        }
        return max;
    }
    
    private static int min(final int[] array) {
        final int length = array.length;
        int min = array[0];
        for (int i = 1; i < length; ++i) {
            min = Math.min(min, array[i]);
        }
        return min;
    }
    
    private static long min(final long[] array) {
        final int length = array.length;
        long min = array[0];
        for (int i = 1; i < length; ++i) {
            min = Math.min(min, array[i]);
        }
        return min;
    }
    
    static {
        Main.sc = new Scanner(System.in);
        new StringBuilder();
    }
}
