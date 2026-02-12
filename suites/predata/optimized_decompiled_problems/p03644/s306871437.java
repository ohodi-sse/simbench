import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        final int[] array;
        final int length = (array = new int[] { 64, 32, 16, 8, 4, 2, 1 }).length;
        for (int i = 0; i < 7; ++i) {
            final int x = array[i];
            if (nextInt >= x) {
                System.out.println(x);
                return;
            }
        }
    }
}
