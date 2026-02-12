import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static Scanner sc;
    
    private static void main$3231c38a() {
        final String next;
        if ((next = Main.sc.next()).equals("RRR")) {
            System.out.println(3);
            return;
        }
        if (next.equals("RSR") || next.equals("RSS") || next.equals("SSR") || next.equals("SRS")) {
            System.out.println(1);
            return;
        }
        if (next.equals("SSS")) {
            System.out.println(0);
            return;
        }
        System.out.println(2);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}
