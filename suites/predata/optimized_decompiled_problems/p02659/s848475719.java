import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final char[] charArray;
        System.out.println((scanner = new Scanner(System.in)).nextLong() * (((charArray = scanner.next().toCharArray())[0] - '0') * 100 + (charArray[2] - '0') * 10 + (charArray[3] - '0')) / 100L);
    }
}
