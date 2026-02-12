import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        for (int nextInt = new Scanner(System.in).nextInt(), i = 0; i < nextInt; ++i) {
            if (nextInt == Math.pow(2.0, i)) {
                System.out.println((int)Math.pow(2.0, i));
                return;
            }
            if (nextInt < Math.pow(2.0, i)) {
                System.out.println((int)Math.pow(2.0, i - 1));
                return;
            }
        }
    }
}
