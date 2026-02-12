import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int n2 = -1;
        int x = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n3 = i;
            int j = 1;
            while (j != 0) {
                if (n3 % 2 == 0) {
                    ++n;
                    n3 /= 2;
                }
                else {
                    j = 0;
                }
            }
            if (n2 < n) {
                n2 = n;
                x = i;
            }
            n = 0;
        }
        System.out.println(x);
    }
}
