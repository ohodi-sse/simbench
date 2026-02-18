public final class Main
{
    private static Scanner scan;
    
    private static void main$3231c38a() {
        final String next;
        if ((next = Main.scan.next()).contains("RRR")) {
            System.out.println((Object)3);
            return;
        }
        if (next.contains("RR")) {
            System.out.println((Object)2);
            return;
        }
        if (next.contains("R")) {
            System.out.println((Object)1);
            return;
        }
        System.out.println((Object)0);
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