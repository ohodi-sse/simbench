import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x = 0;
        if (next.equals("RRR")) {
            x = 3;
        }
        else if (next.contains("RR")) {
            x = 2;
        }
        else if (next.contains("R")) {
            x = 1;
        }
        System.out.println(x);
    }
}
