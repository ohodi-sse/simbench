import java.io.PrintStream;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        int i;
        int n;
        for (i = new Scanner(System.in).nextInt(), n = 0; i != 1; i /= 2, ++n) {}
        final PrintStream out = System.out;
        final int n2 = n;
        int x = 1;
        for (int j = 0; j < n2; ++j) {
            x <<= 1;
        }
        out.println(x);
    }
    
    private static int pow(final int n) {
        int n2 = 1;
        for (int i = 0; i < n; ++i) {
            n2 <<= 1;
        }
        return n2;
    }
}
