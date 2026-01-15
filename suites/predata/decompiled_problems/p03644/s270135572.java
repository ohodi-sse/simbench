import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        final int[] array2 = { 1, 2, 4, 8, 16, 32, 64 };
        int x = 0;
        for (int i = 0; i < array2.length; ++i) {
            if (array2[i] <= nextInt) {
                x = array2[i];
            }
        }
        System.out.println(x);
    }
}
