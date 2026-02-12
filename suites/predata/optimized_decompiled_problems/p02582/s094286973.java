import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        scanner.close();
        int n = 0;
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++n;
                if (x < n) {
                    x = n;
                }
            }
            else {
                if (x < n) {
                    x = n;
                }
                n = 0;
            }
        }
        System.out.println(x);
    }
}
