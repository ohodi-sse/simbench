import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String nextLine;
        if ((nextLine = new Scanner(System.in).nextLine()).equals("RRR")) {
            System.out.println(3);
            return;
        }
        if (nextLine.contains("RR")) {
            System.out.println(2);
            return;
        }
        if (nextLine.contains("R")) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}
