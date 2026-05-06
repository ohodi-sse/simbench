import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        if (nextInt == 1) {
            System.out.println(1);
        }
        else {
            int x = 0;
            for (int i = 2; i <= nextInt; i *= 2) {
                x = i;
            }
            System.out.println(x);
        }
    }
}
