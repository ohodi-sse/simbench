import java.util.Iterator;
import java.util.TreeSet;
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
        final TreeSet set = new TreeSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        final int[] array = new int[102];
        final Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            array[iterator.next()] = 1;
        }
        int n = Integer.MAX_VALUE;
        int x = 0;
        for (int j = 0; j < array.length; ++j) {
            if (array[j] == 0 && n > Math.abs(nextInt - j)) {
                n = nextInt - j;
                x = j;
            }
        }
        System.out.println(x);
    }
}
