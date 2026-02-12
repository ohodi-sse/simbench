import java.util.Arrays;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final Integer n = new Integer(Integer.parseInt(scanner.next()));
        final int int1;
        if ((int1 = Integer.parseInt(scanner.next())) == 0) {
            System.out.println(n);
            return;
        }
        final Integer[] a = new Integer[int1];
        for (int i = 0; i < int1; ++i) {
            a[i] = new Integer(Integer.parseInt(scanner.next()));
        }
        if (!Arrays.asList(a).contains(n)) {
            System.out.println(n);
            return;
        }
        Arrays.sort(a);
        Arrays.asList(a).indexOf(n);
        int intValue = n;
        int n2 = 0;
        do {
            final int n3 = intValue;
            final Integer[] array = a;
            if (n3 > array[array.length - 1]) {
                break;
            }
            ++n2;
            intValue = n - n2;
        } while (Arrays.asList(a).contains(intValue));
        int intValue2 = n;
        int n4 = 0;
        while (a[0] <= intValue2) {
            ++n4;
            intValue2 = n + n4;
            if (!Arrays.asList(a).contains(intValue2)) {
                break;
            }
        }
        if (n2 <= n4) {
            System.out.println(n - n2);
            return;
        }
        System.out.println(n + n4);
    }
}
