import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        final int[] array = { 1, 2, 4, 8, 16, 32, 64, 128 };
        for (int i = 0; i < 8; ++i) {
            if (array[i] > nextInt) {
                System.out.println(array[i - 1]);
                return;
            }
        }
    }
}
