import java.util.HashSet;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String... array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final HashSet set = new HashSet();
        final int[] array2 = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        int j = nextInt;
        int k = nextInt;
        while (set.contains(j)) {
            --j;
        }
        while (set.contains(k)) {
            ++k;
        }
        System.out.println((nextInt - j <= k - nextInt) ? j : k);
    }
}
