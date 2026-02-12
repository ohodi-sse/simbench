import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final int int1 = Integer.parseInt(new Scanner(System.in).next());
        int x = 1;
        int n = 0;
        for (int i = 1; i <= int1; ++i) {
            int n2;
            int n3;
            for (n2 = i, n3 = 0; n2 % 2 != 1; n2 /= 2, ++n3) {}
            if (n < n3) {
                x = i;
                n = n3;
            }
        }
        System.out.println(x);
    }
}
