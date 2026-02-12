import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String nextLine;
        if ((nextLine = new Scanner(System.in).nextLine()).equals("RRS") || nextLine.equals("SRR")) {
            System.out.println(2);
            return;
        }
        if (nextLine.equals("RRR")) {
            System.out.println(3);
            return;
        }
        if (nextLine.equals("SSS")) {
            System.out.println(0);
            return;
        }
        System.out.println(1);
    }
}
