import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        final String nextLine2 = scanner.nextLine();
        final String substring = nextLine.substring(0, 1);
        final String substring2 = nextLine2.substring(0, 1);
        final String substring3 = nextLine.substring(1, 2);
        final String substring4 = nextLine2.substring(1, 2);
        final String substring5 = nextLine.substring(2);
        final String substring6 = nextLine2.substring(2);
        int x = 0;
        if (nextLine.equals(nextLine2)) {
            System.out.println(3);
        }
        else {
            if (substring.equals(substring2)) {
                ++x;
            }
            if (substring3.equals(substring4)) {
                ++x;
            }
            if (substring5.equals(substring6)) {
                ++x;
            }
            System.out.println(x);
        }
        scanner.close();
    }
}
