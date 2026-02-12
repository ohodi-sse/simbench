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
        final boolean[] array = new boolean[101];
        for (int i = 0; i < nextInt2; ++i) {
            array[scanner.nextInt()] = true;
        }
        for (int j = 0; j < nextInt2 + 1; ++j) {
            if (!array[nextInt - j]) {
                System.out.println(nextInt - j);
                return;
            }
            if (nextInt + j == 101) {
                System.out.println(101);
                return;
            }
            if (!array[nextInt + j]) {
                System.out.println(nextInt + j);
                return;
            }
        }
    }
}
