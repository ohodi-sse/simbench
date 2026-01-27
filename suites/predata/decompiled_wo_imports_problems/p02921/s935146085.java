public class Main
{
    private static Scanner sc;
    
    public static void main(final String[] array) {
        final String next = Main.sc.next();
        final String next2 = Main.sc.next();
        final char[] charArray = next.toCharArray();
        final char[] charArray2 = next2.toCharArray();
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++n;
            }
        }
        p(n);
    }
    
    public static long lcm(final long n, final long n2) {
        return n / gcd(n, n2) * n2;
    }
    
    public static long gcd(final long n, final long n2) {
        return (n2 == 0L) ? n : gcd(n2, n % n2);
    }
    
    static void p(final String x) {
        System.out.println(x);
    }
    
    static void p(final int x) {
        System.out.println(x);
    }
    
    static void p() {
        System.out.println();
    }
    
    static void p(final long x) {
        System.out.println(x);
    }
    
    static void p(final double x) {
        System.out.println(x);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}