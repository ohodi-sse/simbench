import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next;
        System.out.println((next = new Scanner(System.in).next()).matches("R{3}") ? 3 : (next.matches(".*R{2}.*") ? 2 : next.matches(".*R.*")));
    }
    
    private static int weatherReport(final String s) {
        if (s.matches("R{3}")) {
            return 3;
        }
        if (s.matches(".*R{2}.*")) {
            return 2;
        }
        if (s.matches(".*R.*")) {
            return 1;
        }
        return 0;
    }
}
