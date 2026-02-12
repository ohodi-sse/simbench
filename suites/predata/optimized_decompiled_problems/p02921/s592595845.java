import java.io.PrintStream;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        Scanner scanner = null;
        PrintStream out = null;
        try {
            scanner = new Scanner(System.in);
            out = System.out;
            final Scanner scanner2 = scanner;
            final PrintStream printStream = out;
            final Scanner scanner3 = scanner2;
            final String next = scanner2.next();
            final String next2 = scanner3.next();
            int x = 0;
            for (int i = 0; i < 3; ++i) {
                if (next.charAt(i) == next2.charAt(i)) {
                    ++x;
                }
            }
            printStream.println(x);
            if (out != null) {
                out.close();
            }
            scanner.close();
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        finally {
            if (out != null) {
                out.close();
            }
            if (scanner != null) {
                scanner.close();
            }
        }
        System.exit(0);
    }
    
    private static void exec(final Scanner scanner, final PrintStream printStream) throws Exception {
        final String next = scanner.next();
        final String next2 = scanner.next();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        printStream.println(x);
    }
}
