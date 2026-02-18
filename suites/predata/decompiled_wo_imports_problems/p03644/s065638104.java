public final class Main
{
    private static Scanner sc;
    private static Printer pr;
    
    private static void solve() {
        final int nextInt;
        if ((nextInt = Main.sc.nextInt()) == 1) {
            Main.pr.println(1);
            return;
        }
        int x;
        for (x = 2; x << 1 <= nextInt; x <<= 1) {}
        Main.pr.println(x);
    }
    
    private static void main$3231c38a() {
        Main.sc = new Scanner(System.in);
        Main.pr = new Printer(System.out);
        final int nextInt;
        if ((nextInt = Main.sc.nextInt()) == 1) {
            Main.pr.println(1);
        }
        else {
            int x;
            for (x = 2; x << 1 <= nextInt; x <<= 1) {}
            Main.pr.println(x);
        }
        Main.pr.close();
        Main.sc.close();
    }
    
    private static final class Printer extends PrintWriter
    {
        Printer(final PrintStream out) {
            super(out);
        }
    }
}