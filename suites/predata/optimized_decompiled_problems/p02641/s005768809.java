import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList list = new ArrayList();
        int i = 0;
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        final String[] split;
        final int int1 = Integer.parseInt((split = list.get(0).split(" ", 0))[0]);
        final int int2;
        final int[] a = new int[int2 = Integer.parseInt(split[1])];
        Label_0240: {
            if (int2 != 0) {
                final String[] split2 = list.get(1).split(" ", 0);
                while (i < int2) {
                    a[i] = Integer.parseInt(split2[i]);
                    ++i;
                }
                Arrays.sort(a);
                final int[] array = a;
                final int n = int1;
                final int[] array2 = array;
                final ArrayList list2 = new ArrayList(array2.length);
                for (int j = 0; j < array2.length; ++j) {
                    list2.add((Object)array2[j]);
                }
                int n2 = n;
                int n3 = n;
                while (list2.contains(n2)) {
                    --n2;
                    if (!list2.contains(n3)) {
                        System.out.println(n3);
                        break Label_0240;
                    }
                    ++n3;
                }
                System.out.println(n2);
            }
            else {
                System.out.println(int1);
            }
        }
        scanner.close();
    }
    
    private static void check$1c96c31d(final int[] array, final int n) {
        final ArrayList list = new ArrayList(array.length);
        for (int i = 0; i < array.length; ++i) {
            list.add(array[i]);
        }
        int n2 = n;
        int n3 = n;
        while (list.contains(n2)) {
            --n2;
            if (!list.contains(n3)) {
                System.out.println(n3);
                return;
            }
            ++n3;
        }
        System.out.println(n2);
    }
}
