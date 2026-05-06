import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        final int[] array2 = { 1, 2, 4, 8, 16, 32, 64 };
        int i = 0;
        for (int j = 0; j < 7; ++j) {
            if (nextInt >= array2[j]) {
                i = array2[j];
            }
        }
        System.out.print(i);
    }
}
