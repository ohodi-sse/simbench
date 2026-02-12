import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        int i;
        int n;
        int[] array;
        for (i = new Scanner(System.in).nextInt(), n = 0, array = new int[] { 1, 2, 4, 8, 16, 32, 64, 125 }; i >= array[n + 1]; ++n) {}
        System.out.println(array[n]);
    }
}
