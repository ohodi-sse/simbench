import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String[] split = (scanner = new Scanner(System.in)).nextLine().split(" ");
        final String[] split2 = scanner.nextLine().split(" ");
        final int int1 = Integer.parseInt(split[0]);
        final int int2 = Integer.parseInt(split[1]);
        final int n = int1;
        final int[] array = new int[102];
        for (int i = 0; i < 102; ++i) {
            final int[] array2 = array;
            final int n2 = i;
            array2[n2] = n2;
        }
        for (int j = 0; j < int2; ++j) {
            array[Integer.parseInt(split2[j])] = -1;
        }
        int n3 = -1;
        int n4 = -1;
        for (int k = 0; k < 102; ++k) {
            if (k < n) {
                if (array[k] != -1) {
                    n3 = k;
                }
            }
            else if (array[k] != -1) {
                n4 = k;
                break;
            }
        }
        int x;
        if (n3 != -1 && n4 != -1) {
            if (int1 - array[n3] <= array[n4] - int1) {
                x = array[n3];
            }
            else {
                x = array[n4];
            }
        }
        else if (n3 != -1 && n4 == -1) {
            x = array[n3];
        }
        else {
            x = array[n4];
        }
        System.out.println(x);
    }
}
