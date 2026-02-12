import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        int x = 0;
        if (nextLine.contains("R")) {
            x = 1;
        }
        if (nextLine.contains("RR")) {
            x = 2;
        }
        if (nextLine.contains("RRR")) {
            x = 3;
        }
        System.out.println(x);
        scanner.close();
    }
}
