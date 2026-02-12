import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final long long1 = Long.parseLong((scanner = new Scanner(System.in)).next());
        final char[] charArray = scanner.next().toCharArray();
        System.out.println(long1 * (100 * (charArray[0] - '0') + 10 * (charArray[2] - '0') + charArray[3] - 48) / 100L);
    }
}
