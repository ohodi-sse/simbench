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
        new A().solve(1, scanner, printWriter);
        printWriter.close();
    }
    
    static class A
    {
        public void solve(final int n, final Scanner scanner, final PrintWriter printWriter) {
            final String next = scanner.next();
            final String next2 = scanner.next();
            int x = 0;
            if (next.charAt(0) == next2.charAt(0)) {
                ++x;
            }
            if (next.charAt(1) == next2.charAt(1)) {
                ++x;
            }
            if (next.charAt(2) == next2.charAt(2)) {
                ++x;
            }
            printWriter.println(x);
        }
    }
}
