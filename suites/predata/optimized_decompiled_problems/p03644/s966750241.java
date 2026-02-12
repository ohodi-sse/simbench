import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        scanner.close();
        final int[] array;
        (array = new int[7])[0] = 1;
        for (int i = 1; i < 7; ++i) {
            array[i] = array[i - 1] << 1;
        }
        for (int j = 0; j < 7; ++j) {
            if (nextInt == array[j]) {
                System.out.println(nextInt);
                System.exit(0);
            }
            else if (nextInt < array[j]) {
                System.out.println(array[j - 1]);
                System.exit(0);
            }
        }
        System.out.println(array[6]);
    }
}
