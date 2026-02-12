import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int i = 1;
        if (nextInt == 1) {
            System.out.println("1");
            return;
        }
        while (i <= nextInt) {
            i <<= 1;
        }
        System.out.println(i / 2);
    }
}
