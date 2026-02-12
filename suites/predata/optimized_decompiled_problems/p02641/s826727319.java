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
        final boolean[] array = new boolean[105];
        for (int i = 0; i < nextInt2; ++i) {
            array[scanner.nextInt()] = true;
        }
        int x = nextInt;
        for (int x2 = nextInt; array[x]; --x, ++x2) {
            if (!array[x2]) {
                System.out.println(x2);
                return;
            }
        }
        System.out.println(x);
    }
}
