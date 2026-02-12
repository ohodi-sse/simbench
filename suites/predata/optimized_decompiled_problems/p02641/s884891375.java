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
        final int nextInt2 = scanner.nextInt();
        int n = 1001;
        int x = -100;
        final String[] a = new String[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            a[i] = scanner.next();
        }
        for (int j = 0; j <= 101; ++j) {
            if (!Arrays.asList(a).contains(String.valueOf(j))) {
                int n2;
                if (nextInt >= j) {
                    n2 = nextInt - j;
                }
                else {
                    n2 = j - nextInt;
                }
                if (n > n2) {
                    x = j;
                    n = n2;
                }
            }
        }
        System.out.println(x);
    }
}
