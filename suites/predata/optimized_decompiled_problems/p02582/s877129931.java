import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next;
        if ((next = new Scanner(System.in).next()).indexOf("RRR") != -1) {
            System.out.println(3);
            return;
        }
        if (next.indexOf("RR") != -1) {
            System.out.println(2);
            return;
        }
        if (next.indexOf("R") != -1) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}
