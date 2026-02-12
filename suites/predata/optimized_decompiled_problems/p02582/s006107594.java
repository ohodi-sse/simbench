import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (x == 0 && next.charAt(i) == 'R') {
                x = 1;
            }
            if (next.charAt(i) == 'R' && i > 0 && next.charAt(i - 1) == 'R') {
                ++x;
            }
        }
        System.out.println(x);
    }
}
