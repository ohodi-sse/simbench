import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        if (nextInt == 1) {
            System.out.println(1);
        }
        else {
            int i;
            for (i = 2; i <= nextInt; i *= 2) {}
            System.out.println(i / 2);
        }
        scanner.close();
    }
}
