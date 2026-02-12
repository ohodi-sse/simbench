import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static int MOD = 1000000007;
    
    private static void main$3231c38a() {
        new MyScanner();
        final String nextLine = MyScanner.nextLine();
        final String nextLine2 = MyScanner.nextLine();
        int x = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i) == nextLine2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    static final class MyScanner
    {
        private static Scanner sc;
        
        private static String next() {
            return MyScanner.sc.next();
        }
        
        static String nextLine() {
            return MyScanner.sc.nextLine();
        }
        
        private static int nextInt() {
            return Integer.parseInt(MyScanner.sc.next());
        }
        
        private static double nextDouble() {
            return Double.parseDouble(MyScanner.sc.next());
        }
        
        private static long nextLong() {
            return Long.parseLong(MyScanner.sc.next());
        }
        
        private static int[] nextIntArray(final int n) {
            final int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = nextInt();
            }
            return array;
        }
        
        private double[] nextDoubleArray(final int n) {
            final double[] array = new double[n];
            for (int i = 0; i < n; ++i) {
                array[i] = nextDouble();
            }
            return array;
        }
        
        private long[] nextLongArray(final int n) {
            final long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = nextLong();
            }
            return array;
        }
        
        private static String[] nextLineArray(final int n) {
            final String[] array = new String[n];
            for (int i = 0; i < n; ++i) {
                array[i] = MyScanner.sc.nextLine();
            }
            return array;
        }
        
        private static int[][] nextIntMatrix(final int n, final int n2) {
            final int[][] array = new int[n][n2];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n2; ++j) {
                    array[i][j] = nextInt();
                }
            }
            return array;
        }
        
        private double[][] nextDoubleMatrix(final int n, final int n2) {
            final double[][] array = new double[n][n2];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n2; ++j) {
                    array[i][j] = nextDouble();
                }
            }
            return array;
        }
        
        private long[][] nextLongMatrix(final int n, final int n2) {
            final long[][] array = new long[n][n2];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n2; ++j) {
                    array[i][j] = nextLong();
                }
            }
            return array;
        }
        
        static {
            MyScanner.sc = new Scanner(System.in);
        }
    }
}
