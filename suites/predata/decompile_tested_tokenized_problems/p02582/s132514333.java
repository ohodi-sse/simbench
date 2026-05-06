import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        next.toCharArray();
        int x = 0;
        if (next.equals("RRR")) {
            x = 3;
        }
        else if (next.equals("RRS") || next.equals("SRR")) {
            x = 2;
        }
        else if (next.equals("RSS") || next.equals("RSR") || next.equals("SSR") || next.equals("SRS")) {
            x = 1;
        }
        System.out.println(x);
    }
}
