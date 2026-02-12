import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next;
        System.out.println((next = new Scanner(System.in).next()).contains("RRR") ? 3 : (next.contains("RR") ? 2 : next.contains("R")));
    }
    
    private static int solve(final String s) {
        if (s.contains("RRR")) {
            return 3;
        }
        if (s.contains("RR")) {
            return 2;
        }
        if (s.contains("R")) {
            return 1;
        }
        return 0;
    }
}
