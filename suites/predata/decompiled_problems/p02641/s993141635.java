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
        final int[] array2 = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            final int[] array3 = array2;
            final int nextInt3 = scanner.nextInt();
            ++array3[nextInt3];
        }
        if (array2[nextInt] == 0) {
            System.out.println(nextInt);
            return;
        }
        int x = 0;
        for (int j = nextInt + 1; j <= 101; ++j) {
            if (array2[j] == 0) {
                x = j;
                break;
            }
        }
        int x2 = 0;
        for (int k = nextInt - 1; k >= 0; --k) {
            if (array2[k] == 0) {
                x2 = k;
                break;
            }
        }
        if (x - nextInt >= nextInt - x2) {
            System.out.println(x2);
        }
        else {
            System.out.println(x);
        }
    }
}
