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
        int x = nextInt;
        int x2 = nextInt;
        int n = nextInt;
        while (true) {
            for (int j = 0; j < nextInt2; ++j) {
                if (n == array2[j]) {
                    x = 200;
                    break;
                }
                x = n;
            }
            if (x == n) {
                break;
            }
            --n;
        }
        int n2 = nextInt;
        while (true) {
            for (int k = 0; k < nextInt2; ++k) {
                if (n2 == array2[k]) {
                    x2 = 200;
                    break;
                }
                x2 = n2;
            }
            if (x2 == n2) {
                break;
            }
            ++n2;
        }
        if (nextInt - x > x2 - nextInt) {
            System.out.println(x2);
        }
        else {
            System.out.println(x);
        }
    }
}
