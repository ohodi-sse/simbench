import java.io.PrintStream;
import java.io.InputStream;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        final String next = new Scanner(in).next();
        int n = 0;
        int max = 0;
        int b = 0;
        for (int i = 0; i < 3; ++i) {
            int n2 = 0;
            if (next.charAt(i) == 'R') {
                n2 = 1;
                if (n != 0) {
                    ++b;
                }
                else {
                    b = 1;
                }
            }
            else {
                b = 0;
            }
            n = n2;
            max = Math.max(max, b);
        }
        out.println(max);
    }
    
    private static void solve(final InputStream source, final PrintStream printStream) {
        final String next = new Scanner(source).next();
        int n = 0;
        int max = 0;
        int b = 0;
        for (int i = 0; i < 3; ++i) {
            int n2 = 0;
            if (next.charAt(i) == 'R') {
                n2 = 1;
                if (n != 0) {
                    ++b;
                }
                else {
                    b = 1;
                }
            }
            else {
                b = 0;
            }
            n = n2;
            max = Math.max(max, b);
        }
        printStream.println(max);
    }
}
