import java.util.ArrayList;
import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        final int nextInt2 = scanner.nextInt();
        final int[] array2 = new int[nextInt2];
        final ArrayList list = new ArrayList();
        if (nextInt2 == 0) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int i = 0; i < nextInt2; ++i) {
            array2[i] = scanner.nextInt();
            list.add(array2[i]);
        }
        if (!list.contains(nextInt)) {
            System.out.println(nextInt);
            System.exit(0);
        }
        for (int j = 0; j <= nextInt2; ++j) {
            if (!list.contains(nextInt + j) || !list.contains(nextInt - j)) {
                if (!list.contains(nextInt - j)) {
                    System.out.println(nextInt - j);
                    break;
                }
                if (!list.contains(nextInt + j)) {
                    System.out.println(nextInt + j);
                    break;
                }
            }
        }
    }
}