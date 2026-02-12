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
        new ATenki();
        final Scanner scanner2 = scanner;
        final PrintWriter printWriter2 = printWriter;
        final Scanner scanner3 = scanner2;
        final String nextLine = scanner2.nextLine();
        final String nextLine2 = scanner3.nextLine();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (nextLine.charAt(i) == nextLine2.charAt(i)) {
                ++x;
            }
        }
        printWriter2.println(x);
        printWriter.close();
    }
    
    static final class ATenki
    {
        private static void solve$32964a28(final Scanner scanner, final PrintWriter printWriter) {
            final String nextLine = scanner.nextLine();
            final String nextLine2 = scanner.nextLine();
            int x = 0;
            for (int i = 0; i < 3; ++i) {
                if (nextLine.charAt(i) == nextLine2.charAt(i)) {
                    ++x;
                }
            }
            printWriter.println(x);
        }
    }
}
