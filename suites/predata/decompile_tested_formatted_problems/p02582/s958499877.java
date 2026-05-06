import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        scanner.close();
        int x = 0;
        if (next.indexOf("R") > -1) {
            x = 1;
        }
        if (next.indexOf("RR") > -1) {
            x = 2;
        }
        if (next.indexOf("RRR") > -1) {
            x = 3;
        }
        System.out.println(x);
    }
}
