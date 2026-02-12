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
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        int x = nextInt;
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        for (int j = 0; j <= nextInt2; ++j) {
            if (!list.contains(nextInt - j)) {
                x = nextInt - j;
                break;
            }
            if (!list.contains(nextInt + j)) {
                x = nextInt + j;
                break;
            }
        }
        if (nextInt2 > 100) {
            System.out.println("error");
        }
        System.out.println(x);
        scanner.close();
    }
}
