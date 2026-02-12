import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n2 = i / 2;
            int n3 = i % 2;
            boolean b = false;
            int n4 = 0;
            do {
                if (n3 == 0 && n2 == 1) {
                    ++n4;
                    b = true;
                }
                else if (n3 == 0 && n2 != 1) {
                    n2 /= 2;
                    n3 %= 2;
                    ++n4;
                }
                else {
                    if (n3 == 0) {
                        continue;
                    }
                    b = true;
                }
            } while (!b);
            if (n < n4) {
                n = n4;
            }
        }
        System.out.println((int)Math.pow(2.0, n));
    }
}
