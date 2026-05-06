import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 1;
        for (int i = 1; i <= nextInt; i *= 2) {
            x = i;
        }
        System.out.println(x);
    }
}
