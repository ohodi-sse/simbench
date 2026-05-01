import java.util.Scanner;





public class Main
{
    public static Scanner scan;
    
    public static void main(final String[] array) {
        final int nextInt = nextInt();
        final int nextInt2 = nextInt();
        if (nextInt2 == 0) {
            print(nextInt);
            System.exit(0);
        }
        boolean b = true;
        final int[] array2 = new int[nextInt2];
        int n = 1000;
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = nextInt();
        }
        final int[] array3 = array2;
        for (int length = array3.length, j = 0; j < length; ++j) {
            if (nextInt == array3[j]) {
                b = false;
            }
        }
        if (b) {
            print(nextInt);
            System.exit(0);
        }
        for (int k = 1; k < 101; ++k) {
            boolean b2 = true;
            final int n2 = nextInt - k;
            final int[] array4 = array2;
            for (int length2 = array4.length, l = 0; l < length2; ++l) {
                if (array4[l] == n2) {
                    b2 = false;
                    break;
                }
                b2 = true;
                n = n2;
            }
            if (b2) {
                print(n);
                System.exit(0);
            }
            boolean b3 = true;
            final int n3 = nextInt + k;
            final int[] array5 = array2;
            for (int length3 = array5.length, n4 = 0; n4 < length3; ++n4) {
                if (array5[n4] == n3) {
                    b3 = false;
                    break;
                }
                b3 = true;
                n = n3;
            }
            if (b3) {
                print(n);
                System.exit(0);
            }
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