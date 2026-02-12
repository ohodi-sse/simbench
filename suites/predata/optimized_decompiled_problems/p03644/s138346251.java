import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int max = 0;
        int x = 0;
        for (int i = 1; i <= nextInt; ++i) {
            int n = i;
            int n2 = 0;
            while (n % 2 == 0) {
                ++n2;
                n /= 2;
            }
            final int b = n2;
            max = Math.max(max, b);
            if (b == max) {
                x = i;
            }
        }
        System.out.println(x);
    }
    
    private static int counttwo(int n) {
        int n2 = 0;
        while (n % 2 == 0) {
            ++n2;
            n /= 2;
        }
        return n2;
    }
}
