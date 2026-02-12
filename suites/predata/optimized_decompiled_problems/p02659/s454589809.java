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
        new Multiplication3();
        final Scanner scanner2 = scanner;
        final PrintWriter printWriter2 = printWriter;
        final String[] split = scanner2.nextLine().split(" ");
        printWriter2.append(String.valueOf(Long.parseLong(split[0]) * Long.parseLong(split[1].replaceAll("\\.", "")) / 100L));
        printWriter.close();
    }
    
    static final class Multiplication3
    {
        private static void solve$32964a28(final Scanner scanner, final PrintWriter printWriter) {
            final String[] split = scanner.nextLine().split(" ");
            printWriter.append(String.valueOf(Long.parseLong(split[0]) * Long.parseLong(split[1].replaceAll("\\.", "")) / 100L));
        }
    }
}
