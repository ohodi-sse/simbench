import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int i = 2;
        int x = 0;
        if (nextInt == 1) {
            System.out.println(1);
            return;
        }
        while (i <= nextInt) {
            x = i;
            i <<= 1;
        }
        System.out.println(x);
    }
}
