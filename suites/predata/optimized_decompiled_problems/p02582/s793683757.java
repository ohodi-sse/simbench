import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String[] array = { next.substring(0, 1), next.substring(1, 2), next.substring(2, 3) };
        int x = 0;
        if (array[0].equals("R")) {
            ++x;
        }
        int n = 1;
        while (true) {
            final int n2 = n;
            final int length = array.length;
            if (n2 > 2) {
                break;
            }
            if (array[n].equals("R") && array[n - 1].equals("R")) {
                ++x;
            }
            if (array[n].equals("R") && array[n - 1].equals("S")) {
                x = 1;
            }
            ++n;
        }
        System.out.println(x);
        scanner.close();
    }
}
