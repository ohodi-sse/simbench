import java.util.Arrays;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        final Integer[] array2 = new Integer[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        for (int j = 0; j < 51; ++j) {
            if (!Arrays.asList(array2).contains(nextInt - j)) {
                System.out.println(nextInt - j);
                return;
            }
            if (!Arrays.asList(array2).contains(nextInt + j)) {
                System.out.println(nextInt + j);
                return;
            }
        }
    }
}
