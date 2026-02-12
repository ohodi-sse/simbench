import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        for (int i = 6; i >= 0; --i) {
            if (Math.pow(2.0, i) <= nextInt) {
                System.out.println((int)Math.pow(2.0, i));
                return;
            }
        }
    }
}
