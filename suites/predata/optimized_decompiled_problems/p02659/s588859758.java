import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String next = scanner.next();
        String s = "";
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) != '.') {
                s += next.charAt(i);
            }
        }
        System.out.println(nextLong * new Integer(s) / 100L);
    }
}
