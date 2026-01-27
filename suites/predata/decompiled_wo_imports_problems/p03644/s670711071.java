public class Main
{
    static int[] a1;
    static int[] b1;
    private static Scanner sc;
    static int K;
    
    static void p(final String x) {
        System.out.println(x);
    }
    
    static void p(final int x) {
        System.out.println(x);
    }
    
    static void p(final long x) {
        System.out.println(x);
    }
    
    static void p(final double x) {
        System.out.println(x);
    }
    
    public static void main(final String[] array) {
        final int nextInt = Main.sc.nextInt();
        int n = 0;
        int n2 = 1;
        int n3 = 0;
        for (int i = 1; i <= nextInt; ++i) {
            for (int n4 = i; n4 % 2 != 1; n4 /= 2, ++n3) {}
            if (n < n3) {
                n = n3;
                n2 = i;
            }
            n3 = 0;
        }
        p(n2);
    }
    
    static {
        Main.a1 = new int[] { 0, -1, 0, 1 };
        Main.b1 = new int[] { -1, 0, 1, 0 };
        Main.sc = new Scanner(System.in);
    }
}