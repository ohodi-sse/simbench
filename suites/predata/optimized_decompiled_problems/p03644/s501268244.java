import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        int n = 0;
        int x = 1;
        for (int i = 2; i <= nextInt; ++i) {
            int n2 = 0;
            if (i % 2 != 1) {
                int n3 = i;
                do {
                    n3 /= 2;
                    ++n2;
                } while (n3 != 0 && n3 % 2 != 1);
                if (n2 > n) {
                    n = n2;
                    x = i;
                }
            }
        }
        System.out.println(x);
        scanner.close();
    }
}
