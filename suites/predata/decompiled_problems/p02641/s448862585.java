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
        if (nextInt == 0) {
            System.out.println(nextInt);
            return;
        }
        int abs = Integer.MAX_VALUE;
        int a = 0;
        for (int j = -101; j <= 101; ++j) {
            if (!list.contains(j) && abs > Math.abs(j - nextInt)) {
                abs = Math.abs(j - nextInt);
                a = j;
            }
        }
        int b = 0;
        int abs2 = Integer.MAX_VALUE;
        for (int k = 101; k >= -101; --k) {
            if (!list.contains(k) && abs2 > Math.abs(k - nextInt)) {
                abs2 = Math.abs(k - nextInt);
                b = k;
            }
        }
        System.out.println(Math.min(a, b));
    }
}
