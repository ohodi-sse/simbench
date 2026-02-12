import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String next;
        final long longValue = Long.valueOf((next = scanner.next()).substring(0, 1));
        final long longValue2 = Long.valueOf(next.substring(2, 3));
        System.out.println(nextLong * longValue + nextLong * longValue2 / 10L + (nextLong * longValue2 % 10L * 10L + nextLong * Long.valueOf(next.substring(3, 4))) / 100L);
    }
}
