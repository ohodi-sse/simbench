import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        if (nextInt2 != 0) {
            for (int i = 0; i < nextInt2; ++i) {
                list.add(scanner.nextInt());
            }
            scanner.close();
            int n = 0;
            int l;
            while (true) {
                final int j = nextInt - n;
                final int k = nextInt + n;
                if (!list.contains(j)) {
                    l = j;
                    break;
                }
                if (!list.contains(k)) {
                    l = k;
                    break;
                }
                ++n;
            }
            System.out.print(l);
            return;
        }
        System.out.println(nextInt);
    }
}
