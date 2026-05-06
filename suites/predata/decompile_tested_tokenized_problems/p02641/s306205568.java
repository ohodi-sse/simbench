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
        int i = 0;
        int abs = 101;
        for (int j = 0; j < nextInt2; ++j) {
            list.add(scanner.nextInt());
        }
        for (int k = -1; k <= 200; ++k) {
            if (!list.contains(k) && Math.abs(k - nextInt) < abs) {
                i = k;
                abs = Math.abs(k - nextInt);
            }
        }
        System.out.print(i);
    }
}
