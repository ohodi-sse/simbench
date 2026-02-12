import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int i = 2;
        int x = 2;
        if (nextInt == 1) {
            x = 1;
        }
        while (i < nextInt) {
            if ((i <<= 1) <= nextInt) {
                x = i;
            }
        }
        System.out.println(x);
    }
}
