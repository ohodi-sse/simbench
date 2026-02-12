import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList list = new ArrayList();
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int n = 0;
        int n2 = 1;
        for (int j = 0; j < 100; ++j) {
            for (int k = 0; k < nextInt2; ++k) {
                if ((int)list.get(k) == nextInt - n) {
                    n2 = 0;
                }
            }
            if (n2 == 1) {
                System.out.println(nextInt - n);
                return;
            }
            int n3 = 1;
            for (int l = 0; l < nextInt2; ++l) {
                if ((int)list.get(l) == nextInt + n) {
                    n3 = 0;
                }
            }
            if (n3 == 1) {
                System.out.println(nextInt + n);
                return;
            }
            ++n;
            n2 = 1;
        }
    }
}
