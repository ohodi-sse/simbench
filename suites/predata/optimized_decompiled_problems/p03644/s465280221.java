import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        int i;
        int n;
        for (i = new Scanner(System.in).nextInt(), n = 0; i != 1; i >>= 1, ++n) {}
        System.out.println(i << n);
    }
}
