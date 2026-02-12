import java.io.PrintStream;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final PrintStream out = System.out;
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        final String s = nextLine;
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (s.charAt(i) == nextLine2.charAt(i)) {
                ++x;
            }
        }
        out.println(x);
        scanner.close();
    }
    
    private static int tenki(final String s, final String s2) {
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (s.charAt(i) == s2.charAt(i)) {
                ++n;
            }
        }
        return n;
    }
}
