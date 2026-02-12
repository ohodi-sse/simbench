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
        new ForbiddenList();
        final Scanner scanner2 = scanner;
        final PrintWriter printWriter2 = printWriter;
        final Scanner scanner3 = scanner2;
        final int nextInt = scanner2.nextInt();
        Label_0214: {
            final int nextInt2;
            if ((nextInt2 = scanner3.nextInt()) == 0) {
                printWriter2.append(String.valueOf(nextInt));
            }
            else {
                final boolean[] array = new boolean[101];
                for (int i = 0; i < nextInt2; ++i) {
                    array[scanner3.nextInt()] = true;
                }
                int n2;
                for (int n = 0; (n2 = nextInt - n) < 0 || n2 > 100 || array[n2]; ++n) {
                    final int n3;
                    if ((n3 = nextInt + n) >= 0 && n3 <= 100 && !array[n3]) {
                        printWriter2.append(String.valueOf(n3));
                        break Label_0214;
                    }
                    if (n2 <= 0) {
                        printWriter2.append(String.valueOf(n2));
                        break Label_0214;
                    }
                    if (100 < n3) {
                        printWriter2.append(String.valueOf(n3));
                        break Label_0214;
                    }
                }
                printWriter2.append(String.valueOf(n2));
            }
        }
        printWriter.close();
    }
    
    static final class ForbiddenList
    {
        private static void solve$32964a28(final Scanner scanner, final PrintWriter printWriter) {
            final int nextInt = scanner.nextInt();
            final int nextInt2;
            if ((nextInt2 = scanner.nextInt()) == 0) {
                printWriter.append(String.valueOf(nextInt));
                return;
            }
            final boolean[] array = new boolean[101];
            for (int i = 0; i < nextInt2; ++i) {
                array[scanner.nextInt()] = true;
            }
            int n2;
            for (int n = 0; (n2 = nextInt - n) < 0 || n2 > 100 || array[n2]; ++n) {
                final int n3;
                if ((n3 = nextInt + n) >= 0 && n3 <= 100 && !array[n3]) {
                    printWriter.append(String.valueOf(n3));
                    return;
                }
                if (n2 <= 0) {
                    printWriter.append(String.valueOf(n2));
                    return;
                }
                if (100 < n3) {
                    printWriter.append(String.valueOf(n3));
                    return;
                }
            }
            printWriter.append(String.valueOf(n2));
        }
    }
}
