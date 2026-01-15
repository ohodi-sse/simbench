import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int i;
        int n;
        for (i = scanner.nextInt(), n = 0; i != 1; i /= 2, ++n) {}
        System.out.println((int)Math.pow(2.0, n));
        scanner.close();
    }
}
