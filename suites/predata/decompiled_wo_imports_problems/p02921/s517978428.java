public final class Main
{
    private static String br;
    private static Scanner sc;
    private static PrintWriter out;
    
    private static void main$3231c38a() {
        final char[] charArray = Main.sc.next().toCharArray();
        final char[] charArray2 = Main.sc.next().toCharArray();
        int i = 0;
        for (int j = 0; j < charArray.length; ++j) {
            if (charArray[j] == charArray2[j]) {
                ++i;
            }
        }
        Main.out.println((Object)i);
        Main.out.flush();
    }
    
    private static int nextInt() {
        return Integer.parseInt(Main.sc.next());
    }
    
    private static Long nextLong() {
        return Long.parseLong(Main.sc.next());
    }
    
    private static String next() {
        return Main.sc.next();
    }
    
    private static String nextLine() {
        return Main.sc.nextLine();
    }
    
    private static void println(final Object x) {
        Main.out.println(x);
        Main.out.flush();
    }
    
    private static void print(final Object obj) {
        final PrintWriter printWriter;
        (printWriter = new PrintWriter(System.out)).print(obj);
        printWriter.flush();
    }
    
    static {
        Main.sc = new Scanner(System.in);
        Main.out = new PrintWriter(System.out);
    }
}