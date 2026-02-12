import java.util.Arrays;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final Integer[] array = new Integer[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        for (int j = 0; j < 1000; ++j) {
            if (!Arrays.asList(array).contains(nextInt - j)) {
                System.out.println(nextInt - j);
                return;
            }
            if (!Arrays.asList(array).contains(nextInt + j)) {
                System.out.println(nextInt + j);
                return;
            }
        }
    }
}
