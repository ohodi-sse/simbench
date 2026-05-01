import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            array2[scanner.nextInt()] = 1;
        }
        if (array2[nextInt] == 0) {
            System.out.println(nextInt);
        }
        else {
            int n = nextInt - 1;
            int n2 = nextInt + 1;
            int x = Integer.MAX_VALUE;
            while (n >= 0 && n2 < array2.length) {
                if (array2[n] == 0) {
                    x = n;
                    break;
                }
                --n;
                if (array2[n2] == 0) {
                    x = n2;
                    break;
                }
                ++n2;
            }
            while (n < 0 && n2 < array2.length) {
                if (array2[n2] == 0) {
                    x = n2;
                    break;
                }
                ++n2;
            }
            while (n2 >= array2.length && n >= 0) {
                if (array2[n] == 0) {
                    x = n;
                    break;
                }
                --n;
            }
            System.out.println(x);
        }
    }
}