import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        final String next;
        if ((next = new Scanner(System.in).next()).equals("SSS")) {
            System.out.println(0);
        }
        if (next.equals("RRR")) {
            System.out.println(3);
        }
        if (next.equals("RRS") || next.equals("SRR")) {
            System.out.println(2);
        }
        if (next.equals("RSR") || next.equals("SRS") || next.equals("SSR") || next.equals("RSS")) {
            System.out.println(1);
        }
    }
}
