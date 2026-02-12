import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        int nextInt;
        int i = nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        while (i > 0) {
            int n2;
            int n3;
            for (n2 = i, n3 = 0; n2 > 0 && n2 % 2 == 0; n2 /= 2, ++n3) {}
            final int n4;
            if ((n4 = n3) > n) {
                n = n4;
                nextInt = i;
            }
            --i;
        }
        System.out.println(nextInt);
    }
    
    private static int cnt(int n) {
        int n2;
        for (n2 = 0; n > 0 && n % 2 == 0; n /= 2, ++n2) {}
        return n2;
    }
}
