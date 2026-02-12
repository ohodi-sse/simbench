import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 1;
        for (int i = 1; i <= nextInt; i <<= 1) {
            x = i;
        }
        System.out.println(x);
    }
}
