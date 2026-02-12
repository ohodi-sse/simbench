import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final int int1 = Integer.parseInt(new Scanner(System.in).next());
        int x = 0;
        for (int n = 0; n < int1 && int1 >= (int)Math.round(Math.pow(2.0, n)); ++n) {
            x = (int)Math.round(Math.pow(2.0, n));
        }
        System.out.println(x);
    }
}
