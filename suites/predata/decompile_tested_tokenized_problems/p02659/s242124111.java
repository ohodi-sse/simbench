import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLong() * (long)(double)Math.round(scanner.nextDouble() * 100.0) / 100L);
        scanner.close();
    }
}
