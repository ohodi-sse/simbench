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
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int j = -100;
        int n = 0;
        while (j == -100) {
            if (!list.contains(nextInt - n)) {
                j = nextInt - n;
            }
            else if (!list.contains(nextInt + n)) {
                j = nextInt + n;
            }
            ++n;
        }
        System.out.print(j);
    }
}
