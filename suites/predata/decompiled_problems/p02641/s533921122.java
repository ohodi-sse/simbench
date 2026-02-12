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
        new ForbiddenList().solve(1, scanner, printWriter);
        printWriter.close();
    }
    
    static class ForbiddenList
    {
        public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
            final int nextInt = scanner.nextInt();
            final int nextInt2 = scanner.nextInt();
            if (nextInt2 == 0) {
                printWriter.append(String.valueOf(nextInt));
                return;
            }
            final boolean[] array = new boolean[101];
            for (int i = 0; i < nextInt2; ++i) {
                array[scanner.nextInt()] = true;
            }
            int n2 = 0;
            while (true) {
                final int n3 = nextInt - n2;
                if (0 <= n3 && n3 <= 100 && !array[n3]) {
                    printWriter.append(String.valueOf(n3));
                    return;
                }
                final int n4 = nextInt + n2;
                if (0 <= n4 && n4 <= 100 && !array[n4]) {
                    printWriter.append(String.valueOf(n4));
                    return;
                }
                if (n3 <= 0) {
                    printWriter.append(String.valueOf(n3));
                    return;
                }
                if (100 < n4) {
                    printWriter.append(String.valueOf(n4));
                    return;
                }
                ++n2;
            }
        }
    }
}
