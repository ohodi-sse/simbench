import java.io.PrintStream;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        new Solver();
        final PrintStream out = System.out;
        int max = 0;
        int n = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == 'R') {
                max = Math.max(max, i - n + 1);
            }
            else {
                n = i + 1;
            }
        }
        out.println(max);
    }
}
// 
// Decompiled by Procyon v0.6.0
// 

final class Solver
{
    private static int solve(final String s) {
        int max = 0;
        int n = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'R') {
                max = Math.max(max, i - n + 1);
            }
            else {
                n = i + 1;
            }
        }
        return max;
    }
}
