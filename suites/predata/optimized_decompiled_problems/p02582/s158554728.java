import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next;
        int x;
        if ((next = (scanner = new Scanner(System.in)).next()).equals("RRR")) {
            x = 3;
        }
        else if (next.equals("RRS") || next.equals("SRR")) {
            x = 2;
        }
        else if (next.equals("SSS")) {
            x = 0;
        }
        else {
            x = 1;
        }
        System.out.println(x);
        scanner.close();
    }
}
