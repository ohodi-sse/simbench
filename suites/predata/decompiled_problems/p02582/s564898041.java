import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        int x = 0;
        if (next.equals("RRR")) {
            x = 3;
        }
        else if (next.equals("RRS") || next.equals("SRR")) {
            x = 2;
        }
        else if (next.equals("RSS") || next.equals("SRS") || next.equals("SSR") || next.equals("RSR")) {
            x = 1;
        }
        else if (next.equals("SSS")) {
            x = 0;
        }
        System.out.println(x);
        scanner.close();
    }
}
