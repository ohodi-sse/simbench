import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        scanner.close();
        System.out.println(1 << Integer.toBinaryString(nextInt).length() - 1);
    }
}
