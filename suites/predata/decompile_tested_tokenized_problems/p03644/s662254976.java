import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        int i = new Scanner(System.in).nextInt();
        for (int n = 2; i >= n; i = n, n *= 2) {}
        System.out.println(i);
    }
}
