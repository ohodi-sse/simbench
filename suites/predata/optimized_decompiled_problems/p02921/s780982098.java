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
        int i = 0;
        int x = 0;
        while (i <= 2) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
            ++i;
        }
        System.out.println(x);
    }
}
