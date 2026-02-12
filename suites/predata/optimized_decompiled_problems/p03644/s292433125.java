import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int int1 = Integer.parseInt(new Scanner(System.in).next());
        int x = 0;
        final int[] array = { 1, 2, 4, 8, 16, 32, 64 };
        for (int i = 0; i < 7; ++i) {
            if (array[i] <= int1) {
                x = array[i];
            }
        }
        System.out.println(x);
    }
}
