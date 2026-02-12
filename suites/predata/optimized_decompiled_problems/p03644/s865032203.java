import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int n2 = 0;
        int x = 0;
        for (int i = nextInt; i > 0; --i) {
            if (nextInt == 1) {
                x = 1;
                break;
            }
            if (i % 2 == 0) {
                int n3 = i;
                final int n4 = i;
                while (n3 % 2 == 0) {
                    ++n;
                    n3 /= 2;
                }
                if (n2 < n) {
                    n2 = n;
                    x = n4;
                }
                n = 0;
            }
        }
        System.out.println(x);
    }
}
