import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int i = scanner.nextInt();
        scanner.close();
        int n;
        for (n = 1; i >= n; n *= 2) {}
        System.out.println(n / 2);
    }
}
