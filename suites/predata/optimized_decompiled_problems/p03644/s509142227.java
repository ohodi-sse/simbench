import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        int nextInt;
        int x;
        for (nextInt = new Scanner(System.in).nextInt(), x = 1; nextInt / 2 >= x; x <<= 1) {}
        System.out.println(x);
    }
}
