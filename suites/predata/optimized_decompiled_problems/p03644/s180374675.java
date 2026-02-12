import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        for (int i = 1; i <= 7; ++i) {
            if (Math.pow(2.0, i) > nextInt) {
                System.out.print((int)Math.pow(2.0, i - 1));
                return;
            }
        }
    }
}
