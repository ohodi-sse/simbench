import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        scanner.close();
        final int[] array2 = new int[7];
        array2[0] = 1;
        for (int i = 1; i < 7; ++i) {
            array2[i] = array2[i - 1] * 2;
        }
        for (int j = 0; j < 7; ++j) {
            if (nextInt == array2[j]) {
                System.out.println(nextInt);
                System.exit(0);
            }
            else if (nextInt < array2[j]) {
                System.out.println(array2[j - 1]);
                System.exit(0);
            }
        }
        System.out.println(array2[6]);
    }
}