import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt;
        if ((nextInt = new Scanner(System.in).nextInt()) == 1) {
            System.out.println(nextInt);
            return;
        }
        int x = 0;
        int i = 1;
    Label_0031:
        while (i <= nextInt) {
            final int n = i;
            while (true) {
                for (int j = 1; j <= 10; ++j) {
                    if (n == Math.pow(2.0, j)) {
                        final boolean b = true;
                        if (b) {
                            x = i;
                        }
                        ++i;
                        continue Label_0031;
                    }
                }
                final boolean b = false;
                continue;
            }
        }
        System.out.println(x);
    }
    
    private static boolean isRoot2(final int n) {
        for (int i = 1; i <= 10; ++i) {
            if (n == Math.pow(2.0, i)) {
                return true;
            }
        }
        return false;
    }
}
