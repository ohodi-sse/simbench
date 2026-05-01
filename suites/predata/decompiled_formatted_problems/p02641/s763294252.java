import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        int n = 0;
        final Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
        }
        scanner.close();
        for (int j = 0; j < nextInt2; ++j) {
            if (nextInt == array2[j]) {
                int n2 = ++n;
                for (int k = 0; k < n; ++k) {
                    n2 *= -1;
                }
                nextInt += n2;
                j = -1;
            }
        }
        System.out.println(nextInt);
    }
}