public final class Main
{
    private static Scanner scan;
    
    private static void main$3231c38a() {
        final int nextInt = nextInt();
        final int nextInt2;
        if ((nextInt2 = nextInt()) == 0) {
            System.out.println((Object)nextInt);
            System.exit(0);
        }
        boolean b = true;
        final int[] array = new int[nextInt2];
        int n = 1000;
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = nextInt();
        }
        int[] array2;
        for (int length = (array2 = array).length, j = 0; j < length; ++j) {
            if (nextInt == array2[j]) {
                b = false;
            }
        }
        if (b) {
            System.out.println((Object)nextInt);
            System.exit(0);
        }
        for (int k = 1; k < 101; ++k) {
            boolean b2 = true;
            final int n2 = nextInt - k;
            int[] array3;
            for (int length2 = (array3 = array).length, l = 0; l < length2; ++l) {
                if (array3[l] == n2) {
                    b2 = false;
                    break;
                }
                b2 = true;
                n = n2;
            }
            if (b2) {
                System.out.println((Object)n);
                System.exit(0);
            }
            boolean b3 = true;
            final int n3 = nextInt + k;
            int[] array4;
            for (int length3 = (array4 = array).length, n4 = 0; n4 < length3; ++n4) {
                if (array4[n4] == n3) {
                    b3 = false;
                    break;
                }
                b3 = true;
                n = n3;
            }
            if (b3) {
                System.out.println((Object)n);
                System.exit(0);
            }
        }
    }
    
    private static int nextInt() {
        return Integer.parseInt(Main.scan.next());
    }
    
    private static long nextLong() {
        return Long.parseLong(Main.scan.next());
    }
    
    private static String next() {
        return Main.scan.next();
    }
    
    private static double nextDouble() {
        return Double.parseDouble(Main.scan.next());
    }
    
    private static float nextFloat() {
        return Float.parseFloat(Main.scan.next());
    }
    
    private static void yesNo(final boolean b) {
        if (b) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
    }
    
    private static void print(final Object x) {
        System.out.println(x);
    }
    
    private static int gcd(int n, int n2) {
        int n3;
        while ((n3 = n % n2) != 0) {
            n = n2;
            n2 = n3;
        }
        return n2;
    }
    
    private static int lcm(int n, int n2) {
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