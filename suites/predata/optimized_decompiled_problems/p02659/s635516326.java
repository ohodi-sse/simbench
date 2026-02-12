import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Scanner sc;
    private static StringBuilder sb;
    
    private static void main$3231c38a() {
        final long long1 = Long.parseLong(Main.sc.next());
        final String[] split = Main.sc.next().split("");
        String s = "";
        for (int i = 0; i < 4; ++i) {
            if (!split[i].equals(".")) {
                s += split[i];
            }
        }
        System.out.println(long1 * Long.parseLong(s) / 100L);
    }
    
    private static int lcm(int n, int n2) {
        final int n3 = n * n2;
        final int n4 = n;
        int n5;
        for (n2 = n2, n = n4; n % n2 != 0; n2 = n % n2, n = n5) {
            n5 = n2;
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
