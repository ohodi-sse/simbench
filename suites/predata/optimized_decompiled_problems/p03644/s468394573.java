import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        for (int i = 1; i <= nextInt; i <<= 1) {
            ++n;
        }
        --n;
        System.out.println(1 << n);
    }
}
