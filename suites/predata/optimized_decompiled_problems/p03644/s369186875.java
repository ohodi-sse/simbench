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
        printWriter.println((int)Math.pow(2.0, Math.floor(Math.log(scanner.nextInt()) / Math.log(2.0))));
        printWriter.close();
    }
    
    static final class BBreakNumber
    {
        private static void solve$32964a28(final Scanner scanner, final PrintWriter printWriter) {
            printWriter.println((int)Math.pow(2.0, Math.floor(Math.log(scanner.nextInt()) / Math.log(2.0))));
        }
    }
}
