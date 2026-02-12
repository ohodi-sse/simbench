import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        int i = new Scanner(System.in).nextInt();
        int max = 1;
        while (i > 0) {
            int b = 0;
            for (int n = 2; i % n == 0; n <<= 1) {
                b = n;
            }
            max = Math.max(max, b);
            --i;
        }
        System.out.println(max);
    }
}
