import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final int nextInt = new Scanner(System.in).nextInt();
        int max = 0;
        for (int i = 1; i <= nextInt; i <<= 1) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}
