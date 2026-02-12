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
        scanner.nextLine();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int x = 0;
        int abs = nextInt;
        for (int j = 0; j <= 101; ++j) {
            if (!list.contains(j) && abs > Math.abs(nextInt - j)) {
                x = j;
                abs = Math.abs(nextInt - j);
            }
        }
        System.out.println(x);
    }
}
