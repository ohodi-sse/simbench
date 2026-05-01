import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        final int[] array3 = new int[102];
        for (int i = 0; i < nextInt2; ++i) {
            array3[array2[i] = scanner.nextInt()] = 1;
        }
        int abs = 1000;
        int x = nextInt;
        for (int j = 0; j <= 101; ++j) {
            if (array3[j] == 0 && Math.abs(nextInt - j) < abs) {
                x = j;
                abs = Math.abs(nextInt - j);
            }
        }
        System.out.println(x);
    }
}