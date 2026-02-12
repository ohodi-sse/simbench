import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final int[] array = new int[9];
        final int nextInt = scanner.nextInt();
        int n = 1;
        for (int i = 0; i < array.length; ++i) {
            array[i] = n;
            n <<= 1;
        }
        final int length = array.length;
        for (int j = 8; j >= 0; --j) {
            if (array[j] <= nextInt) {
                System.out.println(array[j]);
                return;
            }
        }
    }
}
