import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int int1 = Integer.parseInt(scanner.next());
        final int int2 = Integer.parseInt(scanner.next());
        final int[] array2 = new int[int2];
        int n = 1;
        if (int2 == 0) {
            System.out.println(int1);
            return;
        }
        for (int i = 0; i < int2; ++i) {
            array2[i] = Integer.parseInt(scanner.next());
        }
        for (int j = 0; j <= int1; ++j) {
            final int x = int1 - j;
            for (int k = 0; k < int2; ++k) {
                if (array2[k] == x) {
                    n = 0;
                }
            }
            if (n != 0) {
                System.out.println(x);
                return;
            }
            boolean b = true;
            final int x2 = int1 + j;
            for (int l = 0; l < int2; ++l) {
                if (array2[l] == x2) {
                    b = false;
                }
            }
            if (b) {
                System.out.println(x2);
                return;
            }
            n = 1;
        }
    }
}
