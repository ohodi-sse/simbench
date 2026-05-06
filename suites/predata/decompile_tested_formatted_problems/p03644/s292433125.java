import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final int int1 = Integer.parseInt(new Scanner(System.in).next());
        int x = 0;
        final int[] array2 = { 1, 2, 4, 8, 16, 32, 64 };
        for (int i = 0; i < 7; ++i) {
            if (array2[i] <= int1) {
                x = array2[i];
            }
        }
        System.out.println(x);
    }
}
