import java.util.HashSet;
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
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        final HashSet set = new HashSet();
        for (int i = 0; i < nextInt2; ++i) {
            set.add(scanner.nextInt());
        }
        scanner.close();
        Integer value = null;
        Integer value2 = null;
        int n = nextInt;
        while (value == null) {
            if (!set.contains(n)) {
                value = n;
            }
            --n;
        }
        int n2 = nextInt;
        while (value2 == null) {
            if (!set.contains(n2)) {
                value2 = n2;
            }
            ++n2;
        }
        final int abs = Math.abs(nextInt - value);
        final int abs2 = Math.abs(nextInt - value2);
        if (abs == abs2) {
            System.out.println(value);
            return;
        }
        if (abs < abs2) {
            System.out.println(value);
        }
        else {
            System.out.println(value2);
        }
    }
}
