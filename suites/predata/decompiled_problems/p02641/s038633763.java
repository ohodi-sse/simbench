import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final ArrayList list = new ArrayList();
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        if (list.isEmpty() || !list.contains(nextInt)) {
            System.out.println(nextInt);
            return;
        }
        for (int j = 1; j <= 100; ++j) {
            if (!list.contains(nextInt - j)) {
                System.out.println(nextInt - j);
                break;
            }
            if (!list.contains(nextInt + j)) {
                System.out.println(nextInt + j);
                break;
            }
        }
        scanner.close();
    }
}
