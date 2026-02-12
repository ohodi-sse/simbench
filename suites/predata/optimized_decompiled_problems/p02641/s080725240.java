import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        final int[] array = new int[nextInt2 = scanner.nextInt()];
        for (int i = 0; i < nextInt2; ++i) {
            array[i] = scanner.nextInt();
        }
        int n;
        int n2;
        int x;
        for (n = nextInt + 1, n2 = nextInt - 1, x = judge(nextInt2, array, nextInt); x == -1 && (x = judge(nextInt2, array, n2)) == -1; x = judge(nextInt2, array, n), ++n, --n2) {}
        System.out.println(x);
    }
    
    private static int judge(final int n, final int[] array, final int n2) {
        int n3 = 0;
        int n4 = -1;
        for (int i = 0; i < n; ++i) {
            if (n2 == array[i]) {
                ++n3;
                break;
            }
        }
        if (n3 == 0) {
            n4 = n2;
        }
        return n4;
    }
}
