import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x;
        if ("RRR".equals(next)) {
            x = 3;
        }
        else if ("RRS".equals(next) || "SRR".equals(next)) {
            x = 2;
        }
        else if (next.contains("R")) {
            x = 1;
        }
        else {
            x = 0;
        }
        System.out.println(x);
    }
}
