import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int max = 0;
        int x = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n = i;
            int b = 0;
            for (int n2 = 1; n2 <= 100 && n % 2 == 0; n /= 2, ++b, ++n2) {}
            if ((max = Math.max(max, b)) == b) {
                x = i;
            }
        }
        System.out.println(x);
    }
}
