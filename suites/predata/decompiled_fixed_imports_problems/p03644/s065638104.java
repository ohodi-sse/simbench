import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{
    private static Scanner sc;
    private static Printer pr;
    
    private static void solve() {
        final int nextInt = Main.sc.nextInt();
        if (nextInt == 1) {
            Main.pr.println(1);
        }
        else {
            int x;
            for (x = 2; x * 2 <= nextInt; x *= 2) {}
            Main.pr.println(x);
        }
    }
    
    public static void main(final String[] array) {
        Main.sc = new Scanner(System.in);
        Main.pr = new Printer(System.out);
        solve();
        Main.pr.close();
        Main.sc.close();
    }
    
    private static class Printer extends PrintWriter
    {
        Printer(final PrintStream out) {
            super(out);
        }
    }
}