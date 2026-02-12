import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        double n = 1.0;
        for (int i = 1; i <= nextInt; ++i) {
            final double pow;
            if ((pow = Math.pow(2.0, i)) > nextInt) {
                System.out.println((int)n);
                return;
            }
            n = pow;
        }
    }
}
