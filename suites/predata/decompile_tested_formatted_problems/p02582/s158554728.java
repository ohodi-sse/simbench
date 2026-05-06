import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        int x;
        if (next.equals("RRR")) {
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
