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
        final String[] array = new String[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.next();
        }
        for (int j = 0; j <= 51; ++j) {
            final int k = nextInt - j;
            final int l = nextInt + j;
            final String value = String.valueOf(k);
            final String value2 = String.valueOf(l);
            if (!Arrays.asList(array).contains(value)) {
                System.out.println(nextInt - j);
                return;
            }
            if (!Arrays.asList(array).contains(value2)) {
                System.out.println(nextInt + j);
                return;
            }
        }
        scanner.close();
    }
}
