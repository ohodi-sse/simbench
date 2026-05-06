import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        if (next.equals("SSS")) {
            System.out.println(0);
            return;
        }
        if (next.equals("RRR")) {
            System.out.println(3);
            return;
        }
        if (next.equals("RRS") || next.equals("SRR")) {
            System.out.println(2);
            return;
        }
        System.out.println(1);
    }
}
