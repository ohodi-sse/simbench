import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();
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
