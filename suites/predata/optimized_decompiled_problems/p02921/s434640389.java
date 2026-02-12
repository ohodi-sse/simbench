import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        final String next = scanner.next();
        final char[] array = new char[3];
        final char[] array2 = new char[3];
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            array[i] = nextLine.charAt(i);
            array2[i] = next.charAt(i);
            if (array[i] == array2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
