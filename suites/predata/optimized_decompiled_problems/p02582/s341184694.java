import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final char[] charArray = (scanner = new Scanner(System.in)).next().toCharArray();
        scanner.close();
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == 'R') {
                ++n;
            }
        }
        if (n == 3) {
            System.out.println("3");
            return;
        }
        if (n == 1) {
            System.out.println("1");
            return;
        }
        if (n != 2) {
            System.out.println("0");
            return;
        }
        if (charArray[1] == 'S') {
            System.out.println("1");
            return;
        }
        System.out.println("2");
    }
}
