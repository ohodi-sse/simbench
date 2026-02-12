import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final long n = scanner.nextLong() * Integer.parseInt(scanner.next().replace(".", ""));
        System.err.println(n);
        final String string;
        final int length;
        String substring;
        if ((length = (string = Long.toString(n)).length()) >= 3) {
            substring = string.substring(0, length - 2);
        }
        else {
            substring = "0";
        }
        System.out.println(substring);
    }
}
