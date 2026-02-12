import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        int i;
        int x;
        for (i = new Scanner(System.in).nextInt(), x = 1; i != 1; i /= 2, x <<= 1) {}
        System.out.println(x);
    }
}
