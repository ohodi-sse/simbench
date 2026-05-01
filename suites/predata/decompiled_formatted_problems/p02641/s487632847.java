import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        int x = nextInt;
        int x2 = nextInt;
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        for (int j = 0; j < nextInt2; ++j) {
            if (x == array2[j]) {
                ++x;
                j = -1;
            }
        }
        for (int k = 0; k < nextInt2; ++k) {
            if (x2 == array2[k] && x2 > 0) {
                --x2;
                k = -1;
            }
        }
        if (Math.abs(x - nextInt) >= Math.abs(x2 - nextInt)) {
            System.out.println(x2);
        }
        else {
            System.out.println(x);
        }
    }
}