import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        int nextInt;
        int n;
        for (nextInt = new Scanner(System.in).nextInt(), n = 0; Math.pow(2.0, n) <= nextInt; ++n) {}
        System.out.println((int)Math.pow(2.0, n - 1));
    }
}
