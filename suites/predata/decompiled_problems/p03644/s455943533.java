import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new BBreakNumber().solve(1, scanner, printWriter);
        printWriter.close();
    }
    
    static class BBreakNumber
    {
        public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
            int nextInt;
            int i;
            for (nextInt = scanner.nextInt(), i = 2; i <= nextInt; i *= 2) {}
            printWriter.println(i / 2);
        }
    }
}
import java.io.PrintWriter;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

static class BBreakNumber
{
    public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
        int nextInt;
        int i;
        for (nextInt = scanner.nextInt(), i = 2; i <= nextInt; i *= 2) {}
        printWriter.println(i / 2);
    }
}
