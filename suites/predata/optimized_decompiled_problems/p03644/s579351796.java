import java.io.PrintStream;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static int answer(final int n) {
        int n2 = 1;
        for (int i = 0; i < 7; ++i) {
            if (n2 <= n && n < n2 << 1) {
                return n2;
            }
            n2 <<= 1;
        }
        return 0;
    }
    
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        final PrintStream out = System.out;
        int n = 1;
        while (true) {
            for (int i = 0; i < 7; ++i) {
                if (n <= nextInt && nextInt < n << 1) {
                    final int x = n;
                    out.println(x);
                    return;
                }
                n <<= 1;
            }
            final int x = 0;
            continue;
        }
    }
}
