import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt;
        if ((nextInt = new Scanner(System.in).nextInt()) >= 64) {
            System.out.println(64);
            return;
        }
        if (nextInt >= 32) {
            System.out.println(32);
            return;
        }
        if (nextInt >= 16) {
            System.out.println(16);
            return;
        }
        if (nextInt >= 8) {
            System.out.println(8);
            return;
        }
        if (nextInt >= 4) {
            System.out.println(4);
            return;
        }
        if (nextInt >= 2) {
            System.out.println(2);
            return;
        }
        System.out.println(1);
    }
    
    private static int sample() {
        return 1;
    }
}
