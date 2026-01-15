import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final long long1 = Long.parseLong(scanner.next());
        final String next = scanner.next();
        final int[] array2 = { Integer.parseInt(String.valueOf(next.charAt(0))), Integer.parseInt(String.valueOf(next.charAt(2))), Integer.parseInt(String.valueOf(next.charAt(3))) };
        scanner.close();
        final long n = long1 * array2[0];
        final long n2 = long1 * array2[1];
        final long n3 = long1 * array2[2];
        System.out.println(n + n2 / 10L + n3 / 100L + (n2 % 10L * 10L + n3 % 100L) / 100L);
    }
}
