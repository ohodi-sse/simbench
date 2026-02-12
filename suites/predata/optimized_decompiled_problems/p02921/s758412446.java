import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        final String nextLine2 = scanner.nextLine();
        int x = 0;
        if (nextLine.charAt(0) == nextLine2.charAt(0)) {
            ++x;
        }
        if (nextLine.charAt(1) == nextLine2.charAt(1)) {
            ++x;
        }
        if (nextLine.charAt(2) == nextLine2.charAt(2)) {
            ++x;
        }
        System.out.println(x);
    }
}
