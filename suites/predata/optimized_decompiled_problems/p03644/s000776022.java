import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        if (1 < nextInt && nextInt < 4) {
            System.out.println(2);
            return;
        }
        if (4 <= nextInt && nextInt < 8) {
            System.out.println(4);
            return;
        }
        if (8 <= nextInt && nextInt < 16) {
            System.out.println(8);
            return;
        }
        if (16 <= nextInt && nextInt < 32) {
            System.out.println(16);
            return;
        }
        if (32 <= nextInt && nextInt < 64) {
            System.out.println(32);
            return;
        }
        if (nextInt == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(64);
    }
}
