import java.io.PrintStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final Scanner scanner = new Scanner(in);
        final PrintWriter printWriter = new PrintWriter(out);
        new BBreakNumber();
        final Scanner scanner2 = scanner;
        final PrintWriter printWriter2 = printWriter;
        int nextInt;
        int i;
        for (nextInt = scanner2.nextInt(), i = 2; i <= nextInt; i <<= 1) {}
        printWriter2.println(i / 2);
        printWriter.close();
    }
    
    static final class BBreakNumber
    {
        private static void solve$32964a28(final Scanner scanner, final PrintWriter printWriter) {
            int nextInt;
            int i;
            for (nextInt = scanner.nextInt(), i = 2; i <= nextInt; i <<= 1) {}
            printWriter.println(i / 2);
        }
    }
}
