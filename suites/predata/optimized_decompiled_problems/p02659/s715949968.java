import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String[] split = scanner.next().split("\\.");
        System.out.println(nextLong * (Long.valueOf(split[0]) * 100L + Long.valueOf(split[1])) / 100L);
    }
}
