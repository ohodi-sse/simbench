import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long n = scanner.nextLong() * Integer.parseInt(scanner.next().replace(".", ""));
        System.err.println(n);
        final String string = Long.toString(n);
        final int length = string.length();
        String substring;
        if (length >= 3) {
            substring = string.substring(0, length - 2);
        }
        else {
            substring = "0";
        }
        System.out.println(substring);
    }
}
