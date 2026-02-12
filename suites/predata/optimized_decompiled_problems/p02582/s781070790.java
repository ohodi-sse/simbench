import java.io.PrintStream;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static int findMaxConsecutiveDays(final String s) {
        int n = 0;
        final char[] charArray = s.toCharArray();
        int n2 = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == 'R') {
                ++n2;
            }
            else {
                if (n2 > n) {
                    n = n2;
                }
                n2 = 0;
            }
        }
        if (n2 > n) {
            n = n2;
        }
        return n;
    }
    
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final PrintStream out = System.out;
        int x = 0;
        final char[] charArray = next.toCharArray();
        int n = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == 'R') {
                ++n;
            }
            else {
                if (n > x) {
                    x = n;
                }
                n = 0;
            }
        }
        if (n > x) {
            x = n;
        }
        out.println(x);
        scanner.close();
    }
}
