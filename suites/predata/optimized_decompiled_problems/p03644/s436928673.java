import java.io.PrintStream;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        final PrintStream out = System.out;
        int x = 1;
        int n = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n2 = 0;
            for (int n3 = i; n3 % 2 == 0 && n3 > 0; n3 /= 2, ++n2) {}
            if (n < n2) {
                x = i;
                n = n2;
            }
        }
        out.println(x);
    }
    
    private static int search(final int n) {
        int n2 = 1;
        int n3 = 0;
        for (int i = 1; i <= n; ++i) {
            int n4 = 0;
            for (int n5 = i; n5 % 2 == 0 && n5 > 0; n5 /= 2, ++n4) {}
            if (n3 < n4) {
                n2 = i;
                n3 = n4;
            }
        }
        return n2;
    }
}
