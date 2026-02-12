import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        for (int i = 1; i < 7; ++i) {
            final int n = (int)Math.pow(2.0, i);
            if (nextInt == n) {
                System.out.println((int)Math.pow(2.0, i));
                return;
            }
            if (nextInt < n) {
                System.out.println((int)Math.pow(2.0, i - 1));
                return;
            }
        }
        System.out.println(64);
    }
}
