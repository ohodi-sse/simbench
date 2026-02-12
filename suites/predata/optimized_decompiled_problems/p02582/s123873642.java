import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x = 0;
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'S') {
                n = 0;
            }
            else if (next.charAt(i) == 'R') {
                ++n;
                if (x < n) {
                    x = n;
                }
            }
        }
        System.out.println(x);
    }
}
