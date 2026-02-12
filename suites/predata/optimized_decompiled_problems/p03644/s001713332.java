import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int int1 = Integer.parseInt(new Scanner(System.in).next());
        int x = 0;
        int numberOfTrailingZeros = 0;
        for (int i = 1; i <= int1; ++i) {
            if (numberOfTrailingZeros <= Integer.numberOfTrailingZeros(i)) {
                x = i;
                numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            }
        }
        System.out.println(x);
    }
}
