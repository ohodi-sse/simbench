import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String[] split = scanner.nextLine().split(" ");
        final String[] split2 = scanner.nextLine().split(" ");
        final int int1 = Integer.parseInt(split[0]);
        final int int2 = Integer.parseInt(split[1]);
        final int n = int1;
        final int[] array2 = new int[102];
        for (int i = 0; i < 102; ++i) {
            array2[i] = i;
        }
        for (int j = 0; j < int2; ++j) {
            array2[Integer.parseInt(split2[j])] = -1;
        }
        int n2 = -1;
        int n3 = -1;
        for (int k = 0; k < 102; ++k) {
            if (k < n) {
                if (array2[k] != -1) {
                    n2 = k;
                }
            }
            else if (array2[k] != -1) {
                n3 = k;
                break;
            }
        }
        int x;
        if (n2 != -1 && n3 != -1) {
            if (int1 - array2[n2] <= array2[n3] - int1) {
                x = array2[n2];
            }
            else {
                x = array2[n3];
            }
        }
        else if (n2 != -1 && n3 == -1) {
            x = array2[n2];
        }
        else {
            x = array2[n3];
        }
        System.out.println(x);
    }
}
