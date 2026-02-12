import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int n = 0;
        int n2 = 0;
        int x = 0;
        for (int i = scanner.nextInt(); i > 0; --i) {
            for (int n3 = i; n3 % 2 == 0 && n3 > 0; n3 /= 2) {
                ++n2;
            }
            if (n <= n2) {
                n = n2;
                x = i;
            }
            n2 = 0;
        }
        System.out.println(x);
        scanner.close();
    }
}
