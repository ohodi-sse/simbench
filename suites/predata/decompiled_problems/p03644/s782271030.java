import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int i = 2;
        int x = 2;
        if (nextInt == 1) {
            x = 1;
        }
        while (i < nextInt) {
            i *= 2;
            if (i <= nextInt) {
                x = i;
            }
        }
        System.out.println(x);
    }
}
