import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final double nextDouble = new Scanner(System.in).nextDouble();
        double n = 0.0;
        for (double b = 0.0; Math.pow(2.0, b) <= nextDouble; ++b) {
            ++n;
        }
        System.out.println((int)Math.pow(2.0, n - 1.0));
    }
}
