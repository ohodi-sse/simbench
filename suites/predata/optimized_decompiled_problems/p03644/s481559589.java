import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int x = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n2 = 0;
            for (int n3 = i; n3 % 2 == 0; n3 /= 2) {
                ++n2;
            }
            if (n <= n2) {
                x = i;
                n = n2;
            }
        }
        System.out.println(x);
    }
}
