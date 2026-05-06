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
        final boolean[] array2 = new boolean[101];
        for (int i = 0; i < nextInt2; ++i) {
            array2[scanner.nextInt()] = true;
        }
        for (int j = 0; j < nextInt2 + 1; ++j) {
            if (!array2[nextInt - j]) {
                System.out.println(nextInt - j);
                return;
            }
            if (nextInt + j == 101) {
                System.out.println(101);
                return;
            }
            if (!array2[nextInt + j]) {
                System.out.println(nextInt + j);
                return;
            }
        }
    }
}
