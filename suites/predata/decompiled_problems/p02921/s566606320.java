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
        new TaskA().solve(1, scanner, printWriter);
        printWriter.close();
    }
    
    static class TaskA
    {
        public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
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
