import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int int1 = Integer.parseInt(new Scanner(System.in).nextLine());
        int n = 0;
        int x = 0;
        for (int i = 1; i <= int1; ++i) {
            int n2;
            int n3;
            for (n2 = i, n3 = 0; n2 % 2 == 0; n2 /= 2, ++n3) {}
            if (n3 > n) {
                n = n3;
                x = i;
            }
        }
        if (x == 0) {
            x = 1;
        }
        System.out.println(x);
    }
}
