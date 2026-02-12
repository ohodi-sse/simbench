import java.io.PrintStream;
import java.io.InputStream;
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
        int max = 0;
        int b = 0;
        char[] charArray;
        for (int length = (charArray = scanner.next().toCharArray()).length, i = 0; i < length; ++i) {
            if (charArray[i] == 'R') {
                ++b;
                max = Math.max(max, b);
            }
            else {
                b = 0;
            }
        }
        out.println(max);
    }
    
    private static void resolve(final InputStream source, final PrintStream printStream) {
        final Scanner scanner = new Scanner(source);
        int max = 0;
        int b = 0;
        char[] charArray;
        for (int length = (charArray = scanner.next().toCharArray()).length, i = 0; i < length; ++i) {
            if (charArray[i] == 'R') {
                ++b;
                max = Math.max(max, b);
            }
            else {
                b = 0;
            }
        }
        printStream.println(max);
    }
}
