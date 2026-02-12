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
        final int[] array = new int[1000];
        for (int i = 0; i < nextInt2; ++i) {
            array[scanner.nextInt()] = 1;
        }
        int x = 0;
        for (int j = 0; j < 101; ++j) {
            if (array[nextInt - j] != 1) {
                x = nextInt - j;
                break;
            }
            if (array[nextInt + j] != 1) {
                x = nextInt + j;
                break;
            }
        }
        System.out.println(x);
    }
}
