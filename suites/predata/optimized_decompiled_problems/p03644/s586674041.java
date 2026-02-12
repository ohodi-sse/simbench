import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        for (int i = new Scanner(System.in).nextInt(); i > 0; --i) {
            final int n = i;
            if ((n & n - 1) == 0x0) {
                System.out.println(i);
                return;
            }
        }
    }
}
