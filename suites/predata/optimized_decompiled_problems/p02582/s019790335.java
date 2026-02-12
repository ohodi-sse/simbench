import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x = 0;
        int x2 = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++x;
            }
            else {
                if (x > x2) {
                    x2 = x;
                }
                x = 0;
            }
        }
        if (x > x2) {
            System.out.println(x);
            return;
        }
        System.out.println(x2);
    }
}
