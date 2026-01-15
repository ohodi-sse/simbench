import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String value = String.valueOf(scanner.nextLong() * (long)(scanner.nextDouble() * 100.0 + 0.5));
        if (value.length() <= 2) {
            System.out.println("0");
        }
        else {
            System.out.println(value.substring(0, value.length() - 2));
        }
    }
}
