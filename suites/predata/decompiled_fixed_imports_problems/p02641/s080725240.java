import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        int n;
        int n2;
        int j;
        for (n = nextInt + 1, n2 = nextInt - 1, j = judge(nextInt2, array2, nextInt); j == -1; j = judge(nextInt2, array2, n), ++n, --n2) {
            j = judge(nextInt2, array2, n2);
            if (j != -1) {
                break;
            }
        }
        System.out.println(j);
    }
    
    public static int judge(final int n, final int[] array, final int n2) {
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