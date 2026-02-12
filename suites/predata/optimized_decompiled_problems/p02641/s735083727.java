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
        int x = 0;
        int x2 = 0;
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        while (n2 == 0 && n3 == 0) {
            if (!list.contains(nextInt + n)) {
                n2 = 1;
                x = nextInt + n;
            }
            if (!list.contains(nextInt - n)) {
                n3 = 1;
                x2 = nextInt - n;
            }
            ++n;
        }
        if (n3 != 0) {
            System.out.println(x2);
            return;
        }
        System.out.println(x);
    }
}
