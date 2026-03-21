import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final boolean[] array2 = new boolean[102];
        for (int i = 0; i < nextInt2; ++i) {
            array2[scanner.nextInt()] = true;
        }
        for (int j = 0; j < 51; ++j) {
            if (!array2[nextInt - j]) {
                System.out.println(nextInt - j);
                break;
            }
            if (!array2[nextInt + j]) {
                System.out.println(nextInt + j);
                break;
            }
        }
    }
}