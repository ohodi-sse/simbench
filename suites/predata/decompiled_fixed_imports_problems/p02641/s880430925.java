import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        boolean b = false;
        int i = nextInt + 100;
        for (int j = 0; j < nextInt2; ++j) {
            array2[j] = scanner.nextInt();
            if (nextInt == array2[j]) {
                b = true;
            }
        }
        if (!b) {
            System.out.print(nextInt);
        }
        else {
            for (int k = 1; k <= 200 - nextInt; ++k) {
                final int n = nextInt - k;
                final int n2 = nextInt + k;
                if (n <= i || n2 <= i) {
                    int n3 = 0;
                    int n4 = 0;
                    for (int l = 0; l < nextInt2; ++l) {
                        if (array2[l] != n) {
                            ++n3;
                        }
                        if (array2[l] != n2) {
                            ++n4;
                        }
                    }
                    if (n3 == nextInt2) {
                        i = n;
                        break;
                    }
                    if (n4 == nextInt2) {
                        i = n2;
                        break;
                    }
                }
            }
            System.out.print(i);
        }
    }
}