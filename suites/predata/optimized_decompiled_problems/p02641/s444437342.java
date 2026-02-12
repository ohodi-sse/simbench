import java.util.LinkedList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final LinkedList list = new LinkedList();
        final int nextInt = scanner.nextInt();
        for (int nextInt2 = scanner.nextInt(), i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        int n;
        for (n = 0; list.contains(nextInt - n); ++n) {
            if (!list.contains(nextInt + n)) {
                System.out.println(nextInt + n);
                return;
            }
        }
        System.out.println(nextInt - n);
    }
}
