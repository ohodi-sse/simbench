import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        final int n = nextInt;
        int n2 = 0;
        int x;
        while (true) {
            final int n3 = n - n2;
            boolean b = false;
            for (int j = 0; j < nextInt2; ++j) {
                if (n3 == array2[j]) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                x = n3;
                break;
            }
            final int n4 = n + n2;
            boolean b2 = false;
            for (int k = 0; k < nextInt2; ++k) {
                if (n4 == array2[k]) {
                    b2 = true;
                    break;
                }
            }
            if (!b2) {
                x = n4;
                break;
            }
            ++n2;
        }
        System.out.println(x);
    }
}
