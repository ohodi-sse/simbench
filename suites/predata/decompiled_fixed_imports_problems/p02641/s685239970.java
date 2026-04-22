import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[102];
        int i = 0;
        for (int j = 0; j < nextInt2; ++j) {
            array2[scanner.nextInt()] = 1;
        }
        for (int k = 0; k < 102; ++k) {
            if (nextInt - k >= 0 && array2[nextInt - k] == 0) {
                i = nextInt - k;
                break;
            }
            if (nextInt + k < 102 && array2[nextInt + k] == 0) {
                i = nextInt + k;
                break;
            }
        }
        System.out.print(i);
        scanner.close();
    }
}