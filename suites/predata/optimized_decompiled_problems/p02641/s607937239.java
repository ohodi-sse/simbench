import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int j = 0;
        int abs = 150;
        for (int k = -100; k <= 200; ++k) {
            if (!list.contains(k) && Math.abs(k - nextInt) < abs) {
                j = k;
                abs = Math.abs(k - nextInt);
            }
        }
        System.out.print(j);
    }
}
