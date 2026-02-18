public final class Main
{
    private static Scanner sc;
    
    private static void main$3231c38a() {
        final String next = Main.sc.next();
        final String next2 = Main.sc.next();
        final char[] charArray = next.toCharArray();
        final char[] charArray2 = next2.toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static long lcm(final long n, final long n2) {
        long n3;
        long n4;
        long n5;
        for (n3 = n2, n4 = n; n3 != 0L; n3 = n4 % n3, n4 = n5) {
            n5 = n3;
        }
        return n / n4 * n2;
    }
    
    private static long gcd(long n, long n2) {
        while (n2 != 0L) {
            final long n3 = n2;
            n2 = n % n2;
            n = n3;
        }
        return n;
    }
    
    private static void p(final String x) {
        System.out.println(x);
    }
    
    private static void p(final int x) {
        System.out.println(x);
    }
    
    private static void p() {
        System.out.println();
    }
    
    private static void p(final long x) {
        System.out.println(x);
    }
    
    private static void p(final double x) {
        System.out.println(x);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}