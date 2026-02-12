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
        new TaskA();
        final Scanner scanner2 = scanner;
        final PrintWriter printWriter2 = printWriter;
        final Scanner scanner3 = scanner2;
        final String next = scanner2.next();
        final String next2 = scanner3.next();
        int i = 0;
        for (int j = 0; j < next.length(); ++j) {
            if (next.charAt(j) == next2.charAt(j)) {
                ++i;
            }
        }
        printWriter2.print(i);
        printWriter.close();
    }
    
    static final class TaskA
    {
        private static void solve$32964a28(final Scanner scanner, final PrintWriter printWriter) {
            final String next = scanner.next();
            final String next2 = scanner.next();
            int i = 0;
            for (int j = 0; j < next.length(); ++j) {
                if (next.charAt(j) == next2.charAt(j)) {
                    ++i;
                }
            }
            printWriter.print(i);
        }
    }
}
