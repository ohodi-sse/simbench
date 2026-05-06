import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int i;
        int x;
        for (i = scanner.nextInt(), x = 1; i >= x * 2; x *= 2) {}
        System.out.println(x);
        scanner.close();
    }
}
