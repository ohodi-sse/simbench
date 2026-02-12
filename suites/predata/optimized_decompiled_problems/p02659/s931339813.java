import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final long nextLong = (scanner = new Scanner(System.in)).nextLong();
        final String next = scanner.next();
        final int[] array;
        (array = new int[3])[0] = Integer.parseInt(String.valueOf(next.charAt(0)));
        array[1] = Integer.parseInt(String.valueOf(next.charAt(2)));
        array[2] = Integer.parseInt(String.valueOf(next.charAt(3)));
        final long n = nextLong * array[0];
        final long n2 = nextLong * array[1];
        final long n3 = nextLong * array[2];
        System.out.println(n + n2 / 10L + n3 / 100L + (n2 % 10L * 10L + n3 % 100L) / 100L);
    }
}
