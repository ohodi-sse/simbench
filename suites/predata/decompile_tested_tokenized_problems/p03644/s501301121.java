import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        scanner.close();
        int n;
        for (n = 0; i > 1; i /= 2, ++n) {}
        System.out.println(1 << n);
    }
}
