import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 1;
        int n = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n2 = i;
            int n3 = 0;
            while (n2 % 2 == 0) {
                ++n3;
                n2 /= 2;
            }
            if (n3 > n) {
                n = n3;
                x = i;
            }
        }
        System.out.println(x);
    }
}
