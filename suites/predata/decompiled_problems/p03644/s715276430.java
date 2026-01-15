import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        int i;
        int x;
        for (i = new Scanner(System.in).nextInt(), x = 1; i != 1; i /= 2, x *= 2) {}
        System.out.println(x);
    }
}
