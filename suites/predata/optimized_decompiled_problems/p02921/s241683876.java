import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        int x = 0;
        if (next.charAt(0) == next2.charAt(0)) {
            ++x;
        }
        if (next.charAt(1) == next2.charAt(1)) {
            ++x;
        }
        if (next.charAt(2) == next2.charAt(2)) {
            ++x;
        }
        System.out.println(x);
    }
}
