import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next;
        System.out.println((scanner = new Scanner(System.in)).nextLong() * (Integer.parseInt(Character.toString((next = scanner.next()).charAt(0))) * 100 + Integer.parseInt(Character.toString(next.charAt(2))) * 10 + Integer.parseInt(Character.toString(next.charAt(3)))) / 100L);
        scanner.close();
    }
}
