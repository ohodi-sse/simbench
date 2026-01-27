public class Main
{
    static Scanner sc;
    static StringBuilder sb;
    
    public static void main(final String[] array) {
        final long nextLong = nextLong();
        final String[] splitString = splitString(next());
        String s = "";
        for (int i = 0; i < 4; ++i) {
            if (!splitString[i].equals(".")) {
                s += splitString[i];
            }
        }
        System.out.println(nextLong * Long.parseLong(s) / 100L);
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