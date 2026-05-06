import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long long1 = Long.parseLong(scanner.next());
        final char[] charArray = scanner.next().toCharArray();
        System.out.println(long1 * (100 * (charArray[0] - '0') + 10 * (charArray[2] - '0') + charArray[3] - 48) / 100L);
    }
}
