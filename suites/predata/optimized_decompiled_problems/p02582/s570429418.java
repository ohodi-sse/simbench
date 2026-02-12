import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < 3; ++i) {
            if (next.charAt(i) == 'R') {
                ++n2;
            }
            else {
                n2 = 0;
            }
            if (n2 > n) {
                n = n2;
            }
        }
        System.out.println("" + n);
    }
}
