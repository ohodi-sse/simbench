import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[1000];
        for (int i = 0; i < nextInt2; ++i) {
            array2[scanner.nextInt()] = 1;
        }
        int x = 0;
        for (int j = 0; j < 101; ++j) {
            if (array2[nextInt - j] != 1) {
                x = nextInt - j;
                break;
            }
            if (array2[nextInt + j] != 1) {
                x = nextInt + j;
                break;
            }
        }
        System.out.println(x);
    }
}