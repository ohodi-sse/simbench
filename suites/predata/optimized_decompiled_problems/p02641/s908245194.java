import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        if ((nextInt2 = scanner.nextInt()) == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        for (int j = 0; j <= 100; ++j) {
            final int n = nextInt - j;
            final int n2 = nextInt + j;
            if (!list.contains(n)) {
                System.out.println(n);
                break;
            }
            if (!list.contains(n2)) {
                System.out.println(n2);
                break;
            }
        }
        scanner.close();
    }
}
