import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int int1 = Integer.parseInt(scanner.next());
        final int[] array2 = { 64, 32, 16, 8, 4, 2, 1 };
        for (int i = 0; i < 7; ++i) {
            if (int1 >= array2[i]) {
                System.out.println(array2[i]);
                break;
            }
        }
        scanner.close();
    }
}