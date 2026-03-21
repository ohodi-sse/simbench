import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            return;
        }
        final int[] array2 = new int[101];
        for (int i = 0; i < nextInt2; ++i) {
            array2[scanner.nextInt()] = 1;
        }
        for (int j = 0; j < 101; ++j) {
            if (nextInt - j >= 0 && 0 == array2[nextInt - j]) {
                System.out.println(nextInt - j);
                return;
            }
            if (nextInt + j >= 101) {
                System.out.println(101);
                return;
            }
            if (0 == array2[nextInt + j]) {
                System.out.println(nextInt + j);
                return;
            }
        }
    }
}